package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveBattleNextLevelRandomAwardDialogBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.das.live.LiveProtos;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleNextLevelRandomAwardDialog.class */
public final class LiveBattleNextLevelRandomAwardDialog extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12725a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<LiveBattleNextLevelRandomAwardDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleNextLevelRandomAwardDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleNextLevelRandomAwardDialogBinding invoke() {
            return LiveBattleNextLevelRandomAwardDialogBinding.a(LayoutInflater.from(LiveBattleNextLevelRandomAwardDialog.this.getContext()));
        }
    });

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleNextLevelRandomAwardDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(FragmentManager fragmentManager) {
            Intrinsics.e(fragmentManager, "fragmentManager");
            new LiveBattleNextLevelRandomAwardDialog().show(fragmentManager, "LiveBattleNextLevelRandomAwardDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattleNextLevelRandomAwardDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBattleNextLevelRandomAwardDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveBattleNextLevelRandomAwardDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_TOP_BUY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LiveBattleShopDialog.f12741a.b(this$0);
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleNextLevelRandomAwardDialogBinding d() {
        return (LiveBattleNextLevelRandomAwardDialogBinding) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveBattleNextLevelRandomAwardDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void e() {
        SVGAParser.a(SVGAParser.f15958a.b(), "live_battle_fly_gift.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.fragment.LiveBattleNextLevelRandomAwardDialog$initView$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                LiveBattleNextLevelRandomAwardDialogBinding d;
                LiveBattleNextLevelRandomAwardDialogBinding d2;
                Intrinsics.e(videoItem, "videoItem");
                d = LiveBattleNextLevelRandomAwardDialog.this.d();
                d.h.setVideoItem(videoItem);
                d2 = LiveBattleNextLevelRandomAwardDialog.this.d();
                d2.h.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
        if (LiveBattlePassDialogFragment.f12728a.a()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_TOP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            d().k.setText("解锁下一战令有机会获得额外奖励");
            TextView textView = d().i;
            Intrinsics.c(textView, "vb.tvDesc");
            BluedViewExKt.a(textView);
            d().j.setText("快去试试吧！");
            LinearLayout linearLayout = d().e;
            Intrinsics.c(linearLayout, "vb.llBtnRoot");
            BluedViewExKt.a(linearLayout);
            ImageView imageView = d().f12141c;
            Intrinsics.c(imageView, "vb.btnGetAllBig");
            BluedViewExKt.b(imageView);
            d().f12141c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleNextLevelRandomAwardDialog$Sp_mVnLmUtJzcUbmrtslaOQBrbY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveBattleNextLevelRandomAwardDialog.a(LiveBattleNextLevelRandomAwardDialog.this, view);
                }
            });
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_BASIC_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            d().k.setText("购买进阶战令并解锁下一等级");
            d().i.setText("有机会领取");
            TextView textView2 = d().i;
            Intrinsics.c(textView2, "vb.tvDesc");
            BluedViewExKt.b(textView2);
            d().j.setText("额外奖励！");
            LinearLayout linearLayout2 = d().e;
            Intrinsics.c(linearLayout2, "vb.llBtnRoot");
            BluedViewExKt.b(linearLayout2);
            ImageView imageView2 = d().f12141c;
            Intrinsics.c(imageView2, "vb.btnGetAllBig");
            BluedViewExKt.a(imageView2);
            ImageLoader.c(a(), "live_battle_box.png").g().g(-1).a(d().d);
            d().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleNextLevelRandomAwardDialog$gz_oX4h9nL370HgojS6LSDLfjAg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveBattleNextLevelRandomAwardDialog.b(LiveBattleNextLevelRandomAwardDialog.this, view);
                }
            });
            d().f12140a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleNextLevelRandomAwardDialog$-kbbkzVAo5FG9nn6fQu9m8pL34g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveBattleNextLevelRandomAwardDialog.c(LiveBattleNextLevelRandomAwardDialog.this, view);
                }
            });
        }
        d().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleNextLevelRandomAwardDialog$cP2kusALy4ialRxbV2KPrnaE4lo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleNextLevelRandomAwardDialog.d(LiveBattleNextLevelRandomAwardDialog.this, view);
            }
        });
        d().g.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(450L).setInterpolator(new OvershootInterpolator()).start();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        WindowManager windowManager;
        Display defaultDisplay;
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(d().getRoot(), new ViewGroup.LayoutParams(-1, -1));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(Color.argb(204, 0, 0, 0)));
        window.setWindowAnimations(R.style.alpha_menu_slow_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        FragmentActivity activity = getActivity();
        Integer num = null;
        if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            num = Integer.valueOf(defaultDisplay.getWidth());
        }
        Intrinsics.a(num);
        attributes.width = num.intValue();
        attributes.height = -1;
        dialog.onWindowAttributesChanged(attributes);
        window.setFlags(67108864, 67108864);
        e();
        return dialog;
    }
}
