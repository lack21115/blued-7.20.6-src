package com.blued.android.module.live_china.view;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveConnectPkViewBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGroupPkUserModel;
import com.blued.android.module.live_china.model.LiveInviteUserModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveConnectPKView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectPKView.class */
public final class LiveConnectPKView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14413a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14414c;
    private ArrayList<LiveInviteUserModel> d;
    private ArrayList<LiveGroupPkUserModel> e;
    private LiveConnectionView f;
    private ILiveConnectionStateListener g;
    private ArrayList<LiveConnectPKUserItemView> h;
    private View i;
    private View j;
    private int k;
    private final OvershootInterpolator l;
    private final int m;
    private final int n;
    private final Lazy o;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectPKView$ExitDialog.class */
    public static final class ExitDialog extends LiveBottomDialog {

        /* renamed from: a  reason: collision with root package name */
        private final LiveConnectPKView f14417a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ExitDialog(Context context, LiveConnectPKView liveConnectPKView) {
            super(context);
            Intrinsics.e(liveConnectPKView, "liveConnectPKView");
            this.f14417a = liveConnectPKView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(ExitDialog this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            this$0.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ExitDialog this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_EXIT_YES_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            this$0.dismiss();
            this$0.f14417a.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ExitDialog this$0, View view) {
            Intrinsics.e(this$0, "this$0");
            EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_EXIT_NO_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            this$0.dismiss();
        }

        @Override // com.blued.android.module.live_china.view.LiveBottomDialog
        public void b() {
            setContentView(R.layout.live_multi_exit_confirm_layout);
            findViewById(R.id.root_view).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$ExitDialog$SCEmjP7o1d85ncuiTz2RCu8CBNg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveConnectPKView.ExitDialog.a(LiveConnectPKView.ExitDialog.this, view);
                }
            });
            ((TextView) findViewById(R.id.tv_exit)).setText(AppInfo.d().getString(R.string.live_multi_pk_exit_tip));
            ((TextView) findViewById(R.id.tv_cancel)).setText(AppInfo.d().getString(R.string.live_multi_pk_exit_cancel));
            findViewById(R.id.tv_exit).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$ExitDialog$h2BKvgY5pbXUOBTSDJLrtWqBO28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveConnectPKView.ExitDialog.b(LiveConnectPKView.ExitDialog.this, view);
                }
            });
            findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$ExitDialog$STTV3cNmx2yrhdXtX9RE0E0ZOyw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveConnectPKView.ExitDialog.c(LiveConnectPKView.ExitDialog.this, view);
                }
            });
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConnectPKView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveConnectPKView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveConnectPKView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.f14413a = mContext;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.h = new ArrayList<>();
        this.l = new OvershootInterpolator(1.0f);
        this.m = ContextCompat.getColor(getContext(), R.color.syc_dark_222);
        this.n = ContextCompat.getColor(getContext(), R.color.syc_dark_777777);
        this.o = LazyKt.a(new Function0<LiveConnectPkViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveConnectPkViewBinding invoke() {
                LiveConnectPkViewBinding a2 = LiveConnectPkViewBinding.a(LayoutInflater.from(LiveConnectPKView.this.getMContext()).inflate(R.layout.live_connect_pk_view, LiveConnectPKView.this));
                Intrinsics.c(a2, "bind(\n            Layout…_pk_view, this)\n        )");
                return a2;
            }
        });
        j();
        getVb().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$sof89QgPaQSJeolYusuhUYI4tkM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConnectPKView.a(LiveConnectPKView.this, view);
            }
        });
        getVb().f12163a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$PYrnBaAT5aFjvYHcYb8T1KEAXRw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConnectPKView.b(LiveConnectPKView.this, view);
            }
        });
        getVb().j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$UhjAFezDKiF4Eu83kzcel91Xj2Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConnectPKView.c(LiveConnectPKView.this, view);
            }
        });
        getVb().k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$oIOuZl9iunS6eUkKvt8etpVo8B4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveConnectPKView.d(LiveConnectPKView.this, view);
            }
        });
        getVb().l.getPaint().setFakeBoldText(true);
        getVb().f12163a.getPaint().setFakeBoldText(true);
        setCurrentTab(1);
    }

    public /* synthetic */ LiveConnectPKView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final LiveConnectPKUserItemView a(long j) {
        LiveConnectPKUserItemView liveConnectPKUserItemView = null;
        for (LiveConnectPKUserItemView liveConnectPKUserItemView2 : this.h) {
            if (liveConnectPKUserItemView2.getParent() == null) {
                if (liveConnectPKUserItemView2.getLastUid() == j) {
                    return liveConnectPKUserItemView2;
                }
                if (liveConnectPKUserItemView2.getUid() == -2 && liveConnectPKUserItemView == null) {
                    liveConnectPKUserItemView = liveConnectPKUserItemView2;
                }
            }
        }
        return liveConnectPKUserItemView;
    }

    private final void a(final int i) {
        int intValue;
        if (this.k == i) {
            return;
        }
        this.k = i;
        ViewGroup.LayoutParams layoutParams = getVb().t.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        ((LinearLayout.LayoutParams) layoutParams).weight = 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new OvershootInterpolator(1.0f));
        ViewGroup.LayoutParams layoutParams2 = getVb().t.getLayoutParams();
        Integer valueOf = layoutParams2 == null ? null : Integer.valueOf(layoutParams2.width);
        Intrinsics.a(valueOf);
        if (valueOf.intValue() < 0) {
            intValue = getVb().t.getWidth();
        } else {
            ViewGroup.LayoutParams layoutParams3 = getVb().t.getLayoutParams();
            Integer valueOf2 = layoutParams3 == null ? null : Integer.valueOf(layoutParams3.width);
            Intrinsics.a(valueOf2);
            intValue = valueOf2.intValue();
        }
        final int i2 = intValue;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$A5a6hytcgzl4Sfc6H8aBULbBXXs
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                LiveConnectPKView.a(LiveConnectPKView.this, i2, i, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConnectPKView this$0, int i, int i2, ValueAnimator animation) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
        float floatValue = ((Float) animatedValue).floatValue();
        ViewGroup.LayoutParams layoutParams = this$0.getVb().t.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (i - ((i - i2) * floatValue));
        }
        this$0.getVb().t.setLayoutParams(this$0.getVb().t.getLayoutParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final LiveConnectPKView this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        LiveConnectionView liveConnectionView = this$0.f;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.f14428a.getFragmentActive();
        BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$3$1$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable error, int i2, String content) {
                Intrinsics.e(error, "error");
                Intrinsics.e(content, "content");
                super.onFailure(error, i2, content);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectPKView.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveConnectPKView.this.a(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
            }
        };
        LiveConnectionView liveConnectionView2 = this$0.f;
        Intrinsics.a(liveConnectionView2);
        LiveRoomHttpUtils.a(2, (List<LiveGroupPkUserModel>) null, bluedUIHttpResponse, liveConnectionView2.f14428a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConnectPKView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConnectPKView this$0, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveConnectPKView this$0, Object obj) {
        Intrinsics.e(this$0, "this$0");
        ShapeTextView shapeTextView = this$0.getVb().s;
        Intrinsics.c(shapeTextView, "vb.viewDot");
        BluedViewExKt.a(shapeTextView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(boolean z) {
        if (!z) {
            ProgressBar progressBar = getVb().h;
            Intrinsics.c(progressBar, "vb.loading");
            BluedViewExKt.a(progressBar);
            return;
        }
        getVb().h.setAlpha(0.0f);
        getVb().h.setScaleX(0.0f);
        getVb().h.setScaleY(0.0f);
        ProgressBar progressBar2 = getVb().h;
        Intrinsics.c(progressBar2, "vb.loading");
        BluedViewExKt.b(progressBar2);
        getVb().h.animate().alpha(1.0f).scaleX(1.0f).scaleY(1.0f).setDuration(200L).setStartDelay(250L).start();
    }

    private final LiveInviteUserModel b(long j) {
        ArrayList<LiveInviteUserModel> arrayList = this.d;
        if (arrayList == null) {
            return null;
        }
        for (LiveInviteUserModel liveInviteUserModel : arrayList) {
            if (Intrinsics.a((Object) String.valueOf(j), (Object) liveInviteUserModel.uid)) {
                return liveInviteUserModel;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveConnectPKView this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.setPKIng(true);
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveConnectPKView this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        LiveConnectionView liveConnectionView = this$0.f;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.f14428a.getFragmentActive();
        BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$4$2$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable error, int i2, String content) {
                Intrinsics.e(error, "error");
                Intrinsics.e(content, "content");
                super.onFailure(error, i2, content);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectPKView.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveConnectPKView.this.a(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
            }
        };
        LiveConnectionView liveConnectionView2 = this$0.f;
        Intrinsics.a(liveConnectionView2);
        LiveRoomHttpUtils.a(3, (List<LiveGroupPkUserModel>) null, bluedUIHttpResponse, liveConnectionView2.f14428a.getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveConnectPKView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.f14414c) {
            this$0.h();
        } else if (this$0.b(true)) {
            if (this$0.b == 2) {
                this$0.r();
            } else {
                this$0.q();
            }
        }
    }

    private final boolean b(boolean z) {
        if (this.b != 2) {
            int i = 0;
            for (LiveInviteUserModel liveInviteUserModel : this.d) {
                if (liveInviteUserModel != null) {
                    String str = liveInviteUserModel.uid;
                    if (!(str == null || str.length() == 0)) {
                        String str2 = liveInviteUserModel.uid;
                        Intrinsics.c(str2, "it.uid");
                        if (Integer.parseInt(str2) > 0) {
                            i++;
                        }
                    }
                }
            }
            if (i <= 1) {
                if (z) {
                    ToastUtils.b(R.string.group_pk_each_count_min);
                    return false;
                }
                return false;
            }
            return true;
        }
        int i2 = 0;
        int i3 = 0;
        for (LiveGroupPkUserModel liveGroupPkUserModel : this.e) {
            if (liveGroupPkUserModel.getGroup_id() == 1 && liveGroupPkUserModel.getUid() > 0) {
                i2++;
            } else if (liveGroupPkUserModel.getGroup_id() == 2 && liveGroupPkUserModel.getUid() > 0) {
                i3++;
            }
        }
        if (i2 <= 0 || i3 <= 0) {
            if (z) {
                ToastUtils.b(R.string.group_pk_count_min);
                return false;
            }
            return false;
        } else if (i2 + i3 <= 2) {
            if (z) {
                ToastUtils.b(R.string.group_pk_switch_failure);
                return false;
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final LiveConnectPKView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.b == 1) {
            return;
        }
        new BluedAlertDialog.Builder(this$0.getContext()).d(R.string.group_pk_dialog_switch_dialog_each_title).e(R.string.group_pk_dialog_switch_dialog_each_subtitle).a(R.string.group_pk_dialog_switch_dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$ak7cN3DyoE0tuMSLRUtsOy-h36Q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveConnectPKView.a(LiveConnectPKView.this, dialogInterface, i);
            }
        }).b(R.string.group_pk_dialog_switch_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$DgwMS1xC_4aMc8Dnf41dyrGDbj4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveConnectPKView.a(dialogInterface, i);
            }
        }).f(R.color.syc_dark_3599FF).g(R.color.syc_dark_A5A6B3).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(final LiveConnectPKView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.b == 2) {
            return;
        }
        int i = 0;
        for (LiveInviteUserModel liveInviteUserModel : this$0.d) {
            if (liveInviteUserModel != null) {
                String str = liveInviteUserModel.uid;
                if (!(str == null || str.length() == 0)) {
                    String str2 = liveInviteUserModel.uid;
                    Intrinsics.c(str2, "it.uid");
                    if (Integer.parseInt(str2) > 0) {
                        i++;
                    }
                }
            }
        }
        if (i <= 2) {
            ToastUtils.b(R.string.group_pk_switch_failure);
        } else {
            new BluedAlertDialog.Builder(this$0.getContext()).d(R.string.group_pk_dialog_switch_dialog_group_title).e(R.string.group_pk_dialog_switch_dialog_group_subtitle).a(R.string.group_pk_dialog_switch_dialog_confirm, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$qdaNLZN0MUKFo14Jq1ds8e24QBE
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    LiveConnectPKView.b(LiveConnectPKView.this, dialogInterface, i2);
                }
            }).b(R.string.group_pk_dialog_switch_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$lDaZttirlgkCNG0jnLXE2ECHvjU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    LiveConnectPKView.b(dialogInterface, i2);
                }
            }).f(R.color.syc_dark_3599FF).g(R.color.syc_dark_A5A6B3).a().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveConnectPKView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveConnectPKView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.s();
    }

    private final LiveConnectPkViewBinding getVb() {
        return (LiveConnectPkViewBinding) this.o.getValue();
    }

    private final void j() {
        LayoutTransition layoutTransition = new LayoutTransition();
        View view = null;
        layoutTransition.setAnimator(2, ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 1.0f));
        layoutTransition.setAnimator(3, ObjectAnimator.ofFloat((Object) null, "alpha", 1.0f, 1.0f));
        layoutTransition.setInterpolator(0, new OvershootInterpolator(0.8f));
        layoutTransition.setDuration(400L);
        getVb().f.setLayoutTransition(layoutTransition);
        ImageView imageView = getVb().e;
        Intrinsics.c(imageView, "vb.ivPkCloak");
        this.i = imageView;
        View view2 = getVb().q;
        Intrinsics.c(view2, "vb.viewCarry");
        this.j = view2;
        this.h.add(getVb().m);
        this.h.add(getVb().n);
        this.h.add(getVb().o);
        this.h.add(getVb().p);
        View view3 = this.i;
        if (view3 == null) {
            Intrinsics.c("ivPkCloakView");
        } else {
            view = view3;
        }
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$QknxdVj9pMryPxpoTFoymjL5Y_0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view4, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                LiveConnectPKView.a(LiveConnectPKView.this, view4, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    private final void k() {
        o();
        getVb().g.animate().alpha(0.0f).setDuration(300L).start();
        getVb().f12163a.animate().translationY(0.0f).setDuration(300L).setInterpolator(this.l).start();
        getVb().i.animate().alpha(1.0f).setDuration(300L).start();
        getVb().r.animate().translationX(0.0f).setDuration(300L).setInterpolator(this.l).start();
        ObjectAnimator.ofArgb(getVb().k, "TextColor", this.m, this.n).setDuration(200L).start();
        getVb().k.getPaint().setFakeBoldText(false);
        ObjectAnimator.ofArgb(getVb().j, "TextColor", this.n, this.m).setDuration(200L).start();
        getVb().j.getPaint().setFakeBoldText(true);
        this.k = 0;
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_PERSONAL_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    private final void l() {
        ShapeTextView shapeTextView = getVb().s;
        Intrinsics.c(shapeTextView, "vb.viewDot");
        if (shapeTextView.getVisibility() == 0) {
            LiveRoomPreferences.R();
            LiveEventBusUtil.d();
        }
        n();
        getVb().g.animate().alpha(1.0f).setDuration(300L).start();
        getVb().f12163a.animate().translationY(DisplayUtil.a(AppInfo.d(), 16.0f)).setDuration(300L).setInterpolator(this.l).start();
        getVb().i.animate().alpha(0.0f).setDuration(300L).start();
        getVb().r.animate().translationX(DensityUtils.a(getContext(), 75.0f)).setDuration(300L).setInterpolator(this.l).start();
        ObjectAnimator.ofArgb(getVb().j, "TextColor", this.m, this.n).setDuration(200L).start();
        getVb().j.getPaint().setFakeBoldText(false);
        ObjectAnimator.ofArgb(getVb().k, "TextColor", this.n, this.m).setDuration(200L).start();
        getVb().k.getPaint().setFakeBoldText(true);
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_TEAM_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    private final void m() {
        for (LiveConnectPKUserItemView liveConnectPKUserItemView : this.h) {
            liveConnectPKUserItemView.setUid(-2L);
            liveConnectPKUserItemView.setGroup(this.b == 2);
            liveConnectPKUserItemView.setPKIng(this.f14414c);
            View switchBtn = liveConnectPKUserItemView.getSwitchBtn();
            if (switchBtn != null) {
                switchBtn.setOnClickListener(null);
            }
        }
    }

    private final void n() {
        getVb().d.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).setInterpolator(this.l).start();
    }

    private final void o() {
        getVb().d.animate().scaleX(0.3f).scaleY(0.65f).setDuration(200L).setInterpolator(new AnticipateInterpolator(1.0f)).start();
    }

    private final void p() {
        if (this.f14414c) {
            TextView textView = getVb().l;
            Intrinsics.c(textView, "vb.tvTitlePkIng");
            BluedViewExKt.b(textView);
            CardView cardView = getVb().f12164c;
            Intrinsics.c(cardView, "vb.cvTabRoot");
            BluedViewExKt.a(cardView);
            for (LiveConnectPKUserItemView liveConnectPKUserItemView : this.h) {
                liveConnectPKUserItemView.setPKIng(true);
            }
            getVb().g.getLayoutParams().height = DisplayUtil.a(AppInfo.d(), 97.5f);
            getVb().g.setLayoutParams(getVb().g.getLayoutParams());
            t();
            getVb().f12163a.animate().translationY(0.0f).setDuration(300L).setInterpolator(this.l).start();
            getVb().i.setText(getContext().getText(R.string.group_pk_ing_tips));
            getVb().i.animate().alpha(1.0f).setDuration(300L).start();
            return;
        }
        TextView textView2 = getVb().l;
        Intrinsics.c(textView2, "vb.tvTitlePkIng");
        BluedViewExKt.a(textView2);
        CardView cardView2 = getVb().f12164c;
        Intrinsics.c(cardView2, "vb.cvTabRoot");
        BluedViewExKt.b(cardView2);
        for (LiveConnectPKUserItemView liveConnectPKUserItemView2 : this.h) {
            liveConnectPKUserItemView2.setPKIng(false);
        }
        getVb().g.getLayoutParams().height = DisplayUtil.a(AppInfo.d(), 110.0f);
        getVb().g.setLayoutParams(getVb().g.getLayoutParams());
        t();
        getVb().f12163a.animate().translationY(DisplayUtil.a(AppInfo.d(), this.b == 1 ? 0.0f : 16.0f)).setDuration(300L).setInterpolator(this.l).start();
        getVb().i.setText(getContext().getText(R.string.live_invite_pk_cancel_tip));
        getVb().i.animate().alpha(this.b == 1 ? 1.0f : 0.0f).setDuration(300L).start();
    }

    private final void q() {
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_PERSONAL_PAGE_START_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        LiveConnectionView liveConnectionView = this.f;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.f14428a.getFragmentActive();
        LiveRoomHttpUtils.r(new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$startPkToEach$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable error, int i, String content) {
                Intrinsics.e(error, "error");
                Intrinsics.e(content, "content");
                super.onFailure(error, i, content);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectPKView.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveConnectPKView.this.a(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                LiveConnectPKView.this.e();
            }
        });
    }

    private final void r() {
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_TEAM_PAGE_START_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        ArrayList<LiveGroupPkUserModel> arrayList = this.e;
        LiveConnectionView liveConnectionView = this.f;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.f14428a.getFragmentActive();
        BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$startPkToGroup$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable error, int i, String content) {
                Intrinsics.e(error, "error");
                Intrinsics.e(content, "content");
                super.onFailure(error, i, content);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectPKView.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveConnectPKView.this.a(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                LiveConnectPKView.this.e();
            }
        };
        LiveConnectionView liveConnectionView2 = this.f;
        Intrinsics.a(liveConnectionView2);
        LiveRoomHttpUtils.b(arrayList, bluedUIHttpResponse, liveConnectionView2.f14428a.getFragmentActive());
    }

    private final void s() {
        int i = 0;
        int i2 = 0;
        for (LiveGroupPkUserModel liveGroupPkUserModel : this.e) {
            if (liveGroupPkUserModel.getUid() == LiveRoomInfo.a().g()) {
                i2 = liveGroupPkUserModel.getGroup_id();
            }
        }
        int i3 = 0;
        for (LiveGroupPkUserModel liveGroupPkUserModel2 : this.e) {
            if (liveGroupPkUserModel2.getGroup_id() == i2 && liveGroupPkUserModel2.getUid() != LiveRoomInfo.a().g()) {
                i3++;
            } else if (liveGroupPkUserModel2.getGroup_id() != i2 && liveGroupPkUserModel2.getUid() > 0) {
                i++;
            }
        }
        if (i > 3) {
            ToastUtils.b(R.string.group_pk_count_max);
        } else if (i3 <= 0) {
            ToastUtils.b(R.string.group_pk_count_min);
        } else {
            ArrayList<LiveGroupPkUserModel> arrayList = this.e;
            if (arrayList != null) {
                for (LiveGroupPkUserModel liveGroupPkUserModel3 : arrayList) {
                    if (liveGroupPkUserModel3.getUid() == LiveRoomInfo.a().g()) {
                        liveGroupPkUserModel3.setGroup_id(liveGroupPkUserModel3.getGroup_id() == 1 ? 2 : 1);
                    }
                }
            }
            ArrayList<LiveGroupPkUserModel> arrayList2 = this.e;
            LiveConnectionView liveConnectionView = this.f;
            Intrinsics.a(liveConnectionView);
            final ActivityFragmentActive fragmentActive = liveConnectionView.f14428a.getFragmentActive();
            BluedUIHttpResponse<BluedEntity<?, ?>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$switchGroup$4
                @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                public void onFailure(Throwable error, int i4, String content) {
                    Intrinsics.e(error, "error");
                    Intrinsics.e(content, "content");
                    super.onFailure(error, i4, content);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIFinish() {
                    super.onUIFinish();
                    LiveConnectPKView.this.a(false);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIStart() {
                    super.onUIStart();
                    LiveConnectPKView.this.a(true);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                }
            };
            LiveConnectionView liveConnectionView2 = this.f;
            Intrinsics.a(liveConnectionView2);
            LiveRoomHttpUtils.a(4, arrayList2, bluedUIHttpResponse, liveConnectionView2.f14428a.getFragmentActive());
        }
    }

    private final void setCurrentTab(int i) {
        if ((i == 1 || i == 2) && i != this.b) {
            this.b = i;
            if (i == 1) {
                k();
            } else if (i != 2) {
            } else {
                l();
            }
        }
    }

    private final void setPKIng(boolean z) {
        if (this.f14414c == z) {
            return;
        }
        this.f14414c = z;
        p();
    }

    private final void t() {
        if (this.f14414c) {
            getVb().f12163a.setText("退出PK");
            getVb().f12163a.getShapeModel().b = ContextCompat.getColor(getContext(), R.color.syc_dark_222);
            getVb().f12163a.getShapeModel().t = BluedSkinUtils.a(getContext(), R.color.syc_dark_f5f5f5);
            getVb().f12163a.getShapeModel().v = BluedSkinUtils.a(getContext(), R.color.syc_dark_f5f5f5);
            getVb().f12163a.setShapeModel(getVb().f12163a.getShapeModel());
        } else if (b(false)) {
            getVb().f12163a.setText("开始PK");
            getVb().f12163a.getShapeModel().b = ContextCompat.getColor(getContext(), R.color.white);
            getVb().f12163a.getShapeModel().t = BluedSkinUtils.a(getContext(), R.color.syc_dark_922cee);
            getVb().f12163a.getShapeModel().v = BluedSkinUtils.a(getContext(), R.color.syc_dark_ff3aaa);
            getVb().f12163a.setShapeModel(getVb().f12163a.getShapeModel());
        } else {
            getVb().f12163a.setText("开始PK");
            getVb().f12163a.getShapeModel().b = ContextCompat.getColor(getContext(), R.color.syc_dark_999999);
            getVb().f12163a.getShapeModel().t = BluedSkinUtils.a(getContext(), R.color.syc_dark_f5f5f5);
            getVb().f12163a.getShapeModel().v = BluedSkinUtils.a(getContext(), R.color.syc_dark_f5f5f5);
            getVb().f12163a.setShapeModel(getVb().f12163a.getShapeModel());
        }
    }

    public final void a() {
        a(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$dGK9Jt82InWFEa69UdC7-ZBL930
            @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
            public final void onAnimationEnd() {
                LiveConnectPKView.b(LiveConnectPKView.this);
            }
        });
    }

    public final void a(int i, int i2, String toast, List<? extends LiveInviteUserModel> inviteModels) {
        View view;
        synchronized (this) {
            Intrinsics.e(toast, "toast");
            Intrinsics.e(inviteModels, "inviteModels");
            this.d = (ArrayList) inviteModels;
            if (this.f14414c && (i2 == 2 || i2 == 3)) {
                return;
            }
            if (i2 == 1) {
                if (i == LiveRoomInfo.a().g()) {
                    d();
                }
            }
            if (i != LiveRoomInfo.a().g() && i2 == 2) {
                if (!(toast.length() == 0)) {
                    ToastUtils.b(toast);
                }
            }
            setCurrentTab(1);
            getVb().f.removeAllViews();
            m();
            int size = this.h.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                view = null;
                if (i4 >= size) {
                    break;
                }
                if (this.d != null) {
                    ArrayList<LiveInviteUserModel> arrayList = this.d;
                    Integer valueOf = arrayList == null ? null : Integer.valueOf(arrayList.size());
                    Intrinsics.a(valueOf);
                    if (i4 < valueOf.intValue()) {
                        ArrayList<LiveInviteUserModel> arrayList2 = this.d;
                        if ((arrayList2 == null ? null : arrayList2.get(i4)) != null) {
                            ArrayList<LiveInviteUserModel> arrayList3 = this.d;
                            LiveInviteUserModel liveInviteUserModel = arrayList3 == null ? null : arrayList3.get(i4);
                            Intrinsics.c(liveInviteUserModel, "mInviteModel?.get(i)");
                            String str = liveInviteUserModel.uid;
                            Intrinsics.a((Object) str);
                            LiveConnectPKUserItemView a2 = a(Long.parseLong(str));
                            if (a2 != null) {
                                a2.a(liveInviteUserModel);
                                a2.setGroup(false);
                                getVb().f.addView(a2);
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                LiveConnectPKUserItemView a3 = a(-2L);
                if (a3 != null) {
                    a3.a(null);
                    a3.setGroup(false);
                    getVb().f.addView(a3);
                }
                i3 = i4 + 1;
            }
            LinearLayout linearLayout = getVb().f;
            View view2 = this.j;
            if (view2 == null) {
                Intrinsics.c("viewCarryView");
            } else {
                view = view2;
            }
            linearLayout.addView(view);
            t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061 A[Catch: all -> 0x0421, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0002, B:9:0x0016, B:199:0x0416, B:199:0x0416, B:200:0x0419, B:201:0x0420, B:12:0x0027, B:197:0x040b, B:198:0x0415, B:14:0x0031, B:17:0x0041, B:19:0x004f, B:24:0x0061, B:26:0x0066, B:37:0x0082, B:47:0x00ab, B:52:0x00bb, B:58:0x00d0, B:60:0x00d5, B:62:0x00ee, B:65:0x00fa, B:68:0x010f, B:70:0x0118, B:74:0x0130, B:79:0x0141, B:83:0x0154, B:86:0x0160, B:88:0x016b, B:90:0x0173, B:92:0x0187, B:94:0x018e, B:97:0x019b, B:100:0x01ad, B:102:0x01d0, B:105:0x01df, B:107:0x01ee, B:109:0x01f8, B:115:0x0212, B:116:0x0235, B:117:0x023f, B:119:0x0241, B:122:0x025a, B:124:0x0262, B:127:0x0274, B:129:0x027f, B:131:0x0287, B:133:0x029b, B:135:0x02a2, B:138:0x02af, B:141:0x02c1, B:143:0x02e4, B:146:0x02f3, B:148:0x0302, B:150:0x030c, B:156:0x0326, B:157:0x0349, B:158:0x0353, B:160:0x0355, B:163:0x0362, B:165:0x036a, B:167:0x0371, B:170:0x037f, B:172:0x0387, B:174:0x0391, B:177:0x039f, B:179:0x03a7, B:181:0x03b0, B:184:0x03c4, B:186:0x03cc, B:187:0x03d5, B:188:0x03df, B:190:0x03e1, B:192:0x03f2, B:194:0x03fe, B:40:0x008e, B:42:0x009a, B:45:0x00a6), top: B:217:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r6, int r7, java.lang.String r8, java.util.List<? extends com.blued.android.module.live_china.model.LiveInviteUserModel> r9, java.util.List<com.blued.android.module.live_china.model.LiveGroupPkUserModel> r10) {
        /*
            Method dump skipped, instructions count: 1108
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.LiveConnectPKView.a(int, int, java.lang.String, java.util.List, java.util.List):void");
    }

    public final void a(ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (c()) {
            ShapeFrameLayout shapeFrameLayout = getVb().b;
            Intrinsics.c(shapeFrameLayout, "vb.contentLayout");
            BluedViewExKt.a(shapeFrameLayout);
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f14413a, R.anim.push_bottom_out);
            getVb().b.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$dismiss$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.e(animation, "animation");
                    if (LiveConnectPKView.this.c()) {
                        return;
                    }
                    BluedViewExKt.a(LiveConnectPKView.this);
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
        } else {
            BluedViewExKt.a(this);
        }
        if (iLiveConnectionAnimListener != null) {
            iLiveConnectionAnimListener.onAnimationEnd();
        }
        getVb().h.animate().cancel();
        ProgressBar progressBar = getVb().h;
        Intrinsics.c(progressBar, "vb.loading");
        BluedViewExKt.a(progressBar);
        ILiveConnectionStateListener iLiveConnectionStateListener = this.g;
        if (iLiveConnectionStateListener == null) {
            return;
        }
        iLiveConnectionStateListener.b();
    }

    public final void a(LiveConnectionView connectionView) {
        Intrinsics.e(connectionView, "connectionView");
        this.f = connectionView;
        this.g = connectionView;
        if (!LiveRoomPreferences.Q() || this.f == null) {
            return;
        }
        ShapeTextView shapeTextView = getVb().s;
        Intrinsics.c(shapeTextView, "vb.viewDot");
        BluedViewExKt.b(shapeTextView);
        Observable observable = LiveEventBus.get(LiveEventBusUtil.D, Object.class);
        LiveConnectionView liveConnectionView = this.f;
        Intrinsics.a(liveConnectionView);
        observable.observe(liveConnectionView.f14428a, new Observer() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveConnectPKView$rGcrzFqRp3w99UEsOIhP9VoFul4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveConnectPKView.a(LiveConnectPKView.this, obj);
            }
        });
    }

    public final void a(List<? extends LiveInviteUserModel> inviteModels) {
        Intrinsics.e(inviteModels, "inviteModels");
        a(-1, -1, "", inviteModels, null);
        setPKIng(true);
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_EXIT_BTN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    public final void a(List<? extends LiveInviteUserModel> models, LiveInviteUserModel model) {
        Intrinsics.e(models, "models");
        Intrinsics.e(model, "model");
        ArrayList<LiveInviteUserModel> arrayList = this.d;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.d = (ArrayList) models;
        for (LiveGroupPkUserModel liveGroupPkUserModel : this.e) {
            if (Intrinsics.a((Object) String.valueOf(liveGroupPkUserModel.getUid()), (Object) model.uid)) {
                liveGroupPkUserModel.setUid(-1L);
            }
        }
        for (LiveConnectPKUserItemView liveConnectPKUserItemView : this.h) {
            if (Intrinsics.a((Object) String.valueOf(liveConnectPKUserItemView.getUid()), (Object) model.uid)) {
                liveConnectPKUserItemView.a(null);
            }
        }
        if (this.f14414c) {
            a(-1, 5, "", this.d, this.e);
        }
        t();
    }

    public final void b() {
        LiveConnectionView liveConnectionView = this.f;
        Intrinsics.a(liveConnectionView);
        final ActivityFragmentActive fragmentActive = liveConnectionView.f14428a.getFragmentActive();
        LiveRoomHttpUtils.a("1", new BluedUIHttpResponse<BluedEntity<?, ?>>(fragmentActive) { // from class: com.blued.android.module.live_china.view.LiveConnectPKView$exitLivePK$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable error, int i, String content) {
                Intrinsics.e(error, "error");
                Intrinsics.e(content, "content");
                super.onFailure(error, i, content);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveConnectPKView.this.a(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveConnectPKView.this.a(true);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, ?> bluedEntity) {
                LiveConnectionView liveConnectionView2;
                LiveConnectionView liveConnectionView3;
                LiveConnectPKView.this.e();
                LiveConnectPKView.this.g();
                liveConnectionView2 = LiveConnectPKView.this.f;
                if (liveConnectionView2 != null) {
                    liveConnectionView3 = LiveConnectPKView.this.f;
                    Intrinsics.a(liveConnectionView3);
                    liveConnectionView3.t();
                }
            }
        });
    }

    public final boolean c() {
        ShapeFrameLayout shapeFrameLayout = getVb().b;
        Intrinsics.c(shapeFrameLayout, "vb.contentLayout");
        return shapeFrameLayout.getVisibility() == 0;
    }

    public final void d() {
        LiveConnectPKView liveConnectPKView = this;
        if ((liveConnectPKView.getVisibility() == 0) && c()) {
            return;
        }
        BluedViewExKt.b(liveConnectPKView);
        ShapeFrameLayout shapeFrameLayout = getVb().b;
        Intrinsics.c(shapeFrameLayout, "vb.contentLayout");
        BluedViewExKt.b(shapeFrameLayout);
        getVb().b.clearAnimation();
        getVb().b.startAnimation(AnimationUtils.loadAnimation(this.f14413a, R.anim.push_bottom_in));
    }

    public final void e() {
        a((ILiveConnectionAnimListener) null);
    }

    public final void f() {
        e();
    }

    public final void g() {
        setPKIng(false);
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        b(false);
        e();
    }

    public final Context getMContext() {
        return this.f14413a;
    }

    public final ArrayList<LiveInviteUserModel> getMInviteModel() {
        return this.d;
    }

    public final void h() {
        new ExitDialog(this.f14413a, this).show();
        EventTrackLive.a(LiveProtos.Event.LIVE_PK_MORE_EXIT_BTN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
    }

    public final void i() {
        if (this.e == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (LiveGroupPkUserModel liveGroupPkUserModel : this.e) {
            if (liveGroupPkUserModel.getUid() == LiveRoomManager.a().f()) {
                i = liveGroupPkUserModel.getGroup_id();
                liveGroupPkUserModel.setGroup_id(1);
                arrayList.add(liveGroupPkUserModel);
            }
        }
        for (LiveGroupPkUserModel liveGroupPkUserModel2 : this.e) {
            if (i == liveGroupPkUserModel2.getGroup_id() && liveGroupPkUserModel2.getUid() != LiveRoomManager.a().f()) {
                liveGroupPkUserModel2.setGroup_id(1);
                arrayList.add(liveGroupPkUserModel2);
            } else if (i != liveGroupPkUserModel2.getGroup_id() && liveGroupPkUserModel2.getUid() != LiveRoomManager.a().f()) {
                liveGroupPkUserModel2.setGroup_id(2);
                arrayList2.add(liveGroupPkUserModel2);
            }
        }
        this.e.clear();
        this.e.addAll(arrayList);
        this.e.addAll(arrayList2);
    }

    public final void setMInviteModel(ArrayList<LiveInviteUserModel> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.d = arrayList;
    }
}
