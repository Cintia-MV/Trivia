package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.trivia.databinding.FragmentPreguntaTriviaBinding;
import com.example.trivia.databinding.FragmentResultadoBinding;


public class Resultado extends Fragment {

    //Variables
    private FragmentResultadoBinding resultadoBinding; //Objeto del biding para vincular el layout correspondiente
    private String nombre;

    //Constructor vacio
    public Resultado() {
        // Required empty public constructor
    }

    //Método onCreate
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    //Método onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar y vincular el layout usando ViewBinding
        resultadoBinding = FragmentResultadoBinding.inflate(inflater, container, false);
        return resultadoBinding.getRoot();
    }

    //Método onViewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Obtener el argumento "nombre" del Bundle
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("nombre")) {
            nombre = bundle.getString("nombre");
        }

        // Obtener el argumento "resultado" pasado desde el fragmento PreguntaTivia
        boolean gano = getArguments().getBoolean("resultado");

        // Mostrar el mensaje correspondiente
        TextView mensajeTextView = view.findViewById(R.id.txtResultado);
        if (gano) {
            mensajeTextView.setText("¡Genial "+nombre+ ", ganaste!");
        } else {
            mensajeTextView.setText("Bueno, te equivocaste " + nombre + ", ¡intentalo otra vez!");
        }

        //Botón volver a intentar
        resultadoBinding.btnIntentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre); //Le paso el nombre nuevamente
                //Navego hacia PreguntaTrivia y le paso el nombre
                Navigation.findNavController(resultadoBinding.getRoot()).navigate(R.id.action_resultado_to_preguntaTrivia, bundle);
            }
        });

        //Botón nuevo jugador
        resultadoBinding.btnNuevoJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Navego hacia InicioTrivia
                Navigation.findNavController(resultadoBinding.getRoot()).navigate(R.id.action_resultado_to_inicioTrivia);
            }
        });





    }
    }
