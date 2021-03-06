package com.learningandroid.lukas.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText caixaTexto;
    private Button botaoIdade;
    private TextView resultadoIdade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        caixaTexto = (EditText) findViewById(R.id.caixaTextoID);
        botaoIdade = (Button) findViewById(R.id.buttonDescobrirIdadeID);
        resultadoIdade = (TextView) findViewById(R.id.textDescobrirIdadeID);

        botaoIdade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = caixaTexto.getText().toString();

                if(textoDigitado.isEmpty()) {
                    resultadoIdade.setText("Digite um numero!!");
                }else{
                    int valorDigitado = Integer.parseInt(textoDigitado);
                    resultadoIdade.setText( "A idade do dog em anos humanos eh: " + (valorDigitado * 7) + " anos.");
                }
            }
        });
    }
}
