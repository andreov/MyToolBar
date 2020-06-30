package com.example.mytoolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_open_notes:
                Toast.makeText(MainActivity.this, "Открыть записную книжку", Toast.LENGTH_LONG).show();
                Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intentNotes);
                break;
            case R.id.action_open_pay:
                Toast.makeText(MainActivity.this, "Открыть терминал оплаты", Toast.LENGTH_LONG).show();
                Intent intentPay = new Intent(MainActivity.this, PayActivity.class);
                startActivity(intentPay);
                break;
            case R.id.action_open_calendar:
                Toast.makeText(MainActivity.this, "Открыть календарь задач", Toast.LENGTH_LONG).show();
                Intent intentCal = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intentCal);
                break;
            //return true;
        }

        return super.onOptionsItemSelected(item);
    }
}