package com.blued.android.module.live_china.fragment;

import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveTabFragmentNew$liveDataObserver$1.class */
final /* synthetic */ class LiveTabFragmentNew$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<AnchorLiveStateModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveTabFragmentNew$liveDataObserver$1(Object obj) {
        super(1, obj, LiveTabFragmentNew.class, "setLiveState", "setLiveState(Lcom/blued/android/module/live_china/model/AnchorLiveStateModel;)V", 0);
    }

    public final void a(AnchorLiveStateModel p0) {
        Intrinsics.e(p0, "p0");
        ((LiveTabFragmentNew) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(AnchorLiveStateModel anchorLiveStateModel) {
        a(anchorLiveStateModel);
        return Unit.f42314a;
    }
}
