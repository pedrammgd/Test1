package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String MYPRESF = "mypresf";
    public static final String NameKey = "nameKey";
    EditText editText ;
    Button button;
    TextView textView;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




//        textView= findViewById(R.id.textView);
//        textView.setText(R.string.long_text);


        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.edt);
        button = findViewById(R.id.btn);



        sharedPreferences = getSharedPreferences(MYPRESF,MODE_PRIVATE);
        editText.setText(sharedPreferences.getString(NameKey,null));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        int id = item.getItemId();

        if(id  == R.id.hi){


            Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.bye){

            Toast.makeText(this, "bye", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    public void sava(View view) {


        String str = editText.getText().toString();
        editor = sharedPreferences.edit();
        editor.putString(NameKey,str);
        editor.apply();

    }


            }