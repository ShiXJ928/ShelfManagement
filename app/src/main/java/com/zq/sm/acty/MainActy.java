package com.zq.sm.acty;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.bean.EquipmentBean;
import com.zq.sm.adapter.EquipmentListAdapter;
import com.zq.sm.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */

public class MainActy extends BaseActy implements EquipmentListAdapter.OnItemClickListener, PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;
    private List<EquipmentBean> list;
    private EquipmentListAdapter adapter;
    private LinearLayout ll_left, ll_right;
    private TextView tb_tv;
    private ImageView iv_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);

        initView();
    }

    private void initView() {
//        initTitleBar(R.id.title, R.drawable.overdue, R.drawable.lend, "苏州公安局高新分局警用装备管理系统", null, R.color.text_blue, R.color.white);
        ll_left = (LinearLayout) findViewById(R.id.ll_left);
        ll_left.setOnClickListener(this);
        ll_right = (LinearLayout) findViewById(R.id.ll_right);
        ll_right.setOnClickListener(this);
        tb_tv = (TextView) findViewById(R.id.tb_tv);
        tb_tv.setText("如皋市公安局警用装备管理系统");
        list = new ArrayList<>();
        list.add(new EquipmentBean("催泪喷射器", "drawable://" + R.drawable.tear_ejector, 30));
        list.add(new EquipmentBean("对讲机", "drawable://" + R.drawable.interphone, 30));
        list.add(new EquipmentBean("强光手电", "drawable://" + R.drawable.flashlight, 10));
        list.add(new EquipmentBean("执法仪", "drawable://" + R.drawable.law_enforcement_instrument, 100));
        list.add(new EquipmentBean("多功能腰带", "drawable://" + R.drawable.multifunction_belt, 45));
        list.add(new EquipmentBean("防割手套", "drawable://" + R.drawable.cut_resistant_gloves, 28));
        list.add(new EquipmentBean("伸缩警棍", "drawable://" + R.drawable.telescopic_baton, 51));
        list.add(new EquipmentBean("手铐", "drawable://" + R.drawable.handcuffs, 36));
        list.add(new EquipmentBean("电喇叭", "drawable://" + R.drawable.electric_horn, 30));
        list.add(new EquipmentBean("肩灯", "drawable://" + R.drawable.shoulder_lamp, 30));
        recyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setGridLayout(3);
        adapter = new EquipmentListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        recyclerView.setPullRefreshEnable(true);
        recyclerView.setPushRefreshEnable(false);
        recyclerView.setOnPullLoadMoreListener(this);
//        recyclerView.setPushRefreshEnable(true);
//        recyclerView.setOnPullLoadMoreListener(this);
//        recyclerView.setFooterViewText("loading");
//        recyclerView.setFooterViewTextColor(R.color.bg_blue);
//        recyclerView.setColorSchemeResources(android.R.color.holo_red_dark,android.R.color.holo_blue_dark);

        iv_setting = (ImageView) findViewById(R.id.iv_setting);
        iv_setting.setOnClickListener(this);
    }

    private long firstClickTime = 0;

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ll_left:
                startActivity(new Intent(this, OverdueEquipmentActy.class));
                break;
            case R.id.ll_right:
                startActivity(new Intent(this, LendEquipmentListActy.class));
                break;
            case R.id.iv_setting:
                if (firstClickTime > 0) {
                    long secondClickTime = SystemClock.uptimeMillis();
                    long dtime = secondClickTime - firstClickTime;
                    if (dtime > 500) {

                    } else {
                        firstClickTime = 0;
                        startActivity(new Intent(this, SettingActy.class));
                    }
                    return;
                }
                firstClickTime = SystemClock.uptimeMillis();
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

    @Override
    public void onItemClick(int position, EquipmentBean model) {
        Intent intent = new Intent(this, TypeEquipmentListActy.class);
        intent.putExtra("name", model.getName());
        startActivity(intent);
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
