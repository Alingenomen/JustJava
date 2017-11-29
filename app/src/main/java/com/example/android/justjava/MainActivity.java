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

    // methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayPrice(numberOfCoffees * price);

        // if savedInstance is not empty, load the variables from the saved state and refresh
        // the textView "quantity_text_view"

        if (savedInstanceState != null){
            numberOfCoffees = savedInstanceState.getInt("numberOfCoffees");
            price = savedInstanceState.getInt("price");
            priceTapped = savedInstanceState.getBoolean("priceTapped");
            display(numberOfCoffees);

            // if the order button has been pressed, also refresh the
            // textView "price_text_view"

            if (priceTapped){
                displayPrice(numberOfCoffees * 5);
            }
        }
    }

    // Put the variables in a saved state to be restored later

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("numberOfCoffees",numberOfCoffees);
        outState.putInt("price",price);
        outState.putBoolean("priceTapped",priceTapped);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//      display(numberOfCoffees);
        priceTapped = true;
        displayPrice(numberOfCoffees * price);
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