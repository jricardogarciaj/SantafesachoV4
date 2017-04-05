package com.example.ricardo.santafesacho;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NavFestivalesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username,correo;
    TextView eUsuario,eCorreo;
    int codigo=0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    Intent intent;
    FestivalesC[] datos = new FestivalesC [] {
            //new FestivalesC(R.drawable.santa,"Semana Santa","Abril", "Con más de 350 años, es una de las más solemnes y bellas de todo el país."),
            //new FestivalesC(R.drawable.tamar,"Festival del Tamarindo","Agosto","Acontecida anualmente en el occidente en el mes de Agosto."),
            //new FestivalesC(R.drawable.tama, "Dia de los Diablitos" , "Diciembre","Del 22 al 31 de diciembre se celebran las fiestas tradicionales de los diablitos.")
    };

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nav_festivales);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pref=getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        editor=pref.edit();

        datos = new FestivalesC [] {
                new FestivalesC(R.drawable.santa,"Semana Santa", this.getString(R.string.Abril), this.getString(R.string.Dessanta)),
                new FestivalesC(R.drawable.tamar,"Festival del Tamarindo",this.getString(R.string.Agosto),this.getString(R.string.Destama)),
                new FestivalesC(R.drawable.tama, "Dia de los Diablitos" , this.getString(R.string.Diciembre),this.getString(R.string.Desdiablo))
        };

        Adapter adapter = new Adapter(this, datos);

        lista = (ListView) findViewById(R.id.Lista);

        lista.setAdapter(adapter);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);

        eUsuario = (TextView) hView.findViewById(R.id.feusuario);
        eCorreo = (TextView) hView.findViewById(R.id.fecorreo);

        Bundle extras = getIntent().getExtras();
        eUsuario.setText(extras.getString("username"));
        eCorreo.setText(extras.getString("correo"));

        username = extras.getString("username");
        correo = extras.getString("correo");

        navigationView.setNavigationItemSelectedListener(this);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch(position) {

                    case 0:
                        intent = new Intent(NavFestivalesActivity.this, Fest2Activity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("correo",correo);
                        startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(NavFestivalesActivity.this, Fest3Activity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("correo",correo);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(NavFestivalesActivity.this, Fest1Activity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("correo",correo);
                        startActivity(intent);
                        break;
                    default:
                }
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    class Adapter extends ArrayAdapter<FestivalesC> {


        public Adapter(Context context, FestivalesC[] datos) {
            super(context,R.layout.listview_item,datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listview_item,null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descripcion = (TextView) item.findViewById(R.id.tDescripcion);
            descripcion.setText(datos[position].getDescripcion());

            TextView fecha = (TextView) item.findViewById(R.id.tFecha);
            fecha.setText(datos[position].getFecha());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_festivales, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mUbicate) {
            intent= new Intent(NavFestivalesActivity.this, NavDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            intent.putExtra("codigo",codigo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mHoteles) {
            intent= new Intent(NavFestivalesActivity.this, NavHotelActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLugares) {
            intent= new Intent(NavFestivalesActivity.this, NavLugaresActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mRestaurantes) {
            intent= new Intent(NavFestivalesActivity.this, NavRestaurantesActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLogOut) {
            editor.putInt("login",-1); //1 ya logueado 0 no logeado
            editor.commit();
            intent = new Intent(NavFestivalesActivity.this, LoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.mPerfil) {
            intent = new Intent(NavFestivalesActivity.this, NavPerfilActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
