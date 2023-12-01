package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.adapter.RecommendUserMoreAdapter;
import com.soft.blued.ui.user.vm.RecommendUserMoreVM;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/RecommendUserMoreFragment.class */
public final class RecommendUserMoreFragment extends BaseListFragment<RecommendUserMoreVM, UserFindResult> {
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/RecommendUserMoreFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str, LogData logData) {
            Intrinsics.e(context, "context");
            Intrinsics.e(str, "uid");
            Intrinsics.e(logData, "logData");
            Bundle bundle = new Bundle();
            bundle.putString(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY, str);
            bundle.putSerializable("key_data", (Serializable) logData);
            Unit unit = Unit.a;
            TerminalActivity.d(context, RecommendUserMoreFragment.class, bundle);
        }
    }

    /* renamed from: C */
    public RecommendUserMoreAdapter i() {
        IRequestHost fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new RecommendUserMoreAdapter(fragmentActive);
    }

    public void m() {
        super.m();
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_SAME_PAGE_SHOW, "");
        CommonTopTitleNoTrans b2 = b();
        if (b2 != null) {
            b2.setCenterText(getString(R.string.user_more_users));
        }
        RecommendUserMoreAdapter recommendUserMoreAdapter = (RecommendUserMoreAdapter) f();
        Bundle arguments = getArguments();
        Serializable serializable = arguments == null ? null : arguments.getSerializable("key_data");
        Serializable serializable2 = serializable;
        if (serializable == null) {
            serializable2 = (Serializable) new LogData();
        }
        recommendUserMoreAdapter.a((LogData) serializable2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y().a((IRequestHost) getFragmentActive());
    }
}
