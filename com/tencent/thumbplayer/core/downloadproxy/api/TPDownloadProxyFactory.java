package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.anythink.expressad.foundation.g.b.b;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/api/TPDownloadProxyFactory.class */
public class TPDownloadProxyFactory {
    private static final String FILE_NAME = "TPDownloadProxyFactory";
    private static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
    private static Object mMapObject = new Object();
    private static HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap = new HashMap<>();
    private static HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap = new HashMap<>();
    private static boolean mUseService = false;
    private static boolean mCanUseAIDL = false;
    private static boolean mIsReadyForDownload = false;
    private static TPDLProxyBindServiceCallback mCallback = null;
    private static ServiceConnection mConnection = new ServiceConnection() { // from class: com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = TPDownloadProxyFactoryAidl.Stub.asInterface(iBinder);
            try {
                for (Map.Entry entry : TPDownloadProxyFactory.mvTPDownloadProxyClientMap.entrySet()) {
                    ((TPDownloadProxyClient) entry.getValue()).updateAidl(TPDownloadProxyFactory.downloadProxyFactoryAidl.getTPDownloadProxy(((Integer) entry.getKey()).intValue()));
                }
            } catch (Throwable th) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onServiceConnected failed, error:" + th.toString());
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected!");
            if (TPDownloadProxyFactory.downloadProxyFactoryAidl == null) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl is null!");
                return;
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl not null!");
            TPDownloadProxyFactory.setCanUseAIDL(true);
            if (TPDownloadProxyFactory.mCallback != null) {
                TPDownloadProxyFactory.mCallback.onBindSuccess();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service disconnected");
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = null;
            TPDownloadProxyFactory.setCanUseAIDL(false);
            TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.mCallback);
        }
    };

    public static boolean canUseService() {
        synchronized (TPDownloadProxyFactory.class) {
            try {
                if (mUseService) {
                    if (mCanUseAIDL) {
                        if (downloadProxyFactoryAidl != null) {
                            downloadProxyFactoryAidl.isReadyForPlay();
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback tPDLProxyBindServiceCallback) {
        Context context = TPDownloadProxyHelper.getContext();
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService get context null!");
            return false;
        }
        mCallback = tPDLProxyBindServiceCallback;
        StringBuilder sb = new StringBuilder("ensurePlayManagerService ");
        sb.append(context == null ? b.f4996a : com.igexin.push.core.b.x);
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, sb.toString());
        try {
            Intent intent = new Intent(context, TPDownloadProxyService.class);
            context.startService(intent);
            if (context.bindService(intent, mConnection, 1)) {
                return true;
            }
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService bind service failed!");
            return true;
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService failed, error:" + th.toString());
            return false;
        }
    }

    public static boolean getCanUseAIDL() {
        boolean z;
        synchronized (TPDownloadProxyFactory.class) {
            try {
                z = mCanUseAIDL;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static String getNativeVersion() {
        if (mUseService && mCanUseAIDL) {
            TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
            if (tPDownloadProxyFactoryAidl != null) {
                try {
                    return tPDownloadProxyFactoryAidl.getNativeVersion();
                } catch (Throwable th) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeVersion failed, error:" + th.toString());
                }
            }
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        }
        return TPDownloadProxyNative.getInstance().getNativeVersion();
    }

    public static ITPDownloadProxy getTPDownloadProxy(int i) {
        TPDownloadProxy tPDownloadProxy;
        if (i <= 0) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy is invalid, serviceType:".concat(String.valueOf(i)));
            return null;
        } else if (!mUseService) {
            synchronized (mMapObject) {
                ITPDownloadProxy iTPDownloadProxy = mvTPDownloadProxyMap.get(Integer.valueOf(i));
                tPDownloadProxy = iTPDownloadProxy;
                if (iTPDownloadProxy == null) {
                    tPDownloadProxy = new TPDownloadProxy(i);
                    mvTPDownloadProxyMap.put(Integer.valueOf(i), tPDownloadProxy);
                }
            }
            return tPDownloadProxy;
        } else if (!mCanUseAIDL) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy failed, can't use aidl!");
            return null;
        } else {
            try {
                return getTPDownloadProxyService(i);
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy failed, error:" + th.toString());
                return null;
            }
        }
    }

    private static ITPDownloadProxy getTPDownloadProxyService(int i) {
        TPDownloadProxyClient tPDownloadProxyClient;
        synchronized (TPDownloadProxyFactory.class) {
            try {
                if (downloadProxyFactoryAidl == null) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, aidl is null!");
                    return null;
                }
                synchronized (mvTPDownloadProxyClientMap) {
                    TPDownloadProxyClient tPDownloadProxyClient2 = mvTPDownloadProxyClientMap.get(Integer.valueOf(i));
                    tPDownloadProxyClient = tPDownloadProxyClient2;
                    if (tPDownloadProxyClient2 == null) {
                        try {
                            tPDownloadProxyClient = new TPDownloadProxyClient(downloadProxyFactoryAidl.getTPDownloadProxy(i));
                        } catch (Throwable th) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, error:" + th.toString());
                            tPDownloadProxyClient = tPDownloadProxyClient2;
                        }
                    }
                    mvTPDownloadProxyClientMap.put(Integer.valueOf(i), tPDownloadProxyClient);
                }
                return tPDownloadProxyClient;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean getUseService() {
        return mUseService;
    }

    public static boolean isReadyForDownload() {
        synchronized (TPDownloadProxyFactory.class) {
            try {
                if (!mUseService) {
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload ret:" + mIsReadyForDownload);
                    return mIsReadyForDownload;
                } else if (mCanUseAIDL) {
                    boolean z = false;
                    if (downloadProxyFactoryAidl != null) {
                        z = downloadProxyFactoryAidl.isReadyForDownload();
                    }
                    return z;
                } else {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isReadyForPlay() {
        synchronized (TPDownloadProxyFactory.class) {
            try {
                if (!mUseService) {
                    boolean isReadyForWork = TPDownloadProxyNative.getInstance().isReadyForWork();
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay ret:".concat(String.valueOf(isReadyForWork)));
                    return isReadyForWork;
                } else if (mCanUseAIDL) {
                    boolean z = false;
                    if (downloadProxyFactoryAidl != null) {
                        z = downloadProxyFactoryAidl.isReadyForPlay();
                    }
                    return z;
                } else {
                    return false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setCanUseAIDL(boolean z) {
        synchronized (TPDownloadProxyFactory.class) {
            try {
                mCanUseAIDL = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setReadyForDownload(boolean z) {
        synchronized (TPDownloadProxyFactory.class) {
            try {
                mIsReadyForDownload = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setUseService(boolean z) {
        mUseService = z;
    }
}
