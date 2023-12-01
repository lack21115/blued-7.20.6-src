package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPThreadPriority.class */
public class TPThreadPriority {
    @TPNativeKeyMap.MapThreadPriorityType(35)
    public static final int THREAD_PRIORITY_AUDIO = 35;
    @TPNativeKeyMap.MapThreadPriorityType(9)
    public static final int THREAD_PRIORITY_BACKGROUND = 9;
    @TPNativeKeyMap.MapThreadPriorityType(-1)
    public static final int THREAD_PRIORITY_DEFAULT = -1;
    @TPNativeKeyMap.MapThreadPriorityType(23)
    public static final int THREAD_PRIORITY_DISPLAY = 23;
    @TPNativeKeyMap.MapThreadPriorityType(21)
    public static final int THREAD_PRIORITY_FOREGROUND = 21;
    @TPNativeKeyMap.MapThreadPriorityType(0)
    public static final int THREAD_PRIORITY_LOWEST = 0;
    @TPNativeKeyMap.MapThreadPriorityType(38)
    public static final int THREAD_PRIORITY_URGENT_AUDIO = 38;
    @TPNativeKeyMap.MapThreadPriorityType(27)
    public static final int THREAD_PRIORITY_URGENT_DISPLAY = 27;
    @TPNativeKeyMap.MapThreadPriorityType(29)
    public static final int THREAD_PRIORITY_VIDEO = 29;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPThreadPriority$THREAD_PRIORITY.class */
    public @interface THREAD_PRIORITY {
    }
}
