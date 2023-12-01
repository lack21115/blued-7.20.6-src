package com.blued.community.ui.send.dialog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/EventTypeDialogFragment$initData$2.class */
public final /* synthetic */ class EventTypeDialogFragment$initData$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventTypeDialogFragment$initData$2(Object obj) {
        super(1, obj, EventTypeDialogFragment.class, "setTypeId", "setTypeId(Ljava/lang/String;)V", 0);
    }

    public final void a(String p0) {
        Intrinsics.e(p0, "p0");
        ((EventTypeDialogFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(String str) {
        a(str);
        return Unit.f42314a;
    }
}
