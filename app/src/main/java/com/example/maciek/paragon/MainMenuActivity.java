package com.example.maciek.paragon;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
    String seller, date, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageButton cameraButton = (ImageButton)findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(this);

        final EditText sellerInput = (EditText) findViewById(R.id.sellerInput);
        final EditText dateInput = (EditText) findViewById(R.id.dateInput);
        EditText priceInput = (EditText) findViewById(R.id.priceInput);

        priceInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    //Process data in the future
                    seller = sellerInput.getText().toString();
                    date = dateInput.getText().toString();
                    price = v.getText().toString();
                    Toast.makeText(MainMenuActivity.this, "PROCESSING: " + seller + date + price, Toast.LENGTH_LONG).show();

                    createNewEntry();

                    //close keyboard
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return handled;
            }
        });


    }
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.cameraButton:
                Intent i = new Intent(getApplicationContext(), GetInfoFromReceiptActivity.class);
                startActivity(i);
                //Toast.makeText(GetInfoFromReceiptActivity.this, "TRYING TO FLASH", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void createNewEntry() {
        TableLayout table = (TableLayout)findViewById(R.id.table);
        TableRow row = new TableRow(this);
        TextView sellerTextView = new TextView(this);
        TextView dateTextView = new TextView(this);
        TextView priceTextView = new TextView(this);
        sellerTextView.setText(seller);
        dateTextView.setText(date);
        priceTextView.setText(price);
        row.addView(sellerTextView);
        row.addView(dateTextView);
        row.addView(priceTextView);
        table.addView(row);
    }
}
