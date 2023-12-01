package com.soft.blued.log.track;

import com.blued.das.client.featured.FeaturedProtos;
import com.blued.track.trackUtils.EventTrackUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/log/track/EventTrackFeatured.class */
public class EventTrackFeatured {
    private static String a(String str) {
        return EventTrackUtils.a(str);
    }

    public static void a(FeaturedProtos.Event event, String str, int i, String str2) {
        if (event != null) {
            EventTrackUtils.a(FeaturedProtos.FeaturedProto.newBuilder().setEvent(event).setTargetUid(a(str)).setReason(i).setLabel(a(str2)).build());
        }
    }
}
