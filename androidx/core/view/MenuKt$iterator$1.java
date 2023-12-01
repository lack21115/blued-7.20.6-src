package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/MenuKt$iterator$1.class */
public final class MenuKt$iterator$1 implements Iterator<MenuItem>, KMutableIterator {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Menu f2648a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MenuKt$iterator$1(Menu menu) {
        this.f2648a = menu;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.f2648a.size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public MenuItem next() {
        Menu menu = this.f2648a;
        int i = this.b;
        this.b = i + 1;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            return item;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.util.Iterator
    public void remove() {
        Menu menu = this.f2648a;
        int i = this.b - 1;
        this.b = i;
        menu.removeItem(i);
    }
}
