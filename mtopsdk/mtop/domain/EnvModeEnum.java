package mtopsdk.mtop.domain;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/EnvModeEnum.class */
public enum EnvModeEnum {
    ONLINE(0),
    PREPARE(1),
    TEST(2),
    TEST_SANDBOX(3);
    
    private int e;

    EnvModeEnum(int i) {
        this.e = i;
    }

    public final int a() {
        return this.e;
    }
}
