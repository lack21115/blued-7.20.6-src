package android.gesture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/InstanceLearner.class */
class InstanceLearner extends Learner {
    private static final Comparator<Prediction> sComparator = new Comparator<Prediction>() { // from class: android.gesture.InstanceLearner.1
        @Override // java.util.Comparator
        public int compare(Prediction prediction, Prediction prediction2) {
            double d = prediction.score;
            double d2 = prediction2.score;
            if (d > d2) {
                return -1;
            }
            return d < d2 ? 1 : 0;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.gesture.Learner
    public ArrayList<Prediction> classify(int i, int i2, float[] fArr) {
        ArrayList<Prediction> arrayList = new ArrayList<>();
        ArrayList<Instance> instances = getInstances();
        int size = instances.size();
        TreeMap treeMap = new TreeMap();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= size) {
                break;
            }
            Instance instance = instances.get(i4);
            if (instance.vector.length == fArr.length) {
                double minimumCosineDistance = i == 2 ? GestureUtils.minimumCosineDistance(instance.vector, fArr, i2) : GestureUtils.squaredEuclideanDistance(instance.vector, fArr);
                double d = minimumCosineDistance == 0.0d ? Double.MAX_VALUE : 1.0d / minimumCosineDistance;
                Double d2 = (Double) treeMap.get(instance.label);
                if (d2 == null || d > d2.doubleValue()) {
                    treeMap.put(instance.label, Double.valueOf(d));
                }
            }
            i3 = i4 + 1;
        }
        for (String str : treeMap.keySet()) {
            arrayList.add(new Prediction(str, ((Double) treeMap.get(str)).doubleValue()));
        }
        Collections.sort(arrayList, sComparator);
        return arrayList;
    }
}
