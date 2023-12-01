package com.blued.android.module.yy_china.adapter;

import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyCreateRoomTypeBinding;
import com.blued.android.module.yy_china.model.YYCreateTypeMode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/CreateRoomTypeAdapter.class */
public final class CreateRoomTypeAdapter extends BaseQuickAdapter<YYCreateTypeMode, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final com.blued.android.module.yy_china.fragment.OnClickRoomTypeListener f16118a;
    private YYCreateTypeMode b;

    /* renamed from: c  reason: collision with root package name */
    private final BaseFragment f16119c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRoomTypeAdapter(com.blued.android.module.yy_china.fragment.OnClickRoomTypeListener clickRoomTypeListener, BaseFragment fragment) {
        super(R.layout.item_yy_create_room_type);
        Intrinsics.e(clickRoomTypeListener, "clickRoomTypeListener");
        Intrinsics.e(fragment, "fragment");
        this.f16118a = clickRoomTypeListener;
        this.f16119c = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYCreateTypeMode yYCreateTypeMode, CreateRoomTypeAdapter this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (yYCreateTypeMode == null) {
            return;
        }
        this$0.a(yYCreateTypeMode);
        this$0.f16118a.a(yYCreateTypeMode, "");
    }

    public final void a(YYCreateTypeMode yYCreateTypeMode) {
        this.b = yYCreateTypeMode;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final YYCreateTypeMode yYCreateTypeMode) {
        Intrinsics.e(helper, "helper");
        ItemYyCreateRoomTypeBinding a2 = ItemYyCreateRoomTypeBinding.a(helper.itemView);
        Intrinsics.c(a2, "bind(helper.itemView)");
        String type = yYCreateTypeMode == null ? null : yYCreateTypeMode.getType();
        YYCreateTypeMode yYCreateTypeMode2 = this.b;
        if (Intrinsics.a((Object) type, (Object) (yYCreateTypeMode2 == null ? null : yYCreateTypeMode2.getType()))) {
            a2.d.setVisibility(0);
        } else {
            a2.d.setVisibility(8);
        }
        a2.b.setText(yYCreateTypeMode == null ? null : yYCreateTypeMode.getType_name());
        if (StringUtils.b(yYCreateTypeMode == null ? null : yYCreateTypeMode.getSubscript())) {
            a2.f16704c.setVisibility(8);
        } else {
            a2.f16704c.setText(yYCreateTypeMode == null ? null : yYCreateTypeMode.getSubscript());
            a2.f16704c.setVisibility(0);
        }
        ActivityFragmentActive fragmentActive = this.f16119c.getFragmentActive();
        String icon = yYCreateTypeMode == null ? null : yYCreateTypeMode.getIcon();
        Intrinsics.a((Object) icon);
        ImageLoader.a(fragmentActive, icon).a(a2.f16703a);
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$CreateRoomTypeAdapter$bKFly8Nh1rcQeVWwSW1d7OIOP_Y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomTypeAdapter.a(YYCreateTypeMode.this, this, view);
            }
        });
    }
}
