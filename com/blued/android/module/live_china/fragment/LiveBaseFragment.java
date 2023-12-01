package com.blued.android.module.live_china.fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.blued.android.chat.data.EntranceData;
import com.blued.android.chat.data.JoinLiveResult;
import com.blued.android.chat.data.ProfileData;
import com.blued.android.chat.listener.LiveChatInfoListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveMakeLoverOkDialogFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveGiftScrawlPlayView;
import com.blued.android.module.live_china.model.GrabBoxModel;
import com.blued.android.module.live_china.model.LiveChattingModel;
import com.blued.android.module.live_china.model.LiveFriendModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftScrawlTransModel;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.view.BubbleLayout;
import com.blued.android.module.live_china.view.LiveActivityView;
import com.blued.android.module.live_china.view.LiveBunchLightView;
import com.blued.android.module.live_china.view.LiveMakeFriendManageView;
import com.blued.android.module.live_china.view.LiveShoutCardStatusView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBaseFragment.class */
public abstract class LiveBaseFragment extends KeyBoardFragment implements LiveChatInfoListener {
    public LiveBunchLightView A;
    private Vibrator F;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public BubbleLayout f12722c;
    public LottieAnimationView j;
    public LiveMakeFriendManageView k;
    public LiveMakeLoverOkDialogFragment l;
    public LiveActivityView m;
    public View n;
    protected LiveShoutCardStatusView o;
    protected LiveGiftScrawlPlayView p;
    public View q;
    protected Bundle r;
    public long t;
    public boolean v;
    public int w;
    public boolean x;
    public boolean z;
    private ConcurrentLinkedQueue<LiveGiftScrawlTransModel> E = new ConcurrentLinkedQueue<>();
    public short s = 4;
    protected boolean u = false;
    public boolean y = false;
    ValueAnimator B = null;
    int C = 0;
    int D = 0;

    /* renamed from: com.blued.android.module.live_china.fragment.LiveBaseFragment$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBaseFragment$2.class */
    class AnonymousClass2 implements LiveMakeLoverOkDialogFragment.IDialogEvent {
        AnonymousClass2() {
        }

        @Override // com.blued.android.module.live_china.fragment.LiveMakeLoverOkDialogFragment.IDialogEvent
        public void a() {
            LiveBaseFragment.this.t();
            LiveBaseFragment.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LinearLayout.LayoutParams layoutParams, ValueAnimator valueAnimator) {
        if (getActivity() != null) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            layoutParams.bottomMargin = intValue;
            this.m.setLayoutParams(layoutParams);
            this.C = intValue;
            return;
        }
        ValueAnimator valueAnimator2 = this.B;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.B.mo53clone();
            this.B = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(LiveMakeLoverFansModel liveMakeLoverFansModel, LiveMakeLoverFansModel liveMakeLoverFansModel2, File file, Exception exc) {
        if (file != null) {
            a(liveMakeLoverFansModel, liveMakeLoverFansModel2, file.getPath(), false);
        } else {
            a(liveMakeLoverFansModel, liveMakeLoverFansModel2, "", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i) {
        if (getActivity() == null || getContext() == null) {
            return;
        }
        final LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
        int i2 = this.C;
        int i3 = i2;
        if (i2 <= 0) {
            i3 = layoutParams.bottomMargin;
        }
        int a2 = DisplayUtil.a(getContext(), 53.0f);
        int i4 = i;
        if (i > a2) {
            i4 = i - a2;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, i4);
        this.B = ofInt;
        ofInt.setDuration(300L);
        this.B.setInterpolator(new DecelerateInterpolator(1.5f));
        this.B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBaseFragment$rnTstFSnqKyaQfoTsG8hJhH9OjY
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveBaseFragment.this.a(layoutParams, valueAnimator);
            }
        });
        this.B.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        if (getFragmentActive() == null || !getFragmentActive().isActive() || this.E.isEmpty()) {
            return;
        }
        this.p.setData(this.E.poll());
    }

    public abstract void I_();

    public int M_() {
        return this.w;
    }

