package com.blued.community.ui.send.dialog;

import com.blued.community.ui.send.model.EventAddPostTypeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/send/dialog/EventTypeDialogFragment$initData$1.class */
public final /* synthetic */ class EventTypeDialogFragment$initData$1 extends FunctionReferenceImpl implements Function1<List<? extends EventAddPostTypeModel>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventTypeDialogFragment$initData$1(Object obj) {
        super(1, obj, EventTypeDialogFragment.class, "setTypeList", "setTypeList(Ljava/util/List;)V", 0);
    }

    public final void a(List<EventAddPostTypeModel> list) {
        ((EventTypeDialogFragment) this.receiver).a(list);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(List<? extends EventAddPostTypeModel> list) {
        a(list);
        return Unit.a;
    }
}
