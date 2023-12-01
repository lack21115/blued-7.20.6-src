package com.blued.community.ui.send.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/EventScoreAddPostFragment.class */
public final class EventScoreAddPostFragment extends FeedAddPostBaseFragment {
    public static final Companion b = new Companion(null);
    private int aW;
    private final Lazy aO = LazyKt.a(new Function0<View>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$layoutEventScore$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final View invoke() {
            return EventScoreAddPostFragment.this.j.findViewById(R.id.layout_event_score);
        }
    });
    private final Lazy aP = LazyKt.a(new Function0<View>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$ivScore1$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final View invoke() {
            return EventScoreAddPostFragment.this.j.findViewById(R.id.iv_score_1);
        }
    });
    private final Lazy aQ = LazyKt.a(new Function0<View>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$ivScore2$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final View invoke() {
            return EventScoreAddPostFragment.this.j.findViewById(R.id.iv_score_2);
        }
    });
    private final Lazy aR = LazyKt.a(new Function0<View>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$ivScore3$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final View invoke() {
            return EventScoreAddPostFragment.this.j.findViewById(R.id.iv_score_3);
        }
    });
    private final Lazy aS = LazyKt.a(new Function0<View>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$ivScore4$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final View invoke() {
            return EventScoreAddPostFragment.this.j.findViewById(R.id.iv_score_4);
        }
    });
    private final Lazy aT = LazyKt.a(new Function0<View>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$ivScore5$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final View invoke() {
            return EventScoreAddPostFragment.this.j.findViewById(R.id.iv_score_5);
        }
    });
    private final Lazy aU = LazyKt.a(new Function0<TextView>() { // from class: com.blued.community.ui.send.fragment.EventScoreAddPostFragment$tvEventEvaluate$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final TextView invoke() {
            return (TextView) EventScoreAddPostFragment.this.j.findViewById(R.id.tv_event_evaluate);
        }
    });
    private String aV = "";
    private String aX = "";

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/EventScoreAddPostFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, NewFeedModel newFeedModel) {
            if (CommunityServiceManager.a().b(context)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("feed_send_data", newFeedModel);
            TerminalActivity.d(context, EventScoreAddPostFragment.class, bundle);
        }

        public final void a(Context context, String eventId, int i, String str) {
            Intrinsics.e(context, "context");
            Intrinsics.e(eventId, "eventId");
            if (CommunityServiceManager.a().b(context) || TextUtils.isEmpty(eventId)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("event_id", eventId);
            bundle.putInt("event_score", i);
            if (str != null) {
                String str2 = str;
                if (StringsKt.c((CharSequence) str, (CharSequence) ",", false, 2, (Object) null)) {
                    str2 = StringsKt.a(str, ",", " . ", false, 4, (Object) null);
                }
                bundle.putString("event_evaluate", str2);
            }
            TerminalActivity.d(context, EventScoreAddPostFragment.class, bundle);
        }
    }

    protected final View A() {
        return (View) this.aP.getValue();
    }

    protected final View B() {
        return (View) this.aQ.getValue();
    }

    protected final View C() {
        return (View) this.aR.getValue();
    }

    protected final View D() {
        return (View) this.aS.getValue();
    }

    protected final View E() {
        return (View) this.aT.getValue();
    }

    protected final TextView F() {
        return (TextView) this.aU.getValue();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected String G() {
        if (this.ad) {
            String G = super.G();
            Intrinsics.c(G, "super.getEdtNewFeedHint()");
            return G;
        }
        String string = requireContext().getString(R.string.feed_post_event_score_hint);
        Intrinsics.c(string, "requireContext().getStri…ed_post_event_score_hint)");
        return string;
    }

    protected final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.aV = str;
    }

    protected final void b(int i) {
        this.aW = i;
    }

    protected final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.aX = str;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("event_id", "");
            Intrinsics.c(string, "getString(EVENT_ID, \"\")");
            a(string);
            b(arguments.getInt("event_score", 0));
            String string2 = arguments.getString("event_evaluate", "");
            Intrinsics.c(string2, "getString(EVENT_EVALUATE, \"\")");
            b(string2);
        }
        if (this.ah != null) {
            String str = this.ah.activity_id;
            Intrinsics.c(str, "mNewFeedModel.activity_id");
            this.aV = str;
            this.aW = this.ah.event_score;
            String str2 = this.ah.event_evaluate;
            Intrinsics.c(str2, "mNewFeedModel.event_evaluate");
            this.aX = str2;
        }
        if (this.aW == 0) {
            k().setVisibility(8);
        } else {
            k().setVisibility(0);
        }
        if (this.aW >= 1) {
            A().setVisibility(0);
        }
        if (this.aW >= 2) {
            B().setVisibility(0);
        }
        if (this.aW >= 3) {
            C().setVisibility(0);
        }
        if (this.aW >= 4) {
            D().setVisibility(0);
        }
        if (this.aW >= 5) {
            E().setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.aX)) {
            F().setVisibility(0);
            F().setText(Intrinsics.a(requireContext().getString(R.string.feed_post_event_evaluate), (Object) this.aX));
            F().setLines(1);
        }
        ImageView imageView = this.V;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    protected final View k() {
        return (View) this.aO.getValue();
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected NewFeedModel l() {
        NewFeedModel feedModel = super.l();
        feedModel.event_score = this.aW;
        feedModel.event_evaluate = this.aX;
        feedModel.activity_id = this.aV;
        feedModel.is_evaluate_activity = 1;
        Intrinsics.c(feedModel, "feedModel");
        return feedModel;
    }

    @Override // com.blued.community.ui.send.fragment.FeedAddPostBaseFragment
    protected boolean t() {
        return true;
    }
}
