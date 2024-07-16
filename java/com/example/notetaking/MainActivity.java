package com.example.notetaking;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextnote;
    Button buttonaddnote,buttondeletenote;
    int index=0;
    ListView listviewnotes;
    ArrayList<String>noteList;
    ArrayAdapter<String>NotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextnote = findViewById(R.id.editTextNote);
        buttonaddnote = findViewById(R.id.buttonAddNote);
        listviewnotes = findViewById(R.id.listViewNotes);
        buttondeletenote=findViewById(R.id.buttondeletenote);
        buttonaddnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=String.valueOf(editTextnote.getText());
                addNoteToList(text);
            }
        });
        buttondeletenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteNoteFromList(index);
            }
        });

        noteList = new ArrayList<>();
        NotesAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, noteList);
        listviewnotes.setAdapter(NotesAdapter);
    }

        private void addNoteToList(String note){
            noteList.add(note);
            NotesAdapter.notifyDataSetChanged();
        }
        private void deleteNoteFromList(int position) {
            noteList.remove(position);
            NotesAdapter.notifyDataSetChanged();
        }


    }
