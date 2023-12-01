package com.soft.blued.ui.msg_group.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/event/UpdateAnnouncementEvent.class */
public final class UpdateAnnouncementEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f32666a;
    private final String b;

    public UpdateAnnouncementEvent(long j, String announcement) {
        Intrinsics.e(announcement, "announcement");
        this.f32666a = j;
        this.b = announcement;
    }

    public final long a() {
        return this.f32666a;
    }

    public final String b() {
        return this.b;
    }
}
