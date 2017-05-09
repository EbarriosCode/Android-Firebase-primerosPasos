package com.code.ebarrios.androidfirebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtCorreo;
    EditText txtPassword;
    Button btnLogin;
    Button btnRegistro;

    FirebaseAuth.AuthStateListener mAuthStateListener;
    //Button btnCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCorreo = (EditText)findViewById(R.id.email);
        txtPassword = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnRegistro = (Button)findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        mAuthStateListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser(); //FirebaseAuth.getInstance().getCurrentUser();

                if(user != null)
                {
                    Log.i("SESION","Sesión iniciada con email "+user.getEmail());
                }
                else
                {
                    Log.i("SESION","Sesión cerrada");
                }
            }
        };

        /*btnCarro = (Button)findViewById(R.id.btnCarro);

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

    private void Registrar(String email, String pass)
    {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass);
    }

    private void IniciarSesion(String email, String pass)
    {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogin:
                String emailLogin = txtCorreo.getText().toString();
                String passLogin = txtPassword.getText().toString();
                IniciarSesion(emailLogin,passLogin);
                break;

            case R.id.btnRegistro:
                String email = txtCorreo.getText().toString();
                String pass = txtPassword.getText().toString();
                Registrar(email,pass);
                break;
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Fire
    }
}
