package com.zq.sm.acty;

import android.os.Bundle;
import android.view.View;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.adapter.LendEquipmentListAdapter;
import com.zq.sm.bean.EquipmentBean;
import com.zq.sm.bean.LendEquipmentBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class LendEquipmentListActy extends BaseActy implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;
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
        list.add(new LendEquipmentBean("NAO056", "drawable://" + R.drawable.tear_ejector, "催泪喷射器", "张明", "如皋市公安局", "2018.06.10", "2018.06.15"));
        list.add(new LendEquipmentBean("NBO012", "drawable://" + R.drawable.interphone, "对讲机", "张明", "如皋市公安局", "2018.06.10", "2018.06.15"));
        list.add(new LendEquipmentBean("NCO259", "drawable://" + R.drawable.flashlight, "强光手电", "张明", "如皋市公安局", "2018.06.10", "2018.06.15"));
        list.add(new LendEquipmentBean("NDO186", "drawable://" + R.drawable.law_enforcement_instrument, "执法仪", "张明", "如皋市公安局", "2018.06.10", "2018.06.15"));
        list.add(new LendEquipmentBean("NEO043", "drawable://" + R.drawable.multifunction_belt, "多功能腰带", "张明", "如皋市公安局", "2018.06.10", "2018.06.15"));
        list.add(new LendEquipmentBean("NC1239", "drawable://" + R.drawable.cut_resistant_gloves, "防割手套", "赵哥", "如皋市公安局", "2018.06.01", "2018.06.10"));
        list.add(new LendEquipmentBean("NE0008", "drawable://" + R.drawable.telescopic_baton, "伸缩警棍", "李晓", "如皋市公安局", "2018.06.01", "2018.06.12"));


        recyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setGridLayout(2);
        adapter = new LendEquipmentListAdapter(this, list);
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
