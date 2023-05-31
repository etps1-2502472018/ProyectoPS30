package sv.edu.utec.proyectops.fragmentosM;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import sv.edu.utec.proyectops.R;


public class Add_Fragment extends Fragment {

    EditText edtnombre,edtcorreo,edtcontraseña;
    Button agregar;

    FirebaseDatabase mDatabase;
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
        edtnombre = (EditText) view.findViewById(R.id.edtnombre1);
        edtcorreo = (EditText) view.findViewById(R.id.edtcorreo1);
        edtcontraseña = (EditText) view.findViewById(R.id.edtpass1);
        return view;
    }
}