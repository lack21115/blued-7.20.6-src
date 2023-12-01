package mtopsdk.mtop.domain;

import java.util.Arrays;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/BaseOutDo.class */
public abstract class BaseOutDo implements IMTOPDataObject {
    private String a;
    private String b;
    private String[] c;

    public abstract Object b();

    public String toString() {
        return "BaseOutDo [api=" + this.a + ", v=" + this.b + ", ret=" + Arrays.toString(this.c) + "]";
    }
}
