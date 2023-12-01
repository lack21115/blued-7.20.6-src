package dalvik.system;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-2895416-dex2jar.jar:dalvik/system/DalvikLogHandler.class */
public interface DalvikLogHandler {
    void publish(Logger logger, String str, Level level, String str2);
}
