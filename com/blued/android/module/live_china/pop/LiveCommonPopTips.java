package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.model.LiveRoomTipsModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.TriangleView;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveCommonPopTips.class */
public final class LiveCommonPopTips extends AttachPopupView {
    private boolean t;
    private LiveRoomTipsModel u;
    private boolean v;
    private Runnable w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommonPopTips(Context context, LiveRoomTipsModel itemModel) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(itemModel, "itemModel");
        this.w = new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveCommonPopTips$dghik-lymWHqz8bvPJ-SToUL87U
            @Override // java.lang.Runnable
            public final void run() {
                LiveCommonPopTips.a(LiveCommonPopTips.this);
            }
        };
        this.u = itemModel;
    }

    private final void A() {
        boolean z;
        this.v = false;
        LiveProtos.Event event = LiveProtos.Event.LIVE_TIPS_CLICK;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        LiveRoomTipsModel liveRoomTipsModel = this.u;
        EventTrackLive.w(event, e, g, String.valueOf(liveRoomTipsModel == null ? null : Integer.valueOf(liveRoomTipsModel.getId())));
        LiveRoomTipsModel liveRoomTipsModel2 = this.u;
        if (liveRoomTipsModel2 != null && liveRoomTipsModel2.getLinkType() == 1) {
            LiveRoomTipsModel liveRoomTipsModel3 = this.u;
            if (!TextUtils.isEmpty(liveRoomTipsModel3 == null ? null : liveRoomTipsModel3.getLink())) {
                LiveSetDataObserver a = LiveSetDataObserver.a();
                LiveRoomTipsModel liveRoomTipsModel4 = this.u;
                a.b(liveRoomTipsModel4 == null ? null : liveRoomTipsModel4.getLink(), 25);
            }
        } else {
            LiveRoomTipsModel liveRoomTipsModel5 = this.u;
            if (liveRoomTipsModel5 != null && liveRoomTipsModel5.getLinkType() == 2) {
                LiveRoomTipsModel liveRoomTipsModel6 = this.u;
                if (!TextUtils.isEmpty(liveRoomTipsModel6 == null ? null : liveRoomTipsModel6.getLink())) {
                    LiveSetDataObserver a2 = LiveSetDataObserver.a();
                    LiveRoomTipsModel liveRoomTipsModel7 = this.u;
                    a2.c(liveRoomTipsModel7 == null ? null : liveRoomTipsModel7.getLink(), 25);
                }
            } else {
                LiveRoomTipsModel liveRoomTipsModel8 = this.u;
                if (liveRoomTipsModel8 == null) {
                    z = false;
                } else {
                    z = false;
                    if (liveRoomTipsModel8.getLinkType() == 3) {
                        z = true;
                    }
                }
                if (z) {
                    LiveRoomFunctionItemModel liveRoomFunctionItemModel = new LiveRoomFunctionItemModel();
                    LiveRoomTipsModel liveRoomTipsModel9 = this.u;
                    liveRoomFunctionItemModel.setLink(String.valueOf(liveRoomTipsModel9 == null ? null : liveRoomTipsModel9.getLink()));
                    LiveRoomTipsModel liveRoomTipsModel10 = this.u;
                    Integer valueOf = liveRoomTipsModel10 == null ? null : Integer.valueOf(liveRoomTipsModel10.getLinkType());
                    Intrinsics.a(valueOf);
                    liveRoomFunctionItemModel.setLink_type(valueOf.intValue());
                    LiveEventBusUtil.a(liveRoomFunctionItemModel);
                }
            }
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TextView tvTipsMsg, ImageView imgCommonTipsIcon, LiveCommonPopTips this$0) {
        Intrinsics.e(tvTipsMsg, "$tvTipsMsg");
        Intrinsics.e(imgCommonTipsIcon, "$imgCommonTipsIcon");
        Intrinsics.e(this$0, "this$0");
        int lineCount = tvTipsMsg.getLineCount();
        ViewGroup.LayoutParams layoutParams = imgCommonTipsIcon.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (lineCount == 2) {
            layoutParams2.width = UiUtils.a(this$0.getContext(), 34.0f);
            layoutParams2.height = UiUtils.a(this$0.getContext(), 34.0f);
        } else {
            layoutParams2.width = UiUtils.a(this$0.getContext(), 23.0f);
            layoutParams2.height = UiUtils.a(this$0.getContext(), 23.0f);
        }
        imgCommonTipsIcon.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveCommonPopTips this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.t()) {
            return;
        }
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveCommonPopTips this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        AppInfo.n().removeCallbacks(this$0.w);
        this$0.A();
    }

    public final void a(View view, XPopupCallback xPopupCallback) {
        this.v = true;
        new XPopup.Builder(getContext()).a(xPopupCallback).a(PopupAnimation.ScaleAlphaFromCenter).d((Boolean) false).a(PopupPosition.Top).b(false).a(view).a((BasePopupView) this).h();
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        LiveRoomTipsModel liveRoomTipsModel;
        super.b();
        View findViewById = findViewById(R.id.tv_tip_msg);
        Intrinsics.c(findViewById, "findViewById(R.id.tv_tip_msg)");
        final TextView textView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.sll_common_tips_bg);
        Intrinsics.c(findViewById2, "findViewById(R.id.sll_common_tips_bg)");
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.img_common_tips_icon);
        Intrinsics.c(findViewById3, "findViewById(R.id.img_common_tips_icon)");
        final ImageView imageView = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.view_small_triangle);
        Intrinsics.c(findViewById4, "findViewById(R.id.view_small_triangle)");
        TriangleView triangleView = (TriangleView) findViewById4;
        LiveRoomTipsModel liveRoomTipsModel2 = this.u;
        if (liveRoomTipsModel2 != null) {
            EventTrackLive.w(LiveProtos.Event.LIVE_TIPS_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), String.valueOf(liveRoomTipsModel2.getId()));
            textView.setText(liveRoomTipsModel2.getText());
            String icon = liveRoomTipsModel2.getIcon();
            if (icon == null || icon.length() == 0) {
                BluedViewExKt.a(imageView);
                textView.setMaxWidth(UiUtils.a(getContext(), 140.0f));
            } else {
                textView.setMaxWidth(UiUtils.a(getContext(), 106.0f));
                BluedViewExKt.b(imageView);
                ImageLoader.a((IRequestHost) null, liveRoomTipsModel2.getIcon()).a(imageView);
                textView.post(new Runnable() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveCommonPopTips$g9gTlyMlk3BmQFPc4VXT4j3AIKQ
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveCommonPopTips.a(TextView.this, imageView, this);
                    }
                });
            }
            ShapeModel shapeModel = shapeLinearLayout.getShapeModel();
            Intrinsics.c(shapeModel, "sllCommonTipsBg.shapeModel");
            if (liveRoomTipsModel2.getDirection() == 1) {
                shapeModel.C = 0;
            } else {
                shapeModel.C = 270;
            }
            ArrayList<String> colors = liveRoomTipsModel2.getColors();
            if (colors == null || colors.isEmpty()) {
                shapeModel.t = getContext().getResources().getColor(R.color.syc_a);
                shapeModel.v = getContext().getResources().getColor(R.color.syc_a);
            } else {
                int size = liveRoomTipsModel2.getColors().size();
                if (size == 1) {
                    shapeModel.t = Color.parseColor(liveRoomTipsModel2.getColors().get(0));
                    shapeModel.v = Color.parseColor(liveRoomTipsModel2.getColors().get(0));
                    triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(0)));
                } else if (size == 2) {
                    shapeModel.t = Color.parseColor(liveRoomTipsModel2.getColors().get(0));
                    shapeModel.v = Color.parseColor(liveRoomTipsModel2.getColors().get(1));
                    int location = liveRoomTipsModel2.getLocation();
                    if (!(10 <= location && location < 20)) {
                        if (!(24 <= location && location < 30)) {
                            if (20 <= location && location < 24) {
                                triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(1)));
                            }
                        } else if (liveRoomTipsModel2.getDirection() == 1) {
                            triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(0)));
                        } else {
                            triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(1)));
                        }
                    } else if (liveRoomTipsModel2.getDirection() == 1) {
                        triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(0)));
                    } else {
                        triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(1)));
                    }
                } else if (size != 3) {
                    shapeModel.t = getContext().getResources().getColor(R.color.syc_a);
                    shapeModel.v = getContext().getResources().getColor(R.color.syc_a);
                } else {
                    shapeModel.t = Color.parseColor(liveRoomTipsModel2.getColors().get(0));
                    shapeModel.u = Color.parseColor(liveRoomTipsModel2.getColors().get(1));
                    shapeModel.v = Color.parseColor(liveRoomTipsModel2.getColors().get(2));
                    int location2 = liveRoomTipsModel2.getLocation();
                    if (!(10 <= location2 && location2 < 20)) {
                        if (!(24 <= location2 && location2 < 30)) {
                            if (20 <= location2 && location2 < 24) {
                                triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(2)));
                            }
                        } else if (liveRoomTipsModel2.getDirection() == 1) {
                            triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(0)));
                        } else {
                            triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(2)));
                        }
                    } else if (liveRoomTipsModel2.getDirection() == 1) {
                        triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(0)));
                    } else {
                        triangleView.setColor(Color.parseColor(liveRoomTipsModel2.getColors().get(2)));
                    }
                }
            }
            shapeLinearLayout.setShapeModel(shapeModel);
            ViewGroup.LayoutParams layoutParams = triangleView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            int location3 = liveRoomTipsModel2.getLocation();
            if (10 <= location3 && location3 < 20) {
                layoutParams2.gravity = 8388611;
            } else {
                if (24 <= location3 && location3 < 30) {
                    layoutParams2.gravity = 8388611;
                } else {
                    if (20 <= location3 && location3 < 24) {
                        layoutParams2.gravity = 8388613;
                    }
                }
            }
            triangleView.setLayoutParams(layoutParams2);
        }
        View findViewById5 = findViewById(R.id.rl_root);
        Intrinsics.c(findViewById5, "findViewById(R.id.rl_root)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveCommonPopTips$fjW13Il8Y7RMGzQNCWj4vD-ERgQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveCommonPopTips.a(LiveCommonPopTips.this, view);
            }
        });
        ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
        LiveRoomTipsModel liveRoomTipsModel3 = this.u;
        Integer valueOf = liveRoomTipsModel3 == null ? null : Integer.valueOf(liveRoomTipsModel3.getLocation());
        if (valueOf != null && new IntRange(10, 19).a(valueOf.intValue())) {
            marginLayoutParams.rightMargin = UiUtils.a(getContext(), 3.0f);
            marginLayoutParams.leftMargin = 0;
        } else {
            if (valueOf != null && new IntRange(24, 29).a(valueOf.intValue())) {
                marginLayoutParams.rightMargin = 0;
                marginLayoutParams.leftMargin = UiUtils.a(getContext(), 3.0f);
            } else {
                if ((valueOf != null && valueOf.intValue() == 23) || (valueOf != null && valueOf.intValue() == 22)) {
                    marginLayoutParams.rightMargin = UiUtils.a(getContext(), 4.0f);
                    marginLayoutParams.leftMargin = 0;
                } else {
                    if (valueOf != null && new IntRange(20, 21).a(valueOf.intValue())) {
                        marginLayoutParams.rightMargin = 0;
                        marginLayoutParams.leftMargin = UiUtils.a(getContext(), 4.0f);
                    }
                }
            }
        }
        linearLayout.setLayoutParams(marginLayoutParams);
        LiveRoomTipsModel liveRoomTipsModel4 = this.u;
        Integer valueOf2 = liveRoomTipsModel4 == null ? null : Integer.valueOf(liveRoomTipsModel4.getCountdown());
        Intrinsics.a(valueOf2);
        if (valueOf2.intValue() <= 0 || (liveRoomTipsModel = this.u) == null) {
            return;
        }
        AppInfo.n().postDelayed(getDismissRunnable(), liveRoomTipsModel.getCountdown() * 1000);
    }

    public final boolean getCenter() {
        return this.t;
    }

    public final Runnable getDismissRunnable() {
        return this.w;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.live_common_pop_tips;
    }

    public final LiveRoomTipsModel getLiveTipsModel() {
        return this.u;
    }

    public final boolean getShowing() {
        return this.v;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return true;
    }

    public final void setCenter(boolean z) {
        this.t = z;
    }

    public final void setDismissRunnable(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.w = runnable;
    }

    public final void setLiveTipsModel(LiveRoomTipsModel liveRoomTipsModel) {
        this.u = liveRoomTipsModel;
    }

    public final void setShowing(boolean z) {
        this.v = z;
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public void u() {
        super.u();
        this.v = false;
    }

    public final boolean z() {
        return this.v;
    }
}
