package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import com.tencent.smtt.sdk.TbsConfig;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/TbsLog.class */
public class TbsLog {
    public static final int TBSLOG_CODE_SDK_BASE = 1000;
    public static final int TBSLOG_CODE_SDK_CONFLICT_X5CORE = 993;
    public static final int TBSLOG_CODE_SDK_INIT = 999;
    public static final int TBSLOG_CODE_SDK_INVOKE_ERROR = 997;
    public static final int TBSLOG_CODE_SDK_LOAD_ERROR = 998;
    public static final int TBSLOG_CODE_SDK_NO_SHARE_X5CORE = 994;
    public static final int TBSLOG_CODE_SDK_SELF_MODE = 996;
    public static final int TBSLOG_CODE_SDK_THIRD_MODE = 995;
    public static final int TBSLOG_CODE_SDK_UNAVAIL_X5CORE = 992;
    public static final String X5LOGTAG = "x5logtag";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f38927a = false;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static TbsLogClient f38928c;
    public static List<String> sTbsLogList = new LinkedList();
    public static int sLogMaxCount = 10;

    public static void addLog(int i, String str, Object... objArr) {
        synchronized (sTbsLogList) {
            try {
                if (sTbsLogList.size() > sLogMaxCount) {
                    int size = sTbsLogList.size();
                    int i2 = sLogMaxCount;
                    while (true) {
                        int i3 = size - i2;
                        if (i3 <= 0 || sTbsLogList.size() <= 0) {
                            break;
                        }
                        sTbsLogList.remove(0);
                        size = i3;
                        i2 = 1;
                    }
                }
                String str2 = null;
                if (str != null) {
                    try {
                        str2 = String.format(str, objArr);
                    } catch (Exception e) {
                        str2 = null;
                    }
                }
                String str3 = str2;
                if (str2 == null) {
                    str3 = "";
                }
                sTbsLogList.add(String.format("[%d][%d][%c][%d]%s", Long.valueOf(System.currentTimeMillis()), 1, '0', Integer.valueOf(i), str3));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void app_extra(String str, Context context) {
        int i;
        try {
            Context applicationContext = context.getApplicationContext();
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= 6) {
                    break;
                } else if (applicationContext.getPackageName().contains(new String[]{TbsConfig.APP_DEMO, TbsConfig.APP_QB, "com.tencent.mm", "com.tencent.mobileqq", TbsConfig.APP_DEMO_TEST, "com.qzone"}[i])) {
                    i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:" + new String[]{"DEMO", "QB", "WX", "QQ", "TEST", "QZ"}[i] + "!");
                    break;
                } else {
                    i2 = i + 1;
                }
            }
            if (i == 6) {
                i(str, "app_extra pid:" + Process.myPid() + "; APP_TAG:OTHER!");
            }
        } catch (Throwable th) {
            w(str, "app_extra exception:" + Log.getStackTraceString(th));
        }
    }

    public static void d(String str, String str2) {
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.d(str, "TBS:" + str2);
    }

    public static void d(String str, String str2, boolean z) {
        d(str, str2);
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient != null && f38927a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void e(String str, String str2) {
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.e(str, "TBS:" + str2);
        TbsLogClient tbsLogClient2 = f38928c;
        tbsLogClient2.writeLog("(E)-" + str + "-TBS:" + str2);
    }

    public static void e(String str, String str2, boolean z) {
        e(str, str2);
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient != null && f38927a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static String getTbsLogFilePath() {
        if (TbsLogClient.f38930c != null) {
            return TbsLogClient.f38930c.getAbsolutePath();
        }
        return null;
    }

    public static void i(String str, String str2) {
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.i(str, "TBS:" + str2);
        TbsLogClient tbsLogClient2 = f38928c;
        tbsLogClient2.writeLog("(I)-" + str + "-TBS:" + str2);
    }

    public static void i(String str, String str2, boolean z) {
        i(str, str2);
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient != null && f38927a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void i(Throwable th) {
        i("handle_throwable", Log.getStackTraceString(th));
    }

    public static void initIfNeed(Context context) {
        synchronized (TbsLog.class) {
            try {
                if (f38928c == null) {
                    setTbsLogClient(new TbsLogClient(context));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setLogView(TextView textView) {
        TbsLogClient tbsLogClient;
        if (textView == null || (tbsLogClient = f38928c) == null) {
            return;
        }
        tbsLogClient.setLogView(textView);
    }

    public static boolean setTbsLogClient(TbsLogClient tbsLogClient) {
        if (tbsLogClient == null) {
            return false;
        }
        f38928c = tbsLogClient;
        TbsLogClient.setWriteLogJIT(b);
        return true;
    }

    public static void setWriteLogJIT(boolean z) {
        b = z;
        if (f38928c == null) {
            return;
        }
        TbsLogClient.setWriteLogJIT(z);
    }

    public static void v(String str, String str2) {
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.v(str, "TBS:" + str2);
    }

    public static void v(String str, String str2, boolean z) {
        v(str, str2);
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient != null && f38927a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void w(String str, String str2) {
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient == null) {
            return;
        }
        tbsLogClient.w(str, "TBS:" + str2);
        TbsLogClient tbsLogClient2 = f38928c;
        tbsLogClient2.writeLog("(W)-" + str + "-TBS:" + str2);
    }

    public static void w(String str, String str2, boolean z) {
        w(str, str2);
        TbsLogClient tbsLogClient = f38928c;
        if (tbsLogClient != null && f38927a && z) {
            tbsLogClient.showLog(str + ": " + str2);
        }
    }

    public static void writeLogToDisk() {
        synchronized (TbsLog.class) {
            try {
                if (f38928c != null) {
                    f38928c.writeLogToDisk();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
