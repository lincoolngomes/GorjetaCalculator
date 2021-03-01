package com.lincolngomes.gorjetacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editarVR;
    private TextView editarPorcentagem;
    private TextView editarGorjeta;
    private TextView editarTotal;
    private SeekBar seekBar;

    private double porcentagem = 0;

    //Formatação decimais
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editarVR = findViewById(R.id.editarVR);
        editarPorcentagem = findViewById(R.id.editarPorcentagem);
        editarGorjeta = findViewById(R.id.editarGorjeta);
        editarTotal = findViewById(R.id.editarTotal);
        seekBar = findViewById(R.id.seekBar);




        //Adicionando listener SeekBar

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                editarPorcentagem.setText( Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void calcular(){

        //Transformar editarVR para String
        String valorRecuperado = editarVR.getText().toString();

        //Function - se editarVR == "" retorn Toast
        if( valorRecuperado == null || valorRecuperado.equals("")){

            Toast.makeText(getApplicationContext(),"Digite o valor da refeição!", Toast.LENGTH_SHORT).show();
        }else{

        //Start function quando Digitar o editarVR

            //Convertendo string para double
            double valorDigitado = Double.parseDouble( valorRecuperado );

            //Calcula a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = valorDigitado + gorjeta;

            //exibe a gorjeta e total
            editarGorjeta.setText("R$ " + df.format(gorjeta));

            editarTotal.setText("R$ " + df.format(total));


        }


    }


}