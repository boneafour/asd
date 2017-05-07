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
public class ListSubject extends Activity implements View.OnClickListener{

    private TextView txtTitle;
    private ImageButton btnBack;
    ListView lv;
    SubjectListAdapter lvAdapter;
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<String> arSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_for_subject);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText("Предметы");

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        arSubject = new ArrayList<String>();

        List<SubjectData> subjectDatas = db.getAllSubjects();
        for(SubjectData cn : subjectDatas){
            String sSubject = cn.getSubjectName();
            arSubject.add(sSubject);
        }
            lv = (ListView) findViewById(R.id.listView);
            lvAdapter = new SubjectListAdapter(this, arSubject);
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
