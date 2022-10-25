package com.omsk.maptest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.omsk.maptest.R;

import butterknife.ButterKnife;

public class MainZlrwItemView extends LinearLayout implements View.OnClickListener {

    private Context context;

    View ZlrwView,ZlrwTaskView;


    public MainZlrwItemView(Context context) {
        super(context);
    }

    public MainZlrwItemView(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        initView(context);
    }

    public MainZlrwItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public MainZlrwItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        ButterKnife.bind(this);
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_zlrw_item, null);
        addView(view);

        Log.w("test", "初始化");


    }

    @Override
    public void onClick(View view) {


    }
}
