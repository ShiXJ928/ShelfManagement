package com.zq.sm.acty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.adapter.TypeEquipmentListAdapter;
import com.zq.sm.bean.EquipmentInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AIERXUAN on 2018/6/20.
 */

public class TypeEquipmentListActy extends BaseActy implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    private Intent intent;
    private TypeEquipmentListAdapter adapter;
    private PullLoadMoreRecyclerView recyclerView;
    private List<EquipmentInfoBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_type_equipment_list);

        initView();
    }

    private void initView() {
        intent = getIntent();
        String name = intent.getStringExtra("name");
        initTitleBar(R.id.title, R.drawable.back, 0, name, null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();
        list.add(new EquipmentInfoBean("NAO001", "", "", "借出", "", "2019.12.1", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO002", "", "", "借出", "", "2019.1.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO003", "", "", "借出", "", "2019.1.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO004", "", "", "在库", "3层1排", "2018.6.10", "2015.1.1"));
        list.add(new EquipmentInfoBean("NAO005", "", "", "在库", "3层1排", "2018.7.10", "2015.1.1"));
        list.add(new EquipmentInfoBean("NAO006", "", "", "在库", "3层2排", "2018.7.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO007", "", "", "在库", "3层2排", "2019.1.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO008", "", "", "在库", "2层2排", "2019.1.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO009", "", "", "在库", "2层2排", "2019.1.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO010", "", "", "在库", "2层2排", "2019.1.10", "2016.1.1"));
        list.add(new EquipmentInfoBean("NAO011", "", "", "在库", "2层2排", "2019.1.10", "2016.1.1"));

        recyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setGridLayout(1);
        adapter = new TypeEquipmentListAdapter(this, list);
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
