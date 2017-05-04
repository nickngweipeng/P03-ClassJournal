package com.example.nickng.p03_classjournal;

import java.io.Serializable;

/**
 * Created by 15056201 on 4/5/2017.
 */

public class DailyCA implements Serializable{
    private String week;
    private String title;
    private String grade;

    public String getWeek() {
        return week;
    }

    public String getGrade() {
        return grade;
    }

    public DailyCA(String week,String title, String grade) {
        this.week = week;
        this.title = title;
        this.grade = grade;
    }
}
