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

    private FragmentInicioTriviaBinding inicio;




    public InicioTrivia() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inicio = FragmentInicioTriviaBinding.inflate(inflater, container, false);

        return inicio.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inicio.btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Capturo el nombre en una variable
                String nombre = inicio.nombre.getText().toString();

                // Crear un Bundle para pasar datos al siguiente Fragmento
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre);


                Navigation.findNavController(inicio.getRoot()).navigate(R.id.action_inicioTrivia_to_preguntaTrivia, bundle);
            }
        });
    }
}