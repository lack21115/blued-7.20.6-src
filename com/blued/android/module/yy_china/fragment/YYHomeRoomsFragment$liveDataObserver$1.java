package com.blued.android.module.yy_china.fragment;

import com.blued.android.module.yy_china.model.HomeRightMenuModels;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeRoomsFragment$liveDataObserver$1.class */
final /* synthetic */ class YYHomeRoomsFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<HomeRightMenuModels, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YYHomeRoomsFragment$liveDataObserver$1(Object obj) {
        super(1, obj, YYHomeRoomsFragment.class, "changeState", "changeState(Lcom/blued/android/module/yy_china/model/HomeRightMenuModels;)V", 0);
    }

    public final void a(HomeRightMenuModels p0) {
        Intrinsics.e(p0, "p0");
        ((YYHomeRoomsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(HomeRightMenuModels homeRightMenuModels) {
        a(homeRightMenuModels);
        return Unit.f42314a;
    }
}
