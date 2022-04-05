package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.os.Bundle;

public class Barra extends AppCompatActivity {
    protected static final int TIMER_RUNTIME = 10000;
    protected boolean nbActivo;
    protected ProgressBar nProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra);
        nProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        final Thread timerThread = new Thread(){
            @Override
            public void run(){
                nbActivo = true;
                try{
                    int espera1 = 0;
                    while(nbActivo && (espera1 < TIMER_RUNTIME)){
                        sleep(200);
                        if(nbActivo){
                            espera1 += 200;
                            actualizarProgress(espera1);
                        }
                    }
                } catch(InterruptedException e){
                } finally{
                    onContinuar();
                }
            }
        };
        timerThread.start();
    }
    public void actualizarProgress(final int timePassed){
        if(null != nProgressBar){
            final int progress = nProgressBar.getMax() * timePassed
                    /TIMER_RUNTIME;
            nProgressBar.setProgress(progress);
        }
    }
    public void onContinuar(){
        Log.d("mensajeFinal", "Su barra de progreso acaba de cargar");
    }
}