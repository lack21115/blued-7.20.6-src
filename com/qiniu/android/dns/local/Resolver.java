package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/Resolver.class */
public final class Resolver implements IResolver {
    private static final Random random = new Random();
    final InetAddress address;
    private final int timeout;

    public Resolver(InetAddress inetAddress) {
        this(inetAddress, 10);
    }

    public Resolver(InetAddress inetAddress, int i) {
        this.address = inetAddress;
        this.timeout = i;
    }

    private byte[] udpCommunicate(byte[] bArr) throws IOException {
        DatagramSocket datagramSocket;
        try {
            DatagramSocket datagramSocket2 = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.address, 53);
                datagramSocket2.setSoTimeout(this.timeout * 1000);
                datagramSocket2.send(datagramPacket);
                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1500], 1500);
                datagramSocket2.receive(datagramPacket2);
                byte[] data = datagramPacket2.getData();
                datagramSocket2.close();
                return data;
            } catch (Throwable th) {
                datagramSocket = datagramSocket2;
                th = th;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            datagramSocket = null;
        }
    }

    @Override // com.qiniu.android.dns.IResolver
    public Record[] resolve(Domain domain, NetworkInfo networkInfo) throws IOException {
        int nextInt;
        synchronized (random) {
            nextInt = random.nextInt() & 255;
        }
        byte[] udpCommunicate = udpCommunicate(DnsMessage.buildQuery(domain.domain, nextInt));
        if (udpCommunicate != null) {
            return DnsMessage.parseResponse(udpCommunicate, nextInt, domain.domain);
        }
        throw new DnsException(domain.domain, "cant get answer");
    }
}
