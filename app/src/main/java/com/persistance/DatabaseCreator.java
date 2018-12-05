package com.persistance;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import static com.persistance.AppDatabase.DATABASE_NAME;

public class DatabaseCreator {
    private static DatabaseCreator sInstance;
    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();
    private AppDatabase appDatabase;
    private final AtomicBoolean mInitializing = new AtomicBoolean(true);
    private static final Object LOCK = new Object();

    public synchronized static DatabaseCreator getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new DatabaseCreator();
            }
        }
        return sInstance;
    }

   public LiveData<Boolean> isDatabaseCreated() {
        return mIsDatabaseCreated;
    }

    @Nullable
    public AppDatabase getDatabase() {
        return appDatabase;
    }

    public void createDb(Context context) {
        Log.d("DatabaseCreator", "Creating DB from " + Thread.currentThread().getName());

        if (!mInitializing.compareAndSet(true, false)) {
            return; // Already initializing
        }
        mIsDatabaseCreated.setValue(false);// Trigger an update to show a loading screen.

        new AsyncTask<Context, Void, Void>() {

            @Override
            protected Void doInBackground(Context... params) {
                Log.d("DatabaseCreator",
                        "Starting bg job " + Thread.currentThread().getName());

                Context context = params[0].getApplicationContext();

                // Reset the database to have new data on every run.
                context.deleteDatabase(DATABASE_NAME);

                // Build the database!
                AppDatabase db = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, DATABASE_NAME).build();

                // Add a delay to simulate a long-running operation
                addDelay();

                // Add some data to the database
                DatabaseInitUtil.initializeDb(db);
                Log.d("DatabaseCreator",
                        "DB was populated in thread " + Thread.currentThread().getName());

                appDatabase = db;
                return null;
            }

            @Override
            protected void onPostExecute(Void ignored) {
                // Now on the main thread, notify observers that the db is created and ready.
                mIsDatabaseCreated.setValue(true);
            }
        }.execute(context.getApplicationContext());

    }
    private void addDelay() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {}
    }
}
