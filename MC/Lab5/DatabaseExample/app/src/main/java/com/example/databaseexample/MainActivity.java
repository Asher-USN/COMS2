package com.example.databaseexample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

	DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB=new DatabaseHelper(this, "app");
        setContentView(R.layout.activity_main);
    }
        
    public void doList(View v) {
		LinearLayout l = (LinearLayout) findViewById(R.id.mainView);
		l.removeAllViews();
		Cursor c = myDB.doQuery("SELECT name, age from students");
		while (c.moveToNext()) {
			String name = c.getString(c.getColumnIndex("name"));
			long age = c.getLong(c.getColumnIndex("age"));
			TextView t = new TextView(this);
			t.setText(name + ", " + age);
			l.addView(t);
		}
		c.close();
	}
    public void doInsert(View v){
    	String[] vals = {"Steve","23"};
    	myDB.doUpdate("Insert into students(name, age) values (?,?);", vals);
    }

	public void doQuery(View v){
		Cursor c = myDB.doQuery("SELECT name, age from students");
		while (c.moveToNext()){
				System.out.println(c.getString(c.getColumnIndex("name"))+","+c.getLong(c.getColumnIndex("age")));
		}
		c.close();
	}

	public void doAdd(View v){
		EditText nameInput = (EditText)findViewById(R.id.nameInput);
		EditText ageInput = (EditText)findViewById(R.id.ageInput);

		String name = nameInput.getText().toString();
		String age = ageInput.getText().toString();

		if (name.isEmpty() || age.isEmpty()) return;

		String[] vals = {name, age};
		myDB.doUpdate("Insert into students(name, age) values (?,?);", vals);

		nameInput.setText("");
		ageInput.setText("");
	}
}
