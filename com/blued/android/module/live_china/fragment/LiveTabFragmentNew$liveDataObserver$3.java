package com.blued.android.module.live_china.fragment;

import com.blued.android.module.live_china.model.BluedLiveListData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveTabFragmentNew$liveDataObserver$3.class */
final /* synthetic */ class LiveTabFragmentNew$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<List<BluedLiveListData>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveTabFragmentNew$liveDataObserver$3(Object obj) {
        super(1, obj, LiveTabFragmentNew.class, "setLiveList", "setLiveList(Ljava/util/List;)V", 0);
    }

    public final void a(List<BluedLiveListData> p0) {
        Intrinsics.e(p0, "p0");
        ((LiveTabFragmentNew) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<BluedLiveListData> list) {
        a(list);
        return Unit.a;
    }
}
