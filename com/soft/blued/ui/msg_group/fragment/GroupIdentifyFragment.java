package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
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
    private final ViewBindingProperty f18982c;
    private int d;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(GroupIdentifyFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f18981a = new Companion(null);

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
        super((int) R.layout.fragment_yy_apply_layout);
        this.f18982c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<GroupIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg_group/fragment/GroupIdentifyFragment;)Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyApplyLayoutBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<GroupIdentifyFragment, FragmentYyApplyLayoutBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg_group/fragment/GroupIdentifyFragment;)Lcom/blued/android/module/yy_china/databinding/FragmentYyApplyLayoutBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
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
    public static final void a(GroupIdentifyFragment groupIdentifyFragment, Void r6) {
        Intrinsics.e(groupIdentifyFragment, "this$0");
        int i = groupIdentifyFragment.d;
        int i2 = 2;
        if (i == 2 || i == -1) {
            if (((GroupIdentifyViewModel) groupIdentifyFragment.j()).g()) {
                LiveDataManager.a().a(3);
                ShortVideoProxy.e().a(groupIdentifyFragment, 4, 100);
                return;
            }
            LiveDataManager.a().a(2);
            ShortVideoProxy.e().a(groupIdentifyFragment, 3, 100);
            return;
        }
        Context context = groupIdentifyFragment.getContext();
        if (!((GroupIdentifyViewModel) groupIdentifyFragment.j()).g()) {
            i2 = 1;
        }
        YYApplyFinishFragment.a(context, 0, i2);
        FragmentActivity activity = groupIdentifyFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentYyApplyLayoutBinding p() {
        return (FragmentYyApplyLayoutBinding) this.f18982c.b(this, b[0]);
    }

    private final void q() {
        String string = getString(R.string.blued_apply_host_agree);
        Intrinsics.c(string, "getString(R.string.blued_apply_host_agree)");
        String string2 = getString(R.string.group_code_of_conduct);
        Intrinsics.c(string2, "getString(R.string.group_code_of_conduct)");
        String str = string + ' ' + string2;
        SpannableString spannableString = new SpannableString(str);
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        p.c.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$setAgreement$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Intrinsics.e(view, "widget");
                YYRoomInfoManager.e().c().a(GroupIdentifyFragment.this.getActivity(), "https://app.blued.cn/term/conductterm", 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                Intrinsics.e(textPaint, "ds");
                Context context = GroupIdentifyFragment.this.getContext();
                if (context != null) {
                    textPaint.setColor(ContextCompat.getColor(context, 2131102163));
                }
                textPaint.setUnderlineText(false);
            }
        }, StringsKt.a(str, string2, 0, false, 6, (Object) null), (string + ' ' + string2).length(), 33);
        p.c.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        String obj = StringsKt.b(p.i.getText().toString()).toString();
        String obj2 = StringsKt.b(p.h.getText().toString()).toString();
        Object tag = p.b.getTag();
        if (tag == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
        }
        boolean booleanValue = ((Boolean) tag).booleanValue();
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || !booleanValue) {
            p.a.setEnabled(false);
            p.a.setAlpha(0.5f);
            return;
        }
        p.a.setEnabled(true);
        p.a.setAlpha(1.0f);
    }

    public void f() {
        FragmentYyApplyLayoutBinding p = p();
        if (p == null) {
            return;
        }
        p.a.setText(getString(R.string.group_begin_identify));
        ImageView imageView = p.l.a;
        GroupIdentifyFragment groupIdentifyFragment = this;
        imageView.setOnClickListener(groupIdentifyFragment);
        p.b.setOnClickListener(groupIdentifyFragment);
        p.b.setTag(true);
        p.b.setImageResource(2131233891);
        p.l.b.setText(getString(R.string.group_apply_create_title));
        p.j.setText(getString(R.string.group_apply_create_tip1));
        if (((GroupIdentifyViewModel) j()).g()) {
            p.j.setText(getString(R.string.event_apply_create_tip1));
        }
        p.k.setText(getString(R.string.group_apply_create_tip2));
        p.i.setFilters(new InputFilter[]{(InputFilter) new EnglishCharFilter(40)});
        p.i.addTextChangedListener((TextWatcher) new ITextWatcher() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$initView$1$1
            public void afterTextChanged(Editable editable) {
                Intrinsics.e(editable, "s");
                GroupIdentifyFragment.this.r();
            }
        });
        p.h.addTextChangedListener((TextWatcher) new ITextWatcher() { // from class: com.soft.blued.ui.msg_group.fragment.GroupIdentifyFragment$initView$1$2
            public void afterTextChanged(Editable editable) {
                Intrinsics.e(editable, "s");
                GroupIdentifyFragment.this.r();
            }
        });
        p.a.setOnClickListener(groupIdentifyFragment);
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

    public void g() {
        ((GroupIdentifyViewModel) a()).h();
    }

    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        ((GroupIdentifyViewModel) a()).e().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupIdentifyFragment$gTpbVe43cce2ITbmqt-Jxp1ay3s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupIdentifyFragment.a(GroupIdentifyFragment.this, (Void) obj);
            }
        });
        ((GroupIdentifyViewModel) a()).d().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupIdentifyFragment$YJgukGkMPgVPSSJCeQT4xTCkXWk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GroupIdentifyFragment.a(GroupIdentifyFragment.this, (GroupIdentifyModel) obj);
            }
        });
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 0 && i == 100 && intent != null && intent.getBooleanExtra("auth_upload_state", false)) {
            this.d = 0;
            YYApplyFinishFragment.a(getContext(), 0, ((GroupIdentifyViewModel) j()).g() ? 2 : 1);
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Intrinsics.e(view, "v");
        switch (view.getId()) {
            case R.id.go_auth /* 2131364105 */:
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
                String obj = StringsKt.b(p.i.getText().toString()).toString();
                if (TextUtils.isEmpty(obj)) {
                    ToastUtils.a("真实姓名不符合标准", 0);
                    return;
                }
                String obj2 = StringsKt.b(p.h.getText().toString()).toString();
                if (TextUtils.isEmpty(obj2) || obj2.length() < 18) {
                    ToastUtils.a("证件号码不符合标准", 0);
                    return;
                } else {
                    ((GroupIdentifyViewModel) a()).a(obj, obj2);
                    return;
                }
            case R.id.iv_back_img /* 2131365115 */:
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
                return;
            case R.id.iv_terms /* 2131365945 */:
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
            case R.id.tv_bind_phone /* 2131370980 */:
                String b2 = LoginRegisterTools.b();
                boolean z2 = true;
                if (b2 != null) {
                    z2 = b2.length() == 0;
                }
                if (z2) {
                    TerminalActivity.d(getContext(), LinkMobileFragment.class, (Bundle) null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
