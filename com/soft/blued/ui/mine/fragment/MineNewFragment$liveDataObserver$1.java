package com.soft.blued.ui.mine.fragment;

import com.kuaishou.weapon.p0.bp;
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

    public final void a(MinePageModel minePageModel) {
        Intrinsics.e(minePageModel, bp.g);
        ((MineNewFragment) this.receiver).a(minePageModel);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((MinePageModel) obj);
        return Unit.a;
    }
}
