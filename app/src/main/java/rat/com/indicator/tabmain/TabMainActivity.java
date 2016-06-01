package rat.com.indicator.tabmain;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.viewpager.SViewPager;

import rat.com.indicator.R;

/**
 * Created by liangjinzhu on 16/5/30.
 */
public class TabMainActivity extends FragmentActivity {
    private String[] tabNames = {"主页", "消息", "发现", "我"};
    private int[] tabIcons = {R.drawable.maintab_1_selector, R.drawable.maintab_2_selector, R.drawable.maintab_3_selector, R.drawable.maintab_4_selector};
    private LayoutInflater inflater;

    private IndicatorViewPager indicatorViewPager;
    private SViewPager viewPager;
    private Indicator indicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabmain);
        inflater = LayoutInflater.from(getApplicationContext());
        viewPager = (SViewPager) findViewById(R.id.tabmainviewPager);
        indicator = (Indicator) findViewById(R.id.indicatorView);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(true);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(2);
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
                convertView = inflater.inflate(R.layout.tab_main, viewGroup, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(tabNames[i]);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, tabIcons[i], 0, 0);
            return textView;
        }

        @Override
        public Fragment getFragmentForPage(int i) {
            FirstLayerFragment fragment = new FirstLayerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("number", i);
            fragment.setArguments(bundle);
            return fragment;
        }
    }
}