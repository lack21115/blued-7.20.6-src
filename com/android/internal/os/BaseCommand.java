package com.android.internal.os;

import java.io.PrintStream;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/os/BaseCommand.class */
public abstract class BaseCommand {
    public static final String FATAL_ERROR_CODE = "Error type 1";
    public static final String NO_CLASS_ERROR_CODE = "Error type 3";
    public static final String NO_SYSTEM_ERROR_CODE = "Error type 2";
    protected String[] mArgs;
    private String mCurArgData;
    private int mNextArg;

    public String nextArg() {
        if (this.mCurArgData != null) {
            String str = this.mCurArgData;
            this.mCurArgData = null;
            return str;
        } else if (this.mNextArg < this.mArgs.length) {
            String[] strArr = this.mArgs;
            int i = this.mNextArg;
            this.mNextArg = i + 1;
            return strArr[i];
        } else {
            return null;
        }
    }

    public String nextArgRequired() {
        String nextArg = nextArg();
        if (nextArg == null) {
            throw new IllegalArgumentException("Argument expected after \"" + this.mArgs[this.mNextArg - 1] + "\"");
        }
        return nextArg;
    }

    public String nextOption() {
        if (this.mCurArgData != null) {
            throw new IllegalArgumentException("No argument expected after \"" + this.mArgs[this.mNextArg - 1] + "\"");
        } else if (this.mNextArg >= this.mArgs.length) {
            return null;
        } else {
            String str = this.mArgs[this.mNextArg];
            if (str.startsWith("-")) {
                this.mNextArg++;
                if (str.equals("--")) {
                    return null;
                }
                if (str.length() <= 1 || str.charAt(1) == '-') {
                    this.mCurArgData = null;
                    return str;
                } else if (str.length() > 2) {
                    this.mCurArgData = str.substring(2);
                    return str.substring(0, 2);
                } else {
                    this.mCurArgData = null;
                    return str;
                }
            }
            return null;
        }
    }

    public abstract void onRun() throws Exception;

    public abstract void onShowUsage(PrintStream printStream);

    public void run(String[] strArr) {
        if (strArr.length < 1) {
            onShowUsage(System.out);
            return;
        }
        this.mArgs = strArr;
        this.mNextArg = 0;
        this.mCurArgData = null;
        try {
            onRun();
        } catch (IllegalArgumentException e) {
            onShowUsage(System.err);
            System.err.println();
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public void showError(String str) {
        onShowUsage(System.err);
        System.err.println();
        System.err.println(str);
    }

    public void showUsage() {
        onShowUsage(System.err);
    }
}
