package com.android.example.justjava;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView coffeesTextView;
    private TextView priceTextView;
    private EditText customerNameEditText;
    private int numberOfCoffees = 0;
    private float coffeeUnitRate = 5;
    private float whippedCreamRate = 1;
    private float chocolateRate = 2;
    private boolean whippedCream;
    private boolean chocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coffeesTextView = (TextView) findViewById(R.id.quantityTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        customerNameEditText = (EditText) findViewById(R.id.customerNameEditText);

        displayCoffeeToUI();
    }

    private void displayCoffeeToUI() {
        coffeesTextView.setText(String.valueOf(numberOfCoffees));
    }

    private void displayOrderSummary() {
        StringBuffer strBuffer = getOrderSummary(getPriceSummary());

        priceTextView.setText
                (strBuffer);
    }

    private String getPriceSummary() {
        float finalUniteRate = coffeeUnitRate;
        if (whippedCream) finalUniteRate += whippedCreamRate;
        if (chocolate) finalUniteRate += chocolateRate;

        float totalPrice = numberOfCoffees * finalUniteRate;

        return NumberFormat.getCurrencyInstance().format(totalPrice);
    }

    @NonNull
    private StringBuffer getOrderSummary(String formattedPrice) {
        StringBuffer strBuffer = new StringBuffer();
        strBuffer
                .append("Name: ")
                .append(getCustomerName())
                .append("\r\n")
                .append("Add Whipped Cream? ")
                .append(whippedCream)
                .append("\r\n")
                .append("Add Chocolate? ")
                .append(chocolate)
                .append("\r\n")
                .append("Quantity: ")
                .append(numberOfCoffees)
                .append("\r\n")
                .append("Total Price: ")
                .append(formattedPrice)
                .append("\r\n")
                .append("Thank you! <3");
        return strBuffer;
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
        displayOrderSummary();
    }

    public void whippedCreamClicked(View view) {
        whippedCream = ((CheckBox) view).isChecked();
    }

    public void chocolateClicked(View view) {
        chocolate = ((CheckBox) view).isChecked();
    }

    public String getCustomerName() {
        return customerNameEditText.getText().toString();
    }
}
