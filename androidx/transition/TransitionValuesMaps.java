package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/transition/TransitionValuesMaps.class */
public class TransitionValuesMaps {

    /* renamed from: a  reason: collision with root package name */
    final ArrayMap<View, TransitionValues> f3440a = new ArrayMap<>();
    final SparseArray<View> b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    final LongSparseArray<View> f3441c = new LongSparseArray<>();
    final ArrayMap<String, View> d = new ArrayMap<>();
}
