package com.persistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.persistance.dao.CommentDao;
import com.persistance.dao.ProductDao;
import com.persistance.entity.CommentEntity;
import com.persistance.entity.ProductEntity;

@Database(entities = {ProductEntity.class, CommentEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "basic-sample-db";

    public abstract ProductDao productDao();

    public abstract CommentDao commentDao();
}
