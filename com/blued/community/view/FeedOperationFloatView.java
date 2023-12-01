package com.blued.community.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.manager.CommunityManager;
import com.blued.community.model.FeedOperationFloatContentModel;
import com.blued.community.model.FeedOperationFloatModel;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.utils.CommRouteUtil;
import com.blued.community.utils.CommunityPreferences;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/FeedOperationFloatView.class */
public final class FeedOperationFloatView extends FrameLayout {
    private ImageView btnClose;
    private ShapeTextView btnConfirm;
    private int from;
    private ImageView ivIcon;
    private View layoutContent;
    private FeedOperationFloatModel model;
    private TextView tvTitle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedOperationFloatView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
        initView();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedOperationFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
        initView();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedOperationFloatView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        initView();
    }

    private final void initView() {
        View inflate = FrameLayout.inflate(getContext(), R.layout.feed_float_operation_layout, null);
        if (inflate == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        FrameLayout frameLayout = (FrameLayout) inflate;
        this.layoutContent = frameLayout.findViewById(R.id.feed_float_content_layout);
        this.ivIcon = (ImageView) frameLayout.findViewById(R.id.feed_float_op_img);
        this.tvTitle = (TextView) frameLayout.findViewById(R.id.feed_float_op_title);
        this.btnConfirm = (ShapeTextView) frameLayout.findViewById(R.id.feed_float_op_btn);
        this.btnClose = (ImageView) frameLayout.findViewById(R.id.feed_float_op_close);
        refreshDarkMode();
        frameLayout.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$FeedOperationFloatView$XiDZR2RhTC1qdAv6MQuwpMDXOoI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedOperationFloatView.m5149initView$lambda0(FeedOperationFloatView.this, view);
            }
        }));
        ShapeTextView shapeTextView = this.btnConfirm;
        if (shapeTextView != null) {
            shapeTextView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$FeedOperationFloatView$HnQt-gcJarCotoHbA_9bE2DiWoE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedOperationFloatView.m5150initView$lambda1(FeedOperationFloatView.this, view);
                }
            }));
        }
        ImageView imageView = this.btnClose;
        if (imageView != null) {
            imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.community.view.-$$Lambda$FeedOperationFloatView$3F2JJMTmuwpJenD1g86y7KJgWX0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedOperationFloatView.m5151initView$lambda2(FeedOperationFloatView.this, view);
                }
            }));
        }
        addView(frameLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m5149initView$lambda0(FeedOperationFloatView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.onClickContent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m5150initView$lambda1(FeedOperationFloatView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.onClickConfirm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initView$lambda-2  reason: not valid java name */
    public static final void m5151initView$lambda2(FeedOperationFloatView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.onClickClose();
    }

    private final void onClickClose() {
        setVisibility(8);
        FeedOperationFloatModel feedOperationFloatModel = this.model;
        if (feedOperationFloatModel != null) {
            if (this.from == 2) {
                CommunityManager.f19086a.a().a(feedOperationFloatModel.getP_id());
                EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_CLOSE_CLICK, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND);
            } else {
                CommunityManager.f19086a.a().b(feedOperationFloatModel.getP_id());
                EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_CLOSE_CLICK, FeedProtos.SourcePage.FEED_PLAZA_NEARBY);
            }
        }
        this.model = null;
    }

    private final void onClickConfirm() {
        FeedOperationFloatModel feedOperationFloatModel = this.model;
        if (feedOperationFloatModel != null) {
            if (feedOperationFloatModel.getTarget_path() == 1) {
                CommRouteUtil.a(getContext());
            } else if (feedOperationFloatModel.getTarget_path() == 2) {
                CommunityServiceManager.b().a(getContext(), feedOperationFloatModel.getTarget_link());
            }
            FeedHttpUtils.a(this.from, 2, feedOperationFloatModel.getP_id(), (IRequestHost) null);
        }
        setVisibility(8);
        if (this.from == 2) {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_INVOLVE_CLICK, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND);
        } else {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_INVOLVE_CLICK, FeedProtos.SourcePage.FEED_PLAZA_NEARBY);
        }
        CommunityPreferences.a("RecommendDrawDepthBubbleShowCount", 0);
    }

    private final void onClickContent() {
    }

    private final void refreshViews() {
        FeedOperationFloatContentModel push_content;
        FeedOperationFloatModel feedOperationFloatModel = this.model;
        if (feedOperationFloatModel == null || (push_content = feedOperationFloatModel.getPush_content()) == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, push_content.getImg()).b(R.drawable.feed_float_op_default).a(this.ivIcon);
        TextView textView = this.tvTitle;
        if (textView != null) {
            textView.setText(push_content.getTitle());
        }
        if (TextUtils.isEmpty(push_content.getButton())) {
            push_content.setButton("参与话题");
        }
        ShapeTextView shapeTextView = this.btnConfirm;
        if (shapeTextView == null) {
            return;
        }
        shapeTextView.setText(push_content.getButton());
    }

    public final void refreshDarkMode() {
        if (CommunityManager.f19086a.a().s()) {
            View view = this.layoutContent;
            if (view == null) {
                return;
            }
            view.setBackgroundResource(R.drawable.feed_float_op_bg_dark);
            return;
        }
        View view2 = this.layoutContent;
        if (view2 == null) {
            return;
        }
        view2.setBackgroundResource(R.drawable.feed_float_op_bg);
    }

    public final void setFrom(int i) {
        this.from = i;
    }

    public final void setOperationData(FeedOperationFloatModel feedOperationFloatModel) {
        if (feedOperationFloatModel == null) {
            setVisibility(8);
            this.model = null;
            return;
        }
        setVisibility(0);
        this.model = feedOperationFloatModel;
        refreshViews();
        if (this.from == 2) {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_SHOW, FeedProtos.SourcePage.FEED_PLAZA_RECOMMEND);
        } else {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_GUIDE_SHOW, FeedProtos.SourcePage.FEED_PLAZA_NEARBY);
        }
    }

    public final void setVisibleByParent(boolean z) {
        setVisibility((!z || this.model == null) ? 8 : 0);
    }
}
