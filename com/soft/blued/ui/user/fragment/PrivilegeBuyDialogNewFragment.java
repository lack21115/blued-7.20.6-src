package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.H5Url;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.databinding.DialogPrivilegePayNewBinding;
import com.soft.blued.log.bytedance.CallEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.state.PrivilegeBuyState;
import com.soft.blued.ui.user.viewmodel.PrivilegeBuyDialogNewVM;
import com.soft.blued.ui.user.views.PrivilegeDialogBuyNewOptionView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PrivilegeBuyDialogNewFragment.class */
public final class PrivilegeBuyDialogNewFragment extends MVIBaseFragment<PrivilegeBuyDialogNewVM> implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
    private final ViewBindingProperty d;
    private List<PrivilegeBuyOptionForJsonParse.ProductBean> e;
    private List<PrivilegeDialogBuyNewOptionView> f;
    private boolean g;
    private int h;
    private int i;
    private boolean j;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f33907c = {Reflection.a(new PropertyReference1Impl(PrivilegeBuyDialogNewFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/DialogPrivilegePayNewBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/PrivilegeBuyDialogNewFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PrivilegeBuyDialogNewFragment() {
        super(R.layout.dialog_privilege_pay_new);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<PrivilegeBuyDialogNewFragment, DialogPrivilegePayNewBinding>() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogPrivilegePayNewBinding invoke(PrivilegeBuyDialogNewFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogPrivilegePayNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<PrivilegeBuyDialogNewFragment, DialogPrivilegePayNewBinding>() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogPrivilegePayNewBinding invoke(PrivilegeBuyDialogNewFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogPrivilegePayNewBinding.a(fragment.requireView());
            }
        });
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = true;
        this.h = 1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, PrivilegeBuyDialogNewFragment this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z && HomeActivity.f30985c != null) {
            CallHelloManager.a().a((Context) HomeActivity.f30985c, (IRequestHost) null, false, i);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final PrivilegeBuyDialogNewFragment this$0, Boolean bool) {
        int i;
        Intrinsics.e(this$0, "this$0");
        Bundle arguments = this$0.getArguments();
        if (arguments != null) {
            i = arguments.getInt("FROM_PAGE");
            String string = arguments.getString("detail");
            if (!TextUtils.isEmpty(string) && string != null) {
                int hashCode = string.hashCode();
                if (hashCode != -235377960) {
                    if (hashCode != 119794870) {
                        if (hashCode == 1536204444 && string.equals("vocative_end_report")) {
                            i = 5;
                        }
                    } else if (string.equals("mine_vocative_order")) {
                        i = 6;
                    }
                } else if (string.equals("mine_vocative_order_is_remain")) {
                    i = 12;
                }
            }
        } else {
            i = 0;
        }
        final int i2 = i;
        CallHelloManager.a().a(this$0.getContext(), this$0.getFragmentActive(), i, true, true, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PrivilegeBuyDialogNewFragment$k3PgAWF-1DWrT5IJFCJILMCf_20
            @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
            public final void done(boolean z) {
                PrivilegeBuyDialogNewFragment.a(i2, this$0, z);
            }
        });
    }

    private final void a(PrivilegeBuyOptionForJsonParse.ProductBean productBean) {
        Context context;
        DialogPrivilegePayNewBinding a2 = a();
        if (a2 == null || (context = getContext()) == null) {
            return;
        }
        if (productBean.choosen) {
            a2.t.setVisibility(8);
            ShapeHelper.b(a2.i, 2131102360);
            ShapeHelper.d(a2.i, 2131102222);
            a2.p.setPadding(0, DensityUtils.a(context, 10.0f), 0, 0);
            a2.p.setTextColor(context.getResources().getColor(2131102222));
            a2.q.setTextColor(context.getResources().getColor(2131102222));
            a2.s.setTextColor(context.getResources().getColor(2131102222));
            if (StringUtils.d(productBean.discount)) {
                a2.r.setVisibility(4);
            } else {
                a2.r.setVisibility(0);
                a2.r.setText(productBean.discount);
            }
            this.h = 1;
            d();
        } else {
            a2.t.setVisibility(0);
            ShapeHelper.b(a2.i, 2131102360);
            ShapeHelper.d(a2.i, 2131102360);
            a2.p.setPadding(0, DensityUtils.a(context, 20.0f), 0, 0);
            a2.p.setTextColor(context.getResources().getColor(2131102203));
            a2.q.setTextColor(context.getResources().getColor(2131102203));
            a2.s.setTextColor(context.getResources().getColor(2131102205));
            a2.r.setVisibility(8);
        }
        if (productBean.discount_price > 0.0f) {
            TextView textView = a2.s;
            StringBuilder sb = new StringBuilder();
            sb.append((char) 65509);
            sb.append((Object) StringUtils.a(productBean.discount_price + ""));
            sb.append('/');
            sb.append((Object) productBean.unit);
            textView.setText(sb.toString());
        } else {
            TextView textView2 = a2.s;
            StringBuilder sb2 = new StringBuilder();
            sb2.append((char) 65509);
            sb2.append((Object) StringUtils.a(productBean.average_price + ""));
            sb2.append('/');
            sb2.append((Object) productBean.unit);
            textView2.setText(sb2.toString());
        }
        a2.p.setText(String.valueOf(productBean.buy_num));
        a2.q.setText(productBean.unit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i, PrivilegeBuyDialogNewFragment this$0, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z && HomeActivity.f30985c != null) {
            CallHelloManager.a().a((Context) HomeActivity.f30985c, (IRequestHost) null, false, i);
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void c() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CALL_BUY_OPEN, Boolean.TYPE).observe(this, new Observer() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PrivilegeBuyDialogNewFragment$RPPR5qZSN5leuS-rnXV0USK616o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PrivilegeBuyDialogNewFragment.a(PrivilegeBuyDialogNewFragment.this, (Boolean) obj);
            }
        });
    }

    private final void c(int i) {
        final Context context;
        DialogPrivilegePayNewBinding a2 = a();
        if (a2 == null || (context = getContext()) == null) {
            return;
        }
        String string = context.getString(R.string.hello_agree_new);
        Intrinsics.c(string, "mContext.getString(R.string.hello_agree_new)");
        String string2 = context.getString(R.string.hello_service_agreement_new);
        Intrinsics.c(string2, "mContext.getString(R.str…lo_service_agreement_new)");
        String string3 = context.getString(R.string.hello_stop_interval);
        Intrinsics.c(string3, "mContext.getString(R.string.hello_stop_interval)");
        String string4 = context.getString(R.string.hello_spotlight_requirements_new);
        Intrinsics.c(string4, "mContext.getString(R.str…otlight_requirements_new)");
        String string5 = context.getString(R.string.hello_subscribe);
        Intrinsics.c(string5, "mContext.getString(R.string.hello_subscribe)");
        String str = string + string2 + string3 + string4;
        if (i == 3) {
            str = string + string2 + string3 + string5 + string3 + string4;
        }
        String str2 = str;
        SpannableString spannableString = new SpannableString(str2);
        a2.f28717c.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$setAgreement$1$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(PrivilegeBuyDialogNewFragment.this.getActivity(), H5Url.a(35), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(ContextCompat.getColor(context, 2131101766));
                ds.setUnderlineText(false);
            }
        }, StringsKt.a((CharSequence) str2, string2, 0, false, 6, (Object) null), Intrinsics.a(string, (Object) string2).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$setAgreement$1$1$2
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(PrivilegeBuyDialogNewFragment.this.getActivity(), H5Url.a(48), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(ContextCompat.getColor(context, 2131101766));
                ds.setUnderlineText(false);
            }
        }, StringsKt.a((CharSequence) str2, string4, 0, false, 6, (Object) null), str.length(), 33);
        if (i == 3) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$setAgreement$1$1$3
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.e(widget, "widget");
                    WebViewShowInfoFragment.show(PrivilegeBuyDialogNewFragment.this.getActivity(), H5Url.a(34), 7);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.e(ds, "ds");
                    ds.setColor(ContextCompat.getColor(context, 2131101766));
                    ds.setUnderlineText(false);
                }
            }, StringsKt.a((CharSequence) str2, string5, 0, false, 6, (Object) null), (string + string2 + string3 + string5).length(), 33);
        }
        a2.f28717c.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        DialogPrivilegePayNewBinding a2;
        if (this.e == null || (a2 = a()) == null) {
            return;
        }
        int i = this.h;
        if (i == 1) {
            TextView textView = a2.u;
            Context context = getContext();
            textView.setText(context == null ? null : context.getString(2131886386));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean : this.e) {
                productBean.showBeans = false;
            }
            TextView textView2 = a2.n;
            Context context2 = getContext();
            textView2.setText(context2 == null ? null : context2.getString(R.string.hello_buy));
        } else if (i == 2) {
            TextView textView3 = a2.u;
            Context context3 = getContext();
            textView3.setText(context3 == null ? null : context3.getString(R.string.pay_type_wechat));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean2 : this.e) {
                productBean2.showBeans = false;
            }
            TextView textView4 = a2.n;
            Context context4 = getContext();
            textView4.setText(context4 == null ? null : context4.getString(R.string.hello_buy));
        } else if (i == 3) {
            TextView textView5 = a2.u;
            Context context5 = getContext();
            textView5.setText(context5 != null ? context5.getString(R.string.pay_type_beans) : null);
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean3 : this.e) {
                productBean3.showBeans = false;
            }
            Context context6 = getContext();
            if (context6 != null) {
                TextView textView6 = a2.n;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = context6.getResources().getString(R.string.pay_beans);
                Intrinsics.c(string, "context.getResources().g…tring(R.string.pay_beans)");
                String format = String.format(string, Arrays.copyOf(new Object[]{b().total_beans + ""}, 1));
                Intrinsics.c(format, "format(format, *args)");
                textView6.setText(format);
            }
        } else if (i == 4) {
            TextView textView7 = a2.u;
            Context context7 = getContext();
            textView7.setText(context7 == null ? null : context7.getString(R.string.pay_platform_huabei));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean4 : this.e) {
                productBean4.showBeans = false;
            }
            TextView textView8 = a2.n;
            Context context8 = getContext();
            textView8.setText(context8 == null ? null : context8.getString(R.string.hello_buy));
        }
        List<PrivilegeDialogBuyNewOptionView> list = this.f;
        if (list != null ? list.isEmpty() : true) {
            return;
        }
        int size = this.e.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            if (i3 < this.f.size()) {
                this.f.get(i3).setOptionView(this.e.get(i3));
            }
            i2 = i3 + 1;
        }
    }

    private final void e() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (b().is_signed == 1) {
            if (this.j) {
                DialogPrivilegePayNewBinding a2 = a();
                if (a2 == null || (imageView3 = a2.f28716a) == null) {
                    return;
                }
                imageView3.setImageResource(R.drawable.icon_selected);
                return;
            }
            DialogPrivilegePayNewBinding a3 = a();
            if (a3 == null || (imageView4 = a3.f28716a) == null) {
                return;
            }
            imageView4.setImageResource(R.drawable.icon_unselect);
        } else if (this.g) {
            DialogPrivilegePayNewBinding a4 = a();
            if (a4 == null || (imageView = a4.f28716a) == null) {
                return;
            }
            imageView.setImageResource(R.drawable.icon_selected);
        } else {
            DialogPrivilegePayNewBinding a5 = a();
            if (a5 == null || (imageView2 = a5.f28716a) == null) {
                return;
            }
            imageView2.setImageResource(R.drawable.icon_unselect);
        }
    }

    private final void f() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        NormalPayTypeChoosePop.a(context, new NormalPayTypeChoosePop.iChoosePayResultListener() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$selectPayType$1$1
            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a() {
            }

            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a(int i, boolean z) {
                PrivilegeBuyDialogNewFragment.this.h = i;
                PrivilegeBuyDialogNewFragment.this.d();
            }
        }, this.h, b().id, getFragmentActive());
    }

    private final void g() {
        String str;
        if (!this.j && b().is_signed == 1) {
            AppMethods.d((int) R.string.hello_bug_tips);
        } else if (!this.g) {
            AppMethods.d((int) R.string.hello_bug_tips);
        } else if (this.i >= 0) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                int i = arguments.getInt("FROM_PAGE");
                if (i == 1) {
                    GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage = GuyProtos.VocativeSourcePage.CALL_MORE_TIMES;
                    EventTrackGuy.a(event, vocativeSourcePage, b().id + "");
                } else if (i == 2) {
                    GuyProtos.Event event2 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage2 = GuyProtos.VocativeSourcePage.CALL_MORE_TIMES;
                    EventTrackGuy.a(event2, vocativeSourcePage2, b().id + "");
                    CallEventUtils.a("VOCATIVE_MESSAGE", b().buy_num);
                } else if (i == 3) {
                    GuyProtos.Event event3 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage3 = GuyProtos.VocativeSourcePage.CALL_MORE_TIMES;
                    EventTrackGuy.a(event3, vocativeSourcePage3, b().id + "");
                    CallEventUtils.a("HOME_VOCATIVE_BTN", b().buy_num);
                } else if (i == 4) {
                    GuyProtos.Event event4 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage4 = GuyProtos.VocativeSourcePage.CALL_MORE_TIMES;
                    EventTrackGuy.a(event4, vocativeSourcePage4, b().id + "");
                    CallEventUtils.a("HOME_KEEP_ON", b().buy_num);
                } else if (i == 8) {
                    CallEventUtils.a("VOCATIVE_SECOND_PAGE", b().buy_num);
                } else if (i == 9) {
                    String valueOf = String.valueOf(arguments.getString("detail"));
                    GuyProtos.Event event5 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage5 = GuyProtos.VocativeSourcePage.CALL_MORE_TIMES;
                    EventTrackGuy.a(event5, vocativeSourcePage5, b().id + "");
                    str = valueOf;
                    if (!TextUtils.isEmpty(valueOf)) {
                        int hashCode = valueOf.hashCode();
                        if (hashCode != -235377960) {
                            if (hashCode != 119794870) {
                                if (hashCode != 1536204444) {
                                    str = valueOf;
                                } else if (valueOf.equals("vocative_end_report")) {
                                    CallEventUtils.a("REPORT_KEEP_ON", b().buy_num);
                                    str = valueOf;
                                } else {
                                    str = valueOf;
                                }
                            } else if (valueOf.equals("mine_vocative_order")) {
                                CallEventUtils.a("ORDER_BUY", b().buy_num);
                                str = valueOf;
                            } else {
                                str = valueOf;
                            }
                        } else if (valueOf.equals("mine_vocative_order_is_remain")) {
                            CallEventUtils.a("ORDER_BUY_MORE", b().buy_num);
                            str = valueOf;
                        } else {
                            str = valueOf;
                        }
                    }
                    PayPreOrderFragment.a(getContext(), b(), null, "", null, null, str, this.h, 0, getFragmentActive());
                } else if (i == 11) {
                    GuyProtos.Event event6 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage6 = GuyProtos.VocativeSourcePage.CALL_MORE_TIMES;
                    EventTrackGuy.a(event6, vocativeSourcePage6, b().id + "");
                    CallEventUtils.a("CALL_POP", b().buy_num);
                }
            }
            str = "call_more_times";
            PayPreOrderFragment.a(getContext(), b(), null, "", null, null, str, this.h, 0, getFragmentActive());
        }
    }

    public final DialogPrivilegePayNewBinding a() {
        return (DialogPrivilegePayNewBinding) this.d.b(this, f33907c[0]);
    }

    public final void a(int i) {
        Context context;
        if (i >= 0 && i < this.e.size()) {
            int size = this.e.size();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                this.e.get(i3).choosen = false;
                i2 = i3 + 1;
            }
            this.i = i;
            this.e.get(i).choosen = true;
            if (this.h == 3 && (context = getContext()) != null) {
                DialogPrivilegePayNewBinding a2 = a();
                TextView textView = a2 == null ? null : a2.n;
                if (textView != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string = context.getResources().getString(R.string.pay_beans);
                    Intrinsics.c(string, "context.resources.getString(R.string.pay_beans)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{this.e.get(i).total_beans + ""}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    textView.setText(format);
                }
            }
        }
        int size2 = this.e.size();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size2) {
                e();
                b(i);
                c(i);
                return;
            }
            if (i5 < this.f.size()) {
                this.f.get(i5).setOptionView(this.e.get(i5));
            } else {
                a(this.e.get(i5));
            }
            i4 = i5 + 1;
        }
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        int i2;
        if (z) {
            BluedPreferences.n(this.h);
            DialogPrivilegePayNewBinding a2 = a();
            FrameLayout frameLayout = a2 == null ? null : a2.m;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            Bundle arguments = getArguments();
            if (arguments != null) {
                i2 = arguments.getInt("FROM_PAGE");
                String string = arguments.getString("detail");
                if (!TextUtils.isEmpty(string) && string != null) {
                    int hashCode = string.hashCode();
                    if (hashCode != -235377960) {
                        if (hashCode != 119794870) {
                            if (hashCode == 1536204444 && string.equals("vocative_end_report")) {
                                i2 = 5;
                            }
                        } else if (string.equals("mine_vocative_order")) {
                            i2 = 6;
                        }
                    } else if (string.equals("mine_vocative_order_is_remain")) {
                        i2 = 12;
                    }
                }
            } else {
                i2 = 0;
            }
            final int i3 = i2;
            CallHelloManager.a().a(getContext(), getFragmentActive(), i2, true, true, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$PrivilegeBuyDialogNewFragment$SYBXFDKMkHh4BfMblN3443zvz5s
                @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                public final void done(boolean z2) {
                    PrivilegeBuyDialogNewFragment.b(i3, this, z2);
                }
            });
        }
    }

    public final void a(PrivilegeBuyOptionForJsonParse parseData) {
        boolean z;
        Intrinsics.e(parseData, "parseData");
        if (parseData.product != null) {
            this.e = new ArrayList();
            List<PrivilegeBuyOptionForJsonParse.ProductBean> list = parseData.product;
            Intrinsics.c(list, "parseData.product");
            this.e = list;
            d();
            Iterator<PrivilegeBuyOptionForJsonParse.ProductBean> it = this.e.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                PrivilegeBuyOptionForJsonParse.ProductBean next = it.next();
                if (next.is_recommend == 1) {
                    a(this.e.indexOf(next));
                    z = true;
                    break;
                }
            }
            if (!z) {
                a(1);
            }
            PayPlatformDiscountModel._channel _channelVar = parseData.channel;
            if (_channelVar != null) {
                if (_channelVar.alipay != null && _channelVar.alipay.is_choose == 1) {
                    this.h = 1;
                } else if (_channelVar.weixin != null && _channelVar.weixin.is_choose == 1) {
                    this.h = 2;
                } else if (_channelVar.huabei != null && _channelVar.huabei.is_choose == 1) {
                    this.h = 4;
                }
                d();
            }
        }
    }

    public final PrivilegeBuyOptionForJsonParse.ProductBean b() {
        List<PrivilegeBuyOptionForJsonParse.ProductBean> list = this.e;
        if (list == null || list.isEmpty()) {
            return new PrivilegeBuyOptionForJsonParse.ProductBean();
        }
        int size = this.e.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return new PrivilegeBuyOptionForJsonParse.ProductBean();
            }
            if (this.e.get(i2).choosen) {
                if (this.e.get(i2).is_signed == 1) {
                    this.e.get(i2).alipay_contract = 1;
                    this.e.get(i2).wx_contract = 1;
                }
                return this.e.get(i2);
            }
            i = i2 + 1;
        }
    }

    public final void b(int i) {
        Context context;
        DialogPrivilegePayNewBinding a2 = a();
        if (a2 == null || (context = getContext()) == null) {
            return;
        }
        String string = context.getString(R.string.hello_user_time);
        Intrinsics.c(string, "mContext.getString(R.string.hello_user_time)");
        if (i == 3) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string2 = context.getString(R.string.hello_user_mouth_card_time);
            Intrinsics.c(string2, "mContext.getString(R.str…llo_user_mouth_card_time)");
            string = String.format(string2, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Double.valueOf(b().total_price))}, 1));
            Intrinsics.c(string, "format(format, *args)");
        }
        a2.o.setText(string);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((PrivilegeBuyState) obj).getGoodsListData();
            }
        }, new Function1<PrivilegeBuyOptionForJsonParse, Unit>() { // from class: com.soft.blued.ui.user.fragment.PrivilegeBuyDialogNewFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(PrivilegeBuyOptionForJsonParse it) {
                Intrinsics.e(it, "it");
                PrivilegeBuyDialogNewFragment.this.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse) {
                a(privilegeBuyOptionForJsonParse);
                return Unit.f42314a;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Intrinsics.e(view, "view");
        switch (view.getId()) {
            case R.id.agreement_btn /* 2131362004 */:
                if (b().is_signed == 1) {
                    this.j = !this.j;
                } else {
                    this.g = !this.g;
                }
                e();
                return;
            case R.id.cancel_buy_btn /* 2131362713 */:
                CallHelloManager a2 = CallHelloManager.a();
                HomeActivity homeActivity = HomeActivity.f30985c;
                Bundle arguments = getArguments();
                Integer valueOf = arguments == null ? null : Integer.valueOf(arguments.getInt("FROM_PAGE"));
                Intrinsics.a(valueOf);
                a2.a((Context) homeActivity, (IRequestHost) null, false, valueOf.intValue(), false);
                EventTrackGuy.a(GuyProtos.Event.CALL_MORE_TIMES_TWO_FAIL_POP_GIVE_UP_CLICK);
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
                return;
            case 2131364488:
                FragmentActivity activity2 = getActivity();
                if (activity2 == null) {
                    return;
                }
                activity2.finish();
                return;
            case R.id.ll_mouth_card_item /* 2131368040 */:
                a(3);
                return;
            case R.id.rl_pay_type /* 2131369368 */:
                f();
                return;
            case R.id.tv_buy_privilege /* 2131371038 */:
                g();
                return;
            case R.id.view_option_1 /* 2131373203 */:
                List<PrivilegeBuyOptionForJsonParse.ProductBean> list = this.e;
                boolean z = true;
                if (list != null) {
                    z = list.isEmpty();
                }
                if (z) {
                    return;
                }
                a(0);
                return;
            case R.id.view_option_2 /* 2131373204 */:
                List<PrivilegeBuyOptionForJsonParse.ProductBean> list2 = this.e;
                if (list2 == null || list2.size() <= 1) {
                    return;
                }
                a(1);
                return;
            case R.id.view_option_3 /* 2131373205 */:
                List<PrivilegeBuyOptionForJsonParse.ProductBean> list3 = this.e;
                if (list3 == null || list3.size() <= 2) {
                    return;
                }
                a(2);
                return;
            default:
                return;
        }
    }
}