    public void N_() {
        if (TypeUtils.a((List<?>) LiveRoomManager.a().p().activity)) {
            g_(8);
        } else {
            this.m.setData(LiveRoomManager.a().p().activity);
            if (!PlayingOnliveFragment.aa) {
                g_(0);
            }
        }
        if (this.x || this.y) {
            g_(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
    }

    public void a(final LiveMakeLoverFansModel liveMakeLoverFansModel, final LiveMakeLoverFansModel liveMakeLoverFansModel2, String str) {
        LiveMakeLoverOkDialogFragment liveMakeLoverOkDialogFragment = this.l;
        if (liveMakeLoverOkDialogFragment != null && liveMakeLoverOkDialogFragment.isVisible()) {
            this.l.dismiss();
        }
        if (TextUtils.isEmpty(str)) {
            a(liveMakeLoverFansModel, liveMakeLoverFansModel2, "", false);
        } else {
            ImageFileLoader.a(getFragmentActive()).a(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBaseFragment$dG0EyI1sI1PezApui2aJuVjQFNo
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public final void onUIFinish(File file, Exception exc) {
                    LiveBaseFragment.this.a(liveMakeLoverFansModel, liveMakeLoverFansModel2, file, exc);
                }
            }).a();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public void a(LiveMakeLoverFansModel liveMakeLoverFansModel, LiveMakeLoverFansModel liveMakeLoverFansModel2, String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public abstract void a(String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a_(LiveChattingModel liveChattingModel);

    public abstract void a_(List<LiveFriendModel> list);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a_(LiveGiftModel liveGiftModel) {
        if (liveGiftModel != null && liveGiftModel.vibrate_status == 1 && LiveDataManager.a().j()) {
            if (this.F == null) {
                this.F = (Vibrator) AppInfo.d().getSystemService(Context.VIBRATOR_SERVICE);
            }
            this.F.vibrate(400L);
            return true;
        }
        return false;
    }

    public void b(List<GrabBoxModel> list) {
    }

    public void b_(LiveChattingModel liveChattingModel) {
        if (liveChattingModel == null || !(liveChattingModel instanceof LiveChattingModel)) {
            return;
        }
        Object objExtra = LiveChattingModel.copy(liveChattingModel).getObjExtra();
        if (objExtra instanceof LiveGiftScrawlTransModel) {
            LiveGiftScrawlTransModel liveGiftScrawlTransModel = (LiveGiftScrawlTransModel) objExtra;
            if (liveGiftScrawlTransModel.goods == null || liveGiftScrawlTransModel.goods.size() <= 0) {
                return;
            }
            if (this.p.a()) {
                this.E.offer(liveGiftScrawlTransModel);
            } else if (this.E.isEmpty()) {
                this.p.setData(liveGiftScrawlTransModel);
            } else {
                this.p.setData(this.E.poll());
                this.E.offer(liveGiftScrawlTransModel);
            }
        }
    }

    public abstract void c(String str);

    public void c_(int i) {
        BubbleLayout bubbleLayout;
        if (!p() || (bubbleLayout = this.f12722c) == null) {
            return;
        }
        bubbleLayout.a(false, i);
    }

    public void d(String str) {
        if (this.v) {
            return;
        }
        this.j.setVisibility(0);
        this.j.a(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.fragment.LiveBaseFragment.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                LiveBaseFragment.this.v = false;
                LiveBaseFragment.this.j.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LiveBaseFragment.this.v = true;
            }
        });
        this.j.a();
    }

    public void d_(int i) {
        Log.v("pk", "setLiveState:" + i);
        this.w = i;
        LiveRoomManager.a().a(i);
        LiveSetDataObserver.a().f(i);
    }

    public void e_(int i) {
        if (TypeUtils.a((List<?>) LiveRoomManager.a().p().activity) || i < 0 || i >= LiveRoomManager.a().p().activity.size()) {
            return;
        }
        this.m.a(LiveRoomManager.a().p().activity.get(i));
    }

    public void f_(final int i) {
        LiveActivityView liveActivityView;
        ValueAnimator valueAnimator = this.B;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.B.mo53clone();
            this.B = null;
        }
        if (this.D == i || (liveActivityView = this.m) == null) {
            return;
        }
        this.D = i;
        liveActivityView.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBaseFragment$WBf9cvff4O5bfSuX9bH359KtiXo
            @Override // java.lang.Runnable
            public final void run() {
                LiveBaseFragment.this.g(i);
            }
        });
    }

