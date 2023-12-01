package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/at.class */
public class at extends bb {

    /* renamed from: a  reason: collision with root package name */
    String f26378a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    int f26379c;
    public String d;
    public aq e;
    public final ArrayList<ar> f;
    public au g;
    public com.tencent.txcopyrightedmedia.a h;
    public boolean i;
    public boolean j;
    private String n;
    private String o;
    private final az p;
    private int q;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/at$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f26380a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f26381c;

        public a(String str, int i, int i2) {
            this.f26380a = str;
            this.b = i;
            this.f26381c = i2;
        }
    }

    public at(ba baVar, String str, String str2, String str3, String str4) {
        super(baVar);
        this.f = new ArrayList<>();
        this.p = new az();
        this.i = false;
        this.f26378a = str;
        this.n = str2;
        this.o = str3;
        this.d = str4;
        this.f26379c = 0;
        if (TextUtils.equals(str2, "Accompaniment")) {
            if (TextUtils.equals(str, "StandardOriginal")) {
                this.b = 1;
            } else if (!TextUtils.equals(str, "StandardAccompaniment")) {
                if (TextUtils.equals(str, "Subtitles")) {
                    this.b = 3;
                    return;
                }
                return;
            } else {
                this.b = 2;
            }
            this.f26378a = "audio/default";
        } else if (!TextUtils.equals(str2, "ChorusClip")) {
            if (TextUtils.equals(str2, "Original")) {
                this.b = 1;
            }
        } else {
            if (TextUtils.equals(str, "StandardOriginal")) {
                this.b = 1;
            } else if (!TextUtils.equals(str, "StandardAccompaniment")) {
                if (TextUtils.equals(str, "Subtitles")) {
                    this.b = 3;
                }
                this.f26379c = 1;
            } else {
                this.b = 2;
            }
            this.f26378a = "audio/default";
            this.f26379c = 1;
        }
    }

    public static String b(int i) {
        return i == 1 ? "Original" : i == 2 ? "Accompaniment" : i == 3 ? "Subtitle" : "unknown";
    }

    private i e() {
        if (this.b == 3) {
            try {
                this.g = new au(this.k, new String(a(), "UTF-8"));
            } catch (Exception e) {
                e.printStackTrace();
                i iVar = new i(-5, "Content format error.");
                iVar.f26410a.a(e.toString());
                return iVar;
            }
        }
        return new i(0, null);
    }

    public final ar a(int i) {
        synchronized (at.class) {
            try {
                if (i < this.f.size()) {
                    return this.f.get(i);
                }
                return null;
            } finally {
            }
        }
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.bb
    public final String b() {
        return this.o;
    }

    @Override // com.tencent.txcopyrightedmedia.impl.utils.bb
    public final String c() {
        return "txcm://bgmStream/" + URLEncoder.encode(i()) + "/" + URLEncoder.encode(j()) + "/" + this.b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x0596, code lost:
        return e();
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0321 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x032d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.tencent.txcopyrightedmedia.impl.utils.i d() {
        /*
            Method dump skipped, instructions count: 1431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.txcopyrightedmedia.impl.utils.at.d():com.tencent.txcopyrightedmedia.impl.utils.i");
    }
}
