package com.omsk.maptest.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;

import com.omsk.maptest.R;
import com.omsk.maptest.adapter.RwsbAdapter;
import com.omsk.maptest.adapter.SpinnerAdapter;
import com.omsk.maptest.mvp.bean.RwsbStatusBean;

import java.util.ArrayList;
import java.util.List;

public class XxsbView extends LinearLayout {

    private Context context;
    private Spinner spinner;
    private SpinnerAdapter adapter;
    private List<String> datas;

    private HorizontalListView listView;
    private RwsbAdapter rwsbAdapter;
    private List<RwsbStatusBean> datasRwsb;

    public XxsbView(Context context) {
        super(context);
        initView(context);

    }

    public XxsbView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public XxsbView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public XxsbView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_xxsb, null, false);
        intDj(inflate);
        intLx(inflate);
        initDw(inflate);

        inttDatas(inflate);

        addView(inflate);

    }

    void intDj(View view) {
        spinner = view.findViewById(R.id.rwsb_spinner_dj);
        datas = new ArrayList<>();
        datas.add("一级");
        datas.add("二级");
        datas.add("三级");
        datas.add("四级");
        datas.add("五级");
        adapter = new SpinnerAdapter(context, datas);
        spinner.setAdapter(adapter);
    }

    void intLx(View view) {
        spinner = view.findViewById(R.id.rwsb_spinner_lx);
        datas = new ArrayList<>();
        datas.add("立案");
        datas.add("通知");
        datas.add("出动");
        datas.add("到场");
        datas.add("出水");
        datas.add("结束");
        datas.add("撤离");
        datas.add("归队");
        adapter = new SpinnerAdapter(context, datas);
        spinner.setAdapter(adapter);
    }

    void initDw(View view) {
        spinner = view.findViewById(R.id.rwsb_spinner_dw);
        datas = new ArrayList<>();
        datas.add("浙江总队");
        datas.add("杭州支队");
        datas.add("嘉兴支队");
        datas.add("舟山支队");
        datas.add("临平支队");
        adapter = new SpinnerAdapter(context, datas);
        spinner.setAdapter(adapter);
    }

    void inttDatas(View view) {
        listView = view.findViewById(R.id.rwsb_status_list);
        datasRwsb = new ArrayList<>();
        RwsbStatusBean data1 = new RwsbStatusBean();
        data1.setStatus("出水");
        data1.setTime("11:22");
        data1.setSelected("0");

        RwsbStatusBean data2 = new RwsbStatusBean();
        data2.setStatus("撤离");
        data2.setTime("11:55");
        data2.setSelected("1");

        RwsbStatusBean data3 = new RwsbStatusBean();
        data3.setStatus("归队");
        data3.setTime("10:55");
        data3.setSelected("0");

        datasRwsb.add(data1);
        datasRwsb.add(data2);
        datasRwsb.add(data3);

        rwsbAdapter = new RwsbAdapter(context, datasRwsb);

        listView.setAdapter(rwsbAdapter);

    }


    private void updateStatus() {

    }

}
