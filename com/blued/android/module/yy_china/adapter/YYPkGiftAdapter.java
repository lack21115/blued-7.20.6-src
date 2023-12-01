package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.model.YYPkGiftModel;
import com.blued.android.module.yy_china.model.YYPkGoodsModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYPkGiftAdapter.class */
public class YYPkGiftAdapter extends BaseQuickAdapter<YYPkGiftModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private int f16207a;
    private int b;

    public YYPkGiftAdapter(Context context) {
        super(R.layout.view_yy_pk_gift);
        this.f16207a = 0;
        this.b = 0;
        int a2 = AppInfo.l - DensityUtils.a(context, 30.0f);
        this.f16207a = a2;
        this.b = (int) (a2 * 0.203d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, YYPkGiftModel yYPkGiftModel) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_pk_gift_layout);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.gift_icon_left);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.gift_icon_right);
        TextView textView = (TextView) baseViewHolder.getView(R.id.gift_value_right);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.gift_value_left);
        List<YYPkGoodsModel> list = yYPkGiftModel.gifts;
        if (list == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = this.f16207a;
        layoutParams.height = this.b;
        Logger.e("YYPkGiftAdapter", "bgWidth: " + this.f16207a + " , bgHeight: " + this.b);
        imageView.setImageResource(yYPkGiftModel.selected ? R.drawable.icon_yy_selected_pk_bg : R.drawable.icon_yy_normal_pk_bg);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            YYPkGoodsModel yYPkGoodsModel = list.get(i2);
            if (i2 == 0) {
                ImageLoader.a((IRequestHost) null, yYPkGoodsModel.images).a(imageView2);
                textView2.setText(yYPkGoodsModel.beans);
            } else if (i2 == 1) {
                ImageLoader.a((IRequestHost) null, yYPkGoodsModel.images).a(imageView3);
                textView.setText(yYPkGoodsModel.beans);
            }
            i = i2 + 1;
        }
    }
}
