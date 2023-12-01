package com.blued.community.ui.circle.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTypeListFragment$liveDataObserver$3.class */
final /* synthetic */ class CircleTypeListFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CircleTypeListFragment$liveDataObserver$3(Object obj) {
        super(1, obj, CircleTypeListFragment.class, "typeListLoadFinish", "typeListLoadFinish(Z)V", 0);
    }

    public final void a(boolean z) {
        ((CircleTypeListFragment) this.receiver).b(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean bool) {
        a(bool.booleanValue());
        return Unit.a;
    }
}
