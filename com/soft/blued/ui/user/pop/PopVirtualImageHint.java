package com.soft.blued.ui.user.pop;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/pop/PopVirtualImageHint.class */
public final class PopVirtualImageHint extends CenterPopupView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopVirtualImageHint(Context context) {
        super(context);
        Intrinsics.e(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(PopVirtualImageHint popVirtualImageHint, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popVirtualImageHint, "this$0");
        popVirtualImageHint.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PopVirtualImageHint popVirtualImageHint, View view) {
        Tracker.onClick(view);
        Intrinsics.e(popVirtualImageHint, "this$0");
        popVirtualImageHint.p();
    }

    public void b() {
        super.b();
        ((TextView) findViewById(R.id.tv_select)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$PopVirtualImageHint$oRVxndhwYaPGG6kMl-UbInD37hI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopVirtualImageHint.a(PopVirtualImageHint.this, view);
            }
        });
        ((FrameLayout) findViewById(R.id.fl_close)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.pop.-$$Lambda$PopVirtualImageHint$BORuYQE09wKV3iVvX6plM4QHnws
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopVirtualImageHint.b(PopVirtualImageHint.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_virtual_image_hint;
    }
}
