package com.example.nokukhanya.coffeeshop;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.order;
import static com.example.nokukhanya.coffeeshop.MainActivity.btnTotal;

public class Main2Activity extends AppCompatActivity {

    private Button btnback,btnDone;

    private TextView dataFromMain;

    private TextView orderDetails;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2)
        ;

        dataFromMain = (TextView) findViewById(R.id.textView5);
        orderDetails = (TextView) findViewById(R.id.textView17);
        btnback = (Button) findViewById(R.id.back);
        btnDone =(Button) findViewById(R.id.button2);


        intent = getIntent();

        String totalFromMain = intent.getStringExtra(MainActivity.DATA);
        dataFromMain.setText(totalFromMain);


        String order1 = intent.getStringExtra(MainActivity.CUPPUCINNODETAILS);
        String order2 = intent.getStringExtra(MainActivity.ICEDDETAILS);
        String order3 = intent.getStringExtra(MainActivity.BREWEDDETAILS);
        String order4 = intent.getStringExtra(MainActivity.BOTTOMLESSDETAILS);


        orderDetails.setText(order1 + "\n" + order2 + "\n" + order3 + "\n" + order4);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"THANK YOU,your order will be ready in a jiffy",Toast.LENGTH_LONG ).show();

            }
    });
}
    }




