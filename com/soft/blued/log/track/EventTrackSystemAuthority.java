package com.soft.blued.log.track;

import com.blued.das.authority.SystemAuthorityProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackSystemAuthority.class */
public class EventTrackSystemAuthority {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(SystemAuthorityProtos.Event event) {
        if (event != null) {
            EventTrackUtils.a(SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(event).build());
        }
    }

    public static void a(SystemAuthorityProtos.Event event, SystemAuthorityProtos.Type type, boolean z) {
        if (event == null || type == null) {
            return;
        }
        EventTrackUtils.a(SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(event).setType(type).setIsOpen(z).build());
    }

    public static void a(SystemAuthorityProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(event).setUrl(a(str)).build());
        }
    }

    public static void b(SystemAuthorityProtos.Event event, String str) {
        if (event != null) {
            EventTrackUtils.a(SystemAuthorityProtos.SystemAuthorityProto.newBuilder().setEvent(event).setContent(str).build());
        }
    }
}
