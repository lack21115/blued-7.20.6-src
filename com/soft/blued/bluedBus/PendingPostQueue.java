package com.soft.blued.bluedBus;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/PendingPostQueue.class */
final class PendingPostQueue {

    /* renamed from: a  reason: collision with root package name */
    private PendingPost f28304a;
    private PendingPost b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingPost a() {
        PendingPost pendingPost;
        synchronized (this) {
            pendingPost = this.f28304a;
            if (this.f28304a != null) {
                PendingPost pendingPost2 = this.f28304a.f28303c;
                this.f28304a = pendingPost2;
                if (pendingPost2 == null) {
                    this.b = null;
                }
            }
        }
        return pendingPost;
    }
}
