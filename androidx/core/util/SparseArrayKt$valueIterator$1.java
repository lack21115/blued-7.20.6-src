package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/SparseArrayKt$valueIterator$1.class */
public final class SparseArrayKt$valueIterator$1<T> implements Iterator<T>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SparseArray<T> f2607a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArrayKt$valueIterator$1(SparseArray<T> sparseArray) {
        this.f2607a = sparseArray;
    }

    public final int getIndex() {
        return this.b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f2607a.size();
    }

    @Override // java.util.Iterator
    public T next() {
        SparseArray<T> sparseArray = this.f2607a;
        int i = this.b;
        this.b = i + 1;
        return sparseArray.valueAt(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setIndex(int i) {
        this.b = i;
    }
}
