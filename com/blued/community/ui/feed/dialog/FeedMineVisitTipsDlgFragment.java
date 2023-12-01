package com.blued.community.ui.feed.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.community.R;
import com.blued.community.databinding.FragmentFeedMineVisitTipsBinding;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.common.CommFullScreenDialog;
import com.blued.community.ui.feed.manager.FeedMethods;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/FeedMineVisitTipsDlgFragment.class */
public final class FeedMineVisitTipsDlgFragment extends CommFullScreenDialog {
    private final Context a;
    private final int b;
    private final int c;
    private final IRequestHost d;
    private FragmentFeedMineVisitTipsBinding e;
    private int f;
    private boolean g;

    public FeedMineVisitTipsDlgFragment(Context mContext, int i, int i2, IRequestHost fragmentActive) {
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.a = mContext;
        this.b = i;
        this.c = i2;
        this.d = fragmentActive;
        this.g = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FeedMineVisitTipsDlgFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    private final void k() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        FrameLayout frameLayout;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        FrameLayout frameLayout2;
        if (this.c > FeedMethods.c(164) + StatusBarHelper.a(AppInfo.d())) {
            this.g = true;
            this.f = this.c - FeedMethods.c(96);
        } else {
            this.g = false;
            this.f = this.c + FeedMethods.c(4);
        }
        FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding = this.e;
        if (fragmentFeedMineVisitTipsBinding != null && (frameLayout2 = fragmentFeedMineVisitTipsBinding.d) != null) {
            if (this.g) {
                FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding2 = this.e;
                ImageView imageView7 = fragmentFeedMineVisitTipsBinding2 == null ? null : fragmentFeedMineVisitTipsBinding2.b;
                if (imageView7 != null) {
                    imageView7.setVisibility(8);
                }
                FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding3 = this.e;
                ImageView imageView8 = fragmentFeedMineVisitTipsBinding3 == null ? null : fragmentFeedMineVisitTipsBinding3.a;
                if (imageView8 != null) {
                    imageView8.setVisibility(0);
                }
            } else {
                FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding4 = this.e;
                ImageView imageView9 = fragmentFeedMineVisitTipsBinding4 == null ? null : fragmentFeedMineVisitTipsBinding4.b;
                if (imageView9 != null) {
                    imageView9.setVisibility(0);
                }
                FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding5 = this.e;
                ImageView imageView10 = fragmentFeedMineVisitTipsBinding5 == null ? null : fragmentFeedMineVisitTipsBinding5.a;
                if (imageView10 != null) {
                    imageView10.setVisibility(8);
                }
            }
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = this.f;
            layoutParams2.leftMargin = j() - FeedMethods.c(99);
            frameLayout2.setLayoutParams(layoutParams2);
        }
        if (CommunityManager.a.a().s()) {
            FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding6 = this.e;
            if (fragmentFeedMineVisitTipsBinding6 != null && (imageView6 = fragmentFeedMineVisitTipsBinding6.c) != null) {
                imageView6.setImageResource(R.drawable.feed_mine_visit_tips_bg_dark);
            }
            FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding7 = this.e;
            if (fragmentFeedMineVisitTipsBinding7 != null && (imageView5 = fragmentFeedMineVisitTipsBinding7.b) != null) {
                imageView5.setImageResource(R.drawable.feed_mine_visit_tips_arrow_up_dark);
            }
            FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding8 = this.e;
            if (fragmentFeedMineVisitTipsBinding8 != null && (imageView4 = fragmentFeedMineVisitTipsBinding8.a) != null) {
                imageView4.setImageResource(R.drawable.feed_mine_visit_tips_arrow_down_dark);
            }
        } else {
            FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding9 = this.e;
            if (fragmentFeedMineVisitTipsBinding9 != null && (imageView3 = fragmentFeedMineVisitTipsBinding9.c) != null) {
                imageView3.setImageResource(R.drawable.feed_mine_visit_tips_bg);
            }
            FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding10 = this.e;
            if (fragmentFeedMineVisitTipsBinding10 != null && (imageView2 = fragmentFeedMineVisitTipsBinding10.b) != null) {
                imageView2.setImageResource(R.drawable.feed_mine_visit_tips_arrow_up);
            }
            FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding11 = this.e;
            if (fragmentFeedMineVisitTipsBinding11 != null && (imageView = fragmentFeedMineVisitTipsBinding11.a) != null) {
                imageView.setImageResource(R.drawable.feed_mine_visit_tips_arrow_down);
            }
        }
        FragmentFeedMineVisitTipsBinding fragmentFeedMineVisitTipsBinding12 = this.e;
        if (fragmentFeedMineVisitTipsBinding12 == null || (frameLayout = fragmentFeedMineVisitTipsBinding12.e) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$FeedMineVisitTipsDlgFragment$MeIPbSUo1P9KRfnmPlhPzq0tC6Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedMineVisitTipsDlgFragment.a(FeedMineVisitTipsDlgFragment.this, view);
            }
        });
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog
    public int e() {
        return R.layout.fragment_feed_mine_visit_tips;
    }

    public final int j() {
        return this.b;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, viewGroup, bundle);
        this.e = FragmentFeedMineVisitTipsBinding.a(onCreateView);
        return onCreateView;
    }

    @Override // com.blued.community.ui.common.CommFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        k();
    }
}
