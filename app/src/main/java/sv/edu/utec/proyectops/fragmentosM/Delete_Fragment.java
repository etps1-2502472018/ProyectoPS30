package sv.edu.utec.proyectops.fragmentosM;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import sv.edu.utec.proyectops.R;


public class Delete_Fragment extends Fragment {

    EditText iduser;
    Button btnborrar;
    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    private String usuario="";
    public Delete_Fragment() {
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
        View view= inflater.inflate(R.layout.fragment_delete_, container, false);
        iduser=(EditText) view.findViewById(R.id.edtnombre1);
        btnborrar=(Button) view.findViewById(R.id.btnBorrar);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usuario=iduser.getText().toString();
                mDatabase.child("Usuarios").child(usuario).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getActivity(), "Registro Eliminado", Toast.LENGTH_SHORT).show();
                        usuario =" ";
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(), "Error al eliminar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        return  view;
    }
}