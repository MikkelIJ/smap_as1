package com.mikkel.mikkeljensen_au529152_fall_assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {

    private Animalitem animal;
    private TextView tvRating;
    private TextView tvWord;
    private SeekBar seekBar;
    private EditText etNotes;
    private Button btnCancel;
    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        tvWord = (TextView) findViewById(R.id.txtWordEdit);
        tvRating = (TextView) findViewById(R.id.txtRatingDetailData);
        etNotes = (EditText) findViewById(R.id.txtEditNotesData);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        btnCancel = (Button) findViewById(R.id.btnCancelEdit);
        btnOK = (Button) findViewById(R.id.btnOK);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                animal.setmRating(""+(double)progress/10);
                tvRating.setText(animal.getmRating());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.setmNotes(etNotes.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("dataFromEdit", (Parcelable) animal);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        setComponents();
    }

    private void setComponents(){
        animal = (Animalitem) getIntent().getSerializableExtra("dataToEdit");
        tvWord.setText(animal.getmWord());
        etNotes.setText(animal.getmNotes());
    }
}
