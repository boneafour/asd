package com.example.user.univer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.06.2016.
 */
public class ListGroup extends Activity implements View.OnClickListener{

    private TextView txtTitle;
    private ImageButton btnBack;
    ListView lv;
    GroupListAdapter lvAdapter;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<String> arName, arPhone, arGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list2);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("Список группы");

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        arName = new ArrayList<String>();
        arPhone = new ArrayList<String>();
        arGroup = new ArrayList<String>();

        List<StudentData> students = db.getAllStudents();
        for(StudentData cn : students){
            String sName = cn.getStudentName();
            arName.add(sName);
            String sNum = cn.getStudentPhone();
            arPhone.add(sNum);
            String sGroup = cn.getStudentComment();
            arGroup.add(sGroup);
        }

            lv = (ListView) findViewById(R.id.listView);
            lvAdapter = new GroupListAdapter(this, arName, arPhone, arGroup);
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
