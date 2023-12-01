package com.soft.blued.ui.msg;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.svgaplayer.SVGACallback;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAPlayer;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.config.c;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.databinding.FragmentDateTodaySearchBinding;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.model.DateTodayConfigModel;
import com.soft.blued.ui.msg.model.DateTodayMatchModel;
import com.soft.blued.ui.msg.model.DateTodayMatchUserModel;
import com.soft.blued.ui.msg.model.DateTodayPurposeModel;
import com.soft.blued.ui.msg.pop.DateTodayPurposePop;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/DateTodaySearchFragment.class */
public final class DateTodaySearchFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f31701a = new Companion(null);
    private FragmentDateTodaySearchBinding b;
    private long d;
    private DateTodayMatchModel e;
    private boolean f;
    private boolean g;
    private int h;

    /* renamed from: c  reason: collision with root package name */
    private final int f31702c = 3000;
    private final int[] i = {R.drawable.icon_date_today_fake1, R.drawable.icon_date_today_fake2, R.drawable.icon_date_today_fake3, R.drawable.icon_date_today_fake4, R.drawable.icon_date_today_fake5, R.drawable.icon_date_today_fake6, R.drawable.icon_date_today_fake7, R.drawable.icon_date_today_fake8};
    private final int[] j = {R.string.date_today_searching1, R.string.date_today_searching2, R.string.date_today_searching3, R.string.date_today_searching4};
    private final DateTodaySearchFragment$changeFakeAvatarRunnable$1 k = new Runnable() { // from class: com.soft.blued.ui.msg.DateTodaySearchFragment$changeFakeAvatarRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            FragmentDateTodaySearchBinding b;
            int i;
            int i2;
            FragmentDateTodaySearchBinding b2;
            int[] iArr;
            int i3;
            int[] iArr2;
            FragmentDateTodaySearchBinding b3;
            int[] iArr3;
            int i4;
            int[] iArr4;
            b = DateTodaySearchFragment.this.b();
            if (b == null) {
                return;
            }
            DateTodaySearchFragment dateTodaySearchFragment = DateTodaySearchFragment.this;
            i = dateTodaySearchFragment.h;
            dateTodaySearchFragment.h = i + 1;
            DateTodayManager dateTodayManager = DateTodayManager.f32404a;
            i2 = DateTodaySearchFragment.this.h;
            dateTodayManager.a(i2);
            b2 = DateTodaySearchFragment.this.b();
            ImageView imageView = b2.o;
            iArr = DateTodaySearchFragment.this.i;
            i3 = DateTodaySearchFragment.this.h;
            iArr2 = DateTodaySearchFragment.this.i;
            imageView.setImageResource(iArr[i3 % iArr2.length]);
            b3 = DateTodaySearchFragment.this.b();
            TextView textView = b3.v;
            iArr3 = DateTodaySearchFragment.this.j;
            i4 = DateTodaySearchFragment.this.h;
            iArr4 = DateTodaySearchFragment.this.j;
            textView.setText(iArr3[(i4 / 2) % iArr4.length]);
            AppInfo.n().postDelayed(this, c.j);
        }
    };
    private final DateTodaySearchFragment$showUIRunnable$1 l = new Runnable() { // from class: com.soft.blued.ui.msg.DateTodaySearchFragment$showUIRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            FragmentDateTodaySearchBinding b;
            DateTodayMatchModel dateTodayMatchModel;
            DateTodayMatchModel dateTodayMatchModel2;
            b = DateTodaySearchFragment.this.b();
            if (b == null) {
                return;
            }
            dateTodayMatchModel = DateTodaySearchFragment.this.e;
            if (dateTodayMatchModel == null) {
                DateTodaySearchFragment.this.f();
                return;
            }
            DateTodaySearchFragment dateTodaySearchFragment = DateTodaySearchFragment.this;
            dateTodayMatchModel2 = dateTodaySearchFragment.e;
            Intrinsics.a(dateTodayMatchModel2);
            dateTodaySearchFragment.a(dateTodayMatchModel2);
        }
    };

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/DateTodaySearchFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, DateTodaySearchFragment.class, bundle);
        }
    }

    private final void a(View view, View view2, View view3, int i) {
        int[] iArr = {i, 0};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        gradientDrawable.setColors(iArr);
        view.setBackground(gradientDrawable);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setGradientType(0);
        gradientDrawable2.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable2.setColors(iArr);
        view2.setBackground(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setGradientCenter(0.5f, 0.0f);
        gradientDrawable3.setGradientType(1);
        gradientDrawable3.setGradientRadius(DisplayUtil.a(getContext(), 140.0f));
        gradientDrawable3.setColors(iArr);
        view3.setBackground(gradientDrawable3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodaySearchFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final DateTodaySearchFragment this$0, String hisAvatar, final DateTodayMatchModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(hisAvatar, "$hisAvatar");
        Intrinsics.e(model, "$model");
        if (this$0.b() != null) {
            this$0.a(new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$rGgocYX0E7BNWm-p8eXjW0kCWTY
                @Override // java.lang.Runnable
                public final void run() {
                    DateTodaySearchFragment.c(DateTodaySearchFragment.this, model);
                }
            }, hisAvatar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodaySearchFragment this$0, List views, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(views, "$views");
        if (this$0.getContext() != null) {
            View view = (View) views.get(0);
            View view2 = (View) views.get(1);
            View view3 = (View) views.get(2);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            this$0.a(view, view2, view3, ((Integer) animatedValue).intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final DateTodayMatchModel dateTodayMatchModel) {
        String avatar;
        AppInfo.n().removeCallbacks(this.k);
        b();
        DateTodayMatchUserModel target_info = dateTodayMatchModel.getTarget_info();
        String str = "";
        if (target_info != null && (avatar = target_info.getAvatar()) != null) {
            str = avatar;
        }
        final String str2 = str;
        a(new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$652_NjWc3xJKBWZquVhxnwlZvKw
            @Override // java.lang.Runnable
            public final void run() {
                DateTodaySearchFragment.a(DateTodaySearchFragment.this, str2, dateTodayMatchModel);
            }
        });
    }

    private final void a(Runnable runnable) {
        b().j.animate().alpha(0.0f).scaleX(0.4f).scaleY(0.4f).setDuration(100L).withEndAction(runnable);
    }

    private final void a(Runnable runnable, String str) {
        ImageLoader.a(getFragmentActive(), str).c().a(100).a(b().o);
        b().j.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new OvershootInterpolator()).withEndAction(runnable);
    }

    private final void a(final List<? extends View> list, int[] iArr) {
        ValueAnimator ofArgb = ValueAnimator.ofArgb(Arrays.copyOf(iArr, iArr.length));
        ofArgb.setDuration(m.ag);
        ofArgb.setRepeatCount(-1);
        ofArgb.setRepeatMode(1);
        ofArgb.setInterpolator(new LinearInterpolator());
        ofArgb.setEvaluator(new ArgbEvaluator());
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$n8HGk1jAbSzm0OJ-D3YXgue3hj4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                DateTodaySearchFragment.a(DateTodaySearchFragment.this, list, valueAnimator);
            }
        });
        ofArgb.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        if (r15 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r12) {
        /*
            r11 = this;
            r0 = r11
            com.soft.blued.ui.msg.model.DateTodayMatchModel r0 = r0.e
            r18 = r0
            r0 = r18
            if (r0 != 0) goto Le
            goto Lc1
        Le:
            r0 = r18
            com.soft.blued.ui.msg.model.DateTodayMatchUserModel r0 = r0.getTarget_info()
            r16 = r0
            r0 = r16
            if (r0 != 0) goto L1d
            goto Lc1
        L1d:
            r0 = r11
            android.content.Context r0 = r0.getContext()
            r17 = r0
            r0 = r17
            if (r0 != 0) goto L2b
            goto Lc1
        L2b:
            com.soft.blued.ui.msg.manager.DateTodayManager r0 = com.soft.blued.ui.msg.manager.DateTodayManager.f32404a
            r0.k()
            java.lang.String r0 = "xxx"
            java.lang.String r1 = "goToPage()"
            int r0 = android.util.Log.e(r0, r1)
            com.soft.blued.ui.msg.manager.DateTodayManager r0 = com.soft.blued.ui.msg.manager.DateTodayManager.f32404a
            com.soft.blued.ui.msg.manager.DateTodayManager$Status r1 = com.soft.blued.ui.msg.manager.DateTodayManager.Status.MATCHED
            r2 = 0
            r3 = r18
            com.blued.android.chat.model.SessionModel r0 = r0.a(r1, r2, r3)
            r15 = r0
            com.soft.blued.ui.msg.manager.DateTodayManager r0 = com.soft.blued.ui.msg.manager.DateTodayManager.f32404a     // Catch: java.lang.Exception -> Ld3
            r1 = r16
            java.lang.String r1 = r1.getUid()     // Catch: java.lang.Exception -> Ld3
            long r0 = r0.d(r1)     // Catch: java.lang.Exception -> Ld3
            r13 = r0
            r0 = r15
            if (r0 != 0) goto L61
        L5a:
            java.lang.String r0 = ""
            r15 = r0
            goto L70
        L61:
            r0 = r15
            java.lang.String r0 = r0.lastMsgContent     // Catch: java.lang.Exception -> Ld3
            r15 = r0
            r0 = r15
            if (r0 != 0) goto Ld8
            goto L5a
        L70:
            r0 = r13
            r1 = 281(0x119, float:3.94E-43)
            r2 = r15
            com.soft.blued.ui.msg.controller.tools.ChatHelperV4 r3 = com.soft.blued.ui.msg.controller.tools.ChatHelperV4.a()     // Catch: java.lang.Exception -> Ld3
            com.blued.android.chat.model.SessionProfileModel r3 = r3.b()     // Catch: java.lang.Exception -> Ld3
            com.google.gson.Gson r4 = com.blued.android.core.AppInfo.f()     // Catch: java.lang.Exception -> Ld3
            r5 = r18
            java.lang.String r4 = r4.toJson(r5)     // Catch: java.lang.Exception -> Ld3
            r5 = 2
            com.blued.android.chat.model.ChattingModel r0 = com.blued.android.chat.utils.ChatHelper.getChattingModelForSendmsg(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> Ld3
            r15 = r0
            r0 = r15
            java.lang.String r1 = "chatMsg"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)     // Catch: java.lang.Exception -> Ld3
            r0 = r15
            com.soft.blued.ui.msg.manager.DateTodayManager.a(r0)     // Catch: java.lang.Exception -> Ld3
            com.soft.blued.ui.msg.controller.tools.ChatHelperV4 r0 = com.soft.blued.ui.msg.controller.tools.ChatHelperV4.a()     // Catch: java.lang.Exception -> Ld3
            r1 = r15
            java.lang.String r2 = ""
            java.lang.String r3 = ""
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r0.c(r1, r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> Ld3
            goto Lac
        Lac:
            com.soft.blued.ui.msg.manager.DateTodayManager r0 = com.soft.blued.ui.msg.manager.DateTodayManager.f32404a
            long r0 = r0.l()
            r0 = r12
            if (r0 == 0) goto Lc1
            com.soft.blued.ui.msg.manager.DateTodayManager r0 = com.soft.blued.ui.msg.manager.DateTodayManager.f32404a
            r1 = r17
            r2 = r16
            r0.a(r1, r2)
        Lc1:
            r0 = r11
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            r15 = r0
            r0 = r15
            if (r0 != 0) goto Lcd
            return
        Lcd:
            r0 = r15
            r0.finish()
            return
        Ld3:
            r15 = move-exception
            goto Lac
        Ld8:
            goto L70
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.DateTodaySearchFragment.a(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentDateTodaySearchBinding b() {
        FragmentDateTodaySearchBinding fragmentDateTodaySearchBinding = this.b;
        Intrinsics.a(fragmentDateTodaySearchBinding);
        return fragmentDateTodaySearchBinding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DateTodaySearchFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void b(DateTodayMatchModel dateTodayMatchModel) {
        FragmentDateTodaySearchBinding b = b();
        b.t.setVisibility(8);
        b.t.a(true);
        b.q.setVisibility(0);
        b.q.setScaleX(0.0f);
        b.q.setScaleY(0.0f);
        b.q.animate().scaleX(1.0f).scaleY(1.0f).setDuration(350L).setInterpolator(new OvershootInterpolator());
        b.k.animate().translationX(BluedViewExtKt.a(40)).setDuration(350L).setInterpolator(new OvershootInterpolator());
        b.j.animate().translationX(-BluedViewExtKt.a(40)).setDuration(350L).setInterpolator(new OvershootInterpolator());
        SVGAImageView sVGAImageView = b().r;
        sVGAImageView.setLoops(1);
        sVGAImageView.setClearsAfterStop(false);
        sVGAImageView.a();
        SVGAPlayer.Builder a2 = new SVGAPlayer.Builder().a("date_today_small_heart.svga").a((Integer) 1);
        SVGAImageView svgaMatchSmallHeartAnim = b.s;
        Intrinsics.c(svgaMatchSmallHeartAnim, "svgaMatchSmallHeartAnim");
        a2.a(svgaMatchSmallHeartAnim);
        b.s.setCallback(new SVGACallback() { // from class: com.soft.blued.ui.msg.DateTodaySearchFragment$showTwoAvatarCollision$1$2
            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onFinished() {
                DateTodaySearchFragment.this.a(true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onPause() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onRepeat() {
            }

            @Override // com.blued.android.module.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
            }
        });
    }

    private final void c() {
        FragmentDateTodaySearchBinding b = b();
        e();
        b.m.setVisibility(0);
        b.n.setVisibility(8);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, UserInfo.getInstance().getLoginUserInfo().getAvatar())).c().a(b.p);
        d();
        g();
        b.u.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$Dx9rG5Bp8Qz2GAa-deHdSdEBKIA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTodaySearchFragment.a(DateTodaySearchFragment.this, view);
            }
        });
        b.w.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$vaQ6yYzTgLt1orVjVXsrswwSfz4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTodaySearchFragment.b(DateTodaySearchFragment.this, view);
            }
        });
        b.l.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$L3OMycLlpzzVDkL0tYCgAl2BYo0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTodaySearchFragment.c(DateTodaySearchFragment.this, view);
            }
        });
        if (i()) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg.-$$Lambda$DateTodaySearchFragment$AnrF-OIvoka2tEf7Fe-CSCgjXMg
                @Override // java.lang.Runnable
                public final void run() {
                    DateTodaySearchFragment.l(DateTodaySearchFragment.this);
                }
            });
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DateTodaySearchFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DateTodaySearchFragment this$0, DateTodayMatchModel model) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        if (this$0.b() != null) {
            this$0.b(model);
        }
    }

    private final void d() {
        FragmentDateTodaySearchBinding b = b();
        SVGAPlayer.Builder a2 = new SVGAPlayer.Builder().a("date_today_searching.svga");
        SVGAImageView svgaSearchAnim = b.t;
        Intrinsics.c(svgaSearchAnim, "svgaSearchAnim");
        a2.a(svgaSearchAnim);
        ViewGroup.LayoutParams layoutParams = b.r.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = AppInfo.l;
        layoutParams2.height = AppInfo.l;
        layoutParams2.topMargin = BluedViewExtKt.a(300) - ((layoutParams2.height - BluedViewExtKt.a(126)) / 2);
        b.r.setLayoutParams(layoutParams2);
        SVGAPlayer.Builder a3 = new SVGAPlayer.Builder().a("date_today_search_heart.svga").a((Integer) 1).a((Boolean) false);
        SVGAImageView svgaMatchHeartAnim = b.r;
        Intrinsics.c(svgaMatchHeartAnim, "svgaMatchHeartAnim");
        a3.a(svgaMatchHeartAnim);
    }

    private final void e() {
        FragmentDateTodaySearchBinding b = b();
        a(CollectionsKt.b(b.d, b.e, b.f28809a), new int[]{-5249537, -4542465, -5242909, -5249537});
        a(CollectionsKt.b(b.f, b.g, b.b), new int[]{-5242909, -5249537, -4542465, -5242909});
        a(CollectionsKt.b(b.h, b.i, b.f28810c), new int[]{-4542465, -5242909, -5249537, -4542465});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        Log.e("xxx", "showFailureUI()");
        DateTodayManager.f32404a.a("request_no_match");
        AppInfo.n().removeCallbacks(this.k);
        FragmentDateTodaySearchBinding b = b();
        b.n.setVisibility(0);
        b.m.setVisibility(8);
        DateTodayManager.a(DateTodayManager.f32404a, DateTodayManager.Status.HAVE_CHANCE, null, null, 6, null);
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_SESSION_LIST).post(null);
    }

    private final void g() {
        this.h = DateTodayManager.f32404a.r();
        AppInfo.n().post(this.k);
    }

    private final void h() {
        List<DateTodayPurposeModel> friends_purpose;
        Context context;
        DateTodayConfigModel b = DateTodayManager.f32404a.b();
        if (b == null || (friends_purpose = b.getFriends_purpose()) == null || (context = getContext()) == null) {
            return;
        }
        AppInfo.n().removeCallbacks(this.l);
        this.f = true;
        new XPopup.Builder(context).a(new SimpleCallback() { // from class: com.soft.blued.ui.msg.DateTodaySearchFragment$showPurposeSelectPop$1$1$1
            @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
            public void d(BasePopupView basePopupView) {
                boolean z;
                DateTodaySearchFragment$showUIRunnable$1 dateTodaySearchFragment$showUIRunnable$1;
                DateTodaySearchFragment.this.f = false;
                z = DateTodaySearchFragment.this.g;
                if (z) {
                    Handler n = AppInfo.n();
                    dateTodaySearchFragment$showUIRunnable$1 = DateTodaySearchFragment.this.l;
                    n.post(dateTodaySearchFragment$showUIRunnable$1);
                }
                super.d(basePopupView);
            }
        }).a((BasePopupView) new DateTodayPurposePop(context, getFragmentActive(), friends_purpose)).h();
    }

    private final boolean i() {
        if (DateTodayManager.f32404a.o()) {
            return false;
        }
        long q = DateTodayManager.f32404a.q();
        return q == 0 || q - System.currentTimeMillis() > 604800000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DateTodaySearchFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    public final void a() {
        this.e = null;
        this.d = System.currentTimeMillis();
        this.g = false;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        ChatHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<DateTodayMatchModel>>(fragmentActive) { // from class: com.soft.blued.ui.msg.DateTodaySearchFragment$search$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<DateTodayMatchModel> bluedEntityA) {
                boolean z;
                long j;
                int i;
                DateTodaySearchFragment$showUIRunnable$1 dateTodaySearchFragment$showUIRunnable$1;
                List<DateTodayMatchModel> list;
                DateTodayMatchModel dateTodayMatchModel;
                if (bluedEntityA != null && (list = bluedEntityA.data) != null) {
                    DateTodaySearchFragment dateTodaySearchFragment = DateTodaySearchFragment.this;
                    if (list.size() > 0) {
                        dateTodaySearchFragment.e = list.get(0);
                        dateTodayMatchModel = dateTodaySearchFragment.e;
                        if (dateTodayMatchModel != null) {
                            if (dateTodayMatchModel.getTarget_info() == null || dateTodayMatchModel.getSelf_info() == null) {
                                dateTodaySearchFragment.e = null;
                                return;
                            } else {
                                DateTodayManager.f32404a.a("");
                                dateTodayMatchModel.setTime(System.currentTimeMillis());
                            }
                        }
                    }
                }
                z = DateTodaySearchFragment.this.f;
                if (z) {
                    return;
                }
                j = DateTodaySearchFragment.this.d;
                i = DateTodaySearchFragment.this.f31702c;
                long j2 = i;
                long currentTimeMillis = System.currentTimeMillis();
                Handler n = AppInfo.n();
                dateTodaySearchFragment$showUIRunnable$1 = DateTodaySearchFragment.this.l;
                n.postDelayed(dateTodaySearchFragment$showUIRunnable$1, (j + j2) - currentTimeMillis);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                DateTodaySearchFragment.this.f();
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                DateTodaySearchFragment.this.g = true;
            }
        }, getFragmentActive());
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        a(false);
        return false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        this.b = FragmentDateTodaySearchBinding.a(inflater, viewGroup, false);
        return b().getRoot();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AppInfo.n().removeCallbacks(this.k);
        AppInfo.n().removeCallbacks(this.l);
        this.b = null;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        c();
    }
}
