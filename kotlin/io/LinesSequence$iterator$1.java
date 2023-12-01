package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/io/LinesSequence$iterator$1.class */
public final class LinesSequence$iterator$1 implements Iterator<String>, KMappedMarker {
    final /* synthetic */ LinesSequence a;
    private String b;
    private boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinesSequence$iterator$1(LinesSequence linesSequence) {
        this.a = linesSequence;
    }

    @Override // java.util.Iterator
    /* renamed from: a */
    public String next() {
        if (hasNext()) {
            String str = this.b;
            this.b = null;
            Intrinsics.a((Object) str);
            return str;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        BufferedReader bufferedReader;
        if (this.b == null && !this.c) {
            bufferedReader = this.a.a;
            String readLine = bufferedReader.readLine();
            this.b = readLine;
            if (readLine == null) {
                this.c = true;
            }
        }
        return this.b != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
