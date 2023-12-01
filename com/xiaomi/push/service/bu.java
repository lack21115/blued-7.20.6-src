package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bu.class */
public class bu implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ServiceClient f41652a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(ServiceClient serviceClient) {
        this.f41652a = serviceClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        List<Message> list;
        List list2;
        Messenger messenger;
        synchronized (this.f41652a) {
            this.f41652a.f913b = new Messenger(iBinder);
            this.f41652a.f914b = false;
            list = this.f41652a.f911a;
            for (Message message : list) {
                try {
                    messenger = this.f41652a.f913b;
                    messenger.send(message);
                } catch (RemoteException e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                }
            }
            list2 = this.f41652a.f911a;
            list2.clear();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f41652a.f913b = null;
        this.f41652a.f914b = false;
    }
}
