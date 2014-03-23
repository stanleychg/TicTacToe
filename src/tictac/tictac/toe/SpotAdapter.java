package tictac.tictac.toe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SpotAdapter extends ArrayAdapter<Spot>{

	int layoutId;
	Context c;
	Spot[] s;
	public SpotAdapter(Context context, int layoutId, Spot[] objects) {
		super(context, layoutId, objects);
		// TODO Auto-generated constructor stub
		s = objects;
		c = context;
		this.layoutId = layoutId;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = convertView;
		if(v == null){
			LayoutInflater li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.spot, null);
		}
		
		ImageView ib = (ImageView)v.findViewById(R.id.spot);
		switch(s[position/3][position%3].status){
		case EMPTY:
			break;
		case X:
			ib.setImageResource(R.drawable.x);
			break;
		case O:
			ib.setImageResource(R.drawable.o_custom);
			break;
		}
		
		
		return v;
	}
	
	
	
}
