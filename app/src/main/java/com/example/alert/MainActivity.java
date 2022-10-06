package com.example.alert;

import androidx.appcompat.app.AppCompatActivity;

import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ImageView imgF;
    CheckBox ch1, ch2, ch3, ch4;
    Button btngenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgF = findViewById(R.id.imgF);
        ch1 = findViewById(R.id.cbpersona);
        ch2 = findViewById(R.id.cbanimales);
        ch3 = findViewById(R.id.cbflores);
        ch4 = findViewById(R.id.cbcarro);
        btngenerar = findViewById(R.id.btngenerar);

        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ch1.isChecked()) {
                    imgF.setImageResource(R.drawable.persona);

                    //Dos checked
                    if (ch1.isChecked() && ch2.isChecked()) {
                        imgF.setImageResource(R.drawable.per_anim);
                    }
                    if (ch1.isChecked() && ch3.isChecked()){
                        imgF.setImageResource(R.drawable.per_flor);
                    }
                    if (ch1.isChecked() && ch4.isChecked()){
                        imgF.setImageResource(R.drawable.per_carro);
                    }

                    //Tres checked
                    if (ch1.isChecked() && ch2.isChecked() && ch3.isChecked()){
                        imgF.setImageResource(R.drawable.per_anim_flores);
                    }
                    if (ch1.isChecked() && ch2.isChecked() && ch4.isChecked()){
                        imgF.setImageResource(R.drawable.per_anim_carro);
                    }
                    if (ch1.isChecked() && ch3.isChecked() && ch4.isChecked()){
                        imgF.setImageResource(R.drawable.per_flores_carro);
                    }

                    //Cuatros checked
                    if (ch1.isChecked() && ch2.isChecked() && ch3.isChecked() && ch4.isChecked()){
                        imgF.setImageResource(R.drawable.per_anim_flores_carro);
                    }
                }
                else if (ch2.isChecked()){
                    imgF.setImageResource(R.drawable.animales);

                    //Dos checked
                        if (ch2.isChecked() && ch3.isChecked()) {
                            imgF.setImageResource(R.drawable.anim_flores);
                    }
                        if (ch2.isChecked() && ch4.isChecked()){
                            imgF.setImageResource(R.drawable.anim_carro);
                        }
                        if (ch2.isChecked() && ch3.isChecked() && ch4.isChecked()){
                            imgF.setImageResource(R.drawable.anim_flores_carro);
                        }
                }
                else if (ch3.isChecked()){
                    imgF.setImageResource(R.drawable.tulipanes);
                        if (ch3.isChecked() && ch4.isChecked()) {
                            imgF.setImageResource(R.drawable.flor_carro);
                    }
                }
                else if (ch4.isChecked()){
                    imgF.setImageResource(R.drawable.carro);
                }else{
                    imgF.setImageResource(R.drawable.ic_launcher_foreground);
                }


            }
        });
    }


}