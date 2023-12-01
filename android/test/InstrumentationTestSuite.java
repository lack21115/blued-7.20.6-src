package android.test;

import android.app.Instrumentation;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/* loaded from: source-9557208-dex2jar.jar:android/test/InstrumentationTestSuite.class */
public class InstrumentationTestSuite extends TestSuite {
    private final Instrumentation mInstrumentation;

    public InstrumentationTestSuite(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
    }

    public InstrumentationTestSuite(Class cls, Instrumentation instrumentation) {
        super(cls);
        this.mInstrumentation = instrumentation;
    }

    public InstrumentationTestSuite(String str, Instrumentation instrumentation) {
        super(str);
        this.mInstrumentation = instrumentation;
    }

    public void addTestSuite(Class cls) {
        addTest(new InstrumentationTestSuite(cls, this.mInstrumentation));
    }

    public void runTest(Test test, TestResult testResult) {
        if (test instanceof InstrumentationTestCase) {
            ((InstrumentationTestCase) test).injectInstrumentation(this.mInstrumentation);
        }
        super.runTest(test, testResult);
    }
}
