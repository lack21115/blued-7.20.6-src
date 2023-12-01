package com.blued.android.module.live_china.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostExitDlgFragment.class */
public class LiveHostExitDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    public Button j;
    public Button k;
    public ImageView l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        l();
    }

    private void k() {
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(getTargetRequestCode(), -1, (Intent) null);
        }
        dismissAllowingStateLoss();
    }

    private void l() {
        dismissAllowingStateLoss();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.fragment_live_host_exit;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostExitDlgFragment$30cjUjZoyVtiiahls0I4hF2teBE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostExitDlgFragment.this.d(view);
            }
        });
        this.k = (Button) this.b.findViewById(R.id.live_exit_cancel_btn);
        this.j = (Button) this.b.findViewById(R.id.live_exit_sure_btn);
        this.l = (ImageView) this.b.findViewById(R.id.live_exit_close_btn);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostExitDlgFragment$ccPZTCwBUk0dPz0F93h1lI5wkoA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostExitDlgFragment.this.c(view);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostExitDlgFragment$TXugkpLOyBhWG5aY6ov8IZofO-8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostExitDlgFragment.this.b(view);
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostExitDlgFragment$xbvqYCLgkisZNQzLCgikAY2pYyY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostExitDlgFragment.this.a(view);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        l();
        return true;
    }
}
