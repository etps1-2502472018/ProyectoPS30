package sv.edu.utec.proyectops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import sv.edu.utec.proyectops.fragmentosM.Add_Fragment;
import sv.edu.utec.proyectops.fragmentosM.Delete_Fragment;
import sv.edu.utec.proyectops.fragmentosM.Edit_Fragment;
import sv.edu.utec.proyectops.fragmentosM.Update_Fragment;
import sv.edu.utec.proyectops.fragmentosM.agregarFoto;

public class Home extends AppCompatActivity {
    Button Vcategorias,rdama,rhombre,rkids;

    DrawerLayout dl;
    Toolbar tlB;
    NavigationView navV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tlB = findViewById(R.id.toolbar);
        dl = findViewById(R.id.drawerLayout);
        navV = findViewById(R.id.navigator);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,dl,tlB,R.string.open,R.string.close);
        dl.addDrawerListener(toggle);
        toggle.syncState();
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white,null));


        this.setTitle("Home");

        navV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.add:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new agregarFoto());
                        break;

                    case R.id.delete:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new Delete_Fragment());
                        break;

                    case R.id.edit:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new Edit_Fragment());
                        break;

                    case R.id.update:
                        dl.closeDrawer(GravityCompat.START);
                        fragmentosDC(new Update_Fragment());
                        break;
                }


                return true;
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*Vcategorias = findViewById(R.id.btnVC);
        rdama = findViewById(R.id.btnRD);
        rhombre = findViewById(R.id.btnRH);
        rkids = findViewById(R.id.btnRN);*/

/*
        Vcategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),Categorias.class);
                startActivity(intento);
            }
        });

        rdama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),RelojDamas.class);
                startActivity(intento);
            }
        });

        rhombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),RelojHombre.class);
                startActivity(intento);
            }
        });

        rkids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(getApplicationContext(),RelojKids.class);
                startActivity(intento);
            }
        });

 */

    }


    //@Override
   /* public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
*/
    private void fragmentosDC(Fragment fragment){
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frmLayoutContenedor,fragment);
        fragmentTransaction.commit();

    }

}

