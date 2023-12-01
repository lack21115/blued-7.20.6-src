package com.tencent.tinker.lib.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.tinker.lib.IForeService;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/service/TinkerPatchForeService.class */
public class TinkerPatchForeService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new IForeService.Stub() { // from class: com.tencent.tinker.lib.service.TinkerPatchForeService.1
            @Override // com.tencent.tinker.lib.IForeService
            public void startme() throws RemoteException {
            }
        };
    }
}
