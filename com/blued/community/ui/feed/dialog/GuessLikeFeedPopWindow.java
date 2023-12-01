package com.blued.community.ui.feed.dialog;

import android.content.Context;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.databinding.FeedGuessLikeDialogBinding;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import com.blued.community.track.EventTrackFeed;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/community/ui/feed/dialog/GuessLikeFeedPopWindow.class */
public final class GuessLikeFeedPopWindow extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f19735c = {Reflection.a(new PropertyReference1Impl(GuessLikeFeedPopWindow.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FeedGuessLikeDialogBinding;", 0))};
    public GuessLikeDialogConfirmAndCancelListener d;
    private final Context e;
    private final IRequestHost f;
    private final ViewBindingProperty g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuessLikeFeedPopWindow(Context mContext, IRequestHost fragmentActive) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.e = mContext;
        this.f = fragmentActive;
        this.g = new CustomViewBindingProperty(new Function1<GuessLikeFeedPopWindow, FeedGuessLikeDialogBinding>() { // from class: com.blued.community.ui.feed.dialog.GuessLikeFeedPopWindow$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FeedGuessLikeDialogBinding invoke(GuessLikeFeedPopWindow popView) {
                Intrinsics.e(popView, "popView");
                return FeedGuessLikeDialogBinding.a(popView.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GuessLikeFeedPopWindow this$0, BluedIngSelfFeed feed, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(feed, "$feed");
        this$0.p();
        EventTrackFeed.b(FeedProtos.Event.FEED_RECOMMEND_POP_USER_CLICK, feed.feed_id, feed.feed_uid);
        CommunityServiceManager.b().a(this$0.e, feed.feed_uid, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuessLikeFeedPopWindow this$0, BluedIngSelfFeed feed, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(feed, "$feed");
        if (this$0.getClickConfirmAndCancelListener() != null) {
            this$0.getClickConfirmAndCancelListener().a(feed);
        }
        EventTrackFeed.b(FeedProtos.Event.FEED_RECOMMEND_POP_FEED_CLICK, feed.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuessLikeFeedPopWindow this$0, BluedIngSelfFeed feed, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(feed, "$feed");
        if (this$0.getClickConfirmAndCancelListener() != null) {
            this$0.getClickConfirmAndCancelListener().a(feed);
        }
        EventTrackFeed.b(FeedProtos.Event.FEED_RECOMMEND_POP_FEED_CLICK, feed.feed_id);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuessLikeFeedPopWindow this$0, BluedIngSelfFeed feed, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(feed, "$feed");
        if (this$0.getClickConfirmAndCancelListener() != null) {
            this$0.getClickConfirmAndCancelListener().a(feed);
        }
        EventTrackFeed.b(FeedProtos.Event.FEED_RECOMMEND_POP_LOOK_CLICK, feed.feed_id);
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuessLikeFeedPopWindow this$0, BluedIngSelfFeed feed, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(feed, "$feed");
        if (this$0.getClickConfirmAndCancelListener() != null) {
            this$0.getClickConfirmAndCancelListener().a();
        }
        EventTrackFeed.b(FeedProtos.Event.FEED_RECOMMEND_POP_QUIT_CLICK, feed.feed_id);
        this$0.p();
    }

    private final void getGuessLikeData() {
        final IRequestHost iRequestHost = this.f;
        FeedHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(iRequestHost) { // from class: com.blued.community.ui.feed.dialog.GuessLikeFeedPopWindow$getGuessLikeData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.getSingleData() != null) {
                    GuessLikeFeedPopWindow guessLikeFeedPopWindow = GuessLikeFeedPopWindow.this;
                    BluedIngSelfFeed singleData = parseData.getSingleData();
                    Intrinsics.c(singleData, "parseData.singleData");
                    guessLikeFeedPopWindow.setDataToView(singleData);
                }
            }
        }, this.f);
    }

    private final FeedGuessLikeDialogBinding getViewBinding() {
        return (FeedGuessLikeDialogBinding) this.g.b(this, f19735c[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        getGuessLikeData();
    }

    public final GuessLikeDialogConfirmAndCancelListener getClickConfirmAndCancelListener() {
        GuessLikeDialogConfirmAndCancelListener guessLikeDialogConfirmAndCancelListener = this.d;
        if (guessLikeDialogConfirmAndCancelListener != null) {
            return guessLikeDialogConfirmAndCancelListener;
        }
        Intrinsics.c("clickConfirmAndCancelListener");
        return null;
    }

    public final IRequestHost getFragmentActive() {
        return this.f;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.feed_guess_like_dialog;
    }

    public final Context getMContext() {
        return this.e;
    }

    public final void setClickConfirmAndCancelListener(GuessLikeDialogConfirmAndCancelListener guessLikeDialogConfirmAndCancelListener) {
        Intrinsics.e(guessLikeDialogConfirmAndCancelListener, "<set-?>");
        this.d = guessLikeDialogConfirmAndCancelListener;
    }

    public final void setClickListener(GuessLikeDialogConfirmAndCancelListener clickListener) {
        Intrinsics.e(clickListener, "clickListener");
        setClickConfirmAndCancelListener(clickListener);
    }

    public final void setDataToView(final BluedIngSelfFeed feed) {
        Intrinsics.e(feed, "feed");
        FeedGuessLikeDialogBinding viewBinding = getViewBinding();
        if (viewBinding != null) {
            viewBinding.h.setText(new FeedParse(getMContext(), feed, 2).getFeedContent());
            String[] strArr = feed.feed_pics;
            boolean z = true;
            if (strArr != null) {
                z = strArr.length == 0;
            }
            if (z) {
                viewBinding.b.setVisibility(8);
            } else {
                viewBinding.b.setVisibility(0);
                ImageLoader.a(getFragmentActive(), feed.feed_pics[0]).a(6.0f).a(viewBinding.b);
            }
            viewBinding.d.setText(feed.user_name);
            ImageLoader.a(getFragmentActive(), feed.user_avatar).c().a(viewBinding.f18819a);
            viewBinding.f18820c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$GuessLikeFeedPopWindow$wkbmx9yeb_RnVGBkkdFf1egpa9M
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuessLikeFeedPopWindow.a(GuessLikeFeedPopWindow.this, feed, view);
                }
            });
            viewBinding.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$GuessLikeFeedPopWindow$8r5DT5RahGnh7z9hi8CGjpoAo2Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuessLikeFeedPopWindow.b(GuessLikeFeedPopWindow.this, feed, view);
                }
            });
            viewBinding.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$GuessLikeFeedPopWindow$yG6KVGfa5rY3ZDCKbSaQqjXtS2k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuessLikeFeedPopWindow.c(GuessLikeFeedPopWindow.this, feed, view);
                }
            });
            viewBinding.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$GuessLikeFeedPopWindow$oOde6mXCWg_b6lX7ZuvdmbYve3s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuessLikeFeedPopWindow.d(GuessLikeFeedPopWindow.this, feed, view);
                }
            });
            viewBinding.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.feed.dialog.-$$Lambda$GuessLikeFeedPopWindow$8qDuOJhy4LqYsl0-wiqwpFZTJW0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuessLikeFeedPopWindow.e(GuessLikeFeedPopWindow.this, feed, view);
                }
            });
        }
        EventTrackFeed.b(FeedProtos.Event.FEED_RECOMMEND_POP_SHOW, feed.feed_id);
    }
}
