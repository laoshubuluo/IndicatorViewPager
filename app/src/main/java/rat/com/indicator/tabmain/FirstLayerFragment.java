package rat.com.indicator.tabmain;

import android.os.Bundle;
import android.widget.TextView;

import com.shizhefei.fragment.LazyFragment;

import rat.com.indicator.R;

/**
 * Created by liangjinzhu on 16/6/1.
 */
public class FirstLayerFragment extends LazyFragment {
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabmain);
        Bundle bundle = getArguments();
        int i = bundle.getInt("number");
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText("这里是第 【" + i + "】个fragment");
    }
}