package com.example.user.univer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.06.2016.
 */
public class ListTeacher extends Activity implements View.OnClickListener{

    private TextView txtTitle;
    private ImageButton btnBack;
    ListView lv;
    TeachersListAdapter lvAdapter;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<String> arName, arSubject, arGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_teachers_list);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("Список преподавателей");

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        arName = new ArrayList<String>();
        arSubject = new ArrayList<String>();
        arGroup = new ArrayList<String>();

        List<TeacherData> teachers = db.getAllTeachers();
        for(TeacherData cn : teachers){
            String sName = cn.getTeacherName();
            arName.add(sName);
            String sSubject = cn.getTeacherSubject();
            arSubject.add(sSubject);
            String sGroup = cn.getTeacherComment();
            arGroup.add(sGroup);
        }
        lv = (ListView) findViewById(R.id.listView);
        lvAdapter = new TeachersListAdapter(this, arName, arSubject, arGroup);
        lv.setAdapter(lvAdapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnBack:
                NavUtils.navigateUpFromSameTask(this);
            break;

    }

    }
}
