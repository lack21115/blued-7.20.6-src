package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/BindResolveClients.class */
public class BindResolveClients {
    private static final Object b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ResolveClientBean> f9041a;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/common/internal/BindResolveClients$SingletonManager.class */
    static class SingletonManager {

        /* renamed from: a  reason: collision with root package name */
        private static final BindResolveClients f9042a = new BindResolveClients();

        private SingletonManager() {
        }
    }

    private BindResolveClients() {
        this.f9041a = new ArrayList<>();
    }

    public static BindResolveClients getInstance() {
        return SingletonManager.f9042a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (b) {
            contains = this.f9041a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (b) {
            ListIterator<ResolveClientBean> listIterator = this.f9041a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f9041a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (!this.f9041a.contains(resolveClientBean)) {
                this.f9041a.add(resolveClientBean);
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (b) {
            if (this.f9041a.contains(resolveClientBean)) {
                ListIterator<ResolveClientBean> listIterator = this.f9041a.listIterator();
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
            this.f9041a.clear();
        }
    }
}
