package com.example.user.univer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ReportListAdapter extends BaseAdapter implements View.OnClickListener
{
    Activity context;
    ArrayList<String> arName;
    ArrayList<String> arTeacher;
    ArrayList<String> arStudent;
    ArrayList<String> arSubject;
    ArrayList<String> arTopic;
    ArrayList<String> arDate;
    ArrayList<String> arTime;


    public ReportListAdapter(Activity context, ArrayList<String> arName, ArrayList<String> arTeacher, ArrayList<String> arStudent, ArrayList<String> arSubject, ArrayList<String> arTopic, ArrayList<String> arDate, ArrayList<String> arTime) {
        super();
        this.context = context;
        this.arName = arName;
        this.arTeacher = arTeacher;
        this.arStudent = arStudent;
        this.arSubject = arSubject;
        this.arTopic = arTopic;
        this.arDate = arDate;
        this.arTime = arTime;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return arName.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void onClick(View v) {

    }

    private class ViewHolder {
        TextView tvName, tvTeacher, tvStudent, tvSubject, tvTopic, tvDate, tvTime;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_table_list, null);
            holder = new ViewHolder();
            holder.tvName = (TextView) convertView.findViewById(R.id.subject1);
            holder.tvTeacher = (TextView) convertView.findViewById(R.id.teacherSubject);
            holder.tvStudent = (TextView) convertView.findViewById(R.id.name);
            holder.tvSubject = (TextView) convertView.findViewById(R.id.subject);
            holder.tvTopic = (TextView) convertView.findViewById(R.id.topicName);
            holder.tvDate = (TextView) convertView.findViewById(R.id.date);
            holder.tvTime = (TextView) convertView.findViewById(R.id.lectureTime);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText("Название: "+arName.get(position));
        holder.tvTeacher.setText("Преподаватель: "+arTeacher.get(position));
        holder.tvStudent.setText("Студент: "+arStudent.get(position));
        holder.tvSubject.setText("Предмет: "+arSubject.get(position));
        holder.tvTopic.setText("Тема: "+arTopic.get(position));
        holder.tvDate.setText("Дата: "+arDate.get(position));
        holder.tvTime.setText("Время: "+arTime.get(position));

        return convertView;
    }

}