package com.blued.community.view;

import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/view/CommonMultiItemAdapter.class */
public abstract class CommonMultiItemAdapter<T extends MultiItemEntity> extends BaseMultiItemQuickAdapter<T, CommonViewHolder> {
    private IRequestHost requestHost;

    public CommonMultiItemAdapter() {
        super(null);
        onAddItemType();
    }

    public void addDataAndNotify(List<T> list) {
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    protected void convert(CommonViewHolder commonViewHolder, T t) {
        int itemPosition = getItemPosition((CommonMultiItemAdapter<T>) t);
        if (itemPosition == -1 || commonViewHolder == null || t == null) {
            return;
        }
        onConvert(commonViewHolder, t, itemPosition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj) {
        convert((CommonViewHolder) baseViewHolder, (CommonViewHolder) ((MultiItemEntity) obj));
    }

    protected int getItemPosition(T t) {
        if (t == null || getData().isEmpty()) {
            return -1;
        }
        return getData().indexOf(t);
    }

    protected abstract void onAddItemType();

    protected abstract void onConvert(CommonViewHolder commonViewHolder, T t, int i);

    public void setDataAndNotify(List<T> list) {
        this.mData.clear();
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void updateItemAndNotify(int i, T t) {
        if (i < 0 || i >= this.mData.size()) {
            return;
        }
        this.mData.set(i, t);
        notifyItemChanged(i);
    }
}
