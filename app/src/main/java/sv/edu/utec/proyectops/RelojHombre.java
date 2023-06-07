package sv.edu.utec.proyectops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RelojHombre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj_hombre);

        this.setTitle("Reloj Hombre");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}