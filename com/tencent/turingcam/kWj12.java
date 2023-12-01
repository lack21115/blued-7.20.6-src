package com.tencent.turingcam;

import android.hardware.Camera;
import android.view.View;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/kWj12.class */
public class kWj12 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26133a = WOMZP.b("MtgFbiApIVD3jXJqCLt/bt5rkOw=");
    private static final String b = WOMZP.b("+cCcc23pI7PKMKrSVgxsZsPbclBvL8nzPyVl/A==");

    /* renamed from: c  reason: collision with root package name */
    private static final String f26134c = WOMZP.b("zJ+vMS29evWmRb1DSUyS4qT5+NHKl4KpLi9JENdY++M=");
    private static final String d = WOMZP.b("F7V8SjDFWDGEHyhQJR/vmJ2PsYQvMxifBN46aQ==");
    private static final String e = WOMZP.b("loortpg4288gBQkZu13SWTiWdIoZjskllRDZLQ==");
    private static final String f = WOMZP.b("6DSRX7wn8gyuk+q/kxETe0VQRVj1BK8BZd0Lbw==");
    private static final String g = WOMZP.b("u2xfuQx4IjM=");
    private static final String h = WOMZP.b("Mnyu7C/RGC+JS0uIqev/3mXSPxY=");
    private static final String i = WOMZP.b("Z86b4PLjU2vaBVXm");
    private static final String j = WOMZP.b("E/elQq9Fz2/OYi4i");
    private static final String k = WOMZP.b("CX8j6UeNDbaimerGJKcSkIzaGUY3pwfjnkV71g==");
    public static final /* synthetic */ int l = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingcam/kWj12$spXPg.class */
    public static class spXPg {

        /* renamed from: a  reason: collision with root package name */
        private float f26135a;
        private Camera b;
        private String g;
        private int h;
        private View i;

        /* renamed from: c  reason: collision with root package name */
        private int f26136c = 0;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private long j = 500;

        public int a(int i) {
            int i2 = this.h;
            if (i2 > 0) {
                i = i2;
            }
            return i;
        }

        public Camera a() {
            return this.b;
        }

        public spXPg a(Camera camera) {
            this.b = camera;
            return this;
        }

        public spXPg a(View view) {
            this.i = view;
            return this;
        }

        public spXPg a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            String str = map.get(kWj12.g);
            if (str != null) {
                str.split("_");
            }
            String str2 = map.get(kWj12.f26133a);
            if (str2 != null) {
                this.f26135a = Float.parseFloat(str2);
            }
            String str3 = map.get(kWj12.e);
            if (str3 != null) {
                str3.split("_");
            }
            String str4 = map.get(kWj12.d);
            if (str4 != null) {
                try {
                    this.d = Integer.parseInt(str4);
                } catch (Exception e) {
                }
            }
            String str5 = map.get(kWj12.e);
            if (str5 != null) {
                str5.split("_");
            }
            String str6 = map.get(kWj12.f);
            if (str6 != null) {
                try {
                    Integer.parseInt(str6);
                } catch (Exception e2) {
                }
            }
            String str7 = map.get(kWj12.h);
            if (str7 != null) {
                try {
                    this.f26136c = Integer.parseInt(str7);
                } catch (Exception e3) {
                }
            }
            String str8 = map.get(kWj12.f26134c);
            if (str8 != null) {
                try {
                    this.e = Integer.parseInt(str8);
                } catch (Exception e4) {
                }
            }
            String str9 = map.get(kWj12.b);
            if (str9 != null) {
                try {
                    this.f = Integer.parseInt(str9);
                } catch (Exception e5) {
                }
            }
            this.g = map.get(kWj12.i);
            String str10 = map.get(kWj12.j);
            if (str10 != null) {
                try {
                    this.h = Integer.parseInt(str10);
                } catch (Exception e6) {
                }
            }
            String str11 = map.get(kWj12.k);
            if (str11 != null) {
                try {
                    this.j = Long.parseLong(str11);
                } catch (Exception e7) {
                    return this;
                }
            }
            return this;
        }

        public int b(int i) {
            int i2 = this.f26136c;
            if (i2 > 0) {
                i = i2;
            }
            return i;
        }

        public View b() {
            return this.i;
        }

        public float c() {
            return this.f26135a;
        }

        public int c(int i) {
            int i2 = this.f;
            if (i2 > 0) {
                i = i2;
            }
            return i;
        }

        public int d(int i) {
            int i2 = this.d;
            if (i2 > 0) {
                i = i2;
            }
            return i;
        }

        public String d() {
            return this.g;
        }

        public int e(int i) {
            int i2 = this.e;
            if (i2 > 0) {
                i = i2;
            }
            return i;
        }

        public long e() {
            return this.j;
        }
    }
}
