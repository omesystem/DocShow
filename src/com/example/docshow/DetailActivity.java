package com.example.docshow;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class DetailActivity extends Activity implements OnPageChangeListener,
OnItemSelectedListener, OnClickListener{
	
	private static final String TAG = "DetailActivity";
	private static final String INTENT_ID = "id";
	
	private Context mContext;
    private int mCurrentPage;
    private ViewPager mViewPager;
    private GuidePagerAdapter mAdapter;
    private TextView mPageTitle;
    private ImageView mWifiSetting;
    private View mIndicatorContainer;
    private ImageView mIndicator0;
    private ImageView mIndicator1;
    private ImageView mIndicator2;
    private ImageView mIndicator3;
    private ImageView mCurrentImage;
    
    private int mPageCnt = 4;
    private int mGuidId;
    


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Log.d(TAG, "onCreate");
		
        mContext = this;
        mPageTitle = (TextView) findViewById(R.id.pageTitle);

        mIndicatorContainer = findViewById(R.id.indicatorContainer);
        mIndicator0 = (ImageView) findViewById(R.id.indicator0);
        mIndicator1 = (ImageView) findViewById(R.id.indicator1);
        mIndicator2 = (ImageView) findViewById(R.id.indicator2);
        mIndicator3 = (ImageView) findViewById(R.id.indicator3);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setOffscreenPageLimit(4);
        mAdapter = new GuidePagerAdapter();
        mViewPager.setAdapter(mAdapter);
	}
	
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		Intent intent = getIntent();
		int mGuidId = intent.getIntExtra(INTENT_ID, -1);
		if(mGuidId < 0) {finish();}			
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_detail, menu);
		return true;
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onPageSelected ,arg0 = " + arg0);
		
		mCurrentPage = arg0;
		updateIndicator();	

	}
	
    private int getPageCount() {
		// TODO Auto-generated method stub
		return mPageCnt;
	}
    
    private int getPageType(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
    
	private int getPageLayoutId(int pageType) {
		// TODO Auto-generated method stub
        int layoutId = 0;
        switch (pageType) {
            case 0:
                layoutId = R.layout.image_show;
                break;
            case 1:
                layoutId = R.layout.image_show;
                break;
            case 2:
                layoutId = R.layout.image_show;
                break;
            case 3:
                layoutId = R.layout.image_show;
                break;
        }
        return layoutId;
	}
	
	   public void updateIndicator() {
	        switch (mCurrentPage) {
	            case 0:
	                mIndicatorContainer.setVisibility(View.VISIBLE);
	                if (mIndicator0.getVisibility() != View.VISIBLE) {
	                    mIndicator0.setVisibility(View.VISIBLE);
	                }
	                mIndicator0.setImageResource(R.drawable.ic_indicator_blue);
	                mIndicator1.setImageResource(R.drawable.ic_indicator_white);
	                mIndicator2.setImageResource(R.drawable.ic_indicator_white);
	                mIndicator3.setImageResource(R.drawable.ic_indicator_white);
	                break;
	            case 1:
	                mIndicatorContainer.setVisibility(View.VISIBLE);
	                if (mIndicator0.getVisibility() == View.VISIBLE) {
	                    mIndicator0.setImageResource(R.drawable.ic_indicator_white);
	                }
	                mIndicator1.setImageResource(R.drawable.ic_indicator_blue);
	                mIndicator2.setImageResource(R.drawable.ic_indicator_white);
	                mIndicator3.setImageResource(R.drawable.ic_indicator_white);
	                break;
	            case 2:
	                mIndicatorContainer.setVisibility(View.VISIBLE);
	                if (mIndicator0.getVisibility() == View.VISIBLE) {
	                    mIndicator0.setImageResource(R.drawable.ic_indicator_white);
	                }
	                mIndicator1.setImageResource(R.drawable.ic_indicator_white);
	                mIndicator2.setImageResource(R.drawable.ic_indicator_blue);
	                mIndicator3.setImageResource(R.drawable.ic_indicator_white);
	                break;
	            case 3:
	                mIndicatorContainer.setVisibility(View.VISIBLE);
	                if (mIndicator0.getVisibility() == View.VISIBLE) {
	                    mIndicator0.setImageResource(R.drawable.ic_indicator_white);
	                }
	                mIndicator1.setImageResource(R.drawable.ic_indicator_white);
	                mIndicator2.setImageResource(R.drawable.ic_indicator_white);
	                mIndicator3.setImageResource(R.drawable.ic_indicator_blue);
	                break;
	        }
	    }
	
	   private Bitmap getImageFromAssetsFile(String fileName)  
	   {  
	       Bitmap image = null;  
	       AssetManager am = getResources().getAssets();  
	       try  
	       {  
	           InputStream is = am.open(fileName);  
	           image = BitmapFactory.decodeStream(is);  
	           is.close();  
	       }  
	       catch (IOException e)  
	       {  
	           e.printStackTrace();  
	       }  
	   
	       return image;  
	   
	   }  
	   
	public class GuidePagerAdapter extends PagerAdapter {
        private int mPageCount;

        public GuidePagerAdapter() {
            mPageCount = getPageCount();
            Log.v(TAG, "getPageCount=" + mPageCount);
        }

		public void setCount(int count) {
            if (count <= 0)
                return;
            mPageCount = count;
        }

        @Override
        public int getCount() {
            return mPageCount;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Log.d(TAG, "instantiateItem ,position = " + position);

            int pageType = position % 4;
            Log.d(TAG, "instantiateItem ,pageType = " + pageType);
            int layoutId = getPageLayoutId(pageType);
            View convertView = LayoutInflater.from(DetailActivity.this).inflate(
                    layoutId, null);
            mCurrentImage = (ImageView) convertView.findViewById(R.id.imageView1);
            setupPagerViews(pageType, convertView);

            ((ViewPager) container).addView(convertView);
            return convertView;
        }

		@Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.d(TAG, "destroyItem ,position = " + position);
            ((ViewPager) container).removeView((View) object);
        }
    }

	public void setupPagerViews(int pageType, View convertView) {
		// TODO Auto-generated method stub
		Log.d(TAG, "setupPagerViews ,pageType = " + pageType);
        if (convertView == null)
            return;

		switch (pageType) {
		case 0:
			mCurrentImage.setImageResource(R.drawable.ic_1);
			break;
		case 1:
			mCurrentImage.setImageResource(R.drawable.ic_2);
			break;
		case 2:
			mCurrentImage.setImageResource(R.drawable.ic_3);
			break;
		case 3:
			mCurrentImage.setImageResource(R.drawable.ic_1);
			break;

		default:
			break;
		}
	}

}
