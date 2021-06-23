package com.mianzi.tatutest;

import android.content.Context;

import com.mianzi.tatutest.daos.CourseDao;
import com.mianzi.tatutest.daos.SectionDao;
import com.mianzi.tatutest.daos.TopicDao;
import com.mianzi.tatutest.entities.Course;
import com.mianzi.tatutest.entities.Section;
import com.mianzi.tatutest.entities.Topic;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Section.class, Topic.class, Course.class}, version = 1, exportSchema = false)
public abstract class RoomDb extends RoomDatabase {
    public static RoomDb database;

    private static String DATABASE_NAME="tatu_nurse";

    public synchronized static RoomDb getInstance(Context context){
        if(database==null){
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDb.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }

    public abstract CourseDao courseDao();
    public abstract TopicDao topicDao();
    public abstract SectionDao sectionDao();
}
