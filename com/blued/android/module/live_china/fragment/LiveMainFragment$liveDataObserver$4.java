package com.blued.android.module.live_china.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMainFragment$liveDataObserver$4.class */
final /* synthetic */ class LiveMainFragment$liveDataObserver$4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveMainFragment$liveDataObserver$4(Object obj) {
        super(1, obj, LiveMainFragment.class, "showFirstCharge", "showFirstCharge(I)V", 0);
    }

    public final void a(int i) {
        ((LiveMainFragment) this.receiver).b(i);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Integer num) {
        a(num.intValue());
        return Unit.f42314a;
    }
}
