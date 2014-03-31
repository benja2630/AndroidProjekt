package dk.danielmachon.androidproject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import dk.danielmachon.androidproject.Member;

import org.json.simple.JSONObject;


public class Project implements Serializable {
	
	/* Project information */
	private String projectName = "";
	private String dateCreated = "";
	private int groupMembers = 0;
	private ArrayList<Member> memberList = null;
	private int numberOfAppointments = 0;
	
	/* Version number, for local-to-remote sync checking */
	private double version = 0.00;
	
	
	/* Create project object */
	public Project(String projectName, String dateCreated, int groupMembers,
			ArrayList<Member> memberList, int numberOfAppointments){
		
		this.projectName = projectName;
		this.dateCreated = dateCreated;
		this.groupMembers = groupMembers;
		this.memberList = memberList;
		this.numberOfAppointments = numberOfAppointments;
		
	}
	
	/* Write project data to a JSON object */
	private JSONObject writeJSON(){
		JSONObject json = new JSONObject();
		json.put("projectName", projectName);
		json.put("dateCreated", dateCreated);
		json.put("groupMembers", groupMembers);
		json.put("memberList", memberList);
		json.put("numberOfAppointments", numberOfAppointments);
		
		return json;
		
	}
	
	private JSONObject readJSON(){
		return new JSONObject();
	}
	
	/* Save project as a JSON object */
	public void saveProject(){
		try {
			
			JSONObject json = writeJSON();
            
            // Writing to a file  
            File file = new File(projectName+".json");  
            file.createNewFile();  
            FileWriter fileWriter = new FileWriter(file);  
            System.out.println("Writing JSON object to file");  
            System.out.println("-----------------------");  
            System.out.print(json);  
  
            fileWriter.write(json.toJSONString());  
            fileWriter.flush();  
            fileWriter.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  

	}
	
	public void loadProject(){
		
	}
	
	public static void main(String[] args){
		Member daniel = new Member("Daniel@Machon", "123456");
		Member benjamin = new Member("Benjamin@Prakash", "123456");
		ArrayList<Member> al = new ArrayList<Member>();
		al.add(daniel);
		al.add(benjamin);
		
		
		Project testProject = new Project("Android Project", "17-03-2014", 2,
				al, 0);
		
		testProject.saveProject();
	}
	
	public String getProjectName(){
		return projectName;
	}
	
	

}
