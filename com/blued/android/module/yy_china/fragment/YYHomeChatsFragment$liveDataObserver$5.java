package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYMatchRoomModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$liveDataObserver$5.class */
final /* synthetic */ class YYHomeChatsFragment$liveDataObserver$5 extends FunctionReferenceImpl implements Function1<YYMatchRoomModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeChatsFragment$liveDataObserver$5(Object obj) {
        super(1, obj, YYHomeChatsFragment.class, "joinRoom", "joinRoom(Lcom/blued/android/module/yy_china/model/YYMatchRoomModel;)V", 0);
    }

    public final void a(YYMatchRoomModel p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeChatsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(YYMatchRoomModel yYMatchRoomModel) {
        a(yYMatchRoomModel);
        return Unit.f42314a;
    }
}
