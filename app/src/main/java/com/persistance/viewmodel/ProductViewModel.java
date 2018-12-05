package com.persistance.viewmodel;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.persistance.DatabaseCreator;
import com.persistance.entity.CommentEntity;
import com.persistance.entity.ProductEntity;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    public ProductViewModel(@NonNull Application application,
                            final int productId) {
        super(application);
        mProductId = productId;

        final DatabaseCreator databaseCreator = DatabaseCreator.getInstance(this.getApplication());
        mObservableComments = Transformations.switchMap(databaseCreator.isDatabaseCreated(), new Function<Boolean, LiveData<List<CommentEntity>>>() {
            @Override
            public LiveData<List<CommentEntity>> apply(Boolean isDbCreated) {
                if (!isDbCreated) {
                    //noinspection unchecked
                    return ABSENT;
                } else {
                    //noinspection ConstantConditions
                    return databaseCreator.getDatabase().commentDao().loadComments(mProductId);
                }
            }
        });

        mObservableProduct = Transformations.switchMap(databaseCreator.isDatabaseCreated(), new Function<Boolean, LiveData<ProductEntity>>() {
            @Override
            public LiveData<ProductEntity> apply(Boolean isDbCreated) {
                if (!isDbCreated) {
                    //noinspection unchecked
                    return ABSENT;
                } else {
                    //noinspection ConstantConditions
                    return databaseCreator.getDatabase().productDao().loadProduct(mProductId);
                }
            }
        });

        databaseCreator.createDb(this.getApplication());


    }

    private final LiveData<ProductEntity> mObservableProduct;
    private static final MutableLiveData ABSENT = new MutableLiveData();

    {
        //noinspection unchecked
        ABSENT.setValue(null);
    }

    public ObservableField<ProductEntity> product = new ObservableField<>();

    private final int
            mProductId;

    private final LiveData<List<CommentEntity>> mObservableComments;

    /**
     * Expose the LiveData Comments query so the UI can observe it.
     */
    public LiveData<List<CommentEntity>> getComments() {
        return mObservableComments;
    }

    public LiveData<ProductEntity> getObservableProduct() {
        return mObservableProduct;
    }

    public void setProduct(ProductEntity product) {
        this.product.set(product);
    }

    /**
     * A creator is used to inject the product ID into the ViewModel
     * <p>
     * This creator is to showcase how to inject dependencies into ViewModels. It's not
     * actually necessary in this case, as the product ID can be passed in a public method.
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application mApplication;

        private final int mProductId;

        public Factory(@NonNull Application application, int productId) {
            mApplication = application;
            mProductId = productId;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new ProductViewModel(mApplication, mProductId);
        }
    }
}

