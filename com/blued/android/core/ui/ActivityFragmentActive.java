package com.blued.android.core.ui;

import androidx.lifecycle.Lifecycle;
import com.blued.android.core.net.IRequestHost;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/ActivityFragmentActive.class */
public class ActivityFragmentActive implements IRequestHost {
    public static ActivityFragmentActive a = new ActivityFragmentActive();
    private Lifecycle b;

    private ActivityFragmentActive() {
    }

    public ActivityFragmentActive(Lifecycle lifecycle) {
        this.b = lifecycle;
    }

    public void a() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.blued.android.core.net.IRequestHost
    public boolean isActive() {
        Lifecycle lifecycle = this.b;
        if (lifecycle != null) {
            return lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED);
        }
        return false;
    }
}
