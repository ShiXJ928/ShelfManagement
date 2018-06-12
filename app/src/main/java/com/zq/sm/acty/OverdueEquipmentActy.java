package com.zq.sm.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zq.sm.R;
import com.zq.sm.adapter.OverdueEquipmentListAdapter;
import com.zq.sm.bean.OverdueEquipmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class OverdueEquipmentActy extends BaseActy {

    private ListView listView;
    private List<OverdueEquipmentBean> list;
    private OverdueEquipmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_overdue_equipment_list_acty);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, 0, R.drawable.refresh, "过期装备", null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();
        list.add(new OverdueEquipmentBean("NAO056", "收拷", "2019-06-15"));
        list.add(new OverdueEquipmentBean("NE1572", "防弹头盔", "2018-05-18"));
        list.add(new OverdueEquipmentBean("NZ0603", "喊话器", "2018-06-15"));
        list.add(new OverdueEquipmentBean("ND3004", "防弹防刺服", "2018-06-12"));
        listView = (ListView) findViewById(R.id.listview);
        adapter = new OverdueEquipmentListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {

        }
    }
}
