package com.example.user.univer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 10;

	// Database Name
	private static final String DATABASE_NAME = "contactsManager";

	// Contacts table name
	private static final String TABLE_TEACHERS = "teachers";
	private static final String TABLE_STUDENTS = "students";
	private static final String TABLE_SUBJECTS = "subjects";
	private static final String TABLE_LECTURES = "lectures";
	private static final String TABLE_MARK = "mark";
	// Contacts Table Columns names

	private static final String TEACHER_ID = "teacher_id";
	private static final String TEACHER_NAME = "teacher_name";
	private static final String TEACHER_SUBJECT = "teacher_subject";
	private static final String TEACHER_NUMBER = "teacher_number";
	private static final String TEACHER_COMMENT = "teacher_comment";

	private static final String STUDENT_ID = "student_id";
	private static final String STUDENT_NAME = "student_name";
	private static final String STUDENT_NUMBER = "student_number";
	private static final String STUDENT_COMMENT = "student_comment";

	private static final String SUBJECT_ID = "subject_id";
	private static final String SUBJECT_NAME = "subject_name";
	private static final String SUBJECT_COMMENT = "subject_comment";

	private static final String LECTURE_ID = "lecture_id";
	private static final String LECTURE_NAME = "lecture_name";
	private static final String LECTURE_TEACHER = "lecture_teacher";
	private static final String LECTURE_STUDENT = "lecture_student";
	private static final String LECTURE_TOPIC = "lecture_topic";
	private static final String LECTURE_SUBJECT = "lecture_subject";
	private static final String LECTURE_DATE = "lecture_data";
	private static final String LECTURE_TIME = "lecture_time";
	private static final String LECTURE_TEACHER_COMMENT= "lecture_teacher_comment";
	private static final String LECTURE_STUDENT_COMMENT = "lecture_student_comment";
	private static final String LECTURE_CHECK= "lecture_check";

	private static final String MARK_ID = "mark_id";
	private static final String MARK_TEACHER= "mark_teacher";
	private static final String MARK_STUDENT = "mark_student";
	private static final String MARK_SUBJECT = "mark_subject";
	private static final String MARK_NAME = "mark_name";
	private static final String MARK_MARKS = "mark_marks";


	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_TEACHERS = "CREATE TABLE " + TABLE_TEACHERS + "("
				+ TEACHER_ID + " INTEGER PRIMARY KEY," + TEACHER_NAME + " TEXT," + TEACHER_SUBJECT + " TEXT,"
				+ TEACHER_NUMBER +" TEXT,"+ TEACHER_COMMENT +" TEXT"+  ")";
		db.execSQL(CREATE_TABLE_TEACHERS);

		String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + "("
				+ STUDENT_ID + " INTEGER PRIMARY KEY," + STUDENT_NAME + " TEXT,"
				+ STUDENT_NUMBER +" TEXT,"+ STUDENT_COMMENT +" TEXT" +  ")";
		db.execSQL(CREATE_TABLE_STUDENTS);

		String CREATE_TABLE_SUBJECTS = "CREATE TABLE " + TABLE_SUBJECTS + "("
				+ SUBJECT_ID + " INTEGER PRIMARY KEY," + SUBJECT_NAME + " TEXT,"
				+ SUBJECT_COMMENT +" TEXT" +  ")";
		db.execSQL(CREATE_TABLE_SUBJECTS);

		String CREATE_TABLE_LECTURES = "CREATE TABLE " + TABLE_LECTURES + "("
				+ LECTURE_ID + " INTEGER PRIMARY KEY," + LECTURE_NAME + " TEXT,"
				+ LECTURE_TEACHER +" TEXT,"+ LECTURE_STUDENT + " TEXT,"
				+ LECTURE_SUBJECT + " TEXT,"+ LECTURE_TOPIC + " TEXT," + LECTURE_DATE +" TEXT,"
				+ LECTURE_TIME + " TEXT,"+ LECTURE_TEACHER_COMMENT +" TEXT,"+ LECTURE_STUDENT_COMMENT + " TEXT,"+ LECTURE_CHECK+ " TEXT"+  ")";
		db.execSQL(CREATE_TABLE_LECTURES);

		String CREATE_TABLE_MARK = "CREATE TABLE " + TABLE_MARK + "("
				+ MARK_ID + " INTEGER PRIMARY KEY," + MARK_TEACHER + " TEXT,"
				+ MARK_STUDENT +" TEXT,"+ MARK_SUBJECT + " TEXT,"
				+ MARK_NAME + " TEXT,"+ MARK_MARKS + " TEXT"+  ")";
		db.execSQL(CREATE_TABLE_MARK);

	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEACHERS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUBJECTS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_LECTURES);
		onCreate(db);
	}

	void addTeacher(TeacherData teacher) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(TEACHER_NAME, teacher.getTeacherName());
		values.put(TEACHER_SUBJECT, teacher.getTeacherSubject());
		values.put(TEACHER_NUMBER, teacher.getTeacherPhone());
		values.put(TEACHER_COMMENT, teacher.getTeacherComment());
		db.insert(TABLE_TEACHERS, null, values);
		db.close();
	}

	void addStudent(StudentData student) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(STUDENT_NAME, student.getStudentName());
		values.put(STUDENT_NUMBER, student.getStudentPhone());
		values.put(STUDENT_COMMENT, student.getStudentComment());
		db.insert(TABLE_STUDENTS, null, values);
		db.close();
	}

	void addSubject(SubjectData contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(SUBJECT_NAME, contact.getSubjectName());
		values.put(SUBJECT_COMMENT, contact.getSubjectComment());
		db.insert(TABLE_SUBJECTS, null, values);
		db.close();
	}

	void addLecture(LectureData contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(LECTURE_NAME, contact.getLectureName());
		values.put(LECTURE_TEACHER, contact.getLectureTeacher());
		values.put(LECTURE_STUDENT, contact.getLectureStudent());
		values.put(LECTURE_SUBJECT, contact.getLectureSubject());
		values.put(LECTURE_TOPIC, contact.getLectureTopic());
		values.put(LECTURE_DATE, contact.getLectureData());
		values.put(LECTURE_TIME, contact.getLectureTime());
		values.put(LECTURE_TEACHER_COMMENT, contact.getLectureTeacherComment());
		values.put(LECTURE_STUDENT_COMMENT, contact.getLectureStudentComment());
		values.put(LECTURE_CHECK, contact.getLectureCheck());
		db.insert(TABLE_LECTURES, null, values);
		db.close();
	}

	void addMark(MarkData mark) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(MARK_TEACHER, mark.getMarkTeacher());
		values.put(MARK_STUDENT, mark.getMarkStudent());
		values.put(MARK_SUBJECT, mark.getMarkSubject());
		values.put(MARK_NAME, mark.getMarkName());
		values.put(MARK_MARKS, mark.getMark());
		db.insert(TABLE_MARK, null, values);
		db.close();
	}

	public List<TeacherData> getAllTeachers() {
		List<TeacherData> teacherList = new ArrayList<TeacherData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_TEACHERS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				TeacherData teacher = new TeacherData();
				teacher.setTeacherID(Integer.parseInt(cursor.getString(0)));
				teacher.setTeacherName(cursor.getString(1));
				teacher.setTeacherSubject(cursor.getString(2));
				teacher.setTeacherPhone(cursor.getString(3));
				teacher.setTeacherComment(cursor.getString(4));
				teacherList.add(teacher);
			} while (cursor.moveToNext());
		}

		// return contact list
		return teacherList;
	}
	public List<StudentData> getAllStudents() {
		List<StudentData> studentList = new ArrayList<StudentData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_STUDENTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				StudentData student = new StudentData();
				student.setStudentID(Integer.parseInt(cursor.getString(0)));
				student.setStudentName(cursor.getString(1));
				student.setStudentPhone(cursor.getString(2));
				student.setStudentComment(cursor.getString(3));
				studentList.add(student);
			} while (cursor.moveToNext());
		}
		return studentList;
	}
	public List<SubjectData> getAllSubjects() {
		List<SubjectData> subjectList = new ArrayList<SubjectData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_SUBJECTS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				SubjectData subject = new SubjectData();
				subject.setSubjectID(Integer.parseInt(cursor.getString(0)));
				subject.setSubjectName(cursor.getString(1));
				subject.setSubjectComment(cursor.getString(2));
				subjectList.add(subject);
			} while (cursor.moveToNext());
		}
		return subjectList;
	}

	public List<LectureData> getAllLecture() {
		List<LectureData> lectureList = new ArrayList<LectureData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_LECTURES;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				LectureData lecture = new LectureData();
				lecture.setLectureID(Integer.parseInt(cursor.getString(0)));
				lecture.setLectureName(cursor.getString(1));
				lecture.setLectureTeacher(cursor.getString(2));
				lecture.setLectureStudent(cursor.getString(3));
				lecture.setLectureSubject(cursor.getString(4));
				lecture.setLectureTopic(cursor.getString(5));
				lecture.setLectureData(cursor.getString(6));
				lecture.setLectureTime(cursor.getString(7));
				lecture.setLectureTeacherComment(cursor.getString(8));
				lecture.setLectureStudentComment(cursor.getString(9));
				lecture.setLectureCheck(cursor.getString(10));
				lectureList.add(lecture);
			} while (cursor.moveToNext());
		}
		return lectureList;
	}

	public List<MarkData> getAllMarks() {
		List<MarkData> markList = new ArrayList<MarkData>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_MARK;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				MarkData mark = new MarkData();
				mark.setMarkID(Integer.parseInt(cursor.getString(0)));
				mark.setMarkTeacher(cursor.getString(1));
				mark.setMarkStudent(cursor.getString(2));
				mark.setMarkSubject(cursor.getString(3));
				mark.setMarkName(cursor.getString(4));
				mark.setMark(cursor.getString(5));
				markList.add(mark);
			} while (cursor.moveToNext());
		}
		return markList;
	}

/*
	// Deleting single contact
	public void deleteContact(ContactData contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_CONTACTS, CONTACT_ID +NAME +ADRESS+ORGAN+ROLE +PHONE+COMMENT+ " = ?",
				new String[] { String.valueOf(contact.getID()) });
		db.close();
	}



	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

*/

}
