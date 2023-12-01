package com.blued.community.ui.topic.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CenterAlignImageSpan;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedConstants;
import com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.StringUtils;
import com.blued.das.client.feed.FeedProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.Locale;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/topic/fragment/SuperTopicDetailFragment.class */
public class SuperTopicDetailFragment extends FeedTopicDetailBaseFragment implements View.OnClickListener {
    private CommonTopTitleNoTrans i;
    private View j;
    private ImageView k;
    private View l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private View q;

    public static void a(Context context, String str) {
        a(context, str, (String) null);
    }

    public static void a(Context context, String str, String str2) {
        if (!CommunityServiceManager.a().A()) {
            AppMethods.d(R.string.common_topic_service_upgraded);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("topic_id", str);
        TerminalActivity.a(bundle);
        if (CommunityServiceManager.a().D() == 1) {
            CommRouteUtil.a(context, str, (String) null, str2);
        } else {
            TerminalActivity.d(context, SuperTopicDetailFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        n();
    }

    public static void b(Context context, String str) {
        b(context, str, null);
    }

    public static void b(Context context, String str, String str2) {
        if (!CommunityServiceManager.a().A()) {
            AppMethods.d(R.string.common_topic_service_upgraded);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("topic_name", str);
        TerminalActivity.a(bundle);
        if (CommunityServiceManager.a().D() == 1) {
            CommRouteUtil.a(context, (String) null, str, str2);
        } else {
            TerminalActivity.d(context, SuperTopicDetailFragment.class, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        m();
    }

    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void a() {
        super.a();
    }

    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void b() {
        super.b();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_super_topic_detail_header, (ViewGroup) null);
        this.j = inflate;
        this.k = (ImageView) inflate.findViewById(R.id.img_bg);
        this.l = this.j.findViewById(R.id.bg_shadow);
        this.f20231c = (ImageView) this.j.findViewById(R.id.img_avatar);
        this.f20231c.setOnClickListener(this);
        this.m = (TextView) this.j.findViewById(R.id.tv_name);
        this.n = (TextView) this.j.findViewById(R.id.tv_visit);
        this.o = (TextView) this.j.findViewById(R.id.tv_join);
        this.p = (TextView) this.j.findViewById(R.id.tv_content);
        this.q = this.j.findViewById(R.id.view_line);
        this.b = (NoDataAndLoadFailView) this.j.findViewById(R.id.no_data_view);
        this.b.setTopSpace(DensityUtils.a(getContext(), 58.0f));
        this.b.setImageScale(0.7f);
        this.b.d();
        this.f20230a.addHeaderView(this.j);
    }

    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment
    public void c() {
        Drawable drawable;
        super.c();
        if (this.f != null) {
            boolean z = true;
            if (this.f.is_anonym == 1) {
                this.i.a();
                this.i.setCenterText(R.string.anonymous_super_topic);
            } else {
                this.i.setRightImg(R.drawable.icon_title_share);
            }
            if (this.f.is_anonym == 1) {
                this.l.setVisibility(8);
                ImageLoader.a(getFragmentActive(), R.drawable.topic_anonymous_bg).a(this.k);
            } else {
                this.l.setVisibility(this.f.is_topic == 1 ? 8 : 0);
                ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, this.f.avatar)).b(R.drawable.topic_default_bg).d(R.drawable.topic_default_bg).d().a(this.k);
            }
            SpannableString spannableString = new SpannableString(this.f.name + "  ");
            if (this.f.is_anonym == 1) {
                drawable = getResources().getDrawable(R.drawable.super_topic_anonymous_icon);
                drawable.setBounds(0, 0, AppMethods.a(!TextUtils.equals("en", Locale.getDefault().getLanguage()) ? 64 : 80), AppMethods.a(17));
            } else {
                drawable = getResources().getDrawable(R.drawable.super_topic_detail_icon);
                drawable.setBounds(0, 0, AppMethods.a(!TextUtils.equals("en", Locale.getDefault().getLanguage()) ? 47 : 44), AppMethods.a(17));
            }
            spannableString.setSpan(new CenterAlignImageSpan(drawable), spannableString.length() - 1, spannableString.length(), 33);
            this.m.setText(spannableString);
            this.m.setVisibility(0);
            this.n.setText(CommonStringUtils.b(this.f.visited_total) + getString(R.string.community_come_to_visit));
            if (!TextUtils.isEmpty(this.f.join_total)) {
                long parseLong = Long.parseLong(this.f.join_total);
                this.o.setText(CommonStringUtils.b(parseLong) + getString(R.string.participate));
            }
            if (TextUtils.isEmpty(this.f.description)) {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
            } else {
                this.p.setVisibility(0);
                this.q.setVisibility(0);
                this.p.setText(StringUtils.a(StringUtils.a(getString(R.string.super_topic_introduction) + this.f.description, DensityUtils.a(getContext(), 14.0f), 0), true, new boolean[0]));
            }
            FeedProtos.Event event = FeedProtos.Event.SUPER_TOPIC_DETAIL_SHOW;
            FeedProtos.DetailFrom detailFrom = FeedConstants.b;
            String str = this.f.super_did;
            if (this.f.is_anonym != 1) {
                z = false;
            }
            EventTrackFeed.a(event, detailFrom, str, z, false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != R.id.img_avatar || TextUtils.isEmpty(this.g)) {
            return;
        }
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.d = R.drawable.topic_default_header;
        loadOptions.b = R.drawable.topic_default_header;
        loadOptions.a(AppInfo.l >> 1, AppInfo.l >> 1);
        CommunityServiceManager.b().a(getContext(), new String[]{this.g}, 0, 14, loadOptions);
    }

    @Override // com.blued.community.ui.subject.fragment.FeedTopicDetailBaseFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.title);
        this.i = commonTopTitleNoTrans;
        commonTopTitleNoTrans.a();
        this.i.setCenterText(R.string.super_topic);
        this.i.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.topic.fragment.-$$Lambda$SuperTopicDetailFragment$9bi62Q2YMDr5ByySsMTF9ZaIugA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperTopicDetailFragment.this.b(view);
            }
        });
        this.i.setRightClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.topic.fragment.-$$Lambda$SuperTopicDetailFragment$vg8AM5se-761EZJw5-Nh7h_xVeY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuperTopicDetailFragment.this.a(view);
            }
        });
        this.h = 6.0f;
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_super_topic_detail;
    }
}
