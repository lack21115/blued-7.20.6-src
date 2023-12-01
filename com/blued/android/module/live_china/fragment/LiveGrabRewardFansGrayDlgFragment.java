package com.blued.android.module.live_china.fragment;

import android.view.View;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGrabRewardFansGrayDlgFragment.class */
public class LiveGrabRewardFansGrayDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(View view) {
    }

    private void k() {
        dismissAllowingStateLoss();
        if (getParentFragment() != null) {
            ((PlayingOnliveFragment) getParentFragment()).K();
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_grab_reward_fans_gray;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGrabRewardFansGrayDlgFragment$8tRsThKW4g8ZLsrqUUdBYg1yoww
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGrabRewardFansGrayDlgFragment.c(view);
            }
        });
        this.b.findViewById(R.id.live_grab_reward_fans_gray_close_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGrabRewardFansGrayDlgFragment$BPznVdez2FEHyWwksr_1lJqvLKg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGrabRewardFansGrayDlgFragment.this.b(view);
            }
        });
        this.b.findViewById(R.id.live_grab_reward_fans_gray_confirm_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGrabRewardFansGrayDlgFragment$3fFxEgMmFffo-39VPkhQK1MQmiY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGrabRewardFansGrayDlgFragment.this.a(view);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
    }
}
