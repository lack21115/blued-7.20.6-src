package com.soft.blued.ui.msg_group.event;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/event/UpdateGroupGradeEvent.class */
public final class UpdateGroupGradeEvent {

    /* renamed from: a  reason: collision with root package name */
    private int f18976a;
    private String b = "";

    public final void a(int i) {
        this.f18976a = i;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.b = str;
    }
}
