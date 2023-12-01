package com.opos.mobad.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.opos.cmn.i.c;
import com.opos.mobad.c.a;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/c.class */
public class c implements com.opos.mobad.c.a {

    /* renamed from: a  reason: collision with root package name */
    private f f12286a;
    private LruCache<String, Buffer> b;

    /* renamed from: c  reason: collision with root package name */
    private LruCache<String, WeakReference<Buffer>> f12287c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this(new g(context));
    }

    c(f fVar) {
        this.f12286a = fVar;
        this.f12287c = new LruCache<>(50);
        this.b = new com.opos.cmn.i.c(20, new c.a<String, Buffer>() { // from class: com.opos.mobad.d.c.1
            @Override // com.opos.cmn.i.c.a
            public void a(String str, Buffer buffer) {
                c.this.f12287c.put(str, new WeakReference(buffer));
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
        if (r0 > r5) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(android.graphics.BitmapFactory.Options r4, int r5, int r6) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.c.a(android.graphics.BitmapFactory$Options, int, int):int");
    }

    public static Bitmap a(InputStream inputStream) {
        Bitmap bitmap = null;
        if (inputStream != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                bitmap = BitmapFactory.decodeStream(inputStream, null, options);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("fCache", "", e);
                bitmap = null;
            }
        }
        com.opos.cmn.an.f.a.b("fCache", "decodeSampledBitmapFromStream res=" + inputStream + ",dst:" + bitmap);
        return bitmap;
    }

    public static Bitmap a(Buffer buffer, int i, int i2) {
        Bitmap bitmap = null;
        if (buffer != null) {
            try {
                Buffer clone = buffer.clone();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(buffer.inputStream(), null, options);
                options.inSampleSize = a(options, i, i2);
                options.inJustDecodeBounds = false;
                bitmap = com.opos.cmn.an.d.c.a.a(BitmapFactory.decodeStream(clone.inputStream(), null, options), i, i2, options.inSampleSize);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e);
                bitmap = null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeSampledBitmapFromStream res=");
        if (buffer == null) {
            buffer = com.igexin.push.core.b.l;
        }
        sb.append(buffer);
        sb.append(",reqWidth=");
        sb.append(i);
        sb.append(",reqHeight=");
        sb.append(i2);
        sb.append(",dst=");
        Bitmap bitmap2 = com.igexin.push.core.b.l;
        if (bitmap != null) {
            bitmap2 = bitmap;
        }
        sb.append(bitmap2);
        com.opos.cmn.an.f.a.b("BitmapTool", sb.toString());
        return bitmap;
    }

    private final File a(String str, String str2) {
        return TextUtils.isEmpty(str2) ? this.f12286a.a(str) : this.f12286a.a(str, str2);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("fCache", "close", e);
            }
        }
    }

    private void a(final File file, final String str, final int i, final int i2, final a.InterfaceC0506a interfaceC0506a) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.d.c.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Buffer buffer = (Buffer) c.this.b.remove(file.getAbsolutePath());
                    Buffer buffer2 = buffer;
                    if (buffer == null) {
                        WeakReference weakReference = (WeakReference) c.this.f12287c.get(file.getAbsolutePath());
                        buffer2 = buffer;
                        if (weakReference != null) {
                            buffer2 = (Buffer) weakReference.get();
                        }
                    }
                    if (buffer2 != null) {
                        com.opos.cmn.an.f.a.b("fCache", "decode cache");
                        if (c.this.a(buffer2, str, i, i2, interfaceC0506a)) {
                            return;
                        }
                        com.opos.cmn.an.f.a.c("fCache", "decode cache fail");
                    }
                    com.opos.cmn.an.f.a.b("fCache", "decode file");
                    if (c.this.b(file, str, i, i2, interfaceC0506a)) {
                        return;
                    }
                } catch (Throwable th) {
                    Log.d("fCache", "decode fail", th);
                }
                a.InterfaceC0506a interfaceC0506a2 = interfaceC0506a;
                if (interfaceC0506a2 != null) {
                    interfaceC0506a2.a(2, null);
                }
            }
        });
    }

    private void a(final Buffer buffer, final File file) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                BufferedSink bufferedSink = null;
                BufferedSink bufferedSink2 = null;
                try {
                    try {
                        try {
                            if (file.exists()) {
                                file.delete();
                            }
                            File b = c.this.b(file);
                            if (b.exists()) {
                                b.delete();
                            }
                            BufferedSink buffer2 = Okio.buffer(Okio.sink(b));
                            buffer2.writeAll(buffer);
                            bufferedSink2 = buffer2;
                            b.renameTo(file);
                            if (buffer2 != null) {
                                buffer2.flush();
                                buffer2.close();
                            }
                            buffer.close();
                        } catch (Throwable th) {
                            if (bufferedSink != null) {
                                try {
                                    bufferedSink.flush();
                                    bufferedSink.close();
                                } catch (Exception e) {
                                    com.opos.cmn.an.f.a.b("fCache", "", e);
                                    throw th;
                                }
                            }
                            buffer.close();
                            throw th;
                        }
                    } catch (Exception e2) {
                        bufferedSink = bufferedSink2;
                        com.opos.cmn.an.f.a.b("fCache", "write fail", e2);
                        if (bufferedSink2 != null) {
                            bufferedSink2.flush();
                            bufferedSink2.close();
                        }
                        buffer.close();
                    }
                } catch (Exception e3) {
                    com.opos.cmn.an.f.a.b("fCache", "", e3);
                }
            }
        });
    }

    private boolean a(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Buffer buffer = null;
        Buffer buffer2 = null;
        try {
            try {
                Buffer a2 = a(file);
                boolean a3 = a(a2, str);
                if (a3) {
                    buffer2 = a2;
                    buffer = a2;
                    this.b.put(file.getAbsolutePath(), a2);
                }
                if (a2 != null) {
                    a2.close();
                }
                return a3;
            } catch (Exception e) {
                buffer2 = buffer;
                com.opos.cmn.an.f.a.b("fCache", "check fail", e);
                if (buffer != null) {
                    buffer.close();
                    return false;
                }
                return false;
            }
        } catch (Throwable th) {
            if (buffer2 != null) {
                buffer2.close();
            }
            throw th;
        }
    }

    private boolean a(Buffer buffer, String str) {
        return buffer.md5().hex().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        if (r6 != null) goto L32;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(okio.Buffer r5, java.lang.String r6, int r7, int r8, com.opos.mobad.c.a.InterfaceC0506a r9) {
        /*
            r4 = this;
            r0 = 0
            r13 = r0
            r0 = 0
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r6
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7d
            if (r0 != 0) goto La9
            r0 = r12
            r11 = r0
            r0 = r5
            okio.Buffer r0 = r0.clone()     // Catch: java.lang.Throwable -> L7d
            r12 = r0
            r0 = r12
            r11 = r0
            r0 = r12
            okio.ByteString r0 = r0.md5()     // Catch: java.lang.Throwable -> L7d
            java.lang.String r0 = r0.hex()     // Catch: java.lang.Throwable -> L7d
            r1 = r6
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L7d
            r10 = r0
            r0 = r12
            r6 = r0
            goto Laf
        L33:
            r0 = r6
            r11 = r0
            r0 = r5
            r1 = r7
            r2 = r8
            android.graphics.Bitmap r0 = a(r0, r1, r2)     // Catch: java.lang.Throwable -> L7d
            r12 = r0
            goto L4e
        L42:
            r0 = r6
            r11 = r0
            r0 = r5
            java.io.InputStream r0 = r0.inputStream()     // Catch: java.lang.Throwable -> L7d
            android.graphics.Bitmap r0 = a(r0)     // Catch: java.lang.Throwable -> L7d
            r12 = r0
        L4e:
            r0 = r12
            if (r0 == 0) goto L76
            r0 = r9
            if (r0 == 0) goto L68
            r0 = r6
            r11 = r0
            r0 = r9
            r1 = r10
            r2 = 1
            r1 = r1 ^ r2
            r2 = r12
            r0.a(r1, r2)     // Catch: java.lang.Throwable -> L7d
        L68:
            r0 = r6
            if (r0 == 0) goto L70
            r0 = r6
            r0.close()
        L70:
            r0 = r5
            r0.close()
            r0 = 1
            return r0
        L76:
            r0 = r6
            if (r0 == 0) goto L92
            goto L8e
        L7d:
            r6 = move-exception
            java.lang.String r0 = "fCache"
            java.lang.String r1 = "decode cache fail"
            r2 = r6
            com.opos.cmn.an.f.a.b(r0, r1, r2)     // Catch: java.lang.Throwable -> L98
            r0 = r11
            if (r0 == 0) goto L92
            r0 = r11
            r6 = r0
        L8e:
            r0 = r6
            r0.close()
        L92:
            r0 = r5
            r0.close()
            r0 = 0
            return r0
        L98:
            r6 = move-exception
            r0 = r11
            if (r0 == 0) goto La3
            r0 = r11
            r0.close()
        La3:
            r0 = r5
            r0.close()
            r0 = r6
            throw r0
        La9:
            r0 = 1
            r10 = r0
            r0 = r13
            r6 = r0
        Laf:
            r0 = r7
            if (r0 <= 0) goto L42
            r0 = r8
            if (r0 > 0) goto L33
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.c.a(okio.Buffer, java.lang.String, int, int, com.opos.mobad.c.a$a):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File b(File file) {
        String parent = file.getParent();
        return new File(parent, file.getName() + ".tmp");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x00d1: MOVE  (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:27:0x00c8 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0204 A[Catch: Exception -> 0x0238, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0238, blocks: (B:99:0x01f7, B:103:0x0204, B:83:0x01af, B:86:0x01be), top: B:123:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01f7 A[Catch: Exception -> 0x0238, TRY_ENTER, TryCatch #2 {Exception -> 0x0238, blocks: (B:99:0x01f7, B:103:0x0204, B:83:0x01af, B:86:0x01be), top: B:123:0x0129 }] */
    /* JADX WARN: Type inference failed for: r18v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.io.File r8, java.lang.String r9, int r10, int r11, com.opos.mobad.c.a.InterfaceC0506a r12) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.d.c.b(java.io.File, java.lang.String, int, int, com.opos.mobad.c.a$a):boolean");
    }

    public int a(String str, BufferedSource bufferedSource, String str2, String str3) {
        return a(str, bufferedSource, new Buffer(), str2, str3);
    }

    public int a(String str, BufferedSource bufferedSource, Buffer buffer, String str2, String str3) {
        int i;
        int i2;
        File a2 = a(str, str3);
        if (a2 != null) {
            if (a2.exists()) {
                a2.delete();
            }
            BufferedSink bufferedSink = null;
            BufferedSink bufferedSink2 = null;
            try {
                try {
                    File b = b(a2);
                    if (b.exists()) {
                        b.delete();
                    }
                    BufferedSink buffer2 = Okio.buffer(Okio.sink(b));
                    do {
                        long read = bufferedSource.read(buffer, 8192L);
                        i2 = (read > 0L ? 1 : (read == 0L ? 0 : -1));
                        if (i2 >= 0) {
                            buffer2.write(buffer, read);
                        }
                    } while (i2 >= 0);
                    try {
                        if (TextUtils.isEmpty(str2) || str2.equals(com.opos.cmn.an.a.c.a(b))) {
                            b.renameTo(a2);
                            i = 0;
                            a((Closeable) bufferedSource);
                            a((Closeable) buffer);
                            if (buffer2 != null) {
                                buffer2.flush();
                                buffer2.close();
                                return 0;
                            }
                        } else {
                            com.opos.cmn.an.f.a.b("fCache", "write but md5 fail");
                            b.delete();
                            i = 1;
                            a((Closeable) bufferedSource);
                            a((Closeable) buffer);
                            if (buffer2 != null) {
                                buffer2.flush();
                                buffer2.close();
                                return 1;
                            }
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("fCache", "close", e);
                        return i2;
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("fCache", "is", e2);
                    a((Closeable) bufferedSource);
                    a((Closeable) buffer);
                    if (0 != 0) {
                        try {
                            bufferedSink.flush();
                            bufferedSink.close();
                        } catch (Exception e3) {
                            com.opos.cmn.an.f.a.b("fCache", "close", e3);
                        }
                    }
                }
                return i;
            } catch (Throwable th) {
                a((Closeable) bufferedSource);
                a((Closeable) buffer);
                if (0 != 0) {
                    try {
                        bufferedSink2.flush();
                        bufferedSink2.close();
                    } catch (Exception e4) {
                        com.opos.cmn.an.f.a.b("fCache", "close", e4);
                    }
                }
                throw th;
            }
        }
        i = 2;
        return i;
    }

    public Buffer a(File file) throws Exception {
        Buffer buffer = new Buffer();
        Okio.buffer(Okio.source(file)).readAll(buffer);
        return buffer;
    }

    @Override // com.opos.mobad.c.a
    public void a(String str, String str2, int i, int i2, a.InterfaceC0506a interfaceC0506a) {
        a(new File(str), str2, i, i2, interfaceC0506a);
    }

    public void a(String str, Buffer buffer, String str2) throws Exception {
        File a2 = a(str, str2);
        if (a2 == null) {
            return;
        }
        this.b.put(a2.getAbsolutePath(), buffer.clone());
        a(buffer, a2);
    }

    public boolean a(String str, String str2, String str3) {
        return a(a(str, str3), str2);
    }
}
