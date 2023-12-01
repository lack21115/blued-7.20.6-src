package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.user.model.VIPCustomSettingBase;
import com.soft.blued.ui.user.model.VipBubbleModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipBubbleFragment.class */
public class VipBubbleFragment extends CustomSettingBaseFragment {
    private TextView k;
    private ImageView l;
    private View m;
    private ShapeTextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;

    public static void a(Context context, int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_VIP_GRADE", i);
        bundle.putString("KEY_VIP_DETAIL", str);
        TerminalActivity.a(bundle);
        TerminalActivity.b(bundle);
        TerminalActivity.d(context, VipBubbleFragment.class, bundle);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0043 -> B:5:0x001d). Please submit an issue!!! */
    private void c(final VIPCustomSettingBase vIPCustomSettingBase) {
        final VipBubbleModel b = VipBubbleManager.a().b(vIPCustomSettingBase.id);
        if (b == null) {
            VipBubbleManager.a().a(new VipBubbleManager.RefreshListener() { // from class: com.soft.blued.ui.user.fragment.VipBubbleFragment.2
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0037 -> B:3:0x0014). Please submit an issue!!! */
                @Override // com.soft.blued.ui.user.manager.VipBubbleManager.RefreshListener
                public void a() {
                    try {
                        VipBubbleFragment.this.p.setTextColor(Color.parseColor(b.text_color));
                    } catch (Throwable th) {
                    }
                    VipBubbleManager.a().b(VipBubbleManager.a().b(vIPCustomSettingBase.id), 1, VipBubbleFragment.this.m);
                }
            }, (IRequestHost) null);
            return;
        }
        try {
            this.p.setTextColor(Color.parseColor(b.text_color));
        } catch (Throwable th) {
        }
        VipBubbleManager.a().b(b, 1, this.m);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int a() {
        return 2;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void a(int i) {
        EventTrackMessage.a(MessageProtos.Event.MSG_BUBBLE_SAVE_CLICK, i);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void a(VIPCustomSettingBase vIPCustomSettingBase) {
        if (vIPCustomSettingBase == null) {
            return;
        }
        if (vIPCustomSettingBase.lastSelected) {
            this.o.setVisibility(8);
            this.n.setVisibility(8);
            if (vIPCustomSettingBase.is_termination == 1) {
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                String b = TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + "");
                TextView textView = this.r;
                textView.setText(this.f20155a.getResources().getString(R.string.valid_time_period) + b);
            } else {
                this.q.setVisibility(8);
                this.r.setVisibility(8);
            }
        } else {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            if (vIPCustomSettingBase.isDefault) {
                if (h()) {
                    this.n.setText((int) R.string.restore_default);
                }
                this.n.setVisibility(0);
                this.o.setVisibility(8);
            } else {
                if (vIPCustomSettingBase.is_termination == 1) {
                    this.q.setVisibility(0);
                    this.o.setVisibility(0);
                    String b2 = TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + "");
                    TextView textView2 = this.o;
                    textView2.setText(this.f20155a.getResources().getString(R.string.valid_time_period) + b2);
                } else {
                    this.o.setVisibility(8);
                }
                if (h()) {
                    this.n.setText((int) R.string.customize_now);
                }
                this.n.setVisibility(0);
            }
        }
        this.k.setText(vIPCustomSettingBase.name);
        if (vIPCustomSettingBase.isDefault) {
            this.p.setTextColor(BluedSkinUtils.a(this.f20155a, 2131101780));
            VipBubbleManager.a().a(0, 1, this.m);
        } else {
            c(vIPCustomSettingBase);
        }
        if (vIPCustomSettingBase.can_select == 0) {
            this.n.setEnabled(false);
            ShapeHelper.b(this.n, 2131102260);
            return;
        }
        this.n.setEnabled(true);
        ShapeHelper.b(this.n, 2131101766);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public String b() {
        return "message";
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void b(int i) {
        AppMethods.d((int) R.string.bubble_set_success);
        VipBubbleManager.a().a(i);
        this.o.setVisibility(8);
        this.n.setVisibility(8);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public void b(VIPCustomSettingBase vIPCustomSettingBase) {
        this.k.setText(vIPCustomSettingBase.name);
        if (vIPCustomSettingBase.isDefault) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            if (!h()) {
                this.n.setVisibility(8);
            }
            VipBubbleManager.a().a(0, 1, this.m);
            return;
        }
        c(vIPCustomSettingBase);
        if (vIPCustomSettingBase.is_termination != 1) {
            this.q.setVisibility(8);
            this.r.setVisibility(8);
            return;
        }
        this.q.setVisibility(0);
        this.r.setVisibility(0);
        String b = TimeAndDateUtils.b(vIPCustomSettingBase.stop_time + "");
        TextView textView = this.r;
        textView.setText(this.f20155a.getResources().getString(R.string.valid_time_period) + b);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public String c() {
        return this.f20155a.getResources().getString(R.string.vip_bubble);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int d() {
        return 30;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public Drawable e() {
        return this.f20155a.getResources().getDrawable(R.drawable.bubble_front_cover_default);
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int f() {
        return R.layout.fragment_vip_chat_bubble;
    }

    @Override // com.soft.blued.ui.user.fragment.CustomSettingBaseFragment
    public int g() {
        return R.layout.dynamic_skin_item;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k = (TextView) this.b.findViewById(R.id.theme_name);
        this.l = (ImageView) this.b.findViewById(2131364232);
        this.m = this.b.findViewById(R.id.msg_content_translate_root);
        this.n = this.b.findViewById(R.id.tv_btm_btn);
        this.o = (TextView) this.b.findViewById(R.id.valid_date);
        this.p = (TextView) this.b.findViewById(R.id.tv_message);
        this.q = (TextView) this.b.findViewById(R.id.tv_time_limit);
        this.r = (TextView) this.b.findViewById(R.id.top_valid_date);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(1, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).d(2131237310).c().a(this.l);
        if (h()) {
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.o.setVisibility(8);
            this.n.setText((int) R.string.buy_vip_for_custom_setting);
        }
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.VipBubbleFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Tracker.onClick(view2);
                if (VipBubbleFragment.this.h()) {
                    VipBubbleFragment.this.j();
                    return;
                }
                EventTrackMessage.a(MessageProtos.Event.MSG_BUBBLE_VIP_CLICK);
                VipBubbleFragment.this.i();
            }
        });
    }
}
