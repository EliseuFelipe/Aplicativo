package com.example.aplicativo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        int rand = ThreadLocalRandom.current().nextInt(10,2000); // simulation words number from db
        String x = "You reviewed for about " + rand + " words!";
        textView.setText(x);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                view.getContext().startActivity(intent);}
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Main Title!");
        toolbar.setSubtitle("Secondary Title.");

        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String title = (String) item.getTitle(); // get the title of the cliked title
                Toast.makeText(MainActivity.this, title + " Selected!", Toast.LENGTH_SHORT).show();

                switch (item.getItemId()){
                    case R.id.progresso:
                        // mudar meta, acompanhar progresso
                        break;
                    case R.id.sobre:
                        // sobre o aplicativo
                        break;
                }

                // Similarly you can write CASES for other menu item as well
                return true;
            }
        });

    }
}
