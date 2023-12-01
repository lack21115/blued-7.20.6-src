package com.tencent.cos.xml.model.tag.eventstreaming;

import android.net.http.Headers;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.s3.Base64;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/Message.class */
public class Message {
    static final int MESSAGE_OVERHEAD = 16;
    private static final int TRAILING_CRC_LENGTH = 4;
    private final Map<String, HeaderValue> headers;
    private final byte[] payload;

    public Message(Map<String, HeaderValue> map, byte[] bArr) {
        this.headers = map;
        this.payload = (byte[]) bArr.clone();
    }

    public static Message decode(ByteBuffer byteBuffer) throws CosXmlServiceException {
        Prelude decode = Prelude.decode(byteBuffer);
        int totalLength = decode.getTotalLength();
        validateMessageCrc(byteBuffer, totalLength);
        byteBuffer.position(byteBuffer.position() + 12);
        long headersLength = decode.getHeadersLength();
        byte[] bArr = new byte[Utils.toIntExact(headersLength)];
        byteBuffer.get(bArr);
        Map<String, HeaderValue> decodeHeaders = decodeHeaders(ByteBuffer.wrap(bArr));
        byte[] bArr2 = new byte[Utils.toIntExact((totalLength - 16) - headersLength)];
        byteBuffer.get(bArr2);
        byteBuffer.getInt();
        return new Message(decodeHeaders, bArr2);
    }

    static Map<String, HeaderValue> decodeHeaders(ByteBuffer byteBuffer) {
        HashMap hashMap = new HashMap();
        while (byteBuffer.hasRemaining()) {
            Header decode = Header.decode(byteBuffer);
            hashMap.put(decode.getName(), decode.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private void encodeOrThrow(OutputStream outputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (Map.Entry<String, HeaderValue> entry : this.headers.entrySet()) {
            Header.encode(entry, dataOutputStream);
        }
        dataOutputStream.write(this.payload);
        dataOutputStream.flush();
        byte[] prelude = getPrelude(byteArrayOutputStream.size() + 12 + 4);
        CRC32 crc32 = new CRC32();
        crc32.update(prelude, 0, prelude.length);
        DataOutputStream dataOutputStream2 = new DataOutputStream(outputStream);
        dataOutputStream2.write(prelude);
        dataOutputStream2.writeInt((int) crc32.getValue());
        dataOutputStream2.flush();
        byteArrayOutputStream.writeTo(outputStream);
    }

    private byte[] getPrelude(int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int length = this.payload.length;
        dataOutputStream.writeInt(i);
        dataOutputStream.writeInt((i - 16) - length);
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private static void validateMessageCrc(ByteBuffer byteBuffer, int i) throws CosXmlServiceException {
        CRC32 crc32 = new CRC32();
        CheckSums.update(crc32, (ByteBuffer) byteBuffer.duplicate().limit((byteBuffer.position() + i) - 4));
        long value = crc32.getValue();
        long unsignedLong = Utils.toUnsignedLong(byteBuffer.getInt((byteBuffer.position() + i) - 4));
        if (unsignedLong != value) {
            throw new CosXmlServiceException("CRC failed", new ArithmeticException(String.format("Message checksum failure: expected 0x%x, computed 0x%x", Long.valueOf(unsignedLong), Long.valueOf(value))));
        }
    }

    public void encode(OutputStream outputStream) {
        try {
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, new CRC32());
            encodeOrThrow(checkedOutputStream);
            long value = checkedOutputStream.getChecksum().getValue();
            outputStream.write((int) ((value >> 24) & 255));
            outputStream.write((int) ((value >> 16) & 255));
            outputStream.write((int) ((value >> 8) & 255));
            outputStream.write((int) (value & 255));
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Message message = (Message) obj;
        if (this.headers.equals(message.headers)) {
            return Arrays.equals(this.payload, message.payload);
        }
        return false;
    }

    public Map<String, HeaderValue> getHeaders() {
        return this.headers;
    }

    public byte[] getPayload() {
        return (byte[]) this.payload.clone();
    }

    public int hashCode() {
        return (this.headers.hashCode() * 31) + Arrays.hashCode(this.payload);
    }

    public ByteBuffer toByteBuffer() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            encode(byteArrayOutputStream);
            byteArrayOutputStream.close();
            return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, HeaderValue> entry : this.headers.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue().toString());
            sb.append('\n');
        }
        sb.append('\n');
        HeaderValue headerValue = this.headers.get(Headers.CONTENT_TYPE);
        HeaderValue headerValue2 = headerValue;
        if (headerValue == null) {
            headerValue2 = HeaderValue.fromString("application/octet-stream");
        }
        String string = headerValue2.getString();
        if (string.contains("json") || string.contains("text")) {
            try {
                sb.append(new String(this.payload, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            sb.append(Base64.encodeAsString(this.payload));
        }
        sb.append('\n');
        return sb.toString();
    }
}
