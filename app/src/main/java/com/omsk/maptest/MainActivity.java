package com.omsk.maptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.maps2d.MapView;
import com.omsk.maptest.event.ZlrwEvent;
import com.omsk.maptest.event.ZzaqEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    private Boolean isOn = false;

    MapView mMapView = null;

    @BindView(R.id.top_title)
    ImageView topTitle;

    @BindView(R.id.main_zlrw_layout)
    View zlrw;

    @BindView(R.id.main_zlrw_detail_layout)
    View zlrwTask;

    @BindView(R.id.rwxq_main)
    View rwxq_main;

    @BindView(R.id.amap_view)
    View amap_view;

    @BindView(R.id.under_circle)
    View under_circle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // butterKinfe 初始化
        ButterKnife.bind(this);

        Log.w("creat", "");

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.amap_view);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，创建地图
        mMapView.onCreate(savedInstanceState);

        //EventBus init
        EventBus.getDefault().register(this);



    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mMapView.onDestroy();
        // eventBus 销毁
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mMapView.onPause();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，保存地图当前的状态
        mMapView.onSaveInstanceState(outState);
    }

    @OnClick(R.id.top_title)
    void onClicked() {

        if (isOn) {
            zlrw.setVisibility(View.GONE);
            isOn = false;
        } else if (!isOn){
            zlrw.setVisibility(View.VISIBLE);
            isOn = true;
        }
        Log.w("click", "点击title");
    }

    @OnClick(R.id.zlrw_close)
    void ZlrwClose() {
        zlrw.setVisibility(View.GONE);
        isOn = false;
    }

    @OnClick(R.id.task_close)
    void TaskClose() {
        zlrwTask.setVisibility(View.GONE);
        isOn = false;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ZlrwEvent myEvent/*, ZzaqEvent zzaqEvent*/) {

        if (myEvent.getType() == ZlrwEvent.SHOW_DETAIL) {
            zlrw.setVisibility(View.GONE);
            zlrwTask.setVisibility(View.VISIBLE);
        } /*else if (zzaqEvent.getType() == ZzaqEvent.DISMISS_ZZAQ) {
            rwxq_main.setVisibility(View.GONE);
        }*/


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent2(ZzaqEvent zzaqEvent) {

      if (zzaqEvent.getType() == ZzaqEvent.DISMISS_ZZAQ) {
            rwxq_main.setVisibility(View.GONE);
            amap_view.setVisibility(View.VISIBLE);
            under_circle.setVisibility(View.VISIBLE);
      } else if (zzaqEvent.getType() == ZzaqEvent.SHOW_ZZAQ){
            amap_view.setVisibility(View.GONE);
          under_circle.setVisibility(View.GONE);
            rwxq_main.setVisibility(View.VISIBLE);

      }


    }

}