package com.mikkel.mikkeljensen_au529152_fall_assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mikkel.mikkeljensen_au529152_fall_assignment1.utils.AnimalAdaptorRV;
import com.mikkel.mikkeljensen_au529152_fall_assignment1.utils.DataMan;

import java.util.ArrayList;
//import com.mikkel.mikkeljensen_au529152_fall_assignment1.adaptors.AnimalAdaptorRV;



public class ListActivity extends AppCompatActivity {

    public static final int RQ_CODE_EDIT = 22;  //inspired by DEMOUI
    //private AnimalAdaptor animalAdaptor;
    private Button btnExit;

    //private ArrayList<Animal> animalList = new ArrayList<>();

    // source https://www.youtube.com/watch?v=17NbUcEts9c&list=PLrnPJCHvNZuBtTYUuc5Pyo4V7xZ2HNtf4&index=2
    private RecyclerView mRecyclerView;
    private AnimalAdaptorRV mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Animalitem> animalList = new ArrayList<>();
    DataMan dataMan = new DataMan(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //animalList.add(new Animalitem(R.drawable.lion,"Lion","LØWE","6.3"));
        animalList = dataMan.addData();
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AnimalAdaptorRV(this,animalList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(1);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putSerializable("animalList",animalList);
    }


    // source https://developer.android.com/training/basics/intents/result#java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       switch (requestCode){
           case RQ_CODE_EDIT:
               if (resultCode == Activity.RESULT_OK){
                   //animalUpdate = (Animal) data.getSerializableExtra("dataFromDetail");
                   //animalList.set(animalUpdate.getIndex(),animalUpdate);

                   //((BaseAdapter)animalListView.getAdapter()).notifyDataSetChanged();
           }
               break;
       }
    }
}