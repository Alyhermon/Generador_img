package com.example.alert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgF;
    Button btngenerar, btninfo, btneditar;
    Editar editar = new Editar();
    info Alerta = new info();
    check checkbox = new check();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgF = findViewById(R.id.imgF);
        btninfo = findViewById(R.id.btninfo);
        btngenerar = findViewById(R.id.btngenerar);
        btneditar = findViewById(R.id.btneditar);

        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Alerta.show(getSupportFragmentManager(), "Ejemplo");

            }
        });

        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkbox.show(getSupportFragmentManager(), "Ejemplo2");

            }
        });

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editar.show(getSupportFragmentManager(), "Ejemplo");

            }
        });


    }


}