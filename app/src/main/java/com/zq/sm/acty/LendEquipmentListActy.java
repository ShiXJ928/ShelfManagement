package com.zq.sm.acty;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;
import com.zq.sm.R;
import com.zq.sm.adapter.LendEquipmentListAdapter;
import com.zq.sm.application.App;
import com.zq.sm.bean.LendEquipmentBean;
import com.zq.sm.bean.OverdueEquipmentBean;
import com.zq.sm.bean.Result;
import com.zq.sm.net.NetPostMethod;
import com.zq.sm.net.NetUrl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/12.
 */

public class LendEquipmentListActy extends BaseActy implements PullLoadMoreRecyclerView.PullLoadMoreListener {

    private PullLoadMoreRecyclerView recyclerView;
    private List<LendEquipmentBean> list;
    private LendEquipmentListAdapter adapter;

    private interface refreshSuccess {
        void success();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_lend_equipment_list_acty);

        initView();
        getLendEquipmentList(new refreshSuccess() {
            @Override
            public void success() {
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "借出装备", null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();

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

    public void getLendEquipmentList(final refreshSuccess success) {
        dlg.show();
        JSONObject post = new JSONObject();
        post.put("ShefId", App.sharedUtility.getEquipId());
        new NetPostMethod(this, NetUrl.POST_LEND_EQUIPMENT_LIST, App.cachedThreadPool, post) {
            @Override
            public void runSuccsess(final Result r) {
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                list.clear();
                                list.addAll(JSON.parseArray(r.getValue().toString(), LendEquipmentBean.class));
                                success.success();
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
    public void onRefresh() {
        getLendEquipmentList(new refreshSuccess() {
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
}
