package java.sql;

/* loaded from: source-2895416-dex2jar.jar:java/sql/DriverPropertyInfo.class */
public class DriverPropertyInfo {
    public String name;
    public String value;
    public String[] choices = null;
    public String description = null;
    public boolean required = false;

    public DriverPropertyInfo(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
