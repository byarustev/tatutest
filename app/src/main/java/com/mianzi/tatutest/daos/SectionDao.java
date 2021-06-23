package com.mianzi.tatutest.daos;

import com.mianzi.tatutest.entities.Section;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface SectionDao {
    @Insert(onConflict = REPLACE)
    void insert(Section section);

    @Delete
    void delete(Section section);

    // delete all
    @Delete
    void reset(List<Section> sectionsList);

    // get all data
    @Query("SELECT * FROM sections")
    List<Section> getAll();
}
