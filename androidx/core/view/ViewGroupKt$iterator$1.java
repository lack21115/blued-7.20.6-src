package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/ViewGroupKt$iterator$1.class */
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ViewGroup f2619a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f2619a = viewGroup;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f2619a.getChildCount();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public View next() {
        ViewGroup viewGroup = this.f2619a;
        int i = this.b;
        this.b = i + 1;
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        ViewGroup viewGroup = this.f2619a;
        int i = this.b - 1;
        this.b = i;
        viewGroup.removeViewAt(i);
    }
}
