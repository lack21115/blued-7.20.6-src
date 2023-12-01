package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGuestGuideDlgFragment.class */
public class LiveGuestGuideDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    public ViewGroup j;
    private RelativeLayout k;
    private int l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        k();
    }

    private void k() {
        if (this.l == 2) {
            LivePreferencesUtils.d(true);
        }
        dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_guest_guide;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestGuideDlgFragment$U1P3kAnGv7APEqN4l-Oqr9eJ7Ps
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestGuideDlgFragment.this.c(view);
            }
        });
        ViewGroup viewGroup = (ViewGroup) this.b.findViewById(R.id.new_gift_guide);
        this.j = viewGroup;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestGuideDlgFragment$joShZT5V0Aw4wc1CxB7QD295Ti4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestGuideDlgFragment.this.b(view);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) this.b.findViewById(R.id.live_scroll_guide_layout);
        this.k = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestGuideDlgFragment$ZWV3S_w5sg8tgy_utL6-TuhpjGQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestGuideDlgFragment.this.a(view);
            }
        });
        int i = this.l;
        if (i == 1) {
            this.j.setVisibility(0);
        } else if (i == 2) {
            this.k.setVisibility(0);
        }
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        this.l = this.c.getInt("type");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        k();
        return true;
    }
}
