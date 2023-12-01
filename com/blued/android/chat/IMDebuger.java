package com.blued.android.chat;

import android.text.TextUtils;
import com.blued.android.chat.core.pack.BasePackage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/IMDebuger.class */
public class IMDebuger {
    private static final int MAX_STATUS_SIZE = 20;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    private static final CopyOnWriteArrayList<String> socketStatusList = new CopyOnWriteArrayList<>();
    private static final AtomicBoolean existReceiveOk = new AtomicBoolean(false);
    private static final AtomicBoolean existSendOk = new AtomicBoolean(false);
    private static volatile String socketStatus = null;
    private static volatile String imStatus = null;
    private static String lastPackageType = null;
    private static long lastPackageTimeMs = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.chat.IMDebuger$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/IMDebuger$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[SocketStatus.values().length];
            $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus = iArr;
            try {
                iArr[SocketStatus.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[SocketStatus.DNS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[SocketStatus.DIRECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[SocketStatus.CREATE_SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[SocketStatus.CREATE_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[SocketStatus.SEND_OK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[SocketStatus.RECEIVE_OK.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/IMDebuger$SocketStatus.class */
    public enum SocketStatus {
        CONNECTING,
        DNS,
        DIRECT,
        CREATE_SUCCESS,
        CREATE_FAILED,
        SEND_OK,
        RECEIVE_OK
    }

    public static String getIMInformation() {
        return imStatus + ", " + socketStatus;
    }

    public static String getLastReceivePackageInfo() {
        if (TextUtils.isEmpty(lastPackageType) || lastPackageTimeMs == 0) {
            return "No Package";
        }
        long currentTimeMillis = (System.currentTimeMillis() - lastPackageTimeMs) / 1000;
        return lastPackageType + ", " + currentTimeMillis + " seconds ago";
    }

    public static String getSocketDetail() {
        String sb;
        synchronized (IMDebuger.class) {
            try {
                StringBuilder sb2 = new StringBuilder();
                int size = socketStatusList.size();
                while (true) {
                    int i = size - 1;
                    if (i >= 0) {
                        sb2.append(socketStatusList.get(i));
                        sb2.append("\n");
                        size = i;
                    } else {
                        sb = sb2.toString();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sb;
    }

    private static String getSocketStatusText(SocketStatus socketStatus2) {
        switch (AnonymousClass1.$SwitchMap$com$blued$android$chat$IMDebuger$SocketStatus[socketStatus2.ordinal()]) {
            case 1:
                return "socket running ";
            case 2:
                return "socket dns ok";
            case 3:
                return "socket direct connect";
            case 4:
                return "socket created";
            case 5:
                return "socket create failed";
            case 6:
                return "socket send stream ok";
            case 7:
                return "socket receive stream ok";
            default:
                return "";
        }
    }

    public static void setImStatus(String str) {
        imStatus = str;
    }

    public static void setLastReceivePackage(BasePackage basePackage) {
        if (basePackage != null) {
            lastPackageType = BasePackage.typeToString(basePackage);
            lastPackageTimeMs = System.currentTimeMillis();
        }
    }

    public static void setSocketStatus(SocketStatus socketStatus2) {
        synchronized (IMDebuger.class) {
            try {
                setSocketStatus(socketStatus2, "");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setSocketStatus(SocketStatus socketStatus2, String str) {
        synchronized (IMDebuger.class) {
            try {
                if (socketStatus2 == SocketStatus.RECEIVE_OK) {
                    if (existReceiveOk.get()) {
                        return;
                    }
                    existReceiveOk.set(true);
                } else if (socketStatus2 == SocketStatus.SEND_OK) {
                    if (existSendOk.get()) {
                        return;
                    }
                    existSendOk.set(true);
                }
                if (socketStatusList.size() > 20) {
                    socketStatusList.remove(0);
                }
                socketStatus = getSocketStatusText(socketStatus2) + " " + str;
                String str2 = "[" + dateFormat.format(new Date()) + "] " + socketStatus;
                String str3 = str2;
                if (socketStatus2 == SocketStatus.CONNECTING) {
                    str3 = str2 + "\n      --------------------------\n";
                    existReceiveOk.set(false);
                    existSendOk.set(false);
                }
                socketStatusList.add(str3);
            } finally {
            }
        }
    }
}
