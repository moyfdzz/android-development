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
 * Use the {@link Basketball#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Basketball extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ScoreViewModel mViewModel;

    public Basketball() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Basketball.
     */
    // TODO: Rename and change types and number of parameters
    public static Basketball newInstance() {
        Basketball fragment = new Basketball();
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

        mViewModel =  new ViewModelProvider(this).get(ScoreViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basketball, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.resetScores();

        Button TA3Points = view.findViewById(R.id.basketballTA3P);
        Button TA2Points = view.findViewById(R.id.basketballTA2P);
        Button TAFreeThrow = view.findViewById(R.id.basketballTAFT);
        Button TB3Points = view.findViewById(R.id.basketballTB3P);
        Button TB2Points = view.findViewById(R.id.basketballTB2P);
        Button TBFreeThrow = view.findViewById(R.id.basketballTBFT);
        Button RB = view.findViewById(R.id.basketballRB);

        TA3Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamA(3);
                displayForTeamA(mViewModel.getScoreTeamA());
            }
        });

        TA2Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamA(2);
                displayForTeamA(mViewModel.getScoreTeamA());
            }
        });

        TAFreeThrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamA(1);
                displayForTeamA(mViewModel.getScoreTeamA());
            }
        });

        TB3Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamB(3);
                displayForTeamB(mViewModel.getScoreTeamB());
            }
        });

        TB2Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.addScoreTeamB(2);
                displayForTeamB(mViewModel.getScoreTeamB());
            }
        });

        TBFreeThrow.setOnClickListener(new View.OnClickListener() {
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