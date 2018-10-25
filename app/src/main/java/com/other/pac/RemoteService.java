package com.other.pac;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.remote.rajan.labs.IRemoteBinder;

public class RemoteService extends Service {
    Handler serviceHandler;
    private int counter;
    private Task task;

    private IRemoteBinder.Stub binderstub = new IRemoteBinder.Stub() {
        @Override
        public int getCounter() throws RemoteException {
            return counter;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        return binderstub;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        serviceHandler = new Handler();
        task = new Task();
        serviceHandler.postDelayed(task, 1000L);
        Log.d(getClass().getSimpleName(), "onStart()");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (task !=null)
        serviceHandler.removeCallbacks(task);
        serviceHandler=null;
    }

    class Task implements Runnable {
        public void run() {
            ++counter;
            serviceHandler.postDelayed(this, 1000L);
            Log.i(getClass().getSimpleName(), "Incrementing counter in the run method");
        }
    }
}
