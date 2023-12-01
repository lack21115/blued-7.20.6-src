package com.blued.android.module.live.base.music;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/YyBackgroundItemFragment$liveDataObserver$5.class */
final /* synthetic */ class YyBackgroundItemFragment$liveDataObserver$5 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public YyBackgroundItemFragment$liveDataObserver$5(Object obj) {
        super(1, obj, YyBackgroundItemFragment.class, "loadFailed", "loadFailed(Z)V", 0);
    }

    public final void a(boolean z) {
        ((YyBackgroundItemFragment) this.receiver).d(z);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Boolean bool) {
        a(bool.booleanValue());
        return Unit.a;
    }
}
