package com.blued.community.track;

import com.blued.das.message.MessageProtos;
import com.blued.das.vip.VipProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/track/EventTrackOther.class */
public class EventTrackOther {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(MessageProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(MessageProtos.MessageProto.newBuilder().setEvent(event).setType(a(str)).build());
        }
    }

    public static void a(VipProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(VipProtos.VipProto.newBuilder().setEvent(event).build());
        }
    }
}
