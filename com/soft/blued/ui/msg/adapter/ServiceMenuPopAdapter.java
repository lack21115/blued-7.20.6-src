package com.soft.blued.ui.msg.adapter;

import android.view.View;
import android.widget.LinearLayout;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.msg.ServiceMenuPopWindow;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/ServiceMenuPopAdapter.class */
public final class ServiceMenuPopAdapter extends BaseQuickAdapter<ServiceMenuModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final ServiceMenuPopWindow f18498a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private long f18499c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceMenuPopAdapter(ServiceMenuPopWindow serviceMenuPopWindow, int i) {
        super((int) R.layout.service_menu_pop_item);
        Intrinsics.e(serviceMenuPopWindow, "serviceMenuPopWindow");
        this.f18498a = serviceMenuPopWindow;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMenuModel serviceMenuModel, ServiceMenuPopAdapter serviceMenuPopAdapter, BaseViewHolder baseViewHolder, View view) {
        Tracker.onClick(view);
        Intrinsics.e(serviceMenuModel, "$item");
        Intrinsics.e(serviceMenuPopAdapter, "this$0");
        Intrinsics.e(baseViewHolder, "$helper");
        if (serviceMenuModel.type == 1) {
            WebViewShowInfoFragment.show(serviceMenuPopAdapter.mContext, serviceMenuModel.value.url, -1);
        } else {
            ChatHttpUtils.a((BluedUIHttpResponse) null, String.valueOf(serviceMenuPopAdapter.f18499c), 1, serviceMenuPopAdapter.b, baseViewHolder.getAdapterPosition(), serviceMenuModel.name, (ChattingModel) null);
        }
        serviceMenuPopAdapter.f18498a.p();
        EventTrackMessage.e(MessageProtos.Event.SERVICE_MSG_PAGE_SECOND_CLICK, String.valueOf(serviceMenuPopAdapter.f18499c), serviceMenuModel.name);
    }

    public final void a(long j) {
        this.f18499c = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final ServiceMenuModel serviceMenuModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(serviceMenuModel, "item");
        baseViewHolder.setText(R.id.tv_menu_name, serviceMenuModel.name);
        ((LinearLayout) baseViewHolder.getView(2131367715)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMenuPopAdapter$cB-5VkczSyJcDdVYv7-HinYUTpw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceMenuPopAdapter.a(ServiceMenuModel.this, this, baseViewHolder, view);
            }
        });
        boolean z = true;
        if (serviceMenuModel.show_divider == 1) {
            z = false;
        }
        baseViewHolder.setGone(R.id.tv_divider, z);
    }
}
