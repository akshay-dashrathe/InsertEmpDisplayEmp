package com.example.insertempdisplayemp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity<DBHandler> extends AppCompatActivity {
    // creating variables for our edittext, button and dbhandler
    private EditText No, Name, Designation, Salary;
    private Button AddDetails;
    private DBHandler dbHandler;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        No = findViewById(R.id.idNo);
        Name = findViewById(R.id.idName);
        Designation = findViewById(R.id.idDesign);
        Salary = findViewById(R.id.idSal);
        AddDetails = findViewById(R.id.idBtnAddDetails);
        AddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // below line is to get data from all edit text fields.
                String Eno = No.getText().toString();
                String EName = Name.getText().toString();
                String Edesign = Designation.getText().toString();
                String Esalary = Salary.getText().toString();
                // validating if the text fields are empty or not.
                if (Eno.isEmpty() && EName.isEmpty() && Edesign.isEmpty() && Esalary.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, "Course has been added.",
                        Toast.LENGTH_SHORT).show();
                No.setText("");
                Name.setText("");
                Designation.setText("");
                Salary.setText("");
            }
        });
    }
}