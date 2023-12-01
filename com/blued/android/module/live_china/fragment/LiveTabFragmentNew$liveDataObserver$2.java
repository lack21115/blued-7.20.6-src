package com.blued.android.module.live_china.fragment;

import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveTabFragmentNew$liveDataObserver$2.class */
final /* synthetic */ class LiveTabFragmentNew$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<List<? extends LiveTwoFloorModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveTabFragmentNew$liveDataObserver$2(Object obj) {
        super(1, obj, LiveTabFragmentNew.class, "setTwoLevel", "setTwoLevel(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends LiveTwoFloorModel> p0) {
        Intrinsics.e(p0, "p0");
        ((LiveTabFragmentNew) this.receiver).b(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends LiveTwoFloorModel> list) {
        a(list);
        return Unit.f42314a;
    }
}
