package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYRoomExtraModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$liveDataObserver$6.class */
final /* synthetic */ class YYHomeChatsFragment$liveDataObserver$6 extends FunctionReferenceImpl implements Function1<YYRoomExtraModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeChatsFragment$liveDataObserver$6(Object obj) {
        super(1, obj, YYHomeChatsFragment.class, "showCreateLayout", "showCreateLayout(Lcom/blued/android/module/yy_china/model/YYRoomExtraModel;)V", 0);
    }

    public final void a(YYRoomExtraModel p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeChatsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(YYRoomExtraModel yYRoomExtraModel) {
        a(yYRoomExtraModel);
        return Unit.f42314a;
    }
}
