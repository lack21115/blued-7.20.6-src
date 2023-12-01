package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/BinderAdapter.class */
public class BinderAdapter implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private Context f22419a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22420c;
    private BinderCallBack d;
    private IBinder e;
    private final Object f = new Object();
    private boolean g = false;
    private Handler h = null;
    private Handler i = null;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/BinderAdapter$BinderCallBack.class */
    public interface BinderCallBack {
        void onBinderFailed(int i);

        void onBinderFailed(int i, Intent intent);

        void onNullBinding(ComponentName componentName);

        void onServiceConnected(ComponentName componentName, IBinder iBinder);

        void onServiceDisconnected(ComponentName componentName);

        void onTimedDisconnected();
    }

    public BinderAdapter(Context context, String str, String str2) {
        this.f22419a = context;
        this.b = str;
        this.f22420c = str2;
    }

    private void c() {
        if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.f22420c)) {
            g();
        }
        Intent intent = new Intent(this.b);
        intent.setPackage(this.f22420c);
        synchronized (this.f) {
            if (this.f22419a.bindService(intent, this, 1)) {
                i();
                return;
            }
            this.g = true;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        BinderCallBack h = h();
        if (h != null) {
            h.onBinderFailed(-1);
        }
    }

    private void e() {
        synchronized (this.f) {
            if (this.h != null) {
                this.h.removeMessages(a());
                this.h = null;
            }
        }
    }

    private void f() {
        Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message == null || message.what != BinderAdapter.this.b()) {
                    return false;
                }
                HMSLog.i("BinderAdapter", "The serviceConnection has been bind for 60s, need to unbind.");
                BinderAdapter.this.unBind();
                BinderCallBack h = BinderAdapter.this.h();
                if (h != null) {
                    h.onTimedDisconnected();
                    return true;
                }
                return true;
            }
        });
        this.i = handler;
        handler.sendEmptyMessageDelayed(b(), 1800000L);
    }

    private void g() {
        HMSLog.e("BinderAdapter", "In connect, bind core service fail");
        ComponentName componentName = new ComponentName(this.f22419a.getApplicationInfo().packageName, "com.huawei.hms.activity.BridgeActivity");
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.putExtra(BridgeActivity.EXTRA_DELEGATE_CLASS_NAME, BindingFailedResolution.class.getName());
        BinderCallBack h = h();
        if (h != null) {
            h.onBinderFailed(-1, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BinderCallBack h() {
        return this.d;
    }

    private void i() {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(a());
        } else {
            this.h = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.huawei.hms.adapter.BinderAdapter.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message == null || message.what != BinderAdapter.this.a()) {
                        return false;
                    }
                    HMSLog.e("BinderAdapter", "In connect, bind core service time out");
                    BinderAdapter.this.d();
                    return true;
                }
            });
        }
        this.h.sendEmptyMessageDelayed(a(), 10000L);
    }

    private void j() {
        HMSLog.d("BinderAdapter", "removeDelayDisconnectTask.");
        synchronized (BinderAdapter.class) {
            try {
                if (this.i != null) {
                    this.i.removeMessages(b());
                }
            } finally {
            }
        }
    }

    protected int a() {
        return 0;
    }

    protected int b() {
        return 0;
    }

    public void binder(BinderCallBack binderCallBack) {
        if (binderCallBack == null) {
            return;
        }
        this.d = binderCallBack;
        c();
    }

    public String getServiceAction() {
        return this.b;
    }

    public IBinder getServiceBinder() {
        return this.e;
    }

    public void onNullBinding(ComponentName componentName) {
        HMSLog.e("BinderAdapter", "Enter onNullBinding, than unBind.");
        if (this.g) {
            this.g = false;
            return;
        }
        unBind();
        e();
        BinderCallBack h = h();
        if (h != null) {
            h.onNullBinding(componentName);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.i("BinderAdapter", "BinderAdapter Enter onServiceConnected.");
        this.e = iBinder;
        e();
        BinderCallBack h = h();
        if (h != null) {
            h.onServiceConnected(componentName, iBinder);
        }
        f();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("BinderAdapter", "Enter onServiceDisconnected.");
        BinderCallBack h = h();
        if (h != null) {
            h.onServiceDisconnected(componentName);
        }
        j();
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.f22419a, this);
    }

    public void updateDelayTask() {
        HMSLog.d("BinderAdapter", "updateDelayTask.");
        synchronized (BinderAdapter.class) {
            try {
                if (this.i != null) {
                    this.i.removeMessages(b());
                    this.i.sendEmptyMessageDelayed(b(), 1800000L);
                }
            } finally {
            }
        }
    }
}
