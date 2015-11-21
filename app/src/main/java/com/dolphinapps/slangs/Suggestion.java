package com.dolphinapps.slangs;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Suggestion extends Activity implements OnClickListener{
	private Button btnSubmit;
    private EditText etName;
    private EditText etEmail;
    private EditText etSubject;
    private EditText etMessage;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    setContentView(R.layout.suggestion_activity);
		btnSubmit  = (Button) findViewById(R.id.btnSubmit_suggestion_activity);
        etName     = (EditText) findViewById(R.id.edtname_suggestion_activity);
        etSubject  = (EditText) findViewById(R.id.edtsubject_suggestion_activity);
        etMessage  = (EditText) findViewById(R.id.edtmessage_suggestion_activity);
        
        btnSubmit. setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		 switch(v.getId()){
            case R.id.btnSubmit_suggestion_activity:
                 sendMail();
                 break;
		}
	}
	private void sendMail(){
        String name      = "" 						+ etName.getText();
        String emailID 	 = WbConfig.suggestionEmail;
        String sub       = "Business Card Creator " + etSubject.getText() ;
        String message   = "" + etMessage.getText() + "\n Send from android" ;
        Intent email     = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{emailID});
        email.putExtra(Intent.EXTRA_SUBJECT, sub);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
	
}
