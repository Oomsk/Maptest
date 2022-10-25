package com.omsk.maptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.omsk.maptest.R;
import com.omsk.maptest.event.ZzaqEvent;

import org.greenrobot.eventbus.EventBus;

public class RwxqView extends LinearLayout implements View.OnClickListener {

    private Context context;

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
        View view = inflater.inflate(R.layout.rwxq_detail_layout, this, false);

        view.findViewById(R.id.rwxq_fanhui).setOnClickListener(this);

        addView(view);
    }



    @Override
    public void onClick(View view) {

        Log.w("omsk", "点击事件");

        switch (view.getId()) {
            case R.id.rwxq_fanhui:
                ZzaqEvent zzaqEvent = new ZzaqEvent();
                zzaqEvent.setType(ZzaqEvent.DISMISS_ZZAQ);
                EventBus.getDefault().post(zzaqEvent);
                break;
        }
    }
}
