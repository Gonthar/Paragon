package com.example.maciek.paragon;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
    String seller, date, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ImageButton cameraButton = (ImageButton) findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(this);

//        final EditText sellerInput = (EditText) findViewById(R.id.sellerInput);
//        final EditText dateInput = (EditText) findViewById(R.id.dateInput);
//        EditText priceInput = (EditText) findViewById(R.id.priceInput);

//        priceInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                boolean handled = false;
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    //Process data in the future
//                    seller = sellerInput.getText().toString();
//                    date = dateInput.getText().toString();
//                    price = v.getText().toString();
//                    Toast.makeText(MainMenuActivity.this, "PROCESSING: " + seller + date + price, Toast.LENGTH_LONG).show();
//
//                    createNewEntry();
//
//                    //close keyboard
//                    InputMethodManager inputManager = (InputMethodManager)
//                            getSystemService(Context.INPUT_METHOD_SERVICE);
//                    inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
//
//                    handled = true;
//                }
//                return handled;
//            }
//        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cameraButton:
                Intent i = new Intent(getApplicationContext(), GetInfoFromReceiptActivity.class);
                startActivity(i);
                //Toast.makeText(GetInfoFromReceiptActivity.this, "TRYING TO FLASH", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void createNewEntry() {
        TableRow row = (TableRow) LayoutInflater.from(MainMenuActivity.this).inflate(R.layout.receipt_entry, null);
        TableRow divider = (TableRow) LayoutInflater.from(MainMenuActivity.this).inflate(R.layout.cell_divider, null);
        TableLayout table = (TableLayout) findViewById(R.id.table);


        TextView sellerLabel = (TextView)row.findViewById(R.id.sellerLabel);
        sellerLabel.setText("Kamila i Roman");
        TextView dateLabel = (TextView)row.findViewById(R.id.dateLabel);
        dateLabel.setText("12/14/2001");
        TextView priceLabel = (TextView)row.findViewById(R.id.priceLabel);
        priceLabel.setText("23,59 PLN");
        table.addView(row);
        table.addView(divider);
    }

    public TextView createNewTextField(String text) {
        TextView textField = new TextView(this);
        textField.setText(text);
        textField.setGravity(Gravity.CENTER_HORIZONTAL);
        textField.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        int color =
                getBaseContext().getResources().getColor(R.color.emerald);
        textField.setTextColor(color);
        return textField;
    }

    public void addNewEntry(View v) {
        Intent intent = new Intent(this, NewEntryActivity.class);
        startActivity(intent);
    }
}
