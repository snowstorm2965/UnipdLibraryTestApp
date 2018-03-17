package com.example.unipdlibrarytestapp;

import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void download(View view) {
        new DownloadTask(this).execute();
    }

    private static class DownloadTask extends AsyncTask<Void, Void, String> {
        private WeakReference<MainActivity> mainActivityWeakReference;
        // URL to download: http://zaphod.cab.unipd.it/psico/disponibilita.txt

        DownloadTask(MainActivity context) {
            mainActivityWeakReference = new WeakReference<MainActivity>(context);
        }
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
            MainActivity mainActivity = mainActivityWeakReference.get();
            if (mainActivity == null || mainActivity.isFinishing()) return;
            TextView textView = (TextView) mainActivity.findViewById(R.id.textView);
            textView.setText(result);
        }
    }
}

