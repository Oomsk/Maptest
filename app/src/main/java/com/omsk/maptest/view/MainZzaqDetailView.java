package com.omsk.maptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

import com.omsk.maptest.R;
import com.omsk.maptest.adapter.ZzaqRyAdapter;
import com.omsk.maptest.mvp.bean.ZzaqRyBean;

import java.util.ArrayList;
import java.util.List;

public class MainZzaqDetailView extends RelativeLayout implements View.OnClickListener {

    private Context context;
    private ZzaqRyAdapter ryAdapter;
    private List<ZzaqRyBean> ryBeans = new ArrayList<>();
    private ListView zzaq_detail_listview;

    public MainZzaqDetailView(Context context) {
        super(context);
        initView(context);
    }

    public MainZzaqDetailView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public MainZzaqDetailView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MainZzaqDetailView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rwxq_detail_layout, null);
        addView(view);

       /* view.findViewById(R.id.zzaq_detail_back).setOnClickListener(this);*/

        for (int i = 0; i < 10; i++) {
            ryBeans.add(new ZzaqRyBean());
        }

        zzaq_detail_listview = view.findViewById(R.id.zzaq_detail_listview);
        ryAdapter = new ZzaqRyAdapter(context , ryBeans);
        zzaq_detail_listview.setAdapter(ryAdapter);


    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()) {
            case R.id.zzaq_detail_back:
                ZzaqEvent zzaqEvent = new ZzaqEvent();
                zzaqEvent.setType(ZzaqEvent.DISMISS_ZZAQ_DETAIL);
                EventBus.getDefault().post(zzaqEvent);
                break;
        }*/
    }
}
