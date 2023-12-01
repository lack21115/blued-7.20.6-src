package com.blued.android.module.live_china.test;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/test/LiveHomeFramentTest$liveDataObserver$1.class */
final /* synthetic */ class LiveHomeFramentTest$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<List<? extends BluedLiveListDataTest>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LiveHomeFramentTest$liveDataObserver$1(Object obj) {
        super(1, obj, LiveHomeFramentTest.class, "setData", "setData(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends BluedLiveListDataTest> p0) {
        Intrinsics.e(p0, "p0");
        ((LiveHomeFramentTest) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends BluedLiveListDataTest> list) {
        a(list);
        return Unit.a;
    }
}
