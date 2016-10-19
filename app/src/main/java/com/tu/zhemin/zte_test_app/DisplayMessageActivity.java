package com.tu.zhemin.zte_test_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        String fLine=null;
        String sIn;
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // read file and display
        try {
            while ((sIn = MainActivity.bufReader.readLine()) != null) {

                fLine += (sIn + "\n");

                // System.out.println(fline);
//                String[] strs = fLine.trim().split(" ");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView textView = new TextView(this);
        textView.setTextSize(10);
        textView.setText(message + "\n" + fLine);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        if (layout != null) {
            layout.addView(textView);
        }

        if (message.compareTo("end") == 0) {
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
