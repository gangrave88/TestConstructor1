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

    public QuestionsList(RealmList<Question> q) {
        questions = q;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.questionName.setText(questions.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView questionName;

        public ViewHolder(View itemView) {
            super(itemView);
            questionName = (TextView) itemView.findViewById(R.id.question_name);
        }
    }
}
