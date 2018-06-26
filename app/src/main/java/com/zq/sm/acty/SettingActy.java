package com.zq.sm.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zq.sm.R;
import com.zq.sm.application.App;
import com.zq.sm.util.ToastUtil;

/**
 * Created by AIERXUAN on 2018/6/20.
 */

public class SettingActy extends BaseActy {

    private EditText et_equipId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_setting);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "设置", "保存", R.color.text_blue, R.color.white);
        et_equipId = (EditText) findViewById(R.id.et_equipId);
        et_equipId.setText(App.sharedUtility.getEquipId());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
            case R.id.tv_right:
                if (et_equipId.getText().toString().replace(" ", "").equals("")) {
                    ToastUtil.show("设备编号不能为空");
                    break;
                }
                App.sharedUtility.setEquipId(et_equipId.getText().toString());
                setResult(RESULT_OK);
                finish();
                break;
        }
    }
}
