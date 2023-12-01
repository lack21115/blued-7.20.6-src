package com.blued.android.module.live_china.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveGiftBackpackModel;
import com.blued.android.module.live_china.model.ReChargeGift;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LiveRechargeGiftBagView;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/presenter/LiveGiftPresenter.class */
public final class LiveGiftPresenter extends MvpPresenter {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final ActivityFragmentActive fragmentActive, final int i, final ImageView imageView, final BaseFragment fragment, View view) {
        Intrinsics.e(fragmentActive, "$fragmentActive");
        Intrinsics.e(fragment, "$fragment");
        LiveRoomHttpUtils.q(new BluedUIHttpResponse<BluedEntityA<ReChargeGift>>(i, imageView, fragment) { // from class: com.blued.android.module.live_china.presenter.LiveGiftPresenter$showRechargeGiftBagIcon$2$1
            final /* synthetic */ int b;
            final /* synthetic */ ImageView c;
            final /* synthetic */ BaseFragment d;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = i;
                this.c = imageView;
                this.d = fragment;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ReChargeGift> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveRoomManager.a().a(bluedEntityA.getSingleData(), false);
                LiveRoomPreferences.h(this.b);
                ImageLoader.a(ActivityFragmentActive.this, R.drawable.live_recharge_static).a(this.c);
                LiveRouteUtil.a(this.d, false);
                EventTrackLive.d(LiveProtos.Event.LIVE_GIFT_POP_RESOURCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), 2);
            }
        }, fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ActivityFragmentActive fragmentActive, ImageView imageView, BaseFragment fragment, View view) {
        Intrinsics.e(fragmentActive, "$fragmentActive");
        Intrinsics.e(fragment, "$fragment");
        LiveRechargeGiftBagView.a.d();
        ImageLoader.a(fragmentActive, R.drawable.live_charge_icon_static).a(imageView);
        LiveRouteUtil.a(fragment, fragment.getFragmentActive(), 1, false, 10020);
        EventTrackLive.d(LiveProtos.Event.LIVE_GIFT_POP_RESOURCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), 1);
    }

    public final void a(int i, final ImageView imageView, final ActivityFragmentActive fragmentActive, final BaseFragment fragment) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        Intrinsics.e(fragment, "fragment");
        if ((imageView == null ? null : imageView.getTag()) != null) {
            if (imageView == null ? false : Intrinsics.a(imageView.getTag(), Integer.valueOf(i))) {
                return;
            }
        }
        if (imageView != null) {
            imageView.setTag(Integer.valueOf(i));
        }
        if (i == 1) {
            if (imageView != null) {
                BluedViewExKt.b(imageView);
            }
            ViewGroup.LayoutParams layoutParams = imageView == null ? null : imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = AppMethods.a(30);
            }
            if (layoutParams != null) {
                layoutParams.height = AppMethods.a(30);
            }
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            if (LiveRechargeGiftBagView.a.c()) {
                ImageLoader.a(fragmentActive, R.drawable.live_charge_icon_static).a(imageView);
            } else {
                ImageWrapper c = ImageLoader.c(fragmentActive, "live_first_gift_pay_anim.png");
                int i2 = 0;
                if (imageView != null) {
                    i2 = imageView.hashCode();
                }
                c.e(i2).g(-1).a(imageView);
            }
            if (imageView == null) {
                return;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.presenter.-$$Lambda$LiveGiftPresenter$KU2pnzsyAIaK60t3Kish2fx-R-g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftPresenter.a(ActivityFragmentActive.this, imageView, fragment, view);
                }
            });
        } else if (i != 2) {
            if (imageView == null) {
                return;
            }
            BluedViewExKt.a(imageView);
        } else {
            if (imageView != null) {
                BluedViewExKt.b(imageView);
            }
            ViewGroup.LayoutParams layoutParams2 = imageView == null ? null : imageView.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = AppMethods.a(77);
            }
            if (layoutParams2 != null) {
                layoutParams2.height = AppMethods.a(32);
            }
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams2);
            }
            Date date = new Date(System.currentTimeMillis());
            final int year = (date.getYear() * 10000) + ((date.getMonth() + 1) * 100) + date.getDate();
            if (year > LiveRoomPreferences.y()) {
                ImageWrapper c2 = ImageLoader.c(fragmentActive, "live_recharge_anim.png");
                int i3 = 0;
                if (imageView != null) {
                    i3 = imageView.hashCode();
                }
                c2.e(i3).g(-1).a(imageView);
            } else {
                ImageLoader.a(fragmentActive, R.drawable.live_recharge_static).a(imageView);
            }
            if (imageView == null) {
                return;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.presenter.-$$Lambda$LiveGiftPresenter$Sb5iou2BMBMBOoJHpCbU9WHKys0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftPresenter.a(ActivityFragmentActive.this, year, imageView, fragment, view);
                }
            });
        }
    }

    public final void a(final IRequestHost requestActive) {
        Intrinsics.e(requestActive, "requestActive");
        LiveRoomHttpUtils.g(new BluedUIHttpResponse<BluedEntity<LiveGiftBackpackModel, BluedEntityBaseExtra>>() { // from class: com.blued.android.module.live_china.presenter.LiveGiftPresenter$getLiveGiftBackpackData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(IRequestHost.this);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveGiftBackpackModel, BluedEntityBaseExtra> bluedEntity) {
                LiveGiftBackpackModel liveGiftBackpackModel;
                if (bluedEntity == null || (liveGiftBackpackModel = bluedEntity.data.get(0)) == null) {
                    return;
                }
                LiveEventBus.get("key_event_live_gift_backpack_data", LiveGiftBackpackModel.class).post(liveGiftBackpackModel);
            }
        });
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}
