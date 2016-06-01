package rat.com.indicator.tabmain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;

import rat.com.indicator.R;

/**
 * Created by liangjinzhu on 16/6/1.
 */
public class FirstLayerFragment extends LazyFragment {
    private String[] tabNames = {"1", "2", "3", "4"};

    private IndicatorViewPager indicatorViewPager;
    private ViewPager viewPager;
    private Indicator indicator;
    private String name;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabmain_first);
        Bundle bundle = getArguments();
        name = bundle.getString("name");

        inflater = LayoutInflater.from(getApplicationContext());
        viewPager = (ViewPager) findViewById(R.id.fragment_tablemain_viewPager);
        indicator = (Indicator) findViewById(R.id.fragment_tablemain_indicator);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(3);
    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int i, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.tab_top, viewGroup, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(name + "-" + tabNames[i]);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int i) {
            SecondLayerFragment fragment = new SecondLayerFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", name + "-" + tabNames[i]);
            fragment.setArguments(bundle);
            return fragment;
        }
    }
}