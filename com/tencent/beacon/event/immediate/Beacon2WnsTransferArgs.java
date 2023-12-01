package com.tencent.beacon.event.immediate;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/event/immediate/Beacon2WnsTransferArgs.class */
public class Beacon2WnsTransferArgs extends BeaconTransferArgs {
    private String d;

    public Beacon2WnsTransferArgs(byte[] bArr) {
        super(bArr);
        this.d = "bls.longconnection";
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
