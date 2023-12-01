package com.blued.community.ui.event.fragment;

import com.blued.community.model.BluedIngSelfFeed;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$liveDataObserver$3.class */
final /* synthetic */ class EventDetailsFragment$liveDataObserver$3 extends FunctionReferenceImpl implements Function1<List<? extends BluedIngSelfFeed>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetailsFragment$liveDataObserver$3(Object obj) {
        super(1, obj, EventDetailsFragment.class, "setFeedList", "setFeedList(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends BluedIngSelfFeed> p0) {
        Intrinsics.e(p0, "p0");
        ((EventDetailsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends BluedIngSelfFeed> list) {
        a(list);
        return Unit.f42314a;
    }
}
