package com.blued.android.module.yy_china.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeRoomsFragment$liveDataObserver$3.class */
final /* synthetic */ class YYHomeRoomsFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeRoomsFragment$liveDataObserver$3(Object obj) {
        super(1, obj, YYHomeRoomsFragment.class, "dataNull", "dataNull(Ljava/lang/String;)V", 0);
    }

    public final void a(String p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeRoomsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(String str) {
        a(str);
        return Unit.f42314a;
    }
}
