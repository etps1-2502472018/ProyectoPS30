package sv.edu.utec.proyectops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registrarse extends AppCompatActivity {
    EditText edtnombre,edtCorreo,edtPass;
    Button btnregistrar;

    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    private String nombre="",correo="",contraseña="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        edtnombre=findViewById(R.id.edtNombre);
        edtCorreo=findViewById(R.id.edtEmail);
        edtPass=findViewById(R.id.edtContra);
        btnregistrar=findViewById(R.id.btnAddU);
        this.setTitle("Registrarse");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=edtnombre.getText().toString();
                correo=edtCorreo.getText().toString();
                contraseña=edtPass.getText().toString();

                if(!nombre.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){
                    if(contraseña.length() >=6) {

                        registrarUsuario();
                    }
                    else{
                        Toast.makeText(Registrarse.this, "la contraseña debe contener 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(Registrarse.this, "Complete los campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void  registrarUsuario(){

        mAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object>     map = new HashMap<>();
                    map.put("nombre",nombre);
                    map.put("correo",correo);
                    map.put("contraseña",contraseña);
                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("nombre").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Toast.makeText(Registrarse.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                                Intent intento=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intento);

                            }
                            else {
                                Toast.makeText(Registrarse.this, "No se creo usuarios", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
                else{
                    Toast.makeText(Registrarse.this, "no se pudo registrar usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}