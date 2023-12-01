package com.anythink.core.common.j;

import android.content.Context;
import com.anythink.core.api.AdError;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.g.a.c;
import com.anythink.core.common.g.i;
import com.anythink.core.common.k.p;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/j/b.class */
public class b {
    private static volatile b b;
    private Context h;
    private File i;
    private AtomicInteger j;

    /* renamed from: a  reason: collision with root package name */
    private final String f6766a = "Agent";

    /* renamed from: c  reason: collision with root package name */
    private int f6767c = 5;
    private int d = 10;
    private long e = 1800000;
    private String f = "";
    private String g = "";
    private boolean k = false;
    private String l = "";
    private i m = new i() { // from class: com.anythink.core.common.j.b.1
        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i) {
            b.this.k = false;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i, String str, AdError adError) {
            b.this.k = false;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadFinish(int i, Object obj) {
            b.this.a(((Integer) obj).intValue());
            b.this.k = false;
            p.a(b.this.h, g.o, "LOG_SEND_TIME", System.currentTimeMillis());
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i) {
        }
    };
    private c.a n = new c.a() { // from class: com.anythink.core.common.j.b.2
        @Override // com.anythink.core.common.g.a.c.a
        public final void a(Object obj) {
            if (obj instanceof com.anythink.core.common.g.a.a) {
                b.this.a(((com.anythink.core.common.g.a.a) obj).b());
                b.this.k = false;
                p.a(b.this.h, g.o, "LOG_SEND_TIME", System.currentTimeMillis());
            }
        }

        @Override // com.anythink.core.common.g.a.c.a
        public final void a(Throwable th) {
            b.this.k = false;
        }
    };
    private Object o = new Object();

