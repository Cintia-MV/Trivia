package com.example.trivia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trivia.databinding.FragmentPreguntaTriviaBinding;


public class PreguntaTrivia extends Fragment {

    //Variables
    private FragmentPreguntaTriviaBinding preguntaBiding; //Objeto del biding para vincular el layout correspondiente
    private String nombre;
    private int respuesta = 2; //indice de la respuesta correcta

    //Constructor vacío
    public PreguntaTrivia() {
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
        preguntaBiding = FragmentPreguntaTriviaBinding.inflate(inflater, container, false);
        return preguntaBiding.getRoot();
    }

    //Método onViewCreated
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener el texto que estoy pasando desde el fragmento InicioTrivia a traves del Bundle
        Bundle bundle = getArguments();

        if (bundle != null && bundle.containsKey("nombre")) { //confirmo que el bundle no viene nulo y confirmo que contenga la clave "nombre"
            nombre = bundle.getString("nombre"); //Obtengo el nombre

            TextView saludo = view.findViewById(R.id.txtSaludo); //Selecciono el textview dónde irá el mensaje con el nombre
            saludo.setText("Hola, " + nombre); //Seteo el textview con el texto que quiero mostrar

        }

        //Botón enviar
        preguntaBiding.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Obtener la instancia del RadioGroup
                RadioGroup radioGroup = preguntaBiding.radioGroup;


                if (radioGroup.getCheckedRadioButtonId() != -1) { //Si no selecciono ningún radiobutton me devuelve -1

                    // Obtener el ID del RadioButton seleccionado
                    int id = radioGroup.getCheckedRadioButtonId();

                    // Encontrar el índice del rediobutton seleccionado
                    int index = preguntaBiding.radioGroup.indexOfChild(preguntaBiding.radioGroup.findViewById(id));


                    // Imprimo el indice en la consola para confirmar
                    Log.d("RadioButton ID", "ID del RadioButton seleccionado: " + index);


                    // Verifico que el indice seleccionado es igual a la respuesta que espero
                    boolean gano = index == respuesta;

                    // Navegar al fragmento de resultado, pasando el argumento "gano"
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("resultado", gano);
                    bundle.putString("nombre", nombre);

                    Log.d("Nombre", "Nombre: " + nombre); //Para confirmar que nombre voy a enviar al resultado

                    //Navego al fragmento resultado y le paso el nombre y resultado a traves del bundle
                    Navigation.findNavController(view).navigate(R.id.action_preguntaTrivia_to_resultado, bundle);

                } else {
                    // Mostrar mensaje de que no se seleccionó ninguna respuesta
                    Toast.makeText(getContext(), "Seleccione una respuesta", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}