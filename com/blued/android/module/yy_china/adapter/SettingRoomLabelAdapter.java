package com.blued.android.module.yy_china.adapter;

import android.view.View;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyRoomSettingLaberBinding;
import com.blued.android.module.yy_china.model.RoomSettingTopicModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/SettingRoomLabelAdapter.class */
public final class SettingRoomLabelAdapter extends BaseQuickAdapter<RoomSettingTopicModel, BaseViewHolder> {
    private final OnClickRoomTypeListener a;
    private RoomSettingTopicModel b;
    private final BaseDialogFragment c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingRoomLabelAdapter(OnClickRoomTypeListener clickRoomTypeListener, BaseDialogFragment fragment) {
        super(R.layout.item_yy_room_setting_laber);
        Intrinsics.e(clickRoomTypeListener, "clickRoomTypeListener");
        Intrinsics.e(fragment, "fragment");
        this.a = clickRoomTypeListener;
        this.c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SettingRoomLabelAdapter this$0, RoomSettingTopicModel item, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        this$0.b = item;
        this$0.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final RoomSettingTopicModel item, final SettingRoomLabelAdapter this$0, View view) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        this$0.a.a(item, "", new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$SettingRoomLabelAdapter$6FPqGJk-C6jA1isIoSCSSCfQxd8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingRoomLabelAdapter.a(SettingRoomLabelAdapter.this, item, view2);
            }
        });
    }

    public final void a(RoomSettingTopicModel roomSettingTopicModel) {
        this.b = roomSettingTopicModel;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final RoomSettingTopicModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ItemYyRoomSettingLaberBinding a = ItemYyRoomSettingLaberBinding.a(helper.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        if (Intrinsics.a(item, this.b)) {
            a.b.setVisibility(0);
        } else {
            a.b.setVisibility(8);
        }
        a.a.setText(item.getLabel_name());
        if (StringUtils.b(item.getLabel_name())) {
            a.a.setVisibility(8);
        } else {
            a.a.setText(item.getLabel_name());
            a.a.setVisibility(0);
        }
        a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$SettingRoomLabelAdapter$q-G07hsUIOm4iy_2uOmJ47Iu2gQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingRoomLabelAdapter.a(RoomSettingTopicModel.this, this, view);
            }
        });
    }
}
