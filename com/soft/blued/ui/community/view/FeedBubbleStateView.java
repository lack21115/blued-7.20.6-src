package com.soft.blued.ui.community.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.community.manager.CommunityManager;
import com.blued.community.ui.feed.manager.FeedMethods;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/community/view/FeedBubbleStateView.class */
public final class FeedBubbleStateView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private FrameLayout f29799a;
    private ShapeLinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f29800c;
    private TextView d;
    private FeedPostSignStateItem e;
    private int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleStateView(Context context) {
        super(context);
        Intrinsics.a(context);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.a(context);
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBubbleStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.a(context);
        a();
    }

    private final void a() {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.feed_bubble_state_view_layout, (ViewGroup) null);
        this.f29799a = frameLayout;
        if (frameLayout == null) {
            return;
        }
        this.b = (ShapeLinearLayout) frameLayout.findViewById(R.id.feed_bubble_state_content);
        this.f29800c = (ImageView) frameLayout.findViewById(R.id.feed_bubble_state_iv);
        this.d = (TextView) frameLayout.findViewById(R.id.feed_bubble_state_tv);
        b();
        addView(frameLayout);
    }

    private final void b() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        ShapeLinearLayout shapeLinearLayout = this.b;
        ShapeModel shapeModel = shapeLinearLayout == null ? null : shapeLinearLayout.getShapeModel();
        ShapeModel shapeModel2 = shapeModel;
        if (shapeModel == null) {
            shapeModel2 = new ShapeModel();
        }
        CommunityManager.f19086a.a().s();
        shapeModel2.k = Color.parseColor("#E5E5E5");
        ShapeLinearLayout shapeLinearLayout2 = this.b;
        if (shapeLinearLayout2 != null) {
            shapeLinearLayout2.setShapeModel(shapeModel2);
        }
        int i = this.f;
        str = "#998EBA";
        boolean z = true;
        if (i == 2) {
            FeedPostSignStateItem feedPostSignStateItem = this.e;
            if (feedPostSignStateItem == null || feedPostSignStateItem.is_bubble_tt_click() != 1) {
                z = false;
            }
            if (z) {
                str4 = CommunityManager.f19086a.a().s() ? "#2C2C2C" : "#E5E5E5";
                String str6 = CommunityManager.f19086a.a().s() ? "#2C2C2C" : "#E5E5E5";
                ImageView imageView = this.f29800c;
                if (imageView != null) {
                    imageView.setAlpha(0.7f);
                }
                str3 = str6;
                str2 = "#999999";
            } else {
                str5 = CommunityManager.f19086a.a().s() ? "#237056FF" : "#327056FF";
                str3 = CommunityManager.f19086a.a().s() ? "#233071FE" : "#323071FE";
                str = CommunityManager.f19086a.a().s() ? "#998EBA" : "#766A9F";
                ImageView imageView2 = this.f29800c;
                if (imageView2 != null) {
                    imageView2.setAlpha(1.0f);
                }
                String str7 = str;
                str4 = str5;
                str2 = str7;
            }
        } else if (i == 1) {
            str5 = CommunityManager.f19086a.a().s() ? "#237056FF" : "#327056FF";
            str3 = CommunityManager.f19086a.a().s() ? "#233071FE" : "#323071FE";
            if (!CommunityManager.f19086a.a().s()) {
                str = "#766A9F";
            }
            String str72 = str;
            str4 = str5;
            str2 = str72;
        } else {
            str2 = "#FFFFFF";
            str3 = "#4C000000";
            str4 = "#4C000000";
        }
        shapeModel2.t = Color.parseColor(str4);
        shapeModel2.v = Color.parseColor(str3);
        ShapeLinearLayout shapeLinearLayout3 = this.b;
        if (shapeLinearLayout3 != null) {
            shapeLinearLayout3.setShapeModel(shapeModel2);
        }
        TextView textView = this.d;
        if (textView == null) {
            return;
        }
        textView.setTextColor(Color.parseColor(str2));
    }

    public final void setBubbleState(FeedPostSignStateItem feedPostSignStateItem) {
        this.e = feedPostSignStateItem;
        if (feedPostSignStateItem == null) {
            setVisibility(8);
            return;
        }
        if (feedPostSignStateItem != null) {
            ImageLoader.a((IRequestHost) null, feedPostSignStateItem.getIcon()).c().a(this.f29800c);
            TextView textView = this.d;
            if (textView != null) {
                textView.setText(feedPostSignStateItem.getName());
            }
        }
        b();
        setVisibility(0);
    }

    public final void setBusinessType(int i) {
        this.f = i;
        if (i == 0) {
            ShapeLinearLayout shapeLinearLayout = this.b;
            ViewGroup.LayoutParams layoutParams = shapeLinearLayout == null ? null : shapeLinearLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = FeedMethods.c(15);
            }
            ShapeLinearLayout shapeLinearLayout2 = this.b;
            if (shapeLinearLayout2 != null) {
                shapeLinearLayout2.setLayoutParams(layoutParams);
            }
            TextView textView = this.d;
            if (textView != null) {
                textView.setTextSize(9.0f);
            }
        }
        b();
    }
}
