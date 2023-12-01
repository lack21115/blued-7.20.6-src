package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.HomeThemeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeChatsFragment$liveDataObserver$2.class */
final /* synthetic */ class YYHomeChatsFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<List<? extends HomeThemeModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeChatsFragment$liveDataObserver$2(Object obj) {
        super(1, obj, YYHomeChatsFragment.class, "setRoomTypes", "setRoomTypes(Ljava/util/List;)V", 0);
    }

    public final void a(List<HomeThemeModel> p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeChatsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends HomeThemeModel> list) {
        a(list);
        return Unit.a;
    }
}
