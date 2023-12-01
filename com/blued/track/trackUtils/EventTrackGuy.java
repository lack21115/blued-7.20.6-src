package com.blued.track.trackUtils;

import com.blued.das.guy.GuyProtos;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/track/trackUtils/EventTrackGuy.class */
public final class EventTrackGuy {

    /* renamed from: a  reason: collision with root package name */
    public static final EventTrackGuy f20626a = new EventTrackGuy();

    private EventTrackGuy() {
    }

    @JvmStatic
    public static final void a(String str) {
        EventTrackUtils.a(GuyProtos.GuyProto.newBuilder().setEvent(GuyProtos.Event.PAGE_REFRESH).setType(EventTrackUtils.a(str)).build());
    }
}
