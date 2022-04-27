package com.example.portfoliotracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Assets extends AppCompatActivity {
    private Button marketButton;

    private ArrayList<AssetModel> assetModelArrayList;
    private DbHandler dbHandler;
    private AssetRVAdapter assetRVAdapter;
    private RecyclerView assetRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assets);

        marketButton = (Button) findViewById(R.id.marketButton);
        marketButton.setOnClickListener(view -> openMarketPage());

        assetModelArrayList = new ArrayList<>();
        dbHandler = new DbHandler(Assets.this);

        // getting our course array
        // list from db handler class.
        assetModelArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        assetRVAdapter = new AssetRVAdapter(assetModelArrayList, Assets.this);
        assetRV = findViewById(R.id.idRVCourses);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Assets.this, RecyclerView.VERTICAL, false);
        assetRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        assetRV.setAdapter(assetRVAdapter);
    }
        public void openMarketPage(){
            Intent intent = new Intent(this, Market.class);
            startActivity(intent);
        }




}
