package java.util.jar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/util/jar/ManifestReader.class */
public class ManifestReader {
    private final byte[] buf;
    private final int endOfMainSection;
    private Attributes.Name name;
    private int pos;
    private String value;
    private final HashMap<String, Attributes.Name> attributeNameCache = new HashMap<>();
    private final ByteArrayOutputStream valueBuffer = new ByteArrayOutputStream(80);
    private int consecutiveLineBreaks = 0;

    public ManifestReader(byte[] bArr, Attributes attributes) throws IOException {
        this.buf = bArr;
        while (readHeader()) {
            attributes.put(this.name, this.value);
        }
        this.endOfMainSection = this.pos;
    }

    private boolean readHeader() throws IOException {
        boolean z = true;
        if (this.consecutiveLineBreaks > 1) {
            this.consecutiveLineBreaks = 0;
            return false;
        }
        readName();
        this.consecutiveLineBreaks = 0;
        readValue();
        if (this.consecutiveLineBreaks <= 0) {
            z = false;
        }
        return z;
    }

    private void readName() throws IOException {
        int i = this.pos;
        while (this.pos < this.buf.length) {
            byte[] bArr = this.buf;
            int i2 = this.pos;
            this.pos = i2 + 1;
            if (bArr[i2] == 58) {
                String str = new String(this.buf, i, (this.pos - i) - 1, StandardCharsets.US_ASCII);
                byte[] bArr2 = this.buf;
                int i3 = this.pos;
                this.pos = i3 + 1;
                if (bArr2[i3] != 32) {
                    throw new IOException(String.format("Invalid value for attribute '%s'", str));
                }
                try {
                    this.name = this.attributeNameCache.get(str);
                    if (this.name == null) {
                        this.name = new Attributes.Name(str);
                        this.attributeNameCache.put(str, this.name);
                        return;
                    }
                    return;
                } catch (IllegalArgumentException e) {
                    throw new IOException(e.getMessage());
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0076, code lost:
        r6.valueBuffer.write(r6.buf, r8, r9 - r8);
        r6.value = r6.valueBuffer.toString(java.nio.charset.StandardCharsets.UTF_8.name());
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0096, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readValue() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.jar.ManifestReader.readValue():void");
    }

    public int getEndOfMainSection() {
        return this.endOfMainSection;
    }

    public void readEntries(Map<String, Attributes> map, Map<String, Manifest.Chunk> map2) throws IOException {
        int i = this.pos;
        while (true) {
            int i2 = i;
            if (!readHeader()) {
                return;
            }
            if (!Attributes.Name.NAME.equals(this.name)) {
                throw new IOException("Entry is not named");
            }
            String str = this.value;
            Attributes attributes = map.get(str);
            Attributes attributes2 = attributes;
            if (attributes == null) {
                attributes2 = new Attributes(12);
            }
            while (readHeader()) {
                attributes2.put(this.name, this.value);
            }
            int i3 = i2;
            if (map2 != null) {
                if (map2.get(str) != null) {
                    throw new IOException("A jar verifier does not support more than one entry with the same name");
                }
                map2.put(str, new Manifest.Chunk(i2, this.pos));
                i3 = this.pos;
            }
            map.put(str, attributes2);
            i = i3;
        }
    }
}
