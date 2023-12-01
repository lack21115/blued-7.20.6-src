package com.blued.android.module.live_china.mine;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.common.adapter.BaseGiftAdapter;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.BaseGiftModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftOperateIconModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftBaseAdapter.class */
public class LiveGiftBaseAdapter extends BaseGiftAdapter<LiveGiftModel> {
    protected Fragment a;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/mine/LiveGiftBaseAdapter$LiveGiftOperateAdapter.class */
    public static class LiveGiftOperateAdapter extends CommonRecycleAdapter<LiveGiftOperateIconModel> {
        public boolean a;

        public LiveGiftOperateAdapter(Context context, IRequestHost iRequestHost) {
            super(context, iRequestHost);
            this.a = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(LiveGiftOperateIconModel liveGiftOperateIconModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            if (liveGiftOperateIconModel.type == 0) {
                commonAdapterHolder.a(R.id.item_live_gift_tag_tv, liveGiftOperateIconModel.content);
                return;
            }
            ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_live_gift_tag_iv);
            ImageView imageView2 = (ImageView) commonAdapterHolder.a(R.id.item_live_gift_tag_apng_iv);
            if (imageView == null) {
                return;
            }
            if (liveGiftOperateIconModel.type == 3) {
                ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
                layoutParams.width = liveGiftOperateIconModel.width;
                imageView2.setLayoutParams(layoutParams);
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
            } else {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                if (liveGiftOperateIconModel.type == 1001) {
                    layoutParams2.width = liveGiftOperateIconModel.width > 0 ? liveGiftOperateIconModel.width : DisplayUtil.a(this.mContext, 25.0f);
                } else {
                    layoutParams2.width = liveGiftOperateIconModel.width;
                }
                imageView.setLayoutParams(layoutParams2);
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
            }
            if (liveGiftOperateIconModel.type == 1001) {
                commonAdapterHolder.d(R.id.item_live_gift_tag_iv, liveGiftOperateIconModel.imgResId);
            } else if (liveGiftOperateIconModel.type == 1) {
                commonAdapterHolder.c(R.id.item_live_gift_tag_iv, liveGiftOperateIconModel.content);
            } else if (liveGiftOperateIconModel.type == 3) {
                ImageLoader.a(this.requestHost, liveGiftOperateIconModel.content).e(imageView2.hashCode()).g(-1).a(imageView2);
            } else {
                commonAdapterHolder.b(R.id.item_live_gift_tag_iv, liveGiftOperateIconModel.content);
            }
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getItemViewType(int i) {
            return ((LiveGiftOperateIconModel) this.dataList.get(i)).type;
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return i == 0 ? R.layout.item_live_gift_tag_text : R.layout.item_live_gift_tag_image;
        }
    }

