package sv.edu.utec.proyectops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RelojDamas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj_damas);

        this.setTitle("Reloj Damas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}