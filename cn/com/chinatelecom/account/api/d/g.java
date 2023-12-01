package cn.com.chinatelecom.account.api.d;

import android.net.Network;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/d/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Network f4130a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f4131c;
    public String d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    public Map<String, String> i;
    private int j;
    private int k;

    /* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/d/g$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f4132a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private Network f4133c;
        private int d;
        private String e;
        private String f;
        private boolean g;
        private boolean h;
        private String i;
        private String j;
        private Map<String, String> k;

        public a a(int i) {
            this.f4132a = i;
            return this;
        }

        public a a(Network network) {
            this.f4133c = network;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.k = map;
            return this;
        }

        public a a(boolean z) {
            this.g = z;
            return this;
        }

        public a a(boolean z, String str, String str2) {
            this.h = z;
            this.i = str;
            this.j = str2;
            return this;
        }

        public g a() {
            return new g(this);
        }

        public a b(int i) {
            this.b = i;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }
    }

    public g(a aVar) {
        this.j = aVar.f4132a;
        this.k = aVar.b;
        this.f4130a = aVar.f4133c;
        this.b = aVar.d;
        this.f4131c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.h = aVar.j;
        this.i = aVar.k;
    }

    public int a() {
        int i = this.j;
        if (i > 0) {
            return i;
        }
        return 3000;
    }

    public int b() {
        int i = this.k;
        if (i > 0) {
            return i;
        }
        return 3000;
    }
}
