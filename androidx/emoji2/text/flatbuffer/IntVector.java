package androidx.emoji2.text.flatbuffer;

import android.widget.ExpandableListView;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/text/flatbuffer/IntVector.class */
public final class IntVector extends BaseVector {
    public IntVector __assign(int i, ByteBuffer byteBuffer) {
        a(i, 4, byteBuffer);
        return this;
    }

    public int get(int i) {
        return this.f2849a.getInt(a(i));
    }

    public long getAsUnsigned(int i) {
        return get(i) & ExpandableListView.PACKED_POSITION_VALUE_NULL;
    }
}
