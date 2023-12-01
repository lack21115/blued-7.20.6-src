package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyCache.class */
public class KeyCache {

    /* renamed from: a  reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f2034a = new HashMap<>();

    public float getFloatValue(Object obj, String str, int i) {
        HashMap<String, float[]> hashMap;
        float[] fArr;
        if (this.f2034a.containsKey(obj) && (hashMap = this.f2034a.get(obj)) != null && hashMap.containsKey(str) && (fArr = hashMap.get(str)) != null && fArr.length > i) {
            return fArr[i];
        }
        return Float.NaN;
    }

    public void setFloatValue(Object obj, String str, int i, float f) {
        if (!this.f2034a.containsKey(obj)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            float[] fArr = new float[i + 1];
            fArr[i] = f;
            hashMap.put(str, fArr);
            this.f2034a.put(obj, hashMap);
            return;
        }
        HashMap<String, float[]> hashMap2 = this.f2034a.get(obj);
        HashMap<String, float[]> hashMap3 = hashMap2;
        if (hashMap2 == null) {
            hashMap3 = new HashMap<>();
        }
        if (!hashMap3.containsKey(str)) {
            float[] fArr2 = new float[i + 1];
            fArr2[i] = f;
            hashMap3.put(str, fArr2);
            this.f2034a.put(obj, hashMap3);
            return;
        }
        float[] fArr3 = hashMap3.get(str);
        float[] fArr4 = fArr3;
        if (fArr3 == null) {
            fArr4 = new float[0];
        }
        float[] fArr5 = fArr4;
        if (fArr4.length <= i) {
            fArr5 = Arrays.copyOf(fArr4, i + 1);
        }
        fArr5[i] = f;
        hashMap3.put(str, fArr5);
    }
}
