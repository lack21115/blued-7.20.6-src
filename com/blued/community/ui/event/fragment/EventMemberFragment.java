package com.blued.community.ui.event.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.fragment.BaseViewPagerParentFragment;
import com.blued.community.R;
import com.blued.community.databinding.FragmentEventMemberBinding;
import com.blued.community.manager.CommunityManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventMemberFragment.class */
public final class EventMemberFragment extends BaseViewPagerParentFragment {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19552c;
    private boolean d;
    private String e;
    private String f;
    private boolean g;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(EventMemberFragment.class, "viewBinding", "getViewBinding()Lcom/blued/community/databinding/FragmentEventMemberBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19551a = new Companion(null);

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventMemberFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String event_id, String uid, int i, boolean z) {
            Intrinsics.e(context, "context");
            Intrinsics.e(event_id, "event_id");
            Intrinsics.e(uid, "uid");
            Bundle bundle = new Bundle();
            bundle.putString("event_id", event_id);
            bundle.putString("event_uid", uid);
            bundle.putInt("event_quota_num", i);
            bundle.putBoolean("event_is_free", z);
            TerminalActivity.d(context, EventMemberFragment.class, bundle);
        }
    }

    public EventMemberFragment() {
        this.f19552c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<EventMemberFragment, FragmentEventMemberBinding>() { // from class: com.blued.community.ui.event.fragment.EventMemberFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventMemberBinding invoke(EventMemberFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventMemberBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<EventMemberFragment, FragmentEventMemberBinding>() { // from class: com.blued.community.ui.event.fragment.EventMemberFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentEventMemberBinding invoke(EventMemberFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentEventMemberBinding.a(fragment.requireView());
            }
        });
        this.e = "";
        this.f = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventMemberFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final FragmentEventMemberBinding b() {
        return (FragmentEventMemberBinding) this.f19552c.b(this, b[0]);
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void a() {
        if (!this.d || this.g) {
            EventMembersListFragment eventMembersListFragment = new EventMembersListFragment();
            eventMembersListFragment.setArguments(this.args);
            this.j.add(eventMembersListFragment);
            return;
        }
        EventMemberVerifyFragment eventMemberVerifyFragment = new EventMemberVerifyFragment();
        eventMemberVerifyFragment.setArguments(this.args);
        this.j.add(eventMemberVerifyFragment);
        EventMemberVerifyFragment eventMemberVerifyFragment2 = new EventMemberVerifyFragment();
        Bundle bundle = new Bundle();
        bundle.putAll(this.args);
        bundle.putInt("verify_type", 1);
        eventMemberVerifyFragment2.setArguments(bundle);
        this.j.add(eventMemberVerifyFragment2);
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public BaseFragment b(int i) {
        MVIBaseFragment eventMembersListFragment;
        MVIBaseFragment eventMemberVerifyFragment;
        Bundle bundle = new Bundle();
        bundle.putAll(this.args);
        if (this.d) {
            if (i == 1) {
                bundle.putInt("verify_type", 1);
                eventMemberVerifyFragment = new EventMemberVerifyFragment();
            } else {
                eventMemberVerifyFragment = new EventMemberVerifyFragment();
            }
            eventMembersListFragment = eventMemberVerifyFragment;
        } else {
            eventMembersListFragment = new EventMembersListFragment();
        }
        eventMembersListFragment.setArguments(bundle);
        return eventMembersListFragment;
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment
    public void f() {
        this.k.clear();
        if (!this.d || this.g) {
            this.k.add(getString(R.string.event_signuped));
            return;
        }
        this.k.add(getString(R.string.event_waiting_to_verified_tab));
        this.k.add(getString(R.string.event_verified_tab));
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        FragmentEventMemberBinding b2 = b();
        if (b2 == null) {
            return;
        }
        b2.e.setTitleBackgroundDrawable(R.color.syc_b);
        b2.e.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventMemberFragment$xiA7oFh2CLymPSh2SFHPUX5f2Eo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventMemberFragment.a(EventMemberFragment.this, view);
            }
        });
        b2.d.setupWithViewPager(this.h);
    }

    @Override // com.blued.android.module.common.fragment.BaseViewPagerParentFragment, com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        FragmentEventMemberBinding b2 = b();
        if (b2 == null) {
            return;
        }
        if (this.j.size() > 1) {
            b2.b.setVisibility(0);
        } else {
            b2.b.setVisibility(8);
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onParseArguments() {
        super.onParseArguments();
        String string = this.args.getString("event_id", "");
        Intrinsics.c(string, "args.getString(EventCons…nts.DataKey.EVENT_ID, \"\")");
        this.e = string;
        String string2 = this.args.getString("event_uid", "");
        Intrinsics.c(string2, "args.getString(EventCons…ts.DataKey.EVENT_UID, \"\")");
        this.f = string2;
        this.d = CommunityManager.f19086a.a().c(this.f);
        this.g = this.args.getBoolean("event_is_free", false);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_event_member;
    }
}
