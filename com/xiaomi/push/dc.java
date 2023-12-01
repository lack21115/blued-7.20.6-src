package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dc.class */
class dc {

    /* renamed from: a  reason: collision with root package name */
    private static String f41326a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private int f279a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f282a;

    /* renamed from: b  reason: collision with other field name */
    private String f283b;

    /* renamed from: c  reason: collision with root package name */
    private String f41327c;

    /* renamed from: a  reason: collision with other field name */
    private final SimpleDateFormat f280a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int b = 2097152;

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<File> f281a = new ArrayList<>();

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        int i;
        int i2;
        boolean z;
        int i3;
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z2 = false;
        while (true) {
            boolean z3 = z2;
            if (read == -1 || z3) {
                return;
            }
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i4 = 0;
            int i5 = 0;
            while (true) {
                i = i5;
                i2 = read;
                z = z3;
                if (i4 >= read) {
                    break;
                }
                i2 = read;
                z = z3;
                if (!matcher.find(i4)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f283b.length() + start);
                if (this.f282a) {
                    i3 = i;
                    if (substring.compareTo(this.f41327c) > 0) {
                        z = true;
                        i2 = start;
                        break;
                    }
                } else {
                    i3 = i;
                    if (substring.compareTo(this.f283b) >= 0) {
                        this.f282a = true;
                        i3 = start;
                    }
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f283b.length();
                }
                i4 = start + indexOf;
                i5 = i3;
            }
            if (this.f282a) {
                int i6 = i2 - i;
                this.f279a += i6;
                bufferedWriter.write(cArr, i, i6);
                if (z || this.f279a > this.b) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
            z2 = z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0285: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:85:0x0285 */
    private void a(File file) {
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        Throwable th;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        BufferedWriter bufferedWriter2;
        BufferedReader bufferedReader4;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedWriter bufferedWriter3 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                bufferedReader = null;
                bufferedReader2 = null;
                BufferedReader bufferedReader5 = null;
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("model :");
                    sb.append(Build.MODEL);
                    sb.append("; os :");
                    sb.append(Build.VERSION.INCREMENTAL);
                    sb.append("; uid :");
                    sb.append(com.xiaomi.push.service.bv.m12168a());
                    sb.append("; lng :");
                    sb.append(Locale.getDefault().toString());
                    sb.append("; sdk :48");
                    sb.append("; andver :");
                    sb.append(Build.VERSION.SDK_INT);
                    sb.append("\n");
                    bufferedWriter.write(sb.toString());
                    this.f279a = 0;
                    Iterator<File> it = this.f281a.iterator();
                    BufferedReader bufferedReader6 = null;
                    while (it.hasNext()) {
                        BufferedReader bufferedReader7 = bufferedReader6;
                        bufferedReader6 = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader6, bufferedWriter, compile);
                            bufferedReader6.close();
                        } catch (FileNotFoundException e) {
                            bufferedReader3 = bufferedReader6;
                            e = e;
                            bufferedWriter2 = bufferedWriter;
                            e = e;
                            StringBuilder sb2 = new StringBuilder("LOG: filter error = ");
                            BufferedWriter bufferedWriter4 = bufferedWriter2;
                            sb2.append(e.getMessage());
                            BufferedWriter bufferedWriter5 = bufferedWriter2;
                            com.xiaomi.channel.commonutils.logger.b.c(sb2.toString());
                            x.a(bufferedWriter2);
                            x.a(bufferedReader3);
                            return;
                        } catch (IOException e2) {
                            bufferedReader2 = bufferedReader6;
                            e = e2;
                            bufferedWriter3 = bufferedWriter;
                            e = e;
                            StringBuilder sb3 = new StringBuilder("LOG: filter error = ");
                            BufferedWriter bufferedWriter6 = bufferedWriter3;
                            sb3.append(e.getMessage());
                            BufferedWriter bufferedWriter7 = bufferedWriter3;
                            com.xiaomi.channel.commonutils.logger.b.c(sb3.toString());
                            x.a(bufferedWriter3);
                            x.a(bufferedReader2);
                            return;
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader6;
                            th = th2;
                            th = th;
                            x.a(bufferedWriter);
                            x.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedReader = bufferedReader6;
                    bufferedReader2 = bufferedReader6;
                    bufferedReader5 = bufferedReader6;
                    bufferedWriter.write(ct.a().c());
                    x.a(bufferedWriter);
                    x.a(bufferedReader6);
                } catch (FileNotFoundException e3) {
                    e = e3;
                    bufferedReader3 = bufferedReader5;
                } catch (IOException e4) {
                    e = e4;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                bufferedReader3 = null;
                bufferedWriter2 = null;
            } catch (IOException e6) {
                e = e6;
                bufferedReader2 = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                bufferedWriter = null;
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = bufferedReader4;
            bufferedWriter = file;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    dc m11613a(File file) {
        if (file.exists()) {
            this.f281a.add(file);
        }
        return this;
    }

    dc a(Date date, Date date2) {
        String format;
        if (date.after(date2)) {
            this.f283b = this.f280a.format(date2);
            format = this.f280a.format(date);
        } else {
            this.f283b = this.f280a.format(date);
            format = this.f280a.format(date2);
        }
        this.f41327c = format;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        File file3;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            File file4 = new File(context.getExternalFilesDir(null), com.xiaomi.push.service.bk.N);
            File file5 = file4;
            if (!file4.exists()) {
                file5 = new File(context.getFilesDir(), com.xiaomi.push.service.bk.N);
            }
            file2 = file5;
            if (!file5.exists()) {
                file2 = context.getFilesDir();
            }
            m11613a(new File(file2, "xmsf.log.1"));
            file3 = new File(file2, "xmsf.log");
        } else {
            file2 = new File(context.getExternalFilesDir(null) + f41326a);
            m11613a(new File(file2, "log0.txt"));
            file3 = new File(file2, "log1.txt");
        }
        m11613a(file3);
        if (file2.isDirectory()) {
            File file6 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
            if (file6.exists()) {
                return null;
            }
            a(date, date2);
            long currentTimeMillis = System.currentTimeMillis();
            File file7 = new File(file, "log.txt");
            a(file7);
            com.xiaomi.channel.commonutils.logger.b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
            if (file7.exists()) {
                long currentTimeMillis2 = System.currentTimeMillis();
                x.a(file6, file7);
                com.xiaomi.channel.commonutils.logger.b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
                file7.delete();
                if (file6.exists()) {
                    return file6;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (i != 0) {
            this.b = i;
        }
    }
}
