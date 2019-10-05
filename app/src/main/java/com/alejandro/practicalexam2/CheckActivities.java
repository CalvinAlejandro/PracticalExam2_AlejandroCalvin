package com.alejandro.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CheckActivities extends AppCompatActivity {

    EditText editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_activities);

        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        FileInputStream reader = null;
        FileInputStream reader2 = null;
        String data = "";
        String data2 = "";
        try {
            reader = openFileInput("activities.txt");
            reader2 = openFileInput("comments.txt");
            int token;
            int token2;
            while((token = reader.read()) != -1)
            {
                data = data + (char)token;
            }

            while((token2 = reader2.read()) != -1)
            {
                data2 = data2 + (char)token2;
            }
        }
        catch (FileNotFoundException fe)
        {
            fe.printStackTrace();
            Log.d("error", "File not found!");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("error", "IO error...");
        }
        String arrData[] = data.split(",");
        for(int i=0;i < arrData.length;i++) {
            editText2.append("\n" + arrData[i]);
        }
        editText3.setText(data2);
    }

    public void sendText(View view)
    {
        Toast.makeText(this, "registration sent...", Toast.LENGTH_LONG).show();
    }

    public void backActivity(View view)
    {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
