package com.example.phonecall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn= (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent _intentOBJ= new Intent(Intent.ACTION_MAIN);
                _intentOBJ.addCategory(Intent.CATEGORY_HOME);
                _intentOBJ.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                _intentOBJ.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(_intentOBJ);

            }
        });
    }
}
