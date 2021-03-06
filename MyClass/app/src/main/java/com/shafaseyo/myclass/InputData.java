package com.shafaseyo.myclass;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InputData extends AppCompatActivity {

	protected Cursor cursor;
	DataHelper dbHelper;
	Button ton1;
	EditText text1, text2, text3, text4, text5;
	String edit;
	TextView tv1, tv2, tv3, tv4, tv5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_data);

		dbHelper = new DataHelper(this);
		text1 = findViewById(R.id.editText1);
		text2 = findViewById(R.id.editText2);
		text3 = findViewById(R.id.editText3);
		text4 = findViewById(R.id.editText4);
		text5 = findViewById(R.id.editText5);

		tv1 = findViewById(R.id.textView1);
		tv2 = findViewById(R.id.textView2);
		tv3 = findViewById(R.id.textView3);
		tv4 = findViewById(R.id.textView4);
		tv5 = findViewById(R.id.textView5);

		ton1 = findViewById(R.id.button1);
		ton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				edit = text1.getText().toString();
				edit = text2.getText().toString();
				edit = text3.getText().toString();
				edit = text4.getText().toString();
				edit = text5.getText().toString();

				if (edit.isEmpty()) {
					Toast.makeText(getApplicationContext(),"Kolom tidak boleh kosong..",Toast.LENGTH_SHORT).show();
				} else {
					db.execSQL("update biodata set nama='"+ text2.getText().toString() +"', tgl='"+ text3.getText().toString() +"', jk='"+ text4.getText().toString() +"', alamat='"+ text5.getText().toString() +"' where no='"+ text1.getText().toString() +"'");
					Toast.makeText(getApplicationContext(), "Perubahan Tersimpan..", Toast.LENGTH_LONG).show();
					finish();
				}
				DataBlink.DBL.RefreshList();
			}
		});
	}
}
