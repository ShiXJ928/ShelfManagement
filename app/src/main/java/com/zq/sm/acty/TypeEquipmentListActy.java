package com.zq.sm.acty;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zq.sm.R;
import com.zq.sm.adapter.TypeEquipmentListAdapter;
import com.zq.sm.application.App;
import com.zq.sm.bean.EquipmentBean;
import com.zq.sm.bean.Result;
import com.zq.sm.net.NetPostMethod;
import com.zq.sm.net.NetUrl;

import java.util.ArrayList;
import java.util.List;

import edu.swu.pulltorefreshswipemenulistview.library.PullToRefreshSwipeMenuListView;
import edu.swu.pulltorefreshswipemenulistview.library.pulltorefresh.interfaces.IXListViewListener;

/**
 * Created by AIERXUAN on 2018/6/20.
 */

public class TypeEquipmentListActy extends BaseActy implements IXListViewListener {

    private Intent intent;
    private TypeEquipmentListAdapter adapter;
    private PullToRefreshSwipeMenuListView listView;
    private List<EquipmentBean> list;
    private int EquipTypeId;
    private int pageIndex = 1;

    private interface refreshSuccess {
        void success();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_type_equipment_list);

        initView();
        getOverdueEquipmentList(new refreshSuccess() {
            @Override
            public void success() {
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }

    private void initView() {
        intent = getIntent();
        String name = intent.getStringExtra("name");
        EquipTypeId = intent.getIntExtra("EquipTypeId", 0);
        initTitleBar(R.id.title, R.drawable.back, 0, name, null, R.color.text_blue, R.color.white);
        list = new ArrayList<>();

        listView = (PullToRefreshSwipeMenuListView) findViewById(R.id.list);
        adapter = new TypeEquipmentListAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setPullRefreshEnable(true);
        listView.setPullLoadEnable(false);
        listView.setXListViewListener(this);
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

    public void getOverdueEquipmentList(final refreshSuccess success) {
        dlg.show();
        JSONObject post = new JSONObject();
        post.put("ShefId", App.sharedUtility.getEquipId());
        post.put("EquipTypeId", EquipTypeId);
        post.put("pageIndex", pageIndex);
        post.put("pageSize", 10);
        new NetPostMethod(this, NetUrl.POST_EQUIPMENT_LIST, App.cachedThreadPool, post) {
            @Override
            public void runSuccsess(final Result r) {
                final List<EquipmentBean> listBean = JSON.parseArray(r.getValue().toString(), EquipmentBean.class);
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                if (listBean.size() == 10) {
                                    listView.setPullLoadEnable(true);
                                } else {
                                    listView.setPullLoadEnable(false);
                                }
                                if (pageIndex == 1) {
                                    list.clear();
                                }
                                list.addAll(listBean);
                                success.success();
                            }
                        }
                );
            }

            @Override
            public void serverfail() {
                dlg.dismiss();
                showServerWarinning();
            }

            @Override
            public void runfail(Context ctx, String message) {
                dlg.dismiss();
                showFailWarinning(ctx, message);
            }

        };
    }

    @Override
    public void onRefresh() {
        pageIndex = 1;
        getOverdueEquipmentList(new refreshSuccess() {
            @Override
            public void success() {
                listView.stopRefresh();
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }

    @Override
    public void onLoadMore() {
        pageIndex++;
        getOverdueEquipmentList(new refreshSuccess() {
            @Override
            public void success() {
                listView.stopLoadMore();
                adapter.notifyDataSetChanged();
                dlg.dismiss();
            }
        });
    }
}
