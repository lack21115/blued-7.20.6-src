package com.tencent.beacon.event.immediate;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/immediate/Beacon2MsfTransferArgs.class */
public class Beacon2MsfTransferArgs extends BeaconTransferArgs {
    private String d;

    public Beacon2MsfTransferArgs(byte[] bArr) {
        super(bArr);
        this.d = "trpc.Beacon.BeaconLogServerLC.blslongconnection.SsoProcess";
    }

    @Override // com.tencent.beacon.event.immediate.BeaconTransferArgs
    public String getCommand() {
        return this.d;
    }

    @Override // com.tencent.beacon.event.immediate.BeaconTransferArgs
    public void setCommand(String str) {
        this.d = str;
    }
}
