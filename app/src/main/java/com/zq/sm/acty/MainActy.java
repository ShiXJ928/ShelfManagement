package com.zq.sm.acty;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.application.App;
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
    private TextView tv_setting;

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

        tv_setting = (TextView) findViewById(R.id.tv_setting);
        tv_setting.setOnClickListener(new View.OnClickListener() {
            //需要监听几次点击事件数组的长度就为几
            //如果要监听双击事件则数组长度为2，如果要监听3次连续点击事件则数组长度为3...
            long[] mHints = new long[5];//初始全部为0

            @Override
            public void onClick(View v) {
                //将mHints数组内的所有元素左移一个位置
                System.arraycopy(mHints, 1, mHints, 0, mHints.length - 1);
                //获得当前系统已经启动的时间
                mHints[mHints.length - 1] = SystemClock.uptimeMillis();
                if (SystemClock.uptimeMillis() - mHints[0] <= 1000) {
                    startActivityForResult(new Intent(MainActy.this, SettingActy.class), 101);
                }
            }
        });
    }

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Log.e("-------->", App.sharedUtility.getEquipId());
        }
    }
}
