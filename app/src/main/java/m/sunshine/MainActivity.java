package m.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    
    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "change location", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }
            });
        }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id==R.id.action_settings){
            startActivity(new Intent(this , SettingActivity.class));
        }
         if (id == R.id.action_map) {
                openPreferredLocationInMap();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
        private void openPreferredLocationInMap(){

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String location = sharedPrefs.getString(
                                getString(R.string.pref_location_key),
                                getString(R.string.pref_location_default));
                // Using the URI scheme for showing a location found on a map.  This super-handy
                                // intent can is detailed in the "Common Intents" page of Android's developer site:
                                        // http://developer.android.com/guide/components/intents-common.html#Maps
                                                Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                                .appendQueryParameter("q", location)
                                .build();

                        Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);

                        if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed!");
                    }


    }


    }

