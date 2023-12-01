package com.kwad.sdk.crash.report.upload;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/crash/report/upload/e.class */
public final class e {
    public static e asI = new e(-11, "Please init.");
    public static e asJ = new e(-12, "error when zip_file");
    public static e asK = new e(-13, "There is no valid network.");
    public static e asL = new e(-14, "Token is invalid.");
    public static e asM = new e(-15, "upload task execute frequence exceed.");
    public static e asN = new e(-16, "process request fail.");
    public static e asO = new e(-17, "sever response error http code");
    public static e asP = new e(-18, "sever response error result code");
    public static e asQ = new e(-19, "server bad response.");
    private final int asR;
    private final String asS;

    private e(int i, String str) {
        this.asR = i;
        this.asS = str;
    }

    public final String Ai() {
        return this.asS;
    }
}
