package com.example.quiz;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RunFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RunFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Double result;

    public RunFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RunFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RunFragment newInstance(String param1, String param2) {
        RunFragment fragment = new RunFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_run, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText ETOp = view.findViewById(R.id.ETOperator);
        EditText ETD1 = view.findViewById(R.id.ETData1);
        EditText ETD2 = view.findViewById(R.id.ETData2);
        Button RB = view.findViewById(R.id.BRun);

        RB.setOnClickListener(view1 -> {
            if (ETOp.getText().toString().isEmpty() || ETD1.getText().toString().isEmpty() || ETD2.getText().toString().isEmpty()) {
                String message = "Por favor llena todas las casillas.";
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
            else {
                String operator = ETOp.getText().toString();
                Double data1 = Double.parseDouble(ETD1.getText().toString());
                Double data2 = Double.parseDouble(ETD2.getText().toString());
                result = returnResult(operator, data1, data2);
                // Modificar TextView cuando se sepa el nombre
            }
        });
    }

    public Double returnResult(String op, Double d1, Double d2) {
        if (op.equals("+")) {
            return d1 + d2;
        }
        else if (op.equals("-")) {
            return d1 - d2;
        }
        else if (op.equals("*")) {
            return d1 * d2;
        }
        else if (op.equals("/")) {
            return d1 / d2;
        }

        return 0.0;
    }
}