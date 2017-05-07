package com.example.user.univer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.06.2016.
 */
public class Teacher extends Activity implements View.OnClickListener {

    private TextView txtTitle;
    private ImageButton btnBack;
    private Button btnSave;
    DatabaseHandler db = new DatabaseHandler(this);
    EditText etFullName, etPhoneNumber, etGroupTeacher;
    String stFullName, stPhoneNumber, stGroupTeacher, stSubject;
    Spinner spSubject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.teacher));

        List<SubjectData> subject = db.getAllSubjects();
        ArrayList<String> roleList = new ArrayList<String>();
        roleList.add("Выберите предмета:");
        for(SubjectData cn : subject){
            String s = cn.getSubjectName();
            roleList.add(s);
        }
        spSubject = (Spinner) findViewById(R.id.subject);
        ArrayAdapter subjectList = new ArrayAdapter(this,R.layout.activity_spinner, roleList);
        spSubject.setAdapter(subjectList);

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        etFullName = (EditText) findViewById(R.id.teacherName);
        etPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        etGroupTeacher = (EditText) findViewById(R.id.groupTeacher);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                NavUtils.navigateUpFromSameTask(this);
                break;

            case R.id.btnSave:
                stFullName = "" + etFullName.getText();
                etFullName.setText("");
                stSubject = "" + spSubject.getSelectedItem().toString();
                stPhoneNumber = "" + etPhoneNumber.getText();
                etPhoneNumber.setText("");
                stGroupTeacher = "" + etGroupTeacher.getText();
                etGroupTeacher.setText("");

                DatabaseHandler db = new DatabaseHandler(this);
                db.addTeacher(new TeacherData(stFullName, stSubject, stPhoneNumber, stGroupTeacher));
                List<TeacherData> teachers = db.getAllTeachers();
                for (TeacherData cn : teachers) {
                    String log = "Id: "+cn.getTeacherID()+" ,Name: " + cn.getTeacherName() + " ,Subject: " + cn.getTeacherSubject() + " ,Phone: " + cn.getTeacherPhone()+" ,Group: " + cn.getTeacherComment();
                    Log.d("Name: ", log);
                }
                break;

        }
    }
}
