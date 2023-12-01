package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.log.bytedance.CallEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.user.model.PayBeanDetail;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.views.PrivilegeDialogBuyOptionView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PrivilegeBuyDialogFragment.class */
public class PrivilegeBuyDialogFragment extends BaseFragment implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public Context f20206a;
    public View b;

    /* renamed from: c  reason: collision with root package name */
    public View f20207c;
    public LayoutInflater d;
    private ImageView f;
    private List<PrivilegeDialogBuyOptionView> g;
    private TextView h;
    private FrameLayout i;
    private List<PrivilegeBuyOptionForJsonParse.ProductBean> j;
    private Dialog k;
    private LinearLayout l;
    private LinearLayout m;
    private CheckBox n;
    private CheckBox o;
    private LinearLayout p;
    private ImageView q;
    private TextView r;
    private ShapeRelativeLayout s;
    private TextView t;
    private int u = 1;
    private int v = -1;
    public BluedUIHttpResponse e = new BluedUIHttpResponse<BluedEntityA<PrivilegeBuyOptionForJsonParse>>(PrivilegeBuyDialogFragment.class.getName(), getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.4
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUICache(BluedEntityA<PrivilegeBuyOptionForJsonParse> bluedEntityA) {
            super.onUICache(bluedEntityA);
            PrivilegeBuyDialogFragment.this.a(bluedEntityA);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public void onUIUpdate(BluedEntityA<PrivilegeBuyOptionForJsonParse> bluedEntityA) {
            PrivilegeBuyDialogFragment.this.a(bluedEntityA);
            if (3 == PrivilegeBuyDialogFragment.this.u) {
                PrivilegeBuyDialogFragment.this.b();
            }
        }

        public void onSuccess(String str) {
            super.onSuccess(str);
        }

        public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PrivilegeBuyDialogFragment.this.k);
        }

        public void onUIStart() {
            DialogUtils.a(PrivilegeBuyDialogFragment.this.k);
            super.onUIStart();
        }
    };
    private boolean w = true;

    public static void a(Context context, int i) {
        a(context, i, false);
    }

    public static void a(Context context, int i, String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("FROM_PAGE", i);
        bundle.putString("detail", str);
        TransparentActivity.a(bundle);
        if (BluedConfig.a().Q() != 1) {
            TransparentActivity.b(context, PrivilegeBuyDialogFragment.class, bundle);
        } else if (BluedConfig.a().R() == 1) {
            SuperPrivilegeBuyDialogFragment.b.a(context, i, str);
        } else {
            TransparentActivity.b(context, PrivilegeBuyDialogNewFragment.class, bundle);
        }
    }

    public static void a(Context context, int i, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("FROM_PAGE", i);
        if (z) {
            bundle.putBoolean("times", z);
        }
        TransparentActivity.a(bundle);
        if (BluedConfig.a().Q() != 1) {
            TransparentActivity.b(context, PrivilegeBuyDialogFragment.class, bundle);
        } else if (BluedConfig.a().R() != 1 || z) {
            TransparentActivity.b(context, PrivilegeBuyDialogNewFragment.class, bundle);
        } else {
            SuperPrivilegeBuyDialogFragment.b.a(context, i, "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CALL_BUY_OPEN, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.1
            /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
                if (r0.equals("mine_vocative_order") != false) goto L14;
             */
            /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onChanged(java.lang.Boolean r12) {
                /*
                    r11 = this;
                    r0 = r11
                    com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment r0 = com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.this
                    android.os.Bundle r0 = r0.getArguments()
                    r12 = r0
                    r0 = 0
                    r13 = r0
                    r0 = r12
                    if (r0 == 0) goto L92
                    r0 = r12
                    java.lang.String r1 = "FROM_PAGE"
                    int r0 = r0.getInt(r1)
                    r14 = r0
                    r0 = r12
                    java.lang.String r1 = "detail"
                    java.lang.String r0 = r0.getString(r1)
                    r12 = r0
                    r0 = r12
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L8d
                    r0 = r12
                    int r0 = r0.hashCode()
                    r15 = r0
                    r0 = r15
                    r1 = -235377960(0xfffffffff1f86ad8, float:-2.4602064E30)
                    if (r0 == r1) goto L5b
                    r0 = r15
                    r1 = 119794870(0x723ecb6, float:1.233232E-34)
                    if (r0 == r1) goto L4f
                    r0 = r15
                    r1 = 1536204444(0x5b909e9c, float:8.1413579E16)
                    if (r0 == r1) goto L41
                    goto L69
                L41:
                    r0 = r12
                    java.lang.String r1 = "vocative_end_report"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L69
                    r0 = 1
                    r13 = r0
                    goto L6b
                L4f:
                    r0 = r12
                    java.lang.String r1 = "mine_vocative_order"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L69
                    goto L6b
                L5b:
                    r0 = r12
                    java.lang.String r1 = "mine_vocative_order_is_remain"
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L69
                    r0 = 2
                    r13 = r0
                    goto L6b
                L69:
                    r0 = -1
                    r13 = r0
                L6b:
                    r0 = r13
                    if (r0 == 0) goto L87
                    r0 = r13
                    r1 = 1
                    if (r0 == r1) goto L82
                    r0 = r13
                    r1 = 2
                    if (r0 == r1) goto L7c
                    goto L8d
                L7c:
                    r0 = 12
                    r13 = r0
                    goto L94
                L82:
                    r0 = 5
                    r13 = r0
                    goto L94
                L87:
                    r0 = 6
                    r13 = r0
                    goto L94
                L8d:
                    r0 = r14
                    r13 = r0
                    goto L94
                L92:
                    r0 = 0
                    r13 = r0
                L94:
                    com.soft.blued.ui.find.manager.CallHelloManager r0 = com.soft.blued.ui.find.manager.CallHelloManager.a()
                    r1 = r11
                    com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment r1 = com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.this
                    android.content.Context r1 = r1.getContext()
                    r2 = r11
                    com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment r2 = com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.this
                    com.blued.android.core.ui.ActivityFragmentActive r2 = r2.getFragmentActive()
                    r3 = r13
                    r4 = 1
                    r5 = 0
                    com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment$1$1 r6 = new com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment$1$1
                    r7 = r6
                    r8 = r11
                    r9 = r13
                    r7.<init>()
                    r0.a(r1, r2, r3, r4, r5, r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.AnonymousClass1.onChanged(java.lang.Boolean):void");
            }
        });
    }

    private void e() {
        String string = this.f20206a.getString(R.string.hello_agree);
        String string2 = this.f20206a.getString(R.string.hello_service_agreement);
        String string3 = this.f20206a.getString(R.string.hello_and);
        String string4 = this.f20206a.getString(R.string.hello_spotlight_requirements);
        String str = string + string2 + string3 + string4;
        SpannableString spannableString = new SpannableString(str);
        this.r.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(PrivilegeBuyDialogFragment.this.getActivity(), H5Url.a(35), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(PrivilegeBuyDialogFragment.this.f20206a.getResources().getColor(2131101766));
                textPaint.setUnderlineText(false);
            }
        }, str.indexOf(string2), (string + string2).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewShowInfoFragment.show(PrivilegeBuyDialogFragment.this.getActivity(), H5Url.a(48), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(PrivilegeBuyDialogFragment.this.f20206a.getResources().getColor(2131101766));
                textPaint.setUnderlineText(false);
            }
        }, str.indexOf(string4), str.length(), 33);
        this.r.setText(spannableString);
    }

    private void f() {
        NormalPayTypeChoosePop.a(getContext(), new NormalPayTypeChoosePop.iChoosePayResultListener() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.6
            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a() {
            }

            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a(int i, boolean z) {
                PrivilegeBuyDialogFragment.this.u = i;
                PrivilegeBuyDialogFragment.this.g();
            }
        }, this.u, c().id, getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i = this.u;
        if (i == 1) {
            this.t.setText(getContext().getString(2131886386));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean : this.j) {
                productBean.showBeans = false;
            }
            this.h.setText(this.f20206a.getResources().getString(R.string.hello_buy));
        } else if (i == 2) {
            this.t.setText(getContext().getString(R.string.pay_type_wechat));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean2 : this.j) {
                productBean2.showBeans = false;
            }
            this.h.setText(this.f20206a.getResources().getString(R.string.hello_buy));
        } else if (i == 3) {
            this.t.setText(getContext().getString(R.string.pay_type_beans));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean3 : this.j) {
                productBean3.showBeans = true;
            }
            this.h.setText(String.format(this.f20206a.getResources().getString(R.string.pay_beans), c().total_beans + ""));
        } else if (i == 4) {
            this.t.setText(getContext().getString(R.string.pay_platform_huabei));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean4 : this.j) {
                productBean4.showBeans = false;
            }
            this.h.setText(this.f20206a.getResources().getString(R.string.hello_buy));
        }
        for (int i2 = 0; i2 < this.j.size(); i2++) {
            if (i2 < this.g.size()) {
                this.g.get(i2).setOptionView(this.j.get(i2));
            }
        }
    }

    private void h() {
        if (!this.w) {
            AppMethods.d((int) R.string.hello_bug_tips);
        } else if (this.v >= 0) {
            Bundle arguments = getArguments();
            String str = "home_page";
            if (arguments != null) {
                int i = arguments.getInt("FROM_PAGE");
                if (i == 1) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, GuyProtos.VocativeSourcePage.VOCATIVE_HOMEPAGE, c().id + "");
                } else if (i == 2) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, GuyProtos.VocativeSourcePage.VOCATIVE_MESSAGE, c().id + "");
                    CallEventUtils.a("VOCATIVE_MESSAGE", c().buy_num);
                    str = "vocative_msg";
                } else if (i == 3) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, GuyProtos.VocativeSourcePage.HOME_VOCATIVE_BTN, c().id + "");
                    CallEventUtils.a("HOME_VOCATIVE_BTN", c().buy_num);
                } else if (i == 4) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, GuyProtos.VocativeSourcePage.HOME_KEEP_ON, c().id + "");
                    CallEventUtils.a("HOME_KEEP_ON", c().buy_num);
                } else if (i == 7) {
                    str = "visit_page";
                } else if (i == 8) {
                    CallEventUtils.a("VOCATIVE_SECOND_PAGE", c().buy_num);
                    str = "vocative_second_page";
                } else if (i == 9) {
                    String string = arguments.getString("detail");
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, EventTrackGuy.a(string), c().id + "");
                    str = string;
                    if (!TextUtils.isEmpty(string)) {
                        boolean z = true;
                        int hashCode = string.hashCode();
                        if (hashCode != -235377960) {
                            if (hashCode != 119794870) {
                                if (hashCode == 1536204444 && string.equals("vocative_end_report")) {
                                    z = true;
                                }
                            } else if (string.equals("mine_vocative_order")) {
                                z = false;
                            }
                        } else if (string.equals("mine_vocative_order_is_remain")) {
                            z = true;
                        }
                        if (!z) {
                            CallEventUtils.a("ORDER_BUY", c().buy_num);
                            str = string;
                        } else if (z) {
                            CallEventUtils.a("REPORT_KEEP_ON", c().buy_num);
                            str = string;
                        } else if (!z) {
                            str = string;
                        } else {
                            CallEventUtils.a("ORDER_BUY_MORE", c().buy_num);
                            str = string;
                        }
                    }
                } else if (i == 11) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, GuyProtos.VocativeSourcePage.CALL_POP, c().id + "");
                    CallEventUtils.a("CALL_POP", c().buy_num);
                    str = "vocative_nearby_bubble";
                } else if (i == 13) {
                    EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK, GuyProtos.VocativeSourcePage.PUSH_CALL_TIME, c().id + "");
                    str = "push_call";
                }
                PayPreOrderFragment.a(getContext(), c(), null, "", null, null, str, this.u, 0, getFragmentActive());
            }
            str = "";
            PayPreOrderFragment.a(getContext(), c(), null, "", null, null, str, this.u, 0, getFragmentActive());
        }
    }

    public void a() {
        this.k = DialogUtils.a(this.f20206a);
        this.j = new ArrayList();
        this.g = new ArrayList();
        ImageView imageView = (ImageView) this.b.findViewById(R.id.img_close);
        this.f = imageView;
        imageView.setOnClickListener(this);
        this.i = (FrameLayout) this.b.findViewById(R.id.fl_top);
        PrivilegeDialogBuyOptionView privilegeDialogBuyOptionView = (PrivilegeDialogBuyOptionView) this.b.findViewById(R.id.view_option_1);
        privilegeDialogBuyOptionView.setOnClickListener(this);
        PrivilegeDialogBuyOptionView privilegeDialogBuyOptionView2 = (PrivilegeDialogBuyOptionView) this.b.findViewById(R.id.view_option_2);
        privilegeDialogBuyOptionView2.setOnClickListener(this);
        PrivilegeDialogBuyOptionView privilegeDialogBuyOptionView3 = (PrivilegeDialogBuyOptionView) this.b.findViewById(R.id.view_option_3);
        privilegeDialogBuyOptionView3.setOnClickListener(this);
        this.g.add(privilegeDialogBuyOptionView);
        this.g.add(privilegeDialogBuyOptionView2);
        this.g.add(privilegeDialogBuyOptionView3);
        TextView textView = (TextView) this.b.findViewById(R.id.tv_buy_privilege);
        this.h = textView;
        textView.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ll_wx_pay);
        this.l = linearLayout;
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.b.findViewById(R.id.ll_ali_pay);
        this.m = linearLayout2;
        linearLayout2.setOnClickListener(this);
        CheckBox checkBox = (CheckBox) this.b.findViewById(R.id.cb_wx_pay);
        this.n = checkBox;
        checkBox.setOnClickListener(this);
        CheckBox checkBox2 = (CheckBox) this.b.findViewById(R.id.cb_ali_pay);
        this.o = checkBox2;
        checkBox2.setOnClickListener(this);
        this.p = (LinearLayout) this.b.findViewById(R.id.agreement_layout);
        this.q = (ImageView) this.b.findViewById(R.id.agreement_btn);
        this.r = (TextView) this.b.findViewById(R.id.agreement_text);
        this.q.setOnClickListener(this);
        this.s = this.b.findViewById(R.id.rl_pay_type);
        this.t = (TextView) this.b.findViewById(R.id.tv_pay_type);
        this.s.setOnClickListener(this);
        if (BluedPreferences.bC() != 0) {
            this.u = BluedPreferences.bC();
        }
        g();
        this.e.refresh();
        e();
        PayHttpUtils.a(this.e, (IRequestHost) getFragmentActive(), "call");
    }

    public void a(int i) {
        int i2 = 0;
        if (i >= 0) {
            i2 = 0;
            if (i < this.j.size()) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.j.size()) {
                        break;
                    }
                    this.j.get(i4).choosen = false;
                    i3 = i4 + 1;
                }
                this.v = i;
                this.j.get(i).choosen = true;
                i2 = 0;
                if (this.u == 3) {
                    this.h.setText(String.format(this.f20206a.getResources().getString(R.string.pay_beans), this.j.get(i).total_beans + ""));
                    i2 = 0;
                }
            }
        }
        while (i2 < this.j.size()) {
            if (i2 < this.g.size()) {
                this.g.get(i2).setOptionView(this.j.get(i2));
            }
            i2++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
        if (r0.equals("mine_vocative_order") != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.a(int, boolean):void");
    }

    public void a(BluedEntityA<PrivilegeBuyOptionForJsonParse> bluedEntityA) {
        boolean z;
        if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || bluedEntityA.data.get(0) == null) {
            return;
        }
        List<PrivilegeBuyOptionForJsonParse.ProductBean> list = this.j;
        if (list != null) {
            list.clear();
        } else {
            this.j = new ArrayList();
        }
        this.j.addAll(((PrivilegeBuyOptionForJsonParse) bluedEntityA.getSingleData()).product);
        g();
        int i = 0;
        while (true) {
            int i2 = i;
            z = false;
            if (i2 >= this.j.size()) {
                break;
            } else if (this.j.get(i2).is_recommend == 1) {
                a(i2);
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (!z) {
            a(1);
        }
        PayPlatformDiscountModel._channel _channelVar = ((PrivilegeBuyOptionForJsonParse) bluedEntityA.getSingleData()).channel;
        if (_channelVar != null) {
            if (_channelVar.alipay != null && _channelVar.alipay.is_choose == 1) {
                this.u = 1;
            } else if (_channelVar.weixin != null && _channelVar.weixin.is_choose == 1) {
                this.u = 2;
            } else if (_channelVar.huabei != null && _channelVar.huabei.is_choose == 1) {
                this.u = 4;
            }
            g();
        }
    }

    public void b() {
        PayHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<PayBeanDetail>>(getFragmentActive()) { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment.5
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PayBeanDetail> bluedEntityA) {
                PayBeanDetail payBeanDetail;
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (payBeanDetail = (PayBeanDetail) bluedEntityA.data.get(0)) == null || payBeanDetail.is_support_beans != 1 || payBeanDetail.is_enough != 0) {
                    return;
                }
                PrivilegeBuyDialogFragment.this.u = 1;
                PrivilegeBuyDialogFragment.this.g();
            }

            public boolean onUIFailure(int i, String str) {
                return super.onUIFailure(i, str);
            }
        }, c().id);
    }

    public PrivilegeBuyOptionForJsonParse.ProductBean c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.j.size()) {
                return new PrivilegeBuyOptionForJsonParse.ProductBean();
            }
            if (this.j.get(i2).choosen) {
                return this.j.get(i2);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.agreement_btn /* 2131362004 */:
                if (this.w) {
                    this.q.setImageResource(R.drawable.hello_buy_default);
                    this.w = false;
                    return;
                }
                this.q.setImageResource(R.drawable.hello_buy_select);
                this.w = true;
                return;
            case R.id.cb_ali_pay /* 2131362756 */:
            case R.id.ll_ali_pay /* 2131367620 */:
                this.n.setChecked(false);
                this.o.setChecked(true);
                this.u = 1;
                return;
            case R.id.cb_wx_pay /* 2131362775 */:
            case R.id.ll_wx_pay /* 2131368367 */:
                this.n.setChecked(true);
                this.o.setChecked(false);
                this.u = 2;
                return;
            case R.id.img_close /* 2131364488 */:
                getActivity().finish();
                return;
            case R.id.rl_pay_type /* 2131369368 */:
                f();
                return;
            case R.id.tv_buy_privilege /* 2131371038 */:
                h();
                return;
            case R.id.view_option_1 /* 2131373203 */:
                List<PrivilegeBuyOptionForJsonParse.ProductBean> list = this.j;
                if (list == null || list.size() <= 0) {
                    return;
                }
                a(0);
                return;
            case R.id.view_option_2 /* 2131373204 */:
                List<PrivilegeBuyOptionForJsonParse.ProductBean> list2 = this.j;
                if (list2 == null || list2.size() <= 1) {
                    return;
                }
                a(1);
                return;
            case R.id.view_option_3 /* 2131373205 */:
                List<PrivilegeBuyOptionForJsonParse.ProductBean> list3 = this.j;
                if (list3 == null || list3.size() <= 2) {
                    return;
                }
                a(2);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        this.f20206a = activity;
        this.d = LayoutInflater.from(activity);
        if (this.b == null) {
            this.b = layoutInflater.inflate(R.layout.dialog_privilege_pay, viewGroup, false);
            a();
            d();
            StatusBarHelper.a(getActivity(), false);
            VIPBuyResultObserver.a().a(this, getLifecycle());
        }
        return this.b;
    }

    public void onDestroy() {
        super.onDestroy();
        ChatHttpUtils.a();
        Dialog dialog = this.k;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.k.dismiss();
    }
}
