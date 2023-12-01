package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYChatRoomGuideListMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYChatRoomsListFragment$liveDataObserver$8.class */
final /* synthetic */ class YYChatRoomsListFragment$liveDataObserver$8 extends FunctionReferenceImpl implements Function1<YYChatRoomGuideListMode, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYChatRoomsListFragment$liveDataObserver$8(Object obj) {
        super(1, obj, YYChatRoomsListFragment.class, "showGuideView", "showGuideView(Lcom/blued/android/module/yy_china/model/YYChatRoomGuideListMode;)V", 0);
    }

    public final void a(YYChatRoomGuideListMode yYChatRoomGuideListMode) {
        ((YYChatRoomsListFragment) this.receiver).a(yYChatRoomGuideListMode);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(YYChatRoomGuideListMode yYChatRoomGuideListMode) {
        a(yYChatRoomGuideListMode);
        return Unit.a;
    }
}
