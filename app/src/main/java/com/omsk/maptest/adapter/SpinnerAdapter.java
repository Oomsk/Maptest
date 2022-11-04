package com.omsk.maptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.omsk.maptest.R;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter implements android.widget.SpinnerAdapter {

    private Context context;
    private List<String> datas;

    public SpinnerAdapter(Context context, List<String> datas) {
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
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.layout_spinner_rwsb, viewGroup,false);
            //view = View.inflate(context,R.layout.layout_spinner_rwsb, null);
            viewHolder.textView = view.findViewById(R.id.rwsb_spinner_mc);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.textView.setText(datas.get(i));

        return view;
    }

    static class ViewHolder{
        TextView textView;
    }


}
