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

    /* renamed from: a  reason: collision with root package name */
    private final OnClickRoomTypeListener f16157a;
    private RoomSettingTopicModel b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseDialogFragment f16158c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingRoomLabelAdapter(OnClickRoomTypeListener clickRoomTypeListener, BaseDialogFragment fragment) {
        super(R.layout.item_yy_room_setting_laber);
        Intrinsics.e(clickRoomTypeListener, "clickRoomTypeListener");
        Intrinsics.e(fragment, "fragment");
        this.f16157a = clickRoomTypeListener;
        this.f16158c = fragment;
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
        this$0.f16157a.a(item, "", new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$SettingRoomLabelAdapter$6FPqGJk-C6jA1isIoSCSSCfQxd8
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
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final RoomSettingTopicModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ItemYyRoomSettingLaberBinding a2 = ItemYyRoomSettingLaberBinding.a(helper.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        if (Intrinsics.a(item, this.b)) {
            a2.b.setVisibility(0);
        } else {
            a2.b.setVisibility(8);
        }
        a2.f16816a.setText(item.getLabel_name());
        if (StringUtils.b(item.getLabel_name())) {
            a2.f16816a.setVisibility(8);
        } else {
            a2.f16816a.setText(item.getLabel_name());
            a2.f16816a.setVisibility(0);
        }
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$SettingRoomLabelAdapter$q-G07hsUIOm4iy_2uOmJ47Iu2gQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingRoomLabelAdapter.a(RoomSettingTopicModel.this, this, view);
            }
        });
    }
}
