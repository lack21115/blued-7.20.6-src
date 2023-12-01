package com.soft.blued.ui.mine.fragment;

import com.soft.blued.ui.mine.model.MinePageAdModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineNewFragment$liveDataObserver$2.class */
final /* synthetic */ class MineNewFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<MinePageAdModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MineNewFragment$liveDataObserver$2(Object obj) {
        super(1, obj, MineNewFragment.class, "setResourcePromotionEntry", "setResourcePromotionEntry(Lcom/soft/blued/ui/mine/model/MinePageAdModel;)V", 0);
    }

    public final void a(MinePageAdModel minePageAdModel) {
        ((MineNewFragment) this.receiver).a(minePageAdModel);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((MinePageAdModel) obj);
        return Unit.a;
    }
}
