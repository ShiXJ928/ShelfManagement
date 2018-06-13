package com.zq.sm.acty;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.zq.sm.R;
import com.zq.sm.adapter.LendEquipmentListAdapter;
import com.zq.sm.bean.LendEquipmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class LendEquipmentListActy extends BaseActy {

    private ListView listView;
    private List<LendEquipmentBean> list;
    private LendEquipmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_lend_equipment_list_acty);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "借出装备", null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();
        list.add(new LendEquipmentBean("NAO056", "防弹防刺服", "张明", "苏州公安局高新分局", "2018-06-10", "2018-06-15"));
        list.add(new LendEquipmentBean("NBO012", "防弹头盔", "张明", "苏州公安局高新分局", "2018-06-10", "2018-06-15"));
        list.add(new LendEquipmentBean("NCO259", "喊话器", "张明", "苏州公安局高新分局", "2018-06-10", "2018-06-15"));
        list.add(new LendEquipmentBean("NDO186", "警戒带", "张明", "苏州公安局高新分局", "2018-06-10", "2018-06-15"));
        list.add(new LendEquipmentBean("NEO043", "警绳", "张明", "苏州公安局高新分局", "2018-06-10", "2018-06-15"));
        list.add(new LendEquipmentBean("NC1239", "喊话器", "赵哥", "苏州公安局高新分局", "2018-06-01", "2018-06-10"));
        list.add(new LendEquipmentBean("NE0008", "警绳", "李晓", "苏州公安局园区分局", "2018-06-01", "2018-06-12"));
        listView = (ListView) findViewById(R.id.listview);
        adapter = new LendEquipmentListAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
        }
    }
}
