package com.blued.android.module.yy_china.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$liveDataObserver$3.class */
final /* synthetic */ class YYHomeChatsFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeChatsFragment$liveDataObserver$3(Object obj) {
        super(1, obj, YYHomeChatsFragment.class, "setGetRoomTypesError", "setGetRoomTypesError(Z)V", 0);
    }

    public final void a(boolean z) {
        ((YYHomeChatsFragment) this.receiver).e(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean bool) {
        a(bool.booleanValue());
        return Unit.f42314a;
    }
}
