package tictac.tictac.toe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {

	GridView board;
	SpotAdapter sa;
	boolean isXTurn = true;
	Spot[][] s = new Spot[3][3];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		board = (GridView)findViewById(R.id.mainBoard);

		for(int x = 0; x < 3; x++)
			for(int y = 0; y < 3; y++)
				s[x][y] = new Spot();
		sa = new SpotAdapter(this,R.layout.spot, s);
		board.setAdapter(sa);
		board.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				System.out.println("plpllp");
				// TODO Auto-generated method stub
				if(sa.getItem(arg2).status == Spot.Status.EMPTY){
					if(isXTurn) {
						sa.getItem(arg2).status = Spot.Status.X;
						isXTurn = false;
					} else{
						sa.getItem(arg2).status = Spot.Status.O;
						isXTurn = true;
					}
				}
				
				sa.notifyDataSetChanged();
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
//	public boolean checkBoard(){
//		
//	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		for(int x = 0; x < s.length; x++)
			for(int y = 0; y < s[x].length; y++)
				s[x][y] = new Spot();
		sa = new SpotAdapter(this,R.layout.spot, s);
		board.setAdapter(sa);
	}
	
	

}
