package com.gangrave88.testconstructor1.realmModel;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Test extends RealmObject{

    @PrimaryKey
    private int id;

    private int difficult;
    private String description;
    private Date dateOfCreate;
    private Date dateOfComplit;
    private boolean complit;
    private RealmList<Type> types;
    private RealmList<Question> questions;

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfComplit() {
        return dateOfComplit;
    }

    public void setDateOfComplit(Date dateOfComplit) {
        this.dateOfComplit = dateOfComplit;
    }

    public boolean isComplit() {
        return complit;
    }

    public void setComplit(boolean complit) {
        this.complit = complit;
    }

    public RealmList<Type> getTypes() {
        return types;
    }

    public void setTypes(RealmList<Type> types) {
        this.types = types;
    }

    public RealmList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(RealmList<Question> questions) {
        this.questions = questions;
    }
}
