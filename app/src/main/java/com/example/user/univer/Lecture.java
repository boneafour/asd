package com.example.user.univer;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lecture extends Activity implements View.OnClickListener{

    private static final int DIALOG_ID = 1;
    int DIALOG_TIME = 2;
    int myHour = 00;
    int myMinute = 00;
    DatabaseHandler db = new DatabaseHandler(this);
    private TextView txtTitle;
    private ImageButton btnBack;
    EditText etName, etTopic, etCommentTeacher, etCommentStudent;
    Spinner spTeacher, spStudent, spSubject;
    Button  btnData, btnTime, btnSave, btnSend;
    String stName,stTeacher, stStudent, stSubject, stTopic, stDate, stTime, stCommentStudent, stCommentTeacher, stCheck, stMessege;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);
        db = new DatabaseHandler(this);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.lecture));

        List<TeacherData> teachers = db.getAllTeachers();
        ArrayList<String> teacherList = new ArrayList<String>();
        teacherList.add("Выберите преподавателя:");
        for(TeacherData cn : teachers){
            String s = cn.getTeacherName();
            teacherList.add(s);
        }
        spTeacher = (Spinner) findViewById(R.id.teacher);
        ArrayAdapter studentAdapter = new ArrayAdapter(this,R.layout.activity_spinner, teacherList);
        spTeacher.setAdapter(studentAdapter);

        List<StudentData> students = db.getAllStudents();
        ArrayList<String> studentList = new ArrayList<String>();
        studentList.add("Выберите ученика:");
        for(StudentData cn : students){
            String s = cn.getStudentName();
            studentList.add(s);
        }
        spStudent = (Spinner) findViewById(R.id.student);
        ArrayAdapter teacherAdapter = new ArrayAdapter(this,R.layout.activity_spinner, studentList);
        spStudent.setAdapter(teacherAdapter);

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


        etName = (EditText) findViewById(R.id.fullName);
        etTopic = (EditText) findViewById(R.id.topic);
        btnData = (Button) findViewById(R.id.data);
        btnData.setOnClickListener(this);
        btnTime = (Button) findViewById(R.id.timeLecture);
        btnTime.setOnClickListener(this);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        btnSend = (Button) findViewById(R.id.send);
        btnSend.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                NavUtils.navigateUpFromSameTask(this);
                break;
            case R.id.data:
                showDialog(DIALOG_ID);
                break;
            case R.id.timeLecture:
                stDate = btnData.getText().toString();
                Log.d("Name: ", stDate);
                showDialog(DIALOG_TIME);
                break;
            case R.id.btnSave:
                Toast.makeText(Lecture.this, "Сохранено", Toast.LENGTH_SHORT).show();
                stName = "" + etName.getText();
                stTeacher = "" + spTeacher.getSelectedItem().toString();
                stStudent = "" + spStudent.getSelectedItem().toString();
                stSubject = "" + spSubject.getSelectedItem().toString();
                stDate = btnData.getText().toString();
                stTime = btnTime.getText().toString();
                stTopic = "" + etTopic.getText();
                stCommentTeacher = " ";
                stCommentStudent = " ";
                stCheck = " ";

                db.addLecture(new LectureData(stName, stTeacher, stStudent, stSubject, stTopic, stDate, stTime, stCommentStudent, stCommentStudent, stCheck));
                List<LectureData> lectures = db.getAllLecture();
                for (LectureData cn : lectures) {
                    String log = "Id: "+cn.getLectureID()+" ,Name: " + cn.getLectureName() + " ,Teacher: " + cn.getLectureTeacher()+" ,Student: " + cn.getLectureStudent()
                            +" ,Subject: " + cn.getLectureSubject() +" ,Topic: " + cn.getLectureTopic() + " ,Data: " + cn.getLectureData()+" ,Time: " + cn.getLectureTime()
                            + " ,CommentTeacher: " + cn.getLectureTeacherComment()+" ,CommentStudent: " + cn.getLectureStudentComment();
                    Log.d("Name: ", log);
                }
                break;

            case R.id.send:
                stName = "" + etName.getText();
                stTeacher = "" + spTeacher.getSelectedItem().toString();
                stStudent = "" + spStudent.getSelectedItem().toString();
                stSubject = "" + spSubject.getSelectedItem().toString();
                stDate = btnData.getText().toString();
                stTime = btnTime.getText().toString();
                stTopic = "" + etTopic.getText();
                stCommentTeacher = "" + etCommentTeacher.getText();
                stCommentStudent = "" + etCommentStudent.getText();
                stCheck = "Нет";
                stMessege = ("Название: "+stName+"Преподаватель: "+stTeacher+"Студент: "+stStudent+"Предметы: "+stSubject+" Дата: "+stDate+" Время: "+stTime+" Тема:  "+stTopic+" Комментарий: "+stCommentTeacher+" "+stCommentStudent);
                sendEmail();
                break;

        }
    }

    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Напоминание");
        emailIntent.putExtra(Intent.EXTRA_TEXT, stMessege);

        try {
            startActivity(Intent.createChooser(emailIntent, "Отправить на почту..."));
            finish();
        }
        catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Lecture.this, "Отправлено", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
            return tpd;
        }
            else if (id == DIALOG_ID) {
            return new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    btnData.setText(year + "-" + getResources().getStringArray(R.array.months)[monthOfYear] + "-" +
                            dayOfMonth );
                }
            }, 2016, 6, 22);
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            btnTime.setText(myHour + ":" + myMinute);
        }
    };
}
