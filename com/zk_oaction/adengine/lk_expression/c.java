package com.zk_oaction.adengine.lk_expression;

import com.xiaomi.mipush.sdk.Constants;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_variable.f;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/c.class */
public class c implements a.w, f {

    /* renamed from: a  reason: collision with root package name */
    private com.zk_oaction.adengine.lk_sdk.c f41922a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f41923c;
    private b d;
    private int e;
    private ArrayList<com.zk_oaction.adengine.lk_expression.a> f;
    private ArrayList<Object> g;
    private boolean h;
    private com.zk_oaction.adengine.lk_expression.a i;
    private ArrayList<c> j;
    private b k = new a();

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/c$a.class */
    class a implements b {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_expression.c.b
        public void h_(String str) {
            c.this.b();
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zk_oaction/adengine/lk_expression/c$b.class */
    public interface b {
        void h_(String str);
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar, String str, b bVar) {
        this.f41922a = cVar;
        this.b = str;
        this.d = bVar;
        if (str.isEmpty()) {
            this.f41923c = "";
        } else {
            char charAt = str.charAt(0);
            if (str.startsWith("ifelse")) {
                int indexOf = str.indexOf(40);
                String substring = str.substring(0, indexOf);
                ArrayList<String> a2 = com.zk_oaction.adengine.lk_expression.a.a(str.substring(indexOf + 1, str.length() - 1));
                if (substring.equals("ifelse")) {
                    this.e = 2;
                    this.f = new ArrayList<>();
                    this.g = new ArrayList<>();
                    int size = a2.size();
                    for (int i = 0; i < size - 1; i += 2) {
                        this.f.add(new com.zk_oaction.adengine.lk_expression.a(this.f41922a, null, a2.get(i), 0.0f, this, false));
                        String str2 = a2.get(i + 1);
                        if (str2.contains("'")) {
                            this.g.add(str2.substring(1, str2.length() - 1));
                        } else {
                            this.g.add(new c(this.f41922a, str2, this.k));
                        }
                    }
                    String str3 = a2.get(a2.size() - 1);
                    if (str3.contains("'")) {
                        this.g.add(str3.substring(1, str3.length() - 1));
                    } else {
                        this.g.add(new c(this.f41922a, str3, this.k));
                    }
                }
            } else if (str.contains("+")) {
                this.e = 4;
                this.j = a(str.replace(" ", "").replace("+", Constants.WAVE_SEPARATOR));
            } else if (charAt == '\'') {
                this.e = 1;
                this.f41923c = str.substring(1, str.length() - 1);
            } else if (charAt == '#' || charAt == '@') {
                this.e = 0;
                String substring2 = str.substring(1);
                this.b = substring2;
                this.f41922a.a(substring2, this);
            } else if (str.contains("#")) {
                this.e = 3;
                this.i = new com.zk_oaction.adengine.lk_expression.a(this.f41922a, null, str, 0.0f, this, false);
            } else {
                this.e = 1;
                this.f41923c = str;
            }
        }
        this.h = true;
        b();
    }

    private ArrayList<c> a(String str) {
        ArrayList<c> arrayList = new ArrayList<>();
        String[] split = str.split(Constants.WAVE_SEPARATOR);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return arrayList;
            }
            arrayList.add(new c(this.f41922a, split[i2], this.k));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r3 = this;
            r0 = r3
            boolean r0 = r0.h
            if (r0 != 0) goto L8
            return
        L8:
            r0 = r3
            int r0 = r0.e
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L98
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L91
            r0 = r4
            r1 = 3
            if (r0 == r1) goto L6d
            r0 = r4
            r1 = 4
            if (r0 == r1) goto L23
            goto Lac
        L23:
            r0 = r3
            java.lang.String r1 = ""
            r0.f41923c = r1
            r0 = r3
            java.util.ArrayList<com.zk_oaction.adengine.lk_expression.c> r0 = r0.j
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
        L31:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto Lac
            r0 = r5
            java.lang.Object r0 = r0.next()
            com.zk_oaction.adengine.lk_expression.c r0 = (com.zk_oaction.adengine.lk_expression.c) r0
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r7
            r1 = r3
            java.lang.String r1 = r1.f41923c
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r7
            r1 = r6
            java.lang.String r1 = r1.a()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r7
            java.lang.String r1 = r1.toString()
            r0.f41923c = r1
            goto L31
        L6d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = ""
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r3
            com.zk_oaction.adengine.lk_expression.a r1 = r1.i
            float r1 = r1.a()
            int r1 = (int) r1
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r0 = r0.toString()
            r5 = r0
            goto La7
        L91:
            r0 = r3
            r0.c()
            goto Lac
        L98:
            r0 = r3
            com.zk_oaction.adengine.lk_sdk.c r0 = r0.f41922a
            com.zk_oaction.adengine.lk_variable.g r0 = r0.n
            r1 = r3
            java.lang.String r1 = r1.b
            java.lang.String r0 = r0.b(r1)
            r5 = r0
        La7:
            r0 = r3
            r1 = r5
            r0.f41923c = r1
        Lac:
            r0 = r3
            java.lang.String r0 = r0.f41923c
            if (r0 != 0) goto Lb9
            r0 = r3
            java.lang.String r1 = ""
            r0.f41923c = r1
        Lb9:
            r0 = r3
            com.zk_oaction.adengine.lk_expression.c$b r0 = r0.d
            r5 = r0
            r0 = r5
            if (r0 == 0) goto Lcc
            r0 = r5
            r1 = r3
            java.lang.String r1 = r1.f41923c
            r0.h_(r1)
        Lcc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_expression.c.b():void");
    }

    private void c() {
        int size = this.f.size();
        Object obj = this.g.get(size - 1);
        this.f41923c = obj instanceof String ? (String) obj : ((c) obj).a();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            if (this.f.get(i2).a() != 0.0f) {
                Object obj2 = this.g.get(i2);
                this.f41923c = obj2 instanceof String ? (String) obj2 : ((c) obj2).a();
                return;
            }
            i = i2 + 1;
        }
    }

    public String a() {
        String str = this.f41923c;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f) {
        b();
    }

    @Override // com.zk_oaction.adengine.lk_variable.f
    public void a(String str, String str2) {
        b();
    }
}
