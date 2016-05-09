package com.android.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView coffeesTextView;
    private TextView priceTextView;
    private int numberOfCoffees = 0;
    private float coffeeUnitRate = 2;
    private boolean whippedCream;

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
        String formattedPrice = NumberFormat
                .getCurrencyInstance()
                .format(numberOfCoffees * coffeeUnitRate);

        StringBuffer strBuffer = new StringBuffer();
        strBuffer
                .append("Name: Osama Alwash\r\n")
                .append("Whipped? ")
                .append(whippedCream)
                .append("\r\n")
                .append("Quantity: ")
                .append(numberOfCoffees)
                .append("\r\n")
                .append("Total Price: ")
                .append(formattedPrice)
                .append("\r\n")
                .append("Thank you! <3");

        priceTextView.setText
                (strBuffer);
    }

    public void decreaseCoffee(View view) {
        numberOfCoffees--;
        checkNumberOfCoffee();
        displayCoffeeToUI();
    }

    private void checkNumberOfCoffee() {
        if (numberOfCoffees < 0) numberOfCoffees = 0;
    }

    public void increaseCoffee(View view) {
        numberOfCoffees++;
        displayCoffeeToUI();
    }

    public void orderCoffee(View view) {
        displayPriceToUI();
    }

    public void whippedCreamClicked(View view) {
        whippedCream = ((CheckBox) view).isChecked();
    }
}
