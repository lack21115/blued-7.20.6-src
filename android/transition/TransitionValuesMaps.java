package android.transition;

import android.util.ArrayMap;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/transition/TransitionValuesMaps.class */
public class TransitionValuesMaps {
    ArrayMap<View, TransitionValues> viewValues = new ArrayMap<>();
    SparseArray<View> idValues = new SparseArray<>();
    LongSparseArray<View> itemIdValues = new LongSparseArray<>();
    ArrayMap<String, View> nameValues = new ArrayMap<>();
}
