package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYRedPackageGiftItems;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRedPackageGiftAdapter.class */
public final class YYRedPackageGiftAdapter extends BaseQuickAdapter<YYRedPackageGiftItems, BaseViewHolder> {
    public YYRedPackageGiftAdapter() {
        super(R.layout.item_package_gift_layout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYRedPackageGiftItems yYRedPackageGiftItems) {
        String images_static;
        if (baseViewHolder == null) {
            return;
        }
        ((TextView) baseViewHolder.getView(R.id.tv_gift_count)).setText(Intrinsics.a("x", (Object) (yYRedPackageGiftItems == null ? null : yYRedPackageGiftItems.getNum())));
        if (yYRedPackageGiftItems == null || (images_static = yYRedPackageGiftItems.getImages_static()) == null) {
            return;
        }
        ImageLoader.a((IRequestHost) null, images_static).b(R.drawable.gift_default_icon).a((ImageView) baseViewHolder.getView(R.id.item_img_gift));
    }
}
