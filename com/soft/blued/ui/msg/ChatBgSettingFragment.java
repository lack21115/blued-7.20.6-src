package com.soft.blued.ui.msg;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.base.mvp.MVPBaseFragment;
import com.soft.blued.customview.LabeledTextView;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.msg.contract.IChatBgSettingIView;
import com.soft.blued.ui.msg.presenter.ChatBgSettingPresent;
import com.soft.blued.ui.user.presenter.PayUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/ChatBgSettingFragment.class */
public class ChatBgSettingFragment extends MVPBaseFragment<IChatBgSettingIView, ChatBgSettingPresent> implements View.OnClickListener, IChatBgSettingIView {
    private LabeledTextView j;
    private LabeledTextView k;
    private LabeledTextView l;
    private TextView m;
    private Dialog n;

    public static void a(Context context, int i) {
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            PayUtils.a(context, 1, null, 23, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        TerminalActivity.d(context, ChatBgSettingFragment.class, bundle);
    }

    public static void a(BaseFragment baseFragment, int i, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", i);
        TerminalActivity.a(baseFragment, ChatBgSettingFragment.class, bundle, i2);
    }

    public static void a(BaseFragment baseFragment, int i, long j, short s, int i2) {
        Bundle bundle = new Bundle();
        bundle.putLong("passby_session_id", j);
        bundle.putShort("passby_session_type", s);
        bundle.putInt("from", i);
        TerminalActivity.a(baseFragment, ChatBgSettingFragment.class, bundle, i2);
    }

    private void k() {
        Dialog dialog = this.n;
        if (dialog == null) {
            this.n = CommonAlertDialog.a(getContext(), getString(R.string.sure_setting_set_all_default_bg), (String) null, getString(2131887281), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatBgSettingFragment.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    if (ChatBgSettingFragment.this.f14603a != null) {
                        ((ChatBgSettingPresent) ChatBgSettingFragment.this.f14603a).g();
                    }
                }
            }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        } else {
            dialog.show();
        }
    }

    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    public boolean a(Bundle bundle) {
        return false;
    }

    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    public void b(Bundle bundle) {
        this.f.setCenterText((int) R.string.biao_v4_chat_setting_select_bg);
        this.f.a();
        this.f.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.ChatBgSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ChatBgSettingFragment.this.getActivity().finish();
            }
        });
        this.j = (LabeledTextView) this.f14604c.findViewById(R.id.chat_setting_select_bg);
        this.k = (LabeledTextView) this.f14604c.findViewById(R.id.chat_setting_select_picture);
        this.l = (LabeledTextView) this.f14604c.findViewById(R.id.chat_setting_take_photo);
        this.m = (TextView) this.f14604c.findViewById(R.id.chat_setting_set_default);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.m.setVisibility(8);
    }

    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    public void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.soft.blued.base.mvp.MVPBaseFragment
    /* renamed from: h */
    public ChatBgSettingPresent e() {
        return new ChatBgSettingPresent();
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSettingIView
    public BaseFragment i() {
        return this;
    }

    @Override // com.soft.blued.ui.msg.contract.IChatBgSettingIView
    public void j() {
        TextView textView = this.m;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.f14603a != 0) {
            switch (view.getId()) {
                case R.id.chat_setting_select_bg /* 2131362831 */:
                    InstantLog.b("set_chat_bg_option_click", 0);
                    ((ChatBgSettingPresent) this.f14603a).d();
                    return;
                case R.id.chat_setting_select_picture /* 2131362832 */:
                    InstantLog.b("set_chat_bg_option_click", 1);
                    PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.ChatBgSettingFragment.3
                        public void U_() {
                            ((ChatBgSettingPresent) ChatBgSettingFragment.this.f14603a).e();
                        }

                        public void a(String[] strArr) {
                        }
                    });
                    return;
                case R.id.chat_setting_set_default /* 2131362833 */:
                    k();
                    return;
                case R.id.chat_setting_take_photo /* 2131362834 */:
                    InstantLog.b("set_chat_bg_option_click", 2);
                    PermissionUtils.b(new PermissionCallbacks() { // from class: com.soft.blued.ui.msg.ChatBgSettingFragment.4
                        public void U_() {
                            ((ChatBgSettingPresent) ChatBgSettingFragment.this.f14603a).f();
                        }

                        public void a(String[] strArr) {
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.a(R.layout.fragment_chat_bg_setting, layoutInflater, viewGroup, bundle);
    }
}
