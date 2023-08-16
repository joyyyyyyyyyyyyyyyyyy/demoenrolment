package sg.edu.rp.c346.id22022096.demoenrolment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvenrollment;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvenrollment = findViewById(R.id.lvenrollment);
        //create variable client as new obj
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //creates a new empty arraylist of weather objects using variable name alWeather
        ArrayList<Enrollment> alEnrolment = new ArrayList<Enrollment>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {

            int year;
            String type_of_study;
            int enrolment;

            //@Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonRecord = response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonRecord.getJSONArray("records");
                    for(int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject x = jsonArrRecords.getJSONObject(i);
                        year = x.getInt("year");
                        type_of_study = x.getString("type_of_study");
                        enrolment = x.getInt("enrolment");
                        Enrollment enrollment = new Enrollment(year, type_of_study,enrolment);
                        alEnrolment.add(enrollment);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                ArrayAdapter aaEnrolment=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alEnrolment);
                lvenrollment.setAdapter(aaEnrolment);

            }//end onSuccess
        });
    }//end onResume
}