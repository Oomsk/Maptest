package com.omsk.maptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.omsk.maptest.R;
import com.omsk.maptest.event.ZzaqEvent;
import com.omsk.maptest.mvp.bean.ZzaqRyBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ZzaqRyAdapter extends BaseAdapter implements View.OnClickListener {

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
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_zzaq_detail_ry_item, null);
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
}
