package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.url.H5Url;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.DialogVipUpgradeBinding;
import com.soft.blued.ui.user.adapter.VipUpgradeOptionAdapter;
import com.soft.blued.ui.user.model.VipUpgradeModel;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipUpgradeDialogFragment.class */
public final class VipUpgradeDialogFragment extends BottomSheetDialogFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34178a = new Companion(null);
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final List<VipUpgradeModel> f34179c;
    private final int d;
    private final Lazy e;
    private boolean f;
    private int g;
    private int h;
    private String i;
    private int j;
    private VipProtos.FromType k;
    private boolean l;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipUpgradeDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VipUpgradeDialogFragment a(Context context, FragmentManager manager, List<? extends VipUpgradeModel> data, int i, String vipDetail, int i2) {
            Intrinsics.e(context, "context");
            Intrinsics.e(manager, "manager");
            Intrinsics.e(data, "data");
            Intrinsics.e(vipDetail, "vipDetail");
            return a(context, manager, data, i, vipDetail, i2, VipProtos.FromType.UNKNOWN_FROM);
        }

        public final VipUpgradeDialogFragment a(Context context, FragmentManager manager, List<? extends VipUpgradeModel> data, int i, String vipDetail, int i2, VipProtos.FromType fromType) {
            Intrinsics.e(context, "context");
            Intrinsics.e(manager, "manager");
            Intrinsics.e(data, "data");
            Intrinsics.e(vipDetail, "vipDetail");
            Intrinsics.e(fromType, "fromType");
            VipUpgradeDialogFragment vipUpgradeDialogFragment = new VipUpgradeDialogFragment(context, data, i, vipDetail, i2, fromType);
            vipUpgradeDialogFragment.show(manager, VipUpgradeDialogFragment.class.getSimpleName());
            return vipUpgradeDialogFragment;
        }

        public final VipUpgradeDialogFragment a(Context context, FragmentManager manager, List<? extends VipUpgradeModel> data, boolean z) {
            Intrinsics.e(context, "context");
            Intrinsics.e(manager, "manager");
            Intrinsics.e(data, "data");
            VipUpgradeDialogFragment vipUpgradeDialogFragment = new VipUpgradeDialogFragment(context, data, z ? 3 : 1);
            vipUpgradeDialogFragment.show(manager, VipUpgradeDialogFragment.class.getSimpleName());
            return vipUpgradeDialogFragment;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VipUpgradeDialogFragment(Context mContext, List<? extends VipUpgradeModel> data, int i) {
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(data, "data");
        this.b = mContext;
        this.f34179c = data;
        this.d = i;
        this.e = LazyKt.a(new Function0<DialogVipUpgradeBinding>() { // from class: com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final DialogVipUpgradeBinding invoke() {
                return DialogVipUpgradeBinding.a(LayoutInflater.from(VipUpgradeDialogFragment.this.getContext()));
            }
        });
        this.f = true;
        this.i = "";
        this.k = VipProtos.FromType.UNKNOWN_FROM;
        this.l = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VipUpgradeDialogFragment(Context context, List<? extends VipUpgradeModel> data, int i, String vipDetail, int i2, VipProtos.FromType fromType) {
        this(context, data, 2);
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        Intrinsics.e(vipDetail, "vipDetail");
        Intrinsics.e(fromType, "fromType");
        this.h = i;
        this.i = vipDetail;
        this.j = i2;
        this.k = fromType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogVipUpgradeBinding this_apply, VipUpgradeDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this_apply, "$this_apply");
        Intrinsics.e(this$0, "this$0");
        this_apply.f28733c.setImageResource(R.drawable.icon_pay_type_select);
        this_apply.d.setImageResource(R.drawable.icon_agreement_unselect);
        this$0.l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VipUpgradeOptionAdapter optionAdapter, VipUpgradeDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(optionAdapter, "$optionAdapter");
        Intrinsics.e(this$0, "this$0");
        List<VipUpgradeModel> data = optionAdapter.getData();
        Intrinsics.c(data, "optionAdapter.data");
        Iterator<VipUpgradeModel> it = data.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            it.next();
            if (i3 < 0) {
                CollectionsKt.c();
            }
            optionAdapter.getData().get(i3).choose = i3 == i;
            VipUpgradeModel vipUpgradeModel = optionAdapter.getData().get(i);
            Intrinsics.c(vipUpgradeModel, "optionAdapter.data[position]");
            this$0.a(vipUpgradeModel);
            optionAdapter.notifyDataSetChanged();
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VipUpgradeDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        PayUtils.a(this$0.getContext(), this$0.h, this$0.i, this$0.j, this$0.k, false);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VipUpgradeDialogFragment this$0, DialogVipUpgradeBinding this_apply, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_apply, "$this_apply");
        boolean z = !this$0.f;
        this$0.f = z;
        if (z) {
            this_apply.e.setImageResource(R.drawable.icon_agreement_select);
        } else {
            this_apply.e.setImageResource(R.drawable.icon_agreement_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c9, code lost:
        if (r0.equals("vip_center_super_hide_distance_svip") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d5, code lost:
        if (r0.equals("chat_msg_quiet_singe") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e1, code lost:
        if (r0.equals("setting_msg_quiet_all") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ed, code lost:
        if (r0.equals("visit_page_no_trace_visit") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00f9, code lost:
        if (r0.equals("setting_traceless") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ff, code lost:
        r12 = "up_traceless_visit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012f, code lost:
        if (r0.equals("vip_center_super_hide_role_svip") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x013b, code lost:
        if (r0.equals("chat_msg_quiet_all") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0141, code lost:
        r12 = "up_look_quietly";
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x014d, code lost:
        if (r0.equals("vip_center_super_hide_all_svip") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0159, code lost:
        if (r0.equals("vip_center_super_hide_age_svip") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0165, code lost:
        if (r0.equals("nearby_settings_hide") == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x016b, code lost:
        r12 = "up_hide_custom";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment r11, com.soft.blued.ui.user.adapter.VipUpgradeOptionAdapter r12, android.view.View r13) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment.a(com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment, com.soft.blued.ui.user.adapter.VipUpgradeOptionAdapter, android.view.View):void");
    }

    private final void a(VipUpgradeModel vipUpgradeModel) {
        Context context;
        DialogVipUpgradeBinding k = k();
        if (k == null || (context = getContext()) == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics.c(calendar, "getInstance()");
        calendar.add(5, vipUpgradeModel.month * 30);
        TextView textView = k.p;
        textView.setText((char) 65509 + vipUpgradeModel.money + ' ' + context.getString(R.string.vip_upgrade_bluedx));
        k.q.setText(vipUpgradeModel.explain_text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogVipUpgradeBinding this_apply, VipUpgradeDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this_apply, "$this_apply");
        Intrinsics.e(this$0, "this$0");
        this_apply.f28733c.setImageResource(R.drawable.icon_agreement_unselect);
        this_apply.d.setImageResource(R.drawable.icon_pay_type_select);
        this$0.l = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipUpgradeDialogFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.b, H5Url.a(95));
    }

    private final void q() {
        final DialogVipUpgradeBinding k = k();
        if (k == null || getContext() == null) {
            return;
        }
        k.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$BJ4NkzE5N3rsdIau4vZNdzrjWU8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipUpgradeDialogFragment.a(DialogVipUpgradeBinding.this, this, view);
            }
        });
        k.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$Uh7EEMwAK3y1SIw8YmyHlRN5YzU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipUpgradeDialogFragment.b(DialogVipUpgradeBinding.this, this, view);
            }
        });
    }

    private final void r() {
        final DialogVipUpgradeBinding k = k();
        if (k == null) {
            return;
        }
        final Context context = getContext();
        if (context != null) {
            String string = context.getString(R.string.vip_read_ang_agree);
            Intrinsics.c(string, "mContext.getString(R.string.vip_read_ang_agree)");
            String string2 = context.getString(R.string.vip_service_terms);
            Intrinsics.c(string2, "mContext.getString(R.string.vip_service_terms)");
            String string3 = context.getString(R.string.hello_stop_interval);
            Intrinsics.c(string3, "mContext.getString(R.string.hello_stop_interval)");
            String string4 = context.getString(R.string.vip_privacy_policy);
            Intrinsics.c(string4, "mContext.getString(R.string.vip_privacy_policy)");
            String str = string + string2 + string3 + string4;
            String str2 = str;
            SpannableString spannableString = new SpannableString(str2);
            k.n.setMovementMethod(LinkMovementMethod.getInstance());
            spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment$setAgreement$1$1$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.e(widget, "widget");
                    WebViewShowInfoFragment.show(VipUpgradeDialogFragment.this.getActivity(), H5Url.a(35), 7);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.e(ds, "ds");
                    ds.setColor(ContextCompat.getColor(context, 2131102203));
                    ds.setFakeBoldText(true);
                }
            }, StringsKt.a((CharSequence) str2, string2, 0, false, 6, (Object) null), Intrinsics.a(string, (Object) string2).length(), 33);
            spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment$setAgreement$1$1$2
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.e(widget, "widget");
                    WebViewShowInfoFragment.show(Context.this, H5Url.a(22), 0);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint ds) {
                    Intrinsics.e(ds, "ds");
                    ds.setColor(ContextCompat.getColor(Context.this, 2131102203));
                    ds.setFakeBoldText(true);
                }
            }, StringsKt.a((CharSequence) str2, string4, 0, false, 6, (Object) null), str.length(), 33);
            k.n.setText(spannableString);
        }
        k.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$9-w1hMdJSk4b_zsgLajND82h-Oo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipUpgradeDialogFragment.a(VipUpgradeDialogFragment.this, k, view);
            }
        });
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        dismiss();
    }

    public final Context h() {
        return this.b;
    }

    public final List<VipUpgradeModel> i() {
        return this.f34179c;
    }

    public final int j() {
        return this.d;
    }

    public final DialogVipUpgradeBinding k() {
        return (DialogVipUpgradeBinding) this.e.getValue();
    }

    public final int l() {
        int i = this.g;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }

    public final String m() {
        return this.i;
    }

    public final VipProtos.FromType n() {
        return this.k;
    }

    public final boolean o() {
        return this.l;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        VIPBuyResultObserver.a().b(this);
    }

    public final void p() {
        DialogVipUpgradeBinding k = k();
        if (k == null) {
            return;
        }
        Iterator<VipUpgradeModel> it = i().iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            VipUpgradeModel next = it.next();
            if (i2 < 0) {
                CollectionsKt.c();
            }
            next.choose = i2 == 0;
            i = i2 + 1;
        }
        if (j() == 2) {
            k.m.setVisibility(0);
            k.m.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$yKvibToq1g8gyiDjLiKGnFF2ors
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VipUpgradeDialogFragment.a(VipUpgradeDialogFragment.this, view);
                }
            });
        } else {
            k.m.setVisibility(8);
        }
        k.g.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$md61SaAzD5rQp0WVEgUhOdS44A8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipUpgradeDialogFragment.b(VipUpgradeDialogFragment.this, view);
            }
        });
        final VipUpgradeOptionAdapter vipUpgradeOptionAdapter = new VipUpgradeOptionAdapter();
        k.k.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        k.k.setAdapter(vipUpgradeOptionAdapter);
        vipUpgradeOptionAdapter.setNewData(i());
        vipUpgradeOptionAdapter.notifyDataSetChanged();
        vipUpgradeOptionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$RWVMh5Ukn0hOz3ovoL3jenZR_zs
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                VipUpgradeDialogFragment.a(VipUpgradeOptionAdapter.this, this, baseQuickAdapter, view, i3);
            }
        });
        a(i().get(0));
        r();
        q();
        k.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipUpgradeDialogFragment$8Fwb3mROn6VT6GkeqrM1AfB4NCo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipUpgradeDialogFragment.a(VipUpgradeDialogFragment.this, vipUpgradeOptionAdapter, view);
            }
        });
        Dialog dialog = getDialog();
        if (dialog == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialog");
        }
        ((BottomSheetDialog) dialog).a().a(l());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00bd, code lost:
        if (r0.equals("setting_msg_quiet_all") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00c9, code lost:
        if (r0.equals("visit_page_no_trace_visit") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00d5, code lost:
        if (r0.equals("setting_traceless") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00db, code lost:
        r4.k = com.blued.das.vip.VipProtos.FromType.TRACELESS_VISIT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0117, code lost:
        if (r0.equals("vip_center_super_hide_role_svip") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0123, code lost:
        if (r0.equals("chat_msg_quiet_all") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0129, code lost:
        r4.k = com.blued.das.vip.VipProtos.FromType.LOOK_QUIETLY;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0139, code lost:
        if (r0.equals("vip_center_super_hide_all_svip") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0145, code lost:
        if (r0.equals("vip_center_super_hide_age_svip") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0151, code lost:
        if (r0.equals("nearby_settings_hide") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0157, code lost:
        r4.k = com.blued.das.vip.VipProtos.FromType.HIDE_CUSTOM;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x00a5, code lost:
        if (r0.equals("vip_center_super_hide_distance_svip") == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00b1, code lost:
        if (r0.equals("chat_msg_quiet_singe") == false) goto L32;
     */
    @Override // com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setupDialog(android.app.Dialog r5, int r6) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.VipUpgradeDialogFragment.setupDialog(android.app.Dialog, int):void");
    }
}
