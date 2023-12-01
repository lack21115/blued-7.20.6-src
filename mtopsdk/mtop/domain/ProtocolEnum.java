package mtopsdk.mtop.domain;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/ProtocolEnum.class */
public enum ProtocolEnum {
    HTTP("http://"),
    HTTPSECURE("https://");
    
    private String c;

    ProtocolEnum(String str) {
        this.c = str;
    }

    public final String a() {
        return this.c;
    }
}
