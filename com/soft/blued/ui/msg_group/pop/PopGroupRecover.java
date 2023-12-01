package com.soft.blued.ui.msg_group.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.utils.ToastUtils;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.PopGroupRecoverSuperBinding;
import com.soft.blued.ui.msg_group.adapter.GroupRecoverAdapter;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.RecyclerViewUtil;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/pop/PopGroupRecover.class */
public final class PopGroupRecover extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f19110c = {(KProperty) Reflection.a(new PropertyReference1Impl(PopGroupRecover.class, "vb", "getVb()Lcom/soft/blued/databinding/PopGroupRecoverSuperBinding;", 0))};
    private final MyGroupViewModel d;
    private final GroupPrivilegeModel e;
    private final ViewBindingProperty f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopGroupRecover(Context context, MyGroupViewModel myGroupViewModel, GroupPrivilegeModel groupPrivilegeModel) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(myGroupViewModel, "vm");
        Intrinsics.e(groupPrivilegeModel, "privilege");
        this.d = myGroupViewModel;
        this.e = groupPrivilegeModel;
        BasePopupView basePopupView = (BasePopupView) this;
        this.f = new CustomViewBindingProperty(new Function1<PopGroupRecover, PopGroupRecoverSuperBinding>() { // from class: com.soft.blued.ui.msg_group.pop.PopGroupRecover$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopGroupRecoverSuperBinding invoke(PopGroupRecover popGroupRecover) {
                Intrinsics.e(popGroupRecover, "popView");
                return PopGroupRecoverSuperBinding.a(popGroupRecover.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(int i, PopGroupRecover popGroupRecover, BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        Intrinsics.e(popGroupRecover, "this$0");
        List data = baseQuickAdapter.getData();
        Intrinsics.c(data, "adapter.data");
        int i3 = 0;
        for (Object obj : data) {
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
            }
            if (((GroupInfoModel) obj).isSelected) {
                i3++;
            }
        }
        Object obj2 = baseQuickAdapter.getData().get(i2);
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj2;
        if (groupInfoModel.isSelected || i3 < i) {
            groupInfoModel.isSelected = !groupInfoModel.isSelected;
            baseQuickAdapter.notifyItemChanged(i2);
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = popGroupRecover.getContext().getString(R.string.group_upper_limit_toast);
        Intrinsics.c(string, "context.getString(R.stri….group_upper_limit_toast)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        ToastUtils.a(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(GroupRecoverAdapter groupRecoverAdapter, PopGroupRecover popGroupRecover, View view) {
        Tracker.onClick(view);
        Intrinsics.e(groupRecoverAdapter, "$adapter");
        Intrinsics.e(popGroupRecover, "this$0");
        StringBuilder sb = new StringBuilder();
        int size = groupRecoverAdapter.getData().size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            if (groupRecoverAdapter.getData().get(i2).isSelected) {
                sb.append(groupRecoverAdapter.getData().get(i2).group_id);
                sb.append(",");
            }
            i = i2 + 1;
        }
        String sb2 = sb.toString();
        if (sb2 == null || sb2.length() == 0) {
            return;
        }
        MyGroupViewModel myGroupViewModel = popGroupRecover.d;
        String sb3 = sb.toString();
        Intrinsics.c(sb3, "sb.toString()");
        String substring = sb3.substring(0, sb.toString().length() - 1);
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        myGroupViewModel.a(substring);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopGroupRecover popGroupRecover, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popGroupRecover, "this$0");
        popGroupRecover.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopGroupRecover popGroupRecover, Integer num) {
        Intrinsics.e(popGroupRecover, "this$0");
        if (num != null && num.intValue() == 1) {
            ToastUtils.a(AppInfo.d().getString(R.string.group_upgrade_succeed_toast));
            popGroupRecover.p();
        }
    }

    private final PopGroupRecoverSuperBinding getVb() {
        return (PopGroupRecoverSuperBinding) this.f.b(this, f19110c[0]);
    }

    public void b() {
        super.b();
        final int super_max_group = this.e.getSuper_max_group() - this.e.getSuper_group();
        if (getContext() instanceof FragmentActivity) {
            Context context = getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
            this.d.h().observe((FragmentActivity) context, new Observer() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupRecover$CV_8AB80TEQdnDSmIt-HF26Osp0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PopGroupRecover.a(PopGroupRecover.this, (Integer) obj);
                }
            });
        }
        PopGroupRecoverSuperBinding vb = getVb();
        if (vb == null) {
            return;
        }
        TextView textView = vb.d;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getContext().getString(R.string.group_recover_privilege_dialog_title);
        Intrinsics.c(string, "context.getString(R.stri…r_privilege_dialog_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(getPrivilege().getSuper_max_population())}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        RecyclerViewUtil.a(vb.f15841a);
        vb.f15841a.setLayoutManager(new LinearLayoutManager(getContext()));
        final GroupRecoverAdapter groupRecoverAdapter = new GroupRecoverAdapter();
        groupRecoverAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupRecover$ry2B1ClrLu2Fas7unjQTtHL5V80
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PopGroupRecover.a(super_max_group, this, baseQuickAdapter, view, i);
            }
        });
        List<GroupInfoModel> groupList = getPrivilege().getGroupList();
        if (groupList != null) {
            for (int i = 0; i < super_max_group && i < groupList.size(); i++) {
                groupList.get(i).isSelected = true;
            }
        }
        groupRecoverAdapter.setNewData(getPrivilege().getGroupList());
        vb.f15841a.setAdapter(groupRecoverAdapter);
        vb.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupRecover$lk_0u_PrueiewrfOxMBTw7gRLNw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupRecover.a(PopGroupRecover.this, view);
            }
        });
        vb.f15842c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.pop.-$$Lambda$PopGroupRecover$0VagxNIpIdGYQyhnpp8Qe-LZnCg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopGroupRecover.a(GroupRecoverAdapter.this, this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_group_recover_super;
    }

    public final GroupPrivilegeModel getPrivilege() {
        return this.e;
    }

    public final MyGroupViewModel getVm() {
        return this.d;
    }

    public void w() {
        super.w();
        BluedPreferences.y(System.currentTimeMillis());
    }
}
