package android.net.dhcp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: source-9557208-dex2jar.jar:android/net/dhcp/DhcpOfferPacket.class */
class DhcpOfferPacket extends DhcpPacket {
    private final InetAddress mSrcIp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DhcpOfferPacket(int i, boolean z, InetAddress inetAddress, InetAddress inetAddress2, byte[] bArr) {
        super(i, Inet4Address.ANY, inetAddress2, Inet4Address.ANY, Inet4Address.ANY, bArr, z);
        this.mSrcIp = inetAddress;
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
        dhcpStateMachine.onOfferReceived(this.mBroadcast, this.mTransId, this.mClientMac, this.mYourIp, this.mServerIdentifier);
    }

    @Override // android.net.dhcp.DhcpPacket
    void finishPacket(ByteBuffer byteBuffer) {
        addTlv(byteBuffer, (byte) 53, (byte) 2);
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
        String str = ", DNS servers: ";
        String str2 = str;
        if (this.mDnsServers != null) {
            while (true) {
                str2 = str;
                if (!this.mDnsServers.iterator().hasNext()) {
                    break;
                }
                str = str + it.next() + " ";
            }
        }
        return dhcpPacket + " OFFER, ip " + this.mYourIp + ", mask " + this.mSubnetMask + str2 + ", gateway " + this.mGateway + " lease time " + this.mLeaseTime + ", domain " + this.mDomainName;
    }
}
