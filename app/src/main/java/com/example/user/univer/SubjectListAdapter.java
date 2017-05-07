package com.example.user.univer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectListAdapter extends BaseAdapter implements View.OnClickListener
{
    Activity context;
    ArrayList<String> arSubject;


    public SubjectListAdapter(Activity context, ArrayList<String> arSubject) {
        super();
        this.context = context;
        this.arSubject = arSubject;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return arSubject.size();
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
        TextView  tvSubject;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        ViewHolder holder;
        LayoutInflater inflater =  context.getLayoutInflater();

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.activity_group_subject_list2, null);
            holder = new ViewHolder();
            holder.tvSubject = (TextView) convertView.findViewById(R.id.subject);
            convertView.setTag(holder);
        }
        else
        {

            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvSubject.setText(arSubject.get(position));

        return convertView;
    }

}