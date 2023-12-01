package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.thumbplayer.api.TPErrorCode;
import com.xiaomi.push.ai;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dt.class */
public class dt extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f27653a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f264a;

    /* renamed from: a  reason: collision with other field name */
    private com.xiaomi.push.service.ba f265a;

    public dt(Context context) {
        this.f27653a = context;
        this.f264a = context.getSharedPreferences("mipush_extra", 0);
        this.f265a = com.xiaomi.push.service.ba.a(context);
    }

    private List<ho> a(File file) {
        RandomAccessFile randomAccessFile;
        FileInputStream fileInputStream;
        FileLock fileLock;
        RandomAccessFile randomAccessFile2;
        FileInputStream fileInputStream2;
        FileLock fileLock2;
        FileInputStream fileInputStream3;
        dk m8573a = dl.a().m8573a();
        String a2 = m8573a == null ? "" : m8573a.a();
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (Cdo.f27649a) {
            try {
                File file2 = new File(this.f27653a.getExternalFilesDir(null), "push_cdata.lock");
                x.m9172a(file2);
                randomAccessFile2 = new RandomAccessFile(file2, "rw");
                try {
                    fileLock = randomAccessFile2.getChannel().lock();
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        while (fileInputStream2.read(bArr) == 4) {
                            try {
                                int a3 = ab.a(bArr);
                                byte[] bArr2 = new byte[a3];
                                if (fileInputStream2.read(bArr2) != a3) {
                                    break;
                                }
                                byte[] a4 = dn.a(a2, bArr2);
                                if (a4 != null && a4.length != 0) {
                                    ho hoVar = new ho();
                                    iq.a(hoVar, a4);
                                    arrayList.add(hoVar);
                                    a(hoVar);
                                }
                            } catch (Exception e) {
                                fileLock2 = fileLock;
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException e2) {
                                    }
                                }
                                x.a((Closeable) fileInputStream2);
                                x.a(randomAccessFile2);
                                return arrayList;
                            } catch (Throwable th) {
                                fileInputStream3 = fileInputStream2;
                                th = th;
                                randomAccessFile = randomAccessFile2;
                                fileInputStream = fileInputStream3;
                                if (fileLock != null && fileLock.isValid()) {
                                    try {
                                        fileLock.release();
                                    } catch (IOException e3) {
                                    }
                                }
                                x.a((Closeable) fileInputStream);
                                x.a(randomAccessFile);
                                throw th;
                            }
                        }
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e4) {
                            }
                        }
                        x.a((Closeable) fileInputStream2);
                    } catch (Exception e5) {
                        fileInputStream2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream3 = null;
                    }
                } catch (Exception e6) {
                    fileInputStream2 = null;
                    fileLock2 = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileLock = null;
                    randomAccessFile = randomAccessFile2;
                    fileInputStream = null;
                }
            } catch (Exception e7) {
                randomAccessFile2 = null;
                fileInputStream2 = null;
                fileLock2 = null;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile = null;
                fileInputStream = null;
                fileLock = null;
            }
            x.a(randomAccessFile2);
        }
        return arrayList;
    }

    private void a() {
        SharedPreferences.Editor edit = this.f264a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private void a(ho hoVar) {
        if (hoVar.f527a != hi.AppInstallList || hoVar.f528a.startsWith("same_")) {
            return;
        }
        SharedPreferences.Editor edit = this.f264a.edit();
        edit.putLong("dc_job_result_time_4", hoVar.f526a);
        edit.putString("dc_job_result_4", bn.a(hoVar.f528a));
        edit.commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m8579a() {
        if (bh.e(this.f27653a)) {
            return false;
        }
        if ((bh.g(this.f27653a) || bh.f(this.f27653a)) && !c()) {
            return true;
        }
        return (bh.h(this.f27653a) && !b()) || bh.i(this.f27653a);
    }

    private boolean b() {
        if (this.f265a.a(hl.Upload3GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f264a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f265a.a(hl.Upload3GFrequency.a(), 432000)));
        }
        return false;
    }

    private boolean c() {
        if (this.f265a.a(hl.Upload4GSwitch.a(), true)) {
            return Math.abs((System.currentTimeMillis() / 1000) - this.f264a.getLong("last_upload_data_timestamp", -1L)) > ((long) Math.max(86400, this.f265a.a(hl.Upload4GFrequency.a(), com.anythink.expressad.d.a.b.bx)));
        }
        return false;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo8500a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.f27653a.getExternalFilesDir(null), "push_cdata.data");
        if (!bh.d(this.f27653a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!m8579a() && file.exists()) {
            List<ho> a2 = a(file);
            if (!ac.a(a2)) {
                int size = a2.size();
                List<ho> list = a2;
                if (size > 4000) {
                    list = a2.subList(size - TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, size);
                }
                hz hzVar = new hz();
                hzVar.a(list);
                byte[] a3 = x.a(iq.a(hzVar));
                Cif cif = new Cif("-1", false);
                cif.c(hq.DataCollection.f536a);
                cif.a(a3);
                dk m8573a = dl.a().m8573a();
                if (m8573a != null) {
                    m8573a.a(cif, hg.Notification, null);
                }
                a();
            }
            file.delete();
        }
    }
}
