package com.example.firebaserealtimedbexample;

import androidx.annotation.NonNull;

public class dataHolder {
    String name, course, duration;

    public dataHolder(String name, String course, String duration) {
        this.name = name;
        this.course = course;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}

