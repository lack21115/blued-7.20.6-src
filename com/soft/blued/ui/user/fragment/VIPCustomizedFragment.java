package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import butterknife.BindView;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.msg.ChatBgSettingFragment;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPCustomizedFragment.class */
public class VIPCustomizedFragment extends MvpFragment {

    /* renamed from: a  reason: collision with root package name */
    private Context f20456a;
    private int b = 0;
    @BindView
    CommonTopTitleNoTrans title;
    @BindView
    LabeledTextView viewAppIcon;
    @BindView
    LabeledTextView viewBubble;
    @BindView
    LabeledTextView viewChatBg;
    @BindView
    LabeledTextView viewFeedBg;
    @BindView
    LabeledTextView viewWidget;

    public static void a(Context context, int i) {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            PayUtils.a(context, i, null, 31, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_VIP_GRADE", i);
        TerminalActivity.d(context, VIPCustomizedFragment.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Tracker.onClick(view);
        ChangeBluedIconFragment.a(this.f20456a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        DynamicSkinFragment.a(this.f20456a, this.b, "vip_center_dynamic_skin");
        this.viewFeedBg.a((Boolean) false);
        BluedPreferences.dE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        Tracker.onClick(view);
        ChatBgSettingFragment.a(this.f20456a, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        VipBubbleFragment.a(this.f20456a, this.b, "vip_center_msg_bubble");
        this.viewBubble.a((Boolean) false);
        BluedPreferences.dy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        Tracker.onClick(view);
        getActivity().finish();
    }

    public void a(Bundle bundle) {
        super.a(bundle);
        if (getArguments() != null) {
            this.b = getArguments().getInt("KEY_VIP_GRADE");
        }
        this.f20456a = getActivity();
        this.title.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCustomizedFragment$jpcm2kPldpXFU6OsRuWJ08BcwYo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCustomizedFragment.this.e(view);
            }
        });
        if (!BluedPreferences.dx()) {
            this.viewBubble.a((Boolean) true);
        }
        this.viewBubble.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCustomizedFragment$fYDU87_awsTdC0OA5KECLLannu8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCustomizedFragment.this.d(view);
            }
        });
        this.viewChatBg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCustomizedFragment$xuGucGNgHGprH0cXan50R0QTftA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCustomizedFragment.this.c(view);
            }
        });
        if (!BluedPreferences.dD()) {
            this.viewFeedBg.a((Boolean) true);
        }
        this.viewFeedBg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCustomizedFragment$sffP6NjaRyiPD3f7S-Q2uluokEM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCustomizedFragment.this.b(view);
            }
        });
        this.viewAppIcon.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCustomizedFragment$prPT63xYl8d8Wkzwdw7zvulTwpo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCustomizedFragment.this.a(view);
            }
        });
        if (!BluedPreferences.dz()) {
            this.viewWidget.a((Boolean) true);
        }
        this.viewWidget.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VIPCustomizedFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackVIP.a(VipProtos.Event.VIP_CENTER_PHOTO_PENDANT_CLICK, VIPCustomizedFragment.this.b);
                VIPCustomizedFragment.this.viewWidget.a((Boolean) false);
                BluedPreferences.dA();
                WidgetListFragment.a(VIPCustomizedFragment.this.f20456a, 2, "photo_pendant_vip_center", VipProtos.FromType.PHOTO_PENDANT_VIP_CENTER);
            }
        });
    }

    public int g() {
        return R.layout.fragment_customized_look;
    }
}
