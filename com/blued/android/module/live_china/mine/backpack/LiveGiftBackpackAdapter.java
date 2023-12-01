package com.blued.android.module.live_china.mine.backpack;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.mine.LiveGiftBaseAdapter;
import com.blued.android.module.live_china.mine.LiveRouteUtil;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/backpack/LiveGiftBackpackAdapter.class */
public class LiveGiftBackpackAdapter extends LiveGiftBaseAdapter {
    public LiveGiftBackpackAdapter(Context context, BaseFragment baseFragment, int i) {
        super(context, baseFragment, i);
    }

    private void a(TextView textView, long j) {
        if (j <= 0) {
            textView.setText("已过期");
        } else if (j < 3600000) {
            long j2 = j / 60000;
            if (j2 < 1) {
                textView.setText("即将过期");
                return;
            }
            textView.setText(j2 + "分钟后到期");
        } else if (j < 86400000) {
            textView.setText((j / 3600000) + "小时后到期");
        } else {
            textView.setText((j / 86400000) + "天后到期");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(LiveGiftModel liveGiftModel, View view) {
        if (liveGiftModel.ops != 20) {
            if (TextUtils.isEmpty(liveGiftModel.expire_info)) {
                return false;
            }
            LiveRouteUtil.a(this.f13823a, liveGiftModel);
            EventTrackLive.c(LiveProtos.Event.LIVE_GOODS_VALITIDY_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, 0);
            return false;
        } else if (liveGiftModel.type.equals("1") || liveGiftModel.is_use == 1) {
            return false;
        } else {
            LiveRouteUtil.b(this.f13823a, liveGiftModel);
            EventTrackLive.c(LiveProtos.Event.LIVE_GOODS_VALITIDY_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, 0);
            return false;
        }
    }

    private void c(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        a(liveGiftModel);
        ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv);
        if (liveGiftModel.imageType == 1) {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).f(imageView.hashCode()).g(-1).a(imageView);
        } else if (liveGiftModel.imageType == 2) {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).e(imageView.hashCode()).g(-1).a(imageView);
        } else {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).a(imageView);
        }
        commonAdapterHolder.b(R.id.item_live_gift_state, liveGiftModel.is_use == 1 ? 0 : 8);
        int i = R.id.item_live_gift_expire;
        int i2 = 0;
        if (liveGiftModel.is_hide_expire_time == 1) {
            i2 = 8;
        }
        commonAdapterHolder.b(i, i2);
        if (liveGiftModel.expire == -1) {
            commonAdapterHolder.a(R.id.item_live_gift_expire, this.mContext.getResources().getColor(R.color.syc_dark_8a8a8a));
            commonAdapterHolder.a(R.id.item_live_gift_expire, "永久");
            return;
        }
        commonAdapterHolder.a(R.id.item_live_gift_expire, this.mContext.getResources().getColor(R.color.syc_dark_FF5E32));
        a((TextView) commonAdapterHolder.a(R.id.item_live_gift_expire), (CommonStringUtils.c(liveGiftModel.expire_time) * 1000) - System.currentTimeMillis());
    }

    private void d(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        a(liveGiftModel);
        ImageLoader.a((IRequestHost) null, liveGiftModel.images_static).f().g(-1).a((ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv));
        commonAdapterHolder.b(R.id.item_live_gift_state, liveGiftModel.is_use == 1 ? 0 : 8);
        if (liveGiftModel.ops == 21 || liveGiftModel.ops == 23) {
            commonAdapterHolder.a(R.id.item_live_gift_state, "佩戴中");
        } else if (liveGiftModel.ops == 18) {
            commonAdapterHolder.a(R.id.item_live_gift_state, "装备中");
        } else {
            commonAdapterHolder.a(R.id.item_live_gift_state, "使用中");
        }
        int i = R.id.item_live_gift_expire;
        int i2 = 0;
        if (liveGiftModel.is_hide_expire_time == 1) {
            i2 = 8;
        }
        commonAdapterHolder.b(i, i2);
        if (liveGiftModel.expire == -1) {
            commonAdapterHolder.a(R.id.item_live_gift_expire, Color.parseColor("#8A8A8A"), "永久");
            return;
        }
        commonAdapterHolder.a(R.id.item_live_gift_expire, Color.parseColor("#FF6533"));
        a((TextView) commonAdapterHolder.a(R.id.item_live_gift_expire), (CommonStringUtils.c(liveGiftModel.expire_time) * 1000) - System.currentTimeMillis());
    }

    private void e(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        a(liveGiftModel);
        commonAdapterHolder.a(R.id.item_live_gift_name, liveGiftModel.name);
        ImageLoader.a(this.requestHost, liveGiftModel.images_static).b(R.drawable.gift_default_icon).a(6.0f).a((ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv));
        if (TextUtils.isEmpty(liveGiftModel.expire_info) || liveGiftModel.is_use == 1) {
            a((TextView) commonAdapterHolder.a(R.id.item_live_gift_expire), (CommonStringUtils.c(liveGiftModel.expire_time) * 1000) - System.currentTimeMillis());
        } else {
            commonAdapterHolder.a(R.id.item_live_gift_expire, "长按查看有效期");
        }
        int i = 8;
        if (liveGiftModel.is_use == 1) {
            commonAdapterHolder.b(R.id.item_live_gift_inventory, 8);
            return;
        }
        int i2 = R.id.item_live_gift_inventory;
        if (liveGiftModel.user_store_count > 0) {
            i = 0;
        }
        commonAdapterHolder.b(i2, i).a(R.id.item_live_gift_inventory, liveGiftModel.user_store_count > 1000000 ? "100W+" : liveGiftModel.user_store_count == 1000000 ? "100W" : String.valueOf(liveGiftModel.user_store_count));
    }

    private void f(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        a(liveGiftModel);
        int i = R.id.item_live_gift_price;
        commonAdapterHolder.a(i, CommonStringUtils.d(String.valueOf(liveGiftModel.beans)) + this.mContext.getString(R.string.live_gift_bean) + BridgeUtil.SPLIT_MARK + liveGiftModel.expire + this.mContext.getString(R.string.live_days));
        if (liveGiftModel.ops == 16) {
            commonAdapterHolder.a(R.id.ll_live_gift_price).setVisibility(8);
        } else {
            commonAdapterHolder.a(R.id.ll_live_gift_price).setVisibility(0);
        }
        if (liveGiftModel.is_my != 1) {
            commonAdapterHolder.b(R.id.item_live_gift_effect_state, 8).b(R.id.expiry_date_view, 8).b(R.id.item_live_gift_view_divider_1, 0).b(R.id.item_live_gift_view_divider_2, 0);
            return;
        }
        commonAdapterHolder.b(R.id.expiry_date_view, liveGiftModel.is_hide_expire_time == 1 ? 8 : 0).a(R.id.expiry_date_view, LiveTimeAndDateUtils.a(this.mContext, LiveTimeAndDateUtils.a(liveGiftModel.expire_time))).b(R.id.item_live_gift_view_divider_1, 8).b(R.id.item_live_gift_view_divider_2, 8);
        if (liveGiftModel.is_use == 1) {
            commonAdapterHolder.c(R.id.item_live_gift_effect_state, R.drawable.live_gift_effect_used_bg).a(R.id.item_live_gift_effect_state, this.mContext.getString(R.string.equipped)).b(R.id.item_live_gift_effect_state, 0);
        } else {
            commonAdapterHolder.b(R.id.item_live_gift_effect_state, 8);
        }
    }

    private void g(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        a(liveGiftModel);
        if (liveGiftModel.isSelected) {
            commonAdapterHolder.a().setBackgroundResource(R.drawable.shape_live_gift_bg);
        } else {
            commonAdapterHolder.a().setBackgroundResource(R.drawable.shape_live_gift_fragment_item_bg);
        }
        ImageLoader.a(this.requestHost, liveGiftModel.type_icon).a((ImageView) commonAdapterHolder.a(R.id.iv_gift_fragment_badge));
        ImageLoader.a(this.requestHost, liveGiftModel.images_static).a((ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv));
        commonAdapterHolder.a(R.id.tv_gift_fragment_name, liveGiftModel.name);
        long c2 = (CommonStringUtils.c(liveGiftModel.expire_time) * 1000) - System.currentTimeMillis();
        if (c2 <= 0) {
            commonAdapterHolder.a(R.id.tv_fragment_expire_time, "已失效");
        } else {
            int i = (c2 > 3600000L ? 1 : (c2 == 3600000L ? 0 : -1));
            if (i < 0) {
                commonAdapterHolder.a(R.id.tv_fragment_expire_time, "1小时内到期");
            } else if (c2 < 86400000 || i < 0) {
                long j = c2 / 3600000;
                int i2 = R.id.tv_fragment_expire_time;
                commonAdapterHolder.a(i2, j + "小时后到期");
            } else {
                long j2 = c2 / 86400000;
                int i3 = R.id.tv_fragment_expire_time;
                commonAdapterHolder.a(i3, j2 + "天后到期");
            }
        }
        TextView textView = (TextView) commonAdapterHolder.a(R.id.tv_fragment_count);
        textView.setText(liveGiftModel.count + BridgeUtil.SPLIT_MARK + liveGiftModel.consume);
        ProgressBar progressBar = (ProgressBar) commonAdapterHolder.a(R.id.bar_gift_fragment);
        progressBar.setMax(liveGiftModel.consume);
        progressBar.setProgress(liveGiftModel.count);
    }

    @Override // com.blued.android.module.live_china.mine.LiveGiftBaseAdapter
    public void a(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, final LiveGiftModel liveGiftModel) {
        if (liveGiftModel.ops == 16) {
            f(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 17) {
            c(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 18 || liveGiftModel.ops == 21 || liveGiftModel.ops == 23) {
            d(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 20) {
            e(commonAdapterHolder, liveGiftModel);
        } else if (liveGiftModel.ops == 22) {
            g(commonAdapterHolder, liveGiftModel);
        } else {
            b(commonAdapterHolder, liveGiftModel);
        }
        commonAdapterHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.live_china.mine.backpack.-$$Lambda$LiveGiftBackpackAdapter$Pj3arnRFLK-JVnp2UePBdT1G5kI
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean a2;
                a2 = LiveGiftBackpackAdapter.this.a(liveGiftModel, view);
                return a2;
            }
        });
    }

    public void a(LiveGiftModel liveGiftModel) {
        if (liveGiftModel == null) {
            return;
        }
        EventTrackLive.i(LiveProtos.Event.LIVE_GIFT_COUPON_PAGE_ONE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id);
    }

    @Override // com.blued.android.module.common.adapter.BaseGiftAdapter
    public boolean a(View view, BaseGiftModel baseGiftModel, int i) {
        LiveGiftModel liveGiftModel = (LiveGiftModel) baseGiftModel;
        if (liveGiftModel.ops != 20 || liveGiftModel.is_use != 1) {
            LiveEventBus.get("gift_backpack_item_clicked").post(liveGiftModel);
            return false;
        }
        LiveRouteUtil.b(this.f13823a, liveGiftModel);
        EventTrackLive.c(LiveProtos.Event.LIVE_GOODS_VALITIDY_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, 0);
        return true;
    }

    @Override // com.blued.android.module.live_china.mine.LiveGiftBaseAdapter, com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return i == 16 ? R.layout.item_live_gift_effect : i == 17 ? R.layout.item_live_gift_avatar : (i == 18 || i == 21 || i == 23) ? R.layout.item_live_gift_bubble : i == 20 ? R.layout.item_live_gift_coupon : i == 22 ? R.layout.item_live_gift_bag_fragment : super.getLayoutId(i);
    }
}
