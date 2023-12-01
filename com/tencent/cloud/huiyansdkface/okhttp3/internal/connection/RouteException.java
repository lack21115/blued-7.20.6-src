package com.tencent.cloud.huiyansdkface.okhttp3.internal.connection;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/connection/RouteException.class */
public final class RouteException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private IOException f22248a;
    private IOException b;

    public RouteException(IOException iOException) {
        super(iOException);
        this.f22248a = iOException;
        this.b = iOException;
    }

    public void addConnectException(IOException iOException) {
        Util.addSuppressedIfPossible(this.f22248a, iOException);
        this.b = iOException;
    }

    public IOException getFirstConnectException() {
        return this.f22248a;
    }

    public IOException getLastConnectException() {
        return this.b;
    }
}
