package com.gangrave88.testconstructor1.activity;

import android.app.ActionBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import com.gangrave88.testconstructor1.R;
import com.gangrave88.testconstructor1.adapter.QuestionsList;
import com.gangrave88.testconstructor1.fragmen.NewQuestion;
import com.gangrave88.testconstructor1.realm.RealmController;
import com.gangrave88.testconstructor1.realmModel.Question;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;

public class NewTest extends ActionBarActivity implements NewQuestion.OnFragmentInteractionListener{

    private Realm realm;
    private RealmList<Question> questions;

    private RecyclerView.LayoutManager layoutManager;
    private QuestionsList adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_test);

        ButterKnife.bind(this);

        this.realm = RealmController.with(this).getRealm();

        questions = new RealmList<>();

        recyclerView = (RecyclerView) findViewById(R.id.list_question);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new QuestionsList(questions);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.new_test,menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public void saveQuestion(Question question) {
        questions.add(question);
        adapter.notifyDataSetChanged();
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
