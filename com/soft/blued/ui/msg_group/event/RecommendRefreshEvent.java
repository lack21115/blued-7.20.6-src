package com.soft.blued.ui.msg_group.event;

import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/event/RecommendRefreshEvent.class */
public final class RecommendRefreshEvent {

    /* renamed from: a  reason: collision with root package name */
    private final RecommendGroupFragment.RecommendType f18973a;

    public RecommendRefreshEvent() {
        this(null, 1, null);
    }

    public RecommendRefreshEvent(RecommendGroupFragment.RecommendType recommendType) {
        Intrinsics.e(recommendType, "type");
        this.f18973a = recommendType;
    }

    public /* synthetic */ RecommendRefreshEvent(RecommendGroupFragment.RecommendType recommendType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RecommendGroupFragment.RecommendType.RECOMMEND : recommendType);
    }

    public final RecommendGroupFragment.RecommendType getType() {
        return this.f18973a;
    }
}
