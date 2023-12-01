package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LivePkCenterBinding;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.model.LiveDaredPKExtraModel;
import com.blued.android.module.live_china.model.LiveFriendExtraModel;
import com.blued.android.module.live_china.model.LiveInteractionDetailModel;
import com.blued.android.module.live_china.model.LiveInteractionModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.observer.PkDaredObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKCenterView.class */
public final class LivePKCenterView extends FrameLayout {
    private final Context a;
    private final Lazy b;
    private LiveConnectionView c;
    private ILiveConnectionStateListener d;
    private LiveInteractionModel e;
    private IRequestHost f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePKCenterView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LivePKCenterView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePKCenterView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        this.b = LazyKt.a(new Function0<LivePkCenterBinding>() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$mBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LivePkCenterBinding invoke() {
                LivePkCenterBinding a = LivePkCenterBinding.a(LayoutInflater.from(LivePKCenterView.this.getMContext()).inflate(R.layout.live_pk_center, LivePKCenterView.this));
                Intrinsics.c(a, "bind(rootView)");
                return a;
            }
        });
        f();
    }

    public /* synthetic */ LivePKCenterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(View view) {
        LiveInteractionModel liveInteractionModel = this.e;
        if (liveInteractionModel != null) {
            Intrinsics.a(liveInteractionModel);
            if (liveInteractionModel.whole_pk == null) {
                return;
            }
            LiveInteractionModel liveInteractionModel2 = this.e;
            Intrinsics.a(liveInteractionModel2);
            if (liveInteractionModel2.whole_pk.enable != 1) {
                LiveInteractionModel liveInteractionModel3 = this.e;
                Intrinsics.a(liveInteractionModel3);
                AppMethods.a((CharSequence) liveInteractionModel3.whole_pk.alert_message);
                return;
            }
            LiveConnectionView liveConnectionView = this.c;
            Intrinsics.a(liveConnectionView);
            liveConnectionView.setPKCurrentModel(1);
            a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$clickToWholePk$1
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    LiveConnectionView liveConnectionView2;
                    liveConnectionView2 = LivePKCenterView.this.c;
                    if (liveConnectionView2 == null) {
                        return;
                    }
                    liveConnectionView2.c();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePKCenterView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        a(this$0, null, 1, null);
    }

    public static /* synthetic */ void a(LivePKCenterView livePKCenterView, ILiveConnectionAnimListener iLiveConnectionAnimListener, int i, Object obj) {
        if ((i & 1) != 0) {
            iLiveConnectionAnimListener = null;
        }
        livePKCenterView.a(iLiveConnectionAnimListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePKCenterView this$0, Object obj) {
        Intrinsics.e(this$0, "this$0");
        ShapeTextView shapeTextView = this$0.getMBinding().l;
        Intrinsics.c(shapeTextView, "mBinding.viewDot");
        BluedViewExKt.a((View) shapeTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(View view) {
        LiveInteractionModel liveInteractionModel = this.e;
        if (liveInteractionModel != null) {
            Intrinsics.a(liveInteractionModel);
            if (liveInteractionModel.friend_pk == null) {
                return;
            }
            LiveInteractionModel liveInteractionModel2 = this.e;
            Intrinsics.a(liveInteractionModel2);
            if (liveInteractionModel2.friend_pk.enable == 1) {
                a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$clickToFriendPk$1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        LiveConnectionView liveConnectionView;
                        liveConnectionView = LivePKCenterView.this.c;
                        if (liveConnectionView == null) {
                            return;
                        }
                        liveConnectionView.a(true, 0);
                    }
                });
                return;
            }
            LiveInteractionModel liveInteractionModel3 = this.e;
            Intrinsics.a(liveInteractionModel3);
            AppMethods.a((CharSequence) liveInteractionModel3.friend_pk.alert_message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePKCenterView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        a(this$0, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(View view) {
        LiveInteractionModel liveInteractionModel = this.e;
        if (liveInteractionModel != null) {
            Intrinsics.a(liveInteractionModel);
            if (liveInteractionModel.multi_ligature == null) {
                return;
            }
            LiveInteractionModel liveInteractionModel2 = this.e;
            Intrinsics.a(liveInteractionModel2);
            if (liveInteractionModel2.multi_ligature.enable == 1) {
                c();
                return;
            }
            LiveInteractionModel liveInteractionModel3 = this.e;
            Intrinsics.a(liveInteractionModel3);
            AppMethods.a((CharSequence) liveInteractionModel3.multi_ligature.alert_message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(View view) {
        LiveInteractionModel liveInteractionModel = this.e;
        if (liveInteractionModel != null) {
            Intrinsics.a(liveInteractionModel);
            if (liveInteractionModel.friend_ligature == null) {
                return;
            }
            LiveInteractionModel liveInteractionModel2 = this.e;
            Intrinsics.a(liveInteractionModel2);
            if (liveInteractionModel2.friend_ligature.enable == 1) {
                a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$clickToFriendRtc$1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        LiveConnectionView liveConnectionView;
                        EventTrackLive.b(LiveProtos.Event.LIVE_MANY_CONNECT_CLICK, LiveRoomManager.a().e());
                        liveConnectionView = LivePKCenterView.this.c;
                        if (liveConnectionView == null) {
                            return;
                        }
                        liveConnectionView.a(true, 1);
                    }
                });
                return;
            }
            LiveInteractionModel liveInteractionModel3 = this.e;
            Intrinsics.a(liveInteractionModel3);
            AppMethods.a((CharSequence) liveInteractionModel3.friend_ligature.alert_message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(View view) {
        LiveInteractionModel liveInteractionModel;
        if (ClickUtils.a(R.id.live_pk_dared_btn) || (liveInteractionModel = this.e) == null) {
            return;
        }
        Intrinsics.a(liveInteractionModel);
        if (liveInteractionModel.challenge_pk == null) {
            return;
        }
        LiveInteractionModel liveInteractionModel2 = this.e;
        Intrinsics.a(liveInteractionModel2);
        if (liveInteractionModel2.challenge_pk.enable == 1) {
            EventTrackLive.a(LiveProtos.Event.LIVE_CENTER_CHALLENGE_PK_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid);
            d();
            return;
        }
        LiveInteractionModel liveInteractionModel3 = this.e;
        Intrinsics.a(liveInteractionModel3);
        AppMethods.a((CharSequence) liveInteractionModel3.challenge_pk.alert_message);
    }

    private final void f() {
        getMBinding().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$9Z5tKkXvL6bEBY2scCxMtXq7v3g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.a(LivePKCenterView.this, view);
            }
        });
        getMBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$PseUsPe8u9P936Kq5OMiVEXBcO4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.b(LivePKCenterView.this, view);
            }
        });
        getMBinding().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$5pK3sGmRDDVKwc_DeEGSBr4KPJo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.this.a(view);
            }
        });
        getMBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$5epPY6jB6PnV59fna-84zJVFo_Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.this.b(view);
            }
        });
        getMBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$VHVd61renOZVzN72H5NGyhyiwDw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.this.c(view);
            }
        });
        getMBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$vMd0COB9DLsR1HOHTJWssNU0pbg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.this.d(view);
            }
        });
        getMBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$NtRNgDl-fypbykTYGVgsU3VUFGA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.this.f(view);
            }
        });
        getMBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$WJUJ6no2y5kKaTZMh0N00nAi7fA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePKCenterView.this.e(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(View view) {
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXPLAIN_BUBBLE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LiveSetDataObserver.a().b(LiveRoomInfo.a().A(), DisplayUtil.a(AppInfo.d(), 13.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        LiveInteractionDetailModel liveInteractionDetailModel;
        String str;
        LiveInteractionDetailModel liveInteractionDetailModel2;
        String str2;
        LiveInteractionDetailModel liveInteractionDetailModel3;
        String str3;
        LiveInteractionDetailModel liveInteractionDetailModel4;
        String str4;
        LiveInteractionDetailModel liveInteractionDetailModel5;
        String str5;
        LiveInteractionModel liveInteractionModel = this.e;
        if (liveInteractionModel != null && (liveInteractionDetailModel5 = liveInteractionModel.whole_pk) != null && (str5 = liveInteractionDetailModel5.pic) != null) {
            ImageLoader.a((IRequestHost) null, str5).a(getMBinding().i);
        }
        LiveInteractionModel liveInteractionModel2 = this.e;
        if (liveInteractionModel2 != null && (liveInteractionDetailModel4 = liveInteractionModel2.friend_pk) != null && (str4 = liveInteractionDetailModel4.pic) != null) {
            ImageLoader.a((IRequestHost) null, str4).a(getMBinding().h);
        }
        LiveInteractionModel liveInteractionModel3 = this.e;
        if (liveInteractionModel3 != null && (liveInteractionDetailModel3 = liveInteractionModel3.friend_ligature) != null && (str3 = liveInteractionDetailModel3.pic) != null) {
            ImageLoader.a((IRequestHost) null, str3).a(getMBinding().j);
        }
        LiveInteractionModel liveInteractionModel4 = this.e;
        if (liveInteractionModel4 != null && (liveInteractionDetailModel2 = liveInteractionModel4.multi_ligature) != null && (str2 = liveInteractionDetailModel2.pic) != null) {
            ImageLoader.a((IRequestHost) null, str2).a(getMBinding().c);
        }
        LiveInteractionModel liveInteractionModel5 = this.e;
        if (liveInteractionModel5 == null || (liveInteractionDetailModel = liveInteractionModel5.challenge_pk) == null || (str = liveInteractionDetailModel.pic) == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, str).a(getMBinding().g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LivePkCenterBinding getMBinding() {
        return (LivePkCenterBinding) this.b.getValue();
    }

    public final void a(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (getMBinding().a.getVisibility() == 8) {
            return;
        }
        getMBinding().a.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.push_bottom_out);
        getMBinding().a.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$dismiss$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                LivePKCenterView.this.setVisibility(8);
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 == null) {
                    return;
                }
                iLiveConnectionAnimListener2.onAnimationEnd();
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
        ILiveConnectionStateListener iLiveConnectionStateListener = this.d;
        if (iLiveConnectionStateListener != null) {
            Intrinsics.a(iLiveConnectionStateListener);
            iLiveConnectionStateListener.b();
        }
    }

    public final void a(LiveConnectionView liveConnectionView) {
        RecordingOnliveFragment recordingOnliveFragment;
        this.c = liveConnectionView;
        this.d = liveConnectionView;
        if (liveConnectionView != null && (recordingOnliveFragment = liveConnectionView.a) != null) {
            this.f = recordingOnliveFragment.getFragmentActive();
        }
        if (!LiveRoomPreferences.Q() || this.c == null) {
            return;
        }
        ShapeTextView shapeTextView = getMBinding().l;
        Intrinsics.c(shapeTextView, "mBinding.viewDot");
        BluedViewExKt.b((View) shapeTextView);
        Observable observable = LiveEventBus.get(LiveEventBusUtil.D, Object.class);
        LiveConnectionView liveConnectionView2 = this.c;
        Intrinsics.a(liveConnectionView2);
        observable.observe(liveConnectionView2.a, new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LivePKCenterView$DgDrLrzqH5uP-JnRa6TADJzb4ao
            public final void onChanged(Object obj) {
                LivePKCenterView.a(LivePKCenterView.this, obj);
            }
        });
    }

    public final void a(final boolean z) {
        setVisibility(0);
        getMBinding().a.setVisibility(0);
        getMBinding().a.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.a, R.anim.push_bottom_in);
        getMBinding().a.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$show$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.e(animation, "animation");
                if (z) {
                    this.getInteraction();
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
        ILiveConnectionStateListener iLiveConnectionStateListener = this.d;
        if (iLiveConnectionStateListener != null) {
            Intrinsics.a(iLiveConnectionStateListener);
            iLiveConnectionStateListener.a();
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_EXPLAIN_BUBBLE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        EventTrackLive.a(LiveProtos.Event.LIVE_CENTER_CHALLENGE_PK_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid);
    }

    public final boolean a() {
        return getVisibility() == 0;
    }

    public final void b() {
        a(this, null, 1, null);
    }

    public final void c() {
        LiveConnectionView liveConnectionView = this.c;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.a.getFragmentActive();
        LiveRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntity<LiveFriendExtraModel, LiveFriendExtraModel>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LivePKCenterView$startMakeFriend$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LivePkCenterBinding mBinding;
                super.onUIFinish();
                mBinding = LivePKCenterView.this.getMBinding();
                mBinding.k.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LivePkCenterBinding mBinding;
                super.onUIStart();
                mBinding = LivePKCenterView.this.getMBinding();
                mBinding.k.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(final BluedEntity<LiveFriendExtraModel, LiveFriendExtraModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                final LivePKCenterView livePKCenterView = LivePKCenterView.this;
                livePKCenterView.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$startMakeFriend$1$onUIUpdate$1
                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
                        r0 = r5.c;
                     */
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onAnimationEnd() {
                        /*
                            r3 = this;
                            r0 = r3
                            com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.live_china.model.LiveFriendExtraModel, com.blued.android.module.live_china.model.LiveFriendExtraModel> r0 = r4
                            S extends com.blued.android.framework.http.parser.BluedEntityBaseExtra r0 = r0.extra
                            if (r0 == 0) goto L49
                            r0 = r3
                            com.blued.android.module.live_china.view.LivePKCenterView r0 = r5
                            com.blued.android.module.live_china.view.LiveConnectionView r0 = com.blued.android.module.live_china.view.LivePKCenterView.a(r0)
                            r6 = r0
                            r0 = r6
                            if (r0 != 0) goto L17
                            return
                        L17:
                            r0 = r6
                            com.blued.android.module.live_china.fragment.RecordingOnliveFragment r0 = r0.a
                            r6 = r0
                            r0 = r6
                            if (r0 != 0) goto L21
                            return
                        L21:
                            r0 = r3
                            com.blued.android.framework.http.parser.BluedEntity<com.blued.android.module.live_china.model.LiveFriendExtraModel, com.blued.android.module.live_china.model.LiveFriendExtraModel> r0 = r4
                            S extends com.blued.android.framework.http.parser.BluedEntityBaseExtra r0 = r0.extra
                            r7 = r0
                            r0 = r7
                            kotlin.jvm.internal.Intrinsics.a(r0)
                            r0 = r7
                            com.blued.android.module.live_china.model.LiveFriendExtraModel r0 = (com.blued.android.module.live_china.model.LiveFriendExtraModel) r0
                            int r0 = r0.is_access_control
                            r4 = r0
                            r0 = 1
                            r5 = r0
                            r0 = r4
                            r1 = 1
                            if (r0 != r1) goto L42
                            goto L44
                        L42:
                            r0 = 0
                            r5 = r0
                        L44:
                            r0 = r6
                            r1 = r5
                            r0.g(r1)
                        L49:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LivePKCenterView$startMakeFriend$1$onUIUpdate$1.onAnimationEnd():void");
                    }
                });
            }
        });
    }

    public final void d() {
        LiveConnectionView liveConnectionView = this.c;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.a.getFragmentActive();
        BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LivePKCenterView$startDaredPk$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LivePkCenterBinding mBinding;
                super.onUIFinish();
                mBinding = LivePKCenterView.this.getMBinding();
                mBinding.k.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LivePkCenterBinding mBinding;
                super.onUIStart();
                mBinding = LivePKCenterView.this.getMBinding();
                mBinding.k.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(final BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LivePKCenterView.this.a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKCenterView$startDaredPk$1$onUIUpdate$1
                    @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                    public void onAnimationEnd() {
                        LiveDaredPKExtraModel liveDaredPKExtraModel;
                        BluedEntity<BluedEntityBaseExtra, LiveDaredPKExtraModel> bluedEntity2 = bluedEntity;
                        if (bluedEntity2 == null || (liveDaredPKExtraModel = bluedEntity2.extra) == null) {
                            return;
                        }
                        PkDaredObserver.a().a(liveDaredPKExtraModel.countdown);
                    }
                });
            }
        };
        LiveConnectionView liveConnectionView2 = this.c;
        Intrinsics.a(liveConnectionView2);
        LiveRoomHttpUtils.c(bluedUIHttpResponse, liveConnectionView2.a.getFragmentActive());
    }

    public final void e() {
        a(this, null, 1, null);
    }

    public final Unit getInteraction() {
        final IRequestHost iRequestHost = this.f;
        LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<LiveInteractionModel, GrabBoxDetailModel>>(iRequestHost) { // from class: com.blued.android.module.live_china.view.LivePKCenterView$interaction$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                LivePkCenterBinding mBinding;
                mBinding = LivePKCenterView.this.getMBinding();
                mBinding.k.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                LivePkCenterBinding mBinding;
                super.onUIStart();
                mBinding = LivePKCenterView.this.getMBinding();
                mBinding.k.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveInteractionModel, GrabBoxDetailModel> bluedEntity) {
                LiveInteractionModel liveInteractionModel;
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    return;
                }
                LivePKCenterView.this.e = bluedEntity.data.get(0);
                liveInteractionModel = LivePKCenterView.this.e;
                if (liveInteractionModel == null) {
                    return;
                }
                LivePKCenterView.this.g();
            }
        });
        return Unit.a;
    }

    public final Context getMContext() {
        return this.a;
    }
}
