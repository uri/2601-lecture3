package com.uri;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Lecture3newActivity extends Activity {

	private BankAccount b1;
	private BankAccount b2;

	private EditText field1;
	private EditText field2;
	
	private Handler handler = new Handler();
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button b = (Button)findViewById(R.id.start_button);
        field1 = (EditText)findViewById(R.id.bank_field_1);
        field2 = (EditText)findViewById(R.id.bank_field_2);
        
        field1.setText("100");
        field2.setText("100");
        
        final Lecture3newActivity parent = this;
        
        b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				b1 = new BankAccount(Integer.parseInt(field1.getText().toString()));
		        b2 = new BankAccount(Integer.parseInt(field2.getText().toString()));
		        
		        Random rand = new Random();

		        for (int i = 0; i < 10; i++) {
		        	if (rand.nextBoolean()) {
		        		Log.i("bank", "Apple withdrawing from Balge.");
			        	new Thread(new BankThread("Apple", b1, b2, parent, 50, 10, 100)).start();
			        } else {
			        	Log.i("bank", "Bagel withdrawing from Apple.");
			        	new Thread(new BankThread("Bagel", b2, b1, parent, 30, 10, 100)).start();	
			        }
		        	
		
		        }
			}
		});
        
    }

	public EditText getField1() {
		return field1;
	}

	public void setField1(EditText field1) {
		this.field1 = field1;
	}

	public EditText getField2() {
		return field2;
	}

	public void setField2(EditText field2) {
		this.field2 = field2;
	}
	
	public Handler getHandler() {
		return handler;
	}
		
}