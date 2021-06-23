package com.mianzi.tatutest.daos;

import com.mianzi.tatutest.entities.Course;
import com.mianzi.tatutest.entities.Topic;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface TopicDao {
    @Insert(onConflict = REPLACE)
    void insert(Topic topic);

    @Delete
    void delete(Topic topic);

    // delete all
    @Delete
    void reset(List<Topic> topicList);

    // get all data
    @Query("SELECT * FROM topics")
    List<Topic> getAll();
}
