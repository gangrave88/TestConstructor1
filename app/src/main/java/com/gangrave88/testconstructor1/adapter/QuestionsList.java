package com.gangrave88.testconstructor1.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gangrave88.testconstructor1.R;
import com.gangrave88.testconstructor1.realmModel.Question;

import io.realm.RealmList;

public class QuestionsList extends RecyclerView.Adapter<QuestionsList.ViewHolder>{

    private RealmList<Question> questions;
    private QuestionListOnClickListener context;

    public QuestionsList(RealmList<Question> q, QuestionListOnClickListener con) {
        questions = q;
        context = con;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(questions.get(position),context);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView questionName;

        public ViewHolder(View itemView) {
            super(itemView);
            questionName = (TextView) itemView.findViewById(R.id.question_name);
        }

        public void bind(final Question question, final QuestionListOnClickListener listener){
            questionName.setText(question.getName());
            questionName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClickQuestionClick(question);
                }
            });
        }
    }

    public interface QuestionListOnClickListener{
        public void onClickQuestionClick(Question q);
    }
}
