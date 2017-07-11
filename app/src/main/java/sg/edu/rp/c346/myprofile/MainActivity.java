package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox ckbLike;

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strname = prefs.getString("name", "John");

        etName.setText(strname);


    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor preEdit = prefs.edit();

        preEdit.putString("name", strName);

        preEdit.commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGPA = (EditText) findViewById(R.id.editTextGPA);
        etName = (EditText) findViewById(R.id.editTextName);
        rgGender = (RadioGroup) findViewById(R.id.RadioG);
        ckbLike = (CheckBox) findViewById(R.id.CheckBoxLikeProgramming);


        ckbLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ckbLike.isChecked()) {
                    ckbLike.setChecked(true);
                }
                    else {
                    ckbLike.setChecked(false);
                    }

                }

        });

    }


}

