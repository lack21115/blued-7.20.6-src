package com.blued.community.ui.feed.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.fragment.BaseListFragment;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.community.R;
import com.blued.community.http.CommunityHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.event.model.EventMemberModel;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignInteractiveListFragment.class */
public final class SignInteractiveListFragment extends BaseListFragment<EventMemberModel, BluedEntityBaseExtra> {
    public static final Companion g = new Companion(null);
    private String h = "";
    private BluedIngSelfFeed i;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/fragment/SignInteractiveListFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String feedId, BluedIngSelfFeed feed) {
            Intrinsics.e(feedId, "feedId");
            Intrinsics.e(feed, "feed");
            Bundle bundle = new Bundle();
            bundle.putString("feed_id", feedId);
            bundle.putSerializable("feed", feed);
            TerminalActivity.d(context, SignInteractiveListFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SignInteractiveListFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public CommonAdapter<EventMemberModel> a() {
        return new SignInteractiveListFragment$initAdapter$1(this, R.layout.item_sign_interactive);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.blued.community.ui.feed.fragment.SignInteractiveListFragment$getHttpResDataType$1] */
    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public Type b() {
        Type type = new TypeToken<BluedEntity<EventMemberModel, BluedEntityBaseExtra>>() { // from class: com.blued.community.ui.feed.fragment.SignInteractiveListFragment$getHttpResDataType$1
        }.getType();
        Intrinsics.c(type, "object : TypeToken<Blued…tityBaseExtra>>() {}.type");
        return type;
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public String c() {
        return CommunityHttpUtils.a() + "/ticktocks/feed/double_click_list?feed_id=" + this.h;
    }

    @Override // com.blued.android.module.common.fragment.BaseListFragment
    public void onInitView() {
        super.onInitView();
        CommonTopTitleNoTrans commonTopTitleNoTrans = this.a;
        if (commonTopTitleNoTrans != null) {
            commonTopTitleNoTrans.f();
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans2 = this.a;
        if (commonTopTitleNoTrans2 != null) {
            commonTopTitleNoTrans2.setCenterText(R.string.sign_interactive_title);
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans3 = this.a;
        if (commonTopTitleNoTrans3 != null) {
            commonTopTitleNoTrans3.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.fragment.-$$Lambda$SignInteractiveListFragment$aFiJXuwSA9Q8EoJNj1J1N0kTZhY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SignInteractiveListFragment.a(SignInteractiveListFragment.this, view);
                }
            });
        }
        this.c.setDividerHeight(0);
        this.c.setHeaderDividersEnabled(false);
        this.c.setFooterDividersEnabled(false);
    }

    public void onParseArguments() {
        super.onParseArguments();
        this.h = String.valueOf(this.args.getString("feed_id"));
        this.i = (BluedIngSelfFeed) this.args.getSerializable("feed");
    }
}
