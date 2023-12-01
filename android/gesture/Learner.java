package android.gesture;

import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/Learner.class */
abstract class Learner {
    private final ArrayList<Instance> mInstances = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addInstance(Instance instance) {
        this.mInstances.add(instance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ArrayList<Prediction> classify(int i, int i2, float[] fArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Instance> getInstances() {
        return this.mInstances;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeInstance(long j) {
        ArrayList<Instance> arrayList = this.mInstances;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Instance instance = arrayList.get(i2);
            if (j == instance.id) {
                arrayList.remove(instance);
                return;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeInstances(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Instance> arrayList2 = this.mInstances;
        int size = arrayList2.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                arrayList2.removeAll(arrayList);
                return;
            }
            Instance instance = arrayList2.get(i2);
            if ((instance.label == null && str == null) || (instance.label != null && instance.label.equals(str))) {
                arrayList.add(instance);
            }
            i = i2 + 1;
        }
    }
}
