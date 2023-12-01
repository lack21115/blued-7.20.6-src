package com.blued.community.ui.circle.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment;
import com.blued.community.ui.circle.manager.CircleMethods;
import com.blued.community.ui.circle.model.CircleJoinState;
import com.blued.community.utils.CommunityPreferences;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/ApplyJoinCircleFragment.class */
public class ApplyJoinCircleFragment extends BaseFragment {
    public static void a(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("circle_id", str);
        bundle.putString("circle_name", str2);
        bundle.putString("circle_header", str3);
        TransparentActivity.a(bundle);
        TransparentActivity.b(context, ApplyJoinCircleFragment.class, bundle);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getArguments() == null) {
            getActivity().finish();
            return;
        }
        final String string = getArguments().getString("circle_id");
        final String string2 = getArguments().getString("circle_name");
        final String string3 = getArguments().getString("circle_header");
        ApplyJoinCircleDialogFragment.a(getFragmentManager(), string, string2, string3, new ApplyJoinCircleDialogFragment.ApplyJoinCircleListener() { // from class: com.blued.community.ui.circle.fragment.ApplyJoinCircleFragment.2
            @Override // com.blued.community.ui.circle.fragment.ApplyJoinCircleDialogFragment.ApplyJoinCircleListener
            public void a() {
                CircleMethods.a(new CircleJoinState(string, string2, string3, 3, 1, 1));
                CommunityPreferences.a(string, true);
                CommunityPreferences.b(string, true);
            }
        }).a(new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.circle.fragment.ApplyJoinCircleFragment.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                ApplyJoinCircleFragment.this.getActivity().finish();
            }
        });
    }
}
