package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/HelloOpenState.class */
public class HelloOpenState extends BluedEntityBaseExtra {
    public long countdown;
    public long expire_time;
    public int is_quietly;
    public float multiples;
    public int open_status = -1;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/HelloOpenState$OpenStatus.class */
    public interface OpenStatus {
        public static final int AUDIT = 3;
        public static final int FAIL = 0;
        public static final int MUTE = 5;
        public static final int NO_TIME = 2;
        public static final int OPEN = 1;
    }
}
