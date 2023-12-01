package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.databinding.DialogSuperPrivilegePayBinding;
import com.soft.blued.log.bytedance.CallEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop;
import com.soft.blued.ui.user.model.CheckUserPrivilegePermission;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.ui.user.model.PrivilegeBuyOptionForJsonParse;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.state.PrivilegeBuyAction;
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
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SuperPrivilegeBuyDialogFragment.class */
public final class SuperPrivilegeBuyDialogFragment extends MVIBaseFragment<PrivilegeBuyDialogNewVM> implements View.OnClickListener, VIPBuyResultObserver.IVIPBuyResultObserver {
    private final ViewBindingProperty d;
    private List<PrivilegeBuyOptionForJsonParse.ProductBean> e;
    private List<PrivilegeDialogBuyNewOptionView> f;
    private PrivilegeBuyOptionForJsonParse.ProductBean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private GuyProtos.VocativeType m;
    private boolean n;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f33974c = {Reflection.a(new PropertyReference1Impl(SuperPrivilegeBuyDialogFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/DialogSuperPrivilegePayBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/SuperPrivilegeBuyDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, int i) {
            Intrinsics.e(context, "context");
            Bundle bundle = new Bundle();
            bundle.putInt("FROM_PAGE", i);
            TransparentActivity.a(bundle);
            TransparentActivity.b(context, SuperPrivilegeBuyDialogFragment.class, bundle);
        }

        public final void a(Context context, int i, String detail) {
            Intrinsics.e(context, "context");
            Intrinsics.e(detail, "detail");
            Bundle bundle = new Bundle();
            bundle.putInt("FROM_PAGE", i);
            bundle.putString("detail", detail);
            TransparentActivity.a(bundle);
            TransparentActivity.b(context, SuperPrivilegeBuyDialogFragment.class, bundle);
        }
    }

    public SuperPrivilegeBuyDialogFragment() {
        super(R.layout.dialog_super_privilege_pay);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<SuperPrivilegeBuyDialogFragment, DialogSuperPrivilegePayBinding>() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogSuperPrivilegePayBinding invoke(SuperPrivilegeBuyDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogSuperPrivilegePayBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<SuperPrivilegeBuyDialogFragment, DialogSuperPrivilegePayBinding>() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final DialogSuperPrivilegePayBinding invoke(SuperPrivilegeBuyDialogFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return DialogSuperPrivilegePayBinding.a(fragment.requireView());
            }
        });
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.h = true;
        this.i = 1;
        this.j = -1;
        this.k = true;
        this.m = GuyProtos.VocativeType.VOCATIVE_COMMON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SuperPrivilegeBuyDialogFragment this$0, int i, boolean z) {
        Intrinsics.e(this$0, "this$0");
        if (z && HomeActivity.f30985c != null) {
            if (this$0.k) {
                CallHelloManager.a().a(this$0.getContext(), (IRequestHost) null, false, i);
            } else {
                CallHelloManager.a().a(this$0.getFragmentActive());
            }
        }
        if (!this$0.k) {
            CallHelloManager.a().a(this$0.getFragmentActive());
        }
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final SuperPrivilegeBuyDialogFragment this$0, Boolean bool) {
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
        CallHelloManager.a().a(this$0.getContext(), this$0.getFragmentActive(), i, true, false, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperPrivilegeBuyDialogFragment$8l1jatKY15Oq85cZKgkQjP_23Gs
            @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
            public final void done(boolean z) {
                SuperPrivilegeBuyDialogFragment.a(SuperPrivilegeBuyDialogFragment.this, i2, z);
            }
        });
    }

    private final void a(PrivilegeBuyOptionForJsonParse.ProductBean productBean) {
        Context context;
        DialogSuperPrivilegePayBinding a2 = a();
        if (a2 == null || (context = getContext()) == null) {
            return;
        }
        if (productBean.choosen) {
            a2.D.setVisibility(8);
            ShapeHelper.b(a2.m, 2131102360);
            ShapeHelper.d(a2.m, 2131102222);
            a2.z.setPadding(0, DensityUtils.a(context, 10.0f), 0, 0);
            a2.z.setTextColor(context.getResources().getColor(2131102222));
            a2.A.setTextColor(context.getResources().getColor(2131102222));
            a2.C.setTextColor(context.getResources().getColor(2131102222));
            if (StringUtils.d(productBean.discount)) {
                a2.B.setVisibility(4);
            } else {
                a2.B.setVisibility(0);
                a2.B.setText(productBean.discount);
            }
            this.i = 1;
            h();
        } else {
            a2.D.setVisibility(0);
            ShapeHelper.b(a2.m, 2131102360);
            ShapeHelper.d(a2.m, 2131102360);
            a2.z.setPadding(0, DensityUtils.a(context, 20.0f), 0, 0);
            a2.z.setTextColor(context.getResources().getColor(2131102203));
            a2.A.setTextColor(context.getResources().getColor(2131102203));
            a2.C.setTextColor(context.getResources().getColor(2131102205));
            a2.B.setVisibility(8);
        }
        if (productBean.discount_price > 0.0f) {
            TextView textView = a2.C;
            StringBuilder sb = new StringBuilder();
            sb.append((char) 65509);
            sb.append((Object) StringUtils.a(productBean.discount_price + ""));
            sb.append('/');
            sb.append((Object) productBean.unit);
            textView.setText(sb.toString());
        } else {
            TextView textView2 = a2.C;
            StringBuilder sb2 = new StringBuilder();
            sb2.append((char) 65509);
            sb2.append((Object) StringUtils.a(productBean.average_price + ""));
            sb2.append('/');
            sb2.append((Object) productBean.unit);
            textView2.setText(sb2.toString());
        }
        a2.z.setText(String.valueOf(productBean.buy_num));
        a2.A.setText(productBean.unit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        CommonAlertDialog.a(getContext(), "提示", str, "好的", (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null, 0);
    }

    private final void a(boolean z) {
        this.k = z;
        DialogSuperPrivilegePayBinding a2 = a();
        if (a2 != null) {
            ViewGroup.LayoutParams layoutParams = a2.o.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            ViewGroup.LayoutParams layoutParams3 = a2.j.getLayoutParams();
            if (z) {
                a(GuyProtos.VocativeType.VOCATIVE_COMMON);
                ImageView imageView = a2.h;
                Context context = getContext();
                imageView.setImageDrawable(context == null ? null : context.getDrawable(R.drawable.privilege_tab_select));
                ImageView imageView2 = a2.i;
                Context context2 = getContext();
                imageView2.setImageDrawable(context2 == null ? null : context2.getDrawable(R.drawable.super_privilege_tab_un_select));
                ImageView imageView3 = a2.j;
                Context context3 = getContext();
                imageView3.setImageDrawable(context3 == null ? null : context3.getDrawable(R.drawable.privilege_dialog_top_bg));
                TextView textView = a2.x;
                Context context4 = getContext();
                textView.setBackground(context4 == null ? null : context4.getDrawable(R.drawable.icon_buy_privilege_new_btn));
                layoutParams3.height = DensityUtils.a(getContext(), 120.0f);
                a2.k.setVisibility(0);
                a2.v.setVisibility(8);
                a2.f.setVisibility(0);
                TextView textView2 = a2.e;
                Context context5 = getContext();
                textView2.setText(context5 == null ? null : context5.getText(R.string.hello_new_dialog_title));
                TextView textView3 = a2.d;
                Context context6 = getContext();
                textView3.setText(context6 == null ? null : context6.getText(R.string.hello_new_dialog_subtitle));
                layoutParams2.topMargin = -DensityUtils.a(getContext(), 15.0f);
                a(d());
            } else {
                a(GuyProtos.VocativeType.VOCATIVE_SUPER);
                ImageView imageView4 = a2.h;
                Context context7 = getContext();
                imageView4.setImageDrawable(context7 == null ? null : context7.getDrawable(R.drawable.privilege_tab_un_select));
                ImageView imageView5 = a2.i;
                Context context8 = getContext();
                imageView5.setImageDrawable(context8 == null ? null : context8.getDrawable(R.drawable.super_privilege_tab_select));
                layoutParams3.height = DensityUtils.a(getContext(), 248.0f);
                ImageLoader.a(getFragmentActive(), ImgURLMap.f10885a.a("super_privilege_dialog_top_bg")).a(a2.j);
                TextView textView4 = a2.x;
                Context context9 = getContext();
                textView4.setBackground(context9 == null ? null : context9.getDrawable(R.drawable.icon_buy_super_privilege_new_btn));
                a2.k.setVisibility(8);
                a2.v.setVisibility(0);
                a2.f.setVisibility(8);
                TextView textView5 = a2.e;
                Context context10 = getContext();
                textView5.setText(context10 == null ? null : context10.getText(R.string.super_hello_new_dialog_title));
                TextView textView6 = a2.d;
                Context context11 = getContext();
                textView6.setText(context11 == null ? null : context11.getText(R.string.super_hello_new_dialog_subtitle));
                layoutParams2.topMargin = -DensityUtils.a(getContext(), 50.0f);
                b(3);
                h();
            }
            a2.j.setLayoutParams(layoutParams3);
            i();
            f();
            a2.o.setLayoutParams(layoutParams2);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        int i = arguments.getInt("FROM_PAGE");
        GuyProtos.VocativeType b2 = b();
        Bundle arguments2 = getArguments();
        CallHelloManager.a(i, b2, arguments2 == null ? null : arguments2.getString("detail"), false, this.l ? "super" : "common");
    }

    private final void b(int i) {
        final Context context;
        DialogSuperPrivilegePayBinding a2 = a();
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
        a2.f28725c.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$setAgreement$1$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(SuperPrivilegeBuyDialogFragment.this.getActivity(), H5Url.a(35), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(ContextCompat.getColor(context, 2131101766));
                ds.setUnderlineText(false);
            }
        }, StringsKt.a((CharSequence) str2, string2, 0, false, 6, (Object) null), Intrinsics.a(string, (Object) string2).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$setAgreement$1$1$2
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(SuperPrivilegeBuyDialogFragment.this.getActivity(), H5Url.a(48), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                ds.setColor(ContextCompat.getColor(context, 2131101766));
                ds.setUnderlineText(false);
            }
        }, StringsKt.a((CharSequence) str2, string4, 0, false, 6, (Object) null), str.length(), 33);
        if (i == 3) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$setAgreement$1$1$3
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.e(widget, "widget");
                    WebViewShowInfoFragment.show(SuperPrivilegeBuyDialogFragment.this.getActivity(), H5Url.a(34), 7);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.e(ds, "ds");
                    ds.setColor(ContextCompat.getColor(context, 2131101766));
                    ds.setUnderlineText(false);
                }
            }, StringsKt.a((CharSequence) str2, string5, 0, false, 6, (Object) null), (string + string2 + string3 + string5).length(), 33);
        }
        a2.f28725c.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SuperPrivilegeBuyDialogFragment this$0, int i, boolean z) {
        FragmentActivity activity;
        Intrinsics.e(this$0, "this$0");
        if (z && HomeActivity.f30985c != null) {
            if (this$0.k) {
                CallHelloManager.a().a(this$0.getContext(), (IRequestHost) null, false, i);
            } else {
                CallHelloManager.a().a(this$0.getFragmentActive());
            }
        }
        if (!this$0.k) {
            CallHelloManager.a().a(this$0.getFragmentActive());
        }
        if (this$0.getActivity() == null || (activity = this$0.getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    private final void g() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_CALL_BUY_OPEN, Boolean.TYPE).observe(this, new Observer() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperPrivilegeBuyDialogFragment$uQZaA_iE3YEYsZ3ev82mFBZCUvo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuperPrivilegeBuyDialogFragment.a(SuperPrivilegeBuyDialogFragment.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        DialogSuperPrivilegePayBinding a2;
        if (this.e == null || (a2 = a()) == null) {
            return;
        }
        int i = this.i;
        if (i == 1) {
            TextView textView = a2.E;
            Context context = getContext();
            textView.setText(context == null ? null : context.getString(2131886386));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean : this.e) {
                productBean.showBeans = false;
            }
            TextView textView2 = a2.x;
            Context context2 = getContext();
            textView2.setText(context2 == null ? null : context2.getString(R.string.hello_buy));
        } else if (i == 2) {
            TextView textView3 = a2.E;
            Context context3 = getContext();
            textView3.setText(context3 == null ? null : context3.getString(R.string.pay_type_wechat));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean2 : this.e) {
                productBean2.showBeans = false;
            }
            TextView textView4 = a2.x;
            Context context4 = getContext();
            textView4.setText(context4 == null ? null : context4.getString(R.string.hello_buy));
        } else if (i == 3) {
            TextView textView5 = a2.E;
            Context context5 = getContext();
            textView5.setText(context5 != null ? context5.getString(R.string.pay_type_beans) : null);
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean3 : this.e) {
                productBean3.showBeans = false;
            }
            Context context6 = getContext();
            if (context6 != null) {
                TextView textView6 = a2.x;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = context6.getResources().getString(R.string.pay_beans);
                Intrinsics.c(string, "context.getResources().g…tring(R.string.pay_beans)");
                String format = String.format(string, Arrays.copyOf(new Object[]{e().total_beans + ""}, 1));
                Intrinsics.c(format, "format(format, *args)");
                textView6.setText(format);
            }
        } else if (i == 4) {
            TextView textView7 = a2.E;
            Context context7 = getContext();
            textView7.setText(context7 == null ? null : context7.getString(R.string.pay_platform_huabei));
            for (PrivilegeBuyOptionForJsonParse.ProductBean productBean4 : this.e) {
                productBean4.showBeans = false;
            }
            TextView textView8 = a2.x;
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

    private final void i() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        if (e().is_signed == 1) {
            if (this.n) {
                DialogSuperPrivilegePayBinding a2 = a();
                if (a2 == null || (imageView3 = a2.f28724a) == null) {
                    return;
                }
                imageView3.setImageResource(R.drawable.icon_selected);
                return;
            }
            DialogSuperPrivilegePayBinding a3 = a();
            if (a3 == null || (imageView4 = a3.f28724a) == null) {
                return;
            }
            imageView4.setImageResource(R.drawable.icon_unselect);
        } else if (this.h) {
            DialogSuperPrivilegePayBinding a4 = a();
            if (a4 == null || (imageView = a4.f28724a) == null) {
                return;
            }
            imageView.setImageResource(R.drawable.icon_selected);
        } else {
            DialogSuperPrivilegePayBinding a5 = a();
            if (a5 == null || (imageView2 = a5.f28724a) == null) {
                return;
            }
            imageView2.setImageResource(R.drawable.icon_unselect);
        }
    }

    private final void j() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        NormalPayTypeChoosePop.a(context, new NormalPayTypeChoosePop.iChoosePayResultListener() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$selectPayType$1$1
            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a() {
            }

            @Override // com.soft.blued.ui.msg.pop.NormalPayTypeChoosePop.iChoosePayResultListener
            public void a(int i, boolean z) {
                SuperPrivilegeBuyDialogFragment.this.i = i;
                SuperPrivilegeBuyDialogFragment.this.h();
            }
        }, this.i, e().id, getFragmentActive());
    }

    private final void l() {
        if (!this.n && e().is_signed == 1) {
            AppMethods.d((int) R.string.hello_bug_tips);
        } else if (!this.h) {
            AppMethods.d((int) R.string.hello_bug_tips);
        } else if (this.k) {
            n();
        } else {
            String str = UserInfo.getInstance().getLoginUserInfo().uid;
            Intrinsics.c(str, "getInstance().loginUserInfo.uid");
            BluedStructureExtKt.a(this, new PrivilegeBuyAction.checUserPermission(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (this.j >= 0) {
            Bundle arguments = getArguments();
            String str = "home_page";
            if (arguments != null) {
                int i = arguments.getInt("FROM_PAGE");
                if (i == 1) {
                    GuyProtos.Event event = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage = GuyProtos.VocativeSourcePage.VOCATIVE_HOMEPAGE;
                    EventTrackGuy.a(event, vocativeSourcePage, e().id + "", this.m);
                } else if (i == 2) {
                    GuyProtos.Event event2 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage2 = GuyProtos.VocativeSourcePage.VOCATIVE_MESSAGE;
                    EventTrackGuy.a(event2, vocativeSourcePage2, e().id + "", this.m);
                    CallEventUtils.a("VOCATIVE_MESSAGE", e().buy_num);
                    str = "vocative_msg";
                } else if (i == 3) {
                    GuyProtos.Event event3 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage3 = GuyProtos.VocativeSourcePage.HOME_VOCATIVE_BTN;
                    EventTrackGuy.a(event3, vocativeSourcePage3, e().id + "", this.m);
                    CallEventUtils.a("HOME_VOCATIVE_BTN", e().buy_num);
                } else if (i == 4) {
                    GuyProtos.Event event4 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage4 = GuyProtos.VocativeSourcePage.HOME_KEEP_ON;
                    EventTrackGuy.a(event4, vocativeSourcePage4, e().id + "", this.m);
                    CallEventUtils.a("HOME_KEEP_ON", e().buy_num);
                } else if (i == 7) {
                    GuyProtos.Event event5 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage5 = GuyProtos.VocativeSourcePage.VISIT_PAGE_CALL;
                    EventTrackGuy.a(event5, vocativeSourcePage5, e().id + "", this.m);
                    str = "visit_page";
                } else if (i == 8) {
                    CallEventUtils.a("VOCATIVE_SECOND_PAGE", e().buy_num);
                    str = "vocative_second_page";
                } else if (i == 9) {
                    String valueOf = String.valueOf(arguments.getString("detail"));
                    GuyProtos.Event event6 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage a2 = EventTrackGuy.a(valueOf);
                    EventTrackGuy.a(event6, a2, e().id + "", this.m);
                    str = valueOf;
                    if (!TextUtils.isEmpty(valueOf)) {
                        int hashCode = valueOf.hashCode();
                        if (hashCode != -235377960) {
                            if (hashCode != 119794870) {
                                if (hashCode != 1536204444) {
                                    str = valueOf;
                                } else if (valueOf.equals("vocative_end_report")) {
                                    CallEventUtils.a("REPORT_KEEP_ON", e().buy_num);
                                    str = valueOf;
                                } else {
                                    str = valueOf;
                                }
                            } else if (valueOf.equals("mine_vocative_order")) {
                                CallEventUtils.a("ORDER_BUY", e().buy_num);
                                str = valueOf;
                            } else {
                                str = valueOf;
                            }
                        } else if (valueOf.equals("mine_vocative_order_is_remain")) {
                            CallEventUtils.a("ORDER_BUY_MORE", e().buy_num);
                            str = valueOf;
                        } else {
                            str = valueOf;
                        }
                    }
                } else if (i == 11) {
                    GuyProtos.Event event7 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage6 = GuyProtos.VocativeSourcePage.CALL_POP;
                    EventTrackGuy.a(event7, vocativeSourcePage6, e().id + "", this.m);
                    CallEventUtils.a("CALL_POP", e().buy_num);
                    str = "vocative_nearby_bubble";
                } else if (i == 13) {
                    GuyProtos.Event event8 = GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_PAY_BTN_CLICK;
                    GuyProtos.VocativeSourcePage vocativeSourcePage7 = GuyProtos.VocativeSourcePage.PUSH_CALL_TIME;
                    EventTrackGuy.a(event8, vocativeSourcePage7, e().id + "", this.m);
                    str = "push_call";
                }
                PayPreOrderFragment.a(getContext(), e(), null, "", null, null, str, this.i, 0, getFragmentActive());
            }
            str = "";
            PayPreOrderFragment.a(getContext(), e(), null, "", null, null, str, this.i, 0, getFragmentActive());
        }
    }

    public final DialogSuperPrivilegePayBinding a() {
        return (DialogSuperPrivilegePayBinding) this.d.b(this, f33974c[0]);
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
            this.j = i;
            this.e.get(i).choosen = true;
            if (this.i == 3 && (context = getContext()) != null) {
                DialogSuperPrivilegePayBinding a2 = a();
                TextView textView = a2 == null ? null : a2.x;
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
                i();
                f();
                b(i);
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
            BluedPreferences.n(this.i);
            DialogSuperPrivilegePayBinding a2 = a();
            RelativeLayout relativeLayout = a2 == null ? null : a2.u;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
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
            CallHelloManager.a().a(getContext(), getFragmentActive(), i2, true, false, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$SuperPrivilegeBuyDialogFragment$AKN7VVPmiZXVllLnzfdxTZzYppI
                @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                public final void done(boolean z2) {
                    SuperPrivilegeBuyDialogFragment.b(SuperPrivilegeBuyDialogFragment.this, i3, z2);
                }
            });
        }
    }

    public final void a(GuyProtos.VocativeType vocativeType) {
        Intrinsics.e(vocativeType, "<set-?>");
        this.m = vocativeType;
    }

    public final void a(PrivilegeBuyOptionForJsonParse parseData) {
        boolean z;
        Intrinsics.e(parseData, "parseData");
        if (parseData.product != null) {
            this.e = new ArrayList();
            List<PrivilegeBuyOptionForJsonParse.ProductBean> list = parseData.product;
            Intrinsics.c(list, "parseData.product");
            this.e = list;
            if (parseData.super_call != null && parseData.super_call.size() > 0) {
                this.g = parseData.super_call.get(0);
            }
            c();
            h();
            Iterator<PrivilegeBuyOptionForJsonParse.ProductBean> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
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
                    this.i = 1;
                } else if (_channelVar.weixin != null && _channelVar.weixin.is_choose == 1) {
                    this.i = 2;
                } else if (_channelVar.huabei != null && _channelVar.huabei.is_choose == 1) {
                    this.i = 4;
                }
                h();
            }
            this.k = parseData.select_super_call == 0;
            boolean z2 = false;
            if (parseData.select_super_call == 1) {
                z2 = true;
            }
            this.l = z2;
            a(this.k);
        }
    }

    public final GuyProtos.VocativeType b() {
        return this.m;
    }

    public final void c() {
        PrivilegeBuyOptionForJsonParse.ProductBean productBean = this.g;
        if (productBean == null) {
            return;
        }
        DialogSuperPrivilegePayBinding a2 = a();
        TextView textView = a2 == null ? null : a2.F;
        if (textView == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) 65509);
        sb.append((Object) StringUtils.a(String.valueOf(productBean.average_price)));
        sb.append((Object) productBean.recommend_time);
        textView.setText(sb.toString());
    }

    public final int d() {
        int size = this.e.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.e.get(i2).choosen) {
                i = i2;
            }
        }
        return i;
    }

    public final PrivilegeBuyOptionForJsonParse.ProductBean e() {
        PrivilegeBuyOptionForJsonParse.ProductBean productBean;
        List<PrivilegeBuyOptionForJsonParse.ProductBean> list = this.e;
        if (list == null || list.isEmpty()) {
            return new PrivilegeBuyOptionForJsonParse.ProductBean();
        }
        if (!this.k && (productBean = this.g) != null) {
            return productBean;
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

    public final void f() {
        Context context;
        DialogSuperPrivilegePayBinding a2 = a();
        if (a2 == null || (context = getContext()) == null) {
            return;
        }
        String string = context.getString(R.string.hello_user_time);
        Intrinsics.c(string, "mContext.getString(R.string.hello_user_time)");
        if (e().is_signed == 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string2 = context.getString(R.string.hello_user_mouth_card_time);
            Intrinsics.c(string2, "mContext.getString(R.str…llo_user_mouth_card_time)");
            string = String.format(string2, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Double.valueOf(e().total_price))}, 1));
            Intrinsics.c(string, "format(format, *args)");
        }
        String str = string;
        if (!this.k) {
            PrivilegeBuyOptionForJsonParse.ProductBean productBean = this.g;
            if (productBean == null) {
                str = string;
            } else {
                str = productBean.desc;
                Intrinsics.c(str, "it.desc");
            }
        }
        a2.y.setText(str);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        this.e = new ArrayList();
        this.f = new ArrayList();
        DialogSuperPrivilegePayBinding a2 = a();
        if (a2 != null) {
            ImageView imageView = a2.g;
            SuperPrivilegeBuyDialogFragment superPrivilegeBuyDialogFragment = this;
            imageView.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.G.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.H.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.I.setOnClickListener(superPrivilegeBuyDialogFragment);
            List<PrivilegeDialogBuyNewOptionView> list = this.f;
            PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView = a2.G;
            Intrinsics.c(privilegeDialogBuyNewOptionView, "viewBinding.viewOption1");
            list.add(privilegeDialogBuyNewOptionView);
            List<PrivilegeDialogBuyNewOptionView> list2 = this.f;
            PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView2 = a2.H;
            Intrinsics.c(privilegeDialogBuyNewOptionView2, "viewBinding.viewOption2");
            list2.add(privilegeDialogBuyNewOptionView2);
            List<PrivilegeDialogBuyNewOptionView> list3 = this.f;
            PrivilegeDialogBuyNewOptionView privilegeDialogBuyNewOptionView3 = a2.I;
            Intrinsics.c(privilegeDialogBuyNewOptionView3, "viewBinding.viewOption3");
            list3.add(privilegeDialogBuyNewOptionView3);
            a2.x.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.m.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.f28724a.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.t.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.s.setOnClickListener(superPrivilegeBuyDialogFragment);
            a2.w.setOnClickListener(superPrivilegeBuyDialogFragment);
        }
        g();
        h();
        StatusBarHelper.a((Activity) getActivity(), false);
        VIPBuyResultObserver.a().a(this, getLifecycle());
        b(0);
        BluedStructureExtKt.a(this, new PrivilegeBuyAction.getGoodsList("call", 0));
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        SuperPrivilegeBuyDialogFragment superPrivilegeBuyDialogFragment = this;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(superPrivilegeBuyDialogFragment, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((PrivilegeBuyState) obj).getGoodsListData();
            }
        }, new Function1<PrivilegeBuyOptionForJsonParse, Unit>() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(PrivilegeBuyOptionForJsonParse it) {
                Intrinsics.e(it, "it");
                SuperPrivilegeBuyDialogFragment.this.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(PrivilegeBuyOptionForJsonParse privilegeBuyOptionForJsonParse) {
                a(privilegeBuyOptionForJsonParse);
                return Unit.f42314a;
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner2, "viewLifecycleOwner");
        BluedStructureExtKt.a(superPrivilegeBuyDialogFragment, viewLifecycleOwner2, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$liveDataObserver$3
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((PrivilegeBuyState) obj).getUserPrivilegePermission();
            }
        }, new Function1<CheckUserPrivilegePermission, Unit>() { // from class: com.soft.blued.ui.user.fragment.SuperPrivilegeBuyDialogFragment$liveDataObserver$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(CheckUserPrivilegePermission it) {
                Intrinsics.e(it, "it");
                if (it.open_status <= 0) {
                    if (it.allow_call) {
                        SuperPrivilegeBuyDialogFragment.this.n();
                        return;
                    }
                    return;
                }
                int i = it.open_status;
                if (i == 1) {
                    AppMethods.d((int) R.string.super_hello_status_opening);
                } else if (i == 4) {
                    SuperPrivilegeBuyDialogFragment superPrivilegeBuyDialogFragment2 = SuperPrivilegeBuyDialogFragment.this;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                    String string = SuperPrivilegeBuyDialogFragment.this.getString(R.string.super_hello_status_mb);
                    Intrinsics.c(string, "getString(R.string.super_hello_status_mb)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{TimeAndDateUtils.c(TimeAndDateUtils.j(it.expire_time), false)}, 1));
                    Intrinsics.c(format, "format(format, *args)");
                    superPrivilegeBuyDialogFragment2.a(format);
                    EventTrackGuy.b(GuyProtos.Event.CALL_BUY_MB_POP_SHOW);
                } else if (i != 5) {
                    if (i == 6) {
                        AppMethods.d((int) R.string.super_hello_status_verify);
                    } else if (i != 7) {
                    } else {
                        AppMethods.d((int) R.string.super_hello_status_no_header);
                    }
                } else {
                    EventTrackGuy.b(GuyProtos.Event.CALL_BUY_MUTE_POP_SHOW);
                    long j = 60;
                    String str = ((int) ((it.expire_time / j) / j)) + "小时" + ((int) Math.ceil((it.expire_time % 3600) / j)) + "分钟";
                    SuperPrivilegeBuyDialogFragment superPrivilegeBuyDialogFragment3 = SuperPrivilegeBuyDialogFragment.this;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                    String string2 = SuperPrivilegeBuyDialogFragment.this.getString(R.string.super_hello_status_mute);
                    Intrinsics.c(string2, "getString(R.string.super_hello_status_mute)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
                    Intrinsics.c(format2, "format(format, *args)");
                    superPrivilegeBuyDialogFragment3.a(format2);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(CheckUserPrivilegePermission checkUserPrivilegePermission) {
                a(checkUserPrivilegePermission);
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
                if (e().is_signed == 1) {
                    this.n = !this.n;
                } else {
                    this.h = !this.h;
                }
                i();
                return;
            case 2131364488:
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
                return;
            case R.id.ll_mouth_card_item /* 2131368040 */:
                a(3);
                return;
            case R.id.privilege_tab /* 2131368957 */:
                a(true);
                return;
            case R.id.rl_pay_type /* 2131369368 */:
                j();
                return;
            case R.id.super_privilege_tab /* 2131370501 */:
                a(false);
                return;
            case R.id.tv_buy_privilege /* 2131371038 */:
                l();
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
