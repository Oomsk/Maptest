package com.omsk.maptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.omsk.maptest.R;
import com.omsk.maptest.event.ZlrwEvent;
import com.omsk.maptest.mvp.bean.ZlrwBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class ZlrwAdapter extends BaseAdapter implements View.OnClickListener {

    private Context context;
    private List<ZlrwBean> data;
    private View ZlrwView,ZlrwTaskView;

    public ZlrwAdapter(Context context , List<ZlrwBean> data) {
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
        view = inflater.inflate(R.layout.layout_zlrw_item, null);
        view.findViewById(R.id.zlrw_list_ckxq).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.zlrw_list_ckxq:
                ZlrwEvent zlrwEvent = new ZlrwEvent();
                zlrwEvent.setType(ZlrwEvent.SHOW_DETAIL);
                EventBus.getDefault().post(zlrwEvent);
                break ;
        }
    }


}
