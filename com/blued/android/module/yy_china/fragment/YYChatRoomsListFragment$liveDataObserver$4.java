package com.blued.android.module.yy_china.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomsListFragment$liveDataObserver$4.class */
final /* synthetic */ class YYChatRoomsListFragment$liveDataObserver$4 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYChatRoomsListFragment$liveDataObserver$4(Object obj) {
        super(1, obj, YYChatRoomsListFragment.class, "setGetRoomTypesError", "setGetRoomTypesError(Z)V", 0);
    }

    public final void a(boolean z) {
        ((YYChatRoomsListFragment) this.receiver).c(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean bool) {
        a(bool.booleanValue());
        return Unit.a;
    }
}
