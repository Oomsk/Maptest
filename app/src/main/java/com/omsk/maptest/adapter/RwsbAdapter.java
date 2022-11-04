package com.omsk.maptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.omsk.maptest.R;
import com.omsk.maptest.mvp.bean.RwsbStatusBean;

import java.util.List;

public class RwsbAdapter extends BaseAdapter {

    private Context context;
    private List<RwsbStatusBean> datas;

    public RwsbAdapter(Context context, List<RwsbStatusBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.layout_listview_rwsb, viewGroup,false);
            //view = View.inflate(context,R.layout.layout_spinner_rwsb, null);
            holder.status = view.findViewById(R.id.rwsb_status);
            holder.time = view.findViewById(R.id.rwsb_time);
            holder.linearLayout  = view.findViewById(R.id.rwsb_bt_back);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }


        RwsbStatusBean statusBean = datas.get(i);

        holder.status.setText(statusBean.getStatus());
        holder.time.setText(statusBean.getTime());

        // 设置背景
        if (statusBean.getSelected() != null) {
            holder.linearLayout.setBackgroundResource(statusBean.getSelected().equals("1")?
                    R.mipmap.rwsb_zt_bt2: R.mipmap.rwsb_zt_bt1 );
        }


        return view;
    }

    static class ViewHolder{
        TextView status;
        TextView time;
        LinearLayout linearLayout;
    }
}
