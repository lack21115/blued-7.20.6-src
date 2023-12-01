package com.soft.blued.ui.user.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.adapter.RecommendUserAdapter;
import com.soft.blued.ui.user.fragment.RecommendUserMoreFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/PopUserRecommend.class */
public final class PopUserRecommend extends BottomPopupView {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final List<UserFindResult> f20561c;
    private boolean d;
    private final LogData e;
    private final IRequestHost f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PopUserRecommend(Context context, String str, List<? extends UserFindResult> list, boolean z, LogData logData, IRequestHost iRequestHost) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(str, "uid");
        Intrinsics.e(list, "dataList");
        Intrinsics.e(logData, "logData");
        Intrinsics.e(iRequestHost, "requestHost");
        this.b = str;
        this.f20561c = list;
        this.d = z;
        this.e = logData;
        this.f = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopUserRecommend popUserRecommend, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popUserRecommend, "this$0");
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_SAME_POP_MORE_CLICK, "");
        RecommendUserMoreFragment.Companion companion = RecommendUserMoreFragment.b;
        Context context = popUserRecommend.getContext();
        Intrinsics.c(context, "context");
        companion.a(context, popUserRecommend.b, popUserRecommend.e);
    }

    public void b() {
        super.b();
        this.e.userFrom = "recommend_same";
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_SAME_POP_SHOW, this.b);
        TextView textView = (TextView) findViewById(R.id.tv_recommend_more);
        if (this.d) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$PopUserRecommend$50VLSp3GtoK7BxJvBqXjzdrz5V8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopUserRecommend.a(PopUserRecommend.this, view);
                }
            });
        } else {
            textView.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recommend_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecommendUserAdapter recommendUserAdapter = new RecommendUserAdapter(this.f, this.e);
        recommendUserAdapter.setNewData(getDataList());
        recyclerView.setAdapter(recommendUserAdapter);
    }

    public final List<UserFindResult> getDataList() {
        return this.f20561c;
    }

    public final boolean getHasMore() {
        return this.d;
    }

    public int getImplLayoutId() {
        return R.layout.pop_user_recommend;
    }

    public final LogData getLogData() {
        return this.e;
    }

    public final IRequestHost getRequestHost() {
        return this.f;
    }

    public final String getUid() {
        return this.b;
    }

    public final void setHasMore(boolean z) {
        this.d = z;
    }
}
