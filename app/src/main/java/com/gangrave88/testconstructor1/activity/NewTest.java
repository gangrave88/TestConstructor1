package com.gangrave88.testconstructor1.activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gangrave88.testconstructor1.R;
import com.gangrave88.testconstructor1.fragmen.ListQuestions;
import com.gangrave88.testconstructor1.fragmen.NewQuestion;
import com.gangrave88.testconstructor1.realmModel.Question;

import io.realm.RealmList;

public class NewTest extends FragmentActivity implements NewQuestion.newQuestionInterface{

    RealmList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_test);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frag,ListQuestions.getInstance());
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }
}
