package c.t.m.g;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/i4.class */
public class i4 extends ScanCallback {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3791a;
    public BluetoothManager b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothAdapter f3792c;
    public BluetoothLeScanner d;
    public boolean j;
    public a k;
    public HandlerThread l;
    public byte[] m = new byte[0];
    public List<z4> g = new LinkedList();
    public List<z4> h = new LinkedList();
    public String[] i = "AB8190D5-D11E-4941-ACC4-42F30510B408,FDA50693-A4E2-4FB1-AFCF-C6EB07647825".split(",");
    public ScanSettings e = new ScanSettings.Builder().setScanMode(1).build();
    public List<ScanFilter> f = new ArrayList();

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/i4$a.class */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(Message message) {
            switch (message.what) {
                case 99001:
                    i4 i4Var = i4.this;
                    i4Var.f3792c = i4Var.b == null ? null : i4.this.b.getAdapter();
                    if (i4.this.f3792c != null) {
                        i4 i4Var2 = i4.this;
                        i4Var2.d = i4Var2.f3792c.getBluetoothLeScanner();
                    }
                    i4.this.c();
                    return;
                case 99002:
                    if (i4.this.j) {
                        i4.this.d();
                        return;
                    }
                    return;
                case 99003:
                    i4.this.a((ScanResult) message.obj);
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                a(message);
            } catch (Throwable th) {
            }
        }
    }

    public i4(Context context) {
        this.f3791a = context;
        this.b = (BluetoothManager) this.f3791a.getSystemService("bluetooth");
        for (String str : this.i) {
            this.f.add(b(str));
        }
    }

    public List<z4> a() {
        List<z4> list;
        synchronized (this.g) {
            this.h.clear();
            for (z4 z4Var : this.g) {
                if (System.currentTimeMillis() - z4Var.e() <= 5000) {
                    this.h.add((z4) z4Var.clone());
                }
            }
            this.g.clear();
            list = this.h;
        }
        return list;
    }

    public final void a(ScanResult scanResult) {
        if (scanResult == null) {
            return;
        }
        try {
            BluetoothDevice device = scanResult.getDevice();
            int rssi = scanResult.getRssi();
            byte[] bytes = scanResult.getScanRecord().getBytes();
            if (bytes == null || bytes.length < 30) {
                return;
            }
            a(z4.a(device, rssi, bytes));
        } catch (Throwable th) {
        }
    }

    public void a(Handler handler) {
        synchronized (this.m) {
            if (this.k == null) {
                if (handler == null || handler.getLooper() == null) {
                    HandlerThread handlerThread = new HandlerThread("thread-bleloc");
                    this.l = handlerThread;
                    handlerThread.start();
                    this.k = new a(this.l.getLooper());
                } else {
                    this.k = new a(handler.getLooper());
                }
            }
            this.k.sendEmptyMessage(99001);
        }
    }

    public final void a(z4 z4Var) {
        synchronized (this.g) {
            if (z4Var != null) {
                this.g.add(z4Var);
            }
        }
    }

    public final byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return bArr;
            }
            bArr[i2 / 2] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
            i = i2 + 2;
        }
    }

    public final ScanFilter b(String str) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(a(str.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "")), 0, bArr, 2, 16);
        return new ScanFilter.Builder().setManufacturerData(76, bArr, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}).build();
    }

    public void b() {
        synchronized (this.m) {
            if (this.k != null) {
                this.k.removeCallbacksAndMessages(null);
                this.k.sendEmptyMessage(99002);
                this.k = null;
            }
            if (this.l != null) {
                this.l = null;
            }
        }
    }

    public final int c() {
        try {
            if (this.f3791a.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
                if (this.f3792c == null || !this.f3792c.isEnabled() || this.d == null) {
                    return -2;
                }
                this.d.startScan(this.f, this.e, this);
                this.j = true;
                return 0;
            }
            return -1;
        } catch (Throwable th) {
            return -3;
        }
    }

    public final void d() {
        try {
            synchronized (this.m) {
                if (this.f3791a.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
                    if (this.d != null) {
                        this.d.stopScan(this);
                    }
                    this.f3792c = null;
                    this.j = false;
                    synchronized (this.g) {
                        this.g.clear();
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int i) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i, ScanResult scanResult) {
        a aVar = this.k;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = 99003;
            obtainMessage.obj = scanResult;
            aVar.sendMessage(obtainMessage);
        }
    }
}
