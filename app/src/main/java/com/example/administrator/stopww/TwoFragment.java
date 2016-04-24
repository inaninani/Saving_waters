package com.example.administrator.stopww;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.handstudio.android.hzgrapherlib.animation.GraphAnimation;
import com.handstudio.android.hzgrapherlib.graphview.LineGraphView;
import com.handstudio.android.hzgrapherlib.vo.GraphNameBox;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraph;
import com.handstudio.android.hzgrapherlib.vo.linegraph.LineGraphVO;

public class TwoFragment extends Fragment implements OnClickListener {

	private ViewGroup layoutGraphView;

	//@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.twofragment, container, false);
		//layoutGraphView = (ViewGroup) v.findViewById(R.id.layoutGraphView);
		//setLineGraph();

		return v;
	}



	private void setLineGraph() {
		//all setting
		LineGraphVO vo = makeLineGraphAllSetting();

		//default setting
//		LineGraphVO vo = makeLineGraphDefaultSetting();

		layoutGraphView.addView(new LineGraphView(this.getActivity(), vo));
	}

	/**
	 * make simple line graph
	 * @return
	 */
	private LineGraphVO makeLineGraphDefaultSetting() {

		String[] legendArr 	= {"1","2","3","4","5"};
		float[] graph1 		= {500,100,300,200,100};
		float[] graph2 		= {000,100,200,100,200};
		float[] graph3 		= {200,500,300,400,000};

		List<LineGraph> arrGraph 		= new ArrayList<LineGraph>();
		arrGraph.add(new LineGraph("android", 0xaa66ff33, graph1));
		arrGraph.add(new LineGraph("ios", 0xaa00ffff, graph2));
		arrGraph.add(new LineGraph("tizen", 0xaaff0066, graph3));

		LineGraphVO vo = new LineGraphVO(legendArr, arrGraph);
		return vo;
	}

	/**
	 * make line graph using options
	 * @return
	 */
	private LineGraphVO makeLineGraphAllSetting() {
		//BASIC LAYOUT SETTING
		//padding
		int paddingBottom 	= LineGraphVO.DEFAULT_PADDING;
		int paddingTop 		= LineGraphVO.DEFAULT_PADDING;
		int paddingLeft 	= LineGraphVO.DEFAULT_PADDING;
		int paddingRight 	= LineGraphVO.DEFAULT_PADDING;

		//graph margin
		int marginTop 		= LineGraphVO.DEFAULT_MARGIN_TOP;
		int marginRight 	= LineGraphVO.DEFAULT_MARGIN_RIGHT;

		//max value
		int maxValue 		= LineGraphVO.DEFAULT_MAX_VALUE;

		//increment
		int increment 		= LineGraphVO.DEFAULT_INCREMENT;

		//GRAPH SETTING
		String[] legendArr 	= {"1","2","3","4","5"};
		float[] graph1 		= {500,100,300,200,100};
		float[] graph2 		= {000,100,200,100,200};
		float[] graph3 		= {200,500,300,400,000};

		List<LineGraph> arrGraph 		= new ArrayList<LineGraph>();

		arrGraph.add(new LineGraph("android", 0xaa66ff33, graph1, 0));
		arrGraph.add(new LineGraph("ios", 0xaa00ffff, graph2));
		arrGraph.add(new LineGraph("tizen", 0xaaff0066, graph3));

		LineGraphVO vo = new LineGraphVO(
				paddingBottom, paddingTop, paddingLeft, paddingRight,
				marginTop, marginRight, maxValue, increment, legendArr, arrGraph);

		//set animation
		vo.setAnimation(new GraphAnimation(GraphAnimation.LINEAR_ANIMATION, GraphAnimation.DEFAULT_DURATION));
		//set graph name box
		vo.setGraphNameBox(new GraphNameBox());
		//set draw graph region
//		vo.setDrawRegion(true);

		//use icon
//		arrGraph.add(new Graph(0xaa66ff33, graph1, R.drawable.icon1));
//		arrGraph.add(new Graph(0xaa00ffff, graph2, R.drawable.icon2));
//		arrGraph.add(new Graph(0xaaff0066, graph3, R.drawable.icon3));

//		LineGraphVO vo = new LineGraphVO(
//				paddingBottom, paddingTop, paddingLeft, paddingRight,
//				marginTop, marginRight, maxValue, increment, legendArr, arrGraph, R.drawable.bg);
		return vo;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {



		}

	}

}
