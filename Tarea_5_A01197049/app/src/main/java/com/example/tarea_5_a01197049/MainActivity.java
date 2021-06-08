package com.example.tarea_5_a01197049;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tarea_5_a01197049.db.AppDatabase;
import com.example.tarea_5_a01197049.db.Note;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;
    private String result;
    private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDatabase.getInstance(this);
        Button BSave = findViewById(R.id.BSave);
        Button BDelete = findViewById(R.id.BDelete);
        EditText ETNote = findViewById(R.id.ETNote);

        ETNote.setBackgroundColor(Color.parseColor("#fbf0cd"));
        ETNote.setTextColor(Color.parseColor("#2b2b2b"));

        List<Note> notes = database.getNoteDAO().AllNotes();

        if (!notes.isEmpty()) {
            ETNote.setText(notes.get(0).getContent());
        }

        BSave.setOnClickListener(view1 -> {
            try {
                // Si ya se guardó una nota antes, se saca la nota guardada y se actualiza
                // con el contenido del EditText.
                if (!notes.isEmpty()) {
                    Note note = notes.get(0);

                    note.setContent(ETNote.getText().toString());

                    int update = database.getNoteDAO().updateNote(note);

                    if (update > 0) {
                        result = "Nota guardada correctamente";
                    }
                    else {
                        result = "Hubo un error al intentar guardar la nota.";
                    }

                    Toast.makeText(getApplicationContext(), result, duration).show();

                    return;
                }

                // Si no se ha guardado una nota antes, se crea una nota utilizando el constructor
                // usando el contenido del EditText como parametro para el contenido de la nota.
                Note note = new Note(ETNote.getText().toString());

                Long id = database.getNoteDAO().insertNote(note);

                if (id > 0) {
                    result = "Nota guardada correctamente";
                }
                else {
                    result = "Hubo un error al intentar guardar la nota.";
                }

                Toast.makeText(getApplicationContext(), result, duration).show();
            }
            catch (Exception e) {
                Log.i("error", e.toString());
            }
        });

        BDelete.setOnClickListener(view1 -> {
            try {
                // Si ya se ha guardado una nota, se saca la nota guardada, se utiliza el método delete
                // y se elimina el texto del EditText.
                if (!notes.isEmpty()) {
                    Note note = notes.get(0);

                    int id = database.getNoteDAO().deleteNote(note);

                    ETNote.setText("");

                    if (id > 0) {
                        result = "Nota eliminada correctamente.";
                    }
                    else {
                        result = "Hubo un error al intentar eliminar la nota.";
                    }

                    Toast.makeText(getApplicationContext(), result, duration).show();

                    return;
                }

                // Si no se ha guardado una nota, solo se elimina el contenido del EditText
                ETNote.setText("");

                result = "Nota eliminada correctamente.";

                Toast.makeText(getApplicationContext(), result, duration).show();
            }
            catch (Exception e) {
                Log.i("error", e.toString());
            }
        });
    }
}