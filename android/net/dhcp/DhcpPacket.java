package android.net.dhcp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/net/dhcp/DhcpPacket.class */
public abstract class DhcpPacket {
    protected static final byte CLIENT_ID_ETHER = 1;
    protected static final byte DHCP_BOOTREPLY = 2;
    protected static final byte DHCP_BOOTREQUEST = 1;
    protected static final byte DHCP_BROADCAST_ADDRESS = 28;
    static final short DHCP_CLIENT = 68;
    protected static final byte DHCP_CLIENT_IDENTIFIER = 61;
    protected static final byte DHCP_DNS_SERVER = 6;
    protected static final byte DHCP_DOMAIN_NAME = 15;
    protected static final byte DHCP_HOST_NAME = 12;
    protected static final byte DHCP_LEASE_TIME = 51;
    protected static final byte DHCP_MESSAGE = 56;
    protected static final byte DHCP_MESSAGE_TYPE = 53;
    protected static final byte DHCP_MESSAGE_TYPE_ACK = 5;
    protected static final byte DHCP_MESSAGE_TYPE_DECLINE = 4;
    protected static final byte DHCP_MESSAGE_TYPE_DISCOVER = 1;
    protected static final byte DHCP_MESSAGE_TYPE_INFORM = 8;
    protected static final byte DHCP_MESSAGE_TYPE_NAK = 6;
    protected static final byte DHCP_MESSAGE_TYPE_OFFER = 2;
    protected static final byte DHCP_MESSAGE_TYPE_REQUEST = 3;
    protected static final byte DHCP_PARAMETER_LIST = 55;
    protected static final byte DHCP_RENEWAL_TIME = 58;
    protected static final byte DHCP_REQUESTED_IP = 50;
    protected static final byte DHCP_ROUTER = 3;
    static final short DHCP_SERVER = 67;
    protected static final byte DHCP_SERVER_IDENTIFIER = 54;
    protected static final byte DHCP_SUBNET_MASK = 1;
    protected static final byte DHCP_VENDOR_CLASS_ID = 60;
    public static final int ENCAP_BOOTP = 2;
    public static final int ENCAP_L2 = 0;
    public static final int ENCAP_L3 = 1;
    private static final short IP_FLAGS_OFFSET = 16384;
    private static final byte IP_TOS_LOWDELAY = 16;
    private static final byte IP_TTL = 64;
    private static final byte IP_TYPE_UDP = 17;
    private static final byte IP_VERSION_HEADER_LEN = 69;
    protected static final int MAX_LENGTH = 1500;
    protected static final String TAG = "DhcpPacket";
    protected boolean mBroadcast;
    protected InetAddress mBroadcastAddress;
    protected final InetAddress mClientIp;
    protected final byte[] mClientMac;
    protected List<InetAddress> mDnsServers;
    protected String mDomainName;
    protected InetAddress mGateway;
    protected String mHostName;
    protected Integer mLeaseTime;
    protected String mMessage;
    private final InetAddress mNextIp;
    private final InetAddress mRelayIp;
    protected InetAddress mRequestedIp;
    protected byte[] mRequestedParams;
    protected InetAddress mServerIdentifier;
    protected InetAddress mSubnetMask;
    protected final int mTransId;
    protected final InetAddress mYourIp;

    /* JADX INFO: Access modifiers changed from: protected */
    public DhcpPacket(int i, InetAddress inetAddress, InetAddress inetAddress2, InetAddress inetAddress3, InetAddress inetAddress4, byte[] bArr, boolean z) {
        this.mTransId = i;
        this.mClientIp = inetAddress;
        this.mYourIp = inetAddress2;
        this.mNextIp = inetAddress3;
        this.mRelayIp = inetAddress4;
        this.mClientMac = bArr;
        this.mBroadcast = z;
    }

    public static ByteBuffer buildAckPacket(int i, int i2, boolean z, InetAddress inetAddress, InetAddress inetAddress2, byte[] bArr, Integer num, InetAddress inetAddress3, InetAddress inetAddress4, InetAddress inetAddress5, List<InetAddress> list, InetAddress inetAddress6, String str) {
        DhcpAckPacket dhcpAckPacket = new DhcpAckPacket(i2, z, inetAddress, inetAddress2, bArr);
        dhcpAckPacket.mGateway = inetAddress5;
        dhcpAckPacket.mDnsServers = list;
        dhcpAckPacket.mLeaseTime = num;
        dhcpAckPacket.mDomainName = str;
        dhcpAckPacket.mSubnetMask = inetAddress3;
        dhcpAckPacket.mServerIdentifier = inetAddress6;
        dhcpAckPacket.mBroadcastAddress = inetAddress4;
        return dhcpAckPacket.buildPacket(i, (short) 68, (short) 67);
    }

