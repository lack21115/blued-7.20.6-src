package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8Old;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8Old.class */
public class Utf8Old extends Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<Cache> f2827a = ThreadLocal.withInitial(new Supplier() { // from class: androidx.emoji2.text.flatbuffer.-$$Lambda$Utf8Old$VCpeJ9GC5Wd3BIBG07DGosj7pWk
        @Override // java.util.function.Supplier
        public final Object get() {
            Utf8Old.Cache a2;
            a2 = Utf8Old.a();
            return a2;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/Utf8Old$Cache.class */
    public static class Cache {

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2829c = null;
        ByteBuffer d = null;

        /* renamed from: a  reason: collision with root package name */
        final CharsetEncoder f2828a = StandardCharsets.UTF_8.newEncoder();
        final CharsetDecoder b = StandardCharsets.UTF_8.newDecoder();

        Cache() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Cache a() {
        return new Cache();
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) {
        CharsetDecoder charsetDecoder = f2827a.get().b;
        charsetDecoder.reset();
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(i);
        duplicate.limit(i + i2);
        try {
            return charsetDecoder.decode(duplicate).toString();
        } catch (CharacterCodingException e) {
            throw new IllegalArgumentException("Bad encoding", e);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        Cache cache = f2827a.get();
        if (cache.f2829c != charSequence) {
            encodedLength(charSequence);
        }
        byteBuffer.put(cache.d);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        Cache cache = f2827a.get();
        int length = (int) (charSequence.length() * cache.f2828a.maxBytesPerChar());
        if (cache.d == null || cache.d.capacity() < length) {
            cache.d = ByteBuffer.allocate(Math.max(128, length));
        }
        cache.d.clear();
        cache.f2829c = charSequence;
        CoderResult encode = cache.f2828a.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), cache.d, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new IllegalArgumentException("bad character encoding", e);
            }
        }
        cache.d.flip();
        return cache.d.remaining();
    }
}
