package com.delnortedevs.roompractice;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.delnortedevs.roompractice.db.TvShow;
import com.delnortedevs.roompractice.db.appDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.Observable;

import io.reactivex.schedulers.Schedulers;


public class CreateFragment extends Fragment {

    private appDatabase database;

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        database = appDatabase.getInstance(getActivity());

        EditText tvshowname, tvcategory, tvscore;
        Button btnAddTvShow;

        tvshowname = view.findViewById(R.id.editText_TvShowName);
        tvcategory = view.findViewById(R.id.editText_Category);
        tvscore = view.findViewById(R.id.editText_Score);

        btnAddTvShow = view.findViewById(R.id.btn_addTvShow);

        btnAddTvShow.setOnClickListener(view1 -> {

            try {
                String showName = tvshowname.getText().toString();
                String category = tvcategory.getText().toString();
                Integer score = Integer.parseInt(tvscore.getText().toString());

                //Log.i("INFO", showName + category + score);

                TvShow show = new TvShow(showName, category, score);


                database.getTvShowDao().insertTvShowNMT(show).subscribeOn(Schedulers.io()).subscribe(newshow -> {


                }, throwable -> {
                    Log.i("error",throwable.toString());
                }  );

                //Toast.makeText(getActivity(), "New Show added", Toast.LENGTH_SHORT).show();

             //   Long id = database.getTvShowDao().insertTvShow(show);

               /* if (id > 0) {
                    Toast.makeText(getActivity(), "New Show added", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Hubo error al crear el show", Toast.LENGTH_SHORT).show();
                }*/

            } catch (Exception e){
                Log.i("error", e.toString());
            }

        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false);
    }
}