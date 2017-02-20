package com.gangrave88.testconstructor1.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import com.gangrave88.testconstructor1.R;
import com.gangrave88.testconstructor1.fragmen.NewQuestion;
import com.gangrave88.testconstructor1.realmModel.Question;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmList;

public class NewTest extends FragmentActivity implements NewQuestion.OnFragmentInteractionListener{

    RealmList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_test);

        questions = new RealmList<>();

        ButterKnife.bind(this);
    }

    @Override
    public void saveQuestion(Question question) {
        questions.add(question);
    }

    @OnClick(R.id.add_new_question)
    public void ClickAddNewQuestion(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prew = getSupportFragmentManager().findFragmentByTag("NewQuestion");
        if (prew!=null){
            ft.remove(prew);
        }
        ft.addToBackStack(null);
        DialogFragment df = NewQuestion.getInstance();
        df.show(ft,"NewQuestion");
    }
}
