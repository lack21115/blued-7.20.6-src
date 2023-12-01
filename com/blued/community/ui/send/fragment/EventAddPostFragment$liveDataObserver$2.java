package com.blued.community.ui.send.fragment;

import com.blued.community.ui.send.model.EventAddPostTypeExtra;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/EventAddPostFragment$liveDataObserver$2.class */
final /* synthetic */ class EventAddPostFragment$liveDataObserver$2 extends FunctionReferenceImpl implements Function1<EventAddPostTypeExtra, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventAddPostFragment$liveDataObserver$2(Object obj) {
        super(1, obj, EventAddPostFragment.class, "setTypeExtra", "setTypeExtra(Lcom/blued/community/ui/send/model/EventAddPostTypeExtra;)V", 0);
    }

    public final void a(EventAddPostTypeExtra eventAddPostTypeExtra) {
        ((EventAddPostFragment) this.receiver).a(eventAddPostTypeExtra);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(EventAddPostTypeExtra eventAddPostTypeExtra) {
        a(eventAddPostTypeExtra);
        return Unit.a;
    }
}
