package com.alejandro.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        editText = findViewById(R.id.editText);
    }

    public void writeData(View v)
    {
        String chkData = "";
        String comment = editText.getText().toString();
        if(checkBox1.isChecked())
        {
            chkData = chkData + ", " +  checkBox1.getText().toString();
        }
        if(checkBox2.isChecked())
        {
            chkData = chkData + ", " + checkBox2.getText().toString();
        }
        if(checkBox3.isChecked())
        {
            chkData = chkData + ", " + checkBox3.getText().toString();
        }
        if(checkBox4.isChecked())
        {
            chkData = chkData + ", " + checkBox4.getText().toString();
        }
        if(checkBox5.isChecked())
        {
            chkData = chkData + ", " + checkBox5.getText().toString();
        }
        if(checkBox6.isChecked())
        {
            chkData = chkData + ", " + checkBox6.getText().toString();
        }
        if(checkBox7.isChecked())
        {
            chkData = chkData + ", " + checkBox7.getText().toString();
        }
        if(checkBox8.isChecked())
        {
            chkData = chkData + ", " + checkBox7.getText().toString();
        }
        FileOutputStream writer = null;
        FileOutputStream writer2 = null;
        try
        {
            writer = openFileOutput("activities.txt", MODE_PRIVATE);
            writer2 = openFileOutput("comments.txt", MODE_PRIVATE);
            writer.write(chkData.getBytes());
            writer2.write(comment.getBytes());
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
            Log.d("error", "No file found.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
            Log.d("error", "IO error...");
        }
        finally
        {
            try
            {
                writer.close();
                writer2.close();
            } catch (IOException e)
            {
                e.printStackTrace();
                Log.d("error", "IO error");
            }
        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void nextCheck(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CheckActivities.class);
        startActivity(intent);
    }
}
