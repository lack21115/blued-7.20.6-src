package com.soft.blued.user.Observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/user/Observer/BluedConfigDataObserver.class */
public class BluedConfigDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static BluedConfigDataObserver f34705a = new BluedConfigDataObserver();
    private List<IBluedConfigDataObserver> b = new ArrayList();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/user/Observer/BluedConfigDataObserver$IBluedConfigDataObserver.class */
    public interface IBluedConfigDataObserver {
        void a();
    }

    private BluedConfigDataObserver() {
    }

    public static BluedConfigDataObserver a() {
        return f34705a;
    }

    public void b() {
        synchronized (this) {
            for (IBluedConfigDataObserver iBluedConfigDataObserver : this.b) {
                if (iBluedConfigDataObserver != null) {
                    iBluedConfigDataObserver.a();
                }
            }
        }
    }
}
