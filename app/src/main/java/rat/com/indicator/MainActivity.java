package rat.com.indicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import rat.com.indicator.guide.GuideActivity;
import rat.com.indicator.tabmain.TabMainActivity;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private Button guideBtn;
    private Button tabMainBtn;
    private Button slideTabMainBtn;
    private Button springTabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        guideBtn = (Button) findViewById(R.id.guideBtn);
        tabMainBtn = (Button) findViewById(R.id.tabMainBtn);
        slideTabMainBtn = (Button) findViewById(R.id.slideTabMainBtn);
        springTabBtn = (Button) findViewById(R.id.springTabBtn);
        guideBtn.setOnClickListener(this);
        tabMainBtn.setOnClickListener(this);
        slideTabMainBtn.setOnClickListener(this);
        springTabBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.guideBtn:
                intent = new Intent(MainActivity.this, GuideActivity.class);
                startActivity(intent);
                break;
            case R.id.tabMainBtn:
                intent = new Intent(MainActivity.this, TabMainActivity.class);
                startActivity(intent);
                break;
            case R.id.slideTabMainBtn:
                break;
            case R.id.springTabBtn:
                break;
        }
    }
}
