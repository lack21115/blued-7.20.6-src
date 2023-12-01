package android.net.dhcp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/dhcp/DhcpAckPacket.class */
class DhcpAckPacket extends DhcpPacket {
    private final InetAddress mSrcIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DhcpAckPacket(int i, boolean z, InetAddress inetAddress, InetAddress inetAddress2, byte[] bArr) {
        super(i, Inet4Address.ANY, inetAddress2, inetAddress, Inet4Address.ANY, bArr, z);
        this.mBroadcast = z;
        this.mSrcIp = inetAddress;
    }

    private static final int getInt(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // android.net.dhcp.DhcpPacket
    public ByteBuffer buildPacket(int i, short s, short s2) {
        ByteBuffer allocate = ByteBuffer.allocate(1500);
        fillInPacket(i, this.mBroadcast ? Inet4Address.ALL : this.mYourIp, this.mBroadcast ? Inet4Address.ANY : this.mSrcIp, s, s2, allocate, (byte) 2, this.mBroadcast);
        allocate.flip();
        return allocate;
    }

    @Override // android.net.dhcp.DhcpPacket
    public void doNextOp(DhcpStateMachine dhcpStateMachine) {
        dhcpStateMachine.onAckReceived(this.mYourIp, this.mSubnetMask, this.mGateway, this.mDnsServers, this.mServerIdentifier, getInt(this.mLeaseTime));
    }

    @Override // android.net.dhcp.DhcpPacket
    void finishPacket(ByteBuffer byteBuffer) {
        addTlv(byteBuffer, (byte) 53, (byte) 5);
        addTlv(byteBuffer, (byte) 54, this.mServerIdentifier);
        addTlv(byteBuffer, (byte) 51, this.mLeaseTime);
        if (this.mLeaseTime != null) {
            addTlv(byteBuffer, (byte) 58, Integer.valueOf(this.mLeaseTime.intValue() / 2));
        }
        addTlv(byteBuffer, (byte) 1, this.mSubnetMask);
        addTlv(byteBuffer, (byte) 3, this.mGateway);
        addTlv(byteBuffer, (byte) 15, this.mDomainName);
        addTlv(byteBuffer, (byte) 28, this.mBroadcastAddress);
        addTlv(byteBuffer, (byte) 6, this.mDnsServers);
        addTlvEnd(byteBuffer);
    }

    @Override // android.net.dhcp.DhcpPacket
    public String toString() {
        Iterator<InetAddress> it;
        String dhcpPacket = super.toString();
        String str = " DNS servers: ";
        while (this.mDnsServers.iterator().hasNext()) {
            str = str + it.next().toString() + " ";
        }
        return dhcpPacket + " ACK: your new IP " + this.mYourIp + ", netmask " + this.mSubnetMask + ", gateway " + this.mGateway + str + ", lease time " + this.mLeaseTime;
    }
}
