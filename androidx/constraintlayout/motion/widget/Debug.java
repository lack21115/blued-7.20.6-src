package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/Debug.class */
public class Debug {
    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + "  " + layoutParams.getClass().getName());
        Field[] fields = layoutParams.getClass().getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fields.length) {
                System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
                return;
            }
            Field field = fields[i2];
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(str2 + "       " + name + " " + obj);
                }
            } catch (IllegalAccessException e) {
            }
            i = i2 + 1;
        }
    }

    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = viewGroup.getChildAt(i2);
            System.out.println(str2 + "     " + getName(childAt));
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Field[] fields = layoutParams.getClass().getFields();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < fields.length) {
                    Field field = fields[i4];
                    try {
                        Object obj = field.get(layoutParams);
                        if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                            System.out.println(str2 + "       " + field.getName() + " " + obj);
                        }
                    } catch (IllegalAccessException e) {
                    }
                    i3 = i4 + 1;
                }
            }
            i = i2 + 1;
        }
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        System.out.println(str + "------------- " + cls.getName() + " --------------------");
        Field[] fields = cls.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fields.length) {
                System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
                return;
            }
            Field field = fields[i2];
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(str + "    " + field.getName() + " " + obj2);
                }
            } catch (IllegalAccessException e) {
            }
            i = i2 + 1;
        }
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Field[] fields = MotionEvent.class.getFields();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= fields.length) {
                return "---";
            }
            Field field = fields[i2];
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException e) {
            }
            i = i2 + 1;
        }
    }

    public static String getCallFrom(int i) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getName(Context context, int i) {
        if (i != -1) {
            try {
                return context.getResources().getResourceEntryName(i);
            } catch (Exception e) {
                return "?" + i;
            }
        }
        return GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static String getName(Context context, int[] iArr) {
        String str;
        int i;
        String str2;
        try {
            str = iArr.length + "[";
            i = 0;
        } catch (Exception e) {
            Log.v("DEBUG", e.toString());
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        while (true) {
            int i2 = i;
            if (i2 >= iArr.length) {
                return str + "]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(i2 == 0 ? "" : " ");
            String sb2 = sb.toString();
            try {
                str2 = context.getResources().getResourceEntryName(iArr[i2]);
            } catch (Resources.NotFoundException e2) {
                str2 = "? " + iArr[i2] + " ";
            }
            str = sb2 + str2;
            i = i2 + 1;
            Log.v("DEBUG", e.toString());
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception e) {
            return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static String getState(MotionLayout motionLayout, int i) {
        return getState(motionLayout, i, -1);
    }

    public static String getState(MotionLayout motionLayout, int i, int i2) {
        if (i == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i);
        String str = resourceEntryName;
        if (i2 != -1) {
            String str2 = resourceEntryName;
            if (resourceEntryName.length() > i2) {
                str2 = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
            }
            str = str2;
            if (str2.length() > i2) {
                int length = str2.replaceAll("[^_]", "").length();
                str = str2;
                if (length > 0) {
                    int length2 = (str2.length() - i2) / length;
                    str = str2.replaceAll(CharBuffer.allocate(length2).toString().replace((char) 0, '.') + "_", "_");
                }
            }
        }
        return str;
    }

    public static void logStack(String str, String str2, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str3 = " ";
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > min) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            str3 = str3 + " ";
            Log.v(str, str2 + str3 + (".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") " + stackTrace[i3].getMethodName()) + str3);
            i2 = i3 + 1;
        }
    }

    public static void printStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str2 = " ";
        int i2 = 1;
        while (true) {
            int i3 = i2;
            if (i3 > min) {
                return;
            }
            StackTraceElement stackTraceElement = stackTrace[i3];
            String str3 = ".(" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ") ";
            str2 = str2 + " ";
            System.out.println(str + str2 + str3 + str2);
            i2 = i3 + 1;
        }
    }
}
