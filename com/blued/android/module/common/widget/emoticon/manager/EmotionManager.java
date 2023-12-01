package com.blued.android.module.common.widget.emoticon.manager;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.Zip;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.CommonPreferences;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.widget.emoticon.model.EmoticonModel;
import com.blued.android.module.common.widget.emoticon.model.EmoticonPackageModel;
import com.blued.android.module.common.widget.emoticon.model.EmotionPackDownload;
import com.blued.android.module.common.widget.emoticon.ui.Emotion;
import com.google.common.base.Charsets;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/manager/EmotionManager.class */
public class EmotionManager {
    private static Set<EmotionPackListener> b;
    private static EmoticonPackageModel c;
    private static String e;
    private static List<EmoticonPackageModel> d = new ArrayList();
    private static boolean f = false;
    private static boolean g = false;
    static final Pattern a = Pattern.compile("\\S*[?]\\S*");
    private static BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<EmoticonPackageModel>>() { // from class: com.blued.android.module.common.widget.emoticon.manager.EmotionManager.4
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<EmoticonPackageModel> bluedEntityA) {
            ArrayList arrayList = new ArrayList();
            if (bluedEntityA.data != null) {
                arrayList.addAll(bluedEntityA.data);
            }
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= EmotionManager.d.size()) {
                    EmotionManager.b(arrayList2, arrayList);
                    return;
                }
                if (!StringUtils.b(((EmoticonPackageModel) EmotionManager.d.get(i2)).code) && !((EmoticonPackageModel) EmotionManager.d.get(i2)).isDefaultEmotionPacks) {
                    arrayList2.add((EmoticonPackageModel) EmotionManager.d.get(i2));
                }
                i = i2 + 1;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/manager/EmotionManager$EmotionComparator.class */
    public static class EmotionComparator implements Comparator<EmoticonPackageModel> {
        private EmotionComparator() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(EmoticonPackageModel emoticonPackageModel, EmoticonPackageModel emoticonPackageModel2) {
            if (TextUtils.isEmpty(emoticonPackageModel.code) && TextUtils.isEmpty(emoticonPackageModel2.code)) {
                return 0;
            }
            int i = -1;
            if (TextUtils.isEmpty(emoticonPackageModel.code)) {
                return -1;
            }
            if (TextUtils.isEmpty(emoticonPackageModel2.code)) {
                return 1;
            }
            long v = CommonPreferences.v(emoticonPackageModel.code);
            long v2 = CommonPreferences.v(emoticonPackageModel2.code);
            if (v == v2) {
                return emoticonPackageModel2.code.compareTo(emoticonPackageModel.code);
            }
            if (v2 > v) {
                i = 1;
            }
            return i;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.blued.android.module.common.widget.emoticon.manager.EmotionManager$1] */
    private static EmoticonPackageModel a(String str, boolean z) {
        boolean z2;
        try {
            EmoticonPackageModel emoticonPackageModel = (EmoticonPackageModel) AppInfo.f().fromJson(str, new TypeToken<EmoticonPackageModel>() { // from class: com.blued.android.module.common.widget.emoticon.manager.EmotionManager.1
            }.getType());
            Iterator<EmoticonPackageModel> it = d.iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                EmoticonPackageModel next = it.next();
                if (!TextUtils.isEmpty(next.code) && next.code.equals(emoticonPackageModel.code)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                return null;
            }
            a(emoticonPackageModel, z);
            return emoticonPackageModel;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a() {
        return "/EmotionsPack/" + UserInfo.getInstance().getLoginUserInfo().getUid() + BridgeUtil.SPLIT_MARK;
    }

    public static void a(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        HttpManager.a(l() + "/users/" + str + "/emotions", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void a(Context context, final String str, final EmotionLoadListener emotionLoadListener) {
        if (emotionLoadListener != null) {
            b(context, new BluedUIHttpResponse<BluedEntityA<EmotionPackDownload>>() { // from class: com.blued.android.module.common.widget.emoticon.manager.EmotionManager.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<EmotionPackDownload> bluedEntityA) {
                    if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                        return;
                    }
                    EmotionManager.a(bluedEntityA.data.get(0).download, String.this, emotionLoadListener);
                }
            }, str);
        }
    }

    public static void a(EmotionPackListener emotionPackListener) {
        if (b == null) {
            b = new HashSet();
        }
        b.add(emotionPackListener);
    }

    private static void a(EmoticonPackageModel emoticonPackageModel, boolean z) {
        if (emoticonPackageModel != null) {
            emoticonPackageModel.itemPadding = 25;
            emoticonPackageModel.emoticonType = 1;
            emoticonPackageModel.row = 4;
            emoticonPackageModel.line = 2;
            emoticonPackageModel.isDownLoad = true;
            if (z) {
                emoticonPackageModel.icon = "assets://DefaultEmotions/" + emoticonPackageModel.code + BridgeUtil.SPLIT_MARK + emoticonPackageModel.icon;
                emoticonPackageModel.isDefaultEmotionPacks = true;
            } else {
                emoticonPackageModel.icon = "file://" + h() + BridgeUtil.SPLIT_MARK + emoticonPackageModel.code + BridgeUtil.SPLIT_MARK + emoticonPackageModel.icon;
                emoticonPackageModel.isDefaultEmotionPacks = false;
            }
            if (emoticonPackageModel.emotions != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= emoticonPackageModel.emotions.size()) {
                        break;
                    }
                    EmoticonModel emoticonModel = emoticonPackageModel.emotions.get(i2);
                    if (z) {
                        emoticonModel.url = "assets://DefaultEmotions/" + emoticonPackageModel.code + BridgeUtil.SPLIT_MARK + emoticonModel.small;
                        emoticonModel.url_original = "assets://DefaultEmotions/" + emoticonPackageModel.code + BridgeUtil.SPLIT_MARK + emoticonModel.original;
                    } else {
                        emoticonModel.url = "file://" + h() + BridgeUtil.SPLIT_MARK + emoticonPackageModel.code + BridgeUtil.SPLIT_MARK + emoticonModel.small;
                        emoticonModel.url_original = "file://" + h() + BridgeUtil.SPLIT_MARK + emoticonPackageModel.code + BridgeUtil.SPLIT_MARK + emoticonModel.original;
                    }
                    emoticonModel.emoticonType = 1;
                    emoticonModel.packageCode = emoticonPackageModel.code;
                    i = i2 + 1;
                }
            }
            d.add(emoticonPackageModel);
            b(d);
        }
        if (StringUtils.b(CommonPreferences.k())) {
            return;
        }
        String[] split = CommonPreferences.k().split(",");
        if (split.length <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= split.length) {
                return;
            }
            if (split[i4].equals(emoticonPackageModel.code) && emoticonPackageModel.isDefaultEmotionPacks) {
                d.remove(emoticonPackageModel);
            }
            i3 = i4 + 1;
        }
    }

