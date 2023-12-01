package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.DialogLiveBattlePassBinding;
import com.blued.android.module.live_china.fitem.FitemBattlePassLevel;
import com.blued.android.module.live_china.fitem.FitemBattlePassTask;
import com.blued.android.module.live_china.fragment.LiveBattleNextLevelRandomAwardDialog;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.BattlePassBonusHistoryDataModel;
import com.blued.android.module.live_china.model.BattlePassDataModel;
import com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel;
import com.blued.android.module.live_china.model.BattlePassLevelDataModel;
import com.blued.android.module.live_china.model.BattlePassTaskDataModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.pop.LiveBattlePassAwardClickTipPop;
import com.blued.android.module.live_china.utils.BattlePassLinearLayoutManger;
import com.blued.android.module.live_china.utils.LiveCloakingUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.battlepass.BattlePassProgressLevelView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.umeng.analytics.pro.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattlePassDialogFragment.class */
public final class LiveBattlePassDialogFragment extends BaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12728a = new Companion(null);
    private static boolean m;
    private static boolean n;
    public ArrayList<BattlePassBonusHistoryDataModel> b;
    private BattlePassDataModel d;
    private FreedomAdapter e;
    private FreedomAdapter g;

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f12729c = LazyKt.a(new Function0<DialogLiveBattlePassBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveBattlePassBinding invoke() {
            return DialogLiveBattlePassBinding.a(LayoutInflater.from(LiveBattlePassDialogFragment.this.getContext()));
        }
    });
    private final ArrayList<FitemBattlePassLevel> f = new ArrayList<>();
    private final ArrayList<FitemBattlePassTask> h = new ArrayList<>();
    private int i = 1;
    private final DecelerateInterpolator j = new DecelerateInterpolator(2.0f);
    private int k = -1;
    private final boolean l = true;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattlePassDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveBattlePassDialogFragment a(BaseFragment fragment) {
            Intrinsics.e(fragment, "fragment");
            LiveBattlePassDialogFragment liveBattlePassDialogFragment = new LiveBattlePassDialogFragment();
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            liveBattlePassDialogFragment.show(childFragmentManager, LiveBattlePassDialogFragment.class.getSimpleName());
            return liveBattlePassDialogFragment;
        }

        public final boolean a() {
            return LiveBattlePassDialogFragment.m;
        }
    }

    private final void a(int i) {
        final BattlePassDataModel battlePassDataModel = this.d;
        if (battlePassDataModel == null) {
            return;
        }
        if (!n) {
            c(i);
        }
        battlePassDataModel.setExp(battlePassDataModel.getExp() + i);
        if (!n) {
            if (f().E.getCallback() == null) {
                f().E.setCallback(new BattlePassProgressLevelView.LightCallBack() { // from class: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment$addExp$1$1
                    @Override // com.blued.android.module.live_china.view.battlepass.BattlePassProgressLevelView.LightCallBack
                    public void a(int i2) {
                        LiveBattlePassDialogFragment.this.e(i2);
                    }

                    @Override // com.blued.android.module.live_china.view.battlepass.BattlePassProgressLevelView.LightCallBack
                    public void a(boolean z, int i2, int i3) {
                        DialogLiveBattlePassBinding f;
                        DialogLiveBattlePassBinding f2;
                        String d;
                        DialogLiveBattlePassBinding f3;
                        DialogLiveBattlePassBinding f4;
                        ArrayList arrayList;
                        ArrayList<FitemBattlePassLevel> arrayList2;
                        DialogLiveBattlePassBinding f5;
                        DialogLiveBattlePassBinding f6;
                        DialogLiveBattlePassBinding f7;
                        DialogLiveBattlePassBinding f8;
                        f = LiveBattlePassDialogFragment.this.f();
                        f.E.setHasLightLevel(true);
                        battlePassDataModel.setLevel(i2);
                        f2 = LiveBattlePassDialogFragment.this.f();
                        TextView textView = f2.O;
                        d = LiveBattlePassDialogFragment.this.d(i2);
                        textView.setText(d);
                        f3 = LiveBattlePassDialogFragment.this.f();
                        ObjectAnimator.ofFloat(f3.O, "scaleX", 1.0f, 1.1f, 1.0f).setDuration(180L).start();
                        f4 = LiveBattlePassDialogFragment.this.f();
                        ObjectAnimator.ofFloat(f4.O, "scaleY", 1.0f, 1.1f, 1.0f).setDuration(180L).start();
                        arrayList = LiveBattlePassDialogFragment.this.f;
                        ((FitemBattlePassLevel) arrayList.get(i3)).b(i2, battlePassDataModel.getExp());
                        BattlePassDataModel battlePassDataModel2 = battlePassDataModel;
                        battlePassDataModel2.setUnlock_all_price(battlePassDataModel2.getUnlock_all_price() - battlePassDataModel.getUnlock_price());
                        arrayList2 = LiveBattlePassDialogFragment.this.f;
                        boolean z2 = false;
                        for (FitemBattlePassLevel fitemBattlePassLevel : arrayList2) {
                            if (fitemBattlePassLevel.i()) {
                                z2 = true;
                            }
                        }
                        if (LiveBattlePassDialogFragment.f12728a.a() && z2) {
                            f7 = LiveBattlePassDialogFragment.this.f();
                            LinearLayout linearLayout = f7.C;
                            Intrinsics.c(linearLayout, "vb.llBtnRoot");
                            BluedViewExKt.b(linearLayout);
                            f8 = LiveBattlePassDialogFragment.this.f();
                            ImageView imageView = f8.f11748c;
                            Intrinsics.c(imageView, "vb.btnGetAllBig");
                            BluedViewExKt.a(imageView);
                            return;
                        }
                        f5 = LiveBattlePassDialogFragment.this.f();
                        LinearLayout linearLayout2 = f5.C;
                        Intrinsics.c(linearLayout2, "vb.llBtnRoot");
                        BluedViewExKt.a(linearLayout2);
                        f6 = LiveBattlePassDialogFragment.this.f();
                        ImageView imageView2 = f6.f11748c;
                        Intrinsics.c(imageView2, "vb.btnGetAllBig");
                        BluedViewExKt.b(imageView2);
                    }
                });
            }
            b(true);
            f().E.setHasLightLevel(false);
            ObjectAnimator anim = ObjectAnimator.ofInt(f().E, at.b, f().E.getExp(), battlePassDataModel.getExp());
            anim.setDuration(600L);
            Intrinsics.c(anim, "anim");
            anim.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment$addExp$lambda-30$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    DialogLiveBattlePassBinding f;
                    Intrinsics.e(animator, "animator");
                    LiveBattlePassDialogFragment.this.b(false);
                    f = LiveBattlePassDialogFragment.this.f();
                    if (f.E.getHasLightLevel()) {
                        LiveBattlePassDialogFragment.this.a(battlePassDataModel);
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Intrinsics.e(animator, "animator");
                }
            });
            anim.start();
        }
        int exp = battlePassDataModel.getExp();
        BattlePassDataModel battlePassDataModel2 = this.d;
        Intrinsics.a(battlePassDataModel2);
        if (exp >= battlePassDataModel2.getMax_exp()) {
            n = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (r0.length() == 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0106, code lost:
        if (r0.length() == 0) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(int r7, java.util.ArrayList<com.blued.android.module.live_china.model.BattlePassTaskDataModel> r8) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment.a(int, java.util.ArrayList):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveBattlePassDialogFragment this$0, float f) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getContext() == null || this$0.a() == null || !this$0.a().isActive()) {
            return;
        }
        if (this$0.u()) {
            this$0.f().f.animate().alpha(0.0f).translationY(0 - (f * 0.3f)).setDuration(200L).setStartDelay(800L).setInterpolator(new AccelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$pvc2WHZIlMiMlOMXS9fLkYR628s
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBattlePassDialogFragment.h(LiveBattlePassDialogFragment.this);
                }
            }).start();
        } else {
            this$0.f().f.animate().alpha(0.0f).setDuration(300L).setStartDelay(800L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveBattlePassDialogFragment this$0, final float f, final float f2, final float f3) {
        float b;
        float f4;
        Intrinsics.e(this$0, "this$0");
        if (this$0.getContext() == null || this$0.a() == null || !this$0.a().isActive()) {
            return;
        }
        if (f <= f2) {
            if (this$0.u()) {
                this$0.f().f.animate().alpha(0.0f).translationY(0 - (f3 * 0.3f)).setDuration(200L).setStartDelay(1000L).setInterpolator(new AccelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$zhZIVPWfGOQKxTlxqrrgqst0geI
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveBattlePassDialogFragment.i(LiveBattlePassDialogFragment.this);
                    }
                }).start();
                return;
            } else {
                this$0.f().f.animate().alpha(0.0f).setDuration(300L).setStartDelay(800L).start();
                return;
            }
        }
        long j = 300;
        if (this$0.getContext() != null) {
            Context context = this$0.getContext();
            if ((context == null ? null : context.getResources()) == null) {
                j = 300;
            } else {
                float f5 = f - f2;
                if (f5 < f2 / 3) {
                    b = DensityUtils.b(this$0.getContext(), f5);
                    f4 = 35.0f;
                } else {
                    b = DensityUtils.b(this$0.getContext(), f5);
                    f4 = 20.0f;
                }
                j = b * f4;
            }
        }
        this$0.f().f.animate().cancel();
        final long j2 = j;
        this$0.f().f.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$veBtZVYfmf5GKVvTf4GmupYaSUQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, f, f2, j2, f3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveBattlePassDialogFragment this$0, float f, float f2, long j, final float f3) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getContext() == null || this$0.a() == null || !this$0.a().isActive()) {
            return;
        }
        this$0.f().f.animate().x(0 - (f - f2)).setDuration(j).setStartDelay(500L).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$aKe38egfY9BlAqV7XNgZ9Ki-2XY
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, f3);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveBattleShopDialog.f12741a.b(this$0);
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_TOP_ENTRANCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattlePassDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattlePassDialogFragment this$0, Object pair) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(pair, "pair");
        this$0.a(pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattlePassDialogFragment this$0, ArrayList it) {
        View c2;
        Context context;
        DialogLiveBattlePassBinding f;
        RecyclerView recyclerView;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "$it");
        if (this$0.getContext() == null || this$0.a() == null || !this$0.a().isActive()) {
            return;
        }
        int b = this$0.b(it);
        int a2 = b >= 0 ? DensityUtils.a(this$0.getContext(), 68.0f) * b : -1;
        int i = a2;
        if (a2 == -1) {
            int d = this$0.d(it);
            i = a2;
            if (d >= 0) {
                i = DensityUtils.a(this$0.getContext(), 68.0f) * d;
            }
        }
        int i2 = i;
        if (i == -1) {
            int size = it.size() - 1;
            i2 = i;
            if (size >= 0) {
                i2 = DensityUtils.a(this$0.getContext(), 68.0f) * size;
            }
        }
        if (i2 > 0 && (f = this$0.f()) != null && (recyclerView = f.I) != null) {
            recyclerView.scrollBy(i2, 0);
        }
        if (!LiveRoomPreferences.S() || (c2 = this$0.c(this$0.f)) == null || (context = this$0.getContext()) == null) {
            return;
        }
        int[] iArr = new int[2];
        c2.getLocationOnScreen(iArr);
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        if (iArr[0] + DensityUtils.a(context, 134.0f) < activity.getWindowManager().getDefaultDisplay().getWidth()) {
            new LiveBattlePassAwardClickTipPop(context, activity).b(c2);
            LiveRoomPreferences.T();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BattlePassDataModel battlePassDataModel) {
        if (!isVisible() || getHost() == null) {
            return;
        }
        for (FitemBattlePassLevel fitemBattlePassLevel : this.f) {
            if (battlePassDataModel.getExp() < fitemBattlePassLevel.f().getExp()) {
                BattlePassLevelAwardDataModel top = fitemBattlePassLevel.f().getTop();
                boolean z = false;
                if (top != null && top.getBonus() == 1) {
                    z = true;
                }
                if (z) {
                    LiveBattleNextLevelRandomAwardDialog.Companion companion = LiveBattleNextLevelRandomAwardDialog.f12725a;
                    FragmentManager childFragmentManager = getChildFragmentManager();
                    Intrinsics.c(childFragmentManager, "childFragmentManager");
                    companion.a(childFragmentManager);
                    return;
                }
                return;
            }
        }
    }

    private final void a(Object obj) {
        Pair pair = (Pair) obj;
        for (FitemBattlePassLevel fitemBattlePassLevel : this.f) {
            int level = fitemBattlePassLevel.f().getLevel();
            Integer num = (Integer) pair.first;
            if (num != null && level == num.intValue()) {
                F f = pair.first;
                Intrinsics.c(f, "pair.first");
                int intValue = ((Number) f).intValue();
                S s = pair.second;
                Intrinsics.c(s, "pair.second");
                fitemBattlePassLevel.a(intValue, ((Number) s).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        if (!z) {
            FrameLayout frameLayout = f().D;
            Intrinsics.c(frameLayout, "vb.loading");
            BluedViewExKt.a(frameLayout);
            return;
        }
        f().D.setAlpha(0.0f);
        f().D.setScaleX(0.0f);
        f().D.setScaleY(0.0f);
        FrameLayout frameLayout2 = f().D;
        Intrinsics.c(frameLayout2, "vb.loading");
        BluedViewExKt.b(frameLayout2);
        f().D.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setStartDelay(250L).start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int b(java.util.ArrayList<com.blued.android.module.live_china.model.BattlePassLevelDataModel> r4) {
        /*
            r3 = this;
            r0 = r4
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
            r0 = 0
            r5 = r0
        Lc:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L77
            r0 = r4
            java.lang.Object r0 = r0.next()
            com.blued.android.module.live_china.model.BattlePassLevelDataModel r0 = (com.blued.android.module.live_china.model.BattlePassLevelDataModel) r0
            r9 = r0
            boolean r0 = com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment.m
            r8 = r0
            r0 = 1
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L4d
            r0 = r9
            com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel r0 = r0.getTop()
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L3e
        L39:
            r0 = 0
            r6 = r0
            goto L49
        L3e:
            r0 = r10
            int r0 = r0.getState()
            r1 = 2
            if (r0 != r1) goto L39
            r0 = 1
            r6 = r0
        L49:
            r0 = r6
            if (r0 != 0) goto L6e
        L4d:
            r0 = r9
            com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel r0 = r0.getBasic()
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L5e
        L59:
            r0 = 0
            r6 = r0
            goto L6a
        L5e:
            r0 = r9
            int r0 = r0.getState()
            r1 = 2
            if (r0 != r1) goto L59
            r0 = r7
            r6 = r0
        L6a:
            r0 = r6
            if (r0 == 0) goto L70
        L6e:
            r0 = r5
            return r0
        L70:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto Lc
        L77:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment.b(java.util.ArrayList):int");
    }

    private final void b(int i) {
        ArrayList<BattlePassTaskDataModel> week_task;
        ArrayList<BattlePassTaskDataModel> daily_task;
        BattlePassDataModel battlePassDataModel = this.d;
        if (battlePassDataModel != null && (daily_task = battlePassDataModel.getDaily_task()) != null) {
            for (BattlePassTaskDataModel battlePassTaskDataModel : daily_task) {
                if (battlePassTaskDataModel.getId() == i) {
                    battlePassTaskDataModel.setState(3);
                }
            }
        }
        BattlePassDataModel battlePassDataModel2 = this.d;
        if (battlePassDataModel2 != null && (week_task = battlePassDataModel2.getWeek_task()) != null) {
            for (BattlePassTaskDataModel battlePassTaskDataModel2 : week_task) {
                if (battlePassTaskDataModel2.getId() == i) {
                    battlePassTaskDataModel2.setState(3);
                }
            }
        }
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != null) {
            BattlePassDataModel battlePassDataModel = this$0.d;
            Intrinsics.a(battlePassDataModel);
            LiveBattleShopDialog.f12741a.a(this$0, battlePassDataModel.getDesc_pic_url());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBattlePassDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(BattlePassDataModel battlePassDataModel) {
        this.d = battlePassDataModel;
        f().R.setText(battlePassDataModel.getDuration_desc());
        boolean z = false;
        m = battlePassDataModel.getTop_unlocked() == 1;
        ArrayList<BattlePassLevelDataModel> levels = battlePassDataModel.getLevels();
        if (levels != null) {
            battlePassDataModel.setMax_exp(levels.get(levels.size() - 1).getExp());
            n = battlePassDataModel.getExp() >= battlePassDataModel.getMax_exp();
        }
        if (m) {
            RelativeLayout relativeLayout = f().G;
            Intrinsics.c(relativeLayout, "vb.rlBuyBattlePassPro");
            BluedViewExKt.a(relativeLayout);
        } else {
            ImageLoader.c(a(), "live_battle_box.png").g().g(-1).a(f().v);
            ImageLoader.c(a(), "live_battle_box_buy_btn.png").g().g(-1).a(f().f11747a);
            RelativeLayout relativeLayout2 = f().G;
            Intrinsics.c(relativeLayout2, "vb.rlBuyBattlePassPro");
            BluedViewExKt.b(relativeLayout2);
        }
        f().O.setText(d(battlePassDataModel.getLevel()));
        e(battlePassDataModel.getExp());
        ArrayList<BattlePassLevelDataModel> levels2 = battlePassDataModel.getLevels();
        if (levels2 != null) {
            int i = 0;
            z = false;
            for (BattlePassLevelDataModel battlePassLevelDataModel : levels2) {
                battlePassLevelDataModel.setPriorExp(i);
                int exp = battlePassLevelDataModel.getExp();
                this.f.add(new FitemBattlePassLevel(this, battlePassLevelDataModel));
                BattlePassLevelAwardDataModel top = battlePassLevelDataModel.getTop();
                i = exp;
                if (top != null && top.getState() == 1) {
                    z = true;
                    i = exp;
                }
            }
            f().E.a(levels2, battlePassDataModel.getExp());
            p();
        }
        if (m && z) {
            LinearLayout linearLayout = f().C;
            Intrinsics.c(linearLayout, "vb.llBtnRoot");
            BluedViewExKt.b(linearLayout);
            ImageView imageView = f().f11748c;
            Intrinsics.c(imageView, "vb.btnGetAllBig");
            BluedViewExKt.a(imageView);
        } else {
            LinearLayout linearLayout2 = f().C;
            Intrinsics.c(linearLayout2, "vb.llBtnRoot");
            BluedViewExKt.a(linearLayout2);
            ImageView imageView2 = f().f11748c;
            Intrinsics.c(imageView2, "vb.btnGetAllBig");
            BluedViewExKt.b(imageView2);
        }
        ArrayList<BattlePassTaskDataModel> daily_task = battlePassDataModel.getDaily_task();
        if (daily_task != null) {
            a(1, daily_task);
        }
        final ArrayList<BattlePassLevelDataModel> levels3 = battlePassDataModel.getLevels();
        if (levels3 != null) {
            DialogLiveBattlePassBinding f = f();
            (f == null ? null : f.I).post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$mxtqVua-hUwldLBdTiYNlC0nPwI
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, levels3);
                }
            });
        }
        e(battlePassDataModel.getBonus_history());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        if (!z) {
            FrameLayout frameLayout = f().D;
            Intrinsics.c(frameLayout, "vb.loading");
            BluedViewExKt.a(frameLayout);
            return;
        }
        f().D.setAlpha(0.0f);
        f().D.setScaleX(0.0f);
        f().D.setScaleY(0.0f);
        FrameLayout frameLayout2 = f().D;
        Intrinsics.c(frameLayout2, "vb.loading");
        BluedViewExKt.b(frameLayout2);
    }

    private final View c(ArrayList<FitemBattlePassLevel> arrayList) {
        View k;
        RecyclerView.LayoutManager layoutManager = f().I.getLayoutManager();
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        int findFirstCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        RecyclerView.LayoutManager layoutManager2 = f().I.getLayoutManager();
        if (layoutManager2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition();
        if (findFirstCompletelyVisibleItemPosition > findLastCompletelyVisibleItemPosition) {
            return null;
        }
        while (true) {
            if (findFirstCompletelyVisibleItemPosition >= 0 && findFirstCompletelyVisibleItemPosition < arrayList.size()) {
                FitemBattlePassLevel fitemBattlePassLevel = arrayList.get(findFirstCompletelyVisibleItemPosition);
                Intrinsics.c(fitemBattlePassLevel, "levels[i]");
                FitemBattlePassLevel fitemBattlePassLevel2 = fitemBattlePassLevel;
                BattlePassLevelAwardDataModel basic = fitemBattlePassLevel2.f().getBasic();
                if (!(basic != null && basic.getState() == 2) && (k = fitemBattlePassLevel2.k()) != null) {
                    return k;
                }
            }
            if (findFirstCompletelyVisibleItemPosition == findLastCompletelyVisibleItemPosition) {
                return null;
            }
            findFirstCompletelyVisibleItemPosition++;
        }
    }

    private final void c(int i) {
        int i2;
        int i3;
        BattlePassDataModel battlePassDataModel = this.d;
        if (battlePassDataModel == null) {
            return;
        }
        ArrayList<BattlePassLevelDataModel> levels = battlePassDataModel.getLevels();
        if (levels != null) {
            Iterator<BattlePassLevelDataModel> it = levels.iterator();
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (!it.hasNext()) {
                    break;
                }
                if (battlePassDataModel.getExp() + i >= it.next().getExp()) {
                    i4++;
                }
            }
        } else {
            i2 = 0;
        }
        if (i2 <= 0 || battlePassDataModel.getLevel() == i2) {
            return;
        }
        int i5 = i2 - 1;
        RecyclerView.LayoutManager layoutManager = f().I.getLayoutManager();
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            int i6 = (findLastVisibleItemPosition - findFirstVisibleItemPosition) / 2;
            int i7 = i6;
            if (i6 <= 0) {
                i7 = 1;
            }
            if (i5 <= findFirstVisibleItemPosition) {
                i3 = i5 - i7;
                if (i3 < 0) {
                    i3 = 0;
                }
                RecyclerView.LayoutManager layoutManager2 = f().I.getLayoutManager();
                if (layoutManager2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.utils.BattlePassLinearLayoutManger");
                }
                ((BattlePassLinearLayoutManger) layoutManager2).b();
            } else if (i5 - 1 <= findLastVisibleItemPosition) {
                i3 = i5 + i7;
                if (i3 < 0) {
                    i3 = 0;
                }
                RecyclerView.LayoutManager layoutManager3 = f().I.getLayoutManager();
                if (layoutManager3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.utils.BattlePassLinearLayoutManger");
                }
                ((BattlePassLinearLayoutManger) layoutManager3).a();
            } else {
                i3 = i5 + i7;
                ArrayList<BattlePassLevelDataModel> levels2 = battlePassDataModel.getLevels();
                Intrinsics.a(levels2);
                if (i3 > levels2.size() - 1) {
                    ArrayList<BattlePassLevelDataModel> levels3 = battlePassDataModel.getLevels();
                    Intrinsics.a(levels3);
                    i3 = levels3.size() - 1;
                }
                RecyclerView.LayoutManager layoutManager4 = f().I.getLayoutManager();
                if (layoutManager4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.utils.BattlePassLinearLayoutManger");
                }
                ((BattlePassLinearLayoutManger) layoutManager4).b();
            }
            f().I.smoothScrollToPosition(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveBattlePassDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getContext() == null || this$0.a() == null || !this$0.a().isActive()) {
            return;
        }
        float width = this$0.f().o.getWidth() / 375.0f;
        ViewGroup.LayoutParams layoutParams = this$0.f().F.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i = (int) (width * 10.0f);
        layoutParams2.leftMargin = i;
        layoutParams2.rightMargin = i;
        this$0.f().F.setLayoutParams(layoutParams2);
        int a2 = DensityUtils.a(this$0.getContext(), 12.0f);
        ViewGroup.LayoutParams layoutParams3 = this$0.f().j.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        int i2 = i + a2;
        layoutParams4.leftMargin = i2;
        layoutParams4.rightMargin = i2;
        this$0.f().j.setLayoutParams(layoutParams4);
        this$0.f().O.getPaint().setFakeBoldText(true);
        this$0.h();
        this$0.r();
        this$0.i();
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != null) {
            BattlePassDataModel battlePassDataModel = this$0.d;
            Intrinsics.a(battlePassDataModel);
            LiveBattleShopDialog.f12741a.b(this$0, 1, battlePassDataModel.getUnlock_price());
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_PRE_UNLOCK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveBattlePassDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        if (num == null) {
            return;
        }
        this$0.a(num.intValue());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
        if ((r0 != null && r0.getState() == 1) == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int d(java.util.ArrayList<com.blued.android.module.live_china.model.BattlePassLevelDataModel> r4) {
        /*
            r3 = this;
            r0 = r3
            com.blued.android.module.live_china.model.BattlePassDataModel r0 = r0.d
            r9 = r0
            r0 = r9
            if (r0 != 0) goto Le
            goto L92
        Le:
            r0 = r4
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r4 = r0
            r0 = 0
            r5 = r0
        L1a:
            r0 = r4
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L92
            r0 = r4
            java.lang.Object r0 = r0.next()
            com.blued.android.module.live_china.model.BattlePassLevelDataModel r0 = (com.blued.android.module.live_china.model.BattlePassLevelDataModel) r0
            r10 = r0
            boolean r0 = com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment.m
            r8 = r0
            r0 = 1
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L5b
            r0 = r10
            com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel r0 = r0.getTop()
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L4c
        L47:
            r0 = 0
            r6 = r0
            goto L57
        L4c:
            r0 = r11
            int r0 = r0.getState()
            r1 = 1
            if (r0 != r1) goto L47
            r0 = 1
            r6 = r0
        L57:
            r0 = r6
            if (r0 != 0) goto L7c
        L5b:
            r0 = r10
            com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel r0 = r0.getBasic()
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L6c
        L67:
            r0 = 0
            r6 = r0
            goto L78
        L6c:
            r0 = r11
            int r0 = r0.getState()
            r1 = 1
            if (r0 != r1) goto L67
            r0 = r7
            r6 = r0
        L78:
            r0 = r6
            if (r0 == 0) goto L8b
        L7c:
            r0 = r9
            int r0 = r0.getExp()
            r1 = r10
            int r1 = r1.getExp()
            if (r0 >= r1) goto L8b
            r0 = r5
            return r0
        L8b:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            goto L1a
        L92:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment.d(java.util.ArrayList):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(int i) {
        return i < 10 ? Intrinsics.a("LV.0", (Object) Integer.valueOf(i)) : Intrinsics.a("LV.", (Object) Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveBattlePassDialogFragment this$0) {
        ArrayList<BattlePassTaskDataModel> daily_task;
        Intrinsics.e(this$0, "this$0");
        BattlePassDataModel battlePassDataModel = this$0.d;
        if (battlePassDataModel != null && (daily_task = battlePassDataModel.getDaily_task()) != null) {
            this$0.a(1, daily_task);
        }
        this$0.f().J.setTranslationX(-(this$0.f().J.getWidth() / 10));
        this$0.f().J.animate().alpha(1.0f).translationX(0.0f).setDuration(150L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.d != null) {
            BattlePassDataModel battlePassDataModel = this$0.d;
            Intrinsics.a(battlePassDataModel);
            LiveBattleShopDialog.f12741a.b(this$0, 2, battlePassDataModel.getUnlock_all_price());
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_ALL_UNLOCK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveBattlePassDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        if (num == null) {
            return;
        }
        this$0.b(num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int i) {
        BattlePassDataModel battlePassDataModel = this.d;
        if (battlePassDataModel == null) {
            return;
        }
        if (i < battlePassDataModel.getMax_exp()) {
            f().N.setText(String.valueOf(i));
        } else if (Intrinsics.a((Object) f().N.getText(), (Object) "max")) {
        } else {
            f().N.setText("max");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveBattlePassDialogFragment this$0) {
        ArrayList<BattlePassTaskDataModel> week_task;
        Intrinsics.e(this$0, "this$0");
        BattlePassDataModel battlePassDataModel = this$0.d;
        if (battlePassDataModel != null && (week_task = battlePassDataModel.getWeek_task()) != null) {
            this$0.a(2, week_task);
        }
        this$0.f().J.setTranslationX(this$0.f().J.getWidth() / 10);
        this$0.f().J.animate().alpha(1.0f).translationX(0.0f).setDuration(150L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveBattlePassDialogFragment this$0, Integer num) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismiss();
    }

    private final void e(ArrayList<BattlePassBonusHistoryDataModel> arrayList) {
        ArrayList<BattlePassBonusHistoryDataModel> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            FrameLayout frameLayout = f().h;
            Intrinsics.c(frameLayout, "vb.flBonusHistoryContent");
            BluedViewExKt.a(frameLayout);
            ImageLoader.a(a(), ImgURLMap.f10885a.a("live_battle_pass_bonus_history_star")).a(f().r);
            ImageLoader.a(a(), ImgURLMap.f10885a.a("live_battle_pass_bonus_history_star")).a(f().s);
            FrameLayout frameLayout2 = f().i;
            Intrinsics.c(frameLayout2, "vb.flBonusHistoryEmpty");
            BluedViewExKt.b(frameLayout2);
            f().j.animate().cancel();
            f().j.setAlpha(0.0f);
            f().j.animate().alpha(1.0f).setDuration(300L).setStartDelay(0L).start();
            return;
        }
        a(arrayList);
        this.k = -1;
        FrameLayout frameLayout3 = f().i;
        Intrinsics.c(frameLayout3, "vb.flBonusHistoryEmpty");
        BluedViewExKt.a(frameLayout3);
        f().j.animate().cancel();
        f().j.setAlpha(0.0f);
        FrameLayout frameLayout4 = f().h;
        Intrinsics.c(frameLayout4, "vb.flBonusHistoryContent");
        BluedViewExKt.b(frameLayout4);
        ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("live_battle_pass_bonus_history_tag")).a(f().t);
        t();
        f().j.animate().alpha(1.0f).setDuration(300L).setStartDelay(0L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveBattlePassBinding f() {
        return (DialogLiveBattlePassBinding) this.f12729c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final LiveBattlePassDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        final ActivityFragmentActive a2 = this$0.a();
        LiveRoomHttpUtils.x(new BluedUIHttpResponse<BluedEntity<BattlePassDataModel, ?>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment$getData$1$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveBattlePassDialogFragment.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BattlePassDataModel, ?> entity) {
                Intrinsics.e(entity, "entity");
                BattlePassDataModel singleData = entity.getSingleData();
                if (singleData == null) {
                    return;
                }
                LiveBattlePassDialogFragment.this.b(singleData);
            }
        }, this$0.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.n();
    }

    private final void g() {
        f().o.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$PxJXX_eQ6pvkBw7oLf2xchbOW-8
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.c(LiveBattlePassDialogFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveBattlePassDialogFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.e(this$0, "this$0");
        DialogLiveBattlePassBinding f = this$0.f();
        if (f == null || (recyclerView = f.J) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    private final void h() {
        RecyclerView recyclerView;
        DialogLiveBattlePassBinding f = f();
        if (f == null || (recyclerView = f.I) == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.fragment.LiveBattlePassDialogFragment$initRecyclerScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recycler, int i, int i2) {
                DialogLiveBattlePassBinding f2;
                Intrinsics.e(recycler, "recycler");
                super.onScrolled(recycler, i, i2);
                f2 = LiveBattlePassDialogFragment.this.f();
                f2.n.scrollBy(i, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LiveBattlePassDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LiveBattlePassDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.l();
    }

    private final void i() {
        f().G.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$J7CpFuEV2eIytbBkBRjPRJutqH4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().x.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$dpp4AVsju-t-WjfuqNa_hmhYQUI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.b(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$QykByq9wGU00PU319I7rnALytP0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.c(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$mQQffSG5AyWkdJWoUIa_sXPQ8E0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.d(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$m1SEz7ositKeidH2Q2rWZvWRY_I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.e(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().f11748c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$8Nl2DX-HQdUYtMrzYNf-TzxuwhQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.f(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().y.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$D1SAbJZXrS6is8VrvxXQAIEeQpE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.g(LiveBattlePassDialogFragment.this, view);
            }
        });
        f().z.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$85Hko0wX2qkKcDDUCCMRqvWNFHA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattlePassDialogFragment.h(LiveBattlePassDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LiveBattlePassDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.t();
    }

    private final void j() {
        LiveBattlePassDialogFragment liveBattlePassDialogFragment = this;
        LiveEventBus.get(LiveEventBusUtil.E, Integer.TYPE).observe(liveBattlePassDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$a6NNPHDYONDcmvSFxMlE2Bb9Uc8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.F, Pair.class).observe(liveBattlePassDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$OmffMCveypPy43cO9ZxZa7Tzca0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, (Pair) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.G, Integer.TYPE).observe(liveBattlePassDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$7gj-xwT77nuwU844nDhZePXfpwM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBattlePassDialogFragment.b(LiveBattlePassDialogFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.H, Integer.TYPE).observe(liveBattlePassDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$_JxE96iaPKiClC3QuhwjUSwBa08
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBattlePassDialogFragment.c(LiveBattlePassDialogFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.I, Integer.TYPE).observe(liveBattlePassDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$IUpznPyEj2uy1RhJQbdlIon8HPE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBattlePassDialogFragment.d(LiveBattlePassDialogFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get(LiveEventBusUtil.J, Integer.TYPE).observe(liveBattlePassDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$YEE9BHExsSLYl_0yD79j1ACrV-w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBattlePassDialogFragment.e(LiveBattlePassDialogFragment.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final LiveBattlePassDialogFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        final float width = this$0.f().f.getWidth();
        final float height = this$0.f().f.getHeight();
        final float width2 = this$0.f().g.getWidth();
        this$0.f().f.setAlpha(0.0f);
        this$0.f().f.setTranslationX(0.0f);
        this$0.f().f.setTranslationY(0.3f * height);
        this$0.f().f.animate().alpha(1.0f).translationY(0.0f).setDuration(200L).setStartDelay(0L).setInterpolator(new DecelerateInterpolator(1.5f)).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$b2eulHpDcsA4aW8SxW3nzuy1ri0
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.a(LiveBattlePassDialogFragment.this, width, width2, height);
            }
        }).start();
    }

    private final void k() {
        if (this.i == 1) {
            return;
        }
        this.i = 1;
        f().S.animate().scaleY(1.0f).setDuration(300L).setInterpolator(this.j).start();
        f().T.animate().scaleY(0.0f).setDuration(300L).setInterpolator(this.j).start();
        f().J.animate().alpha(0.0f).translationX(f().J.getWidth() / 10).setDuration(150L).setInterpolator(this.j).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$3Buqys43UQ0VI-nhzNvpz_TvwAQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.d(LiveBattlePassDialogFragment.this);
            }
        }).start();
    }

    private final void l() {
        if (this.i == 2) {
            return;
        }
        this.i = 2;
        f().T.animate().scaleY(1.0f).setDuration(300L).setInterpolator(this.j).start();
        f().S.animate().scaleY(0.0f).setDuration(300L).setInterpolator(this.j).start();
        f().J.animate().alpha(0.0f).translationX(-(f().J.getWidth() / 10)).setDuration(150L).setInterpolator(this.j).withEndAction(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$GdbDqMD9P1YRzxrPP51IYDqaszs
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.e(LiveBattlePassDialogFragment.this);
            }
        }).start();
    }

    private final void m() {
        BattlePassDataModel battlePassDataModel = this.d;
        if (battlePassDataModel != null) {
            battlePassDataModel.setTop_unlocked(1);
        }
        m = true;
        RelativeLayout relativeLayout = f().G;
        Intrinsics.c(relativeLayout, "vb.rlBuyBattlePassPro");
        BluedViewExKt.a(relativeLayout);
        boolean z = false;
        for (FitemBattlePassLevel fitemBattlePassLevel : this.f) {
            if (fitemBattlePassLevel.i()) {
                z = true;
            }
            int level = fitemBattlePassLevel.f().getLevel();
            BattlePassDataModel battlePassDataModel2 = this.d;
            Intrinsics.a(battlePassDataModel2);
            if (level > battlePassDataModel2.getLevel() || !fitemBattlePassLevel.g()) {
                fitemBattlePassLevel.c(fitemBattlePassLevel.f().getLevel());
            } else {
                BattlePassDataModel battlePassDataModel3 = this.d;
                Intrinsics.a(battlePassDataModel3);
                fitemBattlePassLevel.b(battlePassDataModel3.getLevel());
            }
        }
        if (m && z) {
            LinearLayout linearLayout = f().C;
            Intrinsics.c(linearLayout, "vb.llBtnRoot");
            BluedViewExKt.b(linearLayout);
            ImageView imageView = f().f11748c;
            Intrinsics.c(imageView, "vb.btnGetAllBig");
            BluedViewExKt.a(imageView);
            return;
        }
        LinearLayout linearLayout2 = f().C;
        Intrinsics.c(linearLayout2, "vb.llBtnRoot");
        BluedViewExKt.a(linearLayout2);
        ImageView imageView2 = f().f11748c;
        Intrinsics.c(imageView2, "vb.btnGetAllBig");
        BluedViewExKt.b(imageView2);
    }

    private final void n() {
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_ALL_RECEIVE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        boolean z = false;
        boolean z2 = false;
        for (FitemBattlePassLevel fitemBattlePassLevel : this.f) {
            boolean z3 = z;
            if (fitemBattlePassLevel.h()) {
                z3 = true;
            }
            z = z3;
            if (fitemBattlePassLevel.j()) {
                z2 = true;
                z = z3;
            }
        }
        if (!z) {
            ToastUtils.b("你已领取全部奖励！");
        } else if (z2) {
            LiveBattleShopDialog.f12741a.a(this);
        } else {
            ToastUtils.b("暂无奖励可领取，快去做任务吧！");
        }
    }

    private final void o() {
        boolean z = false;
        for (FitemBattlePassLevel fitemBattlePassLevel : this.f) {
            if (fitemBattlePassLevel.j()) {
                z = true;
            }
        }
        if (z) {
            for (FitemBattlePassLevel fitemBattlePassLevel2 : this.f) {
                fitemBattlePassLevel2.d(fitemBattlePassLevel2.f().getLevel());
            }
        }
    }

    private final void p() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        if (getContext() == null || a() == null || !a().isActive()) {
            return;
        }
        FreedomAdapter freedomAdapter = this.e;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.e = new FreedomAdapter(getContext(), a(), this.f);
        DialogLiveBattlePassBinding f = f();
        RecyclerView recyclerView3 = f == null ? null : f.I;
        if (recyclerView3 != null) {
            Context requireContext = requireContext();
            Intrinsics.c(requireContext, "requireContext()");
            recyclerView3.setLayoutManager(new BattlePassLinearLayoutManger(requireContext, 0, false));
        }
        DialogLiveBattlePassBinding f2 = f();
        RecyclerView.LayoutManager layoutManager = (f2 == null || (recyclerView = f2.I) == null) ? null : recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.utils.BattlePassLinearLayoutManger");
        }
        ((BattlePassLinearLayoutManger) layoutManager).a();
        DialogLiveBattlePassBinding f3 = f();
        RecyclerView recyclerView4 = f3 == null ? null : f3.I;
        if (recyclerView4 != null) {
            recyclerView4.setItemAnimator(new DefaultItemAnimator());
        }
        DialogLiveBattlePassBinding f4 = f();
        RecyclerView recyclerView5 = f4 == null ? null : f4.I;
        if (recyclerView5 != null) {
            recyclerView5.setAdapter(this.e);
        }
        DialogLiveBattlePassBinding f5 = f();
        if (f5 == null || (recyclerView2 = f5.I) == null || (animate = recyclerView2.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(300L)) == null) {
            return;
        }
        duration.start();
    }

    private final void q() {
        if (getContext() == null || a() == null || !a().isActive()) {
            return;
        }
        FreedomAdapter freedomAdapter = this.g;
        if (freedomAdapter == null) {
            this.g = new FreedomAdapter(getContext(), a(), this.h);
            DialogLiveBattlePassBinding f = f();
            RecyclerView recyclerView = f == null ? null : f.J;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
            DialogLiveBattlePassBinding f2 = f();
            RecyclerView recyclerView2 = f2 == null ? null : f2.J;
            if (recyclerView2 != null) {
                recyclerView2.setItemAnimator(new DefaultItemAnimator());
            }
            DialogLiveBattlePassBinding f3 = f();
            RecyclerView recyclerView3 = f3 == null ? null : f3.J;
            if (recyclerView3 != null) {
                recyclerView3.setAdapter(this.g);
            }
        } else if (freedomAdapter != null) {
            freedomAdapter.notifyDataSetChanged();
        }
        s();
    }

    private final void r() {
        a(true);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$kazsIGnwYWvMS-eRCtEf3ZvZa2Q
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattlePassDialogFragment.f(LiveBattlePassDialogFragment.this);
            }
        }, 150L);
    }

    private final void s() {
        boolean z;
        boolean z2;
        ArrayList<BattlePassTaskDataModel> week_task;
        ArrayList<BattlePassTaskDataModel> daily_task;
        BattlePassDataModel battlePassDataModel = this.d;
        if (battlePassDataModel != null && (daily_task = battlePassDataModel.getDaily_task()) != null) {
            Iterator<BattlePassTaskDataModel> it = daily_task.iterator();
            boolean z3 = false;
            while (true) {
                z = z3;
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getState() == 2) {
                    z3 = true;
                }
            }
        } else {
            z = false;
        }
        if (z || f().A.getVisibility() != 0) {
            f().A.setVisibility(z ? 0 : 8);
        } else {
            f().A.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).start();
        }
        BattlePassDataModel battlePassDataModel2 = this.d;
        if (battlePassDataModel2 != null && (week_task = battlePassDataModel2.getWeek_task()) != null) {
            Iterator<BattlePassTaskDataModel> it2 = week_task.iterator();
            boolean z4 = false;
            while (true) {
                z2 = z4;
                if (!it2.hasNext()) {
                    break;
                } else if (it2.next().getState() == 2) {
                    z4 = true;
                }
            }
        } else {
            z2 = false;
        }
        if (z2 || f().B.getVisibility() != 0) {
            f().B.setVisibility(z2 ? 0 : 8);
        } else {
            f().B.animate().scaleX(0.0f).scaleY(0.0f).setDuration(300L).start();
        }
    }

    private final void t() {
        if (getContext() == null || a() == null || !a().isActive()) {
            return;
        }
        if (v()) {
            f().g.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattlePassDialogFragment$26fKjnT3T_Z3EbECchc1rsfvOHQ
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBattlePassDialogFragment.j(LiveBattlePassDialogFragment.this);
                }
            });
        } else {
            f().j.animate().alpha(0.0f).setDuration(300L).setStartDelay(0L).start();
        }
    }

    private final boolean u() {
        ArrayList<BattlePassBonusHistoryDataModel> d = d();
        if ((d == null ? null : (BattlePassBonusHistoryDataModel) CollectionsKt.c((List<? extends Object>) d, this.k)) == null) {
            if (this.l) {
                this.k = 0;
                return true;
            }
            return false;
        }
        return true;
    }

    private final boolean v() {
        ArrayList<BattlePassBonusHistoryDataModel> d = d();
        if (d == null || d.isEmpty()) {
            return false;
        }
        this.k = CollectionsKt.c((List<? extends Object>) d(), this.k + 1) == null ? 0 : this.k + 1;
        BattlePassBonusHistoryDataModel battlePassBonusHistoryDataModel = (BattlePassBonusHistoryDataModel) CollectionsKt.c((List<? extends Object>) d(), this.k);
        if (battlePassBonusHistoryDataModel == null) {
            return false;
        }
        f().K.setText(AppInfo.d().getString(R.string.live_battle_bonus_history, LiveCloakingUtil.a(battlePassBonusHistoryDataModel.getName(), battlePassBonusHistoryDataModel.is_hide()), String.valueOf(battlePassBonusHistoryDataModel.getLevel())));
        f().K.setText(LiveUtils.a(f().K.getText(), "#00E4FF", false));
        ImageLoader.a((IRequestHost) null, battlePassBonusHistoryDataModel.getIcon()).a(f().u);
        if (battlePassBonusHistoryDataModel.getCount() <= 1) {
            f().L.setText(battlePassBonusHistoryDataModel.getGoods_name());
            return true;
        }
        TextView textView = f().L;
        textView.setText(battlePassBonusHistoryDataModel.getGoods_name() + " x" + battlePassBonusHistoryDataModel.getCount());
        return true;
    }

    public final void a(ArrayList<BattlePassBonusHistoryDataModel> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.b = arrayList;
    }

    public final ArrayList<BattlePassBonusHistoryDataModel> d() {
        ArrayList<BattlePassBonusHistoryDataModel> arrayList = this.b;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.c("mBonusHistoryData");
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 540.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(f().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(f().getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        g();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
            EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
