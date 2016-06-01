package rat.com.indicator.guide;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;

import rat.com.indicator.R;

/**
 * Created by liangjinzhu on 16/5/24.
 */
public class GuideActivity extends FragmentActivity {
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflater;
    private ViewPager viewPager;
    private FixedIndicatorView indicatorView;
    private int[] images = {R.mipmap.guid1, R.mipmap.guid2, R.mipmap.guid3, R.mipmap.guid4, R.mipmap.guid5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
        inflater = LayoutInflater.from(getApplicationContext());
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicatorView = (FixedIndicatorView) findViewById(R.id.indicatorView);
        indicatorViewPager = new IndicatorViewPager(indicatorView, viewPager);
        indicatorViewPager.setAdapter(adapter);
    }

    private IndicatorViewPager.IndicatorPagerAdapter adapter = new IndicatorViewPager.IndicatorViewPagerAdapter() {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_guide, viewGroup, false);
            }
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = new View(getApplicationContext());
                convertView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
            convertView.setBackgroundResource(images[position]);
            return convertView;
        }
    };
}

