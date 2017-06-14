package com.foromtb.luroga.firebasepruebas;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.foromtb.luroga.firebasepruebas.modelo.Puerto;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private FloatingActionButton mNuevo;


    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference("Puertos");

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        if (mRecyclerView != null) mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(false);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        FirebaseRecyclerAdapter<Puerto,PuertoViewHolder> adapter = new FirebaseRecyclerAdapter<Puerto, PuertoViewHolder>(
                Puerto.class,
                R.layout.puerto_item,
                PuertoViewHolder.class,
                mDatabaseReference.getRef()
        ) {
            @Override
            protected void populateViewHolder(PuertoViewHolder viewHolder, Puerto model, int position) {

                viewHolder.nombre.setText(model.getNombre());
                viewHolder.descripcion.setText(model.getDescripcion());
                viewHolder.valoracion.setRating(model.getValoracion());



            }
        };

        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        mNuevo = (FloatingActionButton)findViewById(R.id.floatingNuevo);
        mNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AnadirItem.class);
                startActivity(i);
            }
        });















/*

        Puerto p = new Puerto();

        p.setNombre("Etaxuri");
        p.setDescripcion("Puerto 6km");
        p.setValoracion(2f);
        p.setLoc_longitud(123);
        p.setLoc_latitud(1);
        p.setLoc_altura(400);



        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Puertos").child(p.getNombre());

        myRef.setValue(p.toMap());

*/




    }
    public  static class PuertoViewHolder extends RecyclerView.ViewHolder{

         TextView nombre, descripcion;
         RatingBar valoracion;

        public PuertoViewHolder(View v){
            super (v);


            nombre = (TextView)v.findViewById(R.id.itemNombre);
            descripcion = (TextView)v.findViewById(R.id.itemDistancia);
            valoracion = (RatingBar)v.findViewById(R.id.itemValoracion);

        }
    }

}
