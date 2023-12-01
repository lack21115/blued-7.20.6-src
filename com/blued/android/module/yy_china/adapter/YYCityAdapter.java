package com.blued.android.module.yy_china.adapter;

import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYRomanticCityModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYCityAdapter.class */
public final class YYCityAdapter extends BaseQuickAdapter<YYRomanticCityModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityFragmentActive f16164a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYCityAdapter(ActivityFragmentActive fragmentActive) {
        super(R.layout.item_city_page_layout);
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.f16164a = fragmentActive;
    }

    public final ActivityFragmentActive a() {
        return this.f16164a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYRomanticCityModel yYRomanticCityModel) {
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_city);
        TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_city_count);
        ShapeableImageView shapeableImageView = baseViewHolder == null ? null : (ShapeableImageView) baseViewHolder.getView(R.id.img_user_head);
        if (yYRomanticCityModel == null) {
            return;
        }
        ImageLoader.a(a(), yYRomanticCityModel.getImage()).a(imageView);
        if (textView != null) {
            textView.setText(Intrinsics.a("已收集 x", (Object) Integer.valueOf(yYRomanticCityModel.getTotal_count())));
        }
        ImageLoader.a(a(), yYRomanticCityModel.getSend_user_avatar()).b(R.drawable.user_bg_round).a(shapeableImageView);
    }
}
