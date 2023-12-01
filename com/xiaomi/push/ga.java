package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ga.class */
public final class ga {

    /* renamed from: a  reason: collision with root package name */
    private static int f41428a = 5000;

    /* renamed from: a  reason: collision with other field name */
    private static Vector<String> f502a = new Vector<>();
    private static int b = 330000;

    /* renamed from: c  reason: collision with root package name */
    private static int f41429c = 600000;
    private static int d = 330000;

    static {
        int next;
        try {
            ClassLoader[] m11808a = m11808a();
            int length = m11808a.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                Enumeration<URL> resources = m11808a[i2].getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        InputStream openStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
                        newPullParser.setInput(openStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("className")) {
                                    a(newPullParser);
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    f41428a = a(newPullParser, f41428a);
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    b = a(newPullParser, b);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    f502a.add(newPullParser.nextText());
                                }
                            }
                            next = newPullParser.next();
                            eventType = next;
                        } while (next != 1);
                        inputStream = openStream;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
                i = i2 + 1;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private ga() {
    }

    public static int a() {
        return b;
    }

    private static int a(XmlPullParser xmlPullParser, int i) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m11807a() {
        return "3.1.0";
    }

    private static void a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException e) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: ".concat(String.valueOf(nextText)));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static ClassLoader[] m11808a() {
        ClassLoader classLoader = ga.class.getClassLoader();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader2 = new ClassLoader[]{classLoader, contextClassLoader}[i];
            if (classLoader2 != null) {
                arrayList.add(classLoader2);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public static int b() {
        return f41429c;
    }
}
