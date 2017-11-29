/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */

public class MainActivity extends AppCompatActivity {

    // variables

    private int numberOfCoffees = 0;
    private int price = 5;
    private boolean priceTapped = false;
    private String message;

    // methods

    // When the screen is rotated the onCreate method
    // is called again to build up the screen
    // and all of its views

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPrice(numberOfCoffees * price);

        // if savedInstanceState is not empty
        if (savedInstanceState != null){

            // load the variables from the saved state
            // using the "get" command followed by the
            // variable type
            // ** (getInt for integers)
            // ** (getString for strings)
            // ** (getBoolean for booleans)
            //
            // choose the id in the savedStateInstance you
            // assigned your variables to
            //
            // ** e.g.
            // numberOfCoffees = savedInstanceState.getInt("numberOfCoffees");
            //     Variable    =                             ID saved State
            numberOfCoffees = savedInstanceState.getInt("numberOfCoffees");
            price = savedInstanceState.getInt("price");
            priceTapped = savedInstanceState.getBoolean("priceTapped");
            message = savedInstanceState.getString("totalPrice");

            // refresh the textView "quantity_text_view"
            // again with the value, read from the "saved state"
            display(numberOfCoffees);

            // if the order button has been pressed, also refresh the
            // textView "price_text_view", read from the "saved state"

            if (priceTapped){
                displayMessage(message);
            }
        }

    }

    // When the screen rotates, the function
    // onSaveInstanceState is called

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // load the current variables in a "saved state"
        // using the "put" command followed by the
        // variable type
        // ** (putInt for integers)
        // ** (putString for strings)
        // ** (putBoolean for booleans)
        //
        // choose an id in the savedStateInstance you
        // want to assign your variables to followed by the
        // variable you want saved
        //
        // ** e.g.
        // outState.putInt("numberOfCoffees",numberOfCoffees);
        //                  ID saved State  ,    variable
        outState.putInt("numberOfCoffees",numberOfCoffees);
        outState.putInt("price",price);
        outState.putBoolean("priceTapped",priceTapped);
        outState.putString("totalPrice",message);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        message = "€ " + price * numberOfCoffees + " for " + numberOfCoffees + " cups please \nThank you!";
        display(numberOfCoffees);
        priceTapped = true;
        displayMessage(message);
        //displayPrice(numberOfCoffees * price);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method increments the amount of coffees by 1.
     */
    public void increment(View view) {
        numberOfCoffees += 1;
        display(numberOfCoffees);
    }

    /**
     * This method decrements the amount of coffees by 1.
     */
    public void decrement(View view) {
        if (numberOfCoffees>0){
            numberOfCoffees -= 1;
        }
        display(numberOfCoffees);
    }

}