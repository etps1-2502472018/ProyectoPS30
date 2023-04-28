package sv.edu.utec.proyectops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RelojKids extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reloj_kids);

        this.setTitle("Reloj Niño");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

}