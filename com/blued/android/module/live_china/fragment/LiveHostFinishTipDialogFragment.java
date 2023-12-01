package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.View;
import com.blued.android.module.common.base.dialog.FullDialogFragment;
import com.blued.android.module.live_china.databinding.LiveHostFinishTipDialogFragmentBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishTipDialogFragment.class */
public final class LiveHostFinishTipDialogFragment extends FullDialogFragment<LiveHostFinishTipDialogFragmentBinding> {
    public static final Companion b = new Companion(null);
    private String c = "";
    private String d = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveHostFinishTipDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveHostFinishTipDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveHostFinishTipDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void b(String str) {
        Intrinsics.e(str, "<set-?>");
        this.d = str;
    }

    @Override // com.blued.android.module.common.base.dialog.FullDialogFragment
    public void e() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        String string = arguments.getString("name", "");
        Intrinsics.c(string, "it.getString(\"name\", \"\")");
        a(string);
        String string2 = arguments.getString("des", "");
        Intrinsics.c(string2, "it.getString(\"des\", \"\")");
        b(string2);
    }

    @Override // com.blued.android.module.common.base.dialog.FullDialogFragment
    public void f() {
        d().d.setText(this.c);
        d().b.setText(this.d);
        d().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishTipDialogFragment$u7fEpvvskyWSntPHvmyrxFvIwjw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostFinishTipDialogFragment.a(LiveHostFinishTipDialogFragment.this, view);
            }
        });
        d().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveHostFinishTipDialogFragment$0OExNXHtJezHDlnEZ7mLXjo6crc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveHostFinishTipDialogFragment.b(LiveHostFinishTipDialogFragment.this, view);
            }
        });
    }
}
