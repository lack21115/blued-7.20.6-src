package com.blued.android.module.live_china.fragment;

import com.blued.android.module.live_china.model.LiveLiangModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMainFragment$liveDataObserver$2.class */
final /* synthetic */ class LiveMainFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<List<LiveLiangModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveMainFragment$liveDataObserver$2(Object obj) {
        super(1, obj, LiveMainFragment.class, "showLiangIdInfo", "showLiangIdInfo(Ljava/util/List;)V", 0);
    }

    public final void a(List<LiveLiangModel> p0) {
        Intrinsics.e(p0, "p0");
        ((LiveMainFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<LiveLiangModel> list) {
        a(list);
        return Unit.a;
    }
}
