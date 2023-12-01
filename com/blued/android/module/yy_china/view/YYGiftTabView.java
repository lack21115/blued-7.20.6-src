package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import com.blued.android.module.yy_china.view.YYGiftTabView;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftTabView.class */
public class YYGiftTabView extends CommonGiftTabView<YYGiftPackageModel> {

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYGiftTabView$YYGiftTabAdapter.class */
    public class YYGiftTabAdapter extends CommonGiftTabView<YYGiftPackageModel>.GiftTabAdapter {
        public YYGiftTabAdapter(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, View view) {
            YYGiftTabView.this.setToolBtnSelect(i);
            if (i < this.dataList.size()) {
                LiveEventBus.get("gift_package_selected").post(((CommonGiftPackageModel) this.dataList.get(i)).index);
            }
        }

        @Override // com.blued.android.module.common.view.CommonGiftTabView.GiftTabAdapter, com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(CommonGiftPackageModel commonGiftPackageModel, final int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            commonAdapterHolder.a(R.id.common_tab_view_item_name, commonGiftPackageModel.name);
            if (YYGiftTabView.this.d == i) {
                ((TextView) commonAdapterHolder.a(R.id.common_tab_view_item_name)).setTextSize(16.0f);
                commonAdapterHolder.a(R.id.common_tab_view_item_name).setEnabled(true);
                commonAdapterHolder.b(R.id.common_tab_view_item_indicator, 0);
            } else {
                ((TextView) commonAdapterHolder.a(R.id.common_tab_view_item_name)).setTextSize(14.0f);
                commonAdapterHolder.a(R.id.common_tab_view_item_name).setEnabled(false);
                commonAdapterHolder.b(R.id.common_tab_view_item_indicator, 8);
            }
            if (commonGiftPackageModel instanceof YYGiftPackageModel) {
                if (((YYGiftPackageModel) commonGiftPackageModel).isBag()) {
                    commonAdapterHolder.b(com.blued.android.module.yy_china.R.id.ll_tab, 8);
                } else {
                    commonAdapterHolder.b(com.blued.android.module.yy_china.R.id.ll_tab, 0);
                }
            }
            commonAdapterHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$YYGiftTabView$YYGiftTabAdapter$Jt9lV39df7jnszEAUuNRh2wt0ts
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYGiftTabView.YYGiftTabAdapter.this.a(i, view);
                }
            });
        }
    }

    public YYGiftTabView(Context context) {
        super(context);
    }

    public YYGiftTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public CommonGiftTabView<YYGiftPackageModel>.GiftTabAdapter a() {
        return new YYGiftTabAdapter(getContext());
    }

    @Override // com.blued.android.module.common.view.CommonGiftTabView
    public int getItemViewLayoutId() {
        if (this.g != null) {
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            layoutParams.width = -1;
            this.g.setLayoutParams(layoutParams);
        }
        return com.blued.android.module.yy_china.R.layout.yy_gift_tab_view_item_layout;
    }
}
