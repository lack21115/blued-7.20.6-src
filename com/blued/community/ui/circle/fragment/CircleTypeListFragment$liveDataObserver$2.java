package com.blued.community.ui.circle.fragment;

import com.blued.community.ui.circle.model.CircleTypeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTypeListFragment$liveDataObserver$2.class */
final /* synthetic */ class CircleTypeListFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<List<? extends CircleTypeModel.DataBean>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleTypeListFragment$liveDataObserver$2(Object obj) {
        super(1, obj, CircleTypeListFragment.class, "setCircleTypeListData", "setCircleTypeListData(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends CircleTypeModel.DataBean> p0) {
        Intrinsics.e(p0, "p0");
        ((CircleTypeListFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends CircleTypeModel.DataBean> list) {
        a(list);
        return Unit.f42314a;
    }
}
