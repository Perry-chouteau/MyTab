package com.example.mytab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TableLayout tabLayout;

    EditText edtTextFName;
    EditText edtTextLName;
    EditText edtNumberAge;

    Button button;

    Integer i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tableLayout);
        button = findViewById(R.id.button);
        edtTextFName = findViewById(R.id.editTextFirstName);
        edtTextLName = findViewById(R.id.editTextLastName);
        edtNumberAge = findViewById(R.id.editNumberAge);

        button.setOnClickListener( (View view) -> {
                tabLayout.addView(generateTableRow(edtTextFName.getText().toString(), edtTextLName.getText().toString(), edtNumberAge.getText().toString()), 1);
        });
    }

    public TableRow generateTableRow(String fName, String lName, String age) {
        TableRow result = new TableRow(this);
        result.setPaddingRelative(10, 10, 10, 10);
        TextView view_fName = new TextView(this);
        TextView view_lName = new TextView(this);
        TextView view_Age = new TextView(this);
//
        view_fName.setText(fName);
        view_lName.setText(lName);
        view_Age.setText(age);
//
        view_fName.setWidth(0);
        view_fName.setMaxLines(1);
        view_lName.setWidth(0);
        view_lName.setMaxLines(1);
        view_Age.setWidth(0);
        view_Age.setMaxLines(1);
//
        view_fName.setTextColor(getResources().getColor(R.color.white));
        view_lName.setTextColor(getResources().getColor(R.color.white));
        view_Age.setTextColor(getResources().getColor(R.color.white));
//
        result.setGravity(Gravity.CENTER);

        view_Age.setGravity(Gravity.CENTER);
        view_fName.setGravity(Gravity.CENTER);
        view_lName.setGravity(Gravity.CENTER);
//
        result.setPadding(50, 50,50, 50);
//
       if (i % 2 == 0) {
           result.setBackgroundColor(getResources().getColor(R.color.blueDark));
       } else {
           result.setBackgroundColor(getResources().getColor(R.color.blueLight));
       }
 //
        result.addView(view_fName);
        result.addView(view_lName);
        result.addView(view_Age);
//
        ++i;
        return result;
    }
}

