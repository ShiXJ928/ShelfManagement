package com.zq.sm.acty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.application.App;
import com.zq.sm.bean.Result;
import com.zq.sm.bean.ShelfInfo;
import com.zq.sm.adapter.EquipmentListAdapter;
import com.zq.sm.net.NetPostMethod;
import com.zq.sm.net.NetUrl;
import com.zq.sm.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/29.
 */

public class MainActy extends BaseActy implements EquipmentListAdapter.OnItemClickListener, PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;
    private ShelfInfo shelfInfo;
    private List<ShelfInfo.EquipTypeListBean> list;
    private EquipmentListAdapter adapter;
    private LinearLayout ll_left, ll_right;
    private TextView tb_tv;
    private TextView tv_setting;
    private TextView tv_name;

    private interface refreshSuccess {
        void success();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);

        initView();
        getShelfInfo(new refreshSuccess() {
            @Override
            public void success() {
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }

    private void initView() {
//        initTitleBar(R.id.title, R.drawable.overdue, R.drawable.lend, "苏州公安局高新分局警用装备管理系统", null, R.color.text_blue, R.color.white);
        ll_left = (LinearLayout) findViewById(R.id.ll_left);
        ll_left.setOnClickListener(this);
        ll_right = (LinearLayout) findViewById(R.id.ll_right);
        ll_right.setOnClickListener(this);
        tb_tv = (TextView) findViewById(R.id.tb_tv);
        tb_tv.setText("如皋市公安局警用装备管理系统");
        tv_name = (TextView) findViewById(R.id.tv_name);
        list = new ArrayList<>();
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

    public void getShelfInfo(final refreshSuccess success) {
        dlg.show();
        JSONObject post = new JSONObject();
        post.put("ShefId", App.sharedUtility.getEquipId());
        new NetPostMethod(this, NetUrl.POST_SHELF_INFO, App.cachedThreadPool, post) {
            @Override
            public void runSuccsess(Result r) {
                shelfInfo = JSON.parseObject(r.getValue().toString(), ShelfInfo.class);
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                list.clear();
                                list.addAll(shelfInfo.getEquipTypeList());
                                success.success();
                                tv_name.setText(shelfInfo.getShelfName());
                            }
                        }
                );
            }

            @Override
            public void serverfail() {
                dlg.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setPullLoadMoreCompleted();
                    }
                });
                showServerWarinning();
            }

            @Override
            public void runfail(Context ctx, String message) {
                dlg.dismiss();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setPullLoadMoreCompleted();
                    }
                });
                showFailWarinning(ctx, message);
            }

        };
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
    public void onItemClick(int position, ShelfInfo.EquipTypeListBean model) {
        Intent intent = new Intent(this, TypeEquipmentListActy.class);
        intent.putExtra("name", model.getEquiptypeName());
        intent.putExtra("EquipTypeId", model.getEquipTypeId());
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        getShelfInfo(new refreshSuccess() {
            @Override
            public void success() {
                recyclerView.setPullLoadMoreCompleted();
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
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
            getShelfInfo(new refreshSuccess() {
                @Override
                public void success() {
                    adapter.notifyDataSetChanged();
                    dlg.dismiss();
                }
            });
        }
    }
}
