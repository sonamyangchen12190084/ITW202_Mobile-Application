package edu.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editname, editsurname,editmarks,editidnumber;
    Button btnADDDATA, btnVIEWALL,btnUPDATE,btnDELETE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DataBaseHelper(this);
        editname = findViewById(R.id.first_name);
        editsurname = findViewById(R.id.second_name);
        editmarks = findViewById(R.id.ITW2002_MARKS);
        editidnumber = findViewById(R.id.ID_number);
        btnADDDATA = findViewById(R.id.add_data);
        btnVIEWALL = findViewById(R.id.view_all);
        btnUPDATE= findViewById(R.id.update);
        btnDELETE = findViewById(R.id.delete);
    }

    public void ADD_DATA(View view) {
        btnADDDATA.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editidnumber.getText().toString(),
                                editname.getText().toString(),
                                editsurname.getText().toString(),
                                editmarks.getText().toString());

                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void viewall(View view) {
        btnVIEWALL.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Student Id : "+ res.getString(0)+"\n");
                            buffer.append("First Name : "+ res.getString(1)+"\n");
                            buffer.append("Last Name: "+ res.getString(2)+"\n");
                            buffer.append("ITW202 Marks : "+ res.getString(3)+"\n");
                        }

                        showMessage("List of Student",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

    public void update(View view) {
        btnUPDATE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editidnumber.getText().toString(),
                                editname.getText().toString(),
                                editsurname.getText().toString(),editmarks.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Update",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    public void delete(View view) {
        btnDELETE.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleteRows = myDb.deleteData(editidnumber.getText().toString());
                        if(deleteRows > 0)
                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}