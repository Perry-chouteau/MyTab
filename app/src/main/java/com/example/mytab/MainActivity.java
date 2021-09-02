package com.example.mytab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        button = (Button) this.findViewById(R.id.button);
        edtTextFName = findViewById(R.id.editTextFirstName);
        edtTextLName = findViewById(R.id.editTextLastName);
        edtNumberAge = findViewById(R.id.editNumberAge);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabLayout.addView(generateTableRow(edtTextFName.getText().toString(), edtTextLName.getText().toString(), edtNumberAge.getText().toString()), 0);
            }
        });
    }

    public TableRow generateTableRow(String fName, String lName, String age) {
        TableRow result = new TableRow(this);
        result.setPadding(10, 10, 10, 10);
        TextView view_fName = new TextView(this);
        TextView view_lName = new TextView(this);
        TextView view_Age = new TextView(this);

        view_fName.setText(fName);
        view_lName.setText(lName);
        view_Age.setText(age);

        result.addView(view_fName);
        result.addView(view_lName);
        result.addView(view_Age);

        if (i % 2 == 0) {
            result.setBackgroundColor(getResources().getColor(R.color.blueDark));
            view_fName.setPadding(5, 5, 5, 5);
            view_Age.setPadding(5, 5, 5, 5);
        } else
            result.setBackgroundColor(getResources().getColor(R.color.grey));
        ++i;
        return result;
    }
}