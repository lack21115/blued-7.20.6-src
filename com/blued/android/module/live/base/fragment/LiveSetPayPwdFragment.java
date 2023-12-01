package com.blued.android.module.live.base.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.anythink.china.activity.TransparentActivity;
import com.anythink.core.common.b.g;
import com.anythink.core.common.l;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.fragment.LiveBaseDialogFragment;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment;
import com.blued.android.module.live.base.model.BasePayRemaining;
import com.blued.android.module.live.base.utils.LiveBasePreferences;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jungly.gridpasswordview.GridPasswordView;
import com.jungly.gridpasswordview.imebugfixer.ImeDelBugFixedEditText;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/fragment/LiveSetPayPwdFragment.class */
public class LiveSetPayPwdFragment extends LiveBaseDialogFragment {
    private TextView j;
    private GridPasswordView k;
    private ImeDelBugFixedEditText l;
    private View m;
    private CheckBox n;
    private TextView o;
    private TextView p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private boolean u = true;
    private int v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/fragment/LiveSetPayPwdFragment$2.class */
    public class AnonymousClass2 implements GridPasswordView.OnPasswordChangedListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, View view) {
            LiveSetPayPwdFragment.this.a(str);
        }

        public void a(String str) {
            if (str.length() < 6) {
                LiveSetPayPwdFragment.this.j.setOnClickListener(null);
                LiveSetPayPwdFragment.this.j.setTextColor(Color.parseColor("#c0c0c0"));
            }
        }

        public void b(final String str) {
            LiveSetPayPwdFragment.this.j.setTextColor(Color.parseColor("#3494f4"));
            LiveSetPayPwdFragment.this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveSetPayPwdFragment$2$fIzLqDsYgCG3PxOiq_HUc1d20TM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveSetPayPwdFragment.AnonymousClass2.this.a(str, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (getTargetRequestCode() == 4221005 || getTargetRequestCode() == 4221004) {
            b(str);
        } else if (getTargetRequestCode() == 4221002) {
            c(str);
        }
    }

    private void b(String str) {
        String str2;
        try {
            str2 = BluedHttpTools.b(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            str2 = null;
        }
        this.c.putString("password", str2);
        this.c.putBoolean("remember_me", this.n.isChecked());
        Intent intent = new Intent();
        intent.putExtras(this.c);
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), -1, intent);
        }
        dismiss();
    }

    private void c(final String str) {
        String str2 = this.s + "/paymentcode/1";
        Map<String, String> a = BluedHttpTools.a();
        a.put("verify", this.n.isChecked() ? "1" : "0");
        a.put("type", "set");
        try {
            a.put(g.c.b, BluedHttpTools.b(str));
            String b = AesCrypto.b(AppInfo.f().toJson(a));
            Map<String, String> a2 = BluedHttpTools.a();
            a2.put(BridgeUtil.UNDERLINE_STR, b);
            HttpManager.b(str2, new BluedUIHttpResponse<BluedEntityA<BasePayRemaining>>(a()) { // from class: com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment.5
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<BasePayRemaining> bluedEntityA) {
                    if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                        AppMethods.d(R.string.get_user_info_fail);
                    } else if (!BluedHttpUtils.a(bluedEntityA.code, bluedEntityA.message)) {
                        AppMethods.d(R.string.get_user_info_fail);
                    } else {
                        try {
                            String c = AesCrypto.c(bluedEntityA.getSingleData().encrypted);
                            Logger.c("pwd", "dataStr = " + c);
                            LiveBasePreferences.b(((DecryptJson) AppInfo.f().fromJson(c, DecryptJson.class)).token);
                            if (LiveSetPayPwdFragment.this.getTargetFragment() != null) {
                                Intent intent = new Intent();
                                LiveSetPayPwdFragment.this.c.putBoolean("remember_me", LiveSetPayPwdFragment.this.n.isChecked());
                                try {
                                    LiveSetPayPwdFragment.this.c.putString("password", BluedHttpTools.b(str));
                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                }
                                intent.putExtras(LiveSetPayPwdFragment.this.c);
                                LiveSetPayPwdFragment.this.getTargetFragment().onActivityResult(LiveSetPayPwdFragment.this.getTargetRequestCode(), -1, intent);
                            }
                            LiveSetPayPwdFragment.this.dismiss();
                        } catch (Exception e2) {
                        }
                    }
                }
            }, a()).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.live_set_pay_pwd;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.j = (TextView) this.b.findViewById(R.id.tv_confirm);
        this.k = this.b.findViewById(R.id.gpv_customUi);
        ImeDelBugFixedEditText findViewById = this.b.findViewById(cn.blued.blued_third_library.R.id.inputView);
        this.l = findViewById;
        findViewById.setImeOptions(33554432);
        this.m = this.b.findViewById(R.id.vg_remember_check);
        this.n = (CheckBox) this.b.findViewById(R.id.cbx_need_next);
        this.o = (TextView) this.b.findViewById(R.id.tv_title);
        View findViewById2 = this.b.findViewById(R.id.tv_title_cutline);
        this.p = (TextView) this.b.findViewById(R.id.tv_msg);
        if (TextUtils.isEmpty(this.q)) {
            this.o.setVisibility(8);
            findViewById2.setVisibility(8);
        } else {
            this.o.setText(this.q);
            if (getTargetRequestCode() == 4221004) {
                this.o.setTextColor(getResources().getColor(R.color.biao_live_bug_gift_paycode_error));
            }
            this.o.setVisibility(0);
            findViewById2.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.r)) {
            this.p.setVisibility(8);
        } else {
            this.p.setText(this.r);
            this.p.setVisibility(0);
        }
        if (this.t) {
            this.k.setPasswordVisibility(true);
        } else {
            this.k.setPasswordVisibility(false);
        }
        if (this.u) {
            this.n.setChecked(true);
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
        this.b.findViewById(R.id.live_set_pay_pwd_layout_id).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (LiveSetPayPwdFragment.this.getTargetFragment() != null) {
                    LiveSetPayPwdFragment.this.getTargetFragment().onActivityResult(LiveSetPayPwdFragment.this.getTargetRequestCode(), 0, new Intent());
                }
                LiveSetPayPwdFragment.this.dismiss();
            }
        });
        this.b.findViewById(R.id.live_set_pay_pwd_content_layout_id).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live.base.fragment.-$$Lambda$LiveSetPayPwdFragment$iioVrutCDAzBBuHWp2lz7anfM5c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveSetPayPwdFragment.a(view);
            }
        });
        this.k.setOnPasswordChangedListener(new AnonymousClass2());
        this.j.setTextColor(Color.parseColor("#c0c0c0"));
        this.k.postDelayed(new Runnable() { // from class: com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment.3
            @Override // java.lang.Runnable
            public void run() {
                LiveSetPayPwdFragment.this.k.callOnClick();
            }
        }, 200L);
        LiveEventBus.get("live_pwd_fragment_close", String.class).observe(this, new Observer<String>() { // from class: com.blued.android.module.live.base.fragment.LiveSetPayPwdFragment.4
            /* renamed from: a */
            public void onChanged(String str) {
                if (LiveSetPayPwdFragment.this.getTargetFragment() != null) {
                    LiveSetPayPwdFragment.this.getTargetFragment().onActivityResult(LiveSetPayPwdFragment.this.getTargetRequestCode(), 0, new Intent());
                }
                LiveSetPayPwdFragment.this.dismiss();
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        this.q = this.c.getString("title");
        this.r = this.c.getString(l.y);
        this.t = this.c.getBoolean("pwd_visible");
        this.u = this.c.getBoolean("remember_check", true);
        this.v = this.c.getInt(TransparentActivity.b);
        this.s = this.c.getString("http_host");
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().setSoftInputMode(18);
        return onCreateDialog;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onDestroyView() {
        super.onDestroyView();
        LiveEventBus.get("inner_fragment_close").post("");
    }
}
