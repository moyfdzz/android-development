package com.example.tarea_4_a01197049;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Soccer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Soccer extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ScoreViewModel mViewModel;

    public Soccer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Soccer.
     */
    // TODO: Rename and change types and number of parameters
    public static Soccer newInstance() {
        Soccer fragment = new Soccer();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }

        mViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_soccer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.resetScores();

        Button TAGoal = view.findViewById(R.id.soccerTAG);
        Button TBGoal = view.findViewById(R.id.soccerTBG);
        Button RB = view.findViewById(R.id.soccerRB);

        TAGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamA(1);
                displayForTeamA(mViewModel.getScoreTeamA());
            }
        });

        TBGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamB(1);
                displayForTeamB(mViewModel.getScoreTeamB());
            }
        });

        RB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.resetScores();

                displayForTeamA(mViewModel.getScoreTeamA());
                displayForTeamB(mViewModel.getScoreTeamB());
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) getActivity().findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) getActivity().findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}