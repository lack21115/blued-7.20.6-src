package com.soft.blued.ui.msg.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/event/UpdateSourceFromEvent.class */
public final class UpdateSourceFromEvent {

    /* renamed from: a  reason: collision with root package name */
    private final String f32329a;

    public UpdateSourceFromEvent(String source) {
        Intrinsics.e(source, "source");
        this.f32329a = source;
    }

    public final String a() {
        return this.f32329a;
    }
}
