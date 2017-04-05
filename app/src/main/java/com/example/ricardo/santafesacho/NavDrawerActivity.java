package com.example.ricardo.santafesacho;
//actividad para los mapas
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class NavDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    String username, correo, password;
    int codigo;
    TextView eUsuario, eCorreo;
    Intent intent;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);

        Bundle extras = getIntent().getExtras();
        username = extras.getString("username");
        correo = extras.getString("correo");
        password = extras.getString("password");
        codigo = extras.getInt("codigo");

        eUsuario = (TextView) hView.findViewById(R.id.usuario);
        eCorreo = (TextView) hView.findViewById(R.id.correo);

        eUsuario.setText(extras.getString("username"));
        eCorreo.setText(extras.getString("correo"));

        //View hView = navigationView.getHeaderView(0);

        navigationView.setNavigationItemSelectedListener(this);
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

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }*/

//    @SuppressWarnings("StatementWithEmptyBody")

    /*@Override
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mHoteles) {
            intent= new Intent(NavDrawerActivity.this, NavHotelActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLugares) {
            intent= new Intent(NavDrawerActivity.this, NavLugaresActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mFestivales) {
            intent= new Intent(NavDrawerActivity.this, NavFestivalesActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mRestaurantes) {
            intent= new Intent(NavDrawerActivity.this, NavRestaurantesActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLogOut) {
            intent = new Intent(NavDrawerActivity.this, LoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.mPerfil) {
            intent = new Intent(NavDrawerActivity.this, NavPerfilActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng Centro = new LatLng(6.556453, -75.827816);
        LatLng Portonp = new LatLng(6.557567, -75.828551);
        LatLng Mariscal = new LatLng(6.557959, -75.829125);
        LatLng Comedia = new LatLng(6.556993, -75.826071);
        LatLng Espana = new LatLng(6.558245, -75.829441);
        LatLng Puente = new LatLng(6.578110, -75.797060);
        LatLng Portons = new LatLng(6.520598, -75.818601);
        LatLng Colonial = new LatLng(6.535057, -75.819113);

        switch (codigo) {

            case 0: //Todos
                mMap.addMarker(new MarkerOptions().position(Centro).title("Parque Central").snippet("Donde todo concurre"));
                mMap.addMarker(new MarkerOptions().position(Portons).title("Porton del Sol").snippet("Hotel"));
                mMap.addMarker(new MarkerOptions().position(Mariscal).title("Mariscal Robledo").snippet("Hotel"));
                mMap.addMarker(new MarkerOptions().position(Colonial).title("Colonial Nueva Granada").snippet("Hotel"));
                mMap.addMarker(new MarkerOptions().position(Puente).title("Puente de Occidente"));
                mMap.addMarker(new MarkerOptions().position(Comedia).title("La Comedia").snippet("Restaurante"));
                mMap.addMarker(new MarkerOptions().position(Portonp).title("Porton del Parque").snippet("Restaurante"));
                mMap.addMarker(new MarkerOptions().position(Espana).title("Sabor Español/Nueva España").snippet("Restaurante"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Centro,12));
                break;
            case 1: //parque o calles coloniales
                mMap.addMarker(new MarkerOptions().position(Centro).title("Parque Central").snippet("Donde todo concurre"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Centro,15));
                break;
            case 2:
                mMap.addMarker(new MarkerOptions().position(Puente).title("Puente de Occidente"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Puente,15));
                break;
            case 3:
                mMap.addMarker(new MarkerOptions().position(Colonial).title("Colonial Nueva Granada").snippet("Hotel"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Colonial,15));
                break;
            case 4:
                mMap.addMarker(new MarkerOptions().position(Mariscal).title("Mariscal Robledo").snippet("Hotel"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Mariscal,15));
                break;
            case 5:
                mMap.addMarker(new MarkerOptions().position(Portons).title("Porton del Sol").snippet("Hotel"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Portons,15));
                break;
            case 6:
                mMap.addMarker(new MarkerOptions().position(Comedia).title("La Comedia").snippet("Restaurante"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Comedia,15));
                break;
            case 7:
                mMap.addMarker(new MarkerOptions().position(Portonp).title("Porton del Parque").snippet("Restaurante"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Portonp,15));
                break;
            case 8:
                mMap.addMarker(new MarkerOptions().position(Espana).title("Sabor Español/Nueva España").snippet("Restaurante"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Espana,15));
                break;
            /*case 9:
                LatLng Centro = new LatLng(6.556453, -75.827816);
                LatLng Portonp = new LatLng(6.557567, -75.828551);
                LatLng Mariscal = new LatLng(6.557959, -75.829125);
                LatLng Comedia = new LatLng(6.556993, -75.826071);
                LatLng Espana = new LatLng(6.558245, -75.829441);
                LatLng Puente = new LatLng(6.578110, -75.797060);
                LatLng Portons = new LatLng(6.520598, -75.818601);
                LatLng Colonial = new LatLng(6.535057, -75.819113);
                mMap.addMarker(new MarkerOptions().position(Centro).title("Parque Central").snippet("Donde todo concurre"));
                mMap.addMarker(new MarkerOptions().position(Portons).title("Porton del Sol").snippet("Hotel"));
                mMap.addMarker(new MarkerOptions().position(Mariscal).title("Mariscal Robledo").snippet("Hotel"));
                mMap.addMarker(new MarkerOptions().position(Colonial).title("Colonial Nueva Granada").snippet("Hotel"));
                mMap.addMarker(new MarkerOptions().position(Puente).title("Puente de Occidente"));
                mMap.addMarker(new MarkerOptions().position(Comedia).title("La Comedia").snippet("Restaurante"));
                mMap.addMarker(new MarkerOptions().position(Portonp).title("Porton del Parque").snippet("Restaurante"));
                mMap.addMarker(new MarkerOptions().position(Espana).title("Sabor Español/Nueva España").snippet("Restaurante"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Centro,15));
                break;*/
        }
        //mMap.addMarker(new MarkerOptions().position().title().snippet());
        //icon(BitmapDescriptorFactory.fromResource(R.drawable.book)).
    }
}

