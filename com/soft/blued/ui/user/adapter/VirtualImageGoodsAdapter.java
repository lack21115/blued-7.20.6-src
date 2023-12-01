package com.soft.blued.ui.user.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.fragment.VirtualImageFragment;
import com.soft.blued.ui.user.model.VirtualImageModel;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VirtualImageGoodsAdapter.class */
public final class VirtualImageGoodsAdapter extends BaseQuickAdapter<VirtualImageModel.ImageGoodsModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final VirtualImageFragment.ImageCallBack f33814a;
    private int b;

    public VirtualImageGoodsAdapter(VirtualImageFragment.ImageCallBack imageCallBack) {
        super((int) R.layout.item_image_goods);
        this.f33814a = imageCallBack;
        this.b = 5;
    }

    private final void a(ShapeTextView shapeTextView, List<VirtualImageModel.Tags> list) {
        int i = 0;
        if (!list.isEmpty()) {
            shapeTextView.setText(list.get(0).getTitle());
            int position = list.get(0).getPosition();
            ViewGroup.LayoutParams layoutParams = shapeTextView.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (position == 1) {
                layoutParams2.topToTop = 2131369459;
                layoutParams2.bottomToBottom = -1;
                layoutParams2.leftToLeft = 2131369459;
                layoutParams2.rightToRight = -1;
            } else if (position == 2) {
                layoutParams2.topToTop = 2131369459;
                layoutParams2.bottomToBottom = -1;
                layoutParams2.rightToRight = 2131369459;
                layoutParams2.leftToLeft = -1;
            } else if (position == 3) {
                layoutParams2.topToTop = -1;
                layoutParams2.bottomToBottom = 2131369459;
                layoutParams2.leftToLeft = 2131369459;
                layoutParams2.rightToRight = -1;
            } else if (position == 4) {
                layoutParams2.topToTop = -1;
                layoutParams2.bottomToBottom = 2131369459;
                layoutParams2.leftToLeft = -1;
                layoutParams2.rightToRight = 2131369459;
            } else if (position == 5) {
                layoutParams2.topToTop = 2131369459;
                layoutParams2.bottomToBottom = 2131369459;
                layoutParams2.leftToLeft = 2131369459;
                layoutParams2.rightToRight = 2131369459;
            }
            shapeTextView.setLayoutParams(layoutParams2);
        } else {
            i = 8;
        }
        shapeTextView.setVisibility(i);
    }

    public final void a(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, VirtualImageModel.ImageGoodsModel item) {
        List<VirtualImageModel.Tags> tags;
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ShapeConstraintLayout shapeConstraintLayout = (ShapeConstraintLayout) helper.getView(2131369459);
        ImageView image = (ImageView) helper.getView(R.id.iv_goods_icon);
        ShapeTextView tag = (ShapeTextView) helper.getView(2131372678);
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(R.id.tv_days);
        ImageView imageView = (ImageView) helper.getView(R.id.iv_bean);
        TextView textView = (TextView) helper.getView(2131372285);
        ViewGroup.LayoutParams layoutParams = shapeConstraintLayout.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = image.getLayoutParams();
        VirtualImageFragment.ImageCallBack imageCallBack = this.f33814a;
        if (imageCallBack != null) {
            Intrinsics.c(image, "image");
            imageCallBack.a(image, item);
        }
        shapeTextView.setVisibility(8);
        if (item.is_have() != 1 || item.getExpire_at() <= 0) {
            VirtualImageModel.Extra extra = item.getExtra();
            if (extra != null && (tags = extra.getTags()) != null) {
                Intrinsics.c(tag, "tag");
                a(tag, tags);
            }
            if (item.getDays() > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = this.mContext.getString(R.string.user_virtual_image_days);
                Intrinsics.c(string, "mContext.getString(R.str….user_virtual_image_days)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(item.getDays())}, 1));
                Intrinsics.c(format, "format(format, *args)");
                shapeTextView.setText(format);
                shapeTextView.setVisibility(0);
            }
            if (item.getBeans() == 0) {
                textView.setText(this.mContext.getResources().getString(2131887695));
                imageView.setVisibility(8);
            } else if (item.is_have() == 1 && item.getExpire_at() == 0) {
                textView.setText(this.mContext.getString(R.string.user_virtual_image_permanently));
                imageView.setVisibility(8);
            } else if (item.is_have() != 1) {
                textView.setText(String.valueOf(item.getBeans()));
                imageView.setVisibility(0);
            }
        } else {
            int daysLeft = item.getDaysLeft();
            if (daysLeft > 1) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                String string2 = this.mContext.getString(R.string.user_virtual_image_time_remaining);
                Intrinsics.c(string2, "mContext.getString(R.str…ual_image_time_remaining)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(daysLeft)}, 1));
                Intrinsics.c(format2, "format(format, *args)");
                textView.setText(format2);
            } else {
                textView.setText(this.mContext.getString(R.string.user_virtual_image_last_day));
            }
            imageView.setVisibility(8);
            tag.setVisibility(8);
        }
        if (item.getCurrent_use() == 1) {
            ShapeConstraintLayout shapeConstraintLayout2 = shapeConstraintLayout;
            ShapeHelper.d(shapeConstraintLayout2, 2131102203);
            ShapeHelper.b(shapeConstraintLayout2, 2131102478);
        } else {
            ShapeConstraintLayout shapeConstraintLayout3 = shapeConstraintLayout;
            ShapeHelper.d(shapeConstraintLayout3, 2131102388);
            ShapeHelper.b(shapeConstraintLayout3, 2131101699);
        }
        if (this.b == 5) {
            layoutParams.width = ((AppInfo.l - BluedViewExtKt.a(16)) - (BluedViewExtKt.a(5) * 4)) / 5;
            layoutParams.height = layoutParams.width;
        } else {
            layoutParams.width = ((AppInfo.l - BluedViewExtKt.a(16)) - (BluedViewExtKt.a(5) * 3)) / 4;
            layoutParams.height = (int) (layoutParams.width * 1.2d);
        }
        layoutParams2.width = layoutParams.width - BluedViewExtKt.a(20);
        layoutParams2.height = layoutParams.width - BluedViewExtKt.a(20);
        shapeConstraintLayout.setLayoutParams(layoutParams);
        image.setLayoutParams(layoutParams2);
    }
}
