package com.example.ricardo.santafesacho;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestUnoFragment extends Fragment {

//    TextView tVerenmapa;
  //  String username, correo;

    public RestUnoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //tVerenmapa = (TextView) getView().findViewById(R.id.vermapa);

        //tVerenmapa.setOnClickListener(new View.OnClickListener() {
         //   @Override

          /*  public void onClick(View view) {
                Intent intent = new Intent(getActivity(), NavDrawerActivity.class);
                intent.putExtra("username", );
                intent.putExtra("correo", correo);
                //intent.putExtra("password", password);
                startActivityForResult(intent);
                //mandar datos
                //intent.putExtra("username", eRUsuario.getText().toString());
            }
        });*/
        return inflater.inflate(R.layout.fragment_rest_uno, container, false);
    }

}
