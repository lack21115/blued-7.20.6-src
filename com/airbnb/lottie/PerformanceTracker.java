package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/PerformanceTracker.class */
public class PerformanceTracker {
    private boolean a = false;
    private final Set<FrameListener> b = new ArraySet();
    private final Map<String, MeanCalculator> c = new HashMap();
    private final Comparator<Pair<String, Float>> d = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.PerformanceTracker.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/PerformanceTracker$FrameListener.class */
    public interface FrameListener {
        void a(float f);
    }

    public void a(String str, float f) {
        if (this.a) {
            MeanCalculator meanCalculator = this.c.get(str);
            MeanCalculator meanCalculator2 = meanCalculator;
            if (meanCalculator == null) {
                meanCalculator2 = new MeanCalculator();
                this.c.put(str, meanCalculator2);
            }
            meanCalculator2.a(f);
            if (str.equals("__container")) {
                for (FrameListener frameListener : this.b) {
                    frameListener.a(f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.a = z;
    }
}
