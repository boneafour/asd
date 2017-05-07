package com.example.user.univer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MarkListAdapter extends BaseAdapter implements View.OnClickListener
{
    Activity context;
    ArrayList<String> arTeacher;
    ArrayList<String> arStudent;
    ArrayList<String> arSubject;
    ArrayList<String> arName;
    ArrayList<String> arMark;


    public MarkListAdapter(Activity context, ArrayList<String> arTeacher, ArrayList<String> arStudent, ArrayList<String> arSubject, ArrayList<String> arName, ArrayList<String> arMark) {
        super();
        this.context = context;
        this.arTeacher = arTeacher;
        this.arStudent = arStudent;
        this.arSubject = arSubject;
        this.arName = arName;
        this.arMark = arMark;
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
        TextView tvTeacher, tvStudent, tvSubject, tvName,  tvMark;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_mark_list, null);
            holder = new ViewHolder();
            holder.tvTeacher = (TextView) convertView.findViewById(R.id.teacherSubject);
            holder.tvStudent = (TextView) convertView.findViewById(R.id.name);
            holder.tvSubject = (TextView) convertView.findViewById(R.id.subject);
            holder.tvName = (TextView) convertView.findViewById(R.id.subject1);
            holder.tvMark = (TextView) convertView.findViewById(R.id.mark);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTeacher.setText("Преподаватель: "+arTeacher.get(position));
        holder.tvStudent.setText("Студент: "+arStudent.get(position));
        holder.tvSubject.setText("Предмет: "+arSubject.get(position));
        holder.tvName.setText("Тема: "+arName.get(position));
        holder.tvMark.setText("Оценка: "+arMark.get(position));

        return convertView;
    }

}