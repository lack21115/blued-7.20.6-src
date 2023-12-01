package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveGiftModel;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftAdapter.class */
public class LiveGiftAdapter extends LiveGiftBaseAdapter {
    public LiveGiftAdapter(Context context, BaseFragment baseFragment, int i) {
        super(context, baseFragment, i);
    }

    private void c(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv);
        if (liveGiftModel.imageType == 1) {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).f(imageView.hashCode()).g(-1).a(imageView);
        } else if (liveGiftModel.imageType == 2) {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).e(imageView.hashCode()).g(-1).a(imageView);
        } else {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).a(imageView);
        }
        commonAdapterHolder.b(R.id.item_live_gift_state, liveGiftModel.is_use == 1 ? 0 : 8);
        commonAdapterHolder.a(R.id.item_live_gift_expire, liveGiftModel.expire == -1 ? "永久" : LiveTimeAndDateUtils.b(this.mContext, CommonStringUtils.c(liveGiftModel.expire_time) * 1000));
    }

    private void d(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        commonAdapterHolder.b(R.id.item_live_gift_state, liveGiftModel.is_use == 1 ? 0 : 8);
        if (liveGiftModel.expire == -1) {
            commonAdapterHolder.a(R.id.item_live_gift_expire, Color.parseColor("#8A8A8A"), "永久");
        } else {
            commonAdapterHolder.a(R.id.item_live_gift_expire, Color.parseColor("#FF6533"), LiveTimeAndDateUtils.b(this.mContext, CommonStringUtils.c(liveGiftModel.expire_time) * 1000));
        }
    }

    private void e(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        commonAdapterHolder.a(R.id.item_live_gift_name, "充值满赠券");
        ImageLoader.a(this.requestHost, liveGiftModel.images_static).b(R.drawable.gift_default_icon).a(6.0f).a((ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv));
        if (liveGiftModel.expire == -1) {
            commonAdapterHolder.a(R.id.item_live_gift_expire, Color.parseColor("#8A8A8A"), "永久");
            return;
        }
        long c2 = (CommonStringUtils.c(liveGiftModel.expire_time) * 1000) - System.currentTimeMillis();
        if (c2 <= 0) {
            commonAdapterHolder.a(R.id.item_live_gift_expire, -1, "已过期");
        } else if (c2 < 3600000) {
            commonAdapterHolder.a(R.id.item_live_gift_expire, Color.parseColor("#FF6533"), "1小时内到期");
        } else if (c2 >= 86400000) {
            long j = c2 / 86400000;
            int i = R.id.item_live_gift_expire;
            commonAdapterHolder.a(i, -1, j + "天后到期");
        } else {
            long j2 = c2 / 3600000;
            int i2 = R.id.item_live_gift_expire;
            int parseColor = Color.parseColor("#FF6533");
            commonAdapterHolder.a(i2, parseColor, j2 + "小时后到期");
        }
    }

    private void f(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        int i = R.id.item_live_gift_price;
        commonAdapterHolder.a(i, CommonStringUtils.d(String.valueOf(liveGiftModel.beans)) + this.mContext.getString(R.string.live_gift_bean) + BridgeUtil.SPLIT_MARK + liveGiftModel.expire + this.mContext.getString(R.string.live_days));
        if (liveGiftModel.is_my != 1) {
            commonAdapterHolder.b(R.id.item_live_gift_effect_state, 8).b(R.id.expiry_date_view, 8).b(R.id.item_live_gift_view_divider_1, 0).b(R.id.item_live_gift_view_divider_2, 0);
            return;
        }
        commonAdapterHolder.b(R.id.expiry_date_view, 0).a(R.id.expiry_date_view, LiveTimeAndDateUtils.a(this.mContext, LiveTimeAndDateUtils.a(liveGiftModel.expire_time))).b(R.id.item_live_gift_view_divider_1, 8).b(R.id.item_live_gift_view_divider_2, 8);
        commonAdapterHolder.b(R.id.item_live_gift_effect_state, 8);
        if (liveGiftModel.is_use == 1) {
            commonAdapterHolder.c(R.id.item_live_gift_effect_state, R.drawable.live_gift_effect_used_bg).a(R.id.item_live_gift_effect_state, this.mContext.getString(R.string.equipped)).b(R.id.item_live_gift_effect_state, 0);
        } else {
            commonAdapterHolder.b(R.id.item_live_gift_effect_state, 8);
        }
    }

    @Override // com.blued.android.module.live_china.mine.LiveGiftBaseAdapter
    protected void a(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        if (liveGiftModel.ops == 5) {
            f(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 1101) {
            c(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 1102) {
            d(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 1103) {
            e(commonAdapterHolder, liveGiftModel);
        } else {
            b(commonAdapterHolder, liveGiftModel);
        }
    }

    @Override // com.blued.android.module.common.adapter.BaseGiftAdapter
    public boolean a(View view, BaseGiftModel baseGiftModel, int i) {
        return true;
    }

    @Override // com.blued.android.module.live_china.mine.LiveGiftBaseAdapter, com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return i == 5 ? R.layout.item_live_gift_effect : i == 1101 ? R.layout.item_live_gift_avatar : i == 1102 ? R.layout.item_live_gift_bubble : i == 1103 ? R.layout.item_live_gift_coupon : super.getLayoutId(i);
    }
}
