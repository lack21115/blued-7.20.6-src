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
import com.blued.android.framework.view.shape.ShapeTextView;
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
    private final Context f33751a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final ServiceMenuDialogFragment f33752c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceMenuAdapter(Context mContext, String uid, ServiceMenuDialogFragment dialog) {
        super((int) R.layout.item_service_menu);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(dialog, "dialog");
        this.f33751a = mContext;
        this.b = uid;
        this.f33752c = dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final ServiceMenuModel item, final ServiceMenuAdapter this$0, final BaseViewHolder helper, View view) {
        Tracker.onClick(view);
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        if (item.levelTwo == null || item.levelTwo.size() <= 0) {
            if (item.type == 1) {
                if (!TextUtils.isEmpty(item.value.url)) {
                    WebViewShowInfoFragment.show(this$0.f33751a, item.value.url, -1);
                }
            } else if (TextUtils.equals(this$0.b, UserInfo.getInstance().getLoginUserInfo().uid)) {
                AppMethods.a((CharSequence) this$0.f33751a.getString(R.string.not_to_msg_self));
            } else {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.adapter.ServiceMenuAdapter$convert$1$1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatHttpUtils.a((BluedUIHttpResponse) null, ServiceMenuAdapter.this.a(), 1, helper.getAdapterPosition(), 0, item.name, (ChattingModel) null);
                    }
                }, 150L);
                LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_MENU_TO_MSG).post(true);
            }
            this$0.f33752c.dismiss();
            EventTrackPersonalProfile.e(PersonalProfileProtos.Event.SERVICE_PROFILE_PAGE_POP_FIRST_CLICK, this$0.b, item.name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final ServiceMenuModel item, final ServiceMenuAdapter this$0, final BaseViewHolder helper, View view, final int i) {
        Intrinsics.e(item, "$item");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(helper, "$helper");
        if (view instanceof TextView) {
            if (item.levelTwo.get(i).type == 1) {
                if (!TextUtils.isEmpty(item.levelTwo.get(i).value.url)) {
                    this$0.f33752c.dismiss();
                    WebViewShowInfoFragment.show(this$0.f33751a, item.levelTwo.get(i).value.url, -1);
                }
            } else if (TextUtils.equals(this$0.b, UserInfo.getInstance().getLoginUserInfo().uid)) {
                AppMethods.a((CharSequence) this$0.f33751a.getString(R.string.not_to_msg_self));
            } else {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.user.adapter.ServiceMenuAdapter$convert$2$1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChatHttpUtils.a((BluedUIHttpResponse) null, ServiceMenuAdapter.this.a(), 1, helper.getAdapterPosition(), i, item.name, (ChattingModel) null);
                    }
                }, 150L);
                LiveEventBus.get(EventBusConstant.KEY_EVENT_CLICK_MENU_TO_MSG).post(true);
            }
            this$0.f33752c.dismiss();
            EventTrackPersonalProfile.e(PersonalProfileProtos.Event.SERVICE_PROFILE_PAGE_POP_SECOND_CLICK, this$0.b, item.levelTwo.get(i).name);
        }
    }

    private final void a(List<ServiceMenuModel> list, FlowLayout flowLayout) {
        flowLayout.removeAllViews();
        for (ServiceMenuModel serviceMenuModel : list) {
            View inflate = this.mLayoutInflater.inflate(R.layout.item_service_menu_leve_two, (ViewGroup) null);
            Intrinsics.c(inflate, "mLayoutInflater.inflate(…vice_menu_leve_two, null)");
            ((ShapeTextView) inflate.findViewById(R.id.tv_service_menu_leve_two)).setText(serviceMenuModel.name);
            flowLayout.addView(inflate);
        }
    }

    public final String a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(final BaseViewHolder helper, final ServiceMenuModel item) {
        Intrinsics.e(helper, "helper");
        Intrinsics.e(item, "item");
        ImageView imageView = (ImageView) helper.getView(R.id.iv_service_leve_two);
        FlowLayout flLevelTwo = (FlowLayout) helper.getView(R.id.fl_level_two);
        helper.setText(2131372046, item.name);
        if (item.levelTwo != null && item.levelTwo.size() > 0) {
            imageView.setVisibility(8);
            flLevelTwo.setVisibility(0);
            List<ServiceMenuModel> list = item.levelTwo;
            Intrinsics.c(list, "item.levelTwo");
            Intrinsics.c(flLevelTwo, "flLevelTwo");
            a(list, flLevelTwo);
        }
        ((LinearLayout) helper.getView(2131363075)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$ServiceMenuAdapter$zf8D1zzkkkF3gR0wfHXikd5_AN4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServiceMenuAdapter.a(ServiceMenuModel.this, this, helper, view);
            }
        });
        flLevelTwo.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$ServiceMenuAdapter$qJXni0xFdlTo5kMN74Q9b96Shrc
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i) {
                ServiceMenuAdapter.a(ServiceMenuModel.this, this, helper, view, i);
            }
        });
    }
}
