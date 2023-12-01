package com.soft.blued.ui.msg.adapter;

import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.FuGiftModel;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/FuGiftAdapter.class */
public class FuGiftAdapter extends BaseQuickAdapter<FuGiftModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f18286a;

    public FuGiftAdapter(List<FuGiftModel> list, IRequestHost iRequestHost) {
        super(R.layout.item_fu_gift, list);
        this.f18286a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, FuGiftModel fuGiftModel) {
        ImageLoader.a(this.f18286a, fuGiftModel.image).a((ImageView) baseViewHolder.getView(R.id.iv));
    }
}
