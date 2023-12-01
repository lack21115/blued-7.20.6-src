package mtopsdk.mtop.domain;

import java.util.Arrays;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/BaseOutDo.class */
public abstract class BaseOutDo implements IMTOPDataObject {

    /* renamed from: a  reason: collision with root package name */
    private String f43733a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f43734c;

    public abstract Object b();

    public String toString() {
        return "BaseOutDo [api=" + this.f43733a + ", v=" + this.b + ", ret=" + Arrays.toString(this.f43734c) + "]";
    }
}
