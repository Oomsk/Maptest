package com.omsk.maptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.omsk.maptest.R;
import com.omsk.maptest.adapter.ZlrwAdapter;
import com.omsk.maptest.event.ZlrwEvent;
import com.omsk.maptest.mvp.bean.ZlrwBean;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainZlrwView extends LinearLayout implements View.OnClickListener {

    private Context context;
    private ListView listView;
    private List<ZlrwBean> data;
    private ZlrwAdapter adapter;


    public MainZlrwView(Context context) {
        super(context);
        initView(context);
    }

    public MainZlrwView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public MainZlrwView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MainZlrwView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.zlrw_view_layout, null);
        addView(view);

        listView = view.findViewById(R.id.zlrw_listview);
        data = new ArrayList<>();
        ZlrwBean bean = new ZlrwBean();
        data.add(bean);
        data.add(bean);
        data.add(bean);
        data.add(bean);
        data.add(bean);
        adapter = new ZlrwAdapter(context , data);
        listView.setAdapter(adapter);

        view.findViewById(R.id.zlrw_close).setOnClickListener(this);
        view.findViewById(R.id.zlrw_yjct).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {



        switch (v.getId()) {
            case R.id.zlrw_close:
                ZlrwEvent zlrwCloseEvent = new ZlrwEvent();
                zlrwCloseEvent.setType(ZlrwEvent.CLOSE_VIEW);
                EventBus.getDefault().post(zlrwCloseEvent);
                break;
            case R.id.zlrw_yjct:
                ZlrwEvent zlrwYjctEvent = new ZlrwEvent();
                zlrwYjctEvent.setType(ZlrwEvent.YJCT);
                EventBus.getDefault().post(zlrwYjctEvent);
                break;


        }
    }



}
