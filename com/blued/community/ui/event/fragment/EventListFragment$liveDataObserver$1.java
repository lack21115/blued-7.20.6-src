package com.blued.community.ui.event.fragment;

import com.blued.community.ui.event.model.EventDetailsModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventListFragment$liveDataObserver$1.class */
final /* synthetic */ class EventListFragment$liveDataObserver$1 extends FunctionReferenceImpl implements Function1<List<? extends EventDetailsModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventListFragment$liveDataObserver$1(Object obj) {
        super(1, obj, EventListFragment.class, "setEventListData", "setEventListData(Ljava/util/List;)V", 0);
    }

    public final void a(List<? extends EventDetailsModel> p0) {
        Intrinsics.e(p0, "p0");
        ((EventListFragment) this.receiver).a(p0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends EventDetailsModel> list) {
        a(list);
        return Unit.f42314a;
    }
}
