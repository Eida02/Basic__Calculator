package com.example.eida.calculator;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView txt;
    Button buttonequal,pi;
    String sign="";
    Double val1,val2,num;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt =(TextView) findViewById(R.id.txtt);
        buttonequal=(Button) findViewById(R.id.btne);
        pi=(Button) findViewById(R.id.btnpi);
        buttonequal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                val2=Double.parseDouble(txt.getText().toString());
                if (sign.equals("+"))
                    num=val1+val2;
                else if (sign.equals("-"))
                    num=val1-val2;
                else if (sign.equals("*"))
                    num=val1*val2;
                else if (sign.equals("/"))
                    num=val1/val2;
                txt.setText(num.toString());


            }
        });
            pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txt.setText("3.14159");
                }
            });
        }

    public void Number_Buttons_Clicked(View view)
    {
        Button btn = (Button) view;
        txt.append(btn.getText());
    }
    public void Sign_Buttons_Clicked(View view)
    {
        Button btn = (Button) view;
        sign = btn.getText().toString();
        val1=Double.parseDouble(txt.getText().toString());
        txt.setText("");
    }
    public void Clear_Buttons_Clicked(View view)
    {
        try{
            Button btn = (Button) view;
            if (btn.getText().equals("Delete"))
            {
                txt.setText(txt.getText().toString().substring(0,
                        txt.getText().length() -1));
            }
            else if(btn.getText().equals("C"))
            {
                txt.setText("");
            }
        }catch (Exception ex)
        {
            txt.setText("");
        }
    }
    public void Log_Buttons_Clicked(View view)
    {
        try
        {
            Button btn= (Button) view;
            val1=Double.parseDouble(txt.getText().toString());
            if(btn.getText().equals("Sin"))
                val1=Math.sin(val1);
            else if(btn.getText().equals("Tan"))
                val1=Math.tan(val1);
            else if(btn.getText().equals("Cos"))
                val1=Math.cos(val1);
            txt.setText(val1.toString());
        }
        catch (Exception ex)
        {
            txt.setText("");
        }
    }
}




