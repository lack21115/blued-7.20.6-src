package com.blued.android.module.yy_china.adapter;

import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.view.YYBaseUserHeadView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/BaseConnectingAdapter.class */
public abstract class BaseConnectingAdapter<M extends MultiItemEntity, H extends BaseViewHolder> extends BaseMultiItemQuickAdapter<M, H> {
    public BaseConnectingAdapter(List<M> list) {
        super(list);
    }

    public void a(int i, int i2, boolean z) {
    }

    public abstract void a(int i, String str, String str2, YYImModel yYImModel);

    public void a(YYSeatMemberModel yYSeatMemberModel) {
    }

    public abstract void a(YYBaseUserHeadView.GetViewX_Y_W_H getViewX_Y_W_H, String str);

    public abstract void a(String str, String str2);

    public void a(List<BlindPublishModel> list) {
    }

    public abstract void a(Set<String> set);

    public void c() {
    }
}
