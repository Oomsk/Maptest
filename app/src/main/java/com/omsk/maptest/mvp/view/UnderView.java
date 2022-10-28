package com.omsk.maptest.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.omsk.maptest.R;

public class UnderView extends RelativeLayout {


    public UnderView(Context context) {
        super(context);
        init(context);
    }

    public UnderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public UnderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public UnderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_under, null);
        addView(inflate);

    }
}
