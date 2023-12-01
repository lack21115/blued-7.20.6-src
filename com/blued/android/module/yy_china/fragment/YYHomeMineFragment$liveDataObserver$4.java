package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeMineFragment$liveDataObserver$4.class */
final /* synthetic */ class YYHomeMineFragment$liveDataObserver$4 extends FunctionReferenceImpl implements Function1<List<? extends YYChatRoomFollowedModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeMineFragment$liveDataObserver$4(Object obj) {
        super(1, obj, YYHomeMineFragment.class, "setFollowData", "setFollowData(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends YYChatRoomFollowedModel> p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeMineFragment) this.receiver).b(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends YYChatRoomFollowedModel> list) {
        a(list);
        return Unit.f42314a;
    }
}
