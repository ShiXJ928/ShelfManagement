package com.zq.sm.acty;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;

import com.zq.sm.R;
import com.zq.sm.bean.EquipmentBean;
import com.zq.sm.adapter.EquipmentListAdapter;
import com.zq.sm.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */

public class MainActy extends BaseActy {

    private ListView listView;
    private List<EquipmentBean> list;
    private EquipmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, 0, R.drawable.refresh, "苏州公安局高新分局警用装备管理系统", null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();
        list.add(new EquipmentBean("防弹防刺服", "NO001", 30, 10, 20));
        list.add(new EquipmentBean("防弹头盔", "NO002", 30, 10, 20));
        list.add(new EquipmentBean("喊话器", "NO003", 10, 1, 9));
        list.add(new EquipmentBean("警戒带", "NO004", 100, 25, 75));
        list.add(new EquipmentBean("警绳", "NO005", 80, 20, 60));
        listView = (ListView) findViewById(R.id.listview);
        adapter = new EquipmentListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_right:
//                startActivity(new Intent(this, LendEquipmentListActy.class));
                startActivity(new Intent(this, OverdueEquipmentActy.class));
                break;
        }
    }

    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        long secondTime = System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                System.exit(0);
            } else {
                ToastUtil.show("再按一次退出程序");
                firstTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
