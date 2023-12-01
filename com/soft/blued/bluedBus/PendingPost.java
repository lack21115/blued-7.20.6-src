package com.soft.blued.bluedBus;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/bluedBus/PendingPost.class */
final class PendingPost {
    private static final List<PendingPost> d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object[] f28302a;
    Subscription b;

    /* renamed from: c  reason: collision with root package name */
    PendingPost f28303c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(PendingPost pendingPost) {
        pendingPost.f28302a = null;
        pendingPost.b = null;
        pendingPost.f28303c = null;
        synchronized (d) {
            if (d.size() < 10000) {
                d.add(pendingPost);
            }
        }
    }
}
