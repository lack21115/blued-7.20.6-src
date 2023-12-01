package libcore.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/DeleteOnExit.class */
public class DeleteOnExit extends Thread {
    private static DeleteOnExit instance;
    private final ArrayList<String> files = new ArrayList<>();

    private DeleteOnExit() {
    }

    public static DeleteOnExit getInstance() {
        DeleteOnExit deleteOnExit;
        synchronized (DeleteOnExit.class) {
            try {
                if (instance == null) {
                    instance = new DeleteOnExit();
                    Runtime.getRuntime().addShutdownHook(instance);
                }
                deleteOnExit = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return deleteOnExit;
    }

    public void addFile(String str) {
        synchronized (this.files) {
            if (!this.files.contains(str)) {
                this.files.add(str);
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Collections.sort(this.files);
        int size = this.files.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return;
            }
            new File(this.files.get(i)).delete();
            size = i;
        }
    }
}
