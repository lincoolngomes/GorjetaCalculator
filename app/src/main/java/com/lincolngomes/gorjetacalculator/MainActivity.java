package com.lincolngomes.gorjetacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editarVR;
    private TextView editarPorcentagem;
    private TextView editarGorjeta;
    private TextView editarTotal;
    private SeekBar seekBar;

    private double porcentagem = 0;

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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}