package com.example.ricardo.santafesacho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
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

public class NavRestaurantesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String username, correo, password;
    Intent intent;
    TextView eUsuario,eCorreo;
    int codigo=0, seltab=0;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nav_restaurantes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                seltab = tabLayout.getSelectedTabPosition();

                switch (seltab){

                    case 0:
                        codigo = 6;
                        intent= new Intent(NavRestaurantesActivity.this, NavDrawerActivity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("correo",correo);
                        intent.putExtra("codigo",codigo);
                        startActivity(intent);
                        break;
                    case 1:
                        codigo = 7;
                        intent= new Intent(NavRestaurantesActivity.this, NavDrawerActivity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("correo",correo);
                        intent.putExtra("codigo",codigo);
                        startActivity(intent);
                        break;
                    case 2:
                        codigo = 8;
                        intent= new Intent(NavRestaurantesActivity.this, NavDrawerActivity.class);
                        intent.putExtra("username",username);
                        intent.putExtra("correo",correo);
                        intent.putExtra("codigo",codigo);
                        startActivity(intent);
                        break;
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View hView = navigationView.getHeaderView(0);

        eUsuario = (TextView) hView.findViewById(R.id.rusuario);
        eCorreo = (TextView) hView.findViewById(R.id.rcorreo);

        Bundle extras = getIntent().getExtras();

        username = extras.getString("username");
        correo = extras.getString("correo");

        eUsuario.setText(extras.getString("username"));
        eCorreo.setText(extras.getString("correo"));

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
        getMenuInflater().inflate(R.menu.nav_restaurantes, menu);
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
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mUbicate) {
            codigo = 0;
            intent= new Intent(NavRestaurantesActivity.this, NavDrawerActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            intent.putExtra("codigo",codigo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mHoteles) {
            intent= new Intent(NavRestaurantesActivity.this, NavHotelActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mFestivales) {
            intent= new Intent(NavRestaurantesActivity.this, NavFestivalesActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLugares) {
            intent= new Intent(NavRestaurantesActivity.this, NavLugaresActivity.class);
            intent.putExtra("username",username);
            intent.putExtra("correo",correo);
            startActivity(intent);
            finish();
        }

        else if (id == R.id.mLogOut) {
            intent = new Intent(NavRestaurantesActivity.this, LoginActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.mPerfil) {
            intent = new Intent(NavRestaurantesActivity.this, NavPerfilActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    RestUnoFragment tab1 = new RestUnoFragment();
                    return tab1;
                case 1:
                    RestDosFragment tab2 = new RestDosFragment();
                    return tab2;
                case 2:
                    RestTresFragment tab3 = new RestTresFragment();
                    return tab3;
            }
            return null;

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "La Comedia";
                case 1:
                    return "Porton Del Parque";
                case 2:
                    return "Sabor Español";
            }
            return null;
        }
    }
}
