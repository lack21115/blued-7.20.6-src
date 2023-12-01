package com.soft.blued.bluedBus;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/PendingPostQueue.class */
final class PendingPostQueue {

    /* renamed from: a  reason: collision with root package name */
    private PendingPost f14614a;
    private PendingPost b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingPost a() {
        PendingPost pendingPost;
        synchronized (this) {
            pendingPost = this.f14614a;
            if (this.f14614a != null) {
                PendingPost pendingPost2 = this.f14614a.f14613c;
                this.f14614a = pendingPost2;
                if (pendingPost2 == null) {
                    this.b = null;
                }
            }
        }
        return pendingPost;
    }
}
