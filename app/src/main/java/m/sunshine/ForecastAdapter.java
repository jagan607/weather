package m.sunshine;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

/**
 * Created by kjaganmohan on 15/12/15.
 */
public class ForecastAdapter extends CursorAdapter {


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ForecastAdapter(Context context , Cursor c , int flags){super(context , c, flags);}
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_forecast,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {



    }
}
