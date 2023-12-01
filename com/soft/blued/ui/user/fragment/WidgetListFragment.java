package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/WidgetListFragment.class */
public class WidgetListFragment extends CustomSettingBaseFragment {
    public ShapeTextView k;
    public TextView l;
    private ImageView m;
    private TextView n;
    private ImageView o;
    private TextView p;
    private TextView q;

    public static void a(Context context, int i, String str, VipProtos.FromType fromType) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_VIP_GRADE", i);
        bundle.putString("KEY_VIP_DETAIL", str);
        bundle.putSerializable("KEY_VIP_FROM_TYPE", fromType);
        TerminalActivity.d(context, WidgetListFragment.class, bundle);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int a() {
        return 1;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void a(int i) {
        VipProtos.Event event = VipProtos.Event.PHOTO_PENDANT_PAGE_SAVE_CLICK;
        EventTrackVIP.a(event, i + "");
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void a(VIPCustomSettingBase vIPCustomSettingBase) {
        if (vIPCustomSettingBase == null) {
            return;
        }
        if (vIPCustomSettingBase.lastSelected) {
            this.l.setVisibility(8);
            this.k.setVisibility(8);
            if (vIPCustomSettingBase.is_termination == 1) {
                this.p.setVisibility(0);
                this.q.setVisibility(0);
                String b = TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + "");
                TextView textView = this.q;
                textView.setText(this.f33846a.getResources().getString(R.string.valid_time_period) + b);
            } else {
                this.p.setVisibility(8);
                this.q.setVisibility(8);
            }
        } else {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            if (vIPCustomSettingBase.isDefault) {
                if (h()) {
                    this.k.setText(R.string.restore_default);
                }
                this.k.setVisibility(0);
                this.l.setVisibility(8);
            } else {
                if (vIPCustomSettingBase.is_termination == 1) {
                    this.p.setVisibility(0);
                    this.l.setVisibility(0);
                    String b2 = TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + "");
                    TextView textView2 = this.l;
                    textView2.setText(this.f33846a.getResources().getString(R.string.valid_time_period) + b2);
                } else {
                    this.l.setVisibility(8);
                }
                if (h()) {
                    this.k.setText(R.string.customize_now);
                }
                this.k.setVisibility(0);
            }
        }
        this.n.setText(vIPCustomSettingBase.name);
        ImageLoader.a(getFragmentActive(), AvatarWidgetManager.a().a(vIPCustomSettingBase.id)).a(this.m);
        if (vIPCustomSettingBase.can_select == 0) {
            this.k.setEnabled(false);
            ShapeHelper.b(this.k, 2131102260);
            return;
        }
        this.k.setEnabled(true);
        ShapeHelper.b(this.k, 2131101766);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public String b() {
        return "pendant";
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void b(int i) {
        AppMethods.d((int) R.string.dynamic_skin_success);
        AvatarWidgetManager.a().b(i);
        this.l.setVisibility(8);
        this.k.setVisibility(8);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void b(VIPCustomSettingBase vIPCustomSettingBase) {
        this.n.setText(vIPCustomSettingBase.name);
        ImageLoader.a(getFragmentActive(), AvatarWidgetManager.a().a(vIPCustomSettingBase.id)).a(this.m);
        if (vIPCustomSettingBase.isDefault) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            if (h()) {
                return;
            }
            this.k.setVisibility(8);
        } else if (vIPCustomSettingBase.is_termination != 1) {
            this.p.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            String b = TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + "");
            TextView textView = this.q;
            textView.setText(this.f33846a.getResources().getString(R.string.valid_time_period) + b);
        }
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public String c() {
        return this.f33846a.getResources().getString(2131887375);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int d() {
        return 32;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public Drawable e() {
        return null;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int f() {
        return R.layout.fragment_vip_avatar_widget;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int g() {
        return R.layout.widget_skin_item;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k = (ShapeTextView) this.b.findViewById(R.id.tv_btm_btn);
        this.n = (TextView) this.b.findViewById(R.id.theme_name);
        this.m = (ImageView) this.b.findViewById(R.id.widget_view);
        this.o = (ImageView) this.b.findViewById(2131364232);
        this.l = (TextView) this.b.findViewById(R.id.valid_date);
        this.p = (TextView) this.b.findViewById(R.id.tv_time_limit);
        this.q = (TextView) this.b.findViewById(R.id.top_valid_date);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(1, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).d(2131237310).c().a(this.o);
        if (h()) {
            this.l.setVisibility(8);
            this.k.setVisibility(8);
        } else {
            this.l.setVisibility(8);
            this.k.setText(R.string.buy_vip_for_custom_setting);
        }
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.WidgetListFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (WidgetListFragment.this.h()) {
                    WidgetListFragment.this.j();
                    return;
                }
                EventTrackVIP.a(VipProtos.Event.PHOTO_PENDANT_PAGE_VIP_CLICK);
                WidgetListFragment.this.i();
            }
        });
    }
}
