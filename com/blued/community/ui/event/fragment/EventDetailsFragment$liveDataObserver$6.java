package com.blued.community.ui.event.fragment;

import com.blued.community.ui.event.model.EventDetailsModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$liveDataObserver$6.class */
final /* synthetic */ class EventDetailsFragment$liveDataObserver$6 extends FunctionReferenceImpl implements Function1<List<? extends EventDetailsModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetailsFragment$liveDataObserver$6(Object obj) {
        super(1, obj, EventDetailsFragment.class, "setRecommendEventList", "setRecommendEventList(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends EventDetailsModel> p0) {
        Intrinsics.e(p0, "p0");
        ((EventDetailsFragment) this.receiver).b(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends EventDetailsModel> list) {
        a(list);
        return Unit.a;
    }
}
