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
    public Messenger f22320a;
    public Bundle b;

    /* renamed from: c  reason: collision with root package name */
    public Context f22321c;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.i("MessengerSrvConnection", "onServiceConnected");
        this.f22320a = new Messenger(iBinder);
        Message obtain = Message.obtain();
        obtain.setData(this.b);
        try {
            this.f22320a.send(obtain);
        } catch (Exception e) {
            new StringBuilder("message sending failed. ").append(e.getMessage());
        }
        Log.i("MessengerSrvConnection", "start unbind service.");
        try {
            this.f22321c.unbindService(this);
            Log.i("MessengerSrvConnection", "unbind service end.");
        } catch (Exception e2) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("MessengerSrvConnection", "onServiceDisconnected");
        this.f22320a = null;
        this.b = null;
        this.f22321c = null;
    }
}
