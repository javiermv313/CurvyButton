package com.example.curvybutton;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import android.os.Bundle;

public class splash extends AppCompatActivity {
    private final int DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }
}


/******************************************************
 Aplicacion Desarrollada por:
 Javier Mercado Velazquez
 Facultad de Estudios Superiores Aragon
 Ingenieria en Computacion
 11/27/19

 Aplicación digital realizada con el apoyo del Programa UNAM-DGAPA-PAPIME-PE110418"


 **********************************************************/


