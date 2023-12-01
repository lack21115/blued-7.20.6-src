package com.blued.android.module.live_china.fragment;

import com.blued.android.module.live_china.model.MultiDialogModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMainFragment$liveDataObserver$3.class */
final /* synthetic */ class LiveMainFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<MultiDialogModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveMainFragment$liveDataObserver$3(Object obj) {
        super(1, obj, LiveMainFragment.class, "setMulitDialog", "setMulitDialog(Lcom/blued/android/module/live_china/model/MultiDialogModel;)V", 0);
    }

    public final void a(MultiDialogModel p0) {
        Intrinsics.e(p0, "p0");
        ((LiveMainFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(MultiDialogModel multiDialogModel) {
        a(multiDialogModel);
        return Unit.f42314a;
    }
}
