package com.blued.community.ui.event.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$liveDataObserver$7.class */
final /* synthetic */ class EventDetailsFragment$liveDataObserver$7 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetailsFragment$liveDataObserver$7(Object obj) {
        super(1, obj, EventDetailsFragment.class, "setReviewsCount", "setReviewsCount(I)V", 0);
    }

    public final void a(int i) {
        ((EventDetailsFragment) this.receiver).a(i);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Integer num) {
        a(num.intValue());
        return Unit.a;
    }
}
