package android.net;

import android.os.SystemClock;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* loaded from: source-9557208-dex2jar.jar:android/net/SntpClient.class */
public class SntpClient {
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int REFERENCE_TIME_OFFSET = 16;
    private static final String TAG = "SntpClient";
    private static final int TRANSMIT_TIME_OFFSET = 40;
    private long mNtpTime;
    private long mNtpTimeReference;
    private long mRoundTripTime;

    private long read32(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = (b & 128) == 128 ? (b & Byte.MAX_VALUE) + 128 : b;
        if ((b2 & 128) == 128) {
            b2 = (b2 & Byte.MAX_VALUE) + 128;
        }
        if ((b3 & 128) == 128) {
            b3 = (b3 & Byte.MAX_VALUE) + 128;
        }
        if ((b4 & 128) == 128) {
            b4 = (b4 & Byte.MAX_VALUE) + 128;
        }
        return (b5 << 24) + (b2 << 16) + (b3 << 8) + b4;
    }

    private long readTimeStamp(byte[] bArr, int i) {
        return ((read32(bArr, i) - OFFSET_1900_TO_1970) * 1000) + ((1000 * read32(bArr, i + 4)) / 4294967296L);
    }

    private void writeTimeStamp(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j2 + OFFSET_1900_TO_1970;
        int i2 = i + 1;
        bArr[i] = (byte) (j3 >> 24);
        int i3 = i2 + 1;
        bArr[i2] = (byte) (j3 >> 16);
        int i4 = i3 + 1;
        bArr[i3] = (byte) (j3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (j3 >> 0);
        long j4 = (4294967296L * (j - (1000 * j2))) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) (j4 >> 24);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (j4 >> 16);
        bArr[i7] = (byte) (j4 >> 8);
        bArr[i7 + 1] = (byte) (Math.random() * 255.0d);
    }

    public long getNtpTime() {
        return this.mNtpTime;
    }

    public long getNtpTimeReference() {
        return this.mNtpTimeReference;
    }

    public long getRoundTripTime() {
        return this.mRoundTripTime;
    }

    public boolean requestTime(String str, int i) {
        DatagramSocket datagramSocket;
        DatagramSocket datagramSocket2;
        boolean z;
        try {
            DatagramSocket datagramSocket3 = new DatagramSocket();
            try {
                datagramSocket3.setSoTimeout(i);
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, InetAddress.getByName(str), 123);
                bArr[0] = 27;
                long currentTimeMillis = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                writeTimeStamp(bArr, 40, currentTimeMillis);
                datagramSocket3.send(datagramPacket);
                datagramSocket3.receive(new DatagramPacket(bArr, bArr.length));
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
                long readTimeStamp = readTimeStamp(bArr, 24);
                long readTimeStamp2 = readTimeStamp(bArr, 32);
                long readTimeStamp3 = readTimeStamp(bArr, 40);
                this.mNtpTime = j + (((readTimeStamp2 - readTimeStamp) + (readTimeStamp3 - j)) / 2);
                this.mNtpTimeReference = elapsedRealtime2;
                this.mRoundTripTime = (elapsedRealtime2 - elapsedRealtime) - (readTimeStamp3 - readTimeStamp2);
                if (datagramSocket3 != null) {
                    datagramSocket3.close();
                }
                z = true;
            } catch (Exception e) {
                datagramSocket2 = datagramSocket3;
                z = false;
                if (datagramSocket2 != null) {
                    datagramSocket2.close();
                    return false;
                }
                return z;
            } catch (Throwable th) {
                datagramSocket = datagramSocket3;
                th = th;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            datagramSocket2 = null;
        } catch (Throwable th2) {
            th = th2;
            datagramSocket = null;
        }
        return z;
    }
}
