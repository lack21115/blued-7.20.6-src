package java.util.logging;

import dalvik.system.VMStack;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import libcore.util.Objects;
import org.apache.commons.codec.language.bm.Rule;

/* loaded from: source-2895416-dex2jar.jar:java/util/logging/Level.class */
public class Level implements Serializable {
    private static final long serialVersionUID = -8176160795706313070L;
    private final String name;
    private transient ResourceBundle rb;
    private final String resourceBundleName;
    private final int value;
    private static final List<Level> levels = new ArrayList(9);
    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);
    public static final Level SEVERE = new Level("SEVERE", 1000);
    public static final Level WARNING = new Level("WARNING", 900);
    public static final Level INFO = new Level("INFO", 800);
    public static final Level CONFIG = new Level("CONFIG", 700);
    public static final Level FINE = new Level("FINE", 500);
    public static final Level FINER = new Level("FINER", 400);
    public static final Level FINEST = new Level("FINEST", 300);
    public static final Level ALL = new Level(Rule.ALL, Integer.MIN_VALUE);

    protected Level(String str, int i) {
        this(str, i, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:9:0x0033). Please submit an issue!!! */
    protected Level(String str, int i, String str2) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.name = str;
        this.value = i;
        this.resourceBundleName = str2;
        if (str2 != null) {
            try {
                this.rb = ResourceBundle.getBundle(str2, Locale.getDefault(), VMStack.getCallingClassLoader());
            } catch (MissingResourceException e) {
                this.rb = null;
            }
        }
        synchronized (levels) {
            levels.add(this);
        }
    }

    public static Level parse(String str) throws IllegalArgumentException {
        int i;
        boolean z;
        Level next;
        Level next2;
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        try {
            i = Integer.parseInt(str);
            z = true;
        } catch (NumberFormatException e) {
            i = 0;
            z = false;
        }
        synchronized (levels) {
            Iterator<Level> it = levels.iterator();
            do {
                if (!it.hasNext()) {
                    if (z) {
                        Iterator<Level> it2 = levels.iterator();
                        do {
                            if (it2.hasNext()) {
                                next = it2.next();
                            }
                        } while (i != next.intValue());
                        return next;
                    }
                    if (z) {
                        return new Level(str, i);
                    }
                    throw new IllegalArgumentException("Cannot parse name '" + str + "'");
                }
                next2 = it.next();
            } while (!str.equals(next2.getName()));
            return next2;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        if (this.resourceBundleName != null) {
            try {
                this.rb = ResourceBundle.getBundle(this.resourceBundleName);
            } catch (MissingResourceException e) {
                this.rb = null;
            }
        }
    }

    private Object readResolve() {
        synchronized (levels) {
            for (Level level : levels) {
                if (this.value == level.value && this.name.equals(level.name) && Objects.equal(this.resourceBundleName, level.resourceBundleName)) {
                    return level;
                }
            }
            levels.add(this);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Level) && ((Level) obj).intValue() == this.value;
    }

    public String getLocalizedName() {
        if (this.rb == null) {
            return this.name;
        }
        try {
            return this.rb.getString(this.name);
        } catch (MissingResourceException e) {
            return this.name;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getResourceBundleName() {
        return this.resourceBundleName;
    }

    public int hashCode() {
        return this.value;
    }

    public final int intValue() {
        return this.value;
    }

    public final String toString() {
        return this.name;
    }
}