    public void g_(int i) {
        LiveShoutCardStatusView liveShoutCardStatusView = this.o;
        if (liveShoutCardStatusView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) liveShoutCardStatusView.getLayoutParams();
            if (i == 0) {
                layoutParams.bottomMargin = DisplayUtil.a(AppInfo.d(), 12.0f);
            } else {
                layoutParams.bottomMargin = DisplayUtil.a(AppInfo.d(), 40.0f);
            }
            this.o.setLayoutParams(layoutParams);
        }
        this.m.setVisibility(i);
        View view = this.n;
        if (view != null) {
            if (i == 0) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
        LiveEventBusUtil.b(DisplayUtil.a(AppInfo.d(), i == 0 ? 143.0f : 0.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        this.q = this.b.findViewById(R.id.live_pk_user_layout_id);
        this.f12722c = (BubbleLayout) this.b.findViewById(R.id.ll_bubble);
        this.j = (LottieAnimationView) this.b.findViewById(R.id.animation_view);
        this.k = (LiveMakeFriendManageView) this.b.findViewById(R.id.live_make_friend_manage_view);
        LiveActivityView liveActivityView = (LiveActivityView) this.b.findViewById(R.id.liveActivityView);
        this.m = liveActivityView;
        liveActivityView.a(this);
        this.n = this.b.findViewById(R.id.btm_space);
        this.o = (LiveShoutCardStatusView) this.b.findViewById(R.id.live_shout_card_status_view);
        LiveGiftScrawlPlayView liveGiftScrawlPlayView = (LiveGiftScrawlPlayView) this.b.findViewById(R.id.live_gift_scrawl_play_view);
        this.p = liveGiftScrawlPlayView;
        liveGiftScrawlPlayView.setScrawlPlayListener(new LiveGiftScrawlPlayView.ScrawlPlayListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBaseFragment$kkQj6myRAuyiPbLY0H4RwJW2QzU
            @Override // com.blued.android.module.live_china.mine.LiveGiftScrawlPlayView.ScrawlPlayListener
            public final void onPlayFinish() {
                LiveBaseFragment.this.h();
            }
        });
        this.f12722c.a(LiveRoomPreferences.i().split(";"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
        LiveEventBus.get(LiveEventBusUtil.b, LiveChattingModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$zALyJqV-33oGfBOCqs6RPyUC7vw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveBaseFragment.this.a_((LiveChattingModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        this.r = arguments;
        if (arguments == null) {
            this.r = new Bundle();
        }
        l();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(y_(), viewGroup, false);
            a(bundle);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        return this.b;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.F = null;
        LiveActivityView liveActivityView = this.m;
        if (liveActivityView != null) {
            liveActivityView.b();
        }
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onJoinLive(JoinLiveResult joinLiveResult, String str, String str2, String str3) {
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m();
        n();
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onViewerDataChanged(long j, List<ProfileData> list) {
    }

    @Override // com.blued.android.chat.listener.LiveChatInfoListener
    public void onViewerEntrance(EntranceData entranceData, long j) {
    }

    protected boolean p() {
        return true;
    }

    public boolean r() {
        return M_() == 1;
    }

    public boolean s() {
        return M_() == 12 || M_() == 13;
    }

    public void t() {
        if (isAdded()) {
            for (Fragment fragment : getChildFragmentManager().getFragments()) {
                if (fragment instanceof PlayingOnliveBaseModeFragment) {
                    ((PlayingOnliveBaseModeFragment) fragment).e();
                }
            }
        }
    }

    public void u() {
    }

    protected abstract int y_();
}
