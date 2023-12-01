package com.tencent.smtt.sdk;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/MimeTypeMap.class */
public class MimeTypeMap {

    /* renamed from: a  reason: collision with root package name */
    private static MimeTypeMap f38713a;

    private MimeTypeMap() {
    }

    public static String getFileExtensionFromUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.MimeTypeMap.getFileExtensionFromUrl(str) : a2.c().h(str);
    }

    public static MimeTypeMap getSingleton() {
        MimeTypeMap mimeTypeMap;
        synchronized (MimeTypeMap.class) {
            try {
                if (f38713a == null) {
                    f38713a = new MimeTypeMap();
                }
                mimeTypeMap = f38713a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str) : a2.c().l(str);
    }

    public String getMimeTypeFromExtension(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str) : a2.c().j(str);
    }

    public boolean hasExtension(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.MimeTypeMap.getSingleton().hasExtension(str) : a2.c().k(str);
    }

    public boolean hasMimeType(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.MimeTypeMap.getSingleton().hasMimeType(str) : a2.c().i(str);
    }
}
