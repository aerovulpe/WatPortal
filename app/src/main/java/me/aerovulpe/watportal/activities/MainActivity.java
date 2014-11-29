package me.aerovulpe.watportal.activities;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import me.aerovulpe.watportal.R;
import me.aerovulpe.watportal.resources.Resource;
import me.aerovulpe.watportal.constants.WatObject;
import me.aerovulpe.watportal.constants.WatObjectHandler;
import me.aerovulpe.watportal.rawdata.GetJSONData;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view for testing purposes.
     */
    public static class PlaceholderFragment extends Fragment implements WatObjectHandler {

        //testing!
        EditText queries;
        Button submit;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            queries = (EditText) getView().findViewById(R.id.editText);
            submit = (Button) getView().findViewById(R.id.button);


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> params = new ArrayList<String>();
                    String raw = queries.getText().toString();

                    String[] split = raw.split(" ");
                    for (String word : split) {
                        if (word.length() > 0)  // eliminate blank lines
                            params.add(word);
                    }

                    ((TextView) getView().findViewById(R.id.textView)).setText("Check LogCat for data returned.");

                    String[] args = params.toArray(new String[params.size()]);
                    //GetJSONData jsonData = new GetJSONData(Resource.COURSES, "", "10", "", "3", "4", "MATH");
                    GetJSONData jsonData = new GetJSONData(Resource.FOOD_DIETS, args);
                    jsonData.execute(PlaceholderFragment.this);
                }
            });
        }

        @Override
        public void setWatObject(WatObject watObject) {
            //testing
            Log.d("TESTING", watObject.toString());
        }
    }
}