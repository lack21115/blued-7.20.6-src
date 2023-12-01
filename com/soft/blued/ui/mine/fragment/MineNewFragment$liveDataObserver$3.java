package com.soft.blued.ui.mine.fragment;

import com.kuaishou.weapon.p0.bp;
import com.soft.blued.ui.msg.model.GroupGuideModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineNewFragment$liveDataObserver$3.class */
final /* synthetic */ class MineNewFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<GroupGuideModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MineNewFragment$liveDataObserver$3(Object obj) {
        super(1, obj, MineNewFragment.class, "showGroupGuide", "showGroupGuide(Lcom/soft/blued/ui/msg/model/GroupGuideModel;)V", 0);
    }

    public final void a(GroupGuideModel groupGuideModel) {
        Intrinsics.e(groupGuideModel, bp.g);
        ((MineNewFragment) this.receiver).a(groupGuideModel);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((GroupGuideModel) obj);
        return Unit.a;
    }
}
