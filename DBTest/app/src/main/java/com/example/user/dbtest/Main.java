package com.example.user.dbtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main extends AppCompatActivity {
    EditText e1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=(EditText)findViewById(R.id.e1);
        t1=(TextView) findViewById(R.id.t1);

    }

    public void write(View view) {
        String s=e1.getText().toString();
        FileOutputStream fos=null;
        try {
            fos = openFileOutput("Input.txt", Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw;
        osw=new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        try {
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(View view) {
        InputStream is=null;
        try {
            is = openFileInput("Input.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader tmp=new InputStreamReader(is);
        BufferedReader reader= new BufferedReader(tmp);
        String str;
        StringBuffer buffer = new StringBuffer();
        try {
            while ((str=reader.readLine()) != null) buffer.append(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t1.setText(buffer);
    }
}
