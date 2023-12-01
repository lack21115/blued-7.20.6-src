package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/BindResolveClients.class */
public class BindResolveClients {
    private static final Object b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ResolveClientBean> f22649a;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/BindResolveClients$SingletonManager.class */
    static class SingletonManager {

        /* renamed from: a  reason: collision with root package name */
        private static final BindResolveClients f22650a = new BindResolveClients();

        private SingletonManager() {
        }
    }

    private BindResolveClients() {
        this.f22649a = new ArrayList<>();
    }

    public static BindResolveClients getInstance() {
        return SingletonManager.f22650a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (b) {
            contains = this.f22649a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (b) {
            ListIterator<ResolveClientBean> listIterator = this.f22649a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f22649a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (!this.f22649a.contains(resolveClientBean)) {
                this.f22649a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (this.f22649a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f22649a.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (b) {
            this.f22649a.clear();
        }
    }
}
