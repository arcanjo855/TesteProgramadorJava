package com.example.ordenarnumeros;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button botaoBaixar,botaoOrdenar;
    EditText numeros;
    TextView listaNumero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        numeros = findViewById(R.id.text_numeros);
        botaoOrdenar = findViewById(R.id.btn_ordenar);
        listaNumero = findViewById(R.id.tv_numeros);





        botaoOrdenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String input = numeros.getText().toString().trim();

                if(!input.isEmpty()){
                    String[] numbers = input.split(",");
                    int[] Intnumbers = new int[numbers.length];

                    for(int i = 0;i < numbers.length;i++){
                        Intnumbers[i] = Integer.parseInt(numbers[i]);
                    }

                    Arrays.sort(Intnumbers);
                    String sortedNumbers = Arrays.toString(Intnumbers);
                    listaNumero.setText(sortedNumbers);

                }

            }
        });


    }


}