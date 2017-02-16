package com.gangrave88.testconstructor1.fragmen;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gangrave88.testconstructor1.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListQuestions extends Fragment {

    public static ListQuestions getInstance() {
        return new ListQuestions();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_questions, container, false);

        ButterKnife.bind(this,v);

        return v;
    }

    @OnClick(R.id.add_question)
    public void addQuestion(){
        NewQuestion frag = new NewQuestion();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frag,frag);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
