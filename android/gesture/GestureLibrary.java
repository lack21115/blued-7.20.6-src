package android.gesture;

import java.util.ArrayList;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureLibrary.class */
public abstract class GestureLibrary {
    protected final GestureStore mStore = new GestureStore();

    public void addGesture(String str, Gesture gesture) {
        this.mStore.addGesture(str, gesture);
    }

    public Set<String> getGestureEntries() {
        return this.mStore.getGestureEntries();
    }

    public ArrayList<Gesture> getGestures(String str) {
        return this.mStore.getGestures(str);
    }

    public Learner getLearner() {
        return this.mStore.getLearner();
    }

    public int getOrientationStyle() {
        return this.mStore.getOrientationStyle();
    }

    public int getSequenceType() {
        return this.mStore.getSequenceType();
    }

    public boolean isReadOnly() {
        return false;
    }

    public abstract boolean load();

    public ArrayList<Prediction> recognize(Gesture gesture) {
        return this.mStore.recognize(gesture);
    }

    public void removeEntry(String str) {
        this.mStore.removeEntry(str);
    }

    public void removeGesture(String str, Gesture gesture) {
        this.mStore.removeGesture(str, gesture);
    }

    public abstract boolean save();

    public void setOrientationStyle(int i) {
        this.mStore.setOrientationStyle(i);
    }

    public void setSequenceType(int i) {
        this.mStore.setSequenceType(i);
    }
}
