package com.other.pac;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class Asyncktask extends AsyncTask<Void, Integer, Boolean> {
    private ProgressDialog dialog;

    Asyncktask(Context context) {
        dialog = new ProgressDialog(context);
    }


    private int total = 1000000;
    private int count = 0;

    //Used as handler to cancel task if back button is pressed
    private AsyncTask<Void, Integer, Boolean> updateTask = null;

    @Override
    protected void onPreExecute() {
        updateTask = this;
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                updateTask.cancel(true);
            }
        });
        dialog.setMessage("Updating Library...");
        dialog.setMax(total);
        dialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... arg0) {
        for (int i = 0; i < 100; i++) {
            try {
//                Thread.sleep(100);
                System.out.println("IIII " + i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (isCancelled()) {
                System.out.println("isCancelled");
                break;
            }
            //Do your updating stuff here
        }
        return true;
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        System.out.println("onCancelled");
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        count += progress[0];
        dialog.setProgress(count);
    }

    @Override
    protected void onPostExecute(Boolean finished) {
        dialog.dismiss();
    }
}

