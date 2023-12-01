package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYHomeChatsMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$liveDataObserver$9.class */
final /* synthetic */ class YYHomeChatsFragment$liveDataObserver$9 extends FunctionReferenceImpl implements Function1<YYHomeChatsMode, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeChatsFragment$liveDataObserver$9(Object obj) {
        super(1, obj, YYHomeChatsFragment.class, "showCardInfo", "showCardInfo(Lcom/blued/android/module/yy_china/model/YYHomeChatsMode;)V", 0);
    }

    public final void a(YYHomeChatsMode p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeChatsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(YYHomeChatsMode yYHomeChatsMode) {
        a(yYHomeChatsMode);
        return Unit.f42314a;
    }
}
