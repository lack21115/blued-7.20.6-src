package com.blued.android.module.yy_china.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYRedPackageDetails;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYRedPackageItemAdapter.class */
public final class YYRedPackageItemAdapter extends BaseQuickAdapter<YYRedPackageDetails, BaseViewHolder> {
    public YYRedPackageItemAdapter() {
        super(R.layout.item_package_detail_layout);
    }

    private final void a(View view, int i) {
        getOnItemClickListener().onItemClick(this, view, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BaseViewHolder baseViewHolder, YYRedPackageItemAdapter this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (baseViewHolder == null) {
            return;
        }
        View view2 = baseViewHolder.itemView;
        Intrinsics.c(view2, "it.itemView");
        this$0.a(view2, baseViewHolder.getAdapterPosition());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, YYRedPackageDetails yYRedPackageDetails) {
        ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.item_background_view);
        ImageView imageView2 = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.img_value_info);
        RecyclerView view = baseViewHolder == null ? null : baseViewHolder.getView(R.id.rv_gift_list);
        TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_package_value);
        TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_package_count);
        if (textView != null) {
            textView.setText(yYRedPackageDetails == null ? null : yYRedPackageDetails.getTotal_beans());
        }
        if (textView2 != null) {
            textView2.setText(Intrinsics.a(yYRedPackageDetails == null ? null : yYRedPackageDetails.getTotal_num(), (Object) "个礼物"));
        }
        boolean z = false;
        if ((yYRedPackageDetails == null ? null : yYRedPackageDetails.getGoods_lists()) != null) {
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
            linearLayoutManager.setOrientation(0);
            if (view != null) {
                view.setLayoutManager(linearLayoutManager);
            }
            RecyclerView.Adapter yYRedPackageGiftAdapter = new YYRedPackageGiftAdapter();
            if (view != null) {
                view.setAdapter(yYRedPackageGiftAdapter);
            }
            yYRedPackageGiftAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.adapter.-$$Lambda$YYRedPackageItemAdapter$XGzlgBckb3UzieRs9eX86V5q858
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    YYRedPackageItemAdapter.a(baseViewHolder, this, baseQuickAdapter, view2, i);
                }
            });
            yYRedPackageGiftAdapter.setNewData(yYRedPackageDetails.getGoods_lists());
        }
        if (yYRedPackageDetails != null && yYRedPackageDetails.is_checked() == 1) {
            z = true;
        }
        if (z) {
            if (imageView != null) {
                imageView.setImageResource(R.drawable.bg_package_item_checked);
            }
            if (imageView2 == null) {
                return;
            }
            imageView2.setImageResource(R.drawable.img_package_value_info_bg_checked);
            return;
        }
        if (imageView != null) {
            imageView.setImageResource(R.drawable.bg_package_item_normal);
        }
        if (imageView2 == null) {
            return;
        }
        imageView2.setImageResource(R.drawable.img_package_value_info_bg_normal);
    }
}
