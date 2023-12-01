package com.soft.blued.ui.msg;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ServiceMsgFragment$liveDataObserver$1.class */
final /* synthetic */ class ServiceMsgFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceMsgFragment$liveDataObserver$1(Object obj) {
        super(1, obj, ServiceMsgFragment.class, "showGuidePop", "showGuidePop(Z)V", 0);
    }

    public final void a(boolean z) {
        ((ServiceMsgFragment) this.receiver).a(z);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a(((Boolean) obj).booleanValue());
        return Unit.a;
    }
}
