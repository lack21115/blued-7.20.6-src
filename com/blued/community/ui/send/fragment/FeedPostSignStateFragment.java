package com.blued.community.ui.send.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.HoleRelativeLayout;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FragmentFeedPostSignStateBinding;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.blued.community.utils.CommEventBusUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.community.view.PhotoGridView;
import com.blued.das.client.feed.FeedProtos;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedPostSignStateFragment.class */
public class FeedPostSignStateFragment extends SimpleFragment {
    public CommonAdapter<FeedPostSignStateItem> c;
    private final ViewBindingProperty d;
    private boolean e;
    private int f;
    private FeedPostSignStateItem g;
    private FeedProtos.SourcePage h;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(FeedPostSignStateFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentFeedPostSignStateBinding;", 0))};
    public static final Companion a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/FeedPostSignStateFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i) {
            Intrinsics.e(context, "context");
            a(context, new Bundle(), i);
        }

        public final void a(Context context, Bundle bundle, int i) {
            Intrinsics.e(context, "context");
            Intrinsics.e(bundle, "bundle");
            if (CommunityServiceManager.a().b(context)) {
                return;
            }
            bundle.putInt("page_from", i);
            FeedProtos.SourcePage sourcePage = i != 1 ? i != 2 ? i != 3 ? i != 9 ? FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE : FeedProtos.SourcePage.GUIDE_PUNCH : FeedProtos.SourcePage.FEED_PERSONAL_FEED : FeedProtos.SourcePage.GUIDE_POP : FeedProtos.SourcePage.PUNCH_FEED_ALL_PUBLISH;
            TerminalActivity.d(context, FeedPostSignStateFragment.class, bundle);
            EventTrackFeed.a(FeedProtos.Event.PUNCH_FEED_STATUS_PAGE_SHOW, "", sourcePage, EventTrackFeed.a());
        }
    }

    public FeedPostSignStateFragment() {
        this.d = ((Fragment) this) instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<FeedPostSignStateFragment, FragmentFeedPostSignStateBinding>() { // from class: com.blued.community.ui.send.fragment.FeedPostSignStateFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentFeedPostSignStateBinding invoke(FeedPostSignStateFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentFeedPostSignStateBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<FeedPostSignStateFragment, FragmentFeedPostSignStateBinding>() { // from class: com.blued.community.ui.send.fragment.FeedPostSignStateFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentFeedPostSignStateBinding invoke(FeedPostSignStateFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentFeedPostSignStateBinding.a(fragment.requireView());
            }
        });
        this.h = FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        ImageView imageView;
        LinearLayout linearLayout;
        HoleRelativeLayout holeRelativeLayout;
        PhotoGridView photoGridView;
        int[] iArr = new int[2];
        int i2 = i / 3;
        int i3 = i % 3;
        LogUtils.c("line: " + i2 + ", column:" + i3);
        FragmentFeedPostSignStateBinding a2 = a();
        if (a2 != null && (holeRelativeLayout = a2.i) != null) {
            HoleRelativeLayout.RoundRect roundRect = new HoleRelativeLayout.RoundRect();
            FragmentFeedPostSignStateBinding a3 = a();
            if (a3 != null && (photoGridView = a3.d) != null) {
                photoGridView.getLocationOnScreen(iArr);
            }
            roundRect.c = FeedMethods.c(50);
            roundRect.d = FeedMethods.c(50);
            roundRect.a = FeedMethods.c(75) + (((AppInfo.l - FeedMethods.c(30)) * i3) / 3);
            int i4 = iArr[1];
            int i5 = i4;
            if (i4 < FeedMethods.c(10)) {
                i5 = FeedMethods.c(153);
            }
            roundRect.b = ((i5 - StatusBarHelper.a(getContext())) - FeedMethods.c(16)) + (FeedMethods.c(135) * i2);
            LogUtils.c("x: " + roundRect.a + ", y:" + roundRect.b);
            roundRect.f = roundRect.c / ((float) 2);
            roundRect.g = roundRect.f;
            roundRect.h = roundRect.f;
            roundRect.e = roundRect.f;
            holeRelativeLayout.a(roundRect);
        }
        FragmentFeedPostSignStateBinding a4 = a();
        if (a4 != null && (linearLayout = a4.h) != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = (iArr[1] - StatusBarHelper.a(getContext())) + FeedMethods.c(38) + (i2 * FeedMethods.c(135));
            linearLayout.setLayoutParams(marginLayoutParams);
        }
        FragmentFeedPostSignStateBinding a5 = a();
        if (a5 == null || (imageView = a5.j) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.leftMargin = FeedMethods.c(93) + ((i3 * (AppInfo.l - FeedMethods.c(30))) / 3);
        imageView.setLayoutParams(marginLayoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostSignStateFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedPostSignStateFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.e(this$0, "this$0");
        if (i < this$0.f) {
            FragmentFeedPostSignStateBinding a2 = this$0.a();
            LinearLayout linearLayout = a2 == null ? null : a2.g;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        FragmentFeedPostSignStateBinding a3 = this$0.a();
        LinearLayout linearLayout2 = a3 == null ? null : a3.g;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(FeedPostSignStateItem feedPostSignStateItem) {
        Context activity = getActivity();
        if (activity == null) {
            return;
        }
        if (c()) {
            this.args.putSerializable("selected_model", feedPostSignStateItem);
            this.args.putInt("page_from", this.args.getInt("page_from"));
            FeedPostSignBaseFragment.a(activity, this.args);
        }
        CommEventBusUtil.a.a(feedPostSignStateItem);
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            return;
        }
        activity2.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedPostSignStateFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentFeedPostSignStateBinding a2 = this$0.a();
        HoleRelativeLayout holeRelativeLayout = a2 == null ? null : a2.i;
        if (holeRelativeLayout == null) {
            return;
        }
        holeRelativeLayout.setVisibility(8);
    }

    private final void f() {
        a(new FeedPostSignStateFragment$createAdapter$1(this, R.layout.item_feed_post_sign_state));
        FragmentFeedPostSignStateBinding a2 = a();
        PhotoGridView photoGridView = a2 == null ? null : a2.d;
        if (photoGridView == null) {
            return;
        }
        photoGridView.setAdapter(b());
    }

    private final void g() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    public final FragmentFeedPostSignStateBinding a() {
        return (FragmentFeedPostSignStateBinding) this.d.b(this, b[0]);
    }

    public final void a(CommonAdapter<FeedPostSignStateItem> commonAdapter) {
        Intrinsics.e(commonAdapter, "<set-?>");
        this.c = commonAdapter;
    }

    public final CommonAdapter<FeedPostSignStateItem> b() {
        CommonAdapter<FeedPostSignStateItem> commonAdapter = this.c;
        if (commonAdapter != null) {
            return commonAdapter;
        }
        Intrinsics.c("adapter");
        return null;
    }

    public final boolean c() {
        return this.e;
    }

    public final FeedPostSignStateItem d() {
        return this.g;
    }

    public final FeedProtos.SourcePage e() {
        return this.h;
    }

    public void onInitView() {
        TextView textView;
        AppBarLayout appBarLayout;
        ImageView imageView;
        FragmentFeedPostSignStateBinding a2 = a();
        if (a2 != null && (imageView = a2.f) != null) {
            imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignStateFragment$iuAhrv5hwUadNLLjraN2FK6wFqM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedPostSignStateFragment.a(FeedPostSignStateFragment.this, view);
                }
            }));
        }
        f();
        this.e = this.g == null;
        this.f = DisplayUtil.a(AppInfo.d(), -83.0f);
        FragmentFeedPostSignStateBinding a3 = a();
        if (a3 != null && (appBarLayout = a3.a) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignStateFragment$TcywsV6DiDWRox24SxrkVv_ljqk
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    FeedPostSignStateFragment.a(FeedPostSignStateFragment.this, appBarLayout2, i);
                }
            });
        }
        FragmentFeedPostSignStateBinding a4 = a();
        if (a4 == null || (textView = a4.c) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.send.fragment.-$$Lambda$FeedPostSignStateFragment$J3wSdm4WnSXqLH33cVsLrfS95T8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedPostSignStateFragment.b(FeedPostSignStateFragment.this, view);
            }
        });
    }

    public void onLoadData() {
        super.onLoadData();
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        FeedHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<FeedPostSignStateItem>>(fragmentActive) { // from class: com.blued.community.ui.send.fragment.FeedPostSignStateFragment$onLoadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<FeedPostSignStateItem> bluedEntityA) {
                int i;
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    FeedPostSignStateFragment.this.b().a(bluedEntityA.data);
                    if (CommunityServiceManager.a().P() && CommunityPreferences.aj()) {
                        Iterator<FeedPostSignStateItem> it = bluedEntityA.data.iterator();
                        int i2 = 0;
                        while (true) {
                            i = i2;
                            if (!it.hasNext() || it.next().is_classify() == 1) {
                                break;
                            }
                            i2 = i + 1;
                        }
                        if (i < 0 || i >= bluedEntityA.data.size()) {
                            return;
                        }
                        FeedPostSignStateFragment.this.a(i);
                        FragmentFeedPostSignStateBinding a2 = FeedPostSignStateFragment.this.a();
                        HoleRelativeLayout holeRelativeLayout = a2 == null ? null : a2.i;
                        if (holeRelativeLayout != null) {
                            holeRelativeLayout.setVisibility(0);
                        }
                        CommunityPreferences.ak();
                    }
                }
            }
        }, getFragmentActive());
    }

    public void onParseArguments() {
        super.onParseArguments();
        this.g = (FeedPostSignStateItem) this.args.getSerializable("selected_model");
        int i = this.args.getInt("page_from");
        if (i == 1) {
            this.h = FeedProtos.SourcePage.PUNCH_FEED_ALL_PUBLISH;
        } else if (i == 2) {
            this.h = FeedProtos.SourcePage.GUIDE_POP;
        } else if (i == 3) {
            this.h = FeedProtos.SourcePage.FEED_PERSONAL_FEED;
        } else if (i != 9) {
        } else {
            this.h = FeedProtos.SourcePage.GUIDE_PUNCH;
        }
    }

    public int onSetRootViewId() {
        return R.layout.fragment_feed_post_sign_state;
    }
}
