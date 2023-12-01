package java.lang;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ProcessBuilder.class */
public final class ProcessBuilder {
    private List<String> command;
    private File directory;
    private Map<String, String> environment;
    private boolean redirectErrorStream;

    public ProcessBuilder(List<String> list) {
        if (list == null) {
            throw new NullPointerException("command == null");
        }
        this.command = list;
        this.environment = new Hashtable(System.getenv());
    }

    public ProcessBuilder(String... strArr) {
        this(new ArrayList(Arrays.asList(strArr)));
    }

    public ProcessBuilder command(List<String> list) {
        if (list == null) {
            throw new NullPointerException("command == null");
        }
        this.command = list;
        return this;
    }

    public ProcessBuilder command(String... strArr) {
        return command(new ArrayList(Arrays.asList(strArr)));
    }

    public List<String> command() {
        return this.command;
    }

    public File directory() {
        return this.directory;
    }

    public ProcessBuilder directory(File file) {
        this.directory = file;
        return this;
    }

    public Map<String, String> environment() {
        return this.environment;
    }

    public ProcessBuilder redirectErrorStream(boolean z) {
        this.redirectErrorStream = z;
        return this;
    }

    public boolean redirectErrorStream() {
        return this.redirectErrorStream;
    }

    public Process start() throws IOException {
        String[] strArr = (String[]) this.command.toArray(new String[this.command.size()]);
        String[] strArr2 = new String[this.environment.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : this.environment.entrySet()) {
            strArr2[i] = entry.getKey() + "=" + entry.getValue();
            i++;
        }
        return ProcessManager.getInstance().exec(strArr, strArr2, this.directory, this.redirectErrorStream);
    }
}
