package com.qiniu.android.storage;

import android.os.Looper;
import android.util.Log;
import com.qiniu.android.utils.AndroidNetwork;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/storage/UploadOptions.class */
public final class UploadOptions {
    final UpCancellationSignal cancellationSignal;
    final boolean checkCrc;
    final String mimeType;
    final NetReadyHandler netReadyHandler;
    final Map<String, String> params;
    final UpProgressHandler progressHandler;

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal) {
        this(map, str, z, upProgressHandler, upCancellationSignal, null);
    }

    public UploadOptions(Map<String, String> map, String str, boolean z, UpProgressHandler upProgressHandler, UpCancellationSignal upCancellationSignal, NetReadyHandler netReadyHandler) {
        int i;
        try {
            String str2 = map.get("netCheckTime");
            i = 6;
            if (str2 != null) {
                i = Integer.parseInt(str2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            i = 6;
        }
        this.params = filterParam(map);
        this.mimeType = mime(str);
        this.checkCrc = z;
        this.progressHandler = upProgressHandler == null ? new UpProgressHandler() { // from class: com.qiniu.android.storage.UploadOptions.1
            @Override // com.qiniu.android.storage.UpProgressHandler
            public void progress(String str3, double d) {
                Log.d("Qiniu.UploadProgress", "" + d);
            }
        } : upProgressHandler;
        this.cancellationSignal = upCancellationSignal == null ? new UpCancellationSignal() { // from class: com.qiniu.android.storage.UploadOptions.2
            @Override // com.qiniu.android.http.CancellationHandler
            public boolean isCancelled() {
                return false;
            }
        } : upCancellationSignal;
        if (netReadyHandler == null) {
            final int i2 = i;
            netReadyHandler = new NetReadyHandler() { // from class: com.qiniu.android.storage.UploadOptions.3
                @Override // com.qiniu.android.storage.NetReadyHandler
                public void waitReady() {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        return;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= i2) {
                            return;
                        }
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (AndroidNetwork.isNetWorkReady()) {
                            return;
                        }
                        i3 = i4 + 1;
                    }
                }
            };
        }
        this.netReadyHandler = netReadyHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UploadOptions defaultOptions() {
        return new UploadOptions(null, null, false, null, null);
    }

    private static Map<String, String> filterParam(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().startsWith("x:") && entry.getValue() != null && !entry.getValue().equals("")) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    private static String mime(String str) {
        return (str == null || str.equals("")) ? "application/octet-stream" : str;
    }
}
