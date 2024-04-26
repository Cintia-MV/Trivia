package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PreguntaTrivia extends Fragment {


    public PreguntaTrivia() {
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
        return inflater.inflate(R.layout.fragment_pregunta_trivia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener el texto del Bundle
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("nombre")) {
            String nombre = bundle.getString("nombre");

            TextView saludo = view.findViewById(R.id.txtSaludo);
            saludo.setText("Hola, " +nombre);


        }
    }
}