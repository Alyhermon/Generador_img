package com.example.alert;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


    private TextView deslizar;
    private GestureDetector gestureDetector;
    ImageView imgF;
    Button btngenerar, btninfo, btneditar;
    private List<String>List;
    EditText ediN, ediA, ediI;
    String name, asignatura, instituto;

    //////////////////////////////////////////

    EditText eName;
    //InfoClass Alerta = new InfoClass();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgF = findViewById(R.id.imgF);
        btninfo = findViewById(R.id.btninfo);
        btngenerar = findViewById(R.id.btngenerar);
        btneditar = findViewById(R.id.btneditar);
        deslizar = findViewById(R.id.deslizar);
        this.gestureDetector = new GestureDetector(this, this);
        gestureDetector.setOnDoubleTapListener(this);


        btninfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Informacion");
                final View customLayout = getLayoutInflater().inflate(R.layout.activity_info, null);
                ediN = customLayout.findViewById(R.id.edtName);
                ediA = customLayout.findViewById( R.id.edtAsign);
                ediI = customLayout.findViewById(R.id.edtInstituto);

                ediN.setText(name);
                ediA.setText(asignatura);
                ediI.setText(instituto);

                ediN.setEnabled(false);
                ediA.setEnabled(false);
                ediI.setEnabled(false);

                builder.setView(customLayout);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {


                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();

            }
        });

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Editar");
                final View customLayout = getLayoutInflater().inflate(R.layout.activity_info, null);
                ediN = customLayout.findViewById(R.id.edtName);
                ediA = customLayout.findViewById( R.id.edtAsign);
                ediI = customLayout.findViewById(R.id.edtInstituto);

                ediN.setEnabled(true);
                ediA.setEnabled(true);
                ediI.setEnabled(true);

                builder.setView(customLayout);
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        name = ediN.getText().toString();
                        asignatura = ediA.getText().toString();
                        instituto = ediI.getText().toString();
                        Toast.makeText(MainActivity.this, ediI.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


    }

    //Para generar la alerta de los checkbox

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("AlertDialog");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // alertDialog.cancel();
            }});
        String[] items = {"Persona", "Animales", "Flores", "Carros"};
        boolean[] checkedItems = {false, false, false, false, false};
        alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (checkedItems[0] == isChecked && checkedItems[1] == isChecked && checkedItems[2] == isChecked && checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.per_anim_flores_carro);
                }

                else if (checkedItems[0] == isChecked && checkedItems[1] == isChecked && checkedItems[2] == isChecked){
                    imgF.setImageResource(R.drawable.per_anim_flores);
                }

                else if (checkedItems[0] == isChecked && checkedItems[1] == isChecked && checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.per_anim_carro);
                }
                else if (checkedItems[0] == isChecked && checkedItems[2] == isChecked && checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.per_flores_carro);
                }
                else if (checkedItems[1] == isChecked && checkedItems[2] == isChecked && checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.anim_flores_carro);
                }
                else if (checkedItems[0] == isChecked && checkedItems[1] == isChecked) {
                    imgF.setImageResource(R.drawable.per_anim);
                }
                else if (checkedItems[0] == isChecked && checkedItems[2] == isChecked){
                    imgF.setImageResource(R.drawable.per_flor);
                }
                else if (checkedItems[0] == isChecked && checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.per_carro);
                }
                else if (checkedItems[1] == isChecked && checkedItems[2] == isChecked) {
                    imgF.setImageResource(R.drawable.anim_flores);
                }
                else if (checkedItems[1] == isChecked && checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.anim_carro);
                }
                else if (checkedItems[2] == isChecked && checkedItems[3] == isChecked) {
                    imgF.setImageResource(R.drawable.flor_carro);
                }
                else if (checkedItems[0] == isChecked) {
                    imgF.setImageResource(R.drawable.persona);
                }
                else if (checkedItems[1] == isChecked) {
                        imgF.setImageResource(R.drawable.animales);
                    }
                else if (checkedItems[2] == isChecked) {
                        imgF.setImageResource(R.drawable.tulipanes);
                    }
                else if (checkedItems[3] == isChecked){
                    imgF.setImageResource(R.drawable.carro);
                }else{
                    imgF.setImageResource(R.drawable.ic_launcher_background);
                }


            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    public Dialog onCreateDialogo(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = new MainActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_info, null);

        builder.setView(view)
                .setTitle("Informacion")
                .setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

        return builder.create();
    }

    //Metodo para deslizar

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    //Este es el metodo para que cuando se deslize se pueda salir de la aplicacion
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        finishAffinity();
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}

