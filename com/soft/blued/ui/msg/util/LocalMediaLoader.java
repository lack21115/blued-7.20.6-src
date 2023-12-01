package com.soft.blued.ui.msg.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.framework.utils.AppUtils;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.huawei.openalliance.ad.constant.ax;
import com.oplus.quickgame.sdk.hall.Constant;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/LocalMediaLoader.class */
public final class LocalMediaLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18908a = LocalMediaLoader.class.getSimpleName();
    private static final Uri b = MediaStore.Files.getContentUri(Constant.Param.KEY_RPK_EXTERNAL);
    private static final String[] f = {"_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", "bucket_id"};
    private static final String[] g = {String.valueOf(1), String.valueOf(3)};

    /* renamed from: c  reason: collision with root package name */
    private Context f18909c;
    private boolean d = AppUtils.b();
    private int e;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/util/LocalMediaLoader$MediaType.class */
    public static class MediaType {
        public static String a() {
            return ax.V;
        }

        public static boolean a(String str) {
            return str != null && str.startsWith("video");
        }

        public static boolean b(String str) {
            return str != null && str.startsWith("image");
        }

        public static boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("content://");
        }

        public static String d(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return ax.V;
                }
                String name = new File(str).getName();
                int lastIndexOf = name.lastIndexOf(".");
                String substring = lastIndexOf == -1 ? "jpeg" : name.substring(lastIndexOf + 1);
                return "image/" + substring;
            } catch (Exception e) {
                e.printStackTrace();
                return ax.V;
            }
        }
    }

    public LocalMediaLoader(Context context, int i) {
        this.f18909c = context.getApplicationContext();
        this.e = i;
    }

    private String a(long j) {
        return b.buildUpon().appendPath(a(Long.valueOf(j))).build().toString();
    }

    private String a(long j, long j2) {
        long j3 = 300000;
        if (j != 0) {
            j3 = Math.min(300000L, j);
        }
        return String.format(Locale.CHINA, "%d <%s duration and duration <= %d", Long.valueOf(Math.max(j2, (long) m.ag)), Math.max(j2, (long) m.ag) == 0 ? "" : "=", Long.valueOf(j3));
    }

    public static String a(Object obj) {
        try {
            return obj.toString();
        } catch (Exception e) {
            return "";
        }
    }

    private static String a(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("(media_type=?");
        sb.append(z ? "" : " AND mime_type!='image/gif'");
        sb.append(" OR ");
        sb.append("media_type=? AND ");
        sb.append(str);
        sb.append(") AND ");
        sb.append("_size");
        sb.append(">0");
        return sb.toString();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    private static String[] a(int i) {
        return new String[]{String.valueOf(i)};
    }

    private static String b() {
        return "media_type=? AND _size>0";
    }

    private String c() {
        int i = this.e;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return b();
            }
            return "media_type=? AND _size>0";
        }
        return a(a(0L, 0L), true);
    }

    private String[] d() {
        int i = this.e;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return a(3);
            }
            return a(1);
        }
        return g;
    }

    public LinkedHashMap<String, List<ChildImageInfo>> a() {
        Cursor query = this.f18909c.getContentResolver().query(b, f, c(), d(), "_id DESC");
        try {
            if (query == null) {
                if (query == null || query.isClosed()) {
                    return null;
                }
                query.close();
                return null;
            }
            try {
                LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.put(this.f18909c.getResources().getString(R.string.msg_camera_pic), new ArrayList());
                if (query.getCount() <= 0) {
                    if (query != null) {
                        query.close();
                    }
                    return linkedHashMap;
                }
                int columnIndexOrThrow = query.getColumnIndexOrThrow(f[0]);
                int columnIndexOrThrow2 = query.getColumnIndexOrThrow(f[1]);
                int columnIndexOrThrow3 = query.getColumnIndexOrThrow(f[2]);
                int columnIndexOrThrow4 = query.getColumnIndexOrThrow(f[3]);
                int columnIndexOrThrow5 = query.getColumnIndexOrThrow(f[4]);
                int columnIndexOrThrow6 = query.getColumnIndexOrThrow(f[5]);
                int columnIndexOrThrow7 = query.getColumnIndexOrThrow(f[6]);
                int columnIndexOrThrow8 = query.getColumnIndexOrThrow(f[7]);
                int columnIndexOrThrow9 = query.getColumnIndexOrThrow(f[8]);
                query.moveToFirst();
                do {
                    long j = query.getLong(columnIndexOrThrow);
                    String string = query.getString(columnIndexOrThrow2);
                    String a2 = this.d ? a(j) : string;
                    String string2 = query.getString(columnIndexOrThrow3);
                    String str = string2;
                    if (TextUtils.isEmpty(string2)) {
                        str = MediaType.a();
                    }
                    String str2 = str;
                    if (str.endsWith("image/*")) {
                        str2 = MediaType.c(a2) ? MediaType.d(string) : MediaType.d(a2);
                    }
                    int i = query.getInt(columnIndexOrThrow4);
                    int i2 = query.getInt(columnIndexOrThrow5);
                    long j2 = query.getLong(columnIndexOrThrow6);
                    long j3 = query.getLong(columnIndexOrThrow7);
                    String string3 = query.getString(columnIndexOrThrow8);
                    String string4 = query.getString(columnIndexOrThrow9);
                    String str3 = f18908a;
                    Logger.c(str3, "fileName : " + string4 + "    type :" + str2 + "  path :" + a2 + "isAndroidQ : " + this.d);
                    String str4 = f18908a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("absolutePath : ");
                    sb.append(string);
                    sb.append(" || ");
                    sb.append(com.soft.blued.utils.AppUtils.b(string));
                    Logger.c(str4, sb.toString());
                    if (!MediaType.a(str2) || (j2 >= m.ag && j2 <= 300000 && j2 != 0 && j3 > 0)) {
                        ChildImageInfo childImageInfo = new ChildImageInfo();
                        childImageInfo.height = i2;
                        childImageInfo.width = i;
                        childImageInfo.mediaType = str2;
                        childImageInfo.duration = j2;
                        childImageInfo.imgUri = a2;
                        childImageInfo.mImagePath = string;
                        List<ChildImageInfo> list = linkedHashMap.get(string3);
                        ArrayList arrayList = list;
                        if (list == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(childImageInfo);
                        if (!linkedHashMap.containsValue(string3)) {
                            linkedHashMap.put(string3, arrayList);
                        }
                        linkedHashMap.get(this.f18909c.getResources().getString(R.string.msg_camera_pic)).add(childImageInfo);
                    }
                } while (query.moveToNext());
                if (query != null && !query.isClosed()) {
                    query.close();
                }
                return linkedHashMap;
            } catch (Exception e) {
                e.printStackTrace();
                String str5 = f18908a;
                Log.i(str5, "loadAllMedia Data Error: " + e.getMessage());
                if (query == null || query.isClosed()) {
                    return null;
                }
                query.close();
                return null;
            }
        } catch (Throwable th) {
            if (query != null && !query.isClosed()) {
                query.close();
            }
            throw th;
        }
    }
}
