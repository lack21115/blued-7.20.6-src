package com.blued.android.module.live_china.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveFunctionModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveFunctionAdapter.class */
public class LiveFunctionAdapter extends BaseMultiItemQuickAdapter<LiveFunctionModel, BaseViewHolder> {
    private Context a;

    public LiveFunctionAdapter(Context context) {
        super(new ArrayList());
        this.a = context;
        addItemType(0, R.layout.live_multi_function_item_type_normal);
        addItemType(1, R.layout.live_multi_function_item_type_top_card);
    }

    private void b(BaseViewHolder baseViewHolder, LiveFunctionModel liveFunctionModel) {
        ((ImageView) baseViewHolder.getView(R.id.iv_icon)).setImageResource(liveFunctionModel.icon);
        ((TextView) baseViewHolder.getView(R.id.tv_name)).setText(liveFunctionModel.name);
        View view = baseViewHolder.getView(R.id.tv_dot);
        if (liveFunctionModel.dot == 0) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        baseViewHolder.addOnClickListener(R.id.ll_items_view);
    }

    private void c(BaseViewHolder baseViewHolder, LiveFunctionModel liveFunctionModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.live_iv_top_card);
        imageView.setImageResource(liveFunctionModel.icon);
        QBadgeContainer qBadgeContainer = (QBadgeContainer) baseViewHolder.getView(R.id.ll_top_card_count);
        qBadgeContainer.a(imageView);
        qBadgeContainer.d(8388659);
        qBadgeContainer.a(8.0f, true);
        qBadgeContainer.a(liveFunctionModel.count);
        ((TextView) baseViewHolder.getView(R.id.tv_top_card_name)).setText(liveFunctionModel.name);
        View view = baseViewHolder.getView(R.id.tv_top_card_red_dot);
        if (liveFunctionModel.dot == 0) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        baseViewHolder.addOnClickListener(R.id.ll_items_view);
    }

    public LiveFunctionModel a(int i) {
        List data = getData();
        if (data == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= data.size()) {
                return null;
            }
            if (((LiveFunctionModel) data.get(i3)).function_type == i) {
                return (LiveFunctionModel) data.get(i3);
            }
            i2 = i3 + 1;
        }
    }

    /* renamed from: a */
    public void addData(int i, LiveFunctionModel liveFunctionModel) {
        List data = getData();
        if (data == null) {
            return;
        }
        if (i >= 0 && i < data.size()) {
            data.add(i, liveFunctionModel);
        }
        if (i >= data.size()) {
            data.add(liveFunctionModel);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveFunctionModel liveFunctionModel) {
        if (baseViewHolder != null) {
            int itemViewType = baseViewHolder.getItemViewType();
            if (itemViewType == 0) {
                b(baseViewHolder, liveFunctionModel);
            } else if (itemViewType != 1) {
            } else {
                c(baseViewHolder, liveFunctionModel);
            }
        }
    }

    public void a(List<LiveFunctionModel> list) {
        Log.i("==abc", "models.szie:" + list.size());
        setNewData(list);
        setEnableLoadMore(false);
    }

    public LiveFunctionModel b(int i) {
        if (getData() != null && i < getData().size() && i >= 0) {
            return (LiveFunctionModel) getData().get(i);
        }
        return null;
    }
}
