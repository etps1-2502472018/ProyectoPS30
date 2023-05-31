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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button entrar,registrar;
    EditText correo,contraseña;
    FirebaseAuth mAut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAut = FirebaseAuth.getInstance();
        correo = findViewById(R.id.edtNombre);
        contraseña= findViewById(R.id.edtContra);

        entrar = findViewById(R.id.btnAddU);
        registrar = findViewById(R.id.btnRegistro);



        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String User = correo.getText().toString();
                String Pass = contraseña.getText().toString();

                if(User.isEmpty() && Pass.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Ingrese los datos", Toast.LENGTH_SHORT).show();
                }
                else {
                    loginUser(User,Pass);

                }

            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),Registrarse.class);
                startActivity(intento);
            }
        });
    }

    private void loginUser(String User, String Pass) {
        mAut.signInWithEmailAndPassword(User,Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();

                    Intent intento=new Intent(getApplicationContext(),Home.class);

                    startActivity(intento);
                    Toast.makeText(MainActivity.this, "BienVenido", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }

}