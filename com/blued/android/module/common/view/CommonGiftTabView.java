package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.model.CommonGiftPackageModel;
import com.blued.android.module.common.view.CommonGiftTabView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonGiftTabView.class */
public class CommonGiftTabView<T extends CommonGiftPackageModel> extends FrameLayout {
    protected Context a;
    protected LayoutInflater b;
    protected final List<T> c;
    public int d;
    protected int e;
    protected int f;
    protected RecyclerView g;
    private CommonGiftTabView<T>.GiftTabAdapter h;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/CommonGiftTabView$GiftTabAdapter.class */
    public class GiftTabAdapter extends CommonRecycleAdapter<CommonGiftPackageModel> {
        public GiftTabAdapter(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, View view) {
            CommonGiftTabView.this.setToolBtnSelect(i);
            if (i < this.dataList.size()) {
                LiveEventBus.get("gift_package_selected").post(((CommonGiftPackageModel) this.dataList.get(i)).index);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(CommonGiftPackageModel commonGiftPackageModel, final int i, CommonRecycleAdapter.CommonAdapterHolder commonAdapterHolder) {
            commonAdapterHolder.a(R.id.common_tab_view_item_name, commonGiftPackageModel.name);
            if (CommonGiftTabView.this.d == i) {
                commonAdapterHolder.a(R.id.common_tab_view_item_name).setEnabled(true);
                commonAdapterHolder.b(R.id.common_tab_view_item_indicator, 0);
            } else {
                commonAdapterHolder.a(R.id.common_tab_view_item_name).setEnabled(false);
                commonAdapterHolder.b(R.id.common_tab_view_item_indicator, 4);
            }
            commonAdapterHolder.a().setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.view.-$$Lambda$CommonGiftTabView$GiftTabAdapter$Vd5rD4WKw99rFpOFE_LTVPu7GFs
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonGiftTabView.GiftTabAdapter.this.a(i, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return CommonGiftTabView.this.getItemViewLayoutId();
        }
    }

    public CommonGiftTabView(Context context) {
        super(context);
        this.c = new ArrayList();
        this.d = 0;
        a(context);
    }

    public CommonGiftTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
        this.d = 0;
        a(context);
    }

    protected CommonGiftTabView<T>.GiftTabAdapter a() {
        return new GiftTabAdapter(this.a);
    }

    public void a(int i) {
        this.h.notifyItemChanged(i);
    }

    public void a(Context context) {
        this.a = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.b = layoutInflater;
        this.g = layoutInflater.inflate(R.layout.common_tab_view, this).findViewById(R.id.common_tab_view_id);
        this.h = a();
        this.g.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.g.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.blued.android.module.common.view.CommonGiftTabView.1
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                rect.left = CommonGiftTabView.this.e;
                rect.right = CommonGiftTabView.this.f;
            }
        });
        this.g.setAdapter(this.h);
    }

    public CommonGiftTabView<T>.GiftTabAdapter getAdapter() {
        return this.h;
    }

    protected int getItemViewLayoutId() {
        return R.layout.common_tab_view_item_layout;
    }

    public void setData(List<T> list) {
        if (list == null) {
            return;
        }
        this.c.clear();
        this.c.addAll(list);
        this.h.setDataAndNotify(this.c);
        setToolBtnSelect(this.d);
    }

    public void setToolBtnSelect(int i) {
        if (i < this.c.size()) {
            this.d = i;
        } else if (this.d >= this.c.size()) {
            this.d = 0;
        }
        this.g.smoothScrollToPosition(i);
        this.h.notifyDataSetChanged();
    }
}
