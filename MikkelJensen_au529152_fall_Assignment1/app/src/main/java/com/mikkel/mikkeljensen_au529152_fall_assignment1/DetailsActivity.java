package com.mikkel.mikkeljensen_au529152_fall_assignment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsActivity extends AppCompatActivity {

    public static final int RQ_CODE_EDIT = 22;

    Animalitem animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setComponents();
        Buttons();
    }


    private void Buttons(){
        Button btnEdit = (Button)findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this,EditActivity.class);
                intent.putExtra("dataToEdit", (Parcelable) animal);
                startActivityForResult(intent,RQ_CODE_EDIT);
            }
        });

        Button btnCancel;
        btnCancel = (Button)findViewById(R.id.btnCancelDetail);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setComponents(){

        animal = (Animalitem) getIntent().getSerializableExtra("wordSelected");

        TextView tvWord = (TextView) findViewById(R.id.txtWordDetail);
        tvWord.setText(animal.getmWord());

        TextView tvPronounced = (TextView) findViewById(R.id.txtwordPronauncedDetail);
        tvPronounced.setText(animal.getmPronounced());

        TextView tvRating = (TextView) findViewById(R.id.txtRatingDetail);
        tvRating.setText("" + animal.getmRating());

        TextView tvDesc = (TextView) findViewById(R.id.txtDescriptionData);
        tvDesc.setText(animal.getmDescription());

        TextView tvNotes = (TextView) findViewById(R.id.txtNotesDataDetail);
        tvNotes.setText(""+animal.getmNotes());


        String word = animal.getmWord();
        ImageView ivAnimal = findViewById(R.id.imageViewDetailed);
        if (word.contains("Lion")){
            ivAnimal.setImageResource(R.drawable.lion);
        }
        if (word.contains("Leopar")){
            ivAnimal.setImageResource(R.drawable.leopard);
        }
        if (word.contains("Cheeta")){
            ivAnimal.setImageResource(R.drawable.cheetah);
        }
        if (word.contains("Elepha")){
            ivAnimal.setImageResource(R.drawable.elephant);
        }
        if (word.contains("Giraffe")){
            ivAnimal.setImageResource(R.drawable.giraffe);
        }
        if (word.contains("Kudu")){
            ivAnimal.setImageResource(R.drawable.kudu);
        }
        if (word.contains("Gnu")){
            ivAnimal.setImageResource(R.drawable.gnu);
        }
        if (word.contains("Oryx")){
            ivAnimal.setImageResource(R.drawable.oryx);
        }
        if (word.contains("Camel")){
            ivAnimal.setImageResource(R.drawable.camel);
        }
        if (word.contains("Shark")){
            ivAnimal.setImageResource(R.drawable.shark);
        }
        if (word.contains("Crocod")){
            ivAnimal.setImageResource(R.drawable.crocodile);
        }
        if (word.contains("Snake")){
            ivAnimal.setImageResource(R.drawable.snake);
        }
        if (word.contains("Buffalo")){
            ivAnimal.setImageResource(R.drawable.buffalo);
        }
        if (word.contains("Ostrich")){
            ivAnimal.setImageResource(R.drawable.ostrich);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case RQ_CODE_EDIT:
                if (resultCode == Activity.RESULT_OK){
                 animal = (Animalitem) data.getSerializableExtra("dataFromEdit");
                 Intent intent = new Intent(DetailsActivity.this, ListActivity.class);
                 intent.putExtra("dataFromDetail", (Parcelable) animal);
                 setResult(Activity.RESULT_OK,intent);
                 finish();
                }
        }
    }
}
