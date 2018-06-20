package com.zq.sm.acty;

import android.os.Bundle;
import android.view.View;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.adapter.OverdueEquipmentListAdapter;
import com.zq.sm.bean.EquipmentBean;
import com.zq.sm.bean.OverdueEquipmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class OverdueEquipmentActy extends BaseActy implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;
    private List<OverdueEquipmentBean> list;
    private OverdueEquipmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_overdue_equipment_list_acty);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "到期装备", null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();
        list.add(new OverdueEquipmentBean("NAO056", "催泪喷射器", "drawable://" + R.drawable.tear_ejector, "2019.06.15"));
        list.add(new OverdueEquipmentBean("NE1572", "对讲机", "drawable://" + R.drawable.interphone, "2018.05.18"));
        list.add(new OverdueEquipmentBean("NZ0603", "强光手电", "drawable://" + R.drawable.flashlight, "2018.06.15"));
        list.add(new OverdueEquipmentBean("ND3004", "执法仪", "drawable://" + R.drawable.law_enforcement_instrument, "2018.06.12"));
        list.add(new OverdueEquipmentBean("NZ0603", "多功能腰带", "drawable://" + R.drawable.multifunction_belt, "2018.06.15"));
        list.add(new OverdueEquipmentBean("ND3004", "防割手套", "drawable://" + R.drawable.cut_resistant_gloves, "2018.06.12"));

        recyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setGridLayout(2);
        adapter = new OverdueEquipmentListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setPullRefreshEnable(true);
        recyclerView.setPushRefreshEnable(false);
        recyclerView.setOnPullLoadMoreListener(this);
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

    @Override
    public void onRefresh() {
        recyclerView.setPullLoadMoreCompleted();
    }

    @Override
    public void onLoadMore() {
        recyclerView.setPullLoadMoreCompleted();
    }
}
