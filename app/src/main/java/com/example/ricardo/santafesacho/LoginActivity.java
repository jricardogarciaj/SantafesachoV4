package com.example.ricardo.santafesacho;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsuario, eContrasena;
    Button bIniciar;
    TextView tRegistrarse;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String username = "", password = "", correo = "";
    //int num =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        pref=getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        editor=pref.edit();

        eUsuario = (EditText) findViewById(R.id.eUsuario);
        eContrasena = (EditText) findViewById(R.id.eContrasena);
        bIniciar = (Button) findViewById(R.id.bIngresar);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);

        username = pref.getString("username","");
        password = pref.getString("password","");
        correo = pref.getString("correo","");

        //username="null"; password="null";
        Log.d("Login",String.valueOf(pref.getInt("login",-1)));
        Log.d("nombre", pref.getString("username","noname"));

        if(pref.getInt("login",-1) == 1) {
            Intent intent = new Intent(LoginActivity.this, NavFestivalesActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo",correo);
            startActivity(intent);
        }


        //Toast.makeText(this, extras.toString("username"),Toast.LENGTH_LONG).show();*/

       tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivityForResult(intent, 1234);
                //mandar datos
                //intent.putExtra("username", eRUsuario.getText().toString());
            }
        });

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validar que el usuario y contrasña sean iguales a los recibidos

                if (eUsuario.getText().toString().equals(username) && eContrasena.getText().toString().equals(password)) {
                    //registrado = "si";
                    editor.putInt("login",1); //1 ya logueado 0 no logeado
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, NavFestivalesActivity.class);
                    intent.putExtra("username", username);
                    intent.putExtra("correo", correo);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(getApplicationContext(),"Error en los datos",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*public void bregistrar(View view) {
        Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivityForResult(intent,1234);}*/

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
            Log.d("nombre",data.getExtras().getString("username"));
            Log.d("correo",data.getExtras().getString("correo"));
            /*etUsuario.setText(username);
            etPassword.setText(password);*/
            editor.putString("username", username);
            editor.putString("password", password);
            editor.putString("correo", correo);
            //editor.putInt("login",1); //1 ya logueado 0 no logeado
            editor.commit();
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en login",Toast.LENGTH_SHORT).show();
        }

    }

    /*public void Entrar(View view) {



        if (eUsuario.getText().toString().equals(username) && eContrasena.getText().toString().equals(password) ) {
            //etUsuario.setText(username);
            //etPassword.setText(password);
            Intent intent = new Intent(LoginActivity.this, NavFestivalesActivity.class);
            intent.putExtra("username", username);
            intent.putExtra("correo",correo);
            editor.putInt("login",1); //1 ya logueado 0 no logeado
            editor.commit();
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
        }
    }*/

}

 /*   @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode==RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");
            Log.d("nombre",data.getExtras().getString("username"));
            Log.d("correo",data.getExtras().getString("correo"));
        }
        if (requestCode == 1234 && resultCode==RESULT_CANCELED){
            Toast.makeText(this, "Error en registro",Toast.LENGTH_SHORT).show();
        }
    }*/
