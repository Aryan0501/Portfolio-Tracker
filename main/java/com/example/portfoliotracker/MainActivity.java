package com.example.portfoliotracker;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public Button addAssetButton;
    public Button marketButton;
    public Button assetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAssetButton = (Button) findViewById(R.id.addAssetsButton);
        addAssetButton.setOnClickListener(view -> openAddAssetPage());

        marketButton = (Button) findViewById(R.id.marketButton);
        marketButton.setOnClickListener(view -> openMarketPage());

        assetButton= (Button) findViewById(R.id.assetsButton);
        assetButton.setOnClickListener(view -> openAddAssetPage());
    }
    public void openAddAssetPage(){
        Intent intent = new Intent(this, AddAssets.class);
        startActivity(intent);
    }
    public void openMarketPage(){
        Intent intent = new Intent(this, Market.class);
        startActivity(intent);
    }
    public void openAssetPage(){
        Intent i = new Intent(this, Assets.class);
        startActivity(i);
    }

}