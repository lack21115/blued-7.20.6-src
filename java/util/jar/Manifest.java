package java.util.jar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import libcore.io.Streams;

/* loaded from: source-2895416-dex2jar.jar:java/util/jar/Manifest.class */
public class Manifest implements Cloneable {
    static final int LINE_LENGTH_LIMIT = 72;
    private static final byte[] LINE_SEPARATOR = {13, 10};
    private static final byte[] VALUE_SEPARATOR = {58, 32};
    private HashMap<String, Chunk> chunks;
    private final HashMap<String, Attributes> entries;
    private final Attributes mainAttributes;
    private int mainEnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/jar/Manifest$Chunk.class */
    public static final class Chunk {
        final int end;
        final int start;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Chunk(int i, int i2) {
            this.start = i;
            this.end = i2;
        }
    }

    public Manifest() {
        this.entries = new HashMap<>();
        this.mainAttributes = new Attributes();
    }

    public Manifest(InputStream inputStream) throws IOException {
        this();
        read(Streams.readFully(inputStream));
    }

    public Manifest(Manifest manifest) {
        this.mainAttributes = (Attributes) manifest.mainAttributes.clone();
        this.entries = (HashMap) ((HashMap) manifest.getEntries()).clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Manifest(byte[] bArr, boolean z) throws IOException {
        this();
        if (z) {
            this.chunks = new HashMap<>();
        }
        read(bArr);
    }

    private void read(byte[] bArr) throws IOException {
        if (bArr.length == 0) {
            return;
        }
        ManifestReader manifestReader = new ManifestReader(bArr, this.mainAttributes);
        this.mainEnd = manifestReader.getEndOfMainSection();
        manifestReader.readEntries(this.entries, this.chunks);
    }

    static void write(Manifest manifest, OutputStream outputStream) throws IOException {
        CharsetEncoder newEncoder = StandardCharsets.UTF_8.newEncoder();
        ByteBuffer allocate = ByteBuffer.allocate(72);
        Attributes.Name name = Attributes.Name.MANIFEST_VERSION;
        String value = manifest.mainAttributes.getValue(name);
        String str = value;
        if (value == null) {
            name = Attributes.Name.SIGNATURE_VERSION;
            str = manifest.mainAttributes.getValue(name);
        }
        if (str != null) {
            writeEntry(outputStream, name, str, newEncoder, allocate);
            Iterator<Object> it = manifest.mainAttributes.keySet().iterator();
            while (it.hasNext()) {
                Attributes.Name name2 = (Attributes.Name) it.next();
                if (!name2.equals(name)) {
                    writeEntry(outputStream, name2, manifest.mainAttributes.getValue(name2), newEncoder, allocate);
                }
            }
        }
        outputStream.write(LINE_SEPARATOR);
        for (String str2 : manifest.getEntries().keySet()) {
            writeEntry(outputStream, Attributes.Name.NAME, str2, newEncoder, allocate);
            Attributes attributes = manifest.entries.get(str2);
            Iterator<Object> it2 = attributes.keySet().iterator();
            while (it2.hasNext()) {
                Attributes.Name name3 = (Attributes.Name) it2.next();
                writeEntry(outputStream, name3, attributes.getValue(name3), newEncoder, allocate);
            }
            outputStream.write(LINE_SEPARATOR);
        }
    }

    private static void writeEntry(OutputStream outputStream, Attributes.Name name, String str, CharsetEncoder charsetEncoder, ByteBuffer byteBuffer) throws IOException {
        String name2 = name.getName();
        outputStream.write(name2.getBytes(StandardCharsets.US_ASCII));
        outputStream.write(VALUE_SEPARATOR);
        charsetEncoder.reset();
        byteBuffer.clear().limit((72 - name2.length()) - 2);
        CharBuffer wrap = CharBuffer.wrap(str);
        while (true) {
            CoderResult encode = charsetEncoder.encode(wrap, byteBuffer, true);
            CoderResult coderResult = encode;
            if (CoderResult.UNDERFLOW == encode) {
                coderResult = charsetEncoder.flush(byteBuffer);
            }
            outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.position());
            outputStream.write(LINE_SEPARATOR);
            if (CoderResult.UNDERFLOW == coderResult) {
                return;
            }
            outputStream.write(32);
            byteBuffer.clear().limit(71);
        }
    }

    public void clear() {
        this.entries.clear();
        this.mainAttributes.clear();
    }

    public Object clone() {
        return new Manifest(this);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass() && this.mainAttributes.equals(((Manifest) obj).mainAttributes)) {
            return getEntries().equals(((Manifest) obj).getEntries());
        }
        return false;
    }

    public Attributes getAttributes(String str) {
        return getEntries().get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Chunk getChunk(String str) {
        return this.chunks.get(str);
    }

    public Map<String, Attributes> getEntries() {
        return this.entries;
    }

    public Attributes getMainAttributes() {
        return this.mainAttributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMainAttributesEnd() {
        return this.mainEnd;
    }

    public int hashCode() {
        return this.mainAttributes.hashCode() ^ getEntries().hashCode();
    }

    public void read(InputStream inputStream) throws IOException {
        read(Streams.readFullyNoClose(inputStream));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeChunks() {
        this.chunks = null;
    }

    public void write(OutputStream outputStream) throws IOException {
        write(this, outputStream);
    }
}
