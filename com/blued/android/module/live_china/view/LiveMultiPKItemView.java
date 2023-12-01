package com.blued.android.module.live_china.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeModel;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.animation.Rotate3dAnimation;
import com.blued.android.module.live_china.common.ZegoCommonHelper;
import com.blued.android.module.live_china.common.ZegoMixStreamHelper;
import com.blued.android.module.live_china.databinding.LiveMultiConnectionItemViewBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.model.LivePkBannerModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.model.RelationInfo;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKItemView.class */
public final class LiveMultiPKItemView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f14634a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private LiveInviteUserModel f14635c;
    private final Lazy d;
    private Runnable e;
    private boolean f;
    private Runnable g;
    private boolean h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKItemView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f14635c = new LiveInviteUserModel();
        this.d = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMultiConnectionItemViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMultiConnectionItemViewBinding invoke() {
                return LiveMultiConnectionItemViewBinding.a(LayoutInflater.from(LiveMultiPKItemView.this.getContext()), LiveMultiPKItemView.this, true);
            }
        });
        this.e = new Runnable() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$rotateRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                if ((LiveRoomManager.a().m() == 12 || LiveRoomManager.a().m() == 13) && LiveMultiPKItemView.this.getAttatch()) {
                    LiveInviteUserModel item = LiveMultiPKItemView.this.getItem();
                    Intrinsics.a(item);
                    if (item.win_streak <= 0) {
                        LiveMultiPKItemView.this.d();
                        return;
                    }
                    LiveMultiPKItemView liveMultiPKItemView = LiveMultiPKItemView.this;
                    LiveMultiConnectionItemViewBinding viewBinding = liveMultiPKItemView.getViewBinding();
                    CardView cardView = viewBinding == null ? null : viewBinding.j;
                    LiveMultiConnectionItemViewBinding viewBinding2 = LiveMultiPKItemView.this.getViewBinding();
                    liveMultiPKItemView.a(cardView, viewBinding2 == null ? null : viewBinding2.l, LiveMultiPKItemView.this.getItem());
                }
            }
        };
        this.g = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$L9ueM-EVqGfiOixVbUoPUGk9Hgs
            @Override // java.lang.Runnable
            public final void run() {
                LiveMultiPKItemView.d(LiveMultiPKItemView.this);
            }
        };
        this.f14634a = context;
    }

    private final String a(double d) {
        return new DecimalFormat("#.##").format(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, int i2, LiveMultiPKItemView this$0, ValueAnimator valueAnimator) {
        Intrinsics.e(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        this$0.getViewBinding().i.setX((int) ((((Float) animatedValue).floatValue() * i) - i2));
        this$0.getParent().requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ImageView it, final LiveMultiPKItemView this$0) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        it.setImageResource(R.drawable.live_icon_pk_voice_close);
        BluedViewExKt.b(it);
        it.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$xrWVN78DI0XTEGiiYp-ie-EVTJU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMultiPKItemView.e(LiveMultiPKItemView.this, view);
            }
        });
        EventTrackLive.g(LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.f14635c.uid, this$0.f14635c.lid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveMultiPKItemView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveRoomInfo.a().a(AppInfo.d(), new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$setData$2$1
            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void Q_() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void a(String relation) {
                Intrinsics.e(relation, "relation");
                LiveMultiConnectionItemViewBinding viewBinding = LiveMultiPKItemView.this.getViewBinding();
                (viewBinding == null ? null : viewBinding.f12288c).setVisibility(8);
                LiveMultiPKItemView.this.e();
                RelationInfo relationInfo = new RelationInfo();
                relationInfo.setUid(LiveMultiPKItemView.this.getItem().uid);
                relationInfo.setRelation(relation);
                LiveEventBus.get("live_attention_relation_changed").post(relationInfo);
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void b(String relation) {
                Intrinsics.e(relation, "relation");
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void c() {
            }

            @Override // com.blued.android.module.live.base.utils.LiveUserRelationshipUtils.IAddOrRemoveAttentionDone
            public void d() {
            }
        }, this$0.f14635c.uid, "", (IRequestHost) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMultiPKItemView this$0, Ref.BooleanRef record, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(record, "$record");
        if (TextUtils.equals(LiveRoomManager.a().g(), this$0.f14635c.uid)) {
            return;
        }
        if (record.f42538a) {
            LiveSetDataObserver.a().a(this$0.f14635c.uid, 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(LiveRoomManager.a().g())) {
            String g = LiveRoomManager.a().g();
            Intrinsics.c(g, "getInstance().anchorIdStr");
            arrayList.add(g);
        }
        if (!TextUtils.isEmpty(this$0.f14635c.uid)) {
            String str = this$0.f14635c.uid;
            Intrinsics.c(str, "item.uid");
            arrayList.add(str);
        }
        LiveRoomManager.a().a(arrayList);
        LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(this$0.f14635c.lid, 0L), 0, LiveFloatManager.a().D(), this$0.f14635c.uid, "", "", 0);
        liveRoomData.link_type = 5;
        LiveSetDataObserver.a().a(liveRoomData);
    }

    private final String b(int i) {
        return i >= 100 ? "99+" : String.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveMultiPKItemView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveInviteUserModel liveInviteUserModel = this$0.f14635c;
        liveInviteUserModel.voice_disable = liveInviteUserModel.voice_disable == 0 ? 1 : 0;
        int i = this$0.f14635c.voice_disable;
        ImageView imageView = null;
        if (i == 0) {
            LiveMultiConnectionItemViewBinding viewBinding = this$0.getViewBinding();
            (viewBinding == null ? null : viewBinding.f).setImageResource(R.drawable.live_icon_pk_voice_open);
        } else if (i == 1) {
            LiveMultiConnectionItemViewBinding viewBinding2 = this$0.getViewBinding();
            if (viewBinding2 != null) {
                imageView = viewBinding2.f;
            }
            imageView.setImageResource(R.drawable.live_icon_pk_voice_close);
        }
        this$0.a(this$0.f14635c, true);
        EventTrackLive.q(this$0.f14635c.voice_disable == 0 ? LiveProtos.Event.LIVE_PK_VOICE_ICON_OPEN : LiveProtos.Event.LIVE_PK_VOICE_ICON_CLOSE, LiveRoomManager.a().e(), this$0.f14635c.uid, this$0.f14635c.lid);
    }

    private final void c(int i, int i2) {
        this.f = i == 2;
        if (i == -1 || i == 3) {
            d();
            getViewBinding().r.setText(b(i2));
            return;
        }
        d();
        getViewBinding().s.setText(b(i2));
        removeCallbacks(this.g);
        postDelayed(this.g, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveMultiPKItemView this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveMultiConnectionItemViewBinding viewBinding = this$0.getViewBinding();
        ImageView imageView = viewBinding == null ? null : viewBinding.f;
        Intrinsics.c(imageView, "viewBinding?.ivPkVoiceSwitch");
        BluedViewExKt.a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveMultiPKItemView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String a2 = PermissionUtils.a(R.string.live_mute_audio_playing_close_other);
        Intrinsics.c(a2, "getString(R.string.live_…udio_playing_close_other)");
        String format = String.format(a2, Arrays.copyOf(new Object[]{this$0.f14635c.name}, 1));
        Intrinsics.c(format, "format(format, *args)");
        ToastUtils.a(format, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveMultiPKItemView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveMultiPKItemView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f14635c.isGroup()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_SCORE_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        } else {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_SCORE_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        if (((int) this$0.f14635c.score) == 0) {
            if (TextUtils.equals(this$0.f14635c.uid, LiveRoomManager.a().g())) {
                LiveRefreshUIObserver.a().j();
                return;
            }
            return;
        }
        LivePkBannerModel livePkBannerModel = new LivePkBannerModel();
        if (this$0.f14635c.result == 1) {
            livePkBannerModel.pk_state = 2;
        } else if (this$0.f14635c.result == 2) {
            livePkBannerModel.pk_state = 1;
        } else {
            livePkBannerModel.pk_state = 0;
        }
        livePkBannerModel.lid = this$0.f14635c.lid;
        livePkBannerModel.name = this$0.f14635c.name;
        livePkBannerModel.fromGroup = this$0.f14635c.isGroup();
        LiveEventBus.get("live_multi_pk_rank").post(livePkBannerModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveMultiPKItemView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
        String a2 = PermissionUtils.a(R.string.live_mute_audio_playing_close_other);
        Intrinsics.c(a2, "getString(R.string.live_…udio_playing_close_other)");
        String format = String.format(a2, Arrays.copyOf(new Object[]{this$0.f14635c.name}, 1));
        Intrinsics.c(format, "format(format, *args)");
        ToastUtils.a(format, 0);
        EventTrackLive.g(LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.f14635c.uid, this$0.f14635c.lid);
    }

    private final void f() {
        TextView textView = getViewBinding().s;
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        Intrinsics.a(liveInviteUserModel);
        textView.setText(b(liveInviteUserModel.win_streak));
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, this.f ? -1.0f : 1.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$animForUpdateNumsRight$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                LiveMultiPKItemView.this.getViewBinding().r.setText(LiveMultiPKItemView.this.getViewBinding().s.getText());
                LiveMultiPKItemView.this.getViewBinding().r.clearAnimation();
                LiveMultiPKItemView.this.getViewBinding().s.setVisibility(8);
                LiveMultiPKItemView.this.getViewBinding().s.clearAnimation();
                if (LiveMultiPKItemView.this.getWin()) {
                    LiveMultiPKItemView.this.h();
                } else {
                    LiveMultiPKItemView.this.g();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        getViewBinding().r.clearAnimation();
        getViewBinding().r.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, this.f ? 1.0f : -1.0f, 1, 0.0f);
        translateAnimation2.setDuration(400L);
        translateAnimation2.setFillAfter(true);
        getViewBinding().s.clearAnimation();
        getViewBinding().s.startAnimation(translateAnimation2);
        getViewBinding().s.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(300L);
        getViewBinding().j.clearAnimation();
        getViewBinding().j.startAnimation(alphaAnimation);
        getViewBinding().j.setVisibility(8);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        getViewBinding().j.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        getViewBinding().i.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        final int measuredWidth = getViewBinding().i.getMeasuredWidth();
        int measuredWidth2 = getViewBinding().j.getMeasuredWidth();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$animForLight$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.e(animation, "animation");
                LiveMultiPKItemView.this.getViewBinding().i.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.e(animation, "animation");
                LiveMultiPKItemView.this.getViewBinding().i.setVisibility(0);
            }
        });
        ofFloat.setDuration(600L);
        ofFloat.setRepeatCount(1);
        final int i = measuredWidth2 + measuredWidth;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$nSq_5O6lOzZ2MfNH1pY7hVqh9to
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveMultiPKItemView.a(i, measuredWidth, this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    private final void i() {
        TextView textView = getViewBinding().q;
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        Intrinsics.a(liveInviteUserModel);
        textView.setText(a(liveInviteUserModel.score));
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(400L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$animForUpdateScore$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                LiveMultiPKItemView.this.getViewBinding().p.setText(LiveMultiPKItemView.this.getViewBinding().q.getText());
                LiveMultiPKItemView.this.getViewBinding().p.clearAnimation();
                LiveMultiPKItemView.this.getViewBinding().q.setVisibility(8);
                LiveMultiPKItemView.this.getViewBinding().q.clearAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        getViewBinding().p.clearAnimation();
        getViewBinding().p.startAnimation(translateAnimation);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation2.setDuration(400L);
        translateAnimation2.setFillAfter(true);
        getViewBinding().q.clearAnimation();
        getViewBinding().q.startAnimation(translateAnimation2);
        getViewBinding().q.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setPkData$lambda-5  reason: not valid java name */
    public static final void m4229setPkData$lambda5(View view) {
        LiveSetDataObserver.a().b(LiveRoomInfo.a().G(), 25);
    }

    public final void a() {
        if (this.f14635c.isGroup()) {
            ShapeModel shapeModel = new ShapeModel();
            ShapeModel shapeModel2 = new ShapeModel();
            shapeModel2.H = DensityUtils.a(getContext(), 30.0f);
            shapeModel.H = DensityUtils.a(getContext(), 30.0f);
            if (this.f14635c.isMyGroup()) {
                shapeModel2.t = ContextCompat.getColor(getContext(), R.color.syc_dark_664081FF);
                shapeModel2.v = ContextCompat.getColor(getContext(), R.color.syc_dark_2D80FF);
                shapeModel.t = ContextCompat.getColor(getContext(), R.color.syc_dark_003E68B8);
                shapeModel.v = ContextCompat.getColor(getContext(), R.color.syc_dark_9DBEFF);
                LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
                (viewBinding == null ? null : viewBinding.n).setVisibility(0);
                LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
                (viewBinding2 == null ? null : viewBinding2.n).setShapeModel(shapeModel);
                LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
                (viewBinding3 == null ? null : viewBinding3.m).setShapeModel(shapeModel2);
                LiveMultiConnectionItemViewBinding viewBinding4 = getViewBinding();
                (viewBinding4 == null ? null : viewBinding4.m).setTextColor(ContextCompat.getColor(getContext(), R.color.syc_dark_b));
                LiveMultiConnectionItemViewBinding viewBinding5 = getViewBinding();
                (viewBinding5 == null ? null : viewBinding5.m).setText(R.string.live_pk_dared_our);
            } else {
                shapeModel2.t = ContextCompat.getColor(getContext(), R.color.syc_dark_66DB19D3);
                shapeModel2.v = ContextCompat.getColor(getContext(), R.color.syc_dark_DB19D3);
                shapeModel.t = ContextCompat.getColor(getContext(), R.color.syc_dark_008C379F);
                shapeModel.v = ContextCompat.getColor(getContext(), R.color.syc_dark_FF6AFF);
                LiveMultiConnectionItemViewBinding viewBinding6 = getViewBinding();
                (viewBinding6 == null ? null : viewBinding6.n).setVisibility(0);
                LiveMultiConnectionItemViewBinding viewBinding7 = getViewBinding();
                (viewBinding7 == null ? null : viewBinding7.n).setShapeModel(shapeModel);
                LiveMultiConnectionItemViewBinding viewBinding8 = getViewBinding();
                (viewBinding8 == null ? null : viewBinding8.m).setShapeModel(shapeModel2);
                LiveMultiConnectionItemViewBinding viewBinding9 = getViewBinding();
                (viewBinding9 == null ? null : viewBinding9.m).setTextColor(ContextCompat.getColor(getContext(), R.color.syc_dark_b));
                LiveMultiConnectionItemViewBinding viewBinding10 = getViewBinding();
                (viewBinding10 == null ? null : viewBinding10.m).setText(R.string.live_pk_dared_opposite);
            }
        } else {
            LiveMultiConnectionItemViewBinding viewBinding11 = getViewBinding();
            (viewBinding11 == null ? null : viewBinding11.n).setVisibility(8);
        }
        LiveMultiConnectionItemViewBinding viewBinding12 = getViewBinding();
        ViewGroup.LayoutParams layoutParams = (viewBinding12 == null ? null : viewBinding12.n).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        Intrinsics.a(liveInviteUserModel);
        if (!TextUtils.equals(liveInviteUserModel.uid, LiveRoomManager.a().g()) || this.f14635c.win_streak > 0) {
            marginLayoutParams.bottomMargin = DensityUtils.a(AppInfo.d(), 30.5f);
        } else {
            marginLayoutParams.bottomMargin = DensityUtils.a(AppInfo.d(), 7.5f);
        }
        LiveMultiConnectionItemViewBinding viewBinding13 = getViewBinding();
        (viewBinding13 == null ? null : viewBinding13.n).setLayoutParams(marginLayoutParams);
        ShapeModel shapeModel3 = new ShapeModel();
        ShapeModel shapeModel4 = new ShapeModel();
        shapeModel3.H = DensityUtils.a(getContext(), 20.0f);
        shapeModel4.H = DensityUtils.a(getContext(), 20.0f);
        if (this.f14635c.win_streak > 0) {
            if (!this.f14635c.isGroup()) {
                shapeModel4.t = ContextCompat.getColor(getContext(), R.color.syc_dark_66DB19D3);
                shapeModel4.v = ContextCompat.getColor(getContext(), R.color.syc_dark_DB19D3);
                shapeModel3.t = ContextCompat.getColor(getContext(), R.color.syc_dark_008C379F);
                shapeModel3.v = ContextCompat.getColor(getContext(), R.color.syc_dark_8C379F);
                LiveMultiConnectionItemViewBinding viewBinding14 = getViewBinding();
                (viewBinding14 == null ? null : viewBinding14.h).setImageResource(R.drawable.live_multi_streak_icon);
            } else if (this.f14635c.isMyGroup()) {
                shapeModel4.t = ContextCompat.getColor(getContext(), R.color.syc_dark_664081FF);
                shapeModel4.v = ContextCompat.getColor(getContext(), R.color.syc_dark_2D80FF);
                shapeModel3.t = ContextCompat.getColor(getContext(), R.color.syc_dark_003E68B8);
                shapeModel3.v = ContextCompat.getColor(getContext(), R.color.syc_dark_3E68B8);
                LiveMultiConnectionItemViewBinding viewBinding15 = getViewBinding();
                (viewBinding15 == null ? null : viewBinding15.h).setImageResource(R.drawable.live_multi_streak_icon_my);
            } else {
                shapeModel4.t = ContextCompat.getColor(getContext(), R.color.syc_dark_66DB19D3);
                shapeModel4.v = ContextCompat.getColor(getContext(), R.color.syc_dark_DB19D3);
                shapeModel3.t = ContextCompat.getColor(getContext(), R.color.syc_dark_008C379F);
                shapeModel3.v = ContextCompat.getColor(getContext(), R.color.syc_dark_8C379F);
                LiveMultiConnectionItemViewBinding viewBinding16 = getViewBinding();
                (viewBinding16 == null ? null : viewBinding16.h).setImageResource(R.drawable.live_multi_streak_icon);
            }
            LiveMultiConnectionItemViewBinding viewBinding17 = getViewBinding();
            (viewBinding17 == null ? null : viewBinding17.b).setShapeModel(shapeModel4);
            LiveMultiConnectionItemViewBinding viewBinding18 = getViewBinding();
            (viewBinding18 == null ? null : viewBinding18.f12287a).setShapeModel(shapeModel3);
        }
    }

    public final void a(double d, int i) {
        Log.i("xpz", "updatePkScore:" + d + " rank:" + i);
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        if (liveInviteUserModel == null) {
            return;
        }
        Intrinsics.a(liveInviteUserModel);
        liveInviteUserModel.score = d;
        LiveInviteUserModel liveInviteUserModel2 = this.f14635c;
        Intrinsics.a(liveInviteUserModel2);
        liveInviteUserModel2.rank = i;
        ShapeModel shapeModel = new ShapeModel();
        shapeModel.H = DensityUtils.a(getContext(), 20.0f);
        if (StringUtils.a(this.f14635c.my_group_id, 0) == 0) {
            shapeModel.q = DensityUtils.a(getContext(), 0.5f);
            LiveInviteUserModel liveInviteUserModel3 = this.f14635c;
            Intrinsics.a(liveInviteUserModel3);
            if (liveInviteUserModel3.rank == 1) {
                shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_dark_85774F01);
                shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_dark_FFEA85);
                LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
                (viewBinding == null ? null : viewBinding.d).setImageResource(R.drawable.live_multi_rank_1);
            } else {
                LiveInviteUserModel liveInviteUserModel4 = this.f14635c;
                Intrinsics.a(liveInviteUserModel4);
                if (liveInviteUserModel4.rank == 2) {
                    shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_dark_66000000);
                    shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_dark_33000000);
                    LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
                    (viewBinding2 == null ? null : viewBinding2.d).setImageResource(R.drawable.live_multi_rank_2);
                } else {
                    LiveInviteUserModel liveInviteUserModel5 = this.f14635c;
                    Intrinsics.a(liveInviteUserModel5);
                    if (liveInviteUserModel5.rank == 3) {
                        shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_dark_66000000);
                        shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_dark_33000000);
                        LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
                        (viewBinding3 == null ? null : viewBinding3.d).setImageResource(R.drawable.live_multi_rank_3);
                    } else {
                        LiveInviteUserModel liveInviteUserModel6 = this.f14635c;
                        Intrinsics.a(liveInviteUserModel6);
                        if (liveInviteUserModel6.rank == 4) {
                            shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_dark_66000000);
                            shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_dark_33000000);
                            LiveMultiConnectionItemViewBinding viewBinding4 = getViewBinding();
                            (viewBinding4 == null ? null : viewBinding4.d).setImageResource(R.drawable.live_multi_rank_4);
                        } else {
                            shapeModel.k = ContextCompat.getColor(getContext(), R.color.syc_dark_66000000);
                            shapeModel.n = ContextCompat.getColor(getContext(), R.color.syc_dark_33000000);
                            LiveMultiConnectionItemViewBinding viewBinding5 = getViewBinding();
                            (viewBinding5 == null ? null : viewBinding5.d).setImageResource(R.drawable.live_multi_gift_icon);
                        }
                    }
                }
            }
            LiveInviteUserModel liveInviteUserModel7 = this.f14635c;
            Intrinsics.a(liveInviteUserModel7);
            if (((int) liveInviteUserModel7.score) == 0) {
                LiveMultiConnectionItemViewBinding viewBinding6 = getViewBinding();
                (viewBinding6 == null ? null : viewBinding6.d).setImageResource(R.drawable.live_multi_gift_icon);
            }
        } else {
            shapeModel.q = DensityUtils.a(getContext(), 0.5f);
            if (StringUtils.a(this.f14635c.group_id, 0) == StringUtils.a(this.f14635c.my_group_id, 0)) {
                shapeModel.t = ContextCompat.getColor(getContext(), R.color.syc_dark_2D80FF);
                shapeModel.v = ContextCompat.getColor(getContext(), R.color.syc_dark_664081FF);
                LiveMultiConnectionItemViewBinding viewBinding7 = getViewBinding();
                (viewBinding7 == null ? null : viewBinding7.d).setImageResource(R.drawable.live_multi_gift_icon_my);
            } else {
                shapeModel.t = ContextCompat.getColor(getContext(), R.color.syc_dark_DB19D3);
                shapeModel.v = ContextCompat.getColor(getContext(), R.color.syc_dark_66DB19D3);
                LiveMultiConnectionItemViewBinding viewBinding8 = getViewBinding();
                (viewBinding8 == null ? null : viewBinding8.d).setImageResource(R.drawable.live_multi_gift_icon);
            }
        }
        LiveMultiConnectionItemViewBinding viewBinding9 = getViewBinding();
        ShapeLinearLayout shapeLinearLayout = viewBinding9 == null ? null : viewBinding9.k;
        if (shapeLinearLayout != null) {
            shapeLinearLayout.setShapeModel(shapeModel);
        }
        LiveMultiConnectionItemViewBinding viewBinding10 = getViewBinding();
        if ((viewBinding10 == null ? null : viewBinding10.k).getVisibility() == 0) {
            if (this.f14635c.scoreChanged) {
                i();
                return;
            }
            LiveMultiConnectionItemViewBinding viewBinding11 = getViewBinding();
            TextView textView = viewBinding11 == null ? null : viewBinding11.p;
            LiveInviteUserModel liveInviteUserModel8 = this.f14635c;
            Intrinsics.a(liveInviteUserModel8);
            textView.setText(a(liveInviteUserModel8.score));
            return;
        }
        if (this.f14635c.isGroup()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_SCORE_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        LiveMultiConnectionItemViewBinding viewBinding12 = getViewBinding();
        TextView textView2 = viewBinding12 == null ? null : viewBinding12.p;
        LiveInviteUserModel liveInviteUserModel9 = this.f14635c;
        Intrinsics.a(liveInviteUserModel9);
        textView2.setText(a(liveInviteUserModel9.score));
        LiveMultiConnectionItemViewBinding viewBinding13 = getViewBinding();
        (viewBinding13 == null ? null : viewBinding13.k).setVisibility(0);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [T, android.view.ViewGroup$MarginLayoutParams] */
    public final void a(int i) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ViewGroup.LayoutParams layoutParams = getViewBinding().g.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        objectRef.f42545a = (ViewGroup.MarginLayoutParams) layoutParams;
        ((ViewGroup.MarginLayoutParams) objectRef.f42545a).width = 0;
        ((ViewGroup.MarginLayoutParams) objectRef.f42545a).height = 0;
        ((ViewGroup.MarginLayoutParams) objectRef.f42545a).leftMargin = DensityUtils.a(AppInfo.d(), 31.5f) - (((ViewGroup.MarginLayoutParams) objectRef.f42545a).width / 2);
        getViewBinding().g.setLayoutParams((ViewGroup.LayoutParams) objectRef.f42545a);
        if (i == 1) {
            getViewBinding().g.setImageResource(R.drawable.live_multi_pk_fail);
        } else if (i != 2) {
            getViewBinding().g.setImageResource(R.drawable.live_multi_pk_draw);
        } else {
            getViewBinding().g.setImageResource(R.drawable.live_multi_pk_win);
        }
        getViewBinding().g.setVisibility(0);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, DensityUtils.a(AppInfo.d(), 60.0f), DensityUtils.a(AppInfo.d(), 50.0f));
        ofInt.setDuration(600L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$animResultIcon$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                Intrinsics.e(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                int intValue = ((Integer) animatedValue).intValue();
                objectRef.f42545a.width = intValue;
                objectRef.f42545a.height = intValue;
                objectRef.f42545a.leftMargin = DensityUtils.a(AppInfo.d(), 26.5f) - (objectRef.f42545a.width / 2);
                objectRef.f42545a.bottomMargin = DensityUtils.a(AppInfo.d(), 52.5f) - (objectRef.f42545a.height / 2);
                this.getViewBinding().g.setLayoutParams(objectRef.f42545a);
            }
        });
        ofInt.start();
    }

    public final void a(int i, int i2) {
        Log.i("xpz", "updateWinStreak");
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        if (liveInviteUserModel == null) {
            return;
        }
        Intrinsics.a(liveInviteUserModel);
        liveInviteUserModel.win_streak = i2;
        getViewBinding().r.clearAnimation();
        getViewBinding().s.clearAnimation();
        getViewBinding().s.setVisibility(8);
        c(i, i2);
    }

    public final void a(final View view, final View view2, final LiveInviteUserModel liveInviteUserModel) {
        if (view == null || view2 == null || liveInviteUserModel == null || liveInviteUserModel.animing) {
            return;
        }
        liveInviteUserModel.animing = true;
        float width = view.getWidth() / 2.0f;
        float height = view.getHeight() / 2.0f;
        final AnimationSet animationSet = new AnimationSet(true);
        final AnimationSet animationSet2 = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(liveInviteUserModel.show_btm ? 0.0f : 1.0f, liveInviteUserModel.show_btm ? 1.0f : 0.0f);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(!liveInviteUserModel.show_btm ? 0.0f : 1.0f, !liveInviteUserModel.show_btm ? 1.0f : 0.0f);
        alphaAnimation.setDuration(160L);
        alphaAnimation2.setDuration(160L);
        Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(liveInviteUserModel.show_btm ? -270.0f : 0.0f, liveInviteUserModel.show_btm ? -360.0f : -90.0f, width, height, 0.0f, Rotate3dAnimation.f11720a, true);
        Rotate3dAnimation rotate3dAnimation2 = new Rotate3dAnimation(!liveInviteUserModel.show_btm ? -270.0f : 0.0f, !liveInviteUserModel.show_btm ? -360.0f : -90.0f, width, height, 0.0f, Rotate3dAnimation.f11720a, true);
        rotate3dAnimation.setDuration(160L);
        rotate3dAnimation2.setDuration(160L);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(rotate3dAnimation);
        animationSet2.addAnimation(alphaAnimation2);
        animationSet2.addAnimation(rotate3dAnimation2);
        rotate3dAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$rotation$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (!LiveInviteUserModel.this.show_btm) {
                    view.setVisibility(8);
                    view2.setVisibility(0);
                    view2.clearAnimation();
                    view2.startAnimation(animationSet2);
                    return;
                }
                LiveInviteUserModel liveInviteUserModel2 = LiveInviteUserModel.this;
                liveInviteUserModel2.show_btm = !liveInviteUserModel2.show_btm;
                this.c();
                LiveMultiPKItemView liveMultiPKItemView = this;
                liveMultiPKItemView.postDelayed(liveMultiPKItemView.getRotateRunnable(), 5000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        rotate3dAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$rotation$2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (LiveInviteUserModel.this.show_btm) {
                    view.setVisibility(0);
                    view2.setVisibility(8);
                    view.clearAnimation();
                    view.startAnimation(animationSet);
                    return;
                }
                LiveInviteUserModel liveInviteUserModel2 = LiveInviteUserModel.this;
                liveInviteUserModel2.show_btm = !liveInviteUserModel2.show_btm;
                this.c();
                LiveMultiPKItemView liveMultiPKItemView = this;
                liveMultiPKItemView.postDelayed(liveMultiPKItemView.getRotateRunnable(), 5000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.e(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.e(animation, "animation");
            }
        });
        if (liveInviteUserModel.show_btm) {
            view.setVisibility(8);
            view2.setVisibility(0);
            view2.clearAnimation();
            view2.startAnimation(animationSet2);
            return;
        }
        view.setVisibility(0);
        view2.setVisibility(8);
        view.clearAnimation();
        view.startAnimation(animationSet);
    }

    public final void a(LiveInviteUserModel model, boolean z) {
        Intrinsics.e(model, "model");
        boolean z2 = model.voice_disable == 1;
        if (TextUtils.isEmpty(LiveRoomManager.a().p().stream) || TextUtils.isEmpty(model.stream_id)) {
            return;
        }
        ZegoCommonHelper.b().c().setPlayVolume(z2 ? 0 : 100, model.stream_id);
        ZegoCommonHelper.b().c().activateAudioPlayStream(model.stream_id, !z2);
        ZegoMixStreamHelper.a().a(model.stream_id, LiveRoomManager.a().p().stream, z2);
        if (z) {
            HashMap hashMap = new HashMap();
            String e = LiveRoomManager.a().e();
            Intrinsics.c(e, "getInstance().roomIdStr");
            hashMap.put("source_lid", e);
            String f = LiveRoomInfo.a().f();
            Intrinsics.c(f, "getInstance().userId");
            hashMap.put("source_uid", f);
            String str = model.lid;
            Intrinsics.c(str, "model.lid");
            hashMap.put("target_lid", str);
            String str2 = model.uid;
            Intrinsics.c(str2, "model.uid");
            hashMap.put("target_uid", str2);
            hashMap.put("target_status", Integer.valueOf(model.voice_disable == 1 ? 0 : 1));
            LiveRoomHttpUtils.a(hashMap);
        }
    }

    public final void a(String str, View view, final IRequestHost iRequestHost) {
        if (view == null) {
            return;
        }
        LiveRoomHttpUtils.a(AppInfo.d(), (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this) { // from class: com.blued.android.module.live_china.view.LiveMultiPKItemView$getUserInfo$1
            final /* synthetic */ LiveMultiPKItemView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveRoomUserModel> bluedEntityA) {
                LiveRoomUserModel liveRoomUserModel;
                Intrinsics.e(bluedEntityA, "bluedEntityA");
                if (this.b.getAttatch() && bluedEntityA.data != null && bluedEntityA.data.size() > 0 && (liveRoomUserModel = bluedEntityA.data.get(0)) != null) {
                    this.b.setRelation(liveRoomUserModel.relationship);
                }
            }
        }, str, "", Long.valueOf(LiveRoomManager.a().d()), (Short) 4, iRequestHost);
    }

    public final void a(boolean z) {
        ImageView imageView;
        final ImageView imageView2;
        if (z) {
            LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
            if (viewBinding != null && (imageView2 = viewBinding.f) != null) {
                imageView2.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$JqiKSC0TZtAIatNYG1BTKFExyt0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LiveMultiPKItemView.a(ImageView.this, this);
                    }
                });
            }
            LiveInviteUserModel liveInviteUserModel = this.f14635c;
            if (liveInviteUserModel == null) {
                return;
            }
            liveInviteUserModel.voice_disable = 1;
            return;
        }
        LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
        if (viewBinding2 != null && (imageView = viewBinding2.f) != null) {
            imageView.post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$VN5Jx1azaxQLHI9nKhKJCfHkUVY
                @Override // java.lang.Runnable
                public final void run() {
                    LiveMultiPKItemView.c(LiveMultiPKItemView.this);
                }
            });
        }
        LiveInviteUserModel liveInviteUserModel2 = this.f14635c;
        if (liveInviteUserModel2 == null) {
            return;
        }
        liveInviteUserModel2.voice_disable = 0;
    }

    public final void b() {
        c();
        this.f14635c.status = 0;
        if (TextUtils.equals(this.f14635c.uid, LiveRoomManager.a().g())) {
            LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
            (viewBinding == null ? null : viewBinding.l).setVisibility(8);
        } else {
            LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
            (viewBinding2 == null ? null : viewBinding2.l).setVisibility(0);
        }
        LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
        (viewBinding3 == null ? null : viewBinding3.k).setVisibility(8);
        LiveMultiConnectionItemViewBinding viewBinding4 = getViewBinding();
        (viewBinding4 == null ? null : viewBinding4.j).setVisibility(8);
        LiveMultiConnectionItemViewBinding viewBinding5 = getViewBinding();
        (viewBinding5 == null ? null : viewBinding5.n).setVisibility(8);
        getViewBinding().g.setVisibility(8);
        if (!TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
            LiveMultiConnectionItemViewBinding viewBinding6 = getViewBinding();
            ImageView imageView = viewBinding6 == null ? null : viewBinding6.f;
            Intrinsics.c(imageView, "viewBinding?.ivPkVoiceSwitch");
            BluedViewExKt.a(imageView);
            this.f14635c.voice_disable = 0;
            return;
        }
        LiveMultiConnectionItemViewBinding viewBinding7 = getViewBinding();
        ImageView imageView2 = viewBinding7 == null ? null : viewBinding7.f;
        Intrinsics.c(imageView2, "viewBinding?.ivPkVoiceSwitch");
        BluedViewExKt.a(imageView2);
        LiveMultiConnectionItemViewBinding viewBinding8 = getViewBinding();
        (viewBinding8 == null ? null : viewBinding8.f).setImageResource(R.drawable.live_icon_pk_voice_open);
        this.f14635c.voice_disable = 0;
        a(this.f14635c, false);
    }

    public final void b(int i, int i2) {
        Log.i("xpz", "setResult");
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        Intrinsics.a(liveInviteUserModel);
        liveInviteUserModel.animing = false;
        a(i, i2);
        LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
        (viewBinding == null ? null : viewBinding.d).setVisibility(8);
        LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
        (viewBinding2 == null ? null : viewBinding2.e).setVisibility(0);
        if (i == 1) {
            ImageLoader.c(null, "live_multi_pk_fail_anim.png").e(getViewBinding().e.hashCode()).g(-1).a(getViewBinding().e);
        } else if (i != 2) {
            ImageLoader.c(null, "live_multi_pk_fail_anim.png").e(getViewBinding().e.hashCode()).g(-1).a(getViewBinding().e);
        } else {
            ImageLoader.c(null, "live_multi_pk_win_anim.png").e(getViewBinding().e.hashCode()).g(-1).a(getViewBinding().e);
        }
        a();
    }

    public final void c() {
        removeCallbacks(this.e);
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        if (liveInviteUserModel == null) {
            return;
        }
        liveInviteUserModel.animing = false;
    }

    public final void d() {
        c();
        LiveInviteUserModel liveInviteUserModel = this.f14635c;
        Intrinsics.a(liveInviteUserModel);
        boolean z = false;
        ShapeLinearLayout shapeLinearLayout = null;
        if (TextUtils.equals(liveInviteUserModel.uid, LiveRoomManager.a().g())) {
            LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
            (viewBinding == null ? null : viewBinding.l).setVisibility(8);
            LiveInviteUserModel liveInviteUserModel2 = this.f14635c;
            Intrinsics.a(liveInviteUserModel2);
            if (liveInviteUserModel2.win_streak > 0) {
                LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
                (viewBinding2 == null ? null : viewBinding2.j).setVisibility(0);
                return;
            }
            LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
            (viewBinding3 == null ? null : viewBinding3.j).setVisibility(8);
            return;
        }
        LiveInviteUserModel liveInviteUserModel3 = this.f14635c;
        Intrinsics.a(liveInviteUserModel3);
        if (liveInviteUserModel3.win_streak <= 0) {
            LiveMultiConnectionItemViewBinding viewBinding4 = getViewBinding();
            (viewBinding4 == null ? null : viewBinding4.l).setVisibility(0);
            LiveMultiConnectionItemViewBinding viewBinding5 = getViewBinding();
            (viewBinding5 == null ? null : viewBinding5.j).setVisibility(8);
            return;
        }
        LiveInviteUserModel liveInviteUserModel4 = this.f14635c;
        if (liveInviteUserModel4 != null) {
            LiveMultiConnectionItemViewBinding viewBinding6 = getViewBinding();
            if (viewBinding6 != null) {
                shapeLinearLayout = viewBinding6.l;
            }
            if (shapeLinearLayout.getVisibility() == 0) {
                z = true;
            }
            liveInviteUserModel4.show_btm = z;
        }
        post(this.e);
    }

    public final void e() {
        TextView textView;
        LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
        TextView textView2 = null;
        boolean z = (viewBinding == null ? null : viewBinding.f12288c).getVisibility() == 0;
        LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
        ViewGroup.LayoutParams layoutParams = (viewBinding2 == null || (textView = viewBinding2.o) == null) ? null : textView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = DensityUtils.a(AppInfo.d(), z ? 0.0f : 7.5f);
        }
        LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
        if (viewBinding3 != null) {
            textView2 = viewBinding3.o;
        }
        if (textView2 == null) {
            return;
        }
        textView2.setLayoutParams(layoutParams);
    }

    public final boolean getAttatch() {
        return this.b;
    }

    public final LiveInviteUserModel getItem() {
        return this.f14635c;
    }

    public final Context getMContext() {
        return this.f14634a;
    }

    public final Runnable getRotateRunnable() {
        return this.e;
    }

    public final Runnable getRunnableNumberRight() {
        return this.g;
    }

    public final boolean getScoreAniming() {
        return this.h;
    }

    public final LiveMultiConnectionItemViewBinding getViewBinding() {
        return (LiveMultiConnectionItemViewBinding) this.d.getValue();
    }

    public final boolean getWin() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setVisibility(0);
        this.b = true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisibility(8);
        this.b = false;
        c();
    }

    public final void setAttatch(boolean z) {
        this.b = z;
    }

    public final void setData(LiveInviteUserModel model) {
        TextView textView;
        Intrinsics.e(model, "model");
        this.f14635c = model;
        c();
        try {
            LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
            (viewBinding == null ? null : viewBinding.k).setVisibility(8);
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
        }
        LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
        (viewBinding2 == null ? null : viewBinding2.j).setVisibility(8);
        LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
        (viewBinding3 == null ? null : viewBinding3.n).setVisibility(8);
        LiveMultiConnectionItemViewBinding viewBinding4 = getViewBinding();
        if (viewBinding4 != null && (textView = viewBinding4.o) != null) {
            textView.setText(this.f14635c.name);
        }
        if (TextUtils.equals(this.f14635c.uid, LiveRoomManager.a().g())) {
            LiveMultiConnectionItemViewBinding viewBinding5 = getViewBinding();
            (viewBinding5 == null ? null : viewBinding5.l).setVisibility(8);
        } else {
            LiveMultiConnectionItemViewBinding viewBinding6 = getViewBinding();
            (viewBinding6 == null ? null : viewBinding6.l).setVisibility(0);
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.f42538a = TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g());
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$lisdY6R5YN3JYVHDr8DttKdrgC8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMultiPKItemView.a(LiveMultiPKItemView.this, booleanRef, view);
            }
        });
        LiveMultiConnectionItemViewBinding viewBinding7 = getViewBinding();
        (viewBinding7 == null ? null : viewBinding7.f12288c).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$0CrdiSWR6l4JmKfUJd0pjsbQiiw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMultiPKItemView.a(LiveMultiPKItemView.this, view);
            }
        });
        String str = this.f14635c.uid;
        LiveMultiConnectionItemViewBinding viewBinding8 = getViewBinding();
        a(str, viewBinding8 == null ? null : viewBinding8.f12288c, (IRequestHost) null);
    }

    public final void setItem(LiveInviteUserModel liveInviteUserModel) {
        Intrinsics.e(liveInviteUserModel, "<set-?>");
        this.f14635c = liveInviteUserModel;
    }

    public final void setMContext(Context context) {
        this.f14634a = context;
    }

    public final void setPkData(LiveInviteUserModel model) {
        CardView cardView;
        ShapeLinearLayout shapeLinearLayout;
        Intrinsics.e(model, "model");
        this.f14635c = model;
        Log.i("xpz", Intrinsics.a("setPkData:", (Object) model.uid));
        c();
        LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
        (viewBinding == null ? null : viewBinding.d).setVisibility(0);
        LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
        (viewBinding2 == null ? null : viewBinding2.e).setVisibility(8);
        if (this.f14635c.voice_disable == -1 || TextUtils.equals(this.f14635c.uid, LiveRoomInfo.a().f())) {
            LiveMultiConnectionItemViewBinding viewBinding3 = getViewBinding();
            ImageView imageView = viewBinding3 == null ? null : viewBinding3.f;
            Intrinsics.c(imageView, "viewBinding?.ivPkVoiceSwitch");
            BluedViewExKt.a(imageView);
        } else if (TextUtils.equals(LiveRoomInfo.a().f(), LiveRoomManager.a().g())) {
            int i = this.f14635c.voice_disable;
            if (i == 0) {
                LiveMultiConnectionItemViewBinding viewBinding4 = getViewBinding();
                (viewBinding4 == null ? null : viewBinding4.f).setImageResource(R.drawable.live_icon_pk_voice_open);
            } else if (i == 1) {
                LiveMultiConnectionItemViewBinding viewBinding5 = getViewBinding();
                (viewBinding5 == null ? null : viewBinding5.f).setImageResource(R.drawable.live_icon_pk_voice_close);
            }
            LiveMultiConnectionItemViewBinding viewBinding6 = getViewBinding();
            ImageView imageView2 = viewBinding6 == null ? null : viewBinding6.f;
            Intrinsics.c(imageView2, "viewBinding?.ivPkVoiceSwitch");
            BluedViewExKt.b(imageView2);
            LiveMultiConnectionItemViewBinding viewBinding7 = getViewBinding();
            (viewBinding7 == null ? null : viewBinding7.f).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$ZEM3_tzf_4EsFXJCs00bzOvxz-U
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveMultiPKItemView.b(LiveMultiPKItemView.this, view);
                }
            });
            EventTrackLive.q(LiveProtos.Event.LIVE_PK_VOICE_ICON_SHOW, LiveRoomManager.a().e(), this.f14635c.uid, this.f14635c.lid);
        } else if (this.f14635c.voice_disable == 1) {
            LiveMultiConnectionItemViewBinding viewBinding8 = getViewBinding();
            (viewBinding8 == null ? null : viewBinding8.f).setImageResource(R.drawable.live_icon_pk_voice_close);
            LiveMultiConnectionItemViewBinding viewBinding9 = getViewBinding();
            ImageView imageView3 = viewBinding9 == null ? null : viewBinding9.f;
            Intrinsics.c(imageView3, "viewBinding?.ivPkVoiceSwitch");
            BluedViewExKt.b(imageView3);
            LiveMultiConnectionItemViewBinding viewBinding10 = getViewBinding();
            (viewBinding10 == null ? null : viewBinding10.f).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$gLO3DG7IngZluHcsPLSwI_A6xxk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveMultiPKItemView.c(LiveMultiPKItemView.this, view);
                }
            });
            EventTrackLive.g(LiveProtos.Event.LIVE_PK_USER_VOICE_ICON_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), model.uid, model.lid);
        } else {
            LiveMultiConnectionItemViewBinding viewBinding11 = getViewBinding();
            ImageView imageView4 = viewBinding11 == null ? null : viewBinding11.f;
            Intrinsics.c(imageView4, "viewBinding?.ivPkVoiceSwitch");
            BluedViewExKt.a(imageView4);
        }
        a();
        a(-1, this.f14635c.win_streak);
        a(this.f14635c.score, this.f14635c.rank);
        LiveMultiConnectionItemViewBinding viewBinding12 = getViewBinding();
        if (viewBinding12 != null && (shapeLinearLayout = viewBinding12.k) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$_X-2UT71MgTBGLUhGP1qV2kkXcE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveMultiPKItemView.d(LiveMultiPKItemView.this, view);
                }
            });
        }
        LiveMultiConnectionItemViewBinding viewBinding13 = getViewBinding();
        if (viewBinding13 == null || (cardView = viewBinding13.j) == null) {
            return;
        }
        cardView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKItemView$Cn9hE6nvUM8GnApiB2Tw4D_Nybs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMultiPKItemView.m4229setPkData$lambda5(view);
            }
        });
    }

    public final void setRelation(String str) {
        String str2 = str;
        ImageView imageView = null;
        if (TextUtils.equals(str2, "1") || TextUtils.equals(str2, "3")) {
            LiveMultiConnectionItemViewBinding viewBinding = getViewBinding();
            (viewBinding == null ? null : viewBinding.f12288c).setVisibility(8);
        } else {
            LiveMultiConnectionItemViewBinding viewBinding2 = getViewBinding();
            if (viewBinding2 != null) {
                imageView = viewBinding2.f12288c;
            }
            imageView.setVisibility(0);
        }
        e();
    }

    public final void setRotateRunnable(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.e = runnable;
    }

    public final void setRunnableNumberRight(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.g = runnable;
    }

    public final void setScoreAniming(boolean z) {
        this.h = z;
    }

    public final void setWin(boolean z) {
        this.f = z;
    }
}
