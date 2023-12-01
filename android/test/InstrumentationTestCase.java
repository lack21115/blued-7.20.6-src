package android.test;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;

/* loaded from: source-9557208-dex2jar.jar:android/test/InstrumentationTestCase.class */
public class InstrumentationTestCase extends TestCase {
    private Instrumentation mInstrumentation;

    private void runMethod(Method method, int i) throws Throwable {
        runMethod(method, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runMethod(Method method, int i, boolean z) throws Throwable {
        IllegalAccessException illegalAccessException;
        int i2;
        int i3 = 0;
        while (true) {
            try {
                try {
                    method.invoke(this, null);
                    int i4 = i3 + 1;
                    illegalAccessException = null;
                    i2 = i4;
                    if (z) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("currentiterations", i4);
                        getInstrumentation().sendStatus(2, bundle);
                        i2 = i4;
                        illegalAccessException = null;
                    }
                } catch (IllegalAccessException e) {
                    e.fillInStackTrace();
                    int i5 = i3 + 1;
                    illegalAccessException = e;
                    i2 = i5;
                    if (z) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("currentiterations", i5);
                        getInstrumentation().sendStatus(2, bundle2);
                        illegalAccessException = e;
                        i2 = i5;
                    }
                } catch (InvocationTargetException e2) {
                    e2.fillInStackTrace();
                    Throwable targetException = e2.getTargetException();
                    int i6 = i3 + 1;
                    illegalAccessException = targetException;
                    i2 = i6;
                    if (z) {
                        Bundle bundle3 = new Bundle();
                        bundle3.putInt("currentiterations", i6);
                        getInstrumentation().sendStatus(2, bundle3);
                        illegalAccessException = targetException;
                        i2 = i6;
                    }
                }
                if (i2 >= i) {
                    break;
                }
                i3 = i2;
                if (!z) {
                    i3 = i2;
                    if (illegalAccessException == null) {
                        break;
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putInt("currentiterations", i3 + 1);
                    getInstrumentation().sendStatus(2, bundle4);
                }
                throw th;
            }
        }
        if (illegalAccessException != null) {
            throw illegalAccessException;
        }
    }

    public Instrumentation getInstrumentation() {
        return this.mInstrumentation;
    }

    @Deprecated
    public void injectInsrumentation(Instrumentation instrumentation) {
        injectInstrumentation(instrumentation);
    }

    public void injectInstrumentation(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
    }

    public final <T extends Activity> T launchActivity(String str, Class<T> cls, Bundle bundle) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return (T) launchActivityWithIntent(str, cls, intent);
    }

    public final <T extends Activity> T launchActivityWithIntent(String str, Class<T> cls, Intent intent) {
        intent.setClassName(str, cls.getName());
        intent.addFlags(268435456);
        T t = (T) getInstrumentation().startActivitySync(intent);
        getInstrumentation().waitForIdleSync();
        return t;
    }

    protected void runTest() throws Throwable {
        String name = getName();
        assertNotNull(name);
        Method method = null;
        try {
            method = getClass().getMethod(name, null);
        } catch (NoSuchMethodException e) {
            fail("Method \"" + name + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            fail("Method \"" + name + "\" should be public");
        }
        int i = 1;
        boolean z = false;
        if (method.isAnnotationPresent(FlakyTest.class)) {
            i = ((FlakyTest) method.getAnnotation(FlakyTest.class)).tolerance();
        } else if (method.isAnnotationPresent(RepetitiveTest.class)) {
            i = ((RepetitiveTest) method.getAnnotation(RepetitiveTest.class)).numIterations();
            z = true;
        }
        if (!method.isAnnotationPresent(UiThreadTest.class)) {
            runMethod(method, i, z);
            return;
        }
        final Throwable[] thArr = new Throwable[1];
        final Method method2 = method;
        final int i2 = i;
        final boolean z2 = z;
        getInstrumentation().runOnMainSync(new Runnable() { // from class: android.test.InstrumentationTestCase.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InstrumentationTestCase.this.runMethod(method2, i2, z2);
                } catch (Throwable th) {
                    thArr[0] = th;
                }
            }
        });
        if (thArr[0] != null) {
            throw thArr[0];
        }
    }

    public void runTestOnUiThread(final Runnable runnable) throws Throwable {
        final Throwable[] thArr = new Throwable[1];
        getInstrumentation().runOnMainSync(new Runnable() { // from class: android.test.InstrumentationTestCase.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    thArr[0] = th;
                }
            }
        });
        if (thArr[0] != null) {
            throw thArr[0];
        }
    }

    public void sendKeys(String str) {
        int parseInt;
        String[] split = str.split(" ");
        int length = split.length;
        Instrumentation instrumentation = getInstrumentation();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                instrumentation.waitForIdleSync();
                return;
            }
            String str2 = split[i2];
            int indexOf = str2.indexOf(42);
            if (indexOf == -1) {
                parseInt = 1;
            } else {
                try {
                    parseInt = Integer.parseInt(str2.substring(0, indexOf));
                } catch (NumberFormatException e) {
                    Log.w("ActivityTestCase", "Invalid repeat count: " + str2);
                }
            }
            String str3 = str2;
            if (indexOf != -1) {
                str3 = str2.substring(indexOf + 1);
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < parseInt) {
                    try {
                        try {
                            instrumentation.sendKeyDownUpSync(KeyEvent.class.getField("KEYCODE_" + str3).getInt(null));
                        } catch (SecurityException e2) {
                        }
                        i3 = i4 + 1;
                    } catch (IllegalAccessException e3) {
                        Log.w("ActivityTestCase", "Unknown keycode: KEYCODE_" + str3);
                    } catch (NoSuchFieldException e4) {
                        Log.w("ActivityTestCase", "Unknown keycode: KEYCODE_" + str3);
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public void sendKeys(int... iArr) {
        int length = iArr.length;
        Instrumentation instrumentation = getInstrumentation();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                instrumentation.waitForIdleSync();
                return;
            } else {
                try {
                    instrumentation.sendKeyDownUpSync(iArr[i2]);
                } catch (SecurityException e) {
                }
                i = i2 + 1;
            }
        }
    }

    public void sendRepeatedKeys(int... iArr) {
        int length = iArr.length;
        if ((length & 1) == 1) {
            throw new IllegalArgumentException("The size of the keys array must be a multiple of 2");
        }
        Instrumentation instrumentation = getInstrumentation();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                instrumentation.waitForIdleSync();
                return;
            }
            int i3 = iArr[i2];
            int i4 = iArr[i2 + 1];
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 < i3) {
                    try {
                        instrumentation.sendKeyDownUpSync(i4);
                    } catch (SecurityException e) {
                    }
                    i5 = i6 + 1;
                }
            }
            i = i2 + 2;
        }
    }

    protected void tearDown() throws Exception {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        super.tearDown();
    }
}
