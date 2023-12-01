package com.blued.android.module.live_china.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGuestInterruptDlgFragment.class */
public class LiveGuestInterruptDlgFragment extends com.blued.android.module.common.fragment.LiveBaseDialogFragment {
    public TextView j;
    public TextView k;
    private String l;
    private String m;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
    }

    private void k() {
        dismissAllowingStateLoss();
        if (getTargetFragment() == null || !(getTargetFragment() instanceof PlayingOnliveFragment)) {
            return;
        }
        ((PlayingOnliveFragment) getTargetFragment()).aw();
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public int d() {
        return R.layout.live_error_layout_tips;
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void e() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestInterruptDlgFragment$T--KIbCruakjCdt3Kf03ZOcyyUM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestInterruptDlgFragment.b(view);
            }
        });
        TextView textView = (TextView) this.b.findViewById(R.id.error_tips_title);
        this.k = textView;
        textView.setText(this.l);
        this.j = (TextView) this.b.findViewById(R.id.error_tips_message);
        if (TextUtils.isEmpty(this.m)) {
            this.j.setVisibility(8);
        } else {
            this.j.setText(this.m);
        }
        this.b.findViewById(R.id.error_tips_btn).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGuestInterruptDlgFragment$XbPrxCnbyqXcIOX5Q28kUKWboP8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveGuestInterruptDlgFragment.this.a(view);
            }
        });
    }

    @Override // com.blued.android.module.common.fragment.LiveBaseDialogFragment
    public void f() {
        this.l = this.c.getString("msg_title");
        this.m = this.c.getString("msg_text");
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        k();
        return true;
    }
}
