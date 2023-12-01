package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.ui.user.model.VIPPrivilegeModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPPrivilegeNewAdapter.class */
public final class VIPPrivilegeNewAdapter extends BaseQuickAdapter<VIPPrivilegeModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20117a;
    private final IRequestHost b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VIPPrivilegeNewAdapter(Context context, IRequestHost iRequestHost) {
        super((int) R.layout.vip_privilege_item_new);
        Intrinsics.e(context, "mContext");
        Intrinsics.e(iRequestHost, "mRequestHost");
        this.f20117a = context;
        this.b = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPPrivilegeNewAdapter vIPPrivilegeNewAdapter, VIPPrivilegeModel vIPPrivilegeModel, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vIPPrivilegeNewAdapter, "this$0");
        Intrinsics.e(vIPPrivilegeModel, "$item");
        WebViewShowInfoFragment.show(vIPPrivilegeNewAdapter.f20117a, vIPPrivilegeModel.url);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final VIPPrivilegeModel vIPPrivilegeModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(vIPPrivilegeModel, "item");
        baseViewHolder.setText(R.id.tv_privilege, vIPPrivilegeModel.name);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_privilege);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_more_privilege);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(2131367999);
        if (!TextUtils.isEmpty(vIPPrivilegeModel.icon)) {
            imageView.setVisibility(0);
            ImageLoader.a(this.b, vIPPrivilegeModel.icon).b(2131237310).c().a(imageView);
            return;
        }
        imageView.setVisibility(8);
        imageView2.setVisibility(0);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPPrivilegeNewAdapter$899uKTJYa3m3m5HR8gNzKt7qAZk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPPrivilegeNewAdapter.a(VIPPrivilegeNewAdapter.this, vIPPrivilegeModel, view);
            }
        });
    }
}
