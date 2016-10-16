package com.tu.zhemin.zte_test_app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        if (layout != null) {
            layout.addView(textView);
        }

        if (message.compareTo("end") == 0)
        {
            DisplayMessageActivity.this.finishAffinity();
            System.exit(0);
        }
    }

    /**
     * Called when the user pushes the Back button
     */
    public void goBackToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
//        EditText editText = (EditText) findViewById(R.id.edit_message);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);

//        filePrint.println("ZTU's file\n");

//        filePrint.close();

        startActivity(intent);
    }
}
