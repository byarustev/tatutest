package com.mianzi.tatutest;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mianzi.tatutest.adapters.CoursesAdapter;
import com.mianzi.tatutest.entities.Course;
import com.mianzi.tatutest.entities.Topic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CoursesAdapter coursesAdapter;
    List<Course> courseList = new ArrayList<>();
    RoomDb database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.courses_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        database = RoomDb.getInstance(this);
        initializeDBData();
        courseList.addAll(database.courseDao().getAll());

        recyclerView.setLayoutManager(linearLayoutManager);
        coursesAdapter = new CoursesAdapter(this, courseList);
        recyclerView.setAdapter(coursesAdapter);
    }

    public void initializeDBData(){
        // only make this insert during app installation
        if(database.courseDao().getAll().size()<1){
            Course course1 = new Course();
            course1.setName("Sample course 1");
            Course course2 = new Course();
            course2.setName("Sample course 2");
            database.courseDao().insert(course1);
            database.courseDao().insert(course2);

            List<Course> courses = database.courseDao().getAll();
            Topic topic1 = new Topic();
            topic1.setTitle("Topic 1");
            topic1.setCourseID(courses.get(0).getCourseID());
            database.topicDao().insert(topic1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        courseList.clear();
        courseList.addAll(database.courseDao().getAll());
        coursesAdapter.notifyDataSetChanged();
    }
}