package com.zq.sm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.sm.R;
import com.zq.sm.bean.OverdueEquipmentBean;
import com.zq.sm.util.Utility;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class OverdueEquipmentListAdapter extends RecyclerView.Adapter<OverdueEquipmentListAdapter.ViewHolder> {
    private List<OverdueEquipmentBean> data;
    private LayoutInflater inflater;
    private RecyclerView mRecyclerView;//用来计算Child位置
    private Context context;

    public OverdueEquipmentListAdapter(Context context, List<OverdueEquipmentBean> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_name;
        TextView tv_time;
        TextView tv_day;
        TextView tv_position;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_day = (TextView) itemView.findViewById(R.id.tv_day);
            tv_position = (TextView) itemView.findViewById(R.id.tv_position);
            iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
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
        View itemView = inflater.inflate(R.layout.item_overdue_equipment, parent, false);

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
        Utility.displayImage(data.get(position).getImageUrl(), holder.iv_img, R.drawable.fail_image);
        holder.tv_name.setText(data.get(position).getShowName());//加载数据
        holder.tv_time.setText("过期时间：" + Utility.getTimeStr(data.get(position).getExpirydate(), "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd"));
        holder.tv_position.setText("位置：" + data.get(position).getSite());
        if (data.get(position).getDays() == 0) {
            holder.tv_day.setText("今天到期");
            holder.tv_day.setTextColor(context.getResources().getColor(R.color.bg_red));
        } else if (data.get(position).getDays() > 0) {
            holder.tv_day.setText("距离过期" + Math.abs(data.get(position).getDays()) + "天");
            holder.tv_day.setTextColor(context.getResources().getColor(R.color.bg_green));
        } else {
            holder.tv_day.setText("已过期" + Math.abs(data.get(position).getDays()) + "天");
            holder.tv_day.setTextColor(context.getResources().getColor(R.color.bg_red));
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