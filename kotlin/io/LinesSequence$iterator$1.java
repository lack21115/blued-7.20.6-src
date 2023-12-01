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

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LinesSequence f42506a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f42507c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinesSequence$iterator$1(LinesSequence linesSequence) {
        this.f42506a = linesSequence;
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
        if (this.b == null && !this.f42507c) {
            bufferedReader = this.f42506a.f42505a;
            String readLine = bufferedReader.readLine();
            this.b = readLine;
            if (readLine == null) {
                this.f42507c = true;
            }
        }
        return this.b != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
