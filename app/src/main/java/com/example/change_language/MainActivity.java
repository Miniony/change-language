package com.example.change_language;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.change_language.LocaleManager.setNewLocale;

public class MainActivity extends BaseActivity {
    FloatingActionButton mAddPersonFab;
boolean feduk=false;
//if elsin isleysi boolen sony isledya

    int changer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changer = prefconfig.loadStateAll(getApplicationContext());
        //prefcon almaly

        if (changer == 0) {
            setNewLocale(getApplicationContext(), LocaleManager.RUSSIAN);
        } else {
            setNewLocale(getApplicationContext(), LocaleManager.TURKMEN);
        }
        //pref islemek un


        mAddPersonFab = findViewById(R.id.add_person_fab);
        mAddPersonFab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Person added", Toast.LENGTH_SHORT).show();
                if(changer == 0){
                    setNewLocale(getApplicationContext(), LocaleManager.RUSSIAN);
                    changer = 1;
                } else {
                    setNewLocale(getApplicationContext(), LocaleManager.TURKMEN);
                    changer = 0;

                }

                prefconfig.saveStateAll(getApplicationContext(), changer);

                recreate();

                //sahypany tazeleyar
            }
        });
    }
}