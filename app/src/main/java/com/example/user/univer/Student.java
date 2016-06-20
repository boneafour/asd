package com.example.user.univer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 14.06.2016.
 */
public class Student extends Activity implements View.OnClickListener {

    private TextView txtTitle;
    private ImageButton btnBack;
    private Button btnSave;

    EditText etFullName, etPhoneNumber, etCommentStudent;
    String stFullName, stPhoneNumber, stCommentStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.student));

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        etFullName = (EditText) findViewById(R.id.name);
        etPhoneNumber = (EditText) findViewById(R.id.phoneNumber);
        etCommentStudent = (EditText) findViewById(R.id.comStudent);

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
                stPhoneNumber = "" + etPhoneNumber.getText();
                etPhoneNumber.setText("");
                stCommentStudent = "" + etCommentStudent.getText();
                etCommentStudent.setText("");

                DatabaseHandler db = new DatabaseHandler(this);
                db.addStudent(new StudentData(stFullName, stPhoneNumber, stCommentStudent));
                List<StudentData> students = db.getAllStudents();
                for (StudentData cn : students) {
                    String log = "Id: "+cn.getStudentID()+" ,Name: " + cn.getStudentName() + " ,Phone: " + cn.getStudentPhone()+" ,Comment: " + cn.getStudentComment();
                    Log.d("Name: ", log);
                }
                break;

        }
    }
}
