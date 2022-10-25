package com.omsk.maptest.event;

public class ZlrwEvent {

    public static final int SHOW_VIEW = 11;

    public static final int CLOSE_VIEW = 12;

    public static final int SHOW_DETAIL = 21;

    public static final int DISMISS_DETAIL = 22;

    public static final int YJCT = 31;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
