package com.zego.zegoavkit2.log;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/log/ZegoLogUtil.class */
public class ZegoLogUtil {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r7.isEmpty() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void createIfNotExist(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L9
            return
        L9:
            r0 = r6
            if (r0 == 0) goto L61
            r0 = r6
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L15
            return
        L15:
            r0 = r7
            if (r0 == 0) goto L22
            r0 = r7
            r8 = r0
            r0 = r7
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L25
        L22:
            java.lang.String r0 = "application/octet-stream"
            r8 = r0
        L25:
            r0 = r6
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L62
            r6 = r0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L62
            r1 = r0
            r2 = r6
            java.lang.String r2 = android.provider.DocumentsContract.getDocumentId(r2)     // Catch: java.lang.Exception -> L62
            r1.<init>(r2)     // Catch: java.lang.Exception -> L62
            r9 = r0
            r0 = r9
            java.lang.String r0 = r0.getParent()     // Catch: java.lang.Exception -> L62
            r7 = r0
            r0 = r9
            java.lang.String r0 = r0.getName()     // Catch: java.lang.Exception -> L62
            r9 = r0
            r0 = r6
            r1 = r7
            android.net.Uri r0 = android.provider.DocumentsContract.buildDocumentUriUsingTree(r0, r1)     // Catch: java.lang.Exception -> L62
            r6 = r0
            r0 = r5
            r1 = r6
            r2 = r9
            android.net.Uri r0 = find(r0, r1, r2)     // Catch: java.lang.Exception -> L62
            if (r0 == 0) goto L55
            return
        L55:
            r0 = r5
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Exception -> L62
            r1 = r6
            r2 = r8
            r3 = r9
            android.net.Uri r0 = android.provider.DocumentsContract.createDocument(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L62
        L61:
            return
        L62:
            r5 = move-exception
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoavkit2.log.ZegoLogUtil.createIfNotExist(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void delete(Context context, String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            File file = new File(DocumentsContract.getDocumentId(parse));
            String parent = file.getParent();
            if (find(context, DocumentsContract.buildDocumentUriUsingTree(parse, parent), file.getName()) == null) {
                return;
            }
            DocumentsContract.deleteDocument(context.getContentResolver(), parse);
        } catch (Exception e) {
        }
    }

    public static Uri find(Context context, Uri uri, String str) {
        Uri uri2;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Cursor query = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"document_id", "_display_name"}, null, null, null);
        if (query == null) {
            return null;
        }
        while (true) {
            uri2 = null;
            if (!query.moveToNext()) {
                break;
            } else if (query.getString(query.getColumnIndex("_display_name")).equalsIgnoreCase(str)) {
                uri2 = DocumentsContract.buildDocumentUriUsingTree(uri, query.getString(query.getColumnIndex("document_id")));
                break;
            }
        }
        query.close();
        return uri2;
    }

    public static int getFD(Context context, String str, String str2) {
        try {
            return context.getContentResolver().openFileDescriptor(Uri.parse(str), str2).detachFd();
        } catch (Exception e) {
            return 0;
        }
    }

    public static long getFileSize(Context context, Uri uri, String str) {
        long j;
        if (Build.VERSION.SDK_INT < 21) {
            return 0L;
        }
        Cursor query = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"_size", "_display_name"}, null, null, null);
        if (query == null) {
            return 0L;
        }
        while (true) {
            j = 0;
            if (!query.moveToNext()) {
                break;
            } else if (query.getString(query.getColumnIndex("_display_name")).equalsIgnoreCase(str)) {
                j = query.getLong(query.getColumnIndex("_size"));
                break;
            }
        }
        query.close();
        return j;
    }

    public static long getFileSize(Context context, String str) {
        long j = 0;
        if (Build.VERSION.SDK_INT < 21) {
            return 0L;
        }
        if (str != null) {
            if (str.isEmpty()) {
                return 0L;
            }
            try {
                Uri parse = Uri.parse(str);
                File file = new File(DocumentsContract.getDocumentId(parse));
                j = getFileSize(context, DocumentsContract.buildDocumentUriUsingTree(parse, file.getParent()), file.getName());
            } catch (Exception e) {
                return 0L;
            }
        }
        return j;
    }

    public static long getFileSize(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT < 21 || str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return 0L;
        }
        return getFileSize(context, Uri.parse(str), str2);
    }

    public static String withAppendedPath(String str, String str2) {
        if (Build.VERSION.SDK_INT < 21) {
            return str + BridgeUtil.SPLIT_MARK + str2;
        }
        try {
            Uri parse = Uri.parse(str);
            return DocumentsContract.buildDocumentUriUsingTree(parse, DocumentsContract.getDocumentId(parse) + BridgeUtil.SPLIT_MARK + str2).toString();
        } catch (Exception e) {
            return "";
        }
    }
}
