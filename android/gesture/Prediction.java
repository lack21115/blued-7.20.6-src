package android.gesture;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/Prediction.class */
public class Prediction {
    public final String name;
    public double score;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Prediction(String str, double d) {
        this.name = str;
        this.score = d;
    }

    public String toString() {
        return this.name;
    }
}
