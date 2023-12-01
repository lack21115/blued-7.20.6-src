package com.soft.blued.ui.user.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.user.fragment.DynamicSkinFragment;
import com.soft.blued.ui.user.fragment.VipBubbleFragment;
import com.soft.blued.ui.user.fragment.VipInvisibleDialogFragment;
import com.soft.blued.ui.user.fragment.WidgetListFragment;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/adapter/VIPCenterVIPRightHoriAdapter.class */
public class VIPCenterVIPRightHoriAdapter extends BaseQuickAdapter<VIPRightOption, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public IRequestHost f33792a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    FragmentManager f33793c;
    private VipInvisibleDialogFragment d;

    public VIPCenterVIPRightHoriAdapter(IRequestHost iRequestHost, List<VIPRightOption> list, int i, FragmentManager fragmentManager) {
        super(R.layout.item_vip_center_hori_right_desc, list);
        this.f33792a = iRequestHost;
        this.b = i;
        this.f33793c = fragmentManager;
        this.d = new VipInvisibleDialogFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ImageView imageView, View view) {
        Tracker.onClick(view);
        imageView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(VIPRightOption vIPRightOption, View view) {
        Tracker.onClick(view);
        EventTrackVIP.a(UserInfo.getInstance().getLoginUserInfo().vip_grade, this.b, false, vIPRightOption.pid);
        int i = vIPRightOption.pid;
        if (i == 4) {
            if (this.d.isAdded()) {
                this.d.dismiss();
            } else {
                this.d.show(this.f33793c, VIPCenterVIPRightHoriAdapter.class.getName());
            }
            BluedPreferences.dU();
            notifyDataSetChanged();
        } else if (i == 14) {
            ChangeBluedIconFragment.a(this.mContext, this.b);
        } else if (i == 36) {
            WebViewShowInfoFragment.show(this.mContext, BluedHttpUrl.a(vIPRightOption.pid, "", this.b, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
            BluedPreferences.dW();
            notifyDataSetChanged();
        } else {
            switch (i) {
                case 28:
                    BluedURIRouterAdapter.goChatAndOpenMsgBox(this.f33793c, this.b);
                    return;
                case 29:
                    BluedPreferences.dO();
                    DynamicSkinFragment.a(this.mContext, this.b, "vip_center_dynamic_skin");
                    notifyDataSetChanged();
                    return;
                case 30:
                    BluedPreferences.dM();
                    VipBubbleFragment.a(this.mContext, this.b, "vip_center_msg_bubble");
                    notifyDataSetChanged();
                    return;
                default:
                    switch (i) {
                        case 32:
                            EventTrackVIP.a(VipProtos.Event.VIP_CENTER_PHOTO_PENDANT_CLICK, this.b);
                            BluedPreferences.dQ();
                            WidgetListFragment.a(this.mContext, this.b, "photo_pendant_vip_center", VipProtos.FromType.PHOTO_PENDANT_VIP_CENTER);
                            notifyDataSetChanged();
                            return;
                        case 33:
                            if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                                PayUtils.a(this.mContext, "flash_photo", 33, VipProtos.FromType.UNKNOWN_FROM);
                                return;
                            }
                            return;
                        case 34:
                            BluedPreferences.dS();
                            WebViewShowInfoFragment.show(this.mContext, BluedHttpUrl.a(vIPRightOption.pid, "groups_expand_vip", this.b, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
                            notifyDataSetChanged();
                            return;
                        default:
                            WebViewShowInfoFragment.show(this.mContext, BluedHttpUrl.a(vIPRightOption.pid, "", this.b, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
                            return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final VIPRightOption vIPRightOption) {
        if (baseViewHolder == null || vIPRightOption == null) {
            return;
        }
        final ImageView imageView = (ImageView) baseViewHolder.getView(2131364496);
        TextView textView = (TextView) baseViewHolder.getView(2131372046);
        View view = baseViewHolder.getView(R.id.view_red_dot);
        View view2 = baseViewHolder.getView(R.id.img_svip);
        if (vIPRightOption.is_svip == 1) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        if (vIPRightOption.pid == 30 && !BluedPreferences.dL()) {
            view.setVisibility(0);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 71.0f));
        } else if (vIPRightOption.pid == 29 && !BluedPreferences.dN()) {
            view.setVisibility(0);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 71.0f));
        } else if (vIPRightOption.pid == 32 && !BluedPreferences.dP()) {
            view.setVisibility(0);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 71.0f));
        } else if (vIPRightOption.pid == 34 && !BluedPreferences.dR()) {
            view.setVisibility(0);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 71.0f));
        } else if (vIPRightOption.pid == 4 && !BluedPreferences.dT()) {
            view.setVisibility(0);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 71.0f));
        } else if (vIPRightOption.pid != 36 || BluedPreferences.dV()) {
            view.setVisibility(8);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 80.0f));
        } else {
            view.setVisibility(0);
            textView.setMaxWidth(DensityUtils.a(this.mContext, 71.0f));
        }
        ImageLoader.a(this.f33792a, vIPRightOption.icon).a(imageView);
        if (StringUtils.d(vIPRightOption.title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(vIPRightOption.title);
            textView.setVisibility(0);
        }
        if (vIPRightOption.pid == 4) {
            this.d.b = vIPRightOption.title;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPCenterVIPRightHoriAdapter$RVZbtzVzURr1K54gvIUJf-PklxM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                VIPCenterVIPRightHoriAdapter.this.a(vIPRightOption, view3);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.adapter.-$$Lambda$VIPCenterVIPRightHoriAdapter$IWZ0CEvv-pcfCkxcyU8ZpzsYPnI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                VIPCenterVIPRightHoriAdapter.a(ImageView.this, view3);
            }
        });
    }
}
