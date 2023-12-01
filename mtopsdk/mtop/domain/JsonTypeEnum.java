package mtopsdk.mtop.domain;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/JsonTypeEnum.class */
public enum JsonTypeEnum {
    JSON("json"),
    ORIGINALJSON("originaljson");
    
    private String c;

    JsonTypeEnum(String str) {
        this.c = str;
    }

    public final String a() {
        return this.c;
    }
}
