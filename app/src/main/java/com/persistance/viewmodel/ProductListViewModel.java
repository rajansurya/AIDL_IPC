package com.persistance.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.persistance.DatabaseCreator;
import com.persistance.entity.ProductEntity;

import java.util.List;

public class ProductListViewModel extends AndroidViewModel {
    private static final MutableLiveData ABSENT = new MutableLiveData();

    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    private final LiveData<List<ProductEntity>> mObservableProducts;

    public ProductListViewModel(@NonNull Application application) {
        super(application);

        final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());
        LiveData<Boolean> databaseCreated = databaseCreator.isDatabaseCreated();

        mObservableProducts = Transformations.switchMap(databaseCreated, new Function<Boolean, LiveData<List<ProductEntity>>>() {
            @Override
            public LiveData<List<ProductEntity>> apply(Boolean isDbCreated) {
                if (!Boolean.TRUE.equals(isDbCreated)) { // Not needed here, but watch out for null
                    //noinspection unchecked
                    return ABSENT;
                } else {
                    //noinspection ConstantConditions
                    return databaseCreator.getDatabase().productDao().loadAllProducts();
                }
            }
        });
        databaseCreator.createDb(this.getApplication());
    }
    /**
     * Expose the LiveData Products query so the UI can observe it.
     */
    public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }
}
