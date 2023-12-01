package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LiveRechargeGiftBagViewBinding;
import com.blued.android.module.live_china.fragment.LiveFirstChargeDialogFragment;
import com.blued.android.module.live_china.fragment.LiveRechargeDlgFragment;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.EnumOperation;
import com.blued.android.module.live_china.model.LiveRoomOperationModel;
import com.blued.android.module.live_china.model.ReChargeGift;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.PushGuideObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRechargeGiftBagView.class */
public final class LiveRechargeGiftBagView extends RelativeLayout {
    public static final Companion a = new Companion(null);
    private final Context b;
    private final Lazy c;
    private Runnable d;
    private BaseFragment e;
    private LiveRoomOperationModel f;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRechargeGiftBagView$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void b(final BaseFragment baseFragment, final boolean z) {
            final ActivityFragmentActive fragmentActive;
            if (baseFragment == null || (fragmentActive = baseFragment.getFragmentActive()) == null) {
                return;
            }
            LiveRoomHttpUtils.q(new BluedUIHttpResponse<BluedEntityA<ReChargeGift>>(baseFragment, z) { // from class: com.blued.android.module.live_china.view.LiveRechargeGiftBagView$Companion$getGiftBagDetail$1$1
                final /* synthetic */ BaseFragment b;
                final /* synthetic */ boolean c;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(ActivityFragmentActive.this);
                    this.b = baseFragment;
                    this.c = z;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<ReChargeGift> bluedEntityA) {
                    ReChargeGift singleData;
                    if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                        return;
                    }
                    BaseFragment baseFragment2 = this.b;
                    boolean z2 = this.c;
                    LiveRoomManager.a().a(singleData, true);
                    LiveRechargeGiftBagView.a.a(baseFragment2, z2);
                }
            }, fragmentActive);
        }

        @JvmStatic
        public final void a(BaseFragment baseFragment, int i, boolean z, int i2) {
            LiveRoomManager.a().p().rechargeGiftBagIconShowType = 1;
            if (PushGuideObserver.a.a().a() || baseFragment == null || baseFragment.getFragmentActive() == null || !baseFragment.getFragmentActive().isActive() || !baseFragment.isVisible() || baseFragment.getFragmentManager() == null) {
                return;
            }
            LiveFirstChargeDialogFragment.a.a(baseFragment, i, z);
            EventTrackLive.a(LiveProtos.Event.LIVE_FIRST_PAY_SHOW, i);
            LiveRechargeGiftBagView.a.b();
        }

        @JvmStatic
        public final void a(BaseFragment baseFragment, boolean z) {
            FragmentManager fragmentManager;
            LiveRoomManager.a().p().rechargeGiftBagIconShowType = 2;
            if (PushGuideObserver.a.a().a() || !LiveFloatManager.a().y() || LiveFloatManager.a().x() || baseFragment == null || baseFragment.getContext() == null || baseFragment.getFragmentActive() == null || !baseFragment.getFragmentActive().isActive() || (fragmentManager = baseFragment.getFragmentManager()) == null) {
                return;
            }
            if (LiveRoomManager.a().E() == null) {
                LiveRechargeGiftBagView.a.b(baseFragment, z);
            } else {
                new LiveRechargeDlgFragment(z).a(fragmentManager);
            }
            LiveRechargeGiftBagView.a.b();
        }

        @JvmStatic
        public final boolean a() {
            Date date = new Date(System.currentTimeMillis());
            return ((date.getYear() * 10000) + ((date.getMonth() + 1) * 100)) + date.getDate() <= LiveRoomPreferences.x();
        }

        @JvmStatic
        public final void b() {
            Date date = new Date(System.currentTimeMillis());
            LiveRoomPreferences.g((date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate());
        }

        @JvmStatic
        public final boolean c() {
            Date date = new Date(System.currentTimeMillis());
            return ((date.getYear() * 10000) + ((date.getMonth() + 1) * 100)) + date.getDate() <= LiveRoomPreferences.y();
        }

        @JvmStatic
        public final void d() {
            Date date = new Date(System.currentTimeMillis());
            LiveRoomPreferences.h((date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRechargeGiftBagView(Context mContext) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
        this.c = LazyKt.a(new Function0<LiveRechargeGiftBagViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveRechargeGiftBagView$vb$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveRechargeGiftBagViewBinding invoke() {
                LiveRechargeGiftBagViewBinding a2 = LiveRechargeGiftBagViewBinding.a(LayoutInflater.from(LiveRechargeGiftBagView.this.getMContext()).inflate(R.layout.live_recharge_gift_bag_view, LiveRechargeGiftBagView.this));
                Intrinsics.c(a2, "bind(LayoutInflater.from…rge_gift_bag_view, this))");
                return a2;
            }
        });
    }

    @JvmStatic
    public static final void a(BaseFragment baseFragment, int i, boolean z, int i2) {
        a.a(baseFragment, i, z, i2);
    }

    @JvmStatic
    public static final void a(BaseFragment baseFragment, boolean z) {
        a.a(baseFragment, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRoomOperationModel liveRoomOperationModel, BaseFragment baseFragment, LiveRechargeGiftBagView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        int tools_type = liveRoomOperationModel.getTools_type();
        if (tools_type == EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue()) {
            a.a(baseFragment, 0, false, 10020);
        } else if (tools_type == EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue()) {
            a.a(baseFragment, false);
        }
        a.d();
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRoomOperationModel it, LiveRechargeGiftBagView this$0) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(this$0, "this$0");
        if (LiveRouteUtil.b() || a.a()) {
            return;
        }
        int tools_type = it.getTools_type();
        if (tools_type == EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue()) {
            a.a(this$0.e, 1, false, 10020);
        } else if (tools_type == EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue()) {
            a.a(this$0.e, true);
        }
    }

    @JvmStatic
    public static final boolean b() {
        return a.c();
    }

    @JvmStatic
    public static final void c() {
        a.d();
    }

    private final void d() {
        LiveRoomOperationModel liveRoomOperationModel = this.f;
        if (liveRoomOperationModel == null) {
            return;
        }
        String icon = a.c() ? liveRoomOperationModel.getIcon() : liveRoomOperationModel.getDynamic_icon();
        if (icon != null) {
            BaseFragment baseFragment = this.e;
            Intrinsics.a(baseFragment);
            ImageLoader.a(baseFragment.getFragmentActive(), icon).g().g(-1).a(getVb().a);
        }
        int i = liveRoomOperationModel.getTools_type() == EnumOperation.VIEW_TYPE_FIRST_RECHARGE_GIFT_BAG.getValue() ? 1 : liveRoomOperationModel.getTools_type() == EnumOperation.VIEW_TYPE_RECHARGE_GIFT_BAG.getValue() ? 2 : 0;
        LiveRoomManager.a().p().rechargeGiftBagIconShowType = i;
        LiveEventBusUtil.a(i);
    }

    private final void e() {
        final LiveRoomOperationModel liveRoomOperationModel;
        if (LiveRouteUtil.b() || a.a() || (liveRoomOperationModel = this.f) == null) {
            return;
        }
        a();
        setChargeRunnable(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveRechargeGiftBagView$SmgTI9Mq6JYuxxqClx9DX45331o
            @Override // java.lang.Runnable
            public final void run() {
                LiveRechargeGiftBagView.a(LiveRoomOperationModel.this, this);
            }
        });
        Handler n = AppInfo.n();
        Runnable chargeRunnable = getChargeRunnable();
        Intrinsics.a(chargeRunnable);
        n.post(chargeRunnable);
    }

    private final LiveRechargeGiftBagViewBinding getVb() {
        return (LiveRechargeGiftBagViewBinding) this.c.getValue();
    }

    public final LiveRechargeGiftBagView a(final BaseFragment baseFragment, final LiveRoomOperationModel liveRoomOperationModel) {
        if (liveRoomOperationModel == null || liveRoomOperationModel.getStatus() == 0) {
            return null;
        }
        this.f = liveRoomOperationModel;
        if (baseFragment == null) {
            return null;
        }
        this.e = baseFragment;
        if (baseFragment.getFragmentActive() == null) {
            return null;
        }
        d();
        e();
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveRechargeGiftBagView$roSpTbjr2PmiHfgtMaXfO6otETM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveRechargeGiftBagView.a(LiveRoomOperationModel.this, baseFragment, this, view);
            }
        });
        return this;
    }

    public final void a() {
        Runnable runnable = this.d;
        if (runnable == null) {
            return;
        }
        AppInfo.n().removeCallbacks(runnable);
        setChargeRunnable(null);
    }

    public final Runnable getChargeRunnable() {
        return this.d;
    }

    public final Context getMContext() {
        return this.b;
    }

    public final LiveRoomOperationModel getModel() {
        return this.f;
    }

    public final void setChargeRunnable(Runnable runnable) {
        this.d = runnable;
    }

    public final void setModel(LiveRoomOperationModel liveRoomOperationModel) {
        this.f = liveRoomOperationModel;
    }
}
