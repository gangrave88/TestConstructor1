package com.gangrave88.testconstructor1.fragmen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.gangrave88.testconstructor1.R;
import com.gangrave88.testconstructor1.realmModel.Answer;
import com.gangrave88.testconstructor1.realmModel.Question;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmList;

public class NewQuestion extends DialogFragment {

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.question_name)TextView questionName;
    @BindView(R.id.answer_1)TextView answer_1;
    @BindView(R.id.answer_2)TextView answer_2;
    @BindView(R.id.answer_3)TextView answer_3;
    @BindView(R.id.answer_4)TextView answer_4;

    @BindView(R.id.radio_answer_1)RadioButton rAnswer1;
    @BindView(R.id.radio_answer_2)RadioButton rAnswer2;
    @BindView(R.id.radio_answer_3)RadioButton rAnswer3;
    @BindView(R.id.radio_answer_4)RadioButton rAnswer4;

    public interface OnFragmentInteractionListener {
        public void saveQuestion(Question question);
    }

    public static NewQuestion getInstance(){
        NewQuestion newQuestion = new NewQuestion();
        return newQuestion;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_question, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.save_question)
    public void saveQuestion(){
        Question question = new Question();
        question.setName(questionName.getText().toString());

        RealmList<Answer> answers = new RealmList<>();
        answers.add(new Answer(answer_1.getText().toString()));
        answers.add(new Answer(answer_2.getText().toString()));
        answers.add(new Answer(answer_3.getText().toString()));
        answers.add(new Answer(answer_4.getText().toString()));

        question.setAnswers(answers);

        Answer correctAnswer = new Answer();
        if (rAnswer1.isChecked()) correctAnswer.setAnswer(answer_1.getText().toString());
        if (rAnswer2.isChecked()) correctAnswer.setAnswer(answer_2.getText().toString());
        if (rAnswer3.isChecked()) correctAnswer.setAnswer(answer_3.getText().toString());
        if (rAnswer4.isChecked()) correctAnswer.setAnswer(answer_4.getText().toString());

        question.setCorrectAnswer(correctAnswer);

        mListener.saveQuestion(question);

        dismiss();
    }
}
