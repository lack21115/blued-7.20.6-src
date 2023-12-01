package com.blued.login.log;

import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.track.trackUtils.EventTrackUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/login/log/EventTrackLogin.class */
public final class EventTrackLogin {

    /* renamed from: a  reason: collision with root package name */
    public static final EventTrackLogin f20558a = new EventTrackLogin();

    private EventTrackLogin() {
    }

    @JvmStatic
    public static final void a(LoginAndRegisterProtos.Event event, LoginAndRegisterProtos.Source source) {
        Intrinsics.e(event, "event");
        Intrinsics.e(source, "source");
        EventTrackUtils.a(LoginAndRegisterProtos.LoginAndRegisterProto.newBuilder().setEvent(event).setSource(source).build());
    }
}
