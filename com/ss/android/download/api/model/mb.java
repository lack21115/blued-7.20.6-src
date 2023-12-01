package com.ss.android.download.api.model;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/mb.class */
public class mb {
    public String b;
    public String h;
    public String hj;
    public String mb;
    public String ox;

    /* renamed from: com.ss.android.download.api.model.mb$mb  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/download/api/model/mb$mb.class */
    public static class C0700mb {
        private String b;
        private String h;
        private String hj;
        private String mb;
        private String ox;

        public C0700mb b(String str) {
            this.hj = str;
            return this;
        }

        public C0700mb hj(String str) {
            this.h = str;
            return this;
        }

        public C0700mb mb(String str) {
            this.mb = str;
            return this;
        }

        public mb mb() {
            return new mb(this);
        }

        public C0700mb ox(String str) {
            this.ox = str;
            return this;
        }
    }

    public mb(C0700mb c0700mb) {
        this.ox = "";
        this.mb = c0700mb.mb;
        this.ox = c0700mb.ox;
        this.b = c0700mb.b;
        this.hj = c0700mb.hj;
        this.h = c0700mb.h;
    }
}
