package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/HashingSink.class */
public final class HashingSink extends ForwardingSink implements Sink {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/HashingSink$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HashingSink hmacSha1(Sink sink, ByteString key) {
            Intrinsics.e(sink, "sink");
            Intrinsics.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSink hmacSha256(Sink sink, ByteString key) {
            Intrinsics.e(sink, "sink");
            Intrinsics.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSink hmacSha512(Sink sink, ByteString key) {
            Intrinsics.e(sink, "sink");
            Intrinsics.e(key, "key");
            return new HashingSink(sink, key, "HmacSHA512");
        }

        @JvmStatic
        public final HashingSink md5(Sink sink) {
            Intrinsics.e(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        public final HashingSink sha1(Sink sink) {
            Intrinsics.e(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        public final HashingSink sha256(Sink sink) {
            Intrinsics.e(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        public final HashingSink sha512(Sink sink) {
            Intrinsics.e(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HashingSink(okio.Sink r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r1 = "sink"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r6
            java.lang.String r1 = "algorithm"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r6
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getInstance(algorithm)"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r4
            r1 = r5
            r2 = r6
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, MessageDigest digest) {
        super(sink);
        Intrinsics.e(sink, "sink");
        Intrinsics.e(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(Sink sink, Mac mac) {
        super(sink);
        Intrinsics.e(sink, "sink");
        Intrinsics.e(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HashingSink(okio.Sink r7, okio.ByteString r8, java.lang.String r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "sink"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r8
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r9
            java.lang.String r1 = "algorithm"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r9
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r0)     // Catch: java.security.InvalidKeyException -> L3f
            r10 = r0
            r0 = r10
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch: java.security.InvalidKeyException -> L3f
            r2 = r1
            r3 = r8
            byte[] r3 = r3.toByteArray()     // Catch: java.security.InvalidKeyException -> L3f
            r4 = r9
            r2.<init>(r3, r4)     // Catch: java.security.InvalidKeyException -> L3f
            java.security.Key r1 = (java.security.Key) r1     // Catch: java.security.InvalidKeyException -> L3f
            r0.init(r1)     // Catch: java.security.InvalidKeyException -> L3f
            kotlin.Unit r0 = kotlin.Unit.f42314a     // Catch: java.security.InvalidKeyException -> L3f
            r8 = r0
            r0 = r10
            java.lang.String r1 = "try {\n      Mac.getInsta…rgumentException(e)\n    }"
            kotlin.jvm.internal.Intrinsics.c(r0, r1)
            r0 = r6
            r1 = r7
            r2 = r10
            r0.<init>(r1, r2)
            return
        L3f:
            r7 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r7
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, okio.ByteString, java.lang.String):void");
    }

    @JvmStatic
    public static final HashingSink hmacSha1(Sink sink, ByteString byteString) {
        return Companion.hmacSha1(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha256(Sink sink, ByteString byteString) {
        return Companion.hmacSha256(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink hmacSha512(Sink sink, ByteString byteString) {
        return Companion.hmacSha512(sink, byteString);
    }

    @JvmStatic
    public static final HashingSink md5(Sink sink) {
        return Companion.md5(sink);
    }

    @JvmStatic
    public static final HashingSink sha1(Sink sink) {
        return Companion.sha1(sink);
    }

    @JvmStatic
    public static final HashingSink sha256(Sink sink) {
        return Companion.sha256(sink);
    }

    @JvmStatic
    public static final HashingSink sha512(Sink sink) {
        return Companion.sha512(sink);
    }

    @Deprecated
    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m13296deprecated_hash() {
        return hash();
    }

    public final ByteString hash() {
        byte[] doFinal;
        MessageDigest messageDigest = this.messageDigest;
        if (messageDigest != null) {
            doFinal = messageDigest.digest();
        } else {
            Mac mac = this.mac;
            Intrinsics.a(mac);
            doFinal = mac.doFinal();
        }
        byte[] result = doFinal;
        Intrinsics.c(result, "result");
        return new ByteString(doFinal);
    }

    @Override // okio.ForwardingSink, okio.Sink
    public void write(Buffer source, long j) throws IOException {
        Intrinsics.e(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0L, j);
        Segment segment = source.head;
        Intrinsics.a(segment);
        long j2 = 0;
        while (j2 < j) {
            int min = (int) Math.min(j - j2, segment.limit - segment.pos);
            MessageDigest messageDigest = this.messageDigest;
            if (messageDigest != null) {
                messageDigest.update(segment.data, segment.pos, min);
            } else {
                Mac mac = this.mac;
                Intrinsics.a(mac);
                mac.update(segment.data, segment.pos, min);
            }
            j2 += min;
            segment = segment.next;
            Intrinsics.a(segment);
        }
        super.write(source, j);
    }
}
