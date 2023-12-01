package com.blued.community.ui.send.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/EventAddPostFragment$liveDataObserver$5.class */
final /* synthetic */ class EventAddPostFragment$liveDataObserver$5 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventAddPostFragment$liveDataObserver$5(Object obj) {
        super(1, obj, EventAddPostFragment.class, "setCity", "setCity(Ljava/lang/String;)V", 0);
    }

    public final void a(String p0) {
        Intrinsics.e(p0, "p0");
        ((EventAddPostFragment) this.receiver).b(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(String str) {
        a(str);
        return Unit.f42314a;
    }
}
