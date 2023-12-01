package com.bytedance.android.live.base.api;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/IEventListener.class */
public interface IEventListener {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/android/live/base/api/IEventListener$Event.class */
    public static class Event {
        public static final int TYPE_COMMENT = 4;
        public static final int TYPE_ENTER = 1;
        public static final int TYPE_EXIT = 2;
        public static final int TYPE_FOLLOW = 3;
        public static final int TYPE_ORDER = 5;
        public static final int TYPE_UNKNOWN = 0;
        public long time;
        public int type;

        public Event(int i, long j) {
            this.type = 0;
            this.time = 0L;
            this.type = i;
            this.time = j;
        }
    }

    void onEvent(Event event);
}
