package android.net.dhcp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/net/dhcp/DhcpDiscoverPacket.class */
class DhcpDiscoverPacket extends DhcpPacket {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DhcpDiscoverPacket(int i, byte[] bArr, boolean z) {
        super(i, Inet4Address.ANY, Inet4Address.ANY, Inet4Address.ANY, Inet4Address.ANY, bArr, z);
    }

    @Override // android.net.dhcp.DhcpPacket
    public ByteBuffer buildPacket(int i, short s, short s2) {
        ByteBuffer allocate = ByteBuffer.allocate(1500);
        InetAddress inetAddress = Inet4Address.ALL;
        fillInPacket(i, Inet4Address.ALL, Inet4Address.ANY, s, s2, allocate, (byte) 1, true);
        allocate.flip();
        return allocate;
    }

    @Override // android.net.dhcp.DhcpPacket
    public void doNextOp(DhcpStateMachine dhcpStateMachine) {
        dhcpStateMachine.onDiscoverReceived(this.mBroadcast, this.mTransId, this.mClientMac, this.mRequestedParams);
    }

    @Override // android.net.dhcp.DhcpPacket
    void finishPacket(ByteBuffer byteBuffer) {
        addTlv(byteBuffer, (byte) 53, (byte) 1);
        addTlv(byteBuffer, (byte) 55, this.mRequestedParams);
        addTlvEnd(byteBuffer);
    }

    @Override // android.net.dhcp.DhcpPacket
    public String toString() {
        return super.toString() + " DISCOVER " + (this.mBroadcast ? "broadcast " : "unicast ");
    }
}
