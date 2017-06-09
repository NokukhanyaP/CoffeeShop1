package com.example.nokukhanya.coffeeshop;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.x;
import static android.R.id.edit;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.webkit.ConsoleMessage.MessageLevel.LOG;
import static com.example.nokukhanya.coffeeshop.R.id.clear;
import static com.example.nokukhanya.coffeeshop.R.id.exit;
import static com.example.nokukhanya.coffeeshop.R.id.total;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkIced;
    private CheckBox chkCappucinno;
    private CheckBox chkBottomless;
    private CheckBox chkBrewed;

    private Button btnTotal;
    private Button btnClear;
    private Button btnExit;

    private TextView txtTotal;

    private EditText EDiced;
    private EditText EDcappucinno;
    private EditText EDbottomless;
    private EditText EDbrewed;

    int IcedCoffee = 45;
    int Cuppucinno = 40;
    int BottomlessCoffee = 30;
    int BrewedCoffee = 35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkIced = (CheckBox) findViewById(R.id.checkBox);
        chkCappucinno = (CheckBox) findViewById(R.id.checkBox2);
        chkBottomless = (CheckBox) findViewById(R.id.checkBox3);
        chkBrewed = (CheckBox) findViewById(R.id.checkBox4);

        btnTotal = (Button) findViewById(total);
        btnClear = (Button) findViewById(clear);
        btnExit = (Button) findViewById(exit);


        EDiced = (EditText) findViewById(R.id.editText1);
        EDcappucinno = (EditText) findViewById(R.id.editText5);
        EDbottomless = (EditText) findViewById(R.id.editText6);
        EDbrewed = (EditText) findViewById(R.id.ediText4);


        txtTotal = (TextView) findViewById(R.id.textView13);


        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total = 0.0;

                //checkBox for Iced Coffee

                if (chkIced.isChecked()) {
                    total = Double.valueOf(EDiced.getText().toString());
                    txtTotal.setText("R" + Double.toString(total * IcedCoffee));

                    if (chkIced.isChecked() && chkCappucinno.isChecked()) {
                        Double x = Double.valueOf(EDiced.getText().toString()) * IcedCoffee;
                        Double y = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));

                    }
                    if (chkIced.isChecked() && chkBottomless.isChecked()) {
                        Double x = Double.valueOf(EDiced.getText().toString()) * IcedCoffee;
                        Double y = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));
                    }
                    if (chkIced.isChecked() && chkBrewed.isChecked()) {
                        Double x = Double.valueOf(EDiced.getText().toString()) * IcedCoffee;
                        Double y = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));
                    }
                    // if 3 checkboxes are checked
                    if (chkIced.isChecked() && chkBrewed.isChecked() && chkBottomless.isChecked()) {
                        Double x = Double.valueOf(EDiced.getText().toString()) * IcedCoffee;
                        Double y = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                        Double z = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                        total = x + y + z;
                        txtTotal.setText("R" + Double.toString(total));
                    }
                    if (chkIced.isChecked() && chkBrewed.isChecked() && chkCappucinno.isChecked()) {
                        Double x = Double.valueOf(EDiced.getText().toString()) * IcedCoffee;
                        Double y = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                        Double z = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                        total = x + y + z;
                        txtTotal.setText("R" + Double.toString(total));
                    }
                    if (chkCappucinno.isChecked() && chkBrewed.isChecked() && chkBottomless.isChecked()) {
                        Double x = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                        Double y = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                        Double z = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                        total = x + y + z;
                        txtTotal.setText("R" + Double.toString(total));
                    }

                    //checkBox for Cappucinno
                }
                if (chkCappucinno.isChecked()) {
                    total = Double.valueOf(EDcappucinno.getText().toString());
                    txtTotal.setText("R" + Double.toString(total * Cuppucinno));

                    if (chkCappucinno.isChecked() && chkBrewed.isChecked()) {
                        Double x = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                        Double y = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));

                    }
                    if (chkCappucinno.isChecked() && chkBottomless.isChecked()) {
                        Double x = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                        Double y = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));

                    }

                    //checkBox for Iced Bottomless Coffee

                }
                if (chkBottomless.isChecked()) {
                    total = Double.parseDouble(EDbottomless.getText().toString());
                    txtTotal.setText("R" + Double.toString(total * BottomlessCoffee));

                    if (chkBottomless.isChecked() && chkBrewed.isChecked()) {
                        Double x = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                        Double y = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));
                    }

                    if (chkBottomless.isChecked() && chkCappucinno.isChecked()) {
                        Double x = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                        Double y = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                        total = x + y;
                        txtTotal.setText("R" + Double.toString(total));


                        //checkBox for Brewed Coffee
                    }
                    if (chkBrewed.isChecked()) {
                        total = Double.parseDouble(EDbrewed.getText().toString());
                        txtTotal.setText("R" + Double.toString(total * BrewedCoffee));

                        if (chkBrewed.isChecked() && chkBottomless.isChecked()) {
                            Double x = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                            Double y = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                            total = x + y;
                            txtTotal.setText("R" + Double.toString(total));
                        }

                        if (chkBrewed.isChecked() && chkCappucinno.isChecked()) {
                            Double x = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                            Double y = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                            total = x + y;
                            txtTotal.setText("R" + Double.toString(total));

                        }
                        // if all checkboxes are checked
                        if (chkCappucinno.isChecked() && chkIced.isChecked() && chkBottomless.isChecked() && chkBrewed.isChecked()) {
                            double w = Double.valueOf(EDiced.getText().toString()) * IcedCoffee;
                            Double x = Double.valueOf(EDbrewed.getText().toString()) * BrewedCoffee;
                            Double y = Double.valueOf(EDcappucinno.getText().toString()) * Cuppucinno;
                            Double z = Double.valueOf(EDbottomless.getText().toString()) * BottomlessCoffee;
                            total = w + x + y + z;
                            txtTotal.setText("R" + Double.toString(total));
                        }

                    }
                }


            }
        });

        chkIced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chkIced.isChecked()) {
                    EDiced.setText("R45.00");
                } else {
                    EDiced.setText("");
                }
            }
        });
        chkCappucinno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chkCappucinno.isChecked()) {
                    EDcappucinno.setText("R40.00");
                } else {
                    EDcappucinno.setText("");

                }
            }


        });

        chkBottomless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chkBottomless.isChecked()) {
                    EDbottomless.setText("R30.00");
                } else {
                    EDbottomless.setText("");


                }
            }
        });

        chkBrewed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!chkBrewed.isChecked()) {
                    EDbrewed.setText("R35.00");
                } else {
                    EDbrewed.setText("");
                }

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnClear.isClickable()) {
                    txtTotal.setText("");

                }

            }
        });
    }
}


