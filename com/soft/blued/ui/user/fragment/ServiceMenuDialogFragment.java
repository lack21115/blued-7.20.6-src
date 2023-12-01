package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.a;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.user.adapter.ServiceMenuAdapter;
import com.soft.blued.ui.user.model.ServiceMenuModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ServiceMenuDialogFragment.class */
public final class ServiceMenuDialogFragment extends CommonDialogFragment {
    public static final Companion b = new Companion(null);

    /* renamed from: c  reason: collision with root package name */
    public ServiceMenuAdapter f20274c;
    private List<ServiceMenuModel> d = new ArrayList();
    private String e = "";

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/ServiceMenuDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ServiceMenuDialogFragment a(FragmentManager fragmentManager, List<ServiceMenuModel> list, String str) {
            Intrinsics.e(fragmentManager, "manager");
            Intrinsics.e(list, "data");
            Intrinsics.e(str, "uid");
            ServiceMenuDialogFragment serviceMenuDialogFragment = new ServiceMenuDialogFragment();
            serviceMenuDialogFragment.show(fragmentManager, ServiceMenuDialogFragment.class.getSimpleName());
            serviceMenuDialogFragment.a(list, str);
            return serviceMenuDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ServiceMenuDialogFragment serviceMenuDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(serviceMenuDialogFragment, "this$0");
        serviceMenuDialogFragment.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<ServiceMenuModel> list, String str) {
        this.d = list;
        this.e = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ServiceMenuDialogFragment serviceMenuDialogFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(serviceMenuDialogFragment, "this$0");
        serviceMenuDialogFragment.dismiss();
    }

    public void a(View view) {
        Intrinsics.e(view, a.B);
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        }
        ((FragmentActivity) context).getWindow().setSoftInputMode(51);
        TextView textView = (TextView) view.findViewById(2131371051);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(2131369105);
        View findViewById = view.findViewById(R.id.viewStub);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ServiceMenuDialogFragment$WnYRQwxTY8ZLGaui2goDp08c_8U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ServiceMenuDialogFragment.a(ServiceMenuDialogFragment.this, view2);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$ServiceMenuDialogFragment$f5G1j2otCKhRS6qapftWEAaRP8E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ServiceMenuDialogFragment.b(ServiceMenuDialogFragment.this, view2);
            }
        });
        Context context2 = getContext();
        if (context2 == null) {
            return;
        }
        a(new ServiceMenuAdapter(context2, this.e, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(context2));
        recyclerView.setAdapter(h());
        h().setNewData(this.d);
        h().notifyDataSetChanged();
        EventTrackPersonalProfile.e(PersonalProfileProtos.Event.SERVICE_PROFILE_PAGE_POP_SHOW, this.e);
    }

    public final void a(ServiceMenuAdapter serviceMenuAdapter) {
        Intrinsics.e(serviceMenuAdapter, "<set-?>");
        this.f20274c = serviceMenuAdapter;
    }

    public int d() {
        return R.layout.dialog_service_menu;
    }

    public int e() {
        return -1;
    }

    public int f() {
        return -1;
    }

    public final ServiceMenuAdapter h() {
        ServiceMenuAdapter serviceMenuAdapter = this.f20274c;
        if (serviceMenuAdapter != null) {
            return serviceMenuAdapter;
        }
        Intrinsics.c("mAdapter");
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }
}
