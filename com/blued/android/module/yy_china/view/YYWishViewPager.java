package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYWishGoodsModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.ban.BGABanner;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYWishViewPager.class */
public class YYWishViewPager extends FrameLayout implements View.OnClickListener, BGABanner.Adapter {
    private BaseYYStudioFragment a;
    private ImageView b;
    private BGABanner c;

    public YYWishViewPager(Context context) {
        super(context);
        a();
    }

    public YYWishViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYWishViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_wish_viewpager, (ViewGroup) this, true);
        this.b = (ImageView) findViewById(R.id.iv_set_wish);
        BGABanner bGABanner = (BGABanner) findViewById(R.id.wish_banner);
        this.c = bGABanner;
        bGABanner.setAdapter(this);
        this.c.setAutoPlayAble(true);
        this.c.setmIsNeedShowIndicator(true);
        this.b.setOnClickListener(this);
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.a = baseYYStudioFragment;
        setItems(null);
    }

    @Override // com.blued.android.module.yy_china.view.ban.BGABanner.Adapter
    public void a(BGABanner bGABanner, View view, Object obj, int i) {
        YYWishGoodsModel yYWishGoodsModel = (YYWishGoodsModel) obj;
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_gift_icon);
        TextView textView = (TextView) view.findViewById(R.id.tv_reveive_count);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_total_count);
        ImageLoader.a(this.a.getFragmentActive(), yYWishGoodsModel.images_static).a(imageView);
        textView.setText(yYWishGoodsModel.wish_current);
        textView2.setText(yYWishGoodsModel.wish_total);
        progressBar.setMax(StringUtils.a(yYWishGoodsModel.wish_total, 1));
        progressBar.setProgress(StringUtils.a(yYWishGoodsModel.wish_current, 0));
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYWishViewPager.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_USER_GIFT_CLICK, b.room_id, b.uid);
                LiveEventBus.get("show_wish_detail").post("");
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.iv_set_wish) {
            BaseYYStudioFragment baseYYStudioFragment = this.a;
            if (baseYYStudioFragment != null) {
                baseYYStudioFragment.y();
            }
            if (YYRoomInfoManager.e().b() != null) {
                EventTrackYY.e(ChatRoomProtos.Event.CHAT_ROOM_OWNER_GIFT_GUIDE_CLICK, YYRoomInfoManager.e().b().room_id);
            }
            LiveEventBus.get("show_create_wish").post("");
        }
    }

    public void setItems(List<YYWishGoodsModel> list) {
        if (list == null || list.isEmpty()) {
            if (!YYRoomInfoManager.e().y()) {
                setVisibility(8);
                return;
            }
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            return;
        }
        if (list.size() > 1) {
            this.c.setAutoPlayAble(true);
        } else {
            this.c.setAutoPlayAble(false);
        }
        this.b.setVisibility(8);
        this.c.setVisibility(0);
        this.c.a(R.layout.item_wish_pager_layout, list, (List<String>) null);
    }
}
