package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemHomeBottBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeRightMenuDotModel;
import com.blued.android.module.yy_china.model.HomeRightMenuModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/HomeRightMenuAdapter.class */
public final class HomeRightMenuAdapter extends BaseQuickAdapter<HomeRightMenuModel, BaseViewHolder> {
    private final BaseFragment a;
    private final View.OnClickListener b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRightMenuAdapter(BaseFragment fra, View.OnClickListener lis) {
        super(R.layout.item_home_bott);
        Intrinsics.e(fra, "fra");
        Intrinsics.e(lis, "lis");
        this.a = fra;
        this.b = lis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HomeRightMenuModel homeRightMenuModel, HomeRightMenuAdapter this$0, ItemHomeBottBinding bind, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(bind, "$bind");
        SharedPreferences.Editor edit = SharedPreferencesUtils.b().edit();
        edit.putInt("YYHOME_RIGHT_MENU_DoT" + homeRightMenuModel.getName() + homeRightMenuModel.getDot().getVersion() + ((Object) YYRoomInfoManager.e().k()), 1).apply();
        this$0.b.onClick(null);
        YYRoomInfoManager.e().c().a((Context) this$0.a.getActivity(), homeRightMenuModel == null ? null : homeRightMenuModel.getUrl(), 0, true);
        bind.c.setVisibility(8);
        EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_HALL_BTN_CLICK, homeRightMenuModel == null ? null : homeRightMenuModel.getName());
    }

    public final BaseFragment a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final HomeRightMenuModel homeRightMenuModel) {
        String icon_black;
        String icon;
        View view = baseViewHolder == null ? null : baseViewHolder.itemView;
        Intrinsics.a(view);
        final ItemHomeBottBinding a = ItemHomeBottBinding.a(view);
        Intrinsics.c(a, "bind(helper?.itemView!!)");
        a.e.setText(homeRightMenuModel == null ? null : homeRightMenuModel.getName());
        if (homeRightMenuModel != null) {
            HomeRightMenuDotModel dot = homeRightMenuModel.getDot();
            boolean z = true;
            if (dot == null || dot.getStatus() != 1) {
                z = false;
            }
            if (z) {
                a.c.setVisibility(0);
            } else {
                a.c.setVisibility(8);
            }
            a.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$HomeRightMenuAdapter$rO0zZHZFaL2PUgp3xDIE1joaEJw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    HomeRightMenuAdapter.a(HomeRightMenuModel.this, this, a, view2);
                }
            });
        }
        if (!BluedSkinUtils.c()) {
            if (homeRightMenuModel != null && (icon_black = homeRightMenuModel.getIcon_black()) != null) {
                ImageLoader.a(a().getFragmentActive(), icon_black).a(a.a);
            }
            a.b.setImageResource(R.drawable.icon_yy_home_black_hei);
            return;
        }
        a.b.setImageResource(R.drawable.icon_yy_home_black);
        if (homeRightMenuModel == null || (icon = homeRightMenuModel.getIcon()) == null) {
            return;
        }
        ImageLoader.a(a().getFragmentActive(), icon).a(a.a);
    }
}
