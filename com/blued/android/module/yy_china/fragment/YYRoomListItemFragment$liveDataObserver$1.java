package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYChatRoomModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomListItemFragment$liveDataObserver$1.class */
final /* synthetic */ class YYRoomListItemFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<List<? extends YYChatRoomModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYRoomListItemFragment$liveDataObserver$1(Object obj) {
        super(1, obj, YYRoomListItemFragment.class, "showNewRoomDatas", "showNewRoomDatas(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends YYChatRoomModel> list) {
        ((YYRoomListItemFragment) this.receiver).b(list);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends YYChatRoomModel> list) {
        a(list);
        return Unit.f42314a;
    }
}
