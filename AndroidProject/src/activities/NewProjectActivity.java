package activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import dk.danielmachon.androidproject.Project;
import dk.danielmachon.androidproject.R;

public class NewProjectActivity extends Activity implements OnClickListener, OnItemSelectedListener{
	
	private EditText editText2 = null;
	private EditText editText3 = null;
	private EditText editText4 = null;
	private EditText editText5 = null;
	private EditText editText6 = null;
	private EditText editText7 = null;
	private Button createButton = null;
	private Spinner spinner = null;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_new_project);

        /* Instantiate GUI components */
        spinner = (Spinner) findViewById(R.id.spinner1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        createButton = (Button) findViewById(R.id.createButton);
        
        createButton.setOnClickListener(this);
        spinner.setOnItemSelectedListener(this);;
        
	}

	@Override
	public void onClick(View view) {
		
		if(view == createButton){
			Project project = createProject();
			Intent CalendarIntent = new Intent(NewProjectActivity.this, CalenderActivity.class);
			CalendarIntent.putExtra("project", project);
			NewProjectActivity.this.startActivity(CalendarIntent);
		}
		else{
			int num = Integer.parseInt(spinner.getSelectedItem().toString());
			setEditTectsFields(num);
		}
		
	}
	
	private void setEditTectsFields(int num, boolean show){
		switch(num){
		case 1:
			editText2.setEnabled(show);
			editText2.setClickable(show);
		case 2:
			editText2.setEnabled(show);
			editText2.setClickable(show);
			editText3.setEnabled(show);
			editText3.setClickable(show);
		case 3:
			editText2.setEnabled(show);
			editText2.setClickable(show);
			editText3.setEnabled(show);
			editText3.setClickable(show);
			editText4.setEnabled(show);
			editText4.setClickable(show);
		case 4:
			editText2.setEnabled(show);
			editText2.setClickable(show);
			editText3.setEnabled(show);
			editText3.setClickable(show);
			editText4.setEnabled(show);
			editText4.setClickable(show);
			editText5.setEnabled(show);
			editText5.setClickable(show);
		case 5:
			editText2.setEnabled(show);
			editText2.setClickable(show);
			editText3.setEnabled(show);
			editText3.setClickable(show);
			editText4.setEnabled(show);
			editText4.setClickable(show);
			editText5.setEnabled(show);
			editText5.setClickable(show);
			editText6.setEnabled(show);
			editText6.setClickable(show);
		case 6:
			editText2.setEnabled(show);
			editText2.setClickable(show);
			editText3.setEnabled(show);
			editText3.setClickable(show);
			editText4.setEnabled(show);
			editText4.setClickable(show);
			editText5.setEnabled(show);
			editText5.setClickable(show);
			editText6.setEnabled(show);
			editText6.setClickable(show);
			editText7.setEnabled(show);
			editText7.setClickable(show);
		}
	}
	
	private void createTextFields(int number){
		
	}
	
	private Project createProject(){
		Project project = new Project(editText2.getText().toString(), "", 
				Integer.parseInt(spinner.getSelectedItem().toString()), 
				new ArrayList(), 0);
		
		project.saveProject();
		
		return project;
	}



	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		int num = Integer.parseInt(spinner.getSelectedItem().toString());
		setEditTectsFields(num, true);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
