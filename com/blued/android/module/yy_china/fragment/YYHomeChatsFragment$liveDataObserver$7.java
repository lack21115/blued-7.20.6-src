package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.YYChatRoomGuideListMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$liveDataObserver$7.class */
final /* synthetic */ class YYHomeChatsFragment$liveDataObserver$7 extends FunctionReferenceImpl implements Function1<YYChatRoomGuideListMode, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeChatsFragment$liveDataObserver$7(Object obj) {
        super(1, obj, YYHomeChatsFragment.class, "showGuideView", "showGuideView(Lcom/blued/android/module/yy_china/model/YYChatRoomGuideListMode;)V", 0);
    }

    public final void a(YYChatRoomGuideListMode yYChatRoomGuideListMode) {
        ((YYHomeChatsFragment) this.receiver).a(yYChatRoomGuideListMode);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(YYChatRoomGuideListMode yYChatRoomGuideListMode) {
        a(yYChatRoomGuideListMode);
        return Unit.a;
    }
}
