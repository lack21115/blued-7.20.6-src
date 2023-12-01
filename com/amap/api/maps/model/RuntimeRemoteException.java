package com.amap.api.maps.model;

import android.os.RemoteException;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/model/RuntimeRemoteException.class */
public final class RuntimeRemoteException extends RuntimeException {
    private static final long serialVersionUID = -3541841807100437802L;

    public RuntimeRemoteException(RemoteException remoteException) {
        super(remoteException);
    }

    public RuntimeRemoteException(String str) {
        super(str);
    }
}
