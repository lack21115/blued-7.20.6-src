package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/q.class */
public class q implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public Messenger f8712a;
    public Bundle b;

    /* renamed from: c  reason: collision with root package name */
    public Context f8713c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("MessengerSrvConnection", "onServiceConnected");
        this.f8712a = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.b);
        try {
            this.f8712a.send(obtain);
        } catch (Exception e) {
            new StringBuilder("message sending failed. ").append(e.getMessage());
        }
        Log.i("MessengerSrvConnection", "start unbind service.");
        try {
            this.f8713c.unbindService(this);
            Log.i("MessengerSrvConnection", "unbind service end.");
        } catch (Exception e2) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("MessengerSrvConnection", "onServiceDisconnected");
        this.f8712a = null;
        this.b = null;
        this.f8713c = null;
    }
}
