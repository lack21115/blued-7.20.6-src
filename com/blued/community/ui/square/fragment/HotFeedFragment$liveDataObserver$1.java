package com.blued.community.ui.square.fragment;

import com.blued.community.model.BluedIngSelfFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/fragment/HotFeedFragment$liveDataObserver$1.class */
final /* synthetic */ class HotFeedFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<List<? extends BluedIngSelfFeed>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public HotFeedFragment$liveDataObserver$1(Object obj) {
        super(1, obj, HotFeedFragment.class, "setDataList", "setDataList(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends BluedIngSelfFeed> p0) {
        Intrinsics.e(p0, "p0");
        ((HotFeedFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends BluedIngSelfFeed> list) {
        a(list);
        return Unit.a;
    }
}
