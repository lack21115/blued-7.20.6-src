package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.InvisibleToUserModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VipInvisibleListAdapter.class */
public final class VipInvisibleListAdapter extends BaseQuickAdapter<InvisibleToUserModel.InvisibleUser, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public InvisibleUserDeleteListener f33813a;
    private final Context b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipInvisibleListAdapter(Context mContext) {
        super((int) R.layout.item_invisible_to_user);
        Intrinsics.e(mContext, "mContext");
        this.b = mContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VipInvisibleListAdapter this$0, InvisibleToUserModel.InvisibleUser item, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(item, "$item");
        if (this$0.a() != null) {
            this$0.a().a(item);
        }
    }

    public final InvisibleUserDeleteListener a() {
        InvisibleUserDeleteListener invisibleUserDeleteListener = this.f33813a;
        if (invisibleUserDeleteListener != null) {
            return invisibleUserDeleteListener;
        }
        Intrinsics.c("invisibleUserDeleteListener");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder helper, final InvisibleToUserModel.InvisibleUser item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        helper.setText(2131372879, item.name);
        View view = helper.getView(2131366006);
        Intrinsics.c(view, "helper.getView(R.id.iv_user_avatar)");
        ImageView imageView = (ImageView) view;
        View view2 = helper.getView(R.id.tv_delete_invisible);
        Intrinsics.c(view2, "helper.getView(R.id.tv_delete_invisible)");
        ImageLoader.a((IRequestHost) null, item.avatar).b(2131237310).c().a(imageView);
        ((ShapeTextView) view2).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VipInvisibleListAdapter$f6o7-NuIXfDbFltv7Z9OPqtlWwo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                VipInvisibleListAdapter.a(VipInvisibleListAdapter.this, item, view3);
            }
        });
    }

    public final void a(InvisibleUserDeleteListener invisibleUserDeleteListener) {
        Intrinsics.e(invisibleUserDeleteListener, "<set-?>");
        this.f33813a = invisibleUserDeleteListener;
    }
}
