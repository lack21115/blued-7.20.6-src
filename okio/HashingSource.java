package okio;

import com.anythink.core.common.k.f;
import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/HashingSource.class */
public final class HashingSource extends ForwardingSource implements Source {
    public static final Companion Companion = new Companion(null);
    private final Mac mac;
    private final MessageDigest messageDigest;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:okio/HashingSource$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HashingSource hmacSha1(Source source, ByteString key) {
            Intrinsics.e(source, "source");
            Intrinsics.e(key, "key");
            return new HashingSource(source, key, "HmacSHA1");
        }

        @JvmStatic
        public final HashingSource hmacSha256(Source source, ByteString key) {
            Intrinsics.e(source, "source");
            Intrinsics.e(key, "key");
            return new HashingSource(source, key, "HmacSHA256");
        }

        @JvmStatic
        public final HashingSource hmacSha512(Source source, ByteString key) {
            Intrinsics.e(source, "source");
            Intrinsics.e(key, "key");
            return new HashingSource(source, key, "HmacSHA512");
        }

        @JvmStatic
        public final HashingSource md5(Source source) {
            Intrinsics.e(source, "source");
            return new HashingSource(source, f.a);
        }

        @JvmStatic
        public final HashingSource sha1(Source source) {
            Intrinsics.e(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @JvmStatic
        public final HashingSource sha256(Source source) {
            Intrinsics.e(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @JvmStatic
        public final HashingSource sha512(Source source) {
            Intrinsics.e(source, "source");
            return new HashingSource(source, "SHA-512");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HashingSource(okio.Source r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r1 = "source"
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
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, java.lang.String):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, MessageDigest digest) {
        super(source);
        Intrinsics.e(source, "source");
        Intrinsics.e(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSource(Source source, Mac mac) {
        super(source);
        Intrinsics.e(source, "source");
        Intrinsics.e(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HashingSource(okio.Source r7, okio.ByteString r8, java.lang.String r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "source"
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
            kotlin.Unit r0 = kotlin.Unit.a     // Catch: java.security.InvalidKeyException -> L3f
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
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, okio.ByteString, java.lang.String):void");
    }

    @JvmStatic
    public static final HashingSource hmacSha1(Source source, ByteString byteString) {
        return Companion.hmacSha1(source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha256(Source source, ByteString byteString) {
        return Companion.hmacSha256(source, byteString);
    }

    @JvmStatic
    public static final HashingSource hmacSha512(Source source, ByteString byteString) {
        return Companion.hmacSha512(source, byteString);
    }

    @JvmStatic
    public static final HashingSource md5(Source source) {
        return Companion.md5(source);
    }

    @JvmStatic
    public static final HashingSource sha1(Source source) {
        return Companion.sha1(source);
    }

    @JvmStatic
    public static final HashingSource sha256(Source source) {
        return Companion.sha256(source);
    }

    @JvmStatic
    public static final HashingSource sha512(Source source) {
        return Companion.sha512(source);
    }

    @Deprecated
    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m12207deprecated_hash() {
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

    @Override // okio.ForwardingSource, okio.Source
    public long read(Buffer sink, long j) throws IOException {
        long j2;
        long j3;
        Segment segment;
        Intrinsics.e(sink, "sink");
        long read = super.read(sink, j);
        if (read != -1) {
            long size = sink.size() - read;
            long size2 = sink.size();
            Segment segment2 = sink.head;
            Intrinsics.a(segment2);
            while (true) {
                j2 = size;
                j3 = size2;
                segment = segment2;
                if (size2 <= size) {
                    break;
                }
                segment2 = segment2.prev;
                Intrinsics.a(segment2);
                size2 -= segment2.limit - segment2.pos;
            }
            while (j3 < sink.size()) {
                int i = (int) ((segment.pos + j2) - j3);
                MessageDigest messageDigest = this.messageDigest;
                if (messageDigest != null) {
                    messageDigest.update(segment.data, i, segment.limit - i);
                } else {
                    Mac mac = this.mac;
                    Intrinsics.a(mac);
                    mac.update(segment.data, i, segment.limit - i);
                }
                j3 += segment.limit - segment.pos;
                segment = segment.next;
                Intrinsics.a(segment);
                j2 = j3;
            }
        }
        return read;
    }
}
