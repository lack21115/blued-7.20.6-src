package com.blued.community.ui.event.fragment;

import android.animation.ValueAnimator;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/event/fragment/EventDetailsFragment$refreshViews$1$3.class */
public final class EventDetailsFragment$refreshViews$1$3 extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EventDetailsFragment f19543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventDetailsFragment$refreshViews$1$3(EventDetailsFragment eventDetailsFragment) {
        this.f19543a = eventDetailsFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(EventDetailsFragment this$0) {
        ValueAnimator valueAnimator;
        Intrinsics.e(this$0, "this$0");
        valueAnimator = this$0.k;
        valueAnimator.start();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        final EventDetailsFragment eventDetailsFragment = this.f19543a;
        eventDetailsFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.event.fragment.-$$Lambda$EventDetailsFragment$refreshViews$1$3$Y4bkOs2IsQyWG0Unq05x0EkgY24
            @Override // java.lang.Runnable
            public final void run() {
                EventDetailsFragment$refreshViews$1$3.a(EventDetailsFragment.this);
            }
        });
    }
}