    public static ByteBuffer buildDiscoverPacket(int i, int i2, byte[] bArr, boolean z, byte[] bArr2) {
        DhcpDiscoverPacket dhcpDiscoverPacket = new DhcpDiscoverPacket(i2, bArr, z);
        dhcpDiscoverPacket.mRequestedParams = bArr2;
        return dhcpDiscoverPacket.buildPacket(i, (short) 67, (short) 68);
    }

    public static ByteBuffer buildNakPacket(int i, int i2, InetAddress inetAddress, InetAddress inetAddress2, byte[] bArr) {
        DhcpNakPacket dhcpNakPacket = new DhcpNakPacket(i2, inetAddress2, inetAddress, inetAddress, inetAddress, bArr);
        dhcpNakPacket.mMessage = "requested address not available";
        dhcpNakPacket.mRequestedIp = inetAddress2;
        return dhcpNakPacket.buildPacket(i, (short) 68, (short) 67);
    }

    public static ByteBuffer buildOfferPacket(int i, int i2, boolean z, InetAddress inetAddress, InetAddress inetAddress2, byte[] bArr, Integer num, InetAddress inetAddress3, InetAddress inetAddress4, InetAddress inetAddress5, List<InetAddress> list, InetAddress inetAddress6, String str) {
        DhcpOfferPacket dhcpOfferPacket = new DhcpOfferPacket(i2, z, inetAddress, inetAddress2, bArr);
        dhcpOfferPacket.mGateway = inetAddress5;
        dhcpOfferPacket.mDnsServers = list;
        dhcpOfferPacket.mLeaseTime = num;
        dhcpOfferPacket.mDomainName = str;
        dhcpOfferPacket.mServerIdentifier = inetAddress6;
        dhcpOfferPacket.mSubnetMask = inetAddress3;
        dhcpOfferPacket.mBroadcastAddress = inetAddress4;
        return dhcpOfferPacket.buildPacket(i, (short) 68, (short) 67);
    }

    public static ByteBuffer buildRequestPacket(int i, int i2, InetAddress inetAddress, boolean z, byte[] bArr, InetAddress inetAddress2, InetAddress inetAddress3, byte[] bArr2, String str) {
        DhcpRequestPacket dhcpRequestPacket = new DhcpRequestPacket(i2, inetAddress, bArr, z);
        dhcpRequestPacket.mRequestedIp = inetAddress2;
        dhcpRequestPacket.mServerIdentifier = inetAddress3;
        dhcpRequestPacket.mHostName = str;
        dhcpRequestPacket.mRequestedParams = bArr2;
        return dhcpRequestPacket.buildPacket(i, (short) 67, (short) 68);
    }

