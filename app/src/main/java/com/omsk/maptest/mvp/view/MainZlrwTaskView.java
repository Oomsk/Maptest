package com.omsk.maptest.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;


import com.omsk.maptest.R;
import com.omsk.maptest.event.ZlrwEvent;

import org.greenrobot.eventbus.EventBus;

public class MainZlrwTaskView extends LinearLayout implements View.OnClickListener {

    private Context context;

    public MainZlrwTaskView(Context context) {
        super(context);
        initView(context);
    }

    public MainZlrwTaskView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public MainZlrwTaskView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MainZlrwTaskView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.zlrw_task_content_layout, null);
        addView(view);

        /*view.findViewById(R.id.zlrw_close).setOnClickListener(this);*/

    }

    @Override
    public void onClick(View v) {

    }
}
