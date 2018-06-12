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
import com.zq.sm.bean.OverdueEquipmentBean;
import com.zq.sm.util.Utility;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class OverdueEquipmentListAdapter extends BaseAdapter {

    private List<OverdueEquipmentBean> list;
    private BaseActy context;
    private LayoutInflater mInflater;

    public OverdueEquipmentListAdapter(Context context, List<OverdueEquipmentBean> list) {
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
        OverdueEquipmentBean bean = list.get(position);
        // 判断convertView的状态，来达到复用效果
        if (null == convertView) {
            //如果convertView为空，则表示第一次显示该条目，需要创建一个view
            view = View.inflate(context, R.layout.item_overdue_equipment, null);
            holder = new ViewHolder();
            holder.tv_num = (TextView) view.findViewById(R.id.tv_num);
            holder.tv_name = (TextView) view.findViewById(R.id.tv_name);
            holder.tv_overdue_time = (TextView) view.findViewById(R.id.tv_overdue_time);
            holder.tv_day = (TextView) view.findViewById(R.id.tv_day);
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
        holder.tv_num.setText(bean.getEquipID());
        holder.tv_name.setText(bean.getEquipName());
        holder.tv_overdue_time.setText(bean.getOverdueTime());
        if (Utility.getNowTime("yyyy-MM-dd").equals(bean.getOverdueTime())) {
            holder.tv_day.setText("今天到期");
            holder.tv_day.setTextColor(context.getResources().getColor(R.color.bg_red));
        } else if (Utility.compareTime(Utility.getNowTime("yyyy-MM-dd"), bean.getOverdueTime(), "yyyy-MM-dd")) {
            holder.tv_day.setText("距离过期" + Math.abs(Utility.getDayByTime(bean.getOverdueTime())) + "天");
            holder.tv_day.setTextColor(context.getResources().getColor(R.color.bg_green));
        } else {
            holder.tv_day.setText("已过期" + Utility.getDayByTime(bean.getOverdueTime()) + "天");
            holder.tv_day.setTextColor(context.getResources().getColor(R.color.bg_red));
        }
        return view;
    }

    public class ViewHolder {
        TextView tv_num, tv_name, tv_overdue_time, tv_day;
        LinearLayout ll_equipment;
    }
}
