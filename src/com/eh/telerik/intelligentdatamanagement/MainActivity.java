package com.eh.telerik.intelligentdatamanagement;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.query.definition.FieldsDefinition;
import com.telerik.everlive.sdk.core.query.definition.expand.ExpandDefinition;
import com.telerik.everlive.sdk.core.result.RequestResult;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new FetchDataItems().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	private class FetchDataItems extends AsyncTask<Void, Void, Void> {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		protected Void doInBackground(Void... arg0) {
	        EverliveApp app = new EverliveApp(getString(R.string.telerik_key));
	        
			ArrayList<String> fieldsArray = new ArrayList<String>();
			fieldsArray.add("DisplayName");
			fieldsArray.add("Description");
			
			FieldsDefinition fields = new FieldsDefinition();
			fields.setIncludedFields(fieldsArray);
			
			ExpandDefinition expand = new ExpandDefinition("Tags", "ItemTags");
			expand.setFieldsDefinition(fields);
	        
	        RequestResult result = app.workWith().data(ServerDataItem.class).getAll().expand(expand).executeSync();	        
	        
	        if (result.getSuccess()) {
	        	ArrayList<ServerDataItem> items = (ArrayList<ServerDataItem>)result.getValue();
	        	for (ServerDataItem item : items) {
	        		Log.i("MainActivity", item.getTitle());
	        	}
	        	
	        } else {
	        	Log.i("MainActivity", "ERROR! ERROR! ERROR!");
	        }			
			
			return null;
		}    	
    }
}
