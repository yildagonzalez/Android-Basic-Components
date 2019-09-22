package com.vogella.android.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // setting up components
    EditText etID;
    Button btnSubmit;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make a connection to UI components
        etID = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);

        // hide the result text for now
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get ID number from user
                String idNumber = etID.getText().toString().trim();

                // getting DOB (first 6 digits from string)
                String dob = idNumber.substring(0,6);

                // getting gender
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String isGender;

                if (gender < 5)
                    isGender = getString(R.string.female);

                else
                    isGender = getString(R.string.male);



                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String sNationality;

                if (nationality == 0)
                    sNationality = getString(R.string.sacit);
                else
                    sNationality = (String) getString(R.string.permanent);

                String text = getString(R.string.dob) + dob + "\n" +
                        getString(R.string.gender) + isGender + "\n" +
                        getString(R.string.nationality) + sNationality;
                // returning results to user
                tvResults.setText(text);

                tvResults.setVisibility(View.VISIBLE);

            }

        });


    }
}
