package androidx.constraintlayout.core.motion.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Utils.class */
public class Utils {

    /* renamed from: a  reason: collision with root package name */
    static DebugHandle f2068a;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/Utils$DebugHandle.class */
    public interface DebugHandle {
        void message(String str);
    }

    private static int a(int i) {
        int i2 = (i & (i >> 31)) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String substring = (stackTraceElement.getMethodName() + "                  ").substring(0, 17);
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")" + "    ".substring(Integer.toString(stackTraceElement.getLineNumber()).length()) + substring;
        System.out.println(str2 + " " + str);
        DebugHandle debugHandle = f2068a;
        if (debugHandle != null) {
            debugHandle.message(str2 + " " + str);
        }
    }

    public static void log(String str, String str2) {
        PrintStream printStream = System.out;
        printStream.println(str + " : " + str2);
    }

    public static void logStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str2 = " ";
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > min) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            String str3 = ".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName();
            str2 = str2 + " ";
            System.out.println(str + str2 + str3 + str2);
            i2 = i3 + 1;
        }
    }

    public static void loge(String str, String str2) {
        PrintStream printStream = System.err;
        printStream.println(str + " : " + str2);
    }

    public static int rgbaTocColor(float f, float f2, float f3, float f4) {
        int a2 = a((int) (f * 255.0f));
        int a3 = a((int) (f2 * 255.0f));
        return (a2 << 16) | (a((int) (f4 * 255.0f)) << 24) | (a3 << 8) | a((int) (f3 * 255.0f));
    }

    public static void setDebugHandle(DebugHandle debugHandle) {
        f2068a = debugHandle;
    }

    public static void socketSend(String str) {
        try {
            OutputStream outputStream = new Socket("127.0.0.1", 5327).getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getInterpolatedColor(float[] fArr) {
        int a2 = a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
        int a3 = a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
        return (a((int) (fArr[3] * 255.0f)) << 24) | (a2 << 16) | (a3 << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }
}