    public LiveGiftBaseAdapter(Context context, Fragment fragment, int i) {
        super(context, i);
        this.a = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new CubicInterpolator(0.2f, 0.04f, 0.83f, 0.96f));
        scaleAnimation.setDuration(700L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftBaseAdapter.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveGiftBaseAdapter.this.b(view);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    private void a(LiveGiftModel liveGiftModel) {
        if (liveGiftModel.ops == 1101 || liveGiftModel.ops == 1102 || liveGiftModel.ops == 1103) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_GIFT_PAGE_GIFT_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, liveGiftModel.packageTypeName, liveGiftModel.pageIndex + 1, liveGiftModel.isMp4, liveGiftModel.positionInPage + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(LiveGiftModel liveGiftModel, View view) {
        LiveRouteUtil.a(this.a, liveGiftModel);
        EventTrackLive.c(LiveProtos.Event.LIVE_GOODS_VALITIDY_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveGiftModel.goods_id, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new CubicInterpolator(0.2f, 0.04f, 0.83f, 0.96f));
        scaleAnimation.setDuration(700L);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.mine.LiveGiftBaseAdapter.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LiveGiftBaseAdapter.this.a(view);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    protected void a(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, LiveGiftModel liveGiftModel) {
        b(commonAdapterHolder, liveGiftModel);
    }

    @Override // com.blued.android.module.common.adapter.BaseGiftAdapter
    public void a(BaseGiftModel baseGiftModel, int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
        LiveGiftModel liveGiftModel = (LiveGiftModel) baseGiftModel;
        if (liveGiftModel == null) {
            return;
        }
        commonAdapterHolder.a(R.id.item_live_gift_name, liveGiftModel.name);
        ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_live_gift_view_iv);
        if (liveGiftModel.ops != 1101 && liveGiftModel.ops != 1103) {
            ImageLoader.a(this.requestHost, liveGiftModel.images_static).b(R.drawable.gift_default_icon).a(imageView);
        }
        if (liveGiftModel.ops != 5) {
            if (liveGiftModel.isSelected) {
                a(imageView);
                commonAdapterHolder.a().setBackgroundResource(R.drawable.shape_live_gift_bg);
            } else {
                commonAdapterHolder.a().setBackground(null);
            }
        }
        if (!liveGiftModel.isExposure) {
            liveGiftModel.isExposure = true;
            a(liveGiftModel);
        }
        a(commonAdapterHolder, liveGiftModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder, final LiveGiftModel liveGiftModel) {
        if (liveGiftModel.is_task == 1) {
            commonAdapterHolder.a(R.id.item_live_gift_price, "任务专属");
            commonAdapterHolder.b(R.id.item_live_gift_price_icon, 8);
        } else {
            commonAdapterHolder.a(R.id.item_live_gift_price, CommonStringUtils.d(String.valueOf(liveGiftModel.beans)));
            commonAdapterHolder.b(R.id.item_live_gift_price_icon, 0);
        }
        RecyclerView a = commonAdapterHolder.a(R.id.item_live_gift_tag_rv);
        if (a.getLayoutManager() == null) {
            a.setLayoutManager(new LinearLayoutManager(a.getContext(), 0, false));
        }
        LiveGiftOperateAdapter liveGiftOperateAdapter = (LiveGiftOperateAdapter) a.getAdapter();
        LiveGiftOperateAdapter liveGiftOperateAdapter2 = liveGiftOperateAdapter;
        if (liveGiftOperateAdapter == null) {
            liveGiftOperateAdapter2 = new LiveGiftOperateAdapter(AppInfo.d(), this.requestHost);
            a.setAdapter(liveGiftOperateAdapter2);
        }
        liveGiftOperateAdapter2.setDataAndNotify(liveGiftModel.realOperateIcons);
        ImageView imageView = (ImageView) commonAdapterHolder.a(R.id.item_live_gift_state);
        if (liveGiftModel.availability == -1) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.upcoming_sale_icon);
        } else if (liveGiftModel.count != 0) {
            imageView.setVisibility(8);
        } else if (liveGiftModel.user_store_count > 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.sold_out_icon);
        }
        commonAdapterHolder.b(R.id.item_live_gift_inventory, liveGiftModel.user_store_count > 0 ? 0 : 8).a(R.id.item_live_gift_inventory, liveGiftModel.user_store_count > 1000000 ? "100W+" : liveGiftModel.user_store_count == 1000000 ? "100W" : String.valueOf(liveGiftModel.user_store_count));
        TextView textView = (TextView) commonAdapterHolder.a(R.id.item_live_gift_level);
        textView.setVisibility(8);
        if (liveGiftModel.isSelected) {
            if (liveGiftModel.is_fans_goods == 1) {
                if (liveGiftModel.fans_level > 0) {
                    textView.setText("LV." + liveGiftModel.fans_level);
                    textView.setVisibility(0);
                }
            } else if (liveGiftModel.level > 0) {
                textView.setVisibility(0);
                textView.setText("LV." + liveGiftModel.level);
            }
        }
        if (TextUtils.isEmpty(liveGiftModel.expire_info)) {
            commonAdapterHolder.b(R.id.item_live_gift_expire, 8).b(R.id.item_live_gift_price_layout, 0).a().setOnLongClickListener(null);
        } else {
            commonAdapterHolder.b(R.id.item_live_gift_expire, 0).b(R.id.item_live_gift_price_layout, 8).a().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.live_china.mine.-$$Lambda$LiveGiftBaseAdapter$jEd7vQVesjs63NXVdUbzYxA_fME
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean a2;
                    a2 = LiveGiftBaseAdapter.this.a(liveGiftModel, view);
                    return a2;
                }
            });
        }
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getItemViewType(int i) {
        return ((LiveGiftModel) this.dataList.get(i)).ops;
    }

    @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
    public int getLayoutId(int i) {
        return R.layout.item_live_gift;
    }
}
