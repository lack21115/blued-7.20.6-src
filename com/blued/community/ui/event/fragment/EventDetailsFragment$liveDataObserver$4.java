package com.blued.community.ui.event.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$liveDataObserver$4.class */
final /* synthetic */ class EventDetailsFragment$liveDataObserver$4 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetailsFragment$liveDataObserver$4(Object obj) {
        super(1, obj, EventDetailsFragment.class, "setFeedListHasMore", "setFeedListHasMore(Z)V", 0);
    }

    public final void a(boolean z) {
        ((EventDetailsFragment) this.receiver).b(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean bool) {
        a(bool.booleanValue());
        return Unit.f42314a;
    }
}
