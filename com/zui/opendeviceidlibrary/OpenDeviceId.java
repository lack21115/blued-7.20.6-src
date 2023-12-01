package com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: source-8829756-dex2jar.jar:com/zui/opendeviceidlibrary/OpenDeviceId.class */
public class OpenDeviceId {

    /* renamed from: c  reason: collision with root package name */
    private static String f28403c = "OpenDeviceId library";
    private static boolean d;

    /* renamed from: a  reason: collision with root package name */
    private IDeviceidInterface f28404a;
    private CallBack b;

    /* renamed from: com.zui.opendeviceidlibrary.OpenDeviceId$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/zui/opendeviceidlibrary/OpenDeviceId$1.class */
    class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OpenDeviceId f28405a;

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(ComponentName componentName);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zui/opendeviceidlibrary/OpenDeviceId$CallBack.class */
    public interface CallBack {
        void a(OpenDeviceId openDeviceId);
    }

    static native /* synthetic */ IDeviceidInterface a(OpenDeviceId openDeviceId, IDeviceidInterface iDeviceidInterface);

    static native /* synthetic */ CallBack a(OpenDeviceId openDeviceId);

    static native /* synthetic */ void a(OpenDeviceId openDeviceId, String str);

    private native void a(String str);
}
