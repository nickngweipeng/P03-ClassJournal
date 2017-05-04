package com.example.nickng.p03_classjournal;

import java.io.Serializable;

/**
 * Created by 15056201 on 4/5/2017.
 */

public class DailyCA implements Serializable{
    private String dgGrade;
    private String moduleCode;
    private int week;

    public DailyCA(String dgGrade, String moduleCode, int week) {
        this.dgGrade = dgGrade;
        this.moduleCode = moduleCode;
        this.week = week;
    }

    public String getDgGrade() {
        return dgGrade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }
}
