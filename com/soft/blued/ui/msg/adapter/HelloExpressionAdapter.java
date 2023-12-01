package com.soft.blued.ui.msg.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.HelloExpressionData;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/HelloExpressionAdapter.class */
public class HelloExpressionAdapter extends BaseQuickAdapter<HelloExpressionData, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private IRequestHost f31978a;

    public HelloExpressionAdapter(IRequestHost iRequestHost) {
        super((int) R.layout.item_hello_expression);
        this.f31978a = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, HelloExpressionData helloExpressionData) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_gif);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
        if (baseViewHolder.getAdapterPosition() == 0) {
            marginLayoutParams.leftMargin = DensityUtil.a(10.0f);
        } else {
            marginLayoutParams.leftMargin = 0;
        }
        imageView.setLayoutParams(marginLayoutParams);
        ImageLoader.a(this.f31978a, helloExpressionData.gif).a(6.0f).b(R.drawable.shape_hello_expression_error).a(imageView);
    }
}
