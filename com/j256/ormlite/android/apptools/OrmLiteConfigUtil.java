package com.j256.ormlite.android.apptools;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/android/apptools/OrmLiteConfigUtil.class */
public class OrmLiteConfigUtil {
    protected static final String RAW_DIR_NAME = "raw";
    protected static final String RESOURCE_DIR_NAME = "res";
    private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    protected static int maxFindSourceLevel = 20;

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
        r3 = r3.getSuperclass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        r0 = java.lang.System.err;
        r0.println("Could not get super class for: " + r3);
        r0 = java.lang.System.err;
        r0.println("     " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean classHasAnnotations(java.lang.Class<?> r3) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.classHasAnnotations(java.lang.Class):boolean");
    }

    private static void findAnnotatedClasses(List<Class<?>> list, File file, int i) throws SQLException, IOException {
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            File file2 = listFiles[i3];
            if (file2.isDirectory()) {
                if (i < maxFindSourceLevel) {
                    findAnnotatedClasses(list, file2, i + 1);
                }
            } else if (file2.getName().endsWith(".java")) {
                String packageOfClass = getPackageOfClass(file2);
                if (packageOfClass == null) {
                    PrintStream printStream = System.err;
                    printStream.println("Could not find package name for: " + file2);
                } else {
                    String name = file2.getName();
                    String substring = name.substring(0, name.length() - 5);
                    try {
                        Class<?> cls = Class.forName(packageOfClass + "." + substring);
                        if (classHasAnnotations(cls)) {
                            list.add(cls);
                        }
                        try {
                            Class<?>[] declaredClasses = cls.getDeclaredClasses();
                            int length2 = declaredClasses.length;
                            int i4 = 0;
                            while (true) {
                                int i5 = i4;
                                if (i5 < length2) {
                                    Class<?> cls2 = declaredClasses[i5];
                                    if (classHasAnnotations(cls2)) {
                                        list.add(cls2);
                                    }
                                    i4 = i5 + 1;
                                }
                            }
                        } catch (Throwable th) {
                            PrintStream printStream2 = System.err;
                            printStream2.println("Could not load inner classes for: " + cls);
                            PrintStream printStream3 = System.err;
                            printStream3.println("     " + th);
                        }
                    } catch (Throwable th2) {
                        PrintStream printStream4 = System.err;
                        printStream4.println("Could not load class file for: " + file2);
                        PrintStream printStream5 = System.err;
                        printStream5.println("     " + th2);
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    protected static File findRawDir(File file) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (file == null || i2 >= 20) {
                return null;
            }
            File findResRawDir = findResRawDir(file);
            if (findResRawDir != null) {
                return findResRawDir;
            }
            file = file.getParentFile();
            i = i2 + 1;
        }
    }

    private static File findResRawDir(File file) {
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            File file2 = listFiles[i2];
            if (file2.getName().equals("res") && file2.isDirectory()) {
                File[] listFiles2 = file2.listFiles(new FileFilter() { // from class: com.j256.ormlite.android.apptools.OrmLiteConfigUtil.1
                    @Override // java.io.FileFilter
                    public boolean accept(File file3) {
                        return file3.getName().equals("raw") && file3.isDirectory();
                    }
                });
                if (listFiles2.length == 1) {
                    return listFiles2[0];
                }
            }
            i = i2 + 1;
        }
    }

    private static String getPackageOfClass(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return null;
                } else if (readLine.contains("package")) {
                    String[] split = readLine.split("[ \t;]");
                    if (split.length > 1 && split[0].equals("package")) {
                        return split[1];
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            throw new IllegalArgumentException("Main can take a single file-name argument.");
        }
        writeConfigFile(strArr[0]);
    }

    public static void writeConfigFile(File file) throws SQLException, IOException {
        writeConfigFile(file, new File("."));
    }

    public static void writeConfigFile(File file, File file2) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file2, 0);
        writeConfigFile(file, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(File file, Class<?>[] clsArr) throws SQLException, IOException {
        PrintStream printStream = System.out;
        printStream.println("Writing configurations to " + file.getAbsolutePath());
        writeConfigFile(new FileOutputStream(file), clsArr);
    }

    public static void writeConfigFile(OutputStream outputStream, File file) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, file, 0);
        writeConfigFile(outputStream, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(OutputStream outputStream, Class<?>[] clsArr) throws SQLException, IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 4096);
        try {
            writeHeader(bufferedWriter);
            int length = clsArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    System.out.println("Done.");
                    return;
                } else {
                    writeConfigForTable(bufferedWriter, clsArr[i2]);
                    i = i2 + 1;
                }
            }
        } finally {
            bufferedWriter.close();
        }
    }

    public static void writeConfigFile(String str) throws SQLException, IOException {
        ArrayList arrayList = new ArrayList();
        findAnnotatedClasses(arrayList, new File("."), 0);
        writeConfigFile(str, (Class[]) arrayList.toArray(new Class[arrayList.size()]));
    }

    public static void writeConfigFile(String str, Class<?>[] clsArr) throws SQLException, IOException {
        File findRawDir = findRawDir(new File("."));
        if (findRawDir == null) {
            System.err.println("Could not find raw directory which is typically in the res directory");
        } else {
            writeConfigFile(new File(findRawDir, str), clsArr);
        }
    }

    private static void writeConfigForTable(BufferedWriter bufferedWriter, Class<?> cls) throws SQLException, IOException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(databaseType, extractTableName, declaredFields[i2]);
                        if (fromField != null) {
                            arrayList.add(fromField);
                        }
                        i = i2 + 1;
                    }
                }
            } catch (Error e) {
                PrintStream printStream = System.err;
                printStream.println("Skipping " + cls + " because we got an error finding its definition: " + e.getMessage());
                return;
            }
        }
        if (arrayList.isEmpty()) {
            PrintStream printStream2 = System.out;
            printStream2.println("Skipping " + cls + " because no annotated fields found");
            return;
        }
        DatabaseTableConfigLoader.write(bufferedWriter, new DatabaseTableConfig(cls, extractTableName, arrayList));
        bufferedWriter.append("#################################");
        bufferedWriter.newLine();
        PrintStream printStream3 = System.out;
        printStream3.println("Wrote config for " + cls);
    }

    private static void writeHeader(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.append('#');
        bufferedWriter.newLine();
        bufferedWriter.append("# generated on ").append((CharSequence) new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(new Date()));
        bufferedWriter.newLine();
        bufferedWriter.append('#');
        bufferedWriter.newLine();
    }
}
