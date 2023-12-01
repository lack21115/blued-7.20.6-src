package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.live.base.manager.LiveDataManager;
import com.blued.android.module.yy_china.databinding.FragmentYyApplyLayoutBinding;
import com.blued.android.module.yy_china.fragment.YYApplyFinishFragment;
import com.blued.android.module.yy_china.listener.ITextWatcher;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.login_register.LinkMobileFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.msg_group.model.GroupIdentifyModel;
import com.soft.blued.ui.msg_group.viewmodel.GroupIdentifyViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupIdentifyFragment.class */
public final class GroupIdentifyFragment extends MVVMBaseFragment<GroupIdentifyViewModel> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f32673c;
    private int d;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(GroupIdentifyFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f32672a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupIdentifyFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Bundle bundle) {
            TerminalActivity.d(context, GroupIdentifyFragment.class, bundle);
        }
    }

    public GroupIdentifyFragment() {
        super(2131559360);
        this.f32673c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<GroupIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyApplyLayoutBinding invoke(GroupIdentifyFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<GroupIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyApplyLayoutBinding invoke(GroupIdentifyFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        });
        this.d = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0082, code lost:
        if (r0.length() == 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment r3, com.soft.blued.ui.msg_group.model.GroupIdentifyModel r4) {
        /*
            r0 = r3
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r3
            r1 = r4
            int r1 = r1.getVideo_verify()
            r0.d = r1
            r0 = r4
            java.lang.String r0 = r0.getCard_name()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7 = r0
            r0 = 0
            r6 = r0
            r0 = r7
            if (r0 == 0) goto L30
            r0 = r7
            int r0 = r0.length()
            if (r0 != 0) goto L2b
            goto L30
        L2b:
            r0 = 0
            r5 = r0
            goto L32
        L30:
            r0 = 1
            r5 = r0
        L32:
            r0 = r5
            if (r0 != 0) goto L6b
            r0 = r3
            com.blued.android.module.yy_china.databinding.FragmentYyApplyLayoutBinding r0 = r0.p()
            r7 = r0
            r0 = r7
            if (r0 != 0) goto L44
            goto L6b
        L44:
            r0 = r7
            android.widget.EditText r0 = r0.i
            r1 = r4
            java.lang.String r1 = r1.getCard_name()
            java.lang.String r1 = com.blued.android.framework.utils.AesCrypto.e(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            r0 = r7
            android.widget.EditText r0 = r0.i
            r1 = r7
            android.widget.EditText r1 = r1.i
            android.text.Editable r1 = r1.getText()
            int r1 = r1.length()
            r0.setSelection(r1)
        L6b:
            r0 = r4
            java.lang.String r0 = r0.getCard_number()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L85
            r0 = r6
            r5 = r0
            r0 = r7
            int r0 = r0.length()
            if (r0 != 0) goto L87
        L85:
            r0 = 1
            r5 = r0
        L87:
            r0 = r5
            if (r0 != 0) goto La6
            r0 = r3
            com.blued.android.module.yy_china.databinding.FragmentYyApplyLayoutBinding r0 = r0.p()
            r3 = r0
            r0 = r3
            if (r0 != 0) goto L95
            return
        L95:
            r0 = r3
            android.widget.EditText r0 = r0.h
            r1 = r4
            java.lang.String r1 = r1.getCard_number()
            java.lang.String r1 = com.blued.android.framework.utils.AesCrypto.e(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment.a(com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment, com.soft.blued.ui.msg_group.model.GroupIdentifyModel):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupIdentifyFragment this$0, Void r6) {
        Intrinsics.e(this$0, "this$0");
        int i = this$0.d;
        int i2 = 2;
        if (i == 2 || i == -1) {
            if (this$0.j().g()) {
                LiveDataManager.a().a(3);
                ShortVideoProxy.e().a(this$0, 4, 100);
                return;
            }
            LiveDataManager.a().a(2);
            ShortVideoProxy.e().a(this$0, 3, 100);
            return;
        }
        Context context = this$0.getContext();
        if (!this$0.j().g()) {
            i2 = 1;
        }
        YYApplyFinishFragment.a(context, 0, i2);
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentYyApplyLayoutBinding p() {
        return (FragmentYyApplyLayoutBinding) this.f32673c.b(this, b[0]);
    }

    private final void q() {
        String string = getString(2131886806);
        Intrinsics.c(string, "getString(R.string.blued_apply_host_agree)");
        String string2 = getString(R.string.group_code_of_conduct);
        Intrinsics.c(string2, "getString(R.string.group_code_of_conduct)");
        String str = string + ' ' + string2;
        SpannableString spannableString = new SpannableString(str);
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        p.f16490c.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$setAgreement$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                YYRoomInfoManager.e().c().a(GroupIdentifyFragment.this.getActivity(), "https://app.blued.cn/term/conductterm", 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.e(ds, "ds");
                Context context = GroupIdentifyFragment.this.getContext();
                if (context != null) {
                    ds.setColor(ContextCompat.getColor(context, 2131102163));
                }
                ds.setUnderlineText(false);
            }
        }, StringsKt.a((CharSequence) str, string2, 0, false, 6, (Object) null), (string + ' ' + string2).length(), 33);
        p.f16490c.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        String obj = StringsKt.b((CharSequence) p.i.getText().toString()).toString();
        String obj2 = StringsKt.b((CharSequence) p.h.getText().toString()).toString();
        Object tag = p.b.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        boolean booleanValue = ((Boolean) tag).booleanValue();
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || !booleanValue) {
            p.f16489a.setEnabled(false);
            p.f16489a.setAlpha(0.5f);
            return;
        }
        p.f16489a.setEnabled(true);
        p.f16489a.setAlpha(1.0f);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        p.f16489a.setText(getString(R.string.group_begin_identify));
        ImageView imageView = p.l.f16964a;
        GroupIdentifyFragment groupIdentifyFragment = this;
        imageView.setOnClickListener(groupIdentifyFragment);
        p.b.setOnClickListener(groupIdentifyFragment);
        p.b.setTag(true);
        p.b.setImageResource(2131233891);
        p.l.b.setText(getString(R.string.group_apply_create_title));
        p.j.setText(getString(R.string.group_apply_create_tip1));
        if (j().g()) {
            p.j.setText(getString(R.string.event_apply_create_tip1));
        }
        p.k.setText(getString(R.string.group_apply_create_tip2));
        p.i.setFilters(new InputFilter[]{new EnglishCharFilter(40)});
        p.i.addTextChangedListener(new ITextWatcher() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$initView$1$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                GroupIdentifyFragment.this.r();
            }
        });
        p.h.addTextChangedListener(new ITextWatcher() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$initView$1$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                Intrinsics.e(s, "s");
                GroupIdentifyFragment.this.r();
            }
        });
        p.f16489a.setOnClickListener(groupIdentifyFragment);
        p.g.setOnClickListener(groupIdentifyFragment);
        TextView textView = p.g;
        String b2 = LoginRegisterTools.b();
        boolean z = true;
        if (b2 != null) {
            z = b2.length() == 0;
        }
        textView.setText(getString(z ? 2131892874 : 2131892876));
        q();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        a().h();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        GroupIdentifyFragment groupIdentifyFragment = this;
        a().e().observe(groupIdentifyFragment, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupIdentifyFragment$gTpbVe43cce2ITbmqt-Jxp1ay3s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupIdentifyFragment.a(GroupIdentifyFragment.this, (Void) obj);
            }
        });
        a().d().observe(groupIdentifyFragment, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupIdentifyFragment$YJgukGkMPgVPSSJCeQT4xTCkXWk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupIdentifyFragment.a(GroupIdentifyFragment.this, (GroupIdentifyModel) obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 0 && i == 100 && intent != null && intent.getBooleanExtra("auth_upload_state", false)) {
            this.d = 0;
            YYApplyFinishFragment.a(getContext(), 0, j().g() ? 2 : 1);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        switch (v.getId()) {
            case 2131364105:
                FragmentYyApplyLayoutBinding p = p();
                if (p == null) {
                    return;
                }
                Object tag = p.b.getTag();
                if (tag == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                if (!((Boolean) tag).booleanValue()) {
                    ToastUtils.a("请先阅读相关条款及协议", 0);
                    return;
                }
                String obj = StringsKt.b((CharSequence) p.i.getText().toString()).toString();
                if (TextUtils.isEmpty(obj)) {
                    ToastUtils.a("真实姓名不符合标准", 0);
                    return;
                }
                String obj2 = StringsKt.b((CharSequence) p.h.getText().toString()).toString();
                if (TextUtils.isEmpty(obj2) || obj2.length() < 18) {
                    ToastUtils.a("证件号码不符合标准", 0);
                    return;
                } else {
                    a().a(obj, obj2);
                    return;
                }
            case 2131365115:
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
                return;
            case 2131365945:
                FragmentYyApplyLayoutBinding p2 = p();
                if (p2 == null) {
                    return;
                }
                Object tag2 = p2.b.getTag();
                if (tag2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolean z = !((Boolean) tag2).booleanValue();
                p2.b.setImageResource(z ? 2131233891 : 2131233892);
                p2.b.setTag(Boolean.valueOf(z));
                r();
                return;
            case 2131370980:
                String b2 = LoginRegisterTools.b();
                boolean z2 = true;
                if (b2 != null) {
                    z2 = b2.length() == 0;
                }
                if (z2) {
                    TerminalActivity.d(getContext(), LinkMobileFragment.class, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
