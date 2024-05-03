package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        myPreferenceRef = getSharedPreferences("MyAppPreferenceString", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        TextView textView = findViewById(R.id.textview1);
        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("==>","Lets go!");
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", "Välkommen! :D"); // Optional
                intent.putExtra("number", 55); // Optional
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        super.onResume();
        myPreferenceRef = getSharedPreferences("MyAppPreferenceString", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();


        TextView prefTextRef=new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.textview1);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));
        Log.d("Hej", myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));
    }
}

