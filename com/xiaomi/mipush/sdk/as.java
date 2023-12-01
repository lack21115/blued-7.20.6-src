package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/as.class */
public class as implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f41213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ao aoVar) {
        this.f41213a = aoVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f41213a) {
            this.f41213a.f135a = new Messenger(iBinder);
            this.f41213a.f41208c = false;
            list = this.f41213a.f138a;
            for (Message message : list) {
                try {
                    messenger = this.f41213a.f135a;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f41213a.f138a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f41213a.f135a = null;
        this.f41213a.f41208c = false;
    }
}
