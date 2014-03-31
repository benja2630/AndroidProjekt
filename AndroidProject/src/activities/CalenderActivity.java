package activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import dk.danielmachon.androidproject.Project;
import dk.danielmachon.androidproject.R;

public class CalenderActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_calender);
        
        Project project = openProject();
      

	}
    
    private Project openProject(){
    	Intent intent = getIntent();
    	Project currentProject = (Project)intent.getSerializableExtra("project");
    	return currentProject;
    }

}
