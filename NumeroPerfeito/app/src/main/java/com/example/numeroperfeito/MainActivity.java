package com.example.numeroperfeito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    Button botaoVerificar;
    EditText textInput;
    TextView inputVerificado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoVerificar = findViewById(R.id.btn_verificar);
        textInput = findViewById(R.id.text_numero);
        inputVerificado = findViewById(R.id.tv_verificado);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int numeroInput = Integer.parseInt(textInput.getText().toString());



                    for (int i = 0;i < numeroInput; i++){
                        int aux = 0;

                        for(int j = 1; j < numeroInput; j++){
                            if(numeroInput % j == 0){
                                aux += j;
                            }
                        }
                        if(aux == numeroInput){
                            inputVerificado.setText("Numero perfeito");
                        }else{
                            inputVerificado.setText("Numero imperfeito");
                        }
                    }

                }catch (Exception e){
                    textInput.setError("Somente numeros!");
                    textInput.requestFocus();
                }
            }
        });
    }
}