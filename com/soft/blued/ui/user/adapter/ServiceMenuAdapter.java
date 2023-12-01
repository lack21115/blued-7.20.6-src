package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.FlowLayout;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.user.fragment.ServiceMenuDialogFragment;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/ServiceMenuAdapter.class */
public final class ServiceMenuAdapter extends BaseQuickAdapter<ServiceMenuModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20060a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final ServiceMenuDialogFragment f20061c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceMenuAdapter(Context context, String str, ServiceMenuDialogFragment serviceMenuDialogFragment) {
        super((int) R.layout.item_service_menu);
        Intrinsics.e(context, "mContext");
        Intrinsics.e(str, "uid");
        Intrinsics.e(serviceMenuDialogFragment, "dialog");
        this.f20060a = context;
        this.b = str;
        this.f20061c = serviceMenuDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final ServiceMenuModel serviceMenuModel, final ServiceMenuAdapter serviceMenuAdapter, final BaseViewHolder baseViewHolder, View view) {
        Tracker.onClick(view);
        Intrinsics.e(serviceMenuModel, "$item");
        Intrinsics.e(serviceMenuAdapter, "this$0");
        Intrinsics.e(baseViewHolder, "$helper");
        if (serviceMenuModel.levelTwo == null || serviceMenuModel.levelTwo.size() <= 0) {
            if (serviceMenuModel.type == 1) {
                if (!TextUtils.isEmpty(serviceMenuModel.value.url)) {
                    WebViewShowInfoFragment.show(serviceMenuAdapter.f20060a, serviceMenuModel.value.url, -1);
                }
            } else if (TextUtils.equals(serviceMenuAdapter.b, UserInfo.getInstance().getLoginUserInfo().uid)) {
                AppMethods.a(serviceMenuAdapter.f20060a.getString(R.string.not_to_msg_self));
            } else {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.adapter.ServiceMenuAdapter$convert$1$1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatHttpUtils.a((BluedUIHttpResponse) null, ServiceMenuAdapter.this.a(), 1, baseViewHolder.getAdapterPosition(), 0, serviceMenuModel.name, (ChattingModel) null);
                    }
                }, 150L);
                LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_MENU_TO_MSG).post(true);
            }
            serviceMenuAdapter.f20061c.dismiss();
            EventTrackPersonalProfile.e(PersonalProfileProtos.Event.SERVICE_PROFILE_PAGE_POP_FIRST_CLICK, serviceMenuAdapter.b, serviceMenuModel.name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final ServiceMenuModel serviceMenuModel, final ServiceMenuAdapter serviceMenuAdapter, final BaseViewHolder baseViewHolder, View view, final int i) {
        Intrinsics.e(serviceMenuModel, "$item");
        Intrinsics.e(serviceMenuAdapter, "this$0");
        Intrinsics.e(baseViewHolder, "$helper");
        if (view instanceof TextView) {
            if (serviceMenuModel.levelTwo.get(i).type == 1) {
                if (!TextUtils.isEmpty(serviceMenuModel.levelTwo.get(i).value.url)) {
                    serviceMenuAdapter.f20061c.dismiss();
                    WebViewShowInfoFragment.show(serviceMenuAdapter.f20060a, serviceMenuModel.levelTwo.get(i).value.url, -1);
                }
            } else if (TextUtils.equals(serviceMenuAdapter.b, UserInfo.getInstance().getLoginUserInfo().uid)) {
                AppMethods.a(serviceMenuAdapter.f20060a.getString(R.string.not_to_msg_self));
            } else {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.adapter.ServiceMenuAdapter$convert$2$1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatHttpUtils.a((BluedUIHttpResponse) null, ServiceMenuAdapter.this.a(), 1, baseViewHolder.getAdapterPosition(), i, serviceMenuModel.name, (ChattingModel) null);
                    }
                }, 150L);
                LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_MENU_TO_MSG).post(true);
            }
            serviceMenuAdapter.f20061c.dismiss();
            EventTrackPersonalProfile.e(PersonalProfileProtos.Event.SERVICE_PROFILE_PAGE_POP_SECOND_CLICK, serviceMenuAdapter.b, serviceMenuModel.levelTwo.get(i).name);
        }
    }

    private final void a(List<ServiceMenuModel> list, FlowLayout flowLayout) {
        flowLayout.removeAllViews();
        for (ServiceMenuModel serviceMenuModel : list) {
            View inflate = this.mLayoutInflater.inflate(R.layout.item_service_menu_leve_two, (ViewGroup) null);
            Intrinsics.c(inflate, "mLayoutInflater.inflate(…vice_menu_leve_two, null)");
            inflate.findViewById(R.id.tv_service_menu_leve_two).setText(serviceMenuModel.name);
            flowLayout.addView(inflate);
        }
    }

    public final String a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder baseViewHolder, final ServiceMenuModel serviceMenuModel) {
        Intrinsics.e(baseViewHolder, "helper");
        Intrinsics.e(serviceMenuModel, "item");
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_service_leve_two);
        FlowLayout flowLayout = (FlowLayout) baseViewHolder.getView(R.id.fl_level_two);
        baseViewHolder.setText(2131372046, serviceMenuModel.name);
        if (serviceMenuModel.levelTwo != null && serviceMenuModel.levelTwo.size() > 0) {
            imageView.setVisibility(8);
            flowLayout.setVisibility(0);
            List<ServiceMenuModel> list = serviceMenuModel.levelTwo;
            Intrinsics.c(list, "item.levelTwo");
            Intrinsics.c(flowLayout, "flLevelTwo");
            a(list, flowLayout);
        }
        ((LinearLayout) baseViewHolder.getView(2131363075)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$ServiceMenuAdapter$zf8D1zzkkkF3gR0wfHXikd5_AN4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceMenuAdapter.a(ServiceMenuModel.this, this, baseViewHolder, view);
            }
        });
        flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$ServiceMenuAdapter$qJXni0xFdlTo5kMN74Q9b96Shrc
            public final void onItemClick(View view, int i) {
                ServiceMenuAdapter.a(ServiceMenuModel.this, this, baseViewHolder, view, i);
            }
        });
    }
}
