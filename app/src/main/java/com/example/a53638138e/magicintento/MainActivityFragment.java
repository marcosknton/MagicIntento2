package com.example.a53638138e.magicintento;

import android.media.Image;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // Jugador 1

    TextView puntuacionJugador1;

    int vidaJugador1 = 20;
    int venenoJugador1 = 0;

    ImageButton sumarVida;
    ImageButton restarVida;
    Button sumarVeneno;
    Button restarVeneno;
    ImageButton robarVida;

    // Jugador 2

    TextView puntuacionJugador2;

    int vidaJugador2 = 20;
    int venenoJugador2 = 0;

    ImageButton sumarVida2;
    ImageButton restarVida2;
    Button sumarVeneno2;
    Button restarVeneno2;
    ImageButton robarVida2;

    public MainActivityFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_main, container, false);

        // Jugador 1
        puntuacionJugador1 = (TextView) vista.findViewById(R.id.vidauno);
        sumarVida = (ImageButton) vista.findViewById(R.id.vidamas);
        restarVida = (ImageButton) vista.findViewById(R.id.vidamenos);
        sumarVeneno = (Button) vista.findViewById(R.id.venenomas);
        restarVeneno = (Button) vista.findViewById(R.id.venenomenos);
        robarVida = (ImageButton)vista.findViewById(R.id.jugador1);

        // Evento que se ejecuta al pulsar el botón sumarVida
        sumarVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaJugador1++;
                actualizarPuntuacionJugador1();
            }
        });

        // Evento que se ejecuta al pulsar el botón restarVida
        restarVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaJugador1--;
                actualizarPuntuacionJugador1();
            }
        });

        // Evento que se ejecuta al pulsar el botón sumarVeneno
        sumarVeneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venenoJugador1++;
                actualizarPuntuacionJugador1();
            }
        });

        // Evento que se ejecuta al pulsar el botón restarVeneno
        restarVeneno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(venenoJugador1 != 0){
                    venenoJugador1--;
                }

                actualizarPuntuacionJugador1();
            }
        });

        robarVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaJugador2--;
                vidaJugador1++;
                actualizarPuntuacionJugador2();
                actualizarPuntuacionJugador1();
            }
        });






        // Jugador 2
        puntuacionJugador2 = (TextView) vista.findViewById(R.id.vidados2);
        sumarVida2 = (ImageButton) vista.findViewById(R.id.vidamas2);
        restarVida2 = (ImageButton) vista.findViewById(R.id.vidamenos2);
        sumarVeneno2 = (Button) vista.findViewById(R.id.venenomas2);
        restarVeneno2 = (Button) vista.findViewById(R.id.venenomenos2);
        robarVida2 = (ImageButton)vista.findViewById(R.id.jugador2);

        // Evento que se ejecuta al pulsar el botón sumarVida
        sumarVida2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaJugador2++;
                actualizarPuntuacionJugador2();
            }
        });

        // Evento que se ejecuta al pulsar el botón restarVida
        restarVida2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaJugador2--;
                actualizarPuntuacionJugador2();
            }
        });

        // Evento que se ejecuta al pulsar el botón sumarVeneno
        sumarVeneno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                venenoJugador2++;
                actualizarPuntuacionJugador2();
            }
        });

        // Evento que se ejecuta al pulsar el botón restarVeneno
        restarVeneno2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(venenoJugador2 != 0){
                    venenoJugador2--;
                }

                actualizarPuntuacionJugador2();
            }
        });

        robarVida2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidaJugador1--;
                vidaJugador2++;
                actualizarPuntuacionJugador2();
                actualizarPuntuacionJugador1();
            }
        });



        return vista;
    }





    // Métodos para actualizar la puntuación

    public void actualizarPuntuacionJugador1 (){
        puntuacionJugador1.setText(vidaJugador1 + "/" + venenoJugador1);
    }

    public void actualizarPuntuacionJugador2 (){
        puntuacionJugador2.setText(vidaJugador2 + "/" + venenoJugador2);
    }

    public void resetearPuntuacion (){
        venenoJugador1 = 0;
        venenoJugador2 = 0;

        vidaJugador1 = 20;
        vidaJugador2 = 20;

        actualizarPuntuacionJugador1();
        actualizarPuntuacionJugador2();

        // Mensaje de la SnackBar
        Snackbar.make(getView(), "Se ha reiniciado la partida", Snackbar.LENGTH_LONG) .setAction("Action", null).show();
    }

    // Imagen

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    // Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // El id hace referencia al item que tenemos guardado en la carpeta menu (archivo menu_main.xml)
        if (id == R.id.reiniciarPartida) {
            resetearPuntuacion();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
