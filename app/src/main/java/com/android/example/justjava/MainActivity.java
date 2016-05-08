package com.android.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView coffeesTextView;
    private TextView priceTextView;
    private int numberOfCoffees = 0;
    private float coffeeUnitRate = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeesTextView = (TextView) findViewById(R.id.quantityTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);

        displayCoffeeToUI();
    }

    private void displayCoffeeToUI() {
        coffeesTextView.setText("" + numberOfCoffees);
    }

    private void displayPriceToUI() {
        priceTextView.setText
                (NumberFormat.getCurrencyInstance().format(numberOfCoffees * coffeeUnitRate));
    }

    public void decreaseCoffee(View view) {
        numberOfCoffees--;
        checkNumberOfCoffee();
    }

    private void checkNumberOfCoffee() {
        if (numberOfCoffees < 0) numberOfCoffees = 0;
    }

    public void increaseCoffee(View view) {
        numberOfCoffees++;
    }

    public void orderCoffee(View view) {
        displayPriceToUI();
    }
}