    public static void a(File file) {
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= listFiles.length) {
                        break;
                    }
                    a(listFiles[i2]);
                    i = i2 + 1;
                }
            }
            file.delete();
        }
    }

    public static void a(String str) {
        try {
            String b2 = AppMethods.b(a());
            String a2 = Zip.a(str, b2);
            String str2 = b2;
            if (!TextUtils.isEmpty(a2)) {
                str2 = b2 + File.separator + a2;
            }
            LogUtils.c("filePath: " + str2);
            String g2 = g(str2);
            if (TextUtils.isEmpty(g2)) {
                LogUtils.c("download emotion can't get json");
                return;
            }
            EmoticonPackageModel a3 = a(g2, false);
            if (a3 != null) {
                CommonPreferences.a(a3.code, System.currentTimeMillis());
                b(d);
            }
            if (b != null) {
                for (EmotionPackListener emotionPackListener : b) {
                    emotionPackListener.a();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2, final EmotionLoadListener emotionLoadListener) {
        String str3 = AppMethods.b(a() + "/SingleEmotions") + File.separator + str2 + "." + f(str);
        LogUtils.c("filePath: " + str3);
        final EmoticonModel emoticonModel = new EmoticonModel();
        emoticonModel.url_original = "file://" + str3;
        FileDownloader.a(str, str3, new FileHttpResponseHandler() { // from class: com.blued.android.module.common.widget.emoticon.manager.EmotionManager.3
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file) {
                EmotionLoadListener.this.a(emoticonModel);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onFailure(Throwable th, int i, File file) {
                EmotionLoadListener.this.b(emoticonModel);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                EmotionLoadListener.this.c(emoticonModel);
            }
        }, null);
    }

    private static void a(List<String> list) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return;
            }
            a(list.get(i2), false);
            i = i2 + 1;
        }
    }

    public static void b() {
        g = false;
        d.clear();
    }

    public static void b(Context context, BluedUIHttpResponse bluedUIHttpResponse, String str) {
        Map<String, String> a2 = BluedHttpTools.a();
        a2.put("name", str);
        HttpManager.a(l() + "/blued/emotions", bluedUIHttpResponse).b(BluedHttpTools.a(true)).a(a2).h();
    }

    public static void b(EmotionPackListener emotionPackListener) {
        Set<EmotionPackListener> set = b;
        if (set != null) {
            set.remove(emotionPackListener);
        }
    }

    public static void b(String str) {
        if (f) {
            return;
        }
        f = true;
        e = str;
        c = g();
        j();
    }

    private static void b(List<EmoticonPackageModel> list) {
        if (list == null) {
            return;
        }
        Collections.sort(list, new EmotionComparator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<EmoticonPackageModel> list, List<EmoticonPackageModel> list2) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (EmoticonPackageModel emoticonPackageModel : list) {
            hashSet.add(emoticonPackageModel.code);
        }
        for (EmoticonPackageModel emoticonPackageModel2 : list2) {
            hashSet2.add(emoticonPackageModel2.code);
        }
        hashSet.removeAll(hashSet2);
        ArrayList arrayList = new ArrayList(hashSet);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                return;
            }
            synchronized (d) {
                d((String) arrayList.get(i2));
            }
            i = i2 + 1;
        }
    }

    public static List<EmoticonPackageModel> c() {
        if (System.currentTimeMillis() - CommonPreferences.l().longValue() > 3600000) {
            a(AppInfo.d(), h, UserInfo.getInstance().getLoginUserInfo().getUid());
        }
        ArrayList arrayList = new ArrayList();
        synchronized (d) {
            arrayList.clear();
            arrayList.addAll(d);
        }
        return arrayList;
    }

    public static void c(String str) {
        if (g) {
            return;
        }
        g = true;
        e = str;
        b(str);
        k();
        EmoticonPackageModel emoticonPackageModel = c;
        if (emoticonPackageModel != null) {
            d.add(0, emoticonPackageModel);
        }
    }

    public static List<String> d() {
        List<EmoticonPackageModel> c2 = c();
        ArrayList arrayList = new ArrayList();
        if (!TypeUtils.a((List<?>) c2)) {
            for (EmoticonPackageModel emoticonPackageModel : c2) {
                if (!TextUtils.isEmpty(emoticonPackageModel.code)) {
                    arrayList.add(emoticonPackageModel.code);
                }
            }
        }
        return arrayList;
    }

    public static void d(String str) {
        boolean z;
        Set<EmotionPackListener> set;
        int i = 0;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (i >= d.size()) {
                break;
            }
            boolean z3 = z;
            if (!StringUtils.b(d.get(i).code)) {
                z3 = z;
                if (d.get(i).code.equals(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str + ",");
                    CommonPreferences.x(sb.toString().substring(0, sb.toString().length() - 1));
                    File file = new File(h() + File.separator + str);
                    if (file.exists()) {
                        File file2 = new File(file.getAbsolutePath() + System.currentTimeMillis());
                        file.renameTo(file2);
                        a(file2);
                    }
                    synchronized (d) {
                        d.remove(i);
                    }
                    z3 = true;
                } else {
                    continue;
                }
            }
            i++;
            z2 = z3;
        }
        CommonPreferences.w(str);
        if (!z || (set = b) == null) {
            return;
        }
        for (EmotionPackListener emotionPackListener : set) {
            emotionPackListener.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.blued.android.module.common.widget.emoticon.model.EmoticonModel e(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.emoticon.manager.EmotionManager.e(java.lang.String):com.blued.android.module.common.widget.emoticon.model.EmoticonModel");
    }

    public static List<EmoticonModel> e() {
        ArrayList arrayList = new ArrayList();
        List<EmoticonPackageModel> c2 = c();
        if (!TypeUtils.a((List<?>) c2)) {
            for (EmoticonPackageModel emoticonPackageModel : c2) {
                if (emoticonPackageModel.emoticonType == 0) {
                    arrayList.addAll(emoticonPackageModel.emotions);
                }
            }
        }
        return arrayList;
    }

    public static String f() {
        List<EmoticonPackageModel> c2 = c();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= c2.size()) {
                break;
            }
            if (!StringUtils.b(c2.get(i2).code)) {
                sb.append(c2.get(i2).code + ",");
            }
            i = i2 + 1;
        }
        return sb.toString().length() > 0 ? sb.toString().substring(0, sb.toString().length() - 1) : "";
    }

    public static String f(String str) {
        Matcher matcher = a.matcher(str);
        String[] split = str.split(BridgeUtil.SPLIT_MARK);
        String str2 = split[split.length - 1];
        try {
            if (matcher.find()) {
                return str2.split("\\?")[0].split("\\.")[1];
            }
        } catch (Throwable th) {
        }
        return str2.split("\\.")[1];
    }

    public static EmoticonPackageModel g() {
        EmoticonPackageModel emoticonPackageModel = new EmoticonPackageModel();
        emoticonPackageModel.emoticonType = 0;
        emoticonPackageModel.emotions = new ArrayList();
        emoticonPackageModel.icon = "system_default_emotion";
        emoticonPackageModel.isShowDelBtn = true;
        emoticonPackageModel.itemPadding = 25;
        emoticonPackageModel.row = 7;
        emoticonPackageModel.line = 3;
        new Emotion(AppInfo.d());
        if (Emotion.b.length != Emotion.a.length) {
            throw new RuntimeException("default small emotion data invalid");
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= Emotion.b.length) {
                return emoticonPackageModel;
            }
            EmoticonModel emoticonModel = new EmoticonModel();
            emoticonModel.code = Emotion.a[i2];
            emoticonModel.original = Emotion.b[i2];
            emoticonModel.emoticonType = 0;
            emoticonPackageModel.emotions.add(emoticonModel);
            i = i2 + 1;
        }
    }

    private static String g(String str) {
        InputStreamReader inputStreamReader;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(str + File.separator + "res.json"), Charsets.UTF_8);
        } catch (Throwable th) {
            th = th;
            inputStreamReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String sb2 = sb.toString();
                    CommonTools.a(inputStreamReader);
                    return sb2;
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                CommonTools.a(inputStreamReader);
                return null;
            } catch (Throwable th3) {
                CommonTools.a(inputStreamReader);
                throw th3;
            }
        }
    }

    public static String h() {
        return AppMethods.b(a());
    }

    private static List<String> h(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return arrayList;
            }
            String g2 = g(listFiles[i2].getAbsolutePath());
            if (!TextUtils.isEmpty(g2)) {
                arrayList.add(g2);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:2:0x0000, B:5:0x000a, B:8:0x0015, B:10:0x0033, B:12:0x0039, B:14:0x0096, B:16:0x00a0, B:17:0x00ab, B:9:0x0025), top: B:23:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j() {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc4
            r7 = r0
            r0 = r7
            r1 = 22
            if (r0 == r1) goto L25
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc4
            r1 = 23
            if (r0 != r1) goto L15
            goto L25
        L15:
            android.content.Context r0 = com.blued.android.core.AppInfo.d()     // Catch: java.lang.Throwable -> Lc4
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r1 = "DefaultEmotions"
            java.lang.String[] r0 = r0.list(r1)     // Catch: java.lang.Throwable -> Lc4
            r8 = r0
            goto Lca
        L25:
            r0 = 1
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> Lc4
            r1 = r0
            r2 = 0
            java.lang.String r3 = "bulu"
            r1[r2] = r3     // Catch: java.lang.Throwable -> Lc4
            r8 = r0
            goto Lca
        L33:
            r0 = r7
            r1 = r8
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc4
            if (r0 >= r1) goto Lc9
            android.content.Context r0 = com.blued.android.core.AppInfo.d()     // Catch: java.lang.Throwable -> Lc4
            android.content.res.AssetManager r0 = r0.getAssets()     // Catch: java.lang.Throwable -> Lc4
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4
            r10 = r0
            r0 = r10
            java.lang.String r1 = "DefaultEmotions"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc4
            r0 = r10
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> Lc4
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc4
            r0 = r10
            r1 = r8
            r2 = r7
            r1 = r1[r2]     // Catch: java.lang.Throwable -> Lc4
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc4
            r0 = r10
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> Lc4
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc4
            r0 = r10
            java.lang.String r1 = "res.json"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc4
            r0 = r9
            r1 = r10
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc4
            java.io.InputStream r0 = r0.open(r1)     // Catch: java.lang.Throwable -> Lc4
            r9 = r0
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lc4
            r1 = r0
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lc4
            r3 = r2
            r4 = r9
            java.nio.charset.Charset r5 = com.google.common.base.Charsets.UTF_8     // Catch: java.lang.Throwable -> Lc4
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> Lc4
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lc4
            r10 = r0
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Lc4
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4
            r11 = r0
        L95:
            r0 = r10
            java.lang.String r0 = r0.readLine()     // Catch: java.lang.Throwable -> Lc4
            r12 = r0
            r0 = r12
            if (r0 == 0) goto Lab
            r0 = r11
            r1 = r12
            java.lang.StringBuffer r0 = r0.append(r1)     // Catch: java.lang.Throwable -> Lc4
            goto L95
        Lab:
            r0 = r10
            r0.close()     // Catch: java.lang.Throwable -> Lc4
            r0 = r9
            r0.close()     // Catch: java.lang.Throwable -> Lc4
            r0 = r11
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lc4
            r1 = 1
            com.blued.android.module.common.widget.emoticon.model.EmoticonPackageModel r0 = a(r0, r1)     // Catch: java.lang.Throwable -> Lc4
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r7 = r0
            goto L33
        Lc4:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        Lc9:
            return
        Lca:
            r0 = 0
            r7 = r0
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.widget.emoticon.manager.EmotionManager.j():void");
    }

    private static void k() {
        try {
            a(h(h()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static String l() {
        if (e == null) {
            e = "https://argo.blued.cn";
        }
        return e;
    }
}
