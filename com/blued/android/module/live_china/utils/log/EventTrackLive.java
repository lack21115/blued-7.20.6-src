package com.blued.android.module.live_china.utils.log;

import com.blued.das.live.LiveProtos;
import com.google.protobuf.Message;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/utils/log/EventTrackLive.class */
public class EventTrackLive {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(LiveProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(LiveProtos.Event event, LiveProtos.Source source, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setSource(source).build());
        }
    }

    public static void a(LiveProtos.Event event, LiveProtos.Status status) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setStatus(status).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setTaskId(a(str3)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, String str4) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setId(a(str3)).setGoodsId(a(str4)).build());
        }
    }

    public static void a(LiveProtos.Event event, String str, String str2, String str3, boolean z, boolean z2) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setType(a(str3)).setIsTrue(z).setIsSuccess(z2).build());
        }
    }

    public static void b(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setId(a(str3)).build());
        }
    }

    public static void c(LiveProtos.Event event, String str, String str2, String str3) {
        if (event != null) {
            EventTrackUtils.a((Message) LiveProtos.LiveProto.newBuilder().setEvent(event).setTargetUid(a(str2)).setLiveId(a(str)).setType(a(str3)).build());
        }
    }
}
