package com.soft.blued.ui.setting.fragment;

import android.app.Dialog;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.community.http.FeedHttpUtils;
import com.soft.blued.R;
import com.soft.blued.fragment.CommonWriteTextFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/FeedbackFragment.class */
public class FeedbackFragment extends CommonWriteTextFragment {
    private Dialog k;

    @Override // com.soft.blued.fragment.CommonWriteTextFragment
    public boolean a(int i, String str) {
        if (i != -1 || TextUtils.isEmpty(str) || getFragmentActive() == null || !getFragmentActive().isActive()) {
            return true;
        }
        if (this.k == null) {
            this.k = DialogUtils.a(getActivity());
        }
        DialogUtils.a(this.k);
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.fragment.FeedbackFragment.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                AppMethods.d((int) R.string.receive_nopraise);
                FeedbackFragment.this.getActivity().finish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(FeedbackFragment.this.k);
            }
        }, str, 0);
        return false;
    }
}
