package com.example.portfoliotracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAssets extends AppCompatActivity{
    private Button addAssetButton, assetButton;
    private EditText cryptoName, cryptoPrice, quantity;
    private DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_asset);
        addAssetButton = findViewById(R.id.AddAssetButton);
        assetButton = findViewById(R.id.assets4);
        cryptoName = findViewById(R.id.CryptoName);
        cryptoPrice = findViewById(R.id.CryptoPrice);
        quantity = findViewById(R.id.CryptoQuantity);
        addAssetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String crypName;
                crypName = cryptoName.getText().toString();
                double crypPrice = Double.parseDouble(cryptoPrice.getText().toString());
                double crypQuantity = Double.parseDouble(quantity.getText().toString());

                // validating if the text fields are empty or not.
                if (crypName.isEmpty() && crypPrice == 0.0 && crypQuantity == 0.0) {
                    Toast.makeText(AddAssets.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(crypName,crypPrice,crypQuantity);

                // after adding the data we are displaying a toast message.
                Toast.makeText(AddAssets.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                cryptoName.setText("");
                cryptoPrice.setText("");
                quantity.setText("");
            }
        });

        assetButton.setOnClickListener(v -> {
            // opening a new activity via a intent.
            Intent i = new Intent(AddAssets.this, Assets.class);
            startActivity(i);
        });
    }
}
