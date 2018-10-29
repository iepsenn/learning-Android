package com.learningandroid.lukas.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        precoAlcool = (EditText) findViewById(R.id.precoAlcoolID);
        precoGasolina = (EditText) findViewById(R.id.precoGasolinaID);
        botaoVerificar = (Button) findViewById(R.id.botaoVerificarID);
        resultado = (TextView) findViewById(R.id.resultadoID);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String precoalcool = precoAlcool.getText().toString();
                String precogasolina = precoGasolina.getText().toString();

                Double valoralcool = Double.parseDouble(precoalcool);
                Double valorgasolina = Double.parseDouble(precogasolina);
                Double result = valoralcool / valorgasolina;

                if(result >= 0.7) {
                    resultado.setText("Eh melhor utilizar gasolina.");
                }else{
                    resultado.setText("Eh melhor utilizar alcool.");
                }
            }
        });
    }
}
