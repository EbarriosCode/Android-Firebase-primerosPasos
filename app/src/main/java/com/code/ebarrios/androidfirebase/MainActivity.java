package com.code.ebarrios.androidfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.code.ebarrios.androidfirebase.Objetos.Carro;
import com.code.ebarrios.androidfirebase.Objetos.FirebaseReferencias;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button btnCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarro = (Button)findViewById(R.id.btnCarro);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference TutorialReferencia = database.getReference(FirebaseReferencias.TUTORIAL_REFERENCIA);

        btnCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carro carro = new Carro("Ford","Eduardo",4,4);
                TutorialReferencia.child(FirebaseReferencias.CARRO_REFERENCIA).push().setValue(carro);
            }
        });

        /*
        DatabaseReference myRef = database.getReference(FirebaseReferencias.TUTORIAL_REFERENCIA);
        myRef.setValue(210);

        // actualiza los datos en tiempo real con firebase aunque cambie el valor de la db
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int valor = dataSnapshot.getValue(Integer.class);
                Log.i("DATOS",valor+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR",databaseError.getMessage());
            }
        };
        myRef.addValueEventListener(valueEventListener);
        */
    }
}
