package com.blued.android.module.yy_china.adapter;

import android.view.View;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ItemYyCreateRoomBgBinding;
import com.blued.android.module.yy_china.model.BgCollectionMode;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/CreateRoomBgAdapter.class */
public final class CreateRoomBgAdapter extends BaseQuickAdapter<BgCollectionMode, BaseViewHolder> {
    private final ClickRoomBgListener a;
    private int b;
    private BgCollectionMode c;
    private final BaseFragment d;
    private View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRoomBgAdapter(ClickRoomBgListener clickRoomBgListener, BaseFragment fragment, int i) {
        super(R.layout.item_yy_create_room_bg);
        Intrinsics.e(clickRoomBgListener, "clickRoomBgListener");
        Intrinsics.e(fragment, "fragment");
        this.a = clickRoomBgListener;
        this.b = i;
        this.d = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CreateRoomBgAdapter this$0, BgCollectionMode bgCollectionMode, ItemYyCreateRoomBgBinding bind, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(bind, "$bind");
        this$0.c = bgCollectionMode;
        View view2 = this$0.e;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        bind.c.setVisibility(0);
        this$0.e = (View) bind.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final CreateRoomBgAdapter this$0, final BgCollectionMode bgCollectionMode, final ItemYyCreateRoomBgBinding bind, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(bind, "$bind");
        int i = this$0.b;
        Integer valueOf = bgCollectionMode == null ? null : Integer.valueOf(bgCollectionMode.getAllow_level());
        Intrinsics.a(valueOf);
        if (i >= valueOf.intValue()) {
            if (bgCollectionMode != null) {
                this$0.a.a(bgCollectionMode, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$CreateRoomBgAdapter$XJX6CKKb6FJv5BpY7E2QeZPvQdE
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        CreateRoomBgAdapter.a(CreateRoomBgAdapter.this, bgCollectionMode, bind, view2);
                    }
                });
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("需要主播等级达到Lv.");
        sb.append(bgCollectionMode == null ? null : Integer.valueOf(bgCollectionMode.getAllow_level()));
        sb.append("才可以解锁");
        ToastUtils.a(sb.toString());
    }

    public final BgCollectionMode a() {
        return this.c;
    }

    public final void a(View view) {
        this.e = view;
    }

    public final void a(BgCollectionMode bgCollectionMode) {
        this.c = bgCollectionMode;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final BgCollectionMode bgCollectionMode) {
        Intrinsics.e(helper, "helper");
        final ItemYyCreateRoomBgBinding a = ItemYyCreateRoomBgBinding.a(helper.itemView);
        Intrinsics.c(a, "bind(helper.itemView)");
        if (bgCollectionMode != null) {
            ImageLoader.a(b().getFragmentActive(), bgCollectionMode.getDefault_pic()).a(8.0f).a(a.a);
            if (StringUtils.b(bgCollectionMode.getPic())) {
                a.b.setImageResource(R.color.transparent);
            } else {
                ImageLoader.a(b().getFragmentActive(), bgCollectionMode.getPic()).g().g(-1).a(a.b);
            }
            if (bgCollectionMode.getAllow_level() >= 1) {
                a.d.setVisibility(0);
                a.d.setText(bgCollectionMode.getLevel_notice());
            } else {
                a.d.setVisibility(8);
            }
            if (a() == bgCollectionMode) {
                a.c.setVisibility(0);
                a((View) a.c);
            } else {
                a.c.setVisibility(8);
            }
        }
        a.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$CreateRoomBgAdapter$B9G7b8uNVDI7Q4xWXxLNuOPo1qc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CreateRoomBgAdapter.b(CreateRoomBgAdapter.this, bgCollectionMode, a, view);
            }
        });
    }

    public final BaseFragment b() {
        return this.d;
    }
}
