package com.soft.blued.log.track;

import android.util.Log;
import com.blued.das.live.LiveProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackLive.class */
public class EventTrackLive {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(LiveProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, int i) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str)).setNum(i).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, int i, int i2) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str)).setGoodsId(str2).setCount(i).setNum(i2).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, LiveProtos.EnterType enterType) {
        if (event == null || enterType == null) {
            return;
        }
        EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setEnterType(enterType).build());
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveId(a(str)).setLiveTypeId(a(str2)).setTargetUid(a(str3)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, boolean z) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveTab(a(str)).setTargetUid(a(str3)).setLiveId(a(str2)).setIsTrue(z).build());
        }
    }

    public static void a(LiveProtos.Event event, boolean z) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setIsJoin(z).build());
        }
    }

    public static void b(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str)).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setTaskId(a(str3)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setUrl(str).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, String str3) {
        Log.i("==tab", "tabId:" + str + "  lid:" + str2);
        if (event != null) {
            EventTrackUtils.a(LiveProtos.LiveProto.newBuilder().setEvent(event).setLiveTab(a(str)).setTargetUid(a(str3)).setLiveId(a(str2)).build());
        }
    }
}
