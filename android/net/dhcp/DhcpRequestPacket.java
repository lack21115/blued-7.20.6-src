package android.net.dhcp;

import android.util.Log;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/net/dhcp/DhcpRequestPacket.class */
class DhcpRequestPacket extends DhcpPacket {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhcpRequestPacket(int i, InetAddress inetAddress, byte[] bArr, boolean z) {
        super(i, inetAddress, Inet4Address.ANY, Inet4Address.ANY, Inet4Address.ANY, bArr, z);
    }

    @Override // android.net.dhcp.DhcpPacket
    public ByteBuffer buildPacket(int i, short s, short s2) {
        ByteBuffer allocate = ByteBuffer.allocate(1500);
        fillInPacket(i, Inet4Address.ALL, Inet4Address.ANY, s, s2, allocate, (byte) 1, this.mBroadcast);
        allocate.flip();
        return allocate;
    }

    @Override // android.net.dhcp.DhcpPacket
    public void doNextOp(DhcpStateMachine dhcpStateMachine) {
        InetAddress inetAddress = this.mRequestedIp == null ? this.mClientIp : this.mRequestedIp;
        Log.v("DhcpPacket", "requested IP is " + this.mRequestedIp + " and client IP is " + this.mClientIp);
        dhcpStateMachine.onRequestReceived(this.mBroadcast, this.mTransId, this.mClientMac, inetAddress, this.mRequestedParams, this.mHostName);
    }

    @Override // android.net.dhcp.DhcpPacket
    void finishPacket(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[7];
        bArr[0] = 1;
        System.arraycopy(this.mClientMac, 0, bArr, 1, 6);
        addTlv(byteBuffer, (byte) 53, (byte) 3);
        addTlv(byteBuffer, (byte) 55, this.mRequestedParams);
        addTlv(byteBuffer, (byte) 50, this.mRequestedIp);
        addTlv(byteBuffer, (byte) 54, this.mServerIdentifier);
        addTlv(byteBuffer, (byte) 61, bArr);
        addTlvEnd(byteBuffer);
    }

    @Override // android.net.dhcp.DhcpPacket
    public String toString() {
        return super.toString() + " REQUEST, desired IP " + this.mRequestedIp + " from host '" + this.mHostName + "', param list length " + (this.mRequestedParams == null ? 0 : this.mRequestedParams.length);
    }
}
