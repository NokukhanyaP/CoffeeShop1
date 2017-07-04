package com.example.nokukhanya.coffeeshop;

import android.content.Intent;
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
import static com.example.nokukhanya.coffeeshop.R.id.exit;
import static com.example.nokukhanya.coffeeshop.R.id.total;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static CheckBox chkIced;
    static CheckBox chkCappucinno;
    static CheckBox chkBottomless;
    static CheckBox chkBrewed;

    static Button btnTotal;
    private Button btnClear;
    private Button btnExit;


    static TextView txtTotal;

    static EditText EDiced;
    static EditText EDcappucinno;
    static EditText EDbottomless;
    static EditText EDbrewed;

    //EditText for toppings
    static EditText editIced;
    static EditText editCuppuccino;
    static EditText editBottomless;
    static EditText editBrewed;

    public static  final String DATA="data";
    public static final String ICEDDETAILS="iced";
    public static final String CUPPUCINNODETAILS="Cappucinno";
    public static final String BOTTOMLESSDETAILS="Bottomless";
    public static final String BREWEDDETAILS ="Brewed";

    Double totalAMT = 0.0;

    int quan=0;

    int IcedCoffee = 45;
    int Cuppucinno = 40;
    int BottomlessCoffee = 30;
    int BrewedCoffee = 35;



    String iceddetails;
    String CappucinnoDetails;
    String BottomlessDetails;
    String BrewedDetails;

    String toppingIced;
    String toppingCuppucinno;
    String toppingBottomless;
    String toppingBrewed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkIced = (CheckBox) findViewById(R.id.checkBox);
        chkCappucinno = (CheckBox) findViewById(R.id.checkBox2);
        chkBottomless = (CheckBox) findViewById(R.id.checkBox3);
        chkBrewed = (CheckBox) findViewById(R.id.checkBox4);

        btnTotal = (Button) findViewById(R.id.total);
        btnTotal.setOnClickListener(this);

        btnExit = (Button) findViewById(exit);

        EDiced = (EditText) findViewById(R.id.editText1);
        EDcappucinno = (EditText) findViewById(R.id.editText5);
        EDbottomless = (EditText) findViewById(R.id.editText6);
        EDbrewed = (EditText) findViewById(R.id.ediText4);

        editIced = (EditText) findViewById(R.id.editText);
        editCuppuccino = (EditText) findViewById(R.id.editText4);
        editBottomless = (EditText) findViewById(R.id.editText7);
        editBrewed = (EditText) findViewById(R.id.editText3);


        txtTotal = (TextView) findViewById(R.id.textView13);

           btnTotal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                   if(chkIced.isChecked())
                   {
                       quan= Integer.parseInt(EDiced.getText().toString());
                        toppingIced=editIced.getText().toString();


                        if(toppingIced.equals(""))
                        {
                            iceddetails=""+quan+" Iced Coffee";

                        }else
                        {
                            iceddetails=" "+quan+" Iced Coffee"+" with "+toppingIced;

                        }

                       double res=IcedCoffee*quan;

                       totalAMT+=Double.parseDouble(String.valueOf(res));
                       txtTotal.setText("R"+ totalAMT);

                   }else {
                       iceddetails = "";

                   }
                   if(chkCappucinno.isChecked()) {
                       quan = Integer.parseInt(EDcappucinno.getText().toString());
                       toppingCuppucinno = editCuppuccino.getText().toString();

                       if (toppingCuppucinno.equals("")) {
                           CappucinnoDetails = " " + quan + " Cappucinno";
                       } else

                       {
                           CappucinnoDetails = "" + quan + " Cappucinno" + "with " + toppingCuppucinno;

                           totalAMT += Double.parseDouble(String.valueOf(Cuppucinno * quan));


                       }
                   }else{
                       CappucinnoDetails = "";
                   }

                   if(chkBottomless.isChecked()) {
                       quan = Integer.parseInt(EDbottomless.getText().toString());
                       toppingBottomless = editBottomless.getText().toString();

                       if (toppingBottomless.equals("")) {
                           BottomlessDetails = " " + quan + " Bottomless";
                       } else

                       {
                           BottomlessDetails = " " + quan + " Bottomless" + "with " + toppingBottomless;


                           totalAMT += Double.parseDouble(String.valueOf(BottomlessCoffee * quan));


                       }
                   }else{
                       BottomlessDetails = "";
                   }

                   if(chkBrewed.isChecked()) {
                       quan = Integer.parseInt(EDbrewed.getText().toString());
                       toppingBrewed = editBrewed.getText().toString();

                       if (toppingBrewed.equals("")) {
                           BrewedDetails = " " + quan + " Brewed";
                       } else {
                           BrewedDetails = "" + quan + " Brewed Coffee" + "with " + toppingBrewed;
                           totalAMT += Double.parseDouble(String.valueOf(BrewedCoffee * quan));
                       }
                   }else {
                       BrewedDetails = "";
                   }



                    txtTotal.setText("R"+ String.valueOf(totalAMT));


                    //  convert Double into a String

                    String data= String.valueOf(totalAMT);

                    // moving from one activity to second Activity
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                    // put data of type String inside a Constant DATA
                    intent.putExtra(DATA,data);
                    intent.putExtra(ICEDDETAILS,iceddetails);
                    intent.putExtra(CUPPUCINNODETAILS,CappucinnoDetails);
                    intent.putExtra(BOTTOMLESSDETAILS,BottomlessDetails);
                    intent.putExtra(BREWEDDETAILS,BrewedDetails);




                    startActivity(intent);

                    iceddetails="";
                    CappucinnoDetails="";
                    BottomlessDetails="";
                    BrewedDetails="";
                    totalAMT=0.0;
                    quan=0;

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

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }

        });
    }

    @Override
    public void onClick(View v) {
       if(v.getId()==R.id.total){




        }

    }
}




