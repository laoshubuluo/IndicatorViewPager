package rat.com.indicator.tabmain;

import android.os.Bundle;
import android.widget.TextView;

import com.shizhefei.fragment.LazyFragment;

import rat.com.indicator.R;

/**
 * Created by liangjinzhu on 16/6/1.
 */
public class SecondLayerFragment extends LazyFragment {
    private String name;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabmain_second);
        Bundle bundle = getArguments();
        name = bundle.getString("name");
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText(name);
    }
}