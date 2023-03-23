package com.example.tabuada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    Button botaoTabuada;
    EditText textTabuada;
    TextView resultTabuada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTabuada = findViewById(R.id.btn_tabuada);
        textTabuada = findViewById(R.id.text_tabuada);
        resultTabuada = findViewById(R.id.tv_result_tabuada);

        botaoTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int taboada = Integer.parseInt(textTabuada.getText().toString());
                    String aux = "";
                    for (int cont = 1;cont <= 10;cont++){
                        aux = aux + taboada + " x " + cont + " = " + (taboada * cont) + "\n";
                    }
                    resultTabuada.setText(aux);
                } catch (Exception e){
                    textTabuada.setError("Somente numeros!");
                    textTabuada.requestFocus();
                }
            }
        });
    }
}