package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.os.Process;
import android.widget.TextView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/TbsLogClient.class */
public class TbsLogClient {

    /* renamed from: a  reason: collision with root package name */
    static TbsLogClient f38929a;

    /* renamed from: c  reason: collision with root package name */
    static File f38930c;
    static String d;
    static byte[] e;
    private static boolean i = true;
    TextView b;
    private SimpleDateFormat f;
    private Context g;
    private StringBuffer h = new StringBuffer();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/TbsLogClient$a.class */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        String f38931a;

        a(String str) {
            this.f38931a = null;
            this.f38931a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TbsLogClient.this.b != null) {
                TextView textView = TbsLogClient.this.b;
                textView.append(this.f38931a + "\n");
            }
        }
    }

    public TbsLogClient(Context context) {
        this.f = null;
        this.g = null;
        try {
            this.g = context.getApplicationContext();
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS", Locale.US);
        } catch (Exception e2) {
            this.f = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss.SSS");
        }
    }

    private void a() {
        String a2;
        try {
            if (f38930c == null) {
                if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) || (a2 = FileUtil.a(this.g, 6)) == null) {
                    f38930c = null;
                    return;
                }
                f38930c = new File(a2, "tbslog.txt");
                d = LogFileUtils.createKey();
                e = LogFileUtils.createHeaderText(f38930c.getName(), d);
            }
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        } catch (SecurityException e3) {
            e3.printStackTrace();
        }
    }

    public static void setWriteLogJIT(boolean z) {
        i = z;
    }

    public void d(String str, String str2) {
    }

    public void e(String str, String str2) {
    }

    public void i(String str, String str2) {
    }

    public void setLogView(TextView textView) {
        this.b = textView;
    }

    public void showLog(String str) {
        TextView textView = this.b;
        if (textView != null) {
            textView.post(new a(str));
        }
    }

    public void v(String str, String str2) {
    }

    public void w(String str, String str2) {
    }

    public void writeLog(String str) {
        try {
            String format = this.f.format(Long.valueOf(System.currentTimeMillis()));
            StringBuffer stringBuffer = this.h;
            stringBuffer.append(format);
            stringBuffer.append(" pid=");
            stringBuffer.append(Process.myPid());
            stringBuffer.append(" tid=");
            stringBuffer.append(Process.myTid());
            stringBuffer.append(str);
            stringBuffer.append("\n");
            if (Thread.currentThread() != Looper.getMainLooper().getThread() || i) {
                writeLogToDisk();
            }
            if (this.h.length() > 524288) {
                this.h.delete(0, this.h.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void writeLogToDisk() {
        try {
            a();
            if (f38930c != null) {
                LogFileUtils.writeDataToStorage(f38930c, d, e, this.h.toString(), true);
                this.h.delete(0, this.h.length());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
