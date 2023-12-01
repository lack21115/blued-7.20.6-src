package com.soft.blued.ui.msg_group.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvvm.EmptyViewModel;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.core.Observable;
import com.soft.blued.R;
import com.soft.blued.databinding.FmGroupAnnouncementBinding;
import com.soft.blued.ui.msg_group.event.UpdateAnnouncementEvent;
import com.umeng.analytics.pro.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupAnnouncementFragment.class */
public final class GroupAnnouncementFragment extends MVVMBaseFragment<EmptyViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f18978c;
    private String d;
    private int e;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(GroupAnnouncementFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FmGroupAnnouncementBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f18977a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupAnnouncementFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, GroupInfoModel groupInfoModel) {
            Intrinsics.e(context, "context");
            if (groupInfoModel == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(d.K, (Serializable) groupInfoModel);
            Unit unit = Unit.a;
            TerminalActivity.d(context, GroupAnnouncementFragment.class, bundle);
        }
    }

    public GroupAnnouncementFragment() {
        super((int) R.layout.fm_group_announcement);
        this.f18978c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<GroupAnnouncementFragment, FmGroupAnnouncementBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg_group/fragment/GroupAnnouncementFragment;)Lcom/soft/blued/databinding/FmGroupAnnouncementBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmGroupAnnouncementBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<GroupAnnouncementFragment, FmGroupAnnouncementBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg_group/fragment/GroupAnnouncementFragment;)Lcom/soft/blued/databinding/FmGroupAnnouncementBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmGroupAnnouncementBinding.a(fragment.requireView());
            }
        });
        this.d = "";
    }

    private final void a(int i) {
        EditText editText;
        if (i == -1) {
            Observable observable = LiveEventBus.get("send_announcement", UpdateAnnouncementEvent.class);
            long j = this.e;
            FmGroupAnnouncementBinding p = p();
            Editable editable = null;
            if (p != null && (editText = p.f15057a) != null) {
                editable = editText.getText();
            }
            observable.post(new UpdateAnnouncementEvent(j, String.valueOf(editable)));
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FmGroupAnnouncementBinding fmGroupAnnouncementBinding, GroupAnnouncementFragment groupAnnouncementFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(fmGroupAnnouncementBinding, "$viewBinding");
        Intrinsics.e(groupAnnouncementFragment, "this$0");
        if (fmGroupAnnouncementBinding.f15057a.getText().toString().length() == 0) {
            groupAnnouncementFragment.r();
        } else {
            groupAnnouncementFragment.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupAnnouncementFragment groupAnnouncementFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(groupAnnouncementFragment, "this$0");
        groupAnnouncementFragment.a(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupAnnouncementFragment groupAnnouncementFragment, FmGroupAnnouncementBinding fmGroupAnnouncementBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(groupAnnouncementFragment, "this$0");
        Intrinsics.e(fmGroupAnnouncementBinding, "$viewBinding");
        if (Intrinsics.a(groupAnnouncementFragment.d, fmGroupAnnouncementBinding.f15057a.getText().toString())) {
            groupAnnouncementFragment.a(0);
        } else {
            groupAnnouncementFragment.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GroupAnnouncementFragment groupAnnouncementFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(groupAnnouncementFragment, "this$0");
        groupAnnouncementFragment.a(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GroupAnnouncementFragment groupAnnouncementFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(groupAnnouncementFragment, "this$0");
        groupAnnouncementFragment.a(0);
    }

    private final FmGroupAnnouncementBinding p() {
        return (FmGroupAnnouncementBinding) this.f18978c.b(this, b[0]);
    }

    private final void q() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_send_title), getString(R.string.group_announcement_send_hint), getString(R.string.group_announcement_submit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$Xy9ToQUpQLSZ9d6aNZjGnHElXdg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupAnnouncementFragment.a(GroupAnnouncementFragment.this, dialogInterface, i);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void r() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_clear_title), getString(R.string.group_announcement_clear_hint), getString(R.string.group_notify_clean), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$QomTmj4uNIjlv1Jjv88mIemo9cE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupAnnouncementFragment.b(GroupAnnouncementFragment.this, dialogInterface, i);
            }
        }, getString(R.string.common_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void s() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_exit_title), getString(R.string.group_announcement_exit_hint), getString(R.string.group_announcement_quit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$JLPVQ1yVqaVApJXWhU9FCTX8T28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupAnnouncementFragment.c(GroupAnnouncementFragment.this, dialogInterface, i);
            }
        }, getString(R.string.group_announcement_go_on), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    public void f() {
        final FmGroupAnnouncementBinding p = p();
        if (p == null) {
            return;
        }
        p.d.f();
        p.d.setCenterText(getString(R.string.group_announcement));
        p.d.getLeftImg().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$2uzHvM1mwRfK9JSWgZuKK13m_7o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupAnnouncementFragment.a(GroupAnnouncementFragment.this, p, view);
            }
        });
        Bundle arguments = getArguments();
        Serializable serializable = arguments == null ? null : arguments.getSerializable(d.K);
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = serializable;
        this.e = groupInfoModel.group_id;
        if (groupInfoModel.group_role == 1 || groupInfoModel.group_role == 2) {
            p.f15057a.setEnabled(true);
            p.g.setVisibility(0);
            p.d.setRightText((int) R.string.group_announcement_submit);
            p.d.setRightTextColor(2131101766);
            p.d.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$UvUJtLAf7KRFT3UlhGQkP9hro1A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupAnnouncementFragment.a(FmGroupAnnouncementBinding.this, this, view);
                }
            });
            p.f15057a.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment$initView$1$3$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    TextView textView = FmGroupAnnouncementBinding.this.g;
                    StringBuilder sb = new StringBuilder();
                    sb.append(editable == null ? null : Integer.valueOf(editable.length()));
                    sb.append("/512");
                    textView.setText(sb.toString());
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        } else {
            p.f15057a.setEnabled(false);
            p.g.setVisibility(8);
        }
        if (groupInfoModel.type == 4) {
            if (groupInfoModel.event != null) {
                String str = groupInfoModel.event.announcement;
                if (!(str == null || str.length() == 0)) {
                    TextView textView = p.e;
                    String str2 = groupInfoModel.event.announcement;
                    Intrinsics.c(str2, "group.event.announcement");
                    textView.setText(StringsKt.a(str2, "$", "\n", false, 4, (Object) null));
                    p.e.setVisibility(0);
                }
            }
            String str3 = groupInfoModel.announcement;
            if ((str3 == null || str3.length() == 0) && !p.f15057a.isEnabled()) {
                p.f15058c.setVisibility(8);
            }
        }
        p.f15057a.setText(groupInfoModel.announcement);
        p.f15057a.setSelection(p.f15057a.getText().length());
        String str4 = groupInfoModel.announcement;
        Intrinsics.c(str4, "group.announcement");
        this.d = str4;
        String obj = p.f15057a.getText().toString();
        if (!(obj == null || obj.length() == 0) || groupInfoModel.group_role == 1 || groupInfoModel.group_role == 2 || p.e.getVisibility() != 8) {
            return;
        }
        p.f.setVisibility(0);
        Context context = getContext();
        if (context == null) {
            return;
        }
        p.b.setBackgroundColor(ContextCompat.getColor(context, 2131102360));
    }

    public void g() {
    }

    public void l() {
    }
}
