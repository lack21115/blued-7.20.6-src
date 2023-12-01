package com.huawei.hms.ads;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kn.class */
public class kn {
    Long B;
    Boolean C;
    Long Code;
    Integer I;
    String S;
    Integer V;
    String Z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kn$a.class */
    public static final class a {
        Long B;
        Boolean C;
        Long Code;
        Integer I;
        String S;
        Integer V;
        String Z;

        public a Code(Boolean bool) {
            this.C = bool;
            return this;
        }

        public a Code(Integer num) {
            this.V = num;
            return this;
        }

        public a Code(Long l) {
            this.Code = l;
            return this;
        }

        public a Code(String str) {
            this.Z = str;
            return this;
        }

        public kn Code() {
            kn knVar = new kn();
            knVar.Code = this.Code;
            knVar.V = this.V;
            knVar.I = this.I;
            knVar.B = this.B;
            knVar.Z = this.Z;
            knVar.C = this.C;
            knVar.S = this.S;
            return knVar;
        }

        public a V(Integer num) {
            this.I = num;
            return this;
        }

        public a V(Long l) {
            this.B = l;
            return this;
        }

        public a V(String str) {
            this.S = str;
            return this;
        }
    }

    public Long B() {
        return this.B;
    }

    public Boolean C() {
        return this.C;
    }

    public Long Code() {
        return this.Code;
    }

    public void Code(Boolean bool) {
        this.C = bool;
    }

    public void Code(Integer num) {
        this.V = num;
    }

    public void Code(Long l) {
        this.Code = l;
    }

    public void Code(String str) {
        this.Z = str;
    }

    public Integer I() {
        return this.I;
    }

    public String S() {
        return this.S;
    }

    public Integer V() {
        return this.V;
    }

    public void V(Integer num) {
        this.I = num;
    }

    public void V(Long l) {
        this.B = l;
    }

    public void V(String str) {
        this.S = str;
    }

    public String Z() {
        return this.Z;
    }
}
