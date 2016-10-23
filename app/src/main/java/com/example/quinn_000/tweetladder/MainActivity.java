package com.example.quinn_000.tweetladder;

import android.os.Handler;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View;

import java.lang.Thread;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private static String usernameString;
    private static String keywordString;

    int[] rtnVals = new int[2];

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(msg == null){
                return;
            }
            ProgressBar p = (ProgressBar) findViewById(R.id.progressBar);
            p.setVisibility(View.INVISIBLE);
            goToGraph();
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EditText t1 = (EditText) findViewById(R.id.usernameBox);
        EditText t2 = (EditText) findViewById(R.id.keywordBox);

        t1.setEnabled(true);
        t2.setEnabled(true);

        t1.setText("");
        t2.setText("");


        Button b = (Button) findViewById(R.id.button);
        b.setVisibility(View.VISIBLE);

    }

    public void goToGraph(){
        Intent i = new Intent(this, Graph.class);

        i.putExtra("D1", 72);
        i.putExtra("D2", 89);
        i.putExtra("D3", 5);
        i.putExtra("D4", 15);

        i.putExtra("username", usernameString);
        i.putExtra("keyword", keywordString);
        startActivity(i);
        return;
    }

    public void buttonClick(View view) {

        EditText t1 = (EditText) findViewById(R.id.usernameBox);
        EditText t2 = (EditText) findViewById(R.id.keywordBox);

        String username = (String) t1.getText().toString();
        String keyword = (String) t2.getText().toString();
        if(username.equals("") || keyword.equals("")){
            return;
        }

        Runnable runnable = new Runnable() {
            String username;
            String keyword;
            public void runnable (String username, String keyword){
                this.username = username;
                this.keyword = keyword;
            }

            @Override
            public void run() {
                //replace try catch block with actual function call
                try {
                    System.out.println(username);
                    Thread.sleep(4000);
                } catch (InterruptedException e) {}
                handler.sendEmptyMessage(0);
            }
        };


        ProgressBar p = (ProgressBar) findViewById(R.id.progressBar);
        p.setVisibility(View.VISIBLE);

        Thread t = new Thread(runnable);


        usernameString = username;
        keywordString = keyword;

        System.out.println(username + keyword);

        Button b = (Button) findViewById(R.id.button);
        b.setVisibility(View.GONE);

        t1.setEnabled(false);
        t2.setEnabled(false);


        t.start();

        return;
    }
}