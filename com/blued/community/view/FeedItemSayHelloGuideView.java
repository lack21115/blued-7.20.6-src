package com.blued.community.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.feed.manager.FeedMethods;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/FeedItemSayHelloGuideView.class */
public final class FeedItemSayHelloGuideView extends LinearLayout {
    private final int SAY_HELLO_GUIDE_COMMENT;
    private final int SAY_HELLO_GUIDE_LIKE;
    private final int SAY_HELLO_GUIDE_RECENT;
    private final int SAY_HELLO_GUIDE_ZAN;
    private View bgView;
    private ImageView ivIcon;
    private ShapeLinearLayout layoutContent;
    private BluedIngSelfFeed model;
    private TextView tvContent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedItemSayHelloGuideView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
        initView();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedItemSayHelloGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedItemSayHelloGuideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.SAY_HELLO_GUIDE_ZAN = 1;
        this.SAY_HELLO_GUIDE_RECENT = 2;
        this.SAY_HELLO_GUIDE_COMMENT = 3;
        this.SAY_HELLO_GUIDE_LIKE = 4;
        initView();
    }

    private final void initView() {
        View inflate = LinearLayout.inflate(getContext(), R.layout.item_feed_say_hello_guide, null);
        if (inflate == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        View findViewById = inflate.findViewById(R.id.item_feed_say_hello_bg);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        this.bgView = findViewById;
        ShapeLinearLayout findViewById2 = inflate.findViewById(R.id.item_feed_say_hello_guide_ly);
        if (findViewById2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.framework.view.shape.ShapeLinearLayout");
        }
        this.layoutContent = findViewById2;
        this.ivIcon = (ImageView) inflate.findViewById(R.id.item_feed_say_hello_guide_iv);
        this.tvContent = (TextView) inflate.findViewById(R.id.item_feed_say_hello_guide_tv);
        if (CommunityManager.a.a().s()) {
            View view = this.bgView;
            if (view != null) {
                view.setBackgroundResource(R.drawable.item_feed_say_hello_guide_bg_dark);
            }
        } else {
            View view2 = this.bgView;
            if (view2 != null) {
                view2.setBackgroundResource(R.drawable.item_feed_say_hello_guide_bg);
            }
        }
        inflate.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$FeedItemSayHelloGuideView$FGRlDU4gfgTH-BQLf8rcBQqz8uM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                FeedItemSayHelloGuideView.m2060initView$lambda0(FeedItemSayHelloGuideView.this, view3);
            }
        }));
        removeAllViews();
        addView(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m2060initView$lambda0(FeedItemSayHelloGuideView feedItemSayHelloGuideView, View view) {
        Intrinsics.e(feedItemSayHelloGuideView, "this$0");
        feedItemSayHelloGuideView.onClickContent();
    }

    private final void onClickContent() {
    }

    private final void refreshViews() {
        int i;
        String str;
        if (CommunityManager.a.a().s()) {
            View view = this.bgView;
            if (view != null) {
                view.setBackgroundResource(R.drawable.item_feed_say_hello_guide_bg_dark);
            }
        } else {
            View view2 = this.bgView;
            if (view2 != null) {
                view2.setBackgroundResource(R.drawable.item_feed_say_hello_guide_bg);
            }
        }
        BluedIngSelfFeed bluedIngSelfFeed = this.model;
        if (bluedIngSelfFeed == null) {
            return;
        }
        int i2 = R.color.syc_a;
        int i3 = bluedIngSelfFeed.tips;
        if (i3 == getSAY_HELLO_GUIDE_RECENT()) {
            i = R.drawable.item_feed_hello_guide_recent_icon;
            str = getResources().getString(R.string.feed_item_hello_guide_recent);
            Intrinsics.c(str, "resources.getString(R.st…_item_hello_guide_recent)");
        } else if (i3 == getSAY_HELLO_GUIDE_ZAN()) {
            i = R.drawable.item_feed_hello_guide_zan_icon;
            str = getResources().getString(R.string.feed_item_hello_guide_zan);
            Intrinsics.c(str, "resources.getString(R.st…eed_item_hello_guide_zan)");
        } else if (i3 == getSAY_HELLO_GUIDE_COMMENT()) {
            i = R.drawable.item_feed_hello_guide_comment_icon;
            str = getResources().getString(R.string.feed_item_hello_guide_commit);
            Intrinsics.c(str, "resources.getString(R.st…_item_hello_guide_commit)");
        } else {
            i = R.drawable.item_feed_hello_guide_like;
            str = bluedIngSelfFeed.tips_text;
            Intrinsics.c(str, "it.tips_text");
        }
        ImageLoader.a((IRequestHost) null, i).a(this.ivIcon);
        TextView textView = this.tvContent;
        if (textView == null) {
            return;
        }
        textView.setText(str);
        textView.setTextColor(getContext().getResources().getColor(i2));
        View view3 = this.bgView;
        if (view3 == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.width = ((int) textView.getPaint().measureText(str)) + FeedMethods.c(23);
        view3.setLayoutParams(marginLayoutParams);
    }

    public final int getSAY_HELLO_GUIDE_COMMENT() {
        return this.SAY_HELLO_GUIDE_COMMENT;
    }

    public final int getSAY_HELLO_GUIDE_LIKE() {
        return this.SAY_HELLO_GUIDE_LIKE;
    }

    public final int getSAY_HELLO_GUIDE_RECENT() {
        return this.SAY_HELLO_GUIDE_RECENT;
    }

    public final int getSAY_HELLO_GUIDE_ZAN() {
        return this.SAY_HELLO_GUIDE_ZAN;
    }

    public final void setFeedData(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            setVisibility(8);
        } else if (CommunityManager.a.a().c(bluedIngSelfFeed.feed_uid)) {
            setVisibility(8);
        } else {
            this.model = bluedIngSelfFeed;
            if (bluedIngSelfFeed.tips <= 0) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            refreshViews();
        }
    }
}
