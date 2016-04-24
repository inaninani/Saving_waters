package com.example.administrator.stopww;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements OnClickListener {

	final String TAG = "MainActivity";
	int mCurrentFragmentIndex;
	public final static int FRAGMENT_MAP = 0;
	public final static int FRAGMENT_TWO = 1;
	public final static int FRAGMENT_THREE = 2;
	public final static int FRAGMENT_FOUR = 3;
    private BackPressCloseHandler backPressCloseHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        //버튼 리소스를 뷰로 전개
        View myButtonLayout = getLayoutInflater().inflate(R.layout.button, null);
        //액션바의 인스턴스 생성
        ActionBar ab = getSupportActionBar();
        //액션바의 커스텀 영역에 버튼 뷰 추가
        ab.setCustomView(myButtonLayout);
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_CUSTOM);

		Button bt_oneFragment = (Button) findViewById(R.id.bt_mapFragment);
		bt_oneFragment.setOnClickListener(this);
		Button bt_twoFragment = (Button) findViewById(R.id.bt_twoFragment);
		bt_twoFragment.setOnClickListener(this);
		Button bt_threeFragment = (Button) findViewById(R.id.bt_threeFragment);
		bt_threeFragment.setOnClickListener(this);
		Button bt_fourFragment = (Button) findViewById(R.id.bt_fourFragment);
		bt_fourFragment.setOnClickListener(this);

		mCurrentFragmentIndex = FRAGMENT_MAP;
        backPressCloseHandler = new BackPressCloseHandler(this);
		fragmentReplace(mCurrentFragmentIndex);
	}
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        backPressCloseHandler.onBackPressed();
    }
    public void MapFragmentReplace() {
        MapFragment mapFragment = new MapFragment();
        // replace fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.ll_fragment, mapFragment).commit();
    }

    public void onBtnClicked(View view){
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll_fragment);
        switch (view.getId()){
            case R.id.white:
                ll.setBackgroundColor(Color.WHITE);
                break;
            case R.id.black:
                ll.setBackgroundColor(Color.BLACK);
        }
    }

    public void fragmentReplace(int reqNewFragmentIndex) {

		Fragment newFragment = null;

		Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

		newFragment = getFragment(reqNewFragmentIndex);

		// replace fragment
		final FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();

		transaction.replace(R.id.ll_fragment, newFragment);

		// Commit the transaction
		transaction.commit();

	}

	private Fragment getFragment(int idx) {
		Fragment newFragment = null;

		switch (idx) {
		case FRAGMENT_MAP:
            newFragment = new MapFragment();
			break;
		case FRAGMENT_TWO:
			newFragment = new TwoFragment();
			break;
		case FRAGMENT_THREE:
			newFragment = new ThreeFragment();
			break;
			case FRAGMENT_FOUR:
				newFragment = new FourFragment();
				break;

		default:
			Log.d(TAG, "Unhandle case");
			break;
		}
		return newFragment;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {

		case R.id.bt_mapFragment:
			mCurrentFragmentIndex = FRAGMENT_MAP;
			fragmentReplace(mCurrentFragmentIndex);
			break;
		case R.id.bt_twoFragment:
			mCurrentFragmentIndex = FRAGMENT_TWO;
			fragmentReplace(mCurrentFragmentIndex);
			break;
		case R.id.bt_threeFragment:
				mCurrentFragmentIndex = FRAGMENT_THREE;
				fragmentReplace(mCurrentFragmentIndex);
				break;
			case R.id.bt_fourFragment:
				mCurrentFragmentIndex = FRAGMENT_FOUR;
				fragmentReplace(mCurrentFragmentIndex);
				break;

		}

	}

}
