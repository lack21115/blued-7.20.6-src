package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Environment;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.meizu.cloud.pushinternal.DebugLogger;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/handler/a/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final File f24136a;

    public b(String str) {
        this.f24136a = new File(str);
    }

    private void a(File file, ZipOutputStream zipOutputStream, String str) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.trim().length() == 0 ? "" : File.separator);
        sb.append(file.getName());
        String sb2 = sb.toString();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (File file2 : listFiles) {
                a(file2, zipOutputStream, sb2);
            }
            return;
        }
        DebugLogger.i("ZipTask", "current file " + sb2 + BridgeUtil.SPLIT_MARK + file.getName() + " size is " + (file.length() / 1024) + "KB");
        if (file.length() >= 10485760) {
            return;
        }
        byte[] bArr = new byte[1048576];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1048576);
        zipOutputStream.putNextEntry(new ZipEntry(sb2));
        while (true) {
            int read = bufferedInputStream.read(bArr);
            if (read == -1) {
                bufferedInputStream.close();
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArr, 0, read);
        }
    }

    private void a(Collection<File> collection, File file) throws Exception {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576));
        for (File file2 : collection) {
            a(file2, zipOutputStream, "");
        }
        zipOutputStream.close();
    }

    public void a(List<String> list) throws Exception {
        if (!this.f24136a.exists()) {
            this.f24136a.getParentFile().mkdirs();
        }
        ArrayList arrayList = new ArrayList();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        for (String str : list) {
            File file = new File(absolutePath + str);
            if (file.exists()) {
                arrayList.add(file);
            }
        }
        a(arrayList, this.f24136a);
    }
}