package com.zq.sm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zq.sm.R;
import com.zq.sm.acty.BaseActy;
import com.zq.sm.bean.EquipmentBean;
import com.zq.sm.util.Utility;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class TypeEquipmentListAdapter extends BaseAdapter {
    private List<EquipmentBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public TypeEquipmentListAdapter(Context context, List<EquipmentBean> list) {
        mInflater = LayoutInflater.from(context);
        this.context = (BaseActy) context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder = null;
        EquipmentBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_type_equipment,
                    null);
            holder = new ViewHolder();
            holder.tv_num = (TextView) view.findViewById(R.id.tv_num);
            holder.tv_statues = (TextView) view.findViewById(R.id.tv_statues);
            holder.tv_position = (TextView) view.findViewById(R.id.tv_position);
            holder.tv_storage_time = (TextView) view.findViewById(R.id.tv_storage_time);
            holder.tv_overdue_time = (TextView) view.findViewById(R.id.tv_overdue_time);
            holder.tv_manufacture_time = (TextView) view.findViewById(R.id.tv_manufacture_time);
            holder.ll_equipment = (LinearLayout) view.findViewById(R.id.ll_equipment);
            // 将holder与view进行绑定
            view.setTag(holder);
        } else {
            //否则表示可以复用convertView
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_num.setText(bean.getRFID());//加载数据
        holder.tv_statues.setText(bean.getStatusName());
        holder.tv_position.setText(bean.getSite());
        holder.tv_storage_time.setText(bean.getPurchasedate());
        if (bean.getExpirydate() != null) {
            holder.tv_overdue_time.setText(bean.getExpirydate());
            if (Utility.getNowTime("yyyy-MM-dd").equals(bean.getExpirydate())) {
                holder.tv_overdue_time.setTextColor(context.getResources().getColor(R.color.bg_red));
            } else if (Utility.compareTime(Utility.getNowTime("yyyy-MM-dd"), bean.getExpirydate(), "yyyy-MM-dd")) {
                holder.tv_overdue_time.setTextColor(context.getResources().getColor(R.color.bg_green));
            } else {
                holder.tv_overdue_time.setTextColor(context.getResources().getColor(R.color.bg_red));
            }
        }
        holder.tv_manufacture_time.setText(bean.getProductdate());

        if (position % 2 == 1) {
            holder.ll_equipment.setBackgroundColor(context.getResources().getColor(R.color.bg_grey));
        } else {
            holder.ll_equipment.setBackgroundColor(context.getResources().getColor(R.color.white));
        }
        return view;
    }

    public class ViewHolder {
        LinearLayout ll_equipment;
        TextView tv_num;
        TextView tv_statues;
        TextView tv_position;
        TextView tv_storage_time;
        TextView tv_overdue_time;
        TextView tv_manufacture_time;
    }
}
