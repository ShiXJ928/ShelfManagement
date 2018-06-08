package com.zq.sm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zq.sm.R;
import com.zq.sm.acty.BaseActy;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class EquipmentListAdapter extends BaseAdapter {

    private List<EquipmentBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public EquipmentListAdapter(Context context, List<EquipmentBean> list) {
        mInflater = LayoutInflater.from(context);
        this.context = (BaseActy) context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        ViewHolder holder = null;
        EquipmentBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_equipment, null);
            holder = new ViewHolder();
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_num = (TextView) view.findViewById(R.id.tv_num);
            holder.tv_batchNo = (TextView) view.findViewById(R.id.tv_batchNo);
            holder.ll_equipment = (LinearLayout) view.findViewById(R.id.ll_equipment);
            // 将holder与view进行绑定
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        if (position % 2 == 1) {
            holder.ll_equipment.setBackgroundColor(context.getResources().getColor(R.color.bg_grey));
        } else {
            holder.ll_equipment.setBackgroundColor(context.getResources().getColor(R.color.white));
        }
        holder.tv_name.setText(bean.getName());
        holder.tv_num.setText(bean.getLendNum() + "/" + bean.getTotalNum());
        holder.tv_batchNo.setText(bean.getBatchNo());
        return view;
    }

    public class ViewHolder {
        TextView tv_name, tv_num, tv_batchNo;
        LinearLayout ll_equipment;
    }
}
