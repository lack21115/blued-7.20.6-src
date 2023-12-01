package mtopsdk.mtop.domain;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/ProtocolEnum.class */
public enum ProtocolEnum {
    HTTP("http://"),
    HTTPSECURE("https://");
    

    /* renamed from: c  reason: collision with root package name */
    private String f43752c;

    ProtocolEnum(String str) {
        this.f43752c = str;
    }

    public final String a() {
        return this.f43752c;
    }
}
