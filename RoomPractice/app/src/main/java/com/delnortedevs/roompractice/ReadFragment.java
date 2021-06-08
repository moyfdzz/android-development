package com.delnortedevs.roompractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.delnortedevs.roompractice.db.TvShow;
import com.delnortedevs.roompractice.db.appDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class ReadFragment extends Fragment {
    private appDatabase database;
    TvShow tempshow;
    public ReadFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        database = appDatabase.getInstance(getActivity());

        EditText buscarNombre, nombre,categoria,score;
        Button button_buscar,button_update, button_delete;

        buscarNombre = view.findViewById(R.id.editText_buscaNombreShow);
        button_buscar = view.findViewById(R.id.btn_buscarShow);
        button_update = view.findViewById(R.id.btn_update);
        button_delete = view.findViewById(R.id.btn_delete);

        nombre = view.findViewById(R.id.editText_ShowName);
        categoria = view.findViewById(R.id.editText_Category);
        score = view.findViewById(R.id.editText_Score);

        button_buscar.setOnClickListener(view1 -> {

            String nombreShow = buscarNombre.getText().toString();

            List<TvShow> show = database.getTvShowDao().SearchByName("%"+nombreShow + "%");

            if (show.size() >0 ){
                TvShow firshow = show.get(0);
                tempshow = firshow;
                nombre.setText(firshow.getName());
                categoria.setText(firshow.getCategory());
                score.setText( String.valueOf(firshow.getScore()));
            }

        });

        button_update.setOnClickListener(view1 -> {

            String showName = nombre.getText().toString();
            String category = categoria.getText().toString();
            Integer tvscore =  Integer.parseInt(score.getText().toString());

            tempshow.setName(showName);
            tempshow.setCategory(category);
            tempshow.setScore(tvscore);

            int update = database.getTvShowDao().updateTvShow(tempshow);

            if (update >0 ){
                Toast.makeText(getActivity(), "Show updated", Toast.LENGTH_SHORT).show();
            }


        });

        button_delete.setOnClickListener(view1 -> {

          int delete =   database.getTvShowDao().deleteTvShow(tempshow);

          if (delete > 0 ){
              Toast.makeText(getActivity(), "Record deleted", Toast.LENGTH_SHORT).show();
          }
          else {
              Toast.makeText(getActivity(), "No Shows with id: " + tempshow.getShow_id(), Toast.LENGTH_SHORT).show();
          }

        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_read, container, false);
    }
}