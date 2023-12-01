package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/anr/TraceFileHelper.class */
public class TraceFileHelper {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public long f21457a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public long f21458c;
        public Map<String, String[]> d;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$b.class */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return stringBuffer.toString();
            }
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
            i = i2 + 1;
        }
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader == null || patternArr == null) {
            return null;
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            int length = patternArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    Pattern pattern = patternArr[i2];
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            x.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                x.c("process end %d", Long.valueOf(j));
                return false;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, String str2) {
                x.c("new process %s", str2);
                a.this.f21457a = j;
                a.this.b = str2;
                a.this.f21458c = j2;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i, String str3, String str4) {
                x.c("new thread %s", str2);
                if (a.this.d == null) {
                    a.this.d = new HashMap();
                }
                Map<String, String[]> map = a.this.d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str2, new String[]{str3, str4, sb.toString()});
                return true;
            }
        });
        if (aVar.f21457a <= 0 || aVar.f21458c <= 0 || aVar.b == null) {
            x.e("first dump error %s", aVar.f21457a + " " + aVar.f21458c + " " + aVar.b);
            return null;
        }
        return aVar;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str == null || str2 == null) {
            return null;
        }
        final a aVar = new a();
        readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j) {
                x.c("process end %d", Long.valueOf(j));
                return a.this.f21457a <= 0 || a.this.f21458c <= 0 || a.this.b == null;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j, long j2, String str3) {
                x.c("new process %s", str3);
                if (str3.equals(str)) {
                    a.this.f21457a = j;
                    a.this.b = str3;
                    a.this.f21458c = j2;
                    return z;
                }
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str3, int i, String str4, String str5) {
                x.c("new thread %s", str3);
                if (a.this.f21457a <= 0 || a.this.f21458c <= 0 || a.this.b == null) {
                    return true;
                }
                if (a.this.d == null) {
                    a.this.d = new HashMap();
                }
                Map<String, String[]> map = a.this.d;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.put(str3, new String[]{str4, str5, sb.toString()});
                return true;
            }
        });
        if (aVar.f21457a <= 0 || aVar.f21458c <= 0 || aVar.b == null) {
            return null;
        }
        return aVar;
    }

    public static void readTraceFile(String str, b bVar) {
        BufferedReader bufferedReader;
        String[] split;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Object[] a2 = a(bufferedReader3, compile);
                        if (a2 == null) {
                            try {
                                bufferedReader3.close();
                                return;
                            } catch (IOException e) {
                                if (x.a(e)) {
                                    return;
                                }
                                e.printStackTrace();
                                return;
                            }
                        }
                        long parseLong = Long.parseLong(a2[1].toString().split("\\s")[2]);
                        long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                        Object[] a3 = a(bufferedReader3, compile3);
                        if (a3 == null) {
                            try {
                                bufferedReader3.close();
                                return;
                            } catch (IOException e2) {
                                if (x.a(e2)) {
                                    return;
                                }
                                e2.printStackTrace();
                                return;
                            }
                        }
                        Matcher matcher = compile3.matcher(a3[1].toString());
                        matcher.find();
                        matcher.group(1);
                        if (!bVar.a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader3.close();
                                return;
                            } catch (IOException e3) {
                                if (x.a(e3)) {
                                    return;
                                }
                                e3.printStackTrace();
                                return;
                            }
                        }
                        while (true) {
                            Object[] a4 = a(bufferedReader3, compile4, compile2);
                            if (a4 == null) {
                                break;
                            } else if (a4[0] == compile4) {
                                String obj = a4[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader3), b(bufferedReader3));
                            } else if (!bVar.a(Long.parseLong(a4[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader3.close();
                                    return;
                                } catch (IOException e4) {
                                    if (x.a(e4)) {
                                        return;
                                    }
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception e5) {
                    bufferedReader = bufferedReader3;
                    e = e5;
                    if (!x.a(e)) {
                        BufferedReader bufferedReader4 = bufferedReader;
                        e.printStackTrace();
                    }
                    BufferedReader bufferedReader5 = bufferedReader;
                    String name = e.getClass().getName();
                    BufferedReader bufferedReader6 = bufferedReader;
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader7 = bufferedReader;
                    sb.append(e.getMessage());
                    bufferedReader2 = bufferedReader;
                    x.d("trace open fail:%s : %s", name, sb.toString());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            if (x.a(e6)) {
                                return;
                            }
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader3;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e7) {
                            if (!x.a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e8) {
            e = e8;
            bufferedReader = null;
        }
    }
}
