package com.example.unipdlibrarytestapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download(View view) {
        new DownloadTask().execute();
    }

    private class DownloadTask extends AsyncTask<Void, Void, String> {

        /*@Override
        protected void onPreExecute() {

        }*/

        @Override
        protected String doInBackground(Void... voids) {
            String result = "MESSAGE FROM THE UNDERWORLD";
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(result);
        }
    }
}
