package android.net.dhcp;

import java.net.InetAddress;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/net/dhcp/DhcpInformPacket.class */
class DhcpInformPacket extends DhcpPacket {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhcpInformPacket(int i, InetAddress inetAddress, InetAddress inetAddress2, InetAddress inetAddress3, InetAddress inetAddress4, byte[] bArr) {
        super(i, inetAddress, inetAddress2, inetAddress3, inetAddress4, bArr, false);
    }

    @Override // android.net.dhcp.DhcpPacket
    public ByteBuffer buildPacket(int i, short s, short s2) {
        ByteBuffer allocate = ByteBuffer.allocate(1500);
        fillInPacket(i, this.mClientIp, this.mYourIp, s, s2, allocate, (byte) 1, false);
        allocate.flip();
        return allocate;
    }

    @Override // android.net.dhcp.DhcpPacket
    public void doNextOp(DhcpStateMachine dhcpStateMachine) {
        dhcpStateMachine.onInformReceived(this.mTransId, this.mClientMac, this.mRequestedIp == null ? this.mClientIp : this.mRequestedIp, this.mRequestedParams);
    }

    @Override // android.net.dhcp.DhcpPacket
    void finishPacket(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[7];
        bArr[0] = 1;
        System.arraycopy(this.mClientMac, 0, bArr, 1, 6);
        addTlv(byteBuffer, (byte) 53, (byte) 3);
        addTlv(byteBuffer, (byte) 55, this.mRequestedParams);
        addTlvEnd(byteBuffer);
    }

    @Override // android.net.dhcp.DhcpPacket
    public String toString() {
        return super.toString() + " INFORM";
    }
}
