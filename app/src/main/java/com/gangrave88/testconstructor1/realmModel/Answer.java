package com.gangrave88.testconstructor1.realmModel;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Answer extends RealmObject {

    @PrimaryKey
    private int id;

    private String answer;

    public Answer() {
    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer1 = (Answer) o;

        if (id != answer1.id) return false;
        return answer.equals(answer1.answer);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + answer.hashCode();
        return result;
    }
}
