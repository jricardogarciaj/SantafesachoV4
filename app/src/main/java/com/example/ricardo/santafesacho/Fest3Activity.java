package com.example.ricardo.santafesacho;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class Fest3Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username,correo;
    TextView eUsuario,eCorreo;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_fest3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);

        eUsuario = (TextView) hView.findViewById(R.id.f3usuario);
        eCorreo = (TextView) hView.findViewById(R.id.f3correo);

        Bundle extras = getIntent().getExtras();
        eUsuario.setText(extras.getString("username"));
        eCorreo.setText(extras.getString("correo"));

        username = extras.getString("username");
        correo = extras.getString("correo");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

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
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fest3, menu);
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

        if (id == R.id.mMain) {
            intent= new Intent(Fest3Activity.this, NavDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mHoteles) {
            intent= new Intent(Fest3Activity.this, NavHotelActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mFestivales) {
            intent= new Intent(Fest3Activity.this, NavFestivalesActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mRestaurantes) {
            intent= new Intent(Fest3Activity.this, NavRestaurantesActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLogOut) {
            intent = new Intent(Fest3Activity.this, LoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.mPerfil) {
            intent = new Intent(Fest3Activity.this, NavPerfilActivity.class);
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
