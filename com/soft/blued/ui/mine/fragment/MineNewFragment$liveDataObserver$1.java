package com.soft.blued.ui.mine.fragment;

import com.soft.blued.ui.mine.model.MinePageModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineNewFragment$liveDataObserver$1.class */
final /* synthetic */ class MineNewFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<MinePageModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MineNewFragment$liveDataObserver$1(Object obj) {
        super(1, obj, MineNewFragment.class, "setMineData", "setMineData(Lcom/soft/blued/ui/mine/model/MinePageModel;)V", 0);
    }

    public final void a(MinePageModel p0) {
        Intrinsics.e(p0, "p0");
        ((MineNewFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(MinePageModel minePageModel) {
        a(minePageModel);
        return Unit.f42314a;
    }
}
