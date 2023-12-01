package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveWishingDrawModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/WishingWellBottomView.class */
public class WishingWellBottomView extends FrameLayout {
    public View a;
    public String b;
    private BaseFragment c;
    private View d;
    private View e;
    private ImageView f;
    private ImageView g;
    private ImageView h;

    public WishingWellBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = "";
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.live_wishing_well_bottom_view, this);
        this.d = findViewById(R.id.rl_wishing_well);
        this.e = findViewById(R.id.rl_wishing_well_knocking);
        this.f = (ImageView) findViewById(R.id.iv_wishing_well);
        this.a = findViewById(R.id.iv_wishing_well_dot);
        this.g = (ImageView) findViewById(R.id.iv_knocking_tag);
        this.h = (ImageView) findViewById(R.id.iv_wishing_well_knocking);
    }

    public void a(LiveWishingDrawModel liveWishingDrawModel) {
        if (liveWishingDrawModel == null) {
            this.d.setVisibility(0);
            this.e.setVisibility(8);
        } else if (liveWishingDrawModel != null) {
            if (liveWishingDrawModel.status != 1) {
                this.d.setVisibility(0);
                this.g.setVisibility(8);
                this.e.setVisibility(8);
                return;
            }
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_ENTER_ICON_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
            EventTrackLive.a(LiveProtos.Event.LIVE_HITS_GIFT_ICON_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveWishingDrawModel.goods_id);
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            this.g.setImageResource(liveWishingDrawModel.type == 1 ? R.drawable.icon_live_wishing_well_pro_knocking_icon : R.drawable.icon_live_wishing_well_knocking_icon);
            this.g.setVisibility(0);
            ImageLoader.a(this.c.getFragmentActive(), liveWishingDrawModel.goods_icon).a(this.h);
        }
    }

    public String getRedPointWord() {
        return this.b;
    }

    public void setBaseFragment(BaseFragment baseFragment) {
        this.c = baseFragment;
    }

    public void setIcon(String str) {
        BaseFragment baseFragment;
        if (TextUtils.isEmpty(str) || (baseFragment = this.c) == null || this.f == null) {
            return;
        }
        ImageLoader.a(baseFragment.getFragmentActive(), str).a(this.f);
    }

    public void setRedPointWord(String str) {
        this.b = str;
    }
}
