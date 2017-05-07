package com.example.user.univer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TeachersListAdapter extends BaseAdapter implements View.OnClickListener
{
    Activity context;
    ArrayList<String> arName, arSubject, arGroup;


    public TeachersListAdapter(Activity context, ArrayList<String> arName, ArrayList<String> arSubject, ArrayList<String> arGroup) {
        super();
        this.context = context;
        this.arName = arName;
        this.arSubject = arSubject;
        this.arGroup = arGroup;

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
        TextView tvStudent, tvSubject, tvGroup;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_group_teacher_list2, null);
            holder = new ViewHolder();
            holder.tvStudent = (TextView) convertView.findViewById(R.id.teacherName);
            holder.tvSubject = (TextView) convertView.findViewById(R.id.teacherSubject);
            holder.tvGroup = (TextView) convertView.findViewById(R.id.teacherGroup);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvStudent.setText("Преподаватель: "+arName.get(position));
        holder.tvSubject.setText("Предмет: "+arSubject.get(position));
        holder.tvGroup.setText("Группа: "+arGroup.get(position));

        return convertView;
    }

}