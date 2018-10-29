package com.learningandroid.lukas.frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textNovaFrase;
    private Button buttonNovaFrase;

    private String[] frases = {"Eu vou te dizer o que eu acho das escolas, Jerry: É uma perda de tempo(...) Escola não é um lugar para pessoas inteligentes",
            "Wubba Lubba Dub Dub",
            "Existem prós e contras em (arrota) todas as linhas temporais alternativas. Um fato curioso sobre esta: ela tem gigantescas aranhas telepáticas, onze 'onze de setembro', e o melhor sorvete do multiverso!",
            "Bem, cientificamente, tradições são idiotas.",
            "Casamentos são basicamente funerais com bolo",
            "Morty: E quanto a realidade que deixamos para trás?",
            "Rick: E quanto a realidade em que Hitler curou o câncer, Morty? A resposta é: não pense sobre isso.",
            "Eu sei que essa situação pode ser intimidadora. Você olha ao redor e é tudo assustador e diferente, mas sabe… encará-las, avançar contra elas como um touro - é assim que crescemos como pessoas.",
            "Eu me transformei em um picles, Morty! Eu sou Picles Riiiick!"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNovaFrase = (TextView) findViewById(R.id.textNovaFraseID);
        buttonNovaFrase = (Button) findViewById(R.id.buttonNovaFraseID);

        //textNovaFrase.setText( frases[0] );

        buttonNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int randIndice = rand.nextInt( frases.length );
                textNovaFrase.setText( frases[randIndice] );
            }
        });
    }
}
