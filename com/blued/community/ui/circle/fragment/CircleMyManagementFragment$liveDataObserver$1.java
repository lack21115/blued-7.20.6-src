package com.blued.community.ui.circle.fragment;

import com.blued.community.ui.circle.model.MyCircleModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleMyManagementFragment$liveDataObserver$1.class */
final /* synthetic */ class CircleMyManagementFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<List<? extends MyCircleModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleMyManagementFragment$liveDataObserver$1(Object obj) {
        super(1, obj, CircleMyManagementFragment.class, "setDataList", "setDataList(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends MyCircleModel> p0) {
        Intrinsics.e(p0, "p0");
        ((CircleMyManagementFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends MyCircleModel> list) {
        a(list);
        return Unit.f42314a;
    }
}
