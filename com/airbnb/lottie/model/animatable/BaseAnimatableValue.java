package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.value.Keyframe;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/animatable/BaseAnimatableValue.class */
abstract class BaseAnimatableValue<V, O> implements AnimatableValue<V, O> {
    final List<Keyframe<V>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(V v) {
        this(Collections.singletonList(new Keyframe(v)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAnimatableValue(List<Keyframe<V>> list) {
        this.a = list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0031, code lost:
        if (r3.a.get(0).e() != false) goto L10;
     */
    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b() {
        /*
            r3 = this;
            r0 = r3
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r0.a
            boolean r0 = r0.isEmpty()
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r4
            if (r0 != 0) goto L34
            r0 = r5
            r4 = r0
            r0 = r3
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r0.a
            int r0 = r0.size()
            r1 = 1
            if (r0 != r1) goto L36
            r0 = r5
            r4 = r0
            r0 = r3
            java.util.List<com.airbnb.lottie.value.Keyframe<V>> r0 = r0.a
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.airbnb.lottie.value.Keyframe r0 = (com.airbnb.lottie.value.Keyframe) r0
            boolean r0 = r0.e()
            if (r0 == 0) goto L36
        L34:
            r0 = 1
            r4 = r0
        L36:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.animatable.BaseAnimatableValue.b():boolean");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public List<Keyframe<V>> c() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }
}
