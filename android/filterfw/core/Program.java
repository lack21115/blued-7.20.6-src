package android.filterfw.core;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/core/Program.class */
public abstract class Program {
    public abstract Object getHostValue(String str);

    public void process(Frame frame, Frame frame2) {
        process(new Frame[]{frame}, frame2);
    }

    public abstract void process(Frame[] frameArr, Frame frame);

    public void reset() {
    }

    public abstract void setHostValue(String str, Object obj);
}
