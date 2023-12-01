package com.tencent.tmsbeacon.event.immediate;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/event/immediate/Beacon2MsfTransferArgs.class */
public class Beacon2MsfTransferArgs extends BeaconTransferArgs {
    private String d;

    public Beacon2MsfTransferArgs(byte[] bArr) {
        super(bArr);
        this.d = "trpc.Beacon.BeaconLogServerLC.blslongconnection.SsoProcess";
    }

    @Override // com.tencent.tmsbeacon.event.immediate.BeaconTransferArgs
    public String getCommand() {
        return this.d;
    }

    @Override // com.tencent.tmsbeacon.event.immediate.BeaconTransferArgs
    public void setCommand(String str) {
        this.d = str;
    }
}
