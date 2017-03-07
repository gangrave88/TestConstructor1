package com.gangrave88.testconstructor1.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.gangrave88.testconstructor1.R;
import com.gangrave88.testconstructor1.adapter.QuestionsList;
import com.gangrave88.testconstructor1.fragmen.NewQuestion;
import com.gangrave88.testconstructor1.realm.RealmController;
import com.gangrave88.testconstructor1.realmModel.Question;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmList;

public class NewTest extends FragmentActivity implements NewQuestion.OnFragmentInteractionListener,QuestionsList.QuestionListOnClickListener{

    private Realm realm;
    private RealmList<Question> questions;

    private RecyclerView.LayoutManager layoutManager;
    private QuestionsList adapter;
    private RecyclerView recyclerView;

    @BindView(R.id.toolbar_new_test)Toolbar toolbar;

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

        adapter = new QuestionsList(questions,this);
        recyclerView.setAdapter(adapter);

        initToolbar();
    }

    private void initToolbar() {

        toolbar.setTitle("Новый тест");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.new_test);
    }

    @Override
    public void saveQuestion(Question question) {
        questions.add(question);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateQuestion(Question question,int location) {
        questions.set(location,question);
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
        DialogFragment df = NewQuestion.getInstance(null,0);
        df.show(ft,"NewQuestion");
    }


    @Override
    public void onClickQuestionClick(Question q) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prew = getSupportFragmentManager().findFragmentByTag("NewQuestion");
        if (prew!=null){
            ft.remove(prew);
        }
        ft.addToBackStack(null);
        DialogFragment df = NewQuestion.getInstance(q,questions.indexOf(q));
        df.show(ft,"NewQuestion");
    }
}
