package android.net;

import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkConfig.class */
public class NetworkConfig {
    public boolean dependencyMet;
    public String name;
    public int priority;
    public int radio;
    public int restoreTime;
    public int type;

    public NetworkConfig(String str) {
        String[] split = str.split(",");
        this.name = split[0].trim().toLowerCase(Locale.ROOT);
        this.type = Integer.parseInt(split[1]);
        this.radio = Integer.parseInt(split[2]);
        this.priority = Integer.parseInt(split[3]);
        this.restoreTime = Integer.parseInt(split[4]);
        this.dependencyMet = Boolean.parseBoolean(split[5]);
    }

    public boolean isDefault() {
        return this.type == this.radio;
    }
}
