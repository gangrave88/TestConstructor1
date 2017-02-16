package com.gangrave88.testconstructor1.fragmen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class NewQuestion extends Fragment {

    private newQuestionInterface listener;

    @BindView(R.id.question_name)TextView questionName;
    @BindView(R.id.answer_1)TextView answer_1;
    @BindView(R.id.answer_2)TextView answer_2;
    @BindView(R.id.answer_3)TextView answer_3;
    @BindView(R.id.answer_4)TextView answer_4;

    @BindView(R.id.radio_answer_1)RadioButton rAnswer1;
    @BindView(R.id.radio_answer_2)RadioButton rAnswer2;
    @BindView(R.id.radio_answer_3)RadioButton rAnswer3;
    @BindView(R.id.radio_answer_4)RadioButton rAnswer4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_new_question, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle!=null){
            //not new Question
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof newQuestionInterface){
            listener = (newQuestionInterface) context;
        }
        else {
            throw new ClassCastException(context.toString());
        }
    }

    public interface newQuestionInterface{
        void addQuestion(Question question);
    }

    @OnClick(R.id.save_question)
    public void saveQuestion(){
        Question question = new Question();
        question.setName(questionName.toString());
        question.setOneAnswer(new Answer(answer_1.toString()));
        question.setOneAnswer(new Answer(answer_2.toString()));
        question.setOneAnswer(new Answer(answer_3.toString()));
        question.setOneAnswer(new Answer(answer_4.toString()));

        Answer correctAnswer = new Answer();
        if (rAnswer1.isChecked()) correctAnswer.setAnswer(answer_1.toString());
        if (rAnswer2.isChecked()) correctAnswer.setAnswer(answer_2.toString());
        if (rAnswer3.isChecked()) correctAnswer.setAnswer(answer_3.toString());
        if (rAnswer4.isChecked()) correctAnswer.setAnswer(answer_4.toString());

        question.setCorrectAnswer(correctAnswer);

        listener.addQuestion(question);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
