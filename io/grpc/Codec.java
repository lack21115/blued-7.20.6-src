package io.grpc;

import android.net.wifi.WifiEnterpriseConfig;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: source-8829756-dex2jar.jar:io/grpc/Codec.class */
public interface Codec extends Compressor, Decompressor {

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Codec$Gzip.class */
    public static final class Gzip implements Codec {
        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream outputStream) throws IOException {
            return new GZIPOutputStream(outputStream);
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream inputStream) throws IOException {
            return new GZIPInputStream(inputStream);
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return "gzip";
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:io/grpc/Codec$Identity.class */
    public static final class Identity implements Codec {
        public static final Codec NONE = new Identity();

        private Identity() {
        }

        @Override // io.grpc.Compressor
        public OutputStream compress(OutputStream outputStream) {
            return outputStream;
        }

        @Override // io.grpc.Decompressor
        public InputStream decompress(InputStream inputStream) {
            return inputStream;
        }

        @Override // io.grpc.Compressor, io.grpc.Decompressor
        public String getMessageEncoding() {
            return WifiEnterpriseConfig.IDENTITY_KEY;
        }
    }
}
