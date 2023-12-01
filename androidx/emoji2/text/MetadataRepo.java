package androidx.emoji2.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataRepo.class */
public final class MetadataRepo {

    /* renamed from: a  reason: collision with root package name */
    private final MetadataList f2842a;
    private final char[] b;

    /* renamed from: c  reason: collision with root package name */
    private final Node f2843c = new Node(1024);
    private final Typeface d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/MetadataRepo$Node.class */
    public static class Node {

        /* renamed from: a  reason: collision with root package name */
        private final SparseArray<Node> f2844a;
        private EmojiMetadata b;

        private Node() {
            this(1);
        }

        Node(int i) {
            this.f2844a = new SparseArray<>(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final EmojiMetadata a() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Node a(int i) {
            SparseArray<Node> sparseArray = this.f2844a;
            if (sparseArray == null) {
                return null;
            }
            return sparseArray.get(i);
        }

        void a(EmojiMetadata emojiMetadata, int i, int i2) {
            Node a2 = a(emojiMetadata.getCodepointAt(i));
            Node node = a2;
            if (a2 == null) {
                node = new Node();
                this.f2844a.put(emojiMetadata.getCodepointAt(i), node);
            }
            if (i2 > i) {
                node.a(emojiMetadata, i + 1, i2);
            } else {
                node.b = emojiMetadata;
            }
        }
    }

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        this.d = typeface;
        this.f2842a = metadataList;
        this.b = new char[this.f2842a.listLength() * 2];
        a(this.f2842a);
    }

    private void a(MetadataList metadataList) {
        int listLength = metadataList.listLength();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= listLength) {
                return;
            }
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i2);
            Character.toChars(emojiMetadata.getId(), this.b, i2 * 2);
            a(emojiMetadata);
            i = i2 + 1;
        }
    }

    public static MetadataRepo create(AssetManager assetManager, String str) throws IOException {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(Typeface.createFromAsset(assetManager, str), MetadataListReader.a(assetManager, str));
            TraceCompat.endSection();
            return metadataRepo;
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    public static MetadataRepo create(Typeface typeface) {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(typeface, new MetadataList());
            TraceCompat.endSection();
            return metadataRepo;
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    public static MetadataRepo create(Typeface typeface, InputStream inputStream) throws IOException {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(typeface, MetadataListReader.a(inputStream));
            TraceCompat.endSection();
            return metadataRepo;
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    public static MetadataRepo create(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.beginSection("EmojiCompat.MetadataRepo.create");
            MetadataRepo metadataRepo = new MetadataRepo(typeface, MetadataListReader.a(byteBuffer));
            TraceCompat.endSection();
            return metadataRepo;
        } catch (Throwable th) {
            TraceCompat.endSection();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface a() {
        return this.d;
    }

    void a(EmojiMetadata emojiMetadata) {
        Preconditions.checkNotNull(emojiMetadata, "emoji metadata cannot be null");
        Preconditions.checkArgument(emojiMetadata.getCodepointsLength() > 0, "invalid metadata codepoint length");
        this.f2843c.a(emojiMetadata, 0, emojiMetadata.getCodepointsLength() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f2842a.version();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Node c() {
        return this.f2843c;
    }

    public char[] getEmojiCharArray() {
        return this.b;
    }

    public MetadataList getMetadataList() {
        return this.f2842a;
    }
}
