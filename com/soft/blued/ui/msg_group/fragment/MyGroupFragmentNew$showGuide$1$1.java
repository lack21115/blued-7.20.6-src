package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.soft.blued.utils.BluedPreferences;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/MyGroupFragmentNew$showGuide$1$1.class */
public final class MyGroupFragmentNew$showGuide$1$1 extends SimpleCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyGroupFragmentNew f32771a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyGroupFragmentNew$showGuide$1$1(MyGroupFragmentNew myGroupFragmentNew) {
        this.f32771a = myGroupFragmentNew;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(BasePopupView basePopupView) {
        BluedPreferences.eu();
        if (basePopupView == null) {
            return;
        }
        basePopupView.p();
    }

    @Override // com.blued.android.framework.ui.xpop.interfaces.SimpleCallback, com.blued.android.framework.ui.xpop.interfaces.XPopupCallback
    public void c(final BasePopupView basePopupView) {
        this.f32771a.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$showGuide$1$1$D3cE2b1SrbS8GR6hW2PJ3f24YM0
            @Override // java.lang.Runnable
            public final void run() {
                MyGroupFragmentNew$showGuide$1$1.g(BasePopupView.this);
            }
        }, 5000L);
    }
}
