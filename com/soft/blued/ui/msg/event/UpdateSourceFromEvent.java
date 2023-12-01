package com.soft.blued.ui.msg.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/event/UpdateSourceFromEvent.class */
public final class UpdateSourceFromEvent {

    /* renamed from: a  reason: collision with root package name */
    private final String f18639a;

    public UpdateSourceFromEvent(String str) {
        Intrinsics.e(str, "source");
        this.f18639a = str;
    }

    public final String a() {
        return this.f18639a;
    }
}
