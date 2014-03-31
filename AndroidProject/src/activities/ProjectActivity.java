package activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.TextView;
import android.widget.Toast;
import dk.danielmachon.androidproject.ExpandableListAdapter;
import dk.danielmachon.androidproject.R;

public class ProjectActivity extends Activity implements OnClickListener, OnChildClickListener{
	
	/* Global variables */
	private TextView header = null;
	private ExpandableListView expList = null;
	private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_project);
        
        header = (TextView) findViewById(R.id.header);
        expList = (ExpandableListView) findViewById(R.id.expList);
 
        
        /* Get listview */
        expListView = (ExpandableListView) findViewById(R.id.expList);
 
        /* Preparing list data */
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        /* Setting list adapter */
        expListView.setAdapter(listAdapter);
        
        /* Attach OnChildClickListener to ExpandableListView */
        expListView.setOnChildClickListener(this); 
        
        
    }
    

    
	@Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {
        Toast.makeText(
                getApplicationContext(),
                listDataHeader.get(groupPosition)
                        + " : "
                        + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                .show();
        return false;
    }
    
    
    
	@Override
	public void onClick(View view) {
		/* Not implemented yet */
	}
    

    
    private void prepareListData() {
    	
    	/* Instantiate data structures */
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        /* Adding child data */
        listDataHeader.add("Projects");
        listDataHeader.add("Other stuff");

 
        /* Adding child data */
        List<String> projects = new ArrayList<String>();
        projects.add("Android Project");
        projects.add("C# project");

        List<String> other = new ArrayList<String>();
  
        listDataChild.put(listDataHeader.get(0), projects); // Header, Child data
        listDataChild.put(listDataHeader.get(1), other);
    }






}
