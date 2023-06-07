package sv.edu.utec.proyectops.fragmentosM;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import sv.edu.utec.proyectops.Home;
import sv.edu.utec.proyectops.R;


public class Add_Fragment extends Fragment {

    EditText edtnombre,edtcorreo,edtcontraseña;
    Button btnregistrar;

    DatabaseReference mDatabase;
    FirebaseAuth mAuth;

    private String nombre="",correo="",contraseña="";
    public Add_Fragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_, container, false);
        mAuth=FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        edtnombre = (EditText) view.findViewById(R.id.edtnombre1);
        edtcorreo = (EditText) view.findViewById(R.id.edtcorreo1);
        edtcontraseña = (EditText) view.findViewById(R.id.edtpass1);
        btnregistrar =(Button) view.findViewById(R.id.btnBorrar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre=edtnombre.getText().toString();
                correo=edtcorreo.getText().toString();
                contraseña=edtcontraseña.getText().toString();

                if(!nombre.isEmpty() && !correo.isEmpty() && !contraseña.isEmpty()){
                    if(contraseña.length() >=6) {

                        registrarUsuario();
                    }
                    else{
                        Toast.makeText(getActivity(), "La contraseña debe contener 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getActivity(), "Complete los campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
    private void  registrarUsuario(){

        mAuth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("nombre",nombre);
                    map.put("correo",correo);
                    map.put("contraseña",contraseña);

                    String id = mAuth.getCurrentUser().getUid();
                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Toast.makeText(getActivity(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                                Intent intento=new Intent(getActivity(), Home.class);
                                startActivity(intento);

                            }
                            else {
                                Toast.makeText(getActivity(), "No se creo usuarios", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
                else{
                    Toast.makeText(getActivity(), "no se pudo registrar usuario", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}