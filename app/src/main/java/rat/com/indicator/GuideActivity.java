package rat.com.indicator;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * Created by liangjinzhu on 16/5/24.
 */
public class GuideActivity extends FragmentActivity implements View.OnClickListener {
//    private Button guideBtn;
//    private Button tabMainBtn;
//    private Button slideTabMainBtn;
//    private Button springTabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
    }

    private void initView() {
//        guideBtn = (Button) findViewById(R.id.guideBtn);
//        tabMainBtn = (Button) findViewById(R.id.tabMainBtn);
//        slideTabMainBtn = (Button) findViewById(R.id.slideTabMainBtn);
//        springTabBtn = (Button) findViewById(R.id.springTabBtn);
//        guideBtn.setOnClickListener(this);
//        tabMainBtn.setOnClickListener(this);
//        slideTabMainBtn.setOnClickListener(this);
//        springTabBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guideBtn:
                break;
            case R.id.tabMainBtn:
                break;
            case R.id.slideTabMainBtn:
                break;
            case R.id.springTabBtn:
                break;
        }
    }
}

