package com.upm.adapters;

import java.util.ArrayList;
import java.util.HashMap;

import com.upm.activities.MainActivity;
import com.upm.others.ImageLoader;
import com.upm.upmnotification.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends ArrayAdapter<String> {
	
	private final Context context;
	private static LayoutInflater inflater=null;
    public ImageLoader imageLoader; 

	public MainAdapter(Context context, String[] data) {
		super(context, R.layout.list_row, data);
	    this.context = context;
	    //this.data = data;
	    inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(context.getApplicationContext());
	}
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		System.out.println("Position : " + position);
	    View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, parent, false);
        
	    TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.artist); // artist name
        //TextView duration = (TextView)vi.findViewById(R.id.duration); // duration
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
        
        //HashMap<String, String> song = new HashMap<String, String>();
        //song = data.get(position);
        
        // Setting all values in listview
        //title.setText(song.get(MainActivity.KEY_TITLE));
        //artist.setText(song.get(MainActivity.KEY_ARTIST));
        //duration.setText(song.get(MainActivity.KEY_DURATION));
        //imageLoader.DisplayImage(song.get(MainActivity.KEY_THUMB), thumb_image);

	    return vi;
	  }

	
}
