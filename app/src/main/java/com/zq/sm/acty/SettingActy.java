package com.zq.sm.acty;

import android.os.Bundle;
import android.view.View;

import com.zq.sm.R;
import com.zq.sm.application.App;

/**
 * Created by AIERXUAN on 2018/6/20.
 */

public class SettingActy extends BaseActy {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_setting);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "设置", "保存", R.color.text_blue, R.color.white);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
            case R.id.tv_right:
                App.sharedUtility.setEquipId("");
                break;
        }
    }
}
