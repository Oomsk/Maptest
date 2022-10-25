package com.omsk.maptest.view;

import android.content.Context;
import android.content.pm.LabeledIntent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.omsk.maptest.R;
import com.omsk.maptest.event.ZzaqEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

public class HeadView extends RelativeLayout implements View.OnClickListener {



    public HeadView(Context context) {
        super(context);
        init(context);
    }

    public HeadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HeadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public HeadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_head, null);
        inflate.findViewById(R.id.top_view_zzzc).setOnClickListener(this);

        addView(inflate);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.top_view_zzzc:
                ZzaqEvent zzaqEvent = new ZzaqEvent();
                zzaqEvent.setType(ZzaqEvent.SHOW_ZZAQ);
                EventBus.getDefault().post(zzaqEvent);

        }
    }
}
