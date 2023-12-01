package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VirtualImageGoodsCartAdapter.class */
public final class VirtualImageGoodsCartAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final IRequestHost f33815a;
    private final VirtualImageUtils b;

    /* renamed from: c  reason: collision with root package name */
    private final OnBuyInfoChangedListener f33816c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VirtualImageGoodsCartAdapter$OnBuyInfoChangedListener.class */
    public interface OnBuyInfoChangedListener {
        void a(int i, int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VirtualImageGoodsCartAdapter(IRequestHost requestHost, final List<? extends MultiItemEntity> list, VirtualImageUtils virtualImageUtils, OnBuyInfoChangedListener onBuyInfoChangedListener) {
        super(list);
        Intrinsics.e(requestHost, "requestHost");
        Intrinsics.e(virtualImageUtils, "virtualImageUtils");
        this.f33815a = requestHost;
        this.b = virtualImageUtils;
        this.f33816c = onBuyInfoChangedListener;
        addItemType(VirtualImageModel.GoodsTypeInCart.Header.ordinal(), R.layout.item_virtual_image_buy_list_title);
        addItemType(VirtualImageModel.GoodsTypeInCart.Goods.ordinal(), R.layout.item_virtual_image_buy_list_goods);
        setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VirtualImageGoodsCartAdapter$0cvC3wXdFQ1L5McelvlqqVPOnBs
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VirtualImageGoodsCartAdapter.a(List.this, this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageModel.ImageGoodsModel goods, VirtualImageGoodsCartAdapter this$0, BaseViewHolder helper, View view) {
        OnBuyInfoChangedListener onBuyInfoChangedListener;
        Tracker.onClick(view);
        Intrinsics.e(goods, "$goods");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        if (goods.getCBuyCount() > 1) {
            goods.setCBuyCount(goods.getCBuyCount() - 1);
            this$0.notifyItemChanged(helper.getAdapterPosition());
            if (!goods.getCBuy() || (onBuyInfoChangedListener = this$0.f33816c) == null) {
                return;
            }
            onBuyInfoChangedListener.a(-1, -goods.getBeans());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List list, VirtualImageGoodsCartAdapter this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (list != null && list.size() > i) {
            MultiItemEntity multiItemEntity = (MultiItemEntity) this$0.getItem(i);
            if (multiItemEntity instanceof VirtualImageModel.ImageGoodsModel) {
                VirtualImageModel.ImageGoodsModel imageGoodsModel = (VirtualImageModel.ImageGoodsModel) multiItemEntity;
                imageGoodsModel.setCBuy(!imageGoodsModel.getCBuy());
                this$0.notifyItemChanged(i);
                int cBuyCount = imageGoodsModel.getCBuy() ? imageGoodsModel.getCBuyCount() : -imageGoodsModel.getCBuyCount();
                OnBuyInfoChangedListener onBuyInfoChangedListener = this$0.f33816c;
                if (onBuyInfoChangedListener == null) {
                    return;
                }
                onBuyInfoChangedListener.a(cBuyCount, imageGoodsModel.getBeans() * cBuyCount);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageModel.ImageGoodsModel goods, VirtualImageGoodsCartAdapter this$0, BaseViewHolder helper, View view) {
        OnBuyInfoChangedListener onBuyInfoChangedListener;
        Tracker.onClick(view);
        Intrinsics.e(goods, "$goods");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        if (goods.getCBuyCount() < 99) {
            goods.setCBuyCount(goods.getCBuyCount() + 1);
            this$0.notifyItemChanged(helper.getAdapterPosition());
            if (!goods.getCBuy() || (onBuyInfoChangedListener = this$0.f33816c) == null) {
                return;
            }
            onBuyInfoChangedListener.a(1, goods.getBeans());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, MultiItemEntity item) {
        String str;
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        int itemType = item.getItemType();
        if (itemType != VirtualImageModel.GoodsTypeInCart.Goods.ordinal()) {
            if (itemType == VirtualImageModel.GoodsTypeInCart.Header.ordinal()) {
                ((TextView) helper.getView(2131371653)).setText(((VirtualImageModel.CartCategoryHeader) item).getText());
                return;
            }
            return;
        }
        final VirtualImageModel.ImageGoodsModel imageGoodsModel = (VirtualImageModel.ImageGoodsModel) item;
        ImageView icon = (ImageView) helper.getView(R.id.iv_goods_icon);
        VirtualImageUtils virtualImageUtils = this.b;
        Intrinsics.c(icon, "icon");
        virtualImageUtils.loadGoodIcon(icon, imageGoodsModel, this.f33815a);
        ((ImageView) helper.getView(R.id.iv_goods_selector)).setImageResource(imageGoodsModel.getCBuy() ? 2131234035 : 2131234036);
        ((TextView) helper.getView(2131372285)).setText(String.valueOf(imageGoodsModel.getBeans()));
        TextView textView = (TextView) helper.getView(R.id.tv_valid_days);
        boolean z = false;
        if ((imageGoodsModel.is_have() == 1 && imageGoodsModel.getExpire_at() == 0) || imageGoodsModel.getDays() == 0) {
            str = this.mContext.getString(R.string.user_virtual_image_permanently);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = this.mContext.getString(R.string.user_virtual_image_valid_days);
            Intrinsics.c(string, "mContext.getString(R.str…virtual_image_valid_days)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(imageGoodsModel.getDays())}, 1));
            Intrinsics.c(format, "format(format, *args)");
            str = format;
        }
        textView.setText(str);
        ShapeTextView shapeTextView = (ShapeTextView) helper.getView(R.id.tv_goods_count);
        shapeTextView.setText(String.valueOf(imageGoodsModel.getCBuyCount()));
        shapeTextView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VirtualImageGoodsCartAdapter$P6OkHPmqw2BvS5at-fxo4mfBG0s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageGoodsCartAdapter.a(view);
            }
        });
        shapeTextView.setEnabled(false);
        boolean z2 = imageGoodsModel.getCBuyCount() > 1;
        if (imageGoodsModel.is_have() != 2 || imageGoodsModel.getDays() != 0) {
            z = true;
        }
        ((ImageView) helper.getView(R.id.iv_sub_goods)).setEnabled(z2);
        ((ImageView) helper.getView(R.id.iv_add_goods)).setEnabled(z);
        FrameLayout frameLayout = (FrameLayout) helper.getView(R.id.fl_sub_goods);
        FrameLayout frameLayout2 = (FrameLayout) helper.getView(R.id.fl_add_goods);
        frameLayout.setEnabled(z2);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VirtualImageGoodsCartAdapter$09SMhpPG8EQ8C_UILWrquAx-W3w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageGoodsCartAdapter.a(VirtualImageModel.ImageGoodsModel.this, this, helper, view);
            }
        });
        frameLayout2.setEnabled(z);
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VirtualImageGoodsCartAdapter$-L7I7tAIv-m0GTWk2-Zb_mQDBJ0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageGoodsCartAdapter.b(VirtualImageModel.ImageGoodsModel.this, this, helper, view);
            }
        });
    }
}
