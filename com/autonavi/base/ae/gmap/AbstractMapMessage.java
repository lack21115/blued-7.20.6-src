package com.autonavi.base.ae.gmap;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/base/ae/gmap/AbstractMapMessage.class */
public abstract class AbstractMapMessage {
    public static final int GESTURE_STATE_BEGIN = 100;
    public static final int GESTURE_STATE_CHANGE = 101;
    public static final int GESTURE_STATE_END = 102;
    public static final int MSGTYPE_NAVIOVERLAY_STATE = 13;

    public abstract int getType();
}
