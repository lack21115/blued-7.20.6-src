package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveMultiConnectionTitleViewBinding;
import com.blued.android.module.live_china.dialog.LiveDialogTip;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMultiPKTitle.class */
public final class LiveMultiPKTitle extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private BaseFragment f14673a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private LiveInviteUserModel f14674c;
    private CountDownTimer d;
    private CountDownTimer e;
    private boolean f;
    private final Lazy g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKTitle(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveMultiPKTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f14674c = new LiveInviteUserModel();
        this.g = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMultiConnectionTitleViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMultiConnectionTitleViewBinding invoke() {
                return LiveMultiConnectionTitleViewBinding.a(LayoutInflater.from(LiveMultiPKTitle.this.getContext()), LiveMultiPKTitle.this, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMultiPKTitle this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f14674c.isGroup()) {
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_RULE_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        }
        LiveSetDataObserver.a().b(LiveRoomInfo.a().A(), 0);
    }

    public final void a() {
        d();
        e();
        final long j = (this.f14674c.durationRemain > 0 ? this.f14674c.durationRemain : this.f14674c.duration) * 1000;
        this.d = new CountDownTimer(j) { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$startPkTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveMultiPKTitle.this.getItem().durationRemain = 0;
                if (LiveMultiPKTitle.this.getRecord()) {
                    LiveMultiPKTitle.this.f();
                    LiveMultiPKTitle.this.c();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                long j3 = (j2 / 1000) + 1;
                int i = (int) j3;
                LiveMultiPKTitle.this.getItem().durationRemain = i;
                LiveMultiPKTitle.this.getViewBinding().d.setText(LiveTimeAndDateUtils.a(j3, false));
                if (LiveMultiPKTitle.this.getRecord()) {
                    if (LiveMultiPKTitle.this.getItem().duration - j3 == LiveMultiPKTitle.this.getItem().buff_time && LiveMultiPKTitle.this.getItem().buff_time > 0) {
                        LiveMultiPKTitle.this.a("1");
                    }
                    if (LiveMultiPKTitle.this.getItem().duration - j3 == LiveMultiPKTitle.this.getItem().fb_time && LiveMultiPKTitle.this.getItem().fb_time > 0) {
                        LiveMultiPKTitle.this.a("2");
                    }
                }
                if (i == 5) {
                    ((LiveMultiPkCountDownView) LiveMultiPKTitle.this.findViewById(R.id.count_down_view)).a();
                }
            }
        }.start();
    }

    public final void a(String type) {
        Intrinsics.e(type, "type");
        if (ArraysKt.a(new int[]{12, 13}, LiveRoomManager.a().m())) {
            LiveRoomHttpUtils.b(type, new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$reportPkBarrage$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                }
            });
        }
    }

    public final void b() {
        d();
        e();
        this.f14674c.status = 2;
        final long j = (this.f14674c.durationRemainPKEnd > 0 ? this.f14674c.durationRemainPKEnd : this.f14674c.duration) * 1000;
        this.d = new CountDownTimer(j) { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$startPunishTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                LiveMultiPKTitle.this.getItem().durationRemainPKEnd = 0;
                if (LiveMultiPKTitle.this.getContext() == null) {
                    return;
                }
                LiveEventBus.get("live_multi_pk_stop").post(true);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (LiveMultiPKTitle.this.getContext() == null) {
                    return;
                }
                long j3 = (j2 / 1000) + 1;
                LiveMultiPKTitle.this.getItem().durationRemainPKEnd = (int) j3;
                TextView textView = LiveMultiPKTitle.this.getViewBinding().d;
                textView.setText(LiveMultiPKTitle.this.getItem().interaction_text + ' ' + ((Object) LiveTimeAndDateUtils.a(j3, false)));
            }
        }.start();
    }

    public final void c() {
        e();
        this.e = new CountDownTimer(5000L) { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$postExceptionTask$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (LiveMultiPKTitle.this.getContext() == null || LiveMultiPKTitle.this.getBaseFragment() == null) {
                    return;
                }
                BaseFragment baseFragment = LiveMultiPKTitle.this.getBaseFragment();
                Intrinsics.a(baseFragment);
                if (baseFragment.getFragmentActive() != null) {
                    BaseFragment baseFragment2 = LiveMultiPKTitle.this.getBaseFragment();
                    Intrinsics.a(baseFragment2);
                    ActivityFragmentActive fragmentActive = baseFragment2.getFragmentActive();
                    Intrinsics.a(fragmentActive);
                    if (fragmentActive.isActive()) {
                        BaseFragment baseFragment3 = LiveMultiPKTitle.this.getBaseFragment();
                        Intrinsics.a(baseFragment3);
                        if (baseFragment3.getContext() != null) {
                            BaseFragment baseFragment4 = LiveMultiPKTitle.this.getBaseFragment();
                            Intrinsics.a(baseFragment4);
                            Context requireContext = baseFragment4.requireContext();
                            String string = LiveMultiPKTitle.this.getResources().getString(R.string.live_wenxin_tip);
                            String string2 = LiveMultiPKTitle.this.getResources().getString(R.string.live_pk_connect_fail);
                            final LiveMultiPKTitle liveMultiPKTitle = LiveMultiPKTitle.this;
                            new LiveDialogTip(requireContext, string, string2, new LiveDialogTip.IEventCallback() { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$postExceptionTask$1$onFinish$1
                                @Override // com.blued.android.module.live_china.dialog.LiveDialogTip.IEventCallback
                                public void a() {
                                    final LiveMultiPKTitle liveMultiPKTitle2 = LiveMultiPKTitle.this;
                                    LiveRoomHttpUtils.a("5", new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$postExceptionTask$1$onFinish$1$confirm$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(null);
                                        }

                                        /* JADX INFO: Access modifiers changed from: protected */
                                        @Override // com.blued.android.framework.http.BluedUIHttpResponse
                                        /* renamed from: a */
                                        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                                            if (LiveMultiPKTitle.this.getBaseFragment() instanceof RecordingOnliveFragment) {
                                                BaseFragment baseFragment5 = LiveMultiPKTitle.this.getBaseFragment();
                                                if (baseFragment5 == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.RecordingOnliveFragment");
                                                }
                                                ((RecordingOnliveFragment) baseFragment5).bf();
                                            }
                                        }
                                    });
                                }
                            }).show();
                        }
                    }
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    public final void d() {
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    public final void e() {
        CountDownTimer countDownTimer = this.e;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    public final void f() {
        if (ArraysKt.a(new int[]{12, 13}, LiveRoomManager.a().m())) {
            LiveRoomHttpUtils.s(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.blued.android.module.live_china.view.LiveMultiPKTitle$endPk$1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                }
            });
        }
    }

    public final void g() {
        d();
        e();
        this.f14674c.status = 0;
        this.f14674c.durationRemain = 0;
        this.f14674c.durationRemainPKEnd = 0;
        setTitle(this.f14674c);
    }

    public final boolean getAttatch() {
        return this.b;
    }

    public final BaseFragment getBaseFragment() {
        return this.f14673a;
    }

    public final LiveInviteUserModel getItem() {
        return this.f14674c;
    }

    public final boolean getRecord() {
        return this.f;
    }

    public final LiveMultiConnectionTitleViewBinding getViewBinding() {
        return (LiveMultiConnectionTitleViewBinding) this.g.getValue();
    }

    public final void h() {
        d();
        e();
        this.f14673a = null;
        setVisibility(8);
        this.b = false;
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
        h();
        super.onDetachedFromWindow();
    }

    public final void setAttatch(boolean z) {
        this.b = z;
    }

    public final void setBaseFragment(BaseFragment baseFragment) {
        this.f14673a = baseFragment;
    }

    public final void setFragment(BaseFragment baseFragment) {
        this.f14673a = baseFragment;
    }

    public final void setItem(LiveInviteUserModel liveInviteUserModel) {
        Intrinsics.e(liveInviteUserModel, "<set-?>");
        this.f14674c = liveInviteUserModel;
    }

    public final void setRecord(boolean z) {
        this.f = z;
    }

    public final void setTitle(LiveInviteUserModel model) {
        Intrinsics.e(model, "model");
        this.f14674c = model;
        this.f = TextUtils.equals(LiveRoomManager.a().g(), LiveRoomInfo.a().f());
        ViewGroup.LayoutParams layoutParams = getViewBinding().d.getLayoutParams();
        if (LiveRoomManager.a().m() == 10) {
            this.f14674c.durationRemain = 0;
            this.f14674c.durationRemainPKEnd = 0;
            getViewBinding().b.setVisibility(0);
            getViewBinding().b.setImageResource(R.drawable.live_multi_connection_icon_small);
            getViewBinding().d.setText(this.f ? R.string.live_invite_connecting_tip : R.string.live_invite_connecting_live_tip);
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = DensityUtils.a(getContext(), 0.0f);
            }
            d();
            ImageView imageView = getViewBinding().f12290c;
            Intrinsics.c(imageView, "viewBinding.ivInfo");
            BluedViewExKt.a(imageView);
            Space space = getViewBinding().e;
            Intrinsics.c(space, "viewBinding.viewSpace");
            BluedViewExKt.b(space);
        } else {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = DensityUtils.a(getContext(), 0.5f);
            }
            if (this.f14674c.status == 1) {
                getViewBinding().b.setVisibility(0);
                if (this.f14674c.my_count == 1) {
                    if (this.f14674c.other_count == 2) {
                        getViewBinding().b.setImageResource(R.drawable.live_multi_pk_1v2);
                    } else if (this.f14674c.other_count == 3) {
                        getViewBinding().b.setImageResource(R.drawable.live_multi_pk_1v3);
                    } else {
                        getViewBinding().b.setImageResource(R.drawable.live_multi_pk_icon);
                    }
                } else if (this.f14674c.my_count == 2) {
                    if (this.f14674c.other_count == 1) {
                        getViewBinding().b.setImageResource(R.drawable.live_multi_pk_2v1);
                    } else if (this.f14674c.other_count == 2) {
                        getViewBinding().b.setImageResource(R.drawable.live_multi_pk_2v2);
                    } else {
                        getViewBinding().b.setImageResource(R.drawable.live_multi_pk_icon);
                    }
                } else if (this.f14674c.my_count != 3) {
                    getViewBinding().b.setImageResource(R.drawable.live_multi_pk_icon);
                } else if (this.f14674c.other_count == 1) {
                    getViewBinding().b.setImageResource(R.drawable.live_multi_pk_3v1);
                } else {
                    getViewBinding().b.setImageResource(R.drawable.live_multi_pk_icon);
                }
                a();
            } else if (this.f14674c.status == 2) {
                getViewBinding().b.setVisibility(8);
                b();
            }
            ImageView imageView2 = getViewBinding().f12290c;
            Intrinsics.c(imageView2, "viewBinding.ivInfo");
            BluedViewExKt.b(imageView2);
            Space space2 = getViewBinding().e;
            Intrinsics.c(space2, "viewBinding.viewSpace");
            BluedViewExKt.a(space2);
            getViewBinding().f12290c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveMultiPKTitle$6OhsZyqRWsuj8viGRzP2G9mgWoY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveMultiPKTitle.a(LiveMultiPKTitle.this, view);
                }
            });
        }
        getViewBinding().d.setLayoutParams(layoutParams);
    }
}