    private int checksum(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int position = byteBuffer.position();
        byteBuffer.position(i2);
        ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
        byteBuffer.position(position);
        short[] sArr = new short[(i3 - i2) / 2];
        asShortBuffer.get(sArr);
        int length = sArr.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length) {
                break;
            }
            i += intAbs(sArr[i5]);
            i4 = i5 + 1;
        }
        int length2 = i2 + (sArr.length * 2);
        int i6 = i;
        if (i3 != length2) {
            short s = byteBuffer.get(length2);
            short s2 = s;
            if (s < 0) {
                s2 = (short) (s + 256);
            }
            i6 = i + (s2 * 256);
        }
        int i7 = ((i6 >> 16) & 65535) + (65535 & i6);
        return intAbs((short) (((((i7 >> 16) & 65535) + i7) & 65535) ^ (-1)));
    }

    public static DhcpPacket decodeFullPacket(ByteBuffer byteBuffer, int i) {
        DhcpPacket dhcpInformPacket;
        int i2;
        InetAddress inetAddress;
        byte b;
        String str;
        byte[] bArr;
        InetAddress inetAddress2;
        String str2;
        Integer num;
        String str3;
        InetAddress inetAddress3;
        InetAddress inetAddress4;
        InetAddress inetAddress5;
        ArrayList arrayList = new ArrayList();
        InetAddress inetAddress6 = null;
        Integer num2 = null;
        InetAddress inetAddress7 = null;
        InetAddress inetAddress8 = null;
        String str4 = null;
        byte[] bArr2 = null;
        String str5 = null;
        String str6 = null;
        InetAddress inetAddress9 = null;
        InetAddress inetAddress10 = null;
        InetAddress inetAddress11 = null;
        byte b2 = -1;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        if (i == 0) {
            byteBuffer.get(new byte[6]);
            byteBuffer.get(new byte[6]);
            if (byteBuffer.getShort() != 2048) {
                return null;
            }
        }
        if (i == 0 || i == 1) {
            byteBuffer.get();
            byteBuffer.get();
            byteBuffer.getShort();
            byteBuffer.getShort();
            byteBuffer.get();
            byteBuffer.get();
            byteBuffer.get();
            byte b3 = byteBuffer.get();
            byteBuffer.getShort();
            InetAddress readIpAddress = readIpAddress(byteBuffer);
            readIpAddress(byteBuffer);
            if (b3 != 17) {
                return null;
            }
            short s = byteBuffer.getShort();
            byteBuffer.getShort();
            byteBuffer.getShort();
            byteBuffer.getShort();
            inetAddress9 = readIpAddress;
            if (s != 67) {
                inetAddress9 = readIpAddress;
                if (s != 68) {
                    return null;
                }
            }
        }
        byteBuffer.get();
        byteBuffer.get();
        int i3 = byteBuffer.get();
        byteBuffer.get();
        int i4 = byteBuffer.getInt();
        byteBuffer.getShort();
        boolean z = (32768 & byteBuffer.getShort()) != 0;
        byte[] bArr3 = new byte[4];
        try {
            byteBuffer.get(bArr3);
            InetAddress byAddress = InetAddress.getByAddress(bArr3);
            byteBuffer.get(bArr3);
            InetAddress byAddress2 = InetAddress.getByAddress(bArr3);
            byteBuffer.get(bArr3);
            InetAddress byAddress3 = InetAddress.getByAddress(bArr3);
            byteBuffer.get(bArr3);
            InetAddress byAddress4 = InetAddress.getByAddress(bArr3);
            byte[] bArr4 = new byte[i3];
            byteBuffer.get(bArr4);
            byteBuffer.position(byteBuffer.position() + (16 - i3) + 64 + 128);
            if (byteBuffer.getInt() != 1669485411) {
                return null;
            }
            boolean z2 = true;
            while (byteBuffer.position() < byteBuffer.limit() && z2) {
                byte b4 = byteBuffer.get();
                if (b4 == -1) {
                    z2 = false;
                } else {
                    int i5 = byteBuffer.get();
                    int i6 = 0;
                    switch (b4) {
                        case 1:
                            inetAddress3 = readIpAddress(byteBuffer);
                            i2 = 4;
                            inetAddress5 = inetAddress7;
                            inetAddress4 = inetAddress11;
                            str3 = str4;
                            num = num2;
                            str2 = str5;
                            inetAddress2 = inetAddress6;
                            bArr = bArr2;
                            str = str6;
                            b = b2;
                            inetAddress = inetAddress10;
                            break;
                        case 3:
                            inetAddress2 = readIpAddress(byteBuffer);
                            i2 = 4;
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 6:
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                inetAddress = inetAddress10;
                                b = b2;
                                str = str6;
                                i2 = i8;
                                bArr = bArr2;
                                inetAddress2 = inetAddress6;
                                str2 = str5;
                                num = num2;
                                str3 = str4;
                                inetAddress3 = inetAddress8;
                                inetAddress4 = inetAddress11;
                                inetAddress5 = inetAddress7;
                                if (i8 >= i5) {
                                    break;
                                } else {
                                    arrayList.add(readIpAddress(byteBuffer));
                                    i7 = i8 + 4;
                                }
                            }
                        case 12:
                            i2 = i5;
                            str2 = readAsciiString(byteBuffer, i5);
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 15:
                            i2 = i5;
                            str = readAsciiString(byteBuffer, i5);
                            inetAddress = inetAddress10;
                            b = b2;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 28:
                            inetAddress = readIpAddress(byteBuffer);
                            i2 = 4;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 50:
                            inetAddress4 = readIpAddress(byteBuffer);
                            i2 = 4;
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress5 = inetAddress7;
                            break;
                        case 51:
                            num = Integer.valueOf(byteBuffer.getInt());
                            i2 = 4;
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 53:
                            b = byteBuffer.get();
                            i2 = 1;
                            inetAddress = inetAddress10;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 54:
                            inetAddress5 = readIpAddress(byteBuffer);
                            i2 = 4;
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            break;
                        case 55:
                            bArr = new byte[i5];
                            byteBuffer.get(bArr);
                            i2 = i5;
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 56:
                            i2 = i5;
                            str3 = readAsciiString(byteBuffer, i5);
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 60:
                            i2 = i5;
                            readAsciiString(byteBuffer, i5);
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        case 61:
                            byteBuffer.get(new byte[i5]);
                            i2 = i5;
                            inetAddress = inetAddress10;
                            b = b2;
                            str = str6;
                            bArr = bArr2;
                            inetAddress2 = inetAddress6;
                            str2 = str5;
                            num = num2;
                            str3 = str4;
                            inetAddress3 = inetAddress8;
                            inetAddress4 = inetAddress11;
                            inetAddress5 = inetAddress7;
                            break;
                        default:
                            int i9 = 0;
                            while (true) {
                                int i10 = i9;
                                inetAddress = inetAddress10;
                                b = b2;
                                str = str6;
                                i2 = i6;
                                bArr = bArr2;
                                inetAddress2 = inetAddress6;
                                str2 = str5;
                                num = num2;
                                str3 = str4;
                                inetAddress3 = inetAddress8;
                                inetAddress4 = inetAddress11;
                                inetAddress5 = inetAddress7;
                                if (i10 >= i5) {
                                    break;
                                } else {
                                    i6++;
                                    byteBuffer.get();
                                    i9 = i10 + 1;
                                }
                            }
                    }
                    inetAddress10 = inetAddress;
                    b2 = b;
                    str6 = str;
                    bArr2 = bArr;
                    inetAddress6 = inetAddress2;
                    str5 = str2;
                    num2 = num;
                    str4 = str3;
                    inetAddress8 = inetAddress3;
                    inetAddress11 = inetAddress4;
                    inetAddress7 = inetAddress5;
                    if (i2 != i5) {
                        return null;
                    }
                }
            }
            switch (b2) {
                case -1:
                    return null;
                case 0:
                case 7:
                default:
                    System.out.println("Unimplemented type: " + ((int) b2));
                    return null;
                case 1:
                    dhcpInformPacket = new DhcpDiscoverPacket(i4, bArr4, z);
                    break;
                case 2:
                    dhcpInformPacket = new DhcpOfferPacket(i4, z, inetAddress9, byAddress2, bArr4);
                    break;
                case 3:
                    dhcpInformPacket = new DhcpRequestPacket(i4, byAddress, bArr4, z);
                    break;
                case 4:
                    dhcpInformPacket = new DhcpDeclinePacket(i4, byAddress, byAddress2, byAddress3, byAddress4, bArr4);
                    break;
                case 5:
                    dhcpInformPacket = new DhcpAckPacket(i4, z, inetAddress9, byAddress2, bArr4);
                    break;
                case 6:
                    dhcpInformPacket = new DhcpNakPacket(i4, byAddress, byAddress2, byAddress3, byAddress4, bArr4);
                    break;
                case 8:
                    dhcpInformPacket = new DhcpInformPacket(i4, byAddress, byAddress2, byAddress3, byAddress4, bArr4);
                    break;
            }
            dhcpInformPacket.mBroadcastAddress = inetAddress10;
            dhcpInformPacket.mDnsServers = arrayList;
            dhcpInformPacket.mDomainName = str6;
            dhcpInformPacket.mGateway = inetAddress6;
            dhcpInformPacket.mHostName = str5;
            dhcpInformPacket.mLeaseTime = num2;
            dhcpInformPacket.mMessage = str4;
            dhcpInformPacket.mRequestedIp = inetAddress11;
            dhcpInformPacket.mRequestedParams = bArr2;
            dhcpInformPacket.mServerIdentifier = inetAddress7;
            dhcpInformPacket.mSubnetMask = inetAddress8;
            return dhcpInformPacket;
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public static DhcpPacket decodeFullPacket(byte[] bArr, int i) {
        return decodeFullPacket(ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN), i);
    }

    private int intAbs(short s) {
        return s < 0 ? s + 65536 : s;
    }

    public static String macToString(byte[] bArr) {
        String str = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return str;
            }
            String str2 = "0" + Integer.toHexString(bArr[i2]);
            String str3 = str + str2.substring(str2.length() - 2);
            str = str3;
            if (i2 != bArr.length - 1) {
                str = str3 + ":";
            }
            i = i2 + 1;
        }
    }

    private static String readAsciiString(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return new String(bArr, 0, bArr.length, StandardCharsets.US_ASCII);
    }

    private static InetAddress readIpAddress(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlv(ByteBuffer byteBuffer, byte b, byte b2) {
        byteBuffer.put(b);
        byteBuffer.put((byte) 1);
        byteBuffer.put(b2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlv(ByteBuffer byteBuffer, byte b, Integer num) {
        if (num != null) {
            byteBuffer.put(b);
            byteBuffer.put((byte) 4);
            byteBuffer.putInt(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlv(ByteBuffer byteBuffer, byte b, String str) {
        if (str == null) {
            return;
        }
        byteBuffer.put(b);
        byteBuffer.put((byte) str.length());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                return;
            }
            byteBuffer.put((byte) str.charAt(i2));
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlv(ByteBuffer byteBuffer, byte b, InetAddress inetAddress) {
        if (inetAddress != null) {
            addTlv(byteBuffer, b, inetAddress.getAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlv(ByteBuffer byteBuffer, byte b, List<InetAddress> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        byteBuffer.put(b);
        byteBuffer.put((byte) (list.size() * 4));
        for (InetAddress inetAddress : list) {
            byteBuffer.put(inetAddress.getAddress());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlv(ByteBuffer byteBuffer, byte b, byte[] bArr) {
        if (bArr != null) {
            byteBuffer.put(b);
            byteBuffer.put((byte) bArr.length);
            byteBuffer.put(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addTlvEnd(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) -1);
    }

    public abstract ByteBuffer buildPacket(int i, short s, short s2);

    public abstract void doNextOp(DhcpStateMachine dhcpStateMachine);

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillInPacket(int i, InetAddress inetAddress, InetAddress inetAddress2, short s, short s2, ByteBuffer byteBuffer, byte b, boolean z) {
        byte[] address = inetAddress.getAddress();
        byte[] address2 = inetAddress2.getAddress();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        byteBuffer.clear();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        if (i == 1) {
            byteBuffer.put((byte) 69);
            byteBuffer.put((byte) 16);
            i2 = byteBuffer.position();
            byteBuffer.putShort((short) 0);
            byteBuffer.putShort((short) 0);
            byteBuffer.putShort((short) 16384);
            byteBuffer.put((byte) 64);
            byteBuffer.put((byte) 17);
            i3 = byteBuffer.position();
            byteBuffer.putShort((short) 0);
            byteBuffer.put(address2);
            byteBuffer.put(address);
            i4 = byteBuffer.position();
            i5 = byteBuffer.position();
            byteBuffer.putShort(s2);
            byteBuffer.putShort(s);
            i6 = byteBuffer.position();
            byteBuffer.putShort((short) 0);
            i7 = byteBuffer.position();
            byteBuffer.putShort((short) 0);
        }
        byteBuffer.put(b);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) this.mClientMac.length);
        byteBuffer.put((byte) 0);
        byteBuffer.putInt(this.mTransId);
        byteBuffer.putShort((short) 0);
        if (z) {
            byteBuffer.putShort(Short.MIN_VALUE);
        } else {
            byteBuffer.putShort((short) 0);
        }
        byteBuffer.put(this.mClientIp.getAddress());
        byteBuffer.put(this.mYourIp.getAddress());
        byteBuffer.put(this.mNextIp.getAddress());
        byteBuffer.put(this.mRelayIp.getAddress());
        byteBuffer.put(this.mClientMac);
        byteBuffer.position(byteBuffer.position() + (16 - this.mClientMac.length) + 64 + 128);
        byteBuffer.putInt(1669485411);
        finishPacket(byteBuffer);
        if ((byteBuffer.position() & 1) == 1) {
            byteBuffer.put((byte) 0);
        }
        if (i == 1) {
            short position = (short) (byteBuffer.position() - i5);
            byteBuffer.putShort(i6, position);
            byteBuffer.putShort(i7, (short) checksum(byteBuffer, 0 + intAbs(byteBuffer.getShort(i3 + 2)) + intAbs(byteBuffer.getShort(i3 + 4)) + intAbs(byteBuffer.getShort(i3 + 6)) + intAbs(byteBuffer.getShort(i3 + 8)) + 17 + position, i5, byteBuffer.position()));
            byteBuffer.putShort(i2, (short) byteBuffer.position());
            byteBuffer.putShort(i3, (short) checksum(byteBuffer, 0, 0, i4));
        }
    }

    abstract void finishPacket(ByteBuffer byteBuffer);

    public int getTransactionId() {
        return this.mTransId;
    }

    public String toString() {
        return macToString(this.mClientMac);
    }
}
