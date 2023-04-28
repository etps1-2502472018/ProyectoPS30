package sv.edu.utec.proyectops;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Registrarse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        this.setTitle("Registrarse");


       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

   // @Override
   /* public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
*/
}