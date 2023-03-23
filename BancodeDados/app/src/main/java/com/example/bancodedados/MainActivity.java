package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;
import java.sql.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button botaoConsultar;
    EditText consulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Conectar com o banco de dados
                    String url = "jdbc:sqlserver://localhost:1433;databaseName=nome_do_banco";
                    String usuario = "nome_do_usuario";
                    String senha = "senha_do_usuario";
                    Connection conexao = DriverManager.getConnection(url, usuario, senha);

                    // Definir a consulta SQL
                    String sql = "SELECT DATEDIFF(YEAR, CONVERT(DATE, @nasc, 103), GETDATE()) AS idade";

                    // Preparar a declaração SQL
                    PreparedStatement declaracao = conexao.prepareStatement(sql);
                    declaracao.setString(1, "17/04/2008");

                    // Executar a consulta e obter o resultado
                    ResultSet resultado = declaracao.executeQuery();
                    resultado.next();
                    int idade = resultado.getInt("idade");

                    // Exibir o resultado
                    System.out.println("Idade: " + idade);

                    // Fechar a conexão
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
            }
            }
        });

    }
}