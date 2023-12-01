package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.util.BitSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/dns/local/DnsMessage.class */
public final class DnsMessage {
    public static byte[] buildQuery(String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        BitSet bitSet = new BitSet();
        bitSet.set(8);
        try {
            dataOutputStream.writeShort((short) i);
            dataOutputStream.writeShort((short) bitSet.value());
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
            writeQuestion(byteArrayOutputStream, str);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static Record[] parseResponse(byte[] bArr, int i, String str) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        if (readUnsignedShort != i) {
            throw new DnsException(str, "the answer id " + readUnsignedShort + " is not match " + i);
        }
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        boolean z = true;
        boolean z2 = ((readUnsignedShort2 >> 8) & 1) == 1;
        if (((readUnsignedShort2 >> 7) & 1) != 1) {
            z = false;
        }
        if (z && z2) {
            int readUnsignedShort3 = dataInputStream.readUnsignedShort();
            int readUnsignedShort4 = dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            readQuestions(dataInputStream, bArr, readUnsignedShort3);
            return readAnswers(dataInputStream, bArr, readUnsignedShort4);
        }
        throw new DnsException(str, "the dns server cant support recursion ");
    }

    private static Record[] readAnswers(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        Record[] recordArr = new Record[i];
        int i2 = 0;
        while (i > 0) {
            recordArr[i2] = readRecord(dataInputStream, bArr);
            i2++;
            i--;
        }
        return recordArr;
    }

    private static String readName(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & 192) == 192) {
            int readUnsignedByte2 = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte2));
            return readName(bArr, readUnsignedByte2, hashSet);
        } else if (readUnsignedByte == 0) {
            return "";
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            String unicode = IDN.toUnicode(new String(bArr2));
            String readName = readName(dataInputStream, bArr);
            String str = unicode;
            if (readName.length() > 0) {
                str = unicode + "." + readName;
            }
            return str;
        }
    }

    private static String readName(byte[] bArr, int i, HashSet<Integer> hashSet) throws IOException {
        int i2 = bArr[i] & 255;
        if ((i2 & 192) == 192) {
            int i3 = ((i2 & 63) << 8) + (bArr[i + 1] & 255);
            if (hashSet.contains(Integer.valueOf(i3))) {
                throw new DnsException("", "Cyclic offsets detected.");
            }
            hashSet.add(Integer.valueOf(i3));
            return readName(bArr, i3, hashSet);
        } else if (i2 == 0) {
            return "";
        } else {
            int i4 = i + 1;
            String str = new String(bArr, i4, i2);
            String readName = readName(bArr, i4 + i2, hashSet);
            String str2 = str;
            if (readName.length() > 0) {
                str2 = str + "." + readName;
            }
            return str2;
        }
    }

    private static void readQuestions(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        while (i > 0) {
            readName(dataInputStream, bArr);
            dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            i--;
        }
    }

    private static Record readRecord(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        String hostAddress;
        readName(dataInputStream, bArr);
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        long readUnsignedShort2 = dataInputStream.readUnsignedShort();
        long readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        if (readUnsignedShort == 1) {
            byte[] bArr2 = new byte[4];
            dataInputStream.readFully(bArr2);
            hostAddress = InetAddress.getByAddress(bArr2).getHostAddress();
        } else if (readUnsignedShort != 5) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readUnsignedShort4) {
                    break;
                }
                dataInputStream.readByte();
                i = i2 + 1;
            }
            hostAddress = null;
        } else {
            hostAddress = readName(dataInputStream, bArr);
        }
        if (hostAddress != null) {
            return new Record(hostAddress, readUnsignedShort, (int) ((readUnsignedShort2 << 16) + readUnsignedShort3), System.currentTimeMillis() / 1000);
        }
        throw new UnknownHostException("no record");
    }

    private static void writeDomain(OutputStream outputStream, String str) throws IOException {
        String[] split = str.split("[.。．｡]");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                outputStream.write(0);
                return;
            }
            byte[] bytes = IDN.toASCII(split[i2]).getBytes();
            outputStream.write(bytes.length);
            outputStream.write(bytes, 0, bytes.length);
            i = i2 + 1;
        }
    }

    private static void writeQuestion(OutputStream outputStream, String str) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        writeDomain(outputStream, str);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(1);
    }
}
