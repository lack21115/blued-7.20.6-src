package com.ut.mini.plugin;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.core.appstatus.UTMCAppStatusCallbacks;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/plugin/UTPluginMgr.class */
public class UTPluginMgr implements UTMCAppStatusCallbacks {
    public static final String PARTNERPLUGIN_UTPREF = "com.ut.mini.perf.UTPerfPlugin";

    /* renamed from: a  reason: collision with root package name */
    private static UTPluginMgr f41028a = new UTPluginMgr();
    private HandlerThread b = null;
    private Handler mHandler = null;
    private List<UTPlugin> n = new LinkedList();
    private List<String> o = new ArrayList();
    private List<String> p = new ArrayList<String>() { // from class: com.ut.mini.plugin.UTPluginMgr.1
        {
            add(UTPluginMgr.PARTNERPLUGIN_UTPREF);
        }
    };
    private List<UTPlugin> q = new LinkedList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/ut/mini/plugin/UTPluginMgr$a.class */
    public static class a {
        private int K;

        /* renamed from: a  reason: collision with root package name */
        private UTPlugin f41029a;
        private Object f;

        private a() {
            this.K = 0;
            this.f = null;
            this.f41029a = null;
        }

        public UTPlugin a() {
            return this.f41029a;
        }

        public void a(UTPlugin uTPlugin) {
            this.f41029a = uTPlugin;
        }

        public void c(Object obj) {
            this.f = obj;
        }

        public void g(int i) {
            this.K = i;
        }

        public Object getMsgObj() {
            return this.f;
        }

        public int i() {
            return this.K;
        }
    }

    private UTPluginMgr() {
        if (Build.VERSION.SDK_INT >= 14) {
            UTMCAppStatusRegHelper.registerAppStatusCallbacks(this);
        }
    }

    private void O() {
        HandlerThread handlerThread = new HandlerThread("UT-PLUGIN-ASYNC");
        this.b = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.b.getLooper()) { // from class: com.ut.mini.plugin.UTPluginMgr.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1 && (message.obj instanceof a)) {
                    a aVar = (a) message.obj;
                    UTPlugin a2 = aVar.a();
                    int i = aVar.i();
                    Object msgObj = aVar.getMsgObj();
                    if (a2 != null) {
                        try {
                            if (!(msgObj instanceof UTPluginMsgDispatchDelegate)) {
                                a2.onPluginMsgArrivedFromSDK(i, msgObj);
                                return;
                            }
                            UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) msgObj;
                            if (uTPluginMsgDispatchDelegate.isMatchPlugin(a2)) {
                                a2.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(a2));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        };
    }

    private UTPluginContext a() {
        UTPluginContext uTPluginContext = new UTPluginContext();
        uTPluginContext.setContext(b.a().getContext());
        if (i.n()) {
            uTPluginContext.setDebugLogFlag(i.n());
        }
        return uTPluginContext;
    }

    private void a(int i, UTPluginContextValueDispatchDelegate uTPluginContextValueDispatchDelegate) {
        synchronized (this) {
            if (uTPluginContextValueDispatchDelegate == null) {
                return;
            }
            for (UTPlugin uTPlugin : this.q) {
                uTPluginContextValueDispatchDelegate.onPluginContextValueChange(uTPlugin.getPluginContext());
                uTPlugin.onPluginContextValueUpdate(i);
            }
        }
    }

    private boolean a(int i, int[] iArr) {
        boolean z = false;
        if (iArr != null) {
            z = false;
            for (int i2 : iArr) {
                if (i2 == i) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static UTPluginMgr getInstance() {
        return f41028a;
    }

    public boolean dispatchPluginMsg(int i, Object obj) {
        boolean z;
        synchronized (this) {
            if (this.mHandler == null) {
                O();
            }
            z = false;
            boolean z2 = false;
            if (this.q.size() > 0) {
                Iterator<UTPlugin> it = this.q.iterator();
                while (true) {
                    z = z2;
                    if (!it.hasNext()) {
                        break;
                    }
                    UTPlugin next = it.next();
                    int[] returnRequiredMsgIds = next.returnRequiredMsgIds();
                    if (returnRequiredMsgIds != null && a(i, returnRequiredMsgIds)) {
                        if (i != 1 && (this.n == null || !this.n.contains(next))) {
                            a aVar = new a();
                            aVar.g(i);
                            aVar.c(obj);
                            aVar.a(next);
                            Message obtain = Message.obtain();
                            obtain.what = 1;
                            obtain.obj = aVar;
                            this.mHandler.sendMessage(obtain);
                            z2 = true;
                        }
                        if (obj instanceof UTPluginMsgDispatchDelegate) {
                            UTPluginMsgDispatchDelegate uTPluginMsgDispatchDelegate = (UTPluginMsgDispatchDelegate) obj;
                            if (uTPluginMsgDispatchDelegate.isMatchPlugin(next)) {
                                next.onPluginMsgArrivedFromSDK(i, uTPluginMsgDispatchDelegate.getDispatchObject(next));
                            }
                        } else {
                            next.onPluginMsgArrivedFromSDK(i, obj);
                        }
                        z2 = true;
                    }
                }
            }
        }
        return z;
    }

    public boolean isPartnerPluginExist(String str) {
        return this.o.contains(str);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchBackground() {
        dispatchPluginMsg(2, null);
    }

    @Override // com.ut.mini.core.appstatus.UTMCAppStatusCallbacks
    public void onSwitchForeground() {
        dispatchPluginMsg(8, null);
    }

    public void registerPlugin(UTPlugin uTPlugin, boolean z) {
        synchronized (this) {
            if (uTPlugin != null) {
                if (!this.q.contains(uTPlugin)) {
                    uTPlugin.a(a());
                    this.q.add(uTPlugin);
                    if (!z) {
                        this.n.add(uTPlugin);
                    }
                    uTPlugin.onRegistered();
                }
            }
        }
    }

    public void runPartnerPlugin() {
        List<String> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str : this.p) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    Object newInstance = Class.forName(str).newInstance();
                    if (newInstance instanceof UTPlugin) {
                        registerPlugin((UTPlugin) newInstance, true);
                        i.a("runPartnerPlugin[OK]:" + str, new String[0]);
                        this.o.add(str);
                    }
                } catch (ClassNotFoundException e) {
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void unregisterPlugin(UTPlugin uTPlugin) {
        synchronized (this) {
            if (uTPlugin != null) {
                if (this.q.contains(uTPlugin)) {
                    this.q.remove(uTPlugin);
                    uTPlugin.onUnRegistered();
                    uTPlugin.a(null);
                }
            }
            if (this.n != null && this.n.contains(uTPlugin)) {
                this.n.remove(uTPlugin);
            }
        }
    }

    public void updatePluginContextValue(int i) {
        if (i != 1) {
            return;
        }
        a(i, new UTPluginContextValueDispatchDelegate() { // from class: com.ut.mini.plugin.UTPluginMgr.3
            @Override // com.ut.mini.plugin.UTPluginContextValueDispatchDelegate
            public void onPluginContextValueChange(UTPluginContext uTPluginContext) {
                uTPluginContext.setDebugLogFlag(i.n());
            }
        });
    }
}
