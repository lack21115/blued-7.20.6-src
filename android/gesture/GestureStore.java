package android.gesture;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-9557208-dex2jar.jar:android/gesture/GestureStore.class */
public class GestureStore {
    private static final short FILE_FORMAT_VERSION = 1;
    public static final int ORIENTATION_INVARIANT = 1;
    public static final int ORIENTATION_SENSITIVE = 2;
    static final int ORIENTATION_SENSITIVE_4 = 4;
    static final int ORIENTATION_SENSITIVE_8 = 8;
    private static final boolean PROFILE_LOADING_SAVING = false;
    public static final int SEQUENCE_INVARIANT = 1;
    public static final int SEQUENCE_SENSITIVE = 2;
    private int mSequenceType = 2;
    private int mOrientationStyle = 2;
    private final HashMap<String, ArrayList<Gesture>> mNamedGestures = new HashMap<>();
    private boolean mChanged = false;
    private Learner mClassifier = new InstanceLearner();

    private void readFormatV1(DataInputStream dataInputStream) throws IOException {
        Learner learner = this.mClassifier;
        HashMap<String, ArrayList<Gesture>> hashMap = this.mNamedGestures;
        hashMap.clear();
        int readInt = dataInputStream.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            ArrayList<Gesture> arrayList = new ArrayList<>(readInt2);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < readInt2) {
                    Gesture deserialize = Gesture.deserialize(dataInputStream);
                    arrayList.add(deserialize);
                    learner.addInstance(Instance.createInstance(this.mSequenceType, this.mOrientationStyle, deserialize, readUTF));
                    i3 = i4 + 1;
                }
            }
            hashMap.put(readUTF, arrayList);
            i = i2 + 1;
        }
    }

    public void addGesture(String str, Gesture gesture) {
        if (str == null || str.length() == 0) {
            return;
        }
        ArrayList<Gesture> arrayList = this.mNamedGestures.get(str);
        ArrayList<Gesture> arrayList2 = arrayList;
        if (arrayList == null) {
            arrayList2 = new ArrayList<>();
            this.mNamedGestures.put(str, arrayList2);
        }
        arrayList2.add(gesture);
        this.mClassifier.addInstance(Instance.createInstance(this.mSequenceType, this.mOrientationStyle, gesture, str));
        this.mChanged = true;
    }

    public Set<String> getGestureEntries() {
        return this.mNamedGestures.keySet();
    }

    public ArrayList<Gesture> getGestures(String str) {
        ArrayList<Gesture> arrayList = this.mNamedGestures.get(str);
        if (arrayList != null) {
            return new ArrayList<>(arrayList);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Learner getLearner() {
        return this.mClassifier;
    }

    public int getOrientationStyle() {
        return this.mOrientationStyle;
    }

    public int getSequenceType() {
        return this.mSequenceType;
    }

    public boolean hasChanged() {
        return this.mChanged;
    }

    public void load(InputStream inputStream) throws IOException {
        load(inputStream, false);
    }

    public void load(InputStream inputStream, boolean z) throws IOException {
        DataInputStream dataInputStream;
        Throwable th;
        try {
            if (!(inputStream instanceof BufferedInputStream)) {
                inputStream = new BufferedInputStream(inputStream, 32768);
            }
            dataInputStream = new DataInputStream(inputStream);
            try {
                switch (dataInputStream.readShort()) {
                    case 1:
                        readFormatV1(dataInputStream);
                        break;
                }
                if (z) {
                    GestureUtils.closeStream(dataInputStream);
                }
            } catch (Throwable th2) {
                th = th2;
                if (z) {
                    GestureUtils.closeStream(dataInputStream);
                }
                throw th;
            }
        } catch (Throwable th3) {
            dataInputStream = null;
            th = th3;
        }
    }

    public ArrayList<Prediction> recognize(Gesture gesture) {
        return this.mClassifier.classify(this.mSequenceType, this.mOrientationStyle, Instance.createInstance(this.mSequenceType, this.mOrientationStyle, gesture, null).vector);
    }

    public void removeEntry(String str) {
        this.mNamedGestures.remove(str);
        this.mClassifier.removeInstances(str);
        this.mChanged = true;
    }

    public void removeGesture(String str, Gesture gesture) {
        ArrayList<Gesture> arrayList = this.mNamedGestures.get(str);
        if (arrayList == null) {
            return;
        }
        arrayList.remove(gesture);
        if (arrayList.isEmpty()) {
            this.mNamedGestures.remove(str);
        }
        this.mClassifier.removeInstance(gesture.getID());
        this.mChanged = true;
    }

    public void save(OutputStream outputStream) throws IOException {
        save(outputStream, false);
    }

    public void save(OutputStream outputStream, boolean z) throws IOException {
        DataOutputStream dataOutputStream;
        HashMap<String, ArrayList<Gesture>> hashMap;
        try {
            hashMap = this.mNamedGestures;
            if (!(outputStream instanceof BufferedOutputStream)) {
                outputStream = new BufferedOutputStream(outputStream, 32768);
            }
            dataOutputStream = new DataOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
            dataOutputStream = null;
        }
        try {
            dataOutputStream.writeShort(1);
            dataOutputStream.writeInt(hashMap.size());
            for (Map.Entry<String, ArrayList<Gesture>> entry : hashMap.entrySet()) {
                String key = entry.getKey();
                ArrayList<Gesture> value = entry.getValue();
                int size = value.size();
                dataOutputStream.writeUTF(key);
                dataOutputStream.writeInt(size);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < size) {
                        value.get(i2).serialize(dataOutputStream);
                        i = i2 + 1;
                    }
                }
            }
            dataOutputStream.flush();
            this.mChanged = false;
            if (z) {
                GestureUtils.closeStream(dataOutputStream);
            }
        } catch (Throwable th2) {
            th = th2;
            if (z) {
                GestureUtils.closeStream(dataOutputStream);
            }
            throw th;
        }
    }

    public void setOrientationStyle(int i) {
        this.mOrientationStyle = i;
    }

    public void setSequenceType(int i) {
        this.mSequenceType = i;
    }
}
