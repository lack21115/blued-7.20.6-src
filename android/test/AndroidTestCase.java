package android.test;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;

/* loaded from: source-9557208-dex2jar.jar:android/test/AndroidTestCase.class */
public class AndroidTestCase extends TestCase {
    protected Context mContext;
    private Context mTestContext;

    public void assertActivityRequiresPermission(String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        intent.addFlags(268435456);
        try {
            getContext().startActivity(intent);
            fail("expected security exception for " + str3);
        } catch (SecurityException e) {
            assertNotNull("security exception's error message.", e.getMessage());
            assertTrue("error message should contain " + str3 + ".", e.getMessage().contains(str3));
        }
    }

    public void assertReadingContentUriRequiresPermission(Uri uri, String str) {
        try {
            getContext().getContentResolver().query(uri, null, null, null, null);
            fail("expected SecurityException requiring " + str);
        } catch (SecurityException e) {
            assertNotNull("security exception's error message.", e.getMessage());
            assertTrue("error message should contain " + str + ".", e.getMessage().contains(str));
        }
    }

    public void assertWritingContentUriRequiresPermission(Uri uri, String str) {
        try {
            getContext().getContentResolver().insert(uri, new ContentValues());
            fail("expected SecurityException requiring " + str);
        } catch (SecurityException e) {
            assertNotNull("security exception's error message.", e.getMessage());
            assertTrue("error message should contain \"" + str + "\". Got: \"" + e.getMessage() + "\".", e.getMessage().contains(str));
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Context getTestContext() {
        return this.mTestContext;
    }

    protected void scrubClass(Class<?> cls) throws IllegalAccessException {
        Field[] declaredFields = getClass().getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Field field = declaredFields[i2];
            if (!field.getType().isPrimitive() && !Modifier.isStatic(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    field.set(this, null);
                } catch (Exception e) {
                    Log.d("TestCase", "Error: Could not nullify field!");
                }
                if (field.get(this) != null) {
                    Log.d("TestCase", "Error: Could not nullify field!");
                }
            }
            i = i2 + 1;
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setTestContext(Context context) {
        this.mTestContext = context;
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAndroidTestCaseSetupProperly() {
        assertNotNull("Context is null. setContext should be called before tests are run", this.mContext);
    }
}
