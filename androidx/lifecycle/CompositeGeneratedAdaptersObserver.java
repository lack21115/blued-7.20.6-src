package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: source-8756600-dex2jar.jar:androidx/lifecycle/CompositeGeneratedAdaptersObserver.class */
class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] mGeneratedAdapters;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.mGeneratedAdapters = generatedAdapterArr;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        GeneratedAdapter[] generatedAdapterArr = this.mGeneratedAdapters;
        int length = generatedAdapterArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            generatedAdapterArr[i2].callMethods(lifecycleOwner, event, false, methodCallsLogger);
            i = i2 + 1;
        }
        GeneratedAdapter[] generatedAdapterArr2 = this.mGeneratedAdapters;
        int length2 = generatedAdapterArr2.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            generatedAdapterArr2[i4].callMethods(lifecycleOwner, event, true, methodCallsLogger);
            i3 = i4 + 1;
        }
    }
}
