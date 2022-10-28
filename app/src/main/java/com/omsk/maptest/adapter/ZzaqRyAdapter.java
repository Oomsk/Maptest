package com.omsk.maptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.omsk.maptest.R;
import com.omsk.maptest.event.ZzaqEvent;
import com.omsk.maptest.mvp.bean.ZzaqRyBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ZzaqRyAdapter extends BaseAdapter implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Context context;
    private List<ZzaqRyBean> data;

    public ZzaqRyAdapter(Context context , List<ZzaqRyBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.layout_zzaq_detail_ry_item, null);
            viewHolder.zzaq_ry_name = view.findViewById(R.id.zzaq_ry_name);
            viewHolder.zzaq_ry_sex = view.findViewById(R.id.zzaq_ry_sex);
            viewHolder.zzaq_ry_number = view.findViewById(R.id.zzaq_ry_number);
            viewHolder.zzaq_ry_address = view.findViewById(R.id.zzaq_ry_address);
            viewHolder.zzaq_ry_edit = view.findViewById(R.id.zzaq_ry_edit);
            viewHolder.zzaq_ry_delete = view.findViewById(R.id.zzaq_ry_delete);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // 数据初始化
        ZzaqRyBean zzaqRyBean = data.get(i);
        viewHolder.zzaq_ry_name.setText(zzaqRyBean.getName());
        viewHolder.zzaq_ry_sex.setText(zzaqRyBean.getSex());
        viewHolder.zzaq_ry_number.setText(zzaqRyBean.getCode());
        viewHolder.zzaq_ry_address.setText(zzaqRyBean.getAddress());


        return view;

    }





    @Override
    public void onClick(View v) {

        /*switch (v.getId()){
            case R.id.zzaq_item_detail:
                ZzaqEvent showZzaqDetailEvent = new ZzaqEvent();
                showZzaqDetailEvent.setType(ZzaqEvent.SHOW_ZZAQ_DETAIL);
                EventBus.getDefault().post(showZzaqDetailEvent);
                break;
        }*/
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Object item = getItem(i);
        System.out.println(item.toString() + "---------------------------------");

    }

    // static静态内部类
    static class ViewHolder {
        TextView zzaq_ry_name;
        TextView zzaq_ry_sex;
        TextView zzaq_ry_number;
        TextView zzaq_ry_address;
        TextView zzaq_ry_edit;
        TextView zzaq_ry_delete;
    }
}
