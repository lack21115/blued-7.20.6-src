package com.tencent.txcopyrightedmedia.impl.utils;

import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/k.class */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static PrintWriter f26415a;
    private static FileWriter b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f26416c = false;
    private static boolean d = false;
    private static File e;
    private static String f;

    public static void a() {
        if (f26416c && !d) {
            d = true;
            f = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()) + ".log";
            File file = new File(TXCopyrightedMedia.instance().getApplicationContext().getExternalFilesDir(null) + File.separator + "AME", f);
            e = file;
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                b = new FileWriter(e, true);
                f26415a = new PrintWriter(b);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void b() {
        if (f26416c) {
            FileWriter fileWriter = b;
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    b.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                b = null;
            }
            PrintWriter printWriter = f26415a;
            if (printWriter != null) {
                printWriter.flush();
                f26415a.close();
                f26415a = null;
            }
            d = false;
            if (!f26416c || e == null) {
                return;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(e);
                File file = new File("sdcard/AME/" + f);
                if (file.getParentFile() != null) {
                    file.getParentFile().mkdirs();
                }
                ak.a(fileInputStream, new FileOutputStream(file));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }
}
