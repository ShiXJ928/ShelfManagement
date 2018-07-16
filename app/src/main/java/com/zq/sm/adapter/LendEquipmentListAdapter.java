package com.zq.sm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zq.sm.R;
import com.zq.sm.bean.LendEquipmentBean;
import com.zq.sm.net.NetUrl;
import com.zq.sm.util.Utility;

import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */

public class LendEquipmentListAdapter extends RecyclerView.Adapter<LendEquipmentListAdapter.ViewHolder> {
    private List<LendEquipmentBean> data;
    private LayoutInflater inflater;
    private Context context;
    private RecyclerView mRecyclerView;//用来计算Child位置

    public LendEquipmentListAdapter(Context context, List<LendEquipmentBean> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_name;
        TextView tv_overday;
        TextView tv_lend_name;
        TextView tv_lend_company;
        TextView tv_lend_time;
        TextView tv_return_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_overday = (TextView) itemView.findViewById(R.id.tv_overday);
            tv_lend_name = (TextView) itemView.findViewById(R.id.tv_lend_name);
            tv_lend_company = (TextView) itemView.findViewById(R.id.tv_lend_company);
            tv_lend_time = (TextView) itemView.findViewById(R.id.tv_lend_time);
            tv_return_time = (TextView) itemView.findViewById(R.id.tv_return_time);
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
        View itemView = inflater.inflate(R.layout.item_lend_equipment, parent, false);

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
        holder.tv_name.setText(data.get(position).getShowName());//加载数据
        holder.tv_lend_name.setText("领用人：" + data.get(position).getUserName());
        holder.tv_lend_company.setText("借用单位：" + data.get(position).getDepartmentName());
        holder.tv_lend_time.setText("借出时间：" + data.get(position).getLastUseTime());
        holder.tv_return_time.setText("应归还时间：" + data.get(position).getRevertTime());
        Utility.displayImage(NetUrl.URL + data.get(position).getImageUrl(), holder.iv_img, R.drawable.fail_image);
        if (Utility.compareTime(Utility.getNowTime("yyyy-MM-dd"), data.get(position).getRevertTime(), "yyyy-MM-dd")
                || Utility.getNowTime("yyyy-MM-dd").equals(data.get(position).getRevertTime())) {
            holder.tv_overday.setText("未超期");
            holder.tv_overday.setTextColor(context.getResources().getColor(R.color.bg_green));
        } else {
            holder.tv_overday.setText("超期" + Utility.getDayByTime(data.get(position).getRevertTime(), "yyyy-MM-dd") + "天");
            holder.tv_overday.setTextColor(context.getResources().getColor(R.color.bg_red));
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
