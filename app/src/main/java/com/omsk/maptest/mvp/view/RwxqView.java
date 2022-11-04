package com.omsk.maptest.mvp.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.omsk.maptest.R;
import com.omsk.maptest.adapter.ZzaqRyAdapter;
import com.omsk.maptest.event.ZzaqEvent;
import com.omsk.maptest.mvp.bean.ZzaqRyBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class RwxqView extends LinearLayout implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Context context;

    private ListView listView;

    private List<ZzaqRyBean> data;

    RelativeLayout ryLayout;
    RelativeLayout clLayout;
    RelativeLayout zbLayout;
    RelativeLayout mhjLayout;

    TextView tab_ry;
    TextView tab_cl;
    TextView tab_zb;
    TextView tab_mhj;

    private final static int RY = 1;
    private final static int CL = 2;
    private final static int ZB = 3;
    private final static int MHJ = 4;

    private int currentTab = RY;

    public RwxqView(Context context) {
        super(context);
        intView(context);
    }

    public RwxqView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        intView(context);
    }

    public RwxqView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intView(context);
    }

    public RwxqView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        intView(context);
    }

    private void intView(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rwxq_detail_layout_main, this, false);

        view.findViewById(R.id.rwxq_fanhui).setOnClickListener(this);

        addView(view);

        initRy(view);
        initCl(view);
        initZB(view);
        initMhj(view);


        tab_ry = findViewById(R.id.tab_ry);
        tab_cl = findViewById(R.id.tab_cl);
        tab_zb = findViewById(R.id.tab_zb);
        tab_mhj = findViewById(R.id.tab_mhj);


        tab_ry.setOnClickListener(this);


        tab_cl.setOnClickListener(this);
        tab_zb.setOnClickListener(this);
        tab_mhj.setOnClickListener(this);

        ryLayout = findViewById(R.id.rwxq_ry);
        zbLayout = findViewById(R.id.rwxq_zb);
        clLayout = findViewById(R.id.rwxq_cl);
        mhjLayout = findViewById(R.id.rwxq_mhj);

        updateView();


    }

    private void updateView(){
        //按钮状态
        tab_ry.setTextColor(getResources().getColor(R.color.black));
        tab_cl.setTextColor(getResources().getColor(R.color.black));
        tab_zb.setTextColor(getResources().getColor(R.color.black));
        tab_mhj.setTextColor(getResources().getColor(R.color.black));

        //背景状态
        tab_ry.setBackgroundResource(R.mipmap.liebiao_no);
        tab_cl.setBackgroundResource(R.mipmap.liebiao_no);
        tab_zb.setBackgroundResource(R.mipmap.liebiao_no);
        tab_mhj.setBackgroundResource(R.mipmap.liebiao_no);

        //布局状态
        ryLayout.setVisibility(View.GONE);
        clLayout.setVisibility(View.GONE);
        zbLayout.setVisibility(View.GONE);
        mhjLayout.setVisibility(View.GONE);

        switch (currentTab){
            case RY:
                tab_ry.setTextColor(getResources().getColor(R.color.teal_200));
                tab_ry.setBackgroundResource(R.mipmap.xuanzhong);
                ryLayout.setVisibility(View.VISIBLE);
                break;
            case CL:
                tab_cl.setTextColor(getResources().getColor(R.color.teal_200));
                clLayout.setVisibility(View.VISIBLE);
                tab_cl.setBackgroundResource(R.mipmap.xuanzhong);
                break;
            case ZB:
                tab_zb.setTextColor(getResources().getColor(R.color.teal_200));
                zbLayout.setVisibility(View.VISIBLE);
                tab_zb.setBackgroundResource(R.mipmap.xuanzhong);
                break;
            case MHJ:
                tab_mhj.setTextColor(getResources().getColor(R.color.teal_200));
                mhjLayout.setVisibility(View.VISIBLE);
                tab_mhj.setBackgroundResource(R.mipmap.xuanzhong);
                break;
        }
    }



    @Override
    public void onClick(View view) {

        Log.w("omsk", "点击事件");

        switch (view.getId()) {
            case R.id.rwxq_fanhui:
                ZzaqEvent zzaqEvent = new ZzaqEvent();
                zzaqEvent.setType(ZzaqEvent.DISMISS_ZZAQ);
                EventBus.getDefault().post(zzaqEvent);

                // 初始化
                currentTab = RY;
                break;
            case R.id.tab_ry:
                currentTab = RY;
                break;
            case R.id.tab_zb:
                currentTab = ZB;
                break;
            case R.id.tab_cl:
                currentTab = CL;
                break;
            case R.id.tab_mhj:
                currentTab = MHJ;
                break;
        }

        updateView();
    }

    private void initRy(View view) {
        listView = view.findViewById(R.id.zzaq_detail_listview);
        
        
        
        
        
        data = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            ZzaqRyBean zzaqRyBean = new ZzaqRyBean();

            zzaqRyBean.setName("叶孤城" + i);
            zzaqRyBean.setSex("男" + i);
            zzaqRyBean.setCode("1588888888" + i);
            zzaqRyBean.setAddress("上海市黄浦大道33号66-1弄" + i);

            data.add(zzaqRyBean);
        }

        ZzaqRyAdapter  zzaqClAdapter = new ZzaqRyAdapter(context, data);
        listView.setAdapter(zzaqClAdapter);

        listView.setOnItemClickListener(this);

    }

    private void initCl(View view) {
        listView = view.findViewById(R.id.zzaq_detail_listview_cl);
        data = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            ZzaqRyBean zzaqRyBean = new ZzaqRyBean();

            zzaqRyBean.setName("泡沫车" + i);
            zzaqRyBean.setSex("张三" + i);
            zzaqRyBean.setCode("1788888888" + i);
            zzaqRyBean.setAddress("北京市长安大街1号" + i);

            data.add(zzaqRyBean);
        }

        ZzaqRyAdapter  zzaqClAdapter = new ZzaqRyAdapter(context, data);
        listView.setAdapter(zzaqClAdapter);
    }

    private void initZB(View view) {
        listView = view.findViewById(R.id.zzaq_detail_listview_zb);
        data = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            ZzaqRyBean zzaqRyBean = new ZzaqRyBean();

            zzaqRyBean.setName("灭火机器人" + i);
            zzaqRyBean.setSex("周六" + i);
            zzaqRyBean.setCode("GXKHD00S" + i);
            zzaqRyBean.setAddress("天津市欧洲街1号" + i);

            data.add(zzaqRyBean);
        }

        ZzaqRyAdapter  zzaqClAdapter = new ZzaqRyAdapter(context, data);
        listView.setAdapter(zzaqClAdapter);
    }

    private void initMhj(View view) {
        listView = view.findViewById(R.id.zzaq_detail_listview_mhj);
        data = new ArrayList<>();

        for (int i = 0; i < 15; i++) {

            ZzaqRyBean zzaqRyBean = new ZzaqRyBean();

            zzaqRyBean.setName("测试灭火剂" + i);
            zzaqRyBean.setSex("正常" + i);
            zzaqRyBean.setCode("15" + i);
            zzaqRyBean.setAddress("IVJGDS" + i);

            data.add(zzaqRyBean);
        }

        ZzaqRyAdapter  zzaqClAdapter = new ZzaqRyAdapter(context, data);
        listView.setAdapter(zzaqClAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.w("dianji", "1111111111111");
        Adapter adapter = adapterView.getAdapter();
        ZzaqRyBean item = (ZzaqRyBean) adapter.getItem(i);

        EventBus.getDefault().post(item);

    }
}
