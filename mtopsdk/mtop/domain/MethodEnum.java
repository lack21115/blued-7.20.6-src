package mtopsdk.mtop.domain;

import io.grpc.internal.GrpcUtil;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/domain/MethodEnum.class */
public enum MethodEnum {
    GET("GET"),
    POST(GrpcUtil.HTTP_METHOD);
    
    private String c;

    MethodEnum(String str) {
        this.c = str;
    }

    public final String a() {
        return this.c;
    }
}
