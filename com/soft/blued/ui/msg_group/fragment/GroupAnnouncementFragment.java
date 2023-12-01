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
import androidx.fragment.app.FragmentActivity;
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
    private final ViewBindingProperty f32669c;
    private String d;
    private int e;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(GroupAnnouncementFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FmGroupAnnouncementBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f32668a = new Companion(null);

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
            bundle.putSerializable(d.K, groupInfoModel);
            Unit unit = Unit.f42314a;
            TerminalActivity.d(context, GroupAnnouncementFragment.class, bundle);
        }
    }

    public GroupAnnouncementFragment() {
        super(R.layout.fm_group_announcement);
        this.f32669c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<GroupAnnouncementFragment, FmGroupAnnouncementBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmGroupAnnouncementBinding invoke(GroupAnnouncementFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmGroupAnnouncementBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<GroupAnnouncementFragment, FmGroupAnnouncementBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmGroupAnnouncementBinding invoke(GroupAnnouncementFragment fragment) {
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
            if (p != null && (editText = p.f28747a) != null) {
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
    public static final void a(FmGroupAnnouncementBinding viewBinding, GroupAnnouncementFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(viewBinding, "$viewBinding");
        Intrinsics.e(this$0, "this$0");
        if (viewBinding.f28747a.getText().toString().length() == 0) {
            this$0.r();
        } else {
            this$0.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupAnnouncementFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        this$0.a(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupAnnouncementFragment this$0, FmGroupAnnouncementBinding viewBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(viewBinding, "$viewBinding");
        if (Intrinsics.a((Object) this$0.d, (Object) viewBinding.f28747a.getText().toString())) {
            this$0.a(0);
        } else {
            this$0.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GroupAnnouncementFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        this$0.a(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GroupAnnouncementFragment this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        this$0.a(0);
    }

    private final FmGroupAnnouncementBinding p() {
        return (FmGroupAnnouncementBinding) this.f32669c.b(this, b[0]);
    }

    private final void q() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_send_title), getString(R.string.group_announcement_send_hint), getString(R.string.group_announcement_submit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$Xy9ToQUpQLSZ9d6aNZjGnHElXdg
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupAnnouncementFragment.a(GroupAnnouncementFragment.this, dialogInterface, i);
            }
        }, getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void r() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_clear_title), getString(R.string.group_announcement_clear_hint), getString(R.string.group_notify_clean), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$QomTmj4uNIjlv1Jjv88mIemo9cE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupAnnouncementFragment.b(GroupAnnouncementFragment.this, dialogInterface, i);
            }
        }, getString(2131887258), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    private final void s() {
        CommonAlertDialog.a(getContext(), getString(R.string.group_announcement_exit_title), getString(R.string.group_announcement_exit_hint), getString(R.string.group_announcement_quit), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$JLPVQ1yVqaVApJXWhU9FCTX8T28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                GroupAnnouncementFragment.c(GroupAnnouncementFragment.this, dialogInterface, i);
            }
        }, getString(R.string.group_announcement_go_on), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
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
        GroupInfoModel groupInfoModel = (GroupInfoModel) serializable;
        this.e = groupInfoModel.group_id;
        if (groupInfoModel.group_role == 1 || groupInfoModel.group_role == 2) {
            p.f28747a.setEnabled(true);
            p.g.setVisibility(0);
            p.d.setRightText(R.string.group_announcement_submit);
            p.d.setRightTextColor(2131101766);
            p.d.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$GroupAnnouncementFragment$UvUJtLAf7KRFT3UlhGQkP9hro1A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupAnnouncementFragment.a(FmGroupAnnouncementBinding.this, this, view);
                }
            });
            p.f28747a.addTextChangedListener(new TextWatcher() { // from class: com.soft.blued.ui.msg_group.fragment.GroupAnnouncementFragment$initView$1$3$1
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
            p.f28747a.setEnabled(false);
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
            if ((str3 == null || str3.length() == 0) && !p.f28747a.isEnabled()) {
                p.f28748c.setVisibility(8);
            }
        }
        p.f28747a.setText(groupInfoModel.announcement);
        p.f28747a.setSelection(p.f28747a.getText().length());
        String str4 = groupInfoModel.announcement;
        Intrinsics.c(str4, "group.announcement");
        this.d = str4;
        String obj = p.f28747a.getText().toString();
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

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
    }
}
