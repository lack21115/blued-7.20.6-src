package com.blued.android.module.live_china.fragment;

import com.blued.android.module.live_china.model.LiveTabInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMainFragment$liveDataObserver$1.class */
final /* synthetic */ class LiveMainFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<LiveTabInfo, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveMainFragment$liveDataObserver$1(Object obj) {
        super(1, obj, LiveMainFragment.class, "setTab", "setTab(Lcom/blued/android/module/live_china/model/LiveTabInfo;)V", 0);
    }

    public final void a(LiveTabInfo p0) {
        Intrinsics.e(p0, "p0");
        ((LiveMainFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(LiveTabInfo liveTabInfo) {
        a(liveTabInfo);
        return Unit.a;
    }
}
