package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.HomeTopicModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomsListFragment$liveDataObserver$3.class */
final /* synthetic */ class YYChatRoomsListFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<List<? extends HomeTopicModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYChatRoomsListFragment$liveDataObserver$3(Object obj) {
        super(1, obj, YYChatRoomsListFragment.class, "setRoomTypes", "setRoomTypes(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends HomeTopicModel> p0) {
        Intrinsics.e(p0, "p0");
        ((YYChatRoomsListFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends HomeTopicModel> list) {
        a(list);
        return Unit.f42314a;
    }
}
