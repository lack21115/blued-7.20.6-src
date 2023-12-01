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
    private final ServiceMenuPopWindow f32188a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private long f32189c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceMenuPopAdapter(ServiceMenuPopWindow serviceMenuPopWindow, int i) {
        super((int) R.layout.service_menu_pop_item);
        Intrinsics.e(serviceMenuPopWindow, "serviceMenuPopWindow");
        this.f32188a = serviceMenuPopWindow;
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMenuModel item, ServiceMenuPopAdapter this$0, BaseViewHolder helper, View view) {
        Tracker.onClick(view);
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        if (item.type == 1) {
            WebViewShowInfoFragment.show(this$0.mContext, item.value.url, -1);
        } else {
            ChatHttpUtils.a((BluedUIHttpResponse) null, String.valueOf(this$0.f32189c), 1, this$0.b, helper.getAdapterPosition(), item.name, (ChattingModel) null);
        }
        this$0.f32188a.p();
        EventTrackMessage.e(MessageProtos.Event.SERVICE_MSG_PAGE_SECOND_CLICK, String.valueOf(this$0.f32189c), item.name);
    }

    public final void a(long j) {
        this.f32189c = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, final ServiceMenuModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        helper.setText(R.id.tv_menu_name, item.name);
        ((LinearLayout) helper.getView(2131367715)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$ServiceMenuPopAdapter$cB-5VkczSyJcDdVYv7-HinYUTpw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceMenuPopAdapter.a(ServiceMenuModel.this, this, helper, view);
            }
        });
        boolean z = true;
        if (item.show_divider == 1) {
            z = false;
        }
        helper.setGone(R.id.tv_divider, z);
    }
}
