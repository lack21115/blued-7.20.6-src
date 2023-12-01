package com.soft.blued.ui.user.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/SecretlyFollowedObserver.class */
public class SecretlyFollowedObserver {

    /* renamed from: a  reason: collision with root package name */
    private static SecretlyFollowedObserver f34244a = new SecretlyFollowedObserver();
    private ArrayList<ISecretlyFollowedObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/SecretlyFollowedObserver$ISecretlyFollowedObserver.class */
    public interface ISecretlyFollowedObserver {
        void a(int i, int i2);
    }

    private SecretlyFollowedObserver() {
    }

    public static SecretlyFollowedObserver a() {
        return f34244a;
    }

    public void a(int i, int i2) {
        synchronized (this) {
            Iterator<ISecretlyFollowedObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ISecretlyFollowedObserver next = it.next();
                if (next != null) {
                    next.a(i, i2);
                }
            }
        }
    }

    public void a(ISecretlyFollowedObserver iSecretlyFollowedObserver) {
        synchronized (this) {
            if (iSecretlyFollowedObserver != null) {
                this.b.add(iSecretlyFollowedObserver);
            }
        }
    }

    public void b(ISecretlyFollowedObserver iSecretlyFollowedObserver) {
        synchronized (this) {
            if (iSecretlyFollowedObserver != null) {
                this.b.remove(iSecretlyFollowedObserver);
            }
        }
    }
}
