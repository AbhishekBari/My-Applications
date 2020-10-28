package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        //int cofeeQuantity = 100;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       //displayPrice(quantity * 5);
        EditText namefiled = (EditText) findViewById(R.id.name_filed);
        String name = namefiled.getText().toString();

        CheckBox whippedCreamCheckBok = (CheckBox) findViewById(R.id.whipped_cream_CheckBok);
        boolean haswhippedCream = whippedCreamCheckBok.isChecked();
       // Log.v("MainActivity" , "Has whipped Cream" + haswhippedCream);

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_CheckBok);
        boolean hasChocolate = chocolateCheckBox.isChecked();
       // Log.v("MainActivity" , "Has chocolate" + hasChocolate);

        int price = calculatePrice();
        String priceMessage = createOrderSummary(name, price, haswhippedCream, hasChocolate);
       displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     */
     private int calculatePrice(){
         int price = quantity * 5;
         return price;
     }

    /**
     * Displaying Order summary.
     *
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal $ " + price;
        priceMessage += "\nThank You";
        return priceMessage;
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_textView_text_view);
        orderSummaryTextView.setText(message);
    }
}
