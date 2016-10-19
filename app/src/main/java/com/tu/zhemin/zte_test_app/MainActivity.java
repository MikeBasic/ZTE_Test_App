package com.tu.zhemin.zte_test_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import static android.R.attr.path;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
//    public File dataFile = null;
    public static BufferedReader bufReader = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check external storage and create the data file
        if (isExternalStorageWritable()) {
            bufReader = getDataStorageFile("ctest.txt");
        }

//        if (dataFile != null) {
//            try {
//                filePrint = new PrintWriter(dataFile);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        } else {
//            Intent intent = new Intent(this, DisplayMessageActivity.class);
//            String message = "No external storage found.";
//            intent.putExtra(EXTRA_MESSAGE, message);
//            startActivity(intent);
//
//            Log.e("Error", "No external storage found.");
//        }
    }

    /**
     * Called when the user clicks the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);

//        filePrint.println(message);

        startActivity(intent);

        if (message.compareTo("end") == 0) {
//            try {
//                bufReader.close();
//            }
//            catch(Exception e){
//                Log.e("file close", e.getMessage());
//            }

            MainActivity.this.finishAffinity();
            System.exit(0);
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public BufferedReader getDataStorageFile(String dataFileName) {

        String sPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ctu/";
        File file = new File(sPath + dataFileName);
        BufferedReader bufReader = null;

        try {
            bufReader = new BufferedReader(new FileReader(file));
        }
        catch(Exception e) {
            Log.e("File not exist.", e.getMessage());
        }

//        try {
//            File path = new File(filePath);
//            if (!path.exists()) {
//                path.mkdirs();
//            }
//        } catch (Exception e) {
//            Log.e("ztuApp path mkdir error", e.getMessage());
//        }

        return bufReader;
    }
}