    private b() {
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        BufferedReader bufferedReader;
        File file;
        synchronized (this) {
            try {
                try {
                    file = new File(this.g);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    bufferedReader = new BufferedReader(new FileReader(this.i));
                } catch (Error e) {
                    bufferedReader = null;
                } catch (Exception e2) {
                    bufferedReader = null;
                } catch (Throwable th) {
                    bufferedReader = null;
                }
            } catch (OutOfMemoryError | StackOverflowError e3) {
                bufferedReader = null;
            }
            try {
                try {
                    FileWriter fileWriter = new FileWriter(file);
                    int i2 = 0;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        int i3 = i2 + 1;
                        i2 = i3;
                        if (i3 > i) {
                            fileWriter.append((CharSequence) readLine);
                            fileWriter.append((CharSequence) "\n");
                            i2 = i3;
                        }
                    }
                    fileWriter.flush();
                    fileWriter.close();
                    bufferedReader.close();
                    this.j.set(this.j.get() - i < 0 ? 0 : this.j.get() - i);
                    this.i.delete();
                    file.renameTo(this.i);
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                } catch (Error e5) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (Exception e7) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                        }
                    }
                } catch (Throwable th2) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                        }
                    }
                }
            } catch (OutOfMemoryError | StackOverflowError e10) {
                System.gc();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e11) {
                    }
                }
            }
        }
    }

    private void a(boolean z) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        BufferedReader bufferedReader3;
        String readLine;
        synchronized (this) {
            if (this.h == null) {
                return;
            }
            if (this.k || (!z && (this.j == null || this.j.get() < this.f6767c))) {
                return;
            }
            this.k = true;
            BufferedReader bufferedReader4 = null;
            try {
                bufferedReader3 = new BufferedReader(new FileReader(this.i));
            } catch (Exception e) {
                bufferedReader2 = null;
            } catch (OutOfMemoryError | StackOverflowError e2) {
                bufferedReader = null;
            } catch (Throwable th) {
            }
            try {
                try {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.d || (readLine = bufferedReader3.readLine()) == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i = i2 + 1;
                    }
                    com.anythink.core.c.a b2 = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                    if (b2 == null) {
                        new com.anythink.core.common.g.b(this.h, 0, arrayList).a(0, this.m);
                    } else if (b2.u() != 1) {
                        new com.anythink.core.common.g.b(this.h, b2.u(), arrayList).a(0, this.m);
                    } else {
                        com.anythink.core.common.g.a.a aVar = new com.anythink.core.common.g.a.a(arrayList);
                        aVar.a(1, b2.t());
                        aVar.a(this.n);
                    }
                    try {
                        bufferedReader3.close();
                    } catch (Exception e3) {
                    }
                } catch (Exception e4) {
                    bufferedReader2 = bufferedReader3;
                    this.k = false;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e5) {
                        }
                    }
                } catch (Throwable th2) {
                    bufferedReader4 = bufferedReader3;
                    this.k = false;
                    if (bufferedReader4 != null) {
                        try {
                            bufferedReader4.close();
                        } catch (Exception e6) {
                        }
                    }
                }
            } catch (OutOfMemoryError | StackOverflowError e7) {
                bufferedReader = bufferedReader3;
                this.k = false;
                BufferedReader bufferedReader5 = bufferedReader;
                System.gc();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e8) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0165 A[Catch: Exception -> 0x0236, OutOfMemoryError | StackOverflowError -> 0x023a, Error -> 0x023e, all -> 0x0256, TryCatch #1 {Error -> 0x023e, blocks: (B:10:0x0029, B:11:0x002c, B:13:0x00b1, B:15:0x00cc, B:17:0x00d8, B:19:0x00e1, B:30:0x0139, B:45:0x015f, B:47:0x0165, B:49:0x0172, B:51:0x0187, B:54:0x0195, B:56:0x01a9, B:59:0x01b7, B:57:0x01b1, B:52:0x018f, B:38:0x014f, B:40:0x0155, B:43:0x015a), top: B:110:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0187 A[Catch: Exception -> 0x0236, OutOfMemoryError | StackOverflowError -> 0x023a, OutOfMemoryError | StackOverflowError -> 0x023a, Error -> 0x023e, all -> 0x0256, TRY_LEAVE, TryCatch #1 {Error -> 0x023e, blocks: (B:10:0x0029, B:11:0x002c, B:13:0x00b1, B:15:0x00cc, B:17:0x00d8, B:19:0x00e1, B:30:0x0139, B:45:0x015f, B:47:0x0165, B:49:0x0172, B:51:0x0187, B:54:0x0195, B:56:0x01a9, B:59:0x01b7, B:57:0x01b1, B:52:0x018f, B:38:0x014f, B:40:0x0155, B:43:0x015a), top: B:110:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018f A[Catch: Exception -> 0x0236, OutOfMemoryError | StackOverflowError -> 0x023a, OutOfMemoryError | StackOverflowError -> 0x023a, Error -> 0x023e, all -> 0x0256, TRY_ENTER, TryCatch #1 {Error -> 0x023e, blocks: (B:10:0x0029, B:11:0x002c, B:13:0x00b1, B:15:0x00cc, B:17:0x00d8, B:19:0x00e1, B:30:0x0139, B:45:0x015f, B:47:0x0165, B:49:0x0172, B:51:0x0187, B:54:0x0195, B:56:0x01a9, B:59:0x01b7, B:57:0x01b1, B:52:0x018f, B:38:0x014f, B:40:0x0155, B:43:0x015a), top: B:110:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a9 A[Catch: Exception -> 0x0236, OutOfMemoryError | StackOverflowError -> 0x023a, OutOfMemoryError | StackOverflowError -> 0x023a, Error -> 0x023e, all -> 0x0256, TRY_LEAVE, TryCatch #1 {Error -> 0x023e, blocks: (B:10:0x0029, B:11:0x002c, B:13:0x00b1, B:15:0x00cc, B:17:0x00d8, B:19:0x00e1, B:30:0x0139, B:45:0x015f, B:47:0x0165, B:49:0x0172, B:51:0x0187, B:54:0x0195, B:56:0x01a9, B:59:0x01b7, B:57:0x01b1, B:52:0x018f, B:38:0x014f, B:40:0x0155, B:43:0x015a), top: B:110:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b1 A[Catch: Exception -> 0x0236, OutOfMemoryError | StackOverflowError -> 0x023a, OutOfMemoryError | StackOverflowError -> 0x023a, Error -> 0x023e, all -> 0x0256, TRY_ENTER, TryCatch #1 {Error -> 0x023e, blocks: (B:10:0x0029, B:11:0x002c, B:13:0x00b1, B:15:0x00cc, B:17:0x00d8, B:19:0x00e1, B:30:0x0139, B:45:0x015f, B:47:0x0165, B:49:0x0172, B:51:0x0187, B:54:0x0195, B:56:0x01a9, B:59:0x01b7, B:57:0x01b1, B:52:0x018f, B:38:0x014f, B:40:0x0155, B:43:0x015a), top: B:110:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c6 A[Catch: all -> 0x0230, TryCatch #11 {, blocks: (B:4:0x0009, B:9:0x0017, B:10:0x0029, B:61:0x01c0, B:63:0x01c6, B:65:0x01d0, B:84:0x022a, B:80:0x0216, B:82:0x021c, B:71:0x01ee, B:73:0x01f4, B:66:0x01d7, B:68:0x01de, B:87:0x022e, B:11:0x002c, B:13:0x00b1, B:15:0x00cc, B:17:0x00d8, B:19:0x00e1, B:30:0x0139, B:45:0x015f, B:47:0x0165, B:49:0x0172, B:51:0x0187, B:54:0x0195, B:56:0x01a9, B:59:0x01b7, B:57:0x01b1, B:52:0x018f, B:38:0x014f, B:40:0x0155, B:43:0x015a, B:69:0x01ea), top: B:116:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.b.a(android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a4, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b2, code lost:
        if (r6 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0117, code lost:
        if (r6 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011e, code lost:
        if (r6 == null) goto L28;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Error] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00f5 -> B:75:0x00c4). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.core.common.e.h r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.b.a(com.anythink.core.common.e.h, boolean):void");
    }

    public final void b() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.b.3
            /* JADX WARN: Code restructure failed: missing block: B:60:0x01a9, code lost:
                if (r11 == null) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:61:0x01ac, code lost:
                r11.close();
                r10 = r10;
             */
            /* JADX WARN: Code restructure failed: missing block: B:66:0x01ca, code lost:
                if (r11 == null) goto L58;
             */
            /* JADX WARN: Code restructure failed: missing block: B:70:0x01df, code lost:
                if (r11 == null) goto L58;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 565
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.b.AnonymousClass3.run():void");
            }
        });
    }
}
