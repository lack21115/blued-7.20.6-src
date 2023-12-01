package com.blued.community.track;

import com.blued.das.superexpose.SuperExposeProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/track/EventTrackSuperExpose.class */
public class EventTrackSuperExpose {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(SuperExposeProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(SuperExposeProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(event).setId(a(str)).build());
        }
    }

    public static void a(String str, String str2, int i, int i2) {
        EventTrackUtils.a(SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(SuperExposeProtos.Event.EXPOSE_BUY_PAGE_PAY_CLICK).setSkuId(a(str)).setDiscountId(a(str2)).setStrategy(i).setRegion(i2).build());
    }

    public static void b(SuperExposeProtos.Event event, String str) {
        EventTrackUtils.a(SuperExposeProtos.SuperExposeProto.newBuilder().setEvent(event).setSkuId(a(str)).build());
    }
}
