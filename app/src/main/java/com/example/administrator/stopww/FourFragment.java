package com.example.administrator.stopww;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.handstudio.android.hzgrapherlib.animation.GraphAnimation;
import com.handstudio.android.hzgrapherlib.graphview.BarGraphView;
import com.handstudio.android.hzgrapherlib.vo.GraphNameBox;
import com.handstudio.android.hzgrapherlib.vo.bargraph.BarGraph;
import com.handstudio.android.hzgrapherlib.vo.bargraph.BarGraphVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourFragment extends Fragment {
	public static final String TAG = "_ACTIVITY";
	private ListView listView = null;
	private ListAdapter listAdapter = null;
	private ArrayAdapter<String> arrayAdapter;
	public String[] location = {"London", "Seoul", "paris"};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fourfragment, container, false);
		listView = (ListView) view.findViewById(R.id.list);
		//listAdapter = listView.getAdapter();

		arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, location);
		listView.setAdapter(arrayAdapter);
		listView.setOnItemClickListener(mItemClickListener);

		return view;
	}
	private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
								long l_position) {
			// parent는 AdapterView의 속성의 모두 사용 할 수 있다.
			String tv = (String) parent.getAdapter().getItem(position);
			Toast.makeText(getActivity(), tv, Toast.LENGTH_SHORT).show();

			// view는 클릭한 Row의 view를 Object로 반환해 준다.
			TextView tv_view = (TextView) view.findViewById(R.id.text_low);
			//tv_view.setText("CHANGED");
			// l_Position 은 클릭한 Row의 long type의 position 을 반환해 준다.
			Toast.makeText(getActivity(), "lndex = " + l_position, Toast.LENGTH_SHORT).show();
		}
	};
}