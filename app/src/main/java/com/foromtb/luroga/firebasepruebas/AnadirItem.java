package com.foromtb.luroga.firebasepruebas;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.design.internal.SnackbarContentLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.foromtb.luroga.firebasepruebas.modelo.Puerto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by LuisR on 13/06/2017.
 */

public class AnadirItem extends AppCompatActivity{

    private TextView nombre, descripcion;
    private RatingBar valoracion;
    private Button anadir, cancelar;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anadir_layout);

        nombre = (TextView)findViewById(R.id.nuevoNombre);
        descripcion = (TextView)findViewById(R.id.nuevoDescripcion);
        valoracion = (RatingBar)findViewById(R.id.nuevoValoracion);
        anadir = (Button)findViewById(R.id.nuevoAceptar);
        cancelar = (Button)findViewById(R.id.nuevoCancelar);

        anadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Puerto p =  new Puerto(
                        nombre.getText().toString(),
                        descripcion.getText().toString(),
                        valoracion.getRating(),
                        129,
                        1,
                        400);

                mFirebaseDatabase = FirebaseDatabase.getInstance();
                mDatabaseReference = mFirebaseDatabase.getReference("Puertos").child(p.getNombre());
                mDatabaseReference.setValue(p.toMap());


                Snackbar snackbar = Snackbar.make(findViewById(R.id.anadirConstraintLayout),"Puerto añadirdo",Snackbar.LENGTH_INDEFINITE);
                snackbar.show();






                volverPrincipal();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverPrincipal();
            }
        });



    }

    private void volverPrincipal(){
        Intent i = new Intent(AnadirItem.this,MainActivity.class);
        startActivity(i);
    }
}
