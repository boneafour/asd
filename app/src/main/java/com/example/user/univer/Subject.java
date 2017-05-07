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
public class Subject extends Activity implements View.OnClickListener{

    private TextView txtTitle;
    private ImageButton btnBack;
    private Button btnSave;

    EditText etName,  etCommentSubject;
    String stFullName, stCommentSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setText(getString(R.string.subject));

        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.subject);
        etCommentSubject = (EditText) findViewById(R.id.comSubject);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnBack:
                NavUtils.navigateUpFromSameTask(this);
            break;

            case R.id.btnSave:
                stFullName = "" + etName.getText();
                etName.setText("");
                stCommentSubject = "" + etCommentSubject.getText();
                etCommentSubject.setText("");
                System.out.println(stFullName);
                System.out.println(stCommentSubject);

            DatabaseHandler db = new DatabaseHandler(this);
            db.addSubject(new SubjectData(stFullName, stCommentSubject));
            List<SubjectData> subjects = db.getAllSubjects();
            for (SubjectData cn : subjects) {
                String log = "Id: " + cn.getSubjectID() + " ,Names: " + cn.getSubjectName() + " ,Group: " + cn.getSubjectComment();
                Log.d("Name: ", log);
            }
            break;
    }

    }
}
