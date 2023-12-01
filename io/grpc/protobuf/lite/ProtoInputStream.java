package io.grpc.protobuf.lite;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/protobuf/lite/ProtoInputStream.class */
final class ProtoInputStream extends InputStream implements Drainable, KnownLength {
    @Nullable
    private MessageLite message;
    private final Parser<?> parser;
    @Nullable
    private ByteArrayInputStream partial;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoInputStream(MessageLite messageLite, Parser<?> parser) {
        this.message = messageLite;
        this.parser = parser;
    }

    @Override // java.io.InputStream
    public int available() {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // io.grpc.Drainable
    public int drainTo(OutputStream outputStream) throws IOException {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            this.message.writeTo(outputStream);
            this.message = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            int copy = (int) ProtoLiteUtils.copy(byteArrayInputStream, outputStream);
            this.partial = null;
            return copy;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageLite message() {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parser<?> parser() {
        return this.parser;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.message != null) {
            this.partial = new ByteArrayInputStream(this.message.toByteArray());
            this.message = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.message = null;
                this.partial = null;
                return -1;
            } else if (i2 >= serializedSize) {
                CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr, i, serializedSize);
                this.message.writeTo(newInstance);
                newInstance.flush();
                newInstance.checkNoSpaceLeft();
                this.message = null;
                this.partial = null;
                return serializedSize;
            } else {
                this.partial = new ByteArrayInputStream(this.message.toByteArray());
                this.message = null;
            }
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }
}
