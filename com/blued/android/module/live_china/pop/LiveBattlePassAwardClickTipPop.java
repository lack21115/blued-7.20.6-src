package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveBattlePassAwardClickPopShadeView;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.das.live.LiveProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveBattlePassAwardClickTipPop.class */
public final class LiveBattlePassAwardClickTipPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    private FragmentActivity f13960c;
    private View d;
    private FrameLayout e;
    private FrameLayout f;
    private SVGAImageView g;
    private SVGAImageView h;
    private ImageView i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveBattlePassAwardClickTipPop(Context context, FragmentActivity activity) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(activity, "activity");
        this.f13960c = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattlePassAwardClickTipPop this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_TRY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this$0.p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        if (this.d == null) {
            p();
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_BUBBLE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        this.e = (FrameLayout) findViewById(R.id.fl_root);
        this.f = (FrameLayout) findViewById(R.id.fl_content);
        this.g = (SVGAImageView) findViewById(R.id.svg_circular);
        this.h = (SVGAImageView) findViewById(R.id.svg_finger);
        this.i = (ImageView) findViewById(R.id.iv_goto);
        View view = this.d;
        if (view == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.c(context, "context");
        LiveBattlePassAwardClickPopShadeView liveBattlePassAwardClickPopShadeView = new LiveBattlePassAwardClickPopShadeView(context, view);
        liveBattlePassAwardClickPopShadeView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = this.e;
        if (frameLayout != null) {
            frameLayout.addView(liveBattlePassAwardClickPopShadeView);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int a2 = DensityUtils.a(getContext(), 125.0f);
        FrameLayout frameLayout2 = this.f;
        if (frameLayout2 != null) {
            frameLayout2.setX(iArr[0] - ((a2 - view.getWidth()) / 2));
        }
        FrameLayout frameLayout3 = this.f;
        if (frameLayout3 != null) {
            frameLayout3.setY(iArr[1] - ((a2 - view.getHeight()) / 2));
        }
        SVGAParser.a(SVGAParser.f15958a.b(), "live_battle_circular.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.pop.LiveBattlePassAwardClickTipPop$initPopupContent$1$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                SVGAImageView sVGAImageView;
                SVGAImageView sVGAImageView2;
                Intrinsics.e(videoItem, "videoItem");
                sVGAImageView = LiveBattlePassAwardClickTipPop.this.g;
                if (sVGAImageView != null) {
                    sVGAImageView.setVideoItem(videoItem);
                }
                sVGAImageView2 = LiveBattlePassAwardClickTipPop.this.g;
                if (sVGAImageView2 == null) {
                    return;
                }
                sVGAImageView2.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        SVGAParser.a(SVGAParser.f15958a.b(), "live_battle_finger.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.pop.LiveBattlePassAwardClickTipPop$initPopupContent$1$2
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                SVGAImageView sVGAImageView;
                SVGAImageView sVGAImageView2;
                Intrinsics.e(videoItem, "videoItem");
                sVGAImageView = LiveBattlePassAwardClickTipPop.this.h;
                if (sVGAImageView != null) {
                    sVGAImageView.setVideoItem(videoItem);
                }
                sVGAImageView2 = LiveBattlePassAwardClickTipPop.this.h;
                if (sVGAImageView2 == null) {
                    return;
                }
                sVGAImageView2.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        ImageView imageView = this.i;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.-$$Lambda$LiveBattlePassAwardClickTipPop$kzasw58NbZXHIbwZYmQQ_TjdWYI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LiveBattlePassAwardClickTipPop.a(LiveBattlePassAwardClickTipPop.this, view2);
            }
        });
    }

    public final void b(View atView) {
        Intrinsics.e(atView, "atView");
        this.d = atView;
        new XPopup.Builder(getContext()).a(PopupAnimation.NoAnimation).d((Boolean) false).a((BasePopupView) this).h();
    }

    public final FragmentActivity getActivity() {
        return this.f13960c;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_battle_pass_award_click_tips;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return this.f13960c.getWindowManager().getDefaultDisplay().getWidth();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p();
        return false;
    }

    public final void setActivity(FragmentActivity fragmentActivity) {
        Intrinsics.e(fragmentActivity, "<set-?>");
        this.f13960c = fragmentActivity;
    }
}
