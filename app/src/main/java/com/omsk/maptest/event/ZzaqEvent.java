package com.omsk.maptest.event;


public class ZzaqEvent {

    public final static int SHOW_ZZAQ = 1001;

    public final static int DISMISS_ZZAQ = 1002;

    public final static int SHOW_ZZAQ_DETAIL = 2001;

    public final static int DISMISS_ZZAQ_DETAIL = 2002;


    private int type;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
