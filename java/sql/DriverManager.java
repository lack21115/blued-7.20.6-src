package java.sql;

import dalvik.system.VMStack;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/* loaded from: source-2895416-dex2jar.jar:java/sql/DriverManager.class */
public class DriverManager {
    private static PrintStream thePrintStream;
    private static PrintWriter thePrintWriter;
    private static int loginTimeout = 0;
    private static final List<Driver> theDrivers = new ArrayList(10);
    private static final SQLPermission logPermission = new SQLPermission("setLog");

    static {
        loadInitialDrivers();
    }

    private DriverManager() {
    }

    public static void deregisterDriver(Driver driver) throws SQLException {
        if (driver == null) {
            return;
        }
        if (!isClassFromClassLoader(driver, VMStack.getCallingClassLoader())) {
            throw new SecurityException("calling class not authorized to deregister JDBC driver");
        }
        synchronized (theDrivers) {
            theDrivers.remove(driver);
        }
    }

    public static Connection getConnection(String str) throws SQLException {
        return getConnection(str, new Properties());
    }

    public static Connection getConnection(String str, String str2, String str3) throws SQLException {
        Properties properties = new Properties();
        if (str2 != null) {
            properties.setProperty("user", str2);
        }
        if (str3 != null) {
            properties.setProperty("password", str3);
        }
        return getConnection(str, properties);
    }

    public static Connection getConnection(String str, Properties properties) throws SQLException {
        Connection connect;
        if (str == null) {
            throw new SQLException("The url cannot be null", "08001");
        }
        synchronized (theDrivers) {
            Iterator<Driver> it = theDrivers.iterator();
            do {
                if (!it.hasNext()) {
                    throw new SQLException("No suitable driver", "08001");
                }
                connect = it.next().connect(str, properties);
            } while (connect == null);
            return connect;
        }
    }

    public static Driver getDriver(String str) throws SQLException {
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        synchronized (theDrivers) {
            for (Driver driver : theDrivers) {
                if (driver.acceptsURL(str) && isClassFromClassLoader(driver, callingClassLoader)) {
                    return driver;
                }
            }
            throw new SQLException("No suitable driver", "08001");
        }
    }

    public static Enumeration<Driver> getDrivers() {
        Enumeration<Driver> enumeration;
        ClassLoader callingClassLoader = VMStack.getCallingClassLoader();
        synchronized (theDrivers) {
            ArrayList arrayList = new ArrayList();
            for (Driver driver : theDrivers) {
                if (isClassFromClassLoader(driver, callingClassLoader)) {
                    arrayList.add(driver);
                }
            }
            enumeration = Collections.enumeration(arrayList);
        }
        return enumeration;
    }

    @Deprecated
    public static PrintStream getLogStream() {
        return thePrintStream;
    }

    public static PrintWriter getLogWriter() {
        return thePrintWriter;
    }

    public static int getLoginTimeout() {
        return loginTimeout;
    }

    private static boolean isClassFromClassLoader(Object obj, ClassLoader classLoader) {
        boolean z = true;
        if (obj == null || classLoader == null) {
            z = false;
        } else {
            Class<?> cls = obj.getClass();
            try {
                if (Class.forName(cls.getName(), true, classLoader) != cls) {
                    return false;
                }
            } catch (Throwable th) {
                return false;
            }
        }
        return z;
    }

    private static void loadInitialDrivers() {
        String property = System.getProperty("jdbc.drivers", null);
        if (property == null) {
            return;
        }
        String[] split = property.split(":");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            try {
                Class.forName(split[i2], true, ClassLoader.getSystemClassLoader());
            } catch (Throwable th) {
            }
            i = i2 + 1;
        }
    }

    public static void println(String str) {
        if (thePrintWriter != null) {
            thePrintWriter.println(str);
            thePrintWriter.flush();
        } else if (thePrintStream != null) {
            thePrintStream.println(str);
            thePrintStream.flush();
        }
    }

    public static void registerDriver(Driver driver) throws SQLException {
        if (driver == null) {
            throw new NullPointerException("driver == null");
        }
        synchronized (theDrivers) {
            theDrivers.add(driver);
        }
    }

    @Deprecated
    public static void setLogStream(PrintStream printStream) {
        thePrintStream = printStream;
    }

    public static void setLogWriter(PrintWriter printWriter) {
        thePrintWriter = printWriter;
    }

    public static void setLoginTimeout(int i) {
        loginTimeout = i;
    }
}
