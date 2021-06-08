package com.example.viewmodelexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);


        Basketball basketfragment = Basketball.newInstance();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Basketball fragment = (Basketball)getSupportFragmentManager().findFragmentById(R.id.contenedor_fragment);

        if (fragment == null) {
            fragmentTransaction.add(R.id.contenedor_fragment,basketfragment).commit();
        }

    }

    @Override
    protected  void onStart() {
        super.onStart();
        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        //scoreTeamA = scoreTeamA + 1;
        mViewModel.addScoreTeamA(1);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
       // scoreTeamA = scoreTeamA + 2;
        //displayForTeamA(scoreTeamA);
        mViewModel.addScoreTeamA(2);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
       // scoreTeamA = scoreTeamA + 3;
        //displayForTeamA(scoreTeamA);
        mViewModel.addScoreTeamA(3);
        displayForTeamA(mViewModel.getScoreTeamA());
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
       // scoreTeamB = scoreTeamB + 1;
     //   displayForTeamB(scoreTeamB);

        mViewModel.addScoreTeamB(1);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
    //    scoreTeamB = scoreTeamB + 2;
    ///    displayForTeamB(scoreTeamB);

        mViewModel.addScoreTeamB(2);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
      //  scoreTeamB = scoreTeamB + 3;
       // displayForTeamB(scoreTeamB);

        mViewModel.addScoreTeamB(3);
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
    //    scoreTeamA = 0;
    //    scoreTeamB = 0;
        mViewModel.resetScores();

        displayForTeamA(mViewModel.getScoreTeamA());
        displayForTeamB(mViewModel.getScoreTeamB());
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}