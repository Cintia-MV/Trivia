package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trivia.databinding.FragmentInicioTriviaBinding;


public class InicioTrivia extends Fragment {

    private FragmentInicioTriviaBinding inicioBiding;  //Objeto del biding para vincular el layout correspondiente

    //Constructor vacio
    public InicioTrivia() {
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
        inicioBiding = FragmentInicioTriviaBinding.inflate(inflater, container, false);
        return inicioBiding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Botón comenzar
        inicioBiding.btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Capturo el nombre en una variable
                String nombre = inicioBiding.nombre.getText().toString();

                //Bundle para pasar datos al siguiente Fragmento
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre);

                //Navego al fragmento PreguntaTrivia y le paso el nombre traves del bundle
                Navigation.findNavController(inicioBiding.getRoot()).navigate(R.id.action_inicioTrivia_to_preguntaTrivia, bundle);
            }
        });
    }
}