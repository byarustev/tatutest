package com.mianzi.tatutest.daos;

import com.mianzi.tatutest.entities.Course;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CourseDao {
    @Insert(onConflict = REPLACE)
    void insert(Course course);

    @Delete
    void delete(Course course);

    // delete all
    @Delete
    void reset(List<Course> courseList);

    // get all data
    @Query("SELECT * FROM courses")
    List<Course> getAll();
}
