package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Conversor extends AppCompatActivity {

    protected static final int TIMER_RUNTIME = 10000;
    protected boolean nbActivo;
    protected ProgressBar nProgressBar;

    private EditText text;
    private EditText text1;
    private EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);
        nProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        final Thread timerThread = new Thread() {
            @Override
            public void run() {
                nbActivo = true;
                try {
                    int espera1 = 0;
                    while (nbActivo && (espera1 < TIMER_RUNTIME)) {
                        sleep(200);
                        if (nbActivo) {
                            espera1 += 200;
                            actualizarProgress(espera1);
                        }
                    }
                } catch (InterruptedException e) {
                } finally {
                    onContinuar();
                }
            }
        };
        timerThread.start();


    }

    public void actualizarProgress(final int timePassed) {
        if (null != nProgressBar) {
            final int progress = nProgressBar.getMax() * timePassed
                    / TIMER_RUNTIME;
            nProgressBar.setProgress(progress);
        }
    }

    public void onContinuar() {
        Log.d("mensajeFinal", "Su barra de progreso acaba de cargar");
    }

    public void miClicManejador(View view) {
        switch (view.getId()) {
            case R.id.btnConvertir:
                RadioButton dolaresButton = (RadioButton)
                        findViewById(R.id.radio0);
                RadioButton solesButton = (RadioButton)
                        findViewById(R.id.radio1);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Ingresa un número válido",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (dolaresButton.isChecked()) {
                    text.setText(String
                            .valueOf(convierteDolaresASoles(inputValue)));
                    dolaresButton.setChecked(false);
                    solesButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(convierteSolesADolares(inputValue)));
                    solesButton.setChecked(false);
                    dolaresButton.setChecked(true);
                }
                break;
        }
    }

    public void miClicManejador1(View view) {
        switch (view.getId()) {
            case R.id.btnConvertir1:
                RadioButton eurosButton = (RadioButton)
                        findViewById(R.id.radio2);
                RadioButton librasButton = (RadioButton)
                        findViewById(R.id.radio3);
                if (text1.getText().length() == 0) {
                    Toast.makeText(this, "Ingresa un número válido",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text1.getText().toString());
                if (eurosButton.isChecked()) {
                    text1.setText(String
                            .valueOf(convierteEurosALibras(inputValue)));
                    eurosButton.setChecked(false);
                    librasButton.setChecked(true);
                } else {
                    text1.setText(String
                            .valueOf(convierteLibrasAEuros(inputValue)));
                    librasButton.setChecked(false);
                    eurosButton.setChecked(true);
                }
                break;
        }
    }

    public void miClicManejador2(View view) {
        switch (view.getId()) {
            case R.id.btnConvertir2:
                RadioButton rupiasButton = (RadioButton)
                        findViewById(R.id.radio4);
                RadioButton realesButton = (RadioButton)
                        findViewById(R.id.radio5);
                if (text2.getText().length() == 0) {
                    Toast.makeText(this, "Ingresa un número válido",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text2.getText().toString());
                if (rupiasButton.isChecked()) {
                    text2.setText(String
                            .valueOf(convierteRupiasAReales(inputValue)));
                    rupiasButton.setChecked(false);
                    realesButton.setChecked(true);
                } else {
                    text2.setText(String
                            .valueOf(convierteRealesARupias(inputValue)));
                    realesButton.setChecked(false);
                    rupiasButton.setChecked(true);
                }
                break;
        }
    }

    // Convierte a dólares
    private double convierteSolesADolares(float soles) {
        return (soles / 3.8);
    }

    // Convierte a soles
    private double convierteDolaresASoles(float dolares) {
        return (dolares * 3.8);
    }

    //Convierte a Libras
    private double convierteEurosALibras(float euros) {
        return (euros / 0.84);
    }

    //Convierte a Euros
    private double convierteLibrasAEuros(float libras) {
        return (libras * 0.84);
    }

    //Covierte a Reales
    private double convierteRupiasAReales(float rupias) {
        return (rupias / 0.063);
    }

    private double convierteRealesARupias(float reales) {
        return (reales * 0.063);
    }
}