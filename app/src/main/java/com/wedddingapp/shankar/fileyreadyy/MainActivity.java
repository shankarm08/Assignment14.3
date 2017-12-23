package com.wedddingapp.shankar.fileyreadyy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {




     Button bsave,bcheck;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button bsave=(Button)findViewById(R.id.b1);
       Button bcheck=(Button)findViewById(R.id.b2);

      bsave.setOnClickListener(new View.OnClickListener() {

          public void onClick(View view) {


              try
              {
              FileOutputStream fileOut=openFileOutput("myAndyFile",MODE_PRIVATE);

              //OutputStreamWriter to write in the file.
              OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOut);

              //Writing in file.
              outputStreamWriter.write("Hello!! I am writing file.");

              //closing OutpuutStreamWriter.
              outputStreamWriter.close();

              //Displaying Toast.
              Toast.makeText(getApplicationContext(),"File Saved",Toast.LENGTH_SHORT).show();

          }
            catch (FileNotFoundException e)
          {
              e.printStackTrace();
          }
            catch (IOException e)
          {
              e.printStackTrace();
          }
      }






      });



      bcheck.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {


              try
              {
                  //Checking by opening the file.
                  FileInputStream fileInputStream=openFileInput("myAndyFile");

                  //Displaying Toast.
                  Toast.makeText(getApplicationContext(),"File is present in Internal Storage",Toast.LENGTH_SHORT).show();
              }
              catch (FileNotFoundException e)
              {
                  //Displaying Toast.
                  Toast.makeText(getApplicationContext(),"File is not available in Internal Storage",Toast.LENGTH_SHORT).show();
              }






          }
      });










    }
}
