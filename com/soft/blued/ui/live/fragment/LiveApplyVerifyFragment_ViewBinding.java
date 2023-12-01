package com.soft.blued.ui.live.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.soft.blued.R;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveApplyVerifyFragment_ViewBinding.class */
public class LiveApplyVerifyFragment_ViewBinding implements Unbinder {
    private LiveApplyVerifyFragment b;

    public LiveApplyVerifyFragment_ViewBinding(LiveApplyVerifyFragment liveApplyVerifyFragment, View view) {
        this.b = liveApplyVerifyFragment;
        liveApplyVerifyFragment.top_title = (CommonTopTitleNoTrans) Utils.a(view, R.id.top_title, "field 'top_title'", CommonTopTitleNoTrans.class);
        liveApplyVerifyFragment.tv_tip_1 = (TextView) Utils.a(view, R.id.tv_tip_1, "field 'tv_tip_1'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        LiveApplyVerifyFragment liveApplyVerifyFragment = this.b;
        if (liveApplyVerifyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        liveApplyVerifyFragment.top_title = null;
        liveApplyVerifyFragment.tv_tip_1 = null;
    }
}
