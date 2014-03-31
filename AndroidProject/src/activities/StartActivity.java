package activities;


import dk.danielmachon.androidproject.R;
import dk.danielmachon.androidproject.R.id;
import dk.danielmachon.androidproject.R.layout;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class StartActivity extends Activity implements OnClickListener  {
	
	/* Global variables */
	private TextView header = null;
	private EditText user_et = null;
	private EditText password_et = null;
	private CheckBox checkBox = null;
	private Button loginButton = null;
	private Button registerButton = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_start);

        /* Instantiate GUI components */
        header = (TextView) findViewById(R.id.header);
        user_et = (EditText) findViewById(R.id.user_et);
        password_et = (EditText) findViewById(R.id.password_et);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        loginButton =  (Button) findViewById(R.id.loginButton);
        registerButton =  (Button) findViewById(R.id.registerButton);
        
        /* Attach onClick listeners to buttons */
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
        
        /* Attempt to fetch Google Play account.
         * Returns empty string if unsuccessful */
        user_et.setText(getGooglePlayInfo());
	}
	
	@Override
	public void onClick(View view){
		
		if(view == loginButton){
			Intent projectIntent = new Intent(StartActivity.this, ProjectActivity.class);
			projectIntent.putExtra("key", 1); //Optional parameters
			StartActivity.this.startActivity(projectIntent);
		}
		
		else{
			Intent NewProjectIntent = new Intent(StartActivity.this, NewProjectActivity.class);
			StartActivity.this.startActivity(NewProjectIntent);
		}
		
	}
	
	/* Fetch Google Play account information */
	private String getGooglePlayInfo(){
		AccountManager manager = (AccountManager) getSystemService(ACCOUNT_SERVICE);
		Account[] list = manager.getAccounts();
		String gmail = "";

		for(Account account: list)
		{
			if(account.type.equalsIgnoreCase("com.google"))
			{
				gmail = account.name;
				break;
			}
		}
		
		if(gmail.equals("")){
			Toast.makeText(getApplicationContext(), "Couldn't retrieve Google Play account!",
					   Toast.LENGTH_LONG).show();
		}
		
		return gmail;
		
	}
	

	

}
