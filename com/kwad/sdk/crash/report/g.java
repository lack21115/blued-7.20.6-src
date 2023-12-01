package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.model.message.MemoryInfo;
import com.kwad.sdk.crash.model.message.NativeExceptionMessage;
import com.kwad.sdk.crash.model.message.ThreadInfo;
import com.kwad.sdk.utils.q;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/g.class */
public final class g extends d {
    public static final Pattern asy = Pattern.compile("(.*)\\s\\(tid=(\\d+), index=(\\d+)*");
    public static final Pattern asz = Pattern.compile("\\sd+\\spc");

    private void a(NativeExceptionMessage nativeExceptionMessage, File file) {
        nativeExceptionMessage.mLogUUID = com.kwad.sdk.crash.utils.g.dW(file.getName());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        boolean z = false;
        boolean z2 = false;
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z && readLine.startsWith("backtrace:")) {
                        z = false;
                        z2 = true;
                    } else if (z2) {
                        if (readLine.startsWith("###### ending of java stack trace ######")) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append('\n');
                    } else if (z) {
                        a(nativeExceptionMessage, readLine, sb2);
                    } else if (readLine.startsWith("*** ***")) {
                        z = true;
                    }
                } catch (IOException e) {
                    this.mErrorMessage += e + "\n";
                }
            } finally {
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            }
        }
        if (sb.length() > 1) {
            nativeExceptionMessage.mCrashDetail = sb.substring(0, sb.length() - 1);
        }
        if (sb2.length() > 1) {
            nativeExceptionMessage.mRegister = sb2.substring(0, sb2.length() - 1);
        }
    }

    private static void a(NativeExceptionMessage nativeExceptionMessage, String str, StringBuilder sb) {
        int i;
        int i2;
        if (str.startsWith("Build fingerprint: ")) {
            nativeExceptionMessage.mFingerprint = str.substring(19);
        } else if (str.startsWith("Revision: ")) {
            nativeExceptionMessage.mRevision = str.substring(10);
        } else if (str.startsWith("ABI: ")) {
            nativeExceptionMessage.mAbi = str.substring(5);
        } else if (str.startsWith("Current UTC: ")) {
            nativeExceptionMessage.mCurrentTimeStamp = Long.parseLong(str.substring(13));
        } else if (str.startsWith("Abort message: ")) {
            nativeExceptionMessage.mAbortMsg = str.substring(15);
        } else if (str.startsWith("    r") || str.startsWith("    ip") || str.startsWith("    x") || str.startsWith("    sp")) {
            sb.append(str);
            sb.append('\n');
        } else if (!str.startsWith("pid: ")) {
            if (str.startsWith("signal ")) {
                String[] split = str.split("\\s+");
                if (split.length >= 9) {
                    nativeExceptionMessage.mSignal = com.kwad.sdk.crash.utils.g.dX(split[2]);
                    nativeExceptionMessage.mCode = com.kwad.sdk.crash.utils.g.dX(split[5]);
                    nativeExceptionMessage.mFaultAddr = split[split.length - 1];
                    nativeExceptionMessage.mManuallyKill = "--------".equals(split[split.length - 1]) ? "True" : "False";
                }
            }
        } else {
            String[] split2 = str.split("\\s+");
            if (split2.length < 9) {
                return;
            }
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < split2.length) {
                if ("name:".equals(split2[i3])) {
                    i = i3;
                    i2 = i5;
                } else if (">>>".equals(split2[i3])) {
                    i2 = i3;
                    i = i4;
                } else {
                    i = i4;
                    i2 = i5;
                    if ("<<<".equals(split2[i3])) {
                        i6 = i3;
                        i2 = i5;
                        i = i4;
                    }
                }
                i3++;
                i4 = i;
                i5 = i2;
            }
            StringBuilder sb2 = new StringBuilder();
            int i7 = i4 + 1;
            String str2 = split2[i7];
            while (true) {
                sb2.append(str2);
                i7++;
                if (i7 >= i5) {
                    break;
                }
                sb2.append(" ");
                str2 = split2[i7];
            }
            nativeExceptionMessage.mThreadName = sb2.toString();
            sb2.setLength(0);
            int i8 = i5 + 1;
            String str3 = split2[i8];
            while (true) {
                sb2.append(str3);
                i8++;
                if (i8 >= i6) {
                    nativeExceptionMessage.mProcessName = sb2.toString();
                    return;
                } else {
                    sb2.append(" ");
                    str3 = split2[i8];
                }
            }
        }
    }

    private static void c(File file, ExceptionMessage exceptionMessage) {
        try {
            MemoryInfo memoryInfo = new MemoryInfo(exceptionMessage.mMemoryInfo);
            ArrayList arrayList = new ArrayList();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            try {
                ThreadInfo threadInfo = new ThreadInfo();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.isEmpty()) {
                        arrayList.add(threadInfo);
                        threadInfo = new ThreadInfo();
                    } else if (asz.matcher(readLine).matches()) {
                        if (threadInfo.mTrace != null) {
                            readLine = threadInfo.mTrace + readLine;
                        }
                        threadInfo.mTrace = readLine;
                        threadInfo.mTrace += "\n";
                    } else {
                        Matcher matcher = asy.matcher(readLine);
                        if (matcher.lookingAt()) {
                            threadInfo.mName = matcher.group(1);
                            threadInfo.mTid = Integer.parseInt(matcher.group(2));
                            threadInfo.mIndex = Integer.parseInt(matcher.group(3));
                        }
                    }
                }
                memoryInfo.mNativeThreads = arrayList;
                exceptionMessage.mMemoryInfo = memoryInfo.toJson().toString();
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    private NativeExceptionMessage y(File file) {
        String str;
        try {
            str = q.Q(file);
        } catch (IOException e) {
            this.mErrorMessage += e + "\n";
            str = null;
        }
        NativeExceptionMessage nativeExceptionMessage = new NativeExceptionMessage();
        if (str != null) {
            try {
                nativeExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e2) {
                this.mErrorMessage += e2 + "\n";
            }
        }
        q.N(file);
        return nativeExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(File file, File file2, File file3, String str) {
        File file4 = new File(str + ".jtrace");
        NativeExceptionMessage y = y(file2);
        try {
            a(y, file);
            b(file3, y);
            a(file4, y);
            c(new File(str + ".ntrace"), y);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) y.toString(), true);
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ Native Crash Report Begin ------\n").append(y);
            y.mDumpsys = q.Q(new File(str + ".minfo"));
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
            this.mErrorMessage += e + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            y.mErrorMessage += this.mErrorMessage;
        }
        return y;
    }
}
