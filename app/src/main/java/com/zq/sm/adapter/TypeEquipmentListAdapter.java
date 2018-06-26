package com.zq.sm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zq.sm.R;
import com.zq.sm.bean.EquipmentInfoBean;
import com.zq.sm.util.Utility;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class TypeEquipmentListAdapter extends RecyclerView.Adapter<TypeEquipmentListAdapter.ViewHolder> {
    private List<EquipmentInfoBean> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;//用来计算Child位置
    private Context context;

    public TypeEquipmentListAdapter(Context context, List<EquipmentInfoBean> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout ll_equipment;
        TextView tv_num;
        TextView tv_statues;
        TextView tv_position;
        TextView tv_storage_time;
        TextView tv_overdue_time;
        TextView tv_manufacture_time;


        public ViewHolder(View itemView) {
            super(itemView);
            tv_num = (TextView) itemView.findViewById(R.id.tv_num);
            tv_statues = (TextView) itemView.findViewById(R.id.tv_statues);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
            tv_storage_time = (TextView) itemView.findViewById(R.id.tv_storage_time);
            tv_overdue_time = (TextView) itemView.findViewById(R.id.tv_overdue_time);
            tv_manufacture_time = (TextView) itemView.findViewById(R.id.tv_manufacture_time);
            ll_equipment = (LinearLayout) itemView.findViewById(R.id.ll_equipment);
        }
    }

    /**
     * 创建VIewHolder，导入布局，实例化itemView
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_type_equipment, parent, false);

        return new ViewHolder(itemView);
    }

    /**
     * 绑定VIewHolder，加载数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_num.setText(data.get(position).getEquipID());//加载数据
        holder.tv_statues.setText(data.get(position).getStatues());
        holder.tv_position.setText(data.get(position).getPosition());
        holder.tv_storage_time.setText(data.get(position).getStorageTime());
        holder.tv_overdue_time.setText(data.get(position).getOverdueTime());
        holder.tv_manufacture_time.setText(data.get(position).getManufactureTime());
        if (Utility.getNowTime("yyyy.MM.dd").equals(data.get(position).getOverdueTime())) {
            holder.tv_overdue_time.setTextColor(context.getResources().getColor(R.color.bg_red));
        } else if (Utility.compareTime(Utility.getNowTime("yyyy.MM.dd"), data.get(position).getOverdueTime(), "yyyy.MM.dd")) {
            holder.tv_overdue_time.setTextColor(context.getResources().getColor(R.color.bg_green));
        } else {
            holder.tv_overdue_time.setTextColor(context.getResources().getColor(R.color.bg_red));
        }
        if (position % 2 == 1) {
            holder.ll_equipment.setBackgroundColor(context.getResources().getColor(R.color.bg_grey));
        } else {
            holder.ll_equipment.setBackgroundColor(context.getResources().getColor(R.color.white));
        }
    }

    /**
     * 数据源的数量，item的个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    /**
     * 适配器绑定到RecyclerView 的时候，回将绑定适配器的RecyclerView 传递过来
     *
     * @param recyclerView
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }
}
