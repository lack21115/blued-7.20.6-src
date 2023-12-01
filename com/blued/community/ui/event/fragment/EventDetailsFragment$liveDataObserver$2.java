package com.blued.community.ui.event.fragment;

import com.blued.community.ui.event.model.EventIdentifyModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$liveDataObserver$2.class */
final /* synthetic */ class EventDetailsFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<EventIdentifyModel, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetailsFragment$liveDataObserver$2(Object obj) {
        super(1, obj, EventDetailsFragment.class, "checkUserIdentify", "checkUserIdentify(Lcom/blued/community/ui/event/model/EventIdentifyModel;)V", 0);
    }

    public final void a(EventIdentifyModel p0) {
        Intrinsics.e(p0, "p0");
        ((EventDetailsFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(EventIdentifyModel eventIdentifyModel) {
        a(eventIdentifyModel);
        return Unit.f42314a;
    }
}
