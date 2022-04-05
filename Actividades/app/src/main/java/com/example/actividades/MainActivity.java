package com.example.actividades;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String eti="CicloDeVida";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(eti,"En el evento onCreate()");
    }
    public void onStart()
    {
        super.onStart();
        Log.d(eti,"En el evento onStart()");
    }
    public void onRestart()
    {
        super.onRestart();
        Log.d(eti,"En el evento onRestart()");
    }
    public void onResume()
    {
        super.onResume();
        Log.d(eti,"En el evento onResume()");
    }
    public void onPause()
    {
        super.onPause();
        Log.d(eti,"En el evento onPause()");
    }
    public void onStop()
    {
        super.onStop();
        Log.d(eti,"En el evento onStop()");
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(eti,"En el evento onDestroy()");
    }
    public void onClick(View view) {
        startActivity(new Intent("com.example.SegundaActividad"));
    }


}