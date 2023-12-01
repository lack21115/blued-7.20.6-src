package android.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.igexin.push.core.b;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug.class */
public class ViewDebug {
    private static final int CAPTURE_TIMEOUT = 4000;
    public static final boolean DEBUG_DRAG = false;
    private static final String REMOTE_COMMAND_CAPTURE = "CAPTURE";
    private static final String REMOTE_COMMAND_CAPTURE_LAYERS = "CAPTURE_LAYERS";
    private static final String REMOTE_COMMAND_DUMP = "DUMP";
    private static final String REMOTE_COMMAND_DUMP_THEME = "DUMP_THEME";
    private static final String REMOTE_COMMAND_INVALIDATE = "INVALIDATE";
    private static final String REMOTE_COMMAND_OUTPUT_DISPLAYLIST = "OUTPUT_DISPLAYLIST";
    private static final String REMOTE_COMMAND_REQUEST_LAYOUT = "REQUEST_LAYOUT";
    private static final String REMOTE_PROFILE = "PROFILE";
    @Deprecated
    public static final boolean TRACE_HIERARCHY = false;
    @Deprecated
    public static final boolean TRACE_RECYCLER = false;
    private static HashMap<AccessibleObject, ExportedProperty> sAnnotations;
    private static HashMap<Class<?>, Field[]> sFieldsForClasses;
    private static HashMap<Class<?>, Method[]> sMethodsForClasses;
    private static HashMap<Class<?>, Method[]> mCapturedViewMethodsForClasses = null;
    private static HashMap<Class<?>, Field[]> mCapturedViewFieldsForClasses = null;

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$CapturedViewProperty.class */
    public @interface CapturedViewProperty {
        boolean retrieveReturn() default false;
    }

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$ExportedProperty.class */
    public @interface ExportedProperty {
        String category() default "";

        boolean deepExport() default false;

        FlagToString[] flagMapping() default {};

        boolean formatToHexString() default false;

        boolean hasAdjacentMapping() default false;

        IntToString[] indexMapping() default {};

        IntToString[] mapping() default {};

        String prefix() default "";

        boolean resolveId() default false;
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$FlagToString.class */
    public @interface FlagToString {
        int equals();

        int mask();

        String name();

        boolean outputIf() default true;
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$HierarchyHandler.class */
    public interface HierarchyHandler {
        void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i);

        View findHierarchyView(String str, int i);
    }

    @Deprecated
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$HierarchyTraceType.class */
    public enum HierarchyTraceType {
        INVALIDATE,
        INVALIDATE_CHILD,
        INVALIDATE_CHILD_IN_PARENT,
        REQUEST_LAYOUT,
        ON_LAYOUT,
        ON_MEASURE,
        DRAW,
        BUILD_CACHE
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$IntToString.class */
    public @interface IntToString {
        int from();

        String to();
    }

    @Deprecated
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$RecyclerTraceType.class */
    public enum RecyclerTraceType {
        NEW_VIEW,
        BIND_VIEW,
        RECYCLE_FROM_ACTIVE_HEAP,
        RECYCLE_FROM_SCRAP_HEAP,
        MOVE_TO_SCRAP_HEAP,
        MOVE_FROM_ACTIVE_TO_SCRAP_HEAP
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/ViewDebug$ViewOperation.class */
    public interface ViewOperation<T> {
        void post(T... tArr);

        T[] pre();

        void run(T... tArr);
    }

    private static Object callMethodOnAppropriateTheadBlocking(final Method method, Object obj) throws IllegalAccessException, InvocationTargetException, TimeoutException {
        if (!(obj instanceof View)) {
            return method.invoke(obj, null);
        }
        final View view = (View) obj;
        FutureTask futureTask = new FutureTask(new Callable<Object>() { // from class: android.view.ViewDebug.7
            @Override // java.util.concurrent.Callable
            public Object call() throws IllegalAccessException, InvocationTargetException {
                return Method.this.invoke(view, null);
            }
        });
        Handler handler = view.getHandler();
        Handler handler2 = handler;
        if (handler == null) {
            handler2 = new Handler(Looper.getMainLooper());
        }
        handler2.post(futureTask);
        while (true) {
            try {
                return futureTask.get(4000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
            } catch (CancellationException e2) {
                throw new RuntimeException("Unexpected cancellation exception", e2);
            } catch (ExecutionException e3) {
                Throwable cause = e3.getCause();
                if (cause instanceof IllegalAccessException) {
                    throw ((IllegalAccessException) cause);
                }
                if (cause instanceof InvocationTargetException) {
                    throw ((InvocationTargetException) cause);
                }
                throw new RuntimeException("Unexpected exception", cause);
            }
        }
    }

    public static void capture(View view, OutputStream outputStream, View view2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        Bitmap performViewCapture = performViewCapture(view2, false);
        Bitmap bitmap = performViewCapture;
        if (performViewCapture == null) {
            Log.w("View", "Failed to create capture bitmap!");
            bitmap = Bitmap.createBitmap(view.getResources().getDisplayMetrics(), 1, 1, Bitmap.Config.ARGB_8888);
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(outputStream, 32768);
        } catch (Throwable th) {
            th = th;
        }
        try {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            bitmap.recycle();
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            bitmap.recycle();
            throw th;
        }
    }

    private static void capture(View view, OutputStream outputStream, String str) throws IOException {
        capture(view, outputStream, findView(view, str));
    }

    public static void captureLayers(View view, DataOutputStream dataOutputStream) throws IOException {
        try {
            Rect rect = new Rect();
            try {
                view.mAttachInfo.mSession.getDisplayFrame(view.mAttachInfo.mWindow, rect);
            } catch (RemoteException e) {
            }
            dataOutputStream.writeInt(rect.width());
            dataOutputStream.writeInt(rect.height());
            captureViewLayer(view, dataOutputStream, true);
            dataOutputStream.write(2);
        } finally {
            dataOutputStream.close();
        }
    }

    private static void captureViewLayer(View view, DataOutputStream dataOutputStream, boolean z) throws IOException {
        boolean z2 = view.getVisibility() == 0 && z;
        if ((view.mPrivateFlags & 128) != 128) {
            int id = view.getId();
            String simpleName = view.getClass().getSimpleName();
            if (id != -1) {
                simpleName = resolveId(view.getContext(), id).toString();
            }
            dataOutputStream.write(1);
            dataOutputStream.writeUTF(simpleName);
            dataOutputStream.writeByte(z2 ? 1 : 0);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            dataOutputStream.writeInt(iArr[0]);
            dataOutputStream.writeInt(iArr[1]);
            dataOutputStream.flush();
            Bitmap performViewCapture = performViewCapture(view, true);
            if (performViewCapture != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(performViewCapture.getWidth() * performViewCapture.getHeight() * 2);
                performViewCapture.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                dataOutputStream.writeInt(byteArrayOutputStream.size());
                byteArrayOutputStream.writeTo(dataOutputStream);
            }
            dataOutputStream.flush();
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                captureViewLayer(viewGroup.getChildAt(i2), dataOutputStream, z2);
                i = i2 + 1;
            }
        }
        if (view.mOverlay != null) {
            captureViewLayer(view.getOverlay().mOverlayViewGroup, dataOutputStream, z2);
        }
    }

    private static String capturedViewExportFields(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return b.l;
        }
        StringBuilder sb = new StringBuilder();
        Field[] capturedViewGetPropertyFields = capturedViewGetPropertyFields(cls);
        int length = capturedViewGetPropertyFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Field field = capturedViewGetPropertyFields[i2];
            try {
                Object obj2 = field.get(obj);
                sb.append(str);
                sb.append(field.getName());
                sb.append("=");
                if (obj2 != null) {
                    sb.append(obj2.toString().replace("\n", "\\n"));
                } else {
                    sb.append(b.l);
                }
                sb.append(' ');
            } catch (IllegalAccessException e) {
            }
            i = i2 + 1;
        }
    }

    private static String capturedViewExportMethods(Object obj, Class<?> cls, String str) {
        if (obj == null) {
            return b.l;
        }
        StringBuilder sb = new StringBuilder();
        Method[] capturedViewGetPropertyMethods = capturedViewGetPropertyMethods(cls);
        int length = capturedViewGetPropertyMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            Method method = capturedViewGetPropertyMethods[i2];
            try {
                Object invoke = method.invoke(obj, null);
                Class<?> returnType = method.getReturnType();
                if (((CapturedViewProperty) method.getAnnotation(CapturedViewProperty.class)).retrieveReturn()) {
                    sb.append(capturedViewExportMethods(invoke, returnType, method.getName() + "#"));
                } else {
                    sb.append(str);
                    sb.append(method.getName());
                    sb.append("()=");
                    if (invoke != null) {
                        sb.append(invoke.toString().replace("\n", "\\n"));
                    } else {
                        sb.append(b.l);
                    }
                    sb.append("; ");
                }
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            }
            i = i2 + 1;
        }
    }

    private static Field[] capturedViewGetPropertyFields(Class<?> cls) {
        if (mCapturedViewFieldsForClasses == null) {
            mCapturedViewFieldsForClasses = new HashMap<>();
        }
        HashMap<Class<?>, Field[]> hashMap = mCapturedViewFieldsForClasses;
        Field[] fieldArr = hashMap.get(cls);
        if (fieldArr != null) {
            return fieldArr;
        }
        ArrayList arrayList = new ArrayList();
        Field[] fields = cls.getFields();
        int length = fields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Field[] fieldArr2 = (Field[]) arrayList.toArray(new Field[arrayList.size()]);
                hashMap.put(cls, fieldArr2);
                return fieldArr2;
            }
            Field field = fields[i2];
            if (field.isAnnotationPresent(CapturedViewProperty.class)) {
                field.setAccessible(true);
                arrayList.add(field);
            }
            i = i2 + 1;
        }
    }

    private static Method[] capturedViewGetPropertyMethods(Class<?> cls) {
        if (mCapturedViewMethodsForClasses == null) {
            mCapturedViewMethodsForClasses = new HashMap<>();
        }
        HashMap<Class<?>, Method[]> hashMap = mCapturedViewMethodsForClasses;
        Method[] methodArr = hashMap.get(cls);
        if (methodArr != null) {
            return methodArr;
        }
        ArrayList arrayList = new ArrayList();
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                Method[] methodArr2 = (Method[]) arrayList.toArray(new Method[arrayList.size()]);
                hashMap.put(cls, methodArr2);
                return methodArr2;
            }
            Method method = methods[i2];
            if (method.getParameterTypes().length == 0 && method.isAnnotationPresent(CapturedViewProperty.class) && method.getReturnType() != Void.class) {
                method.setAccessible(true);
                arrayList.add(method);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dispatchCommand(View view, String str, String str2, OutputStream outputStream) throws IOException {
        View rootView = view.getRootView();
        if (REMOTE_COMMAND_DUMP.equalsIgnoreCase(str)) {
            dump(rootView, false, true, outputStream);
        } else if (REMOTE_COMMAND_DUMP_THEME.equalsIgnoreCase(str)) {
            dumpTheme(rootView, outputStream);
        } else if (REMOTE_COMMAND_CAPTURE_LAYERS.equalsIgnoreCase(str)) {
            captureLayers(rootView, new DataOutputStream(outputStream));
        } else {
            String[] split = str2.split(" ");
            if (REMOTE_COMMAND_CAPTURE.equalsIgnoreCase(str)) {
                capture(rootView, outputStream, split[0]);
            } else if (REMOTE_COMMAND_OUTPUT_DISPLAYLIST.equalsIgnoreCase(str)) {
                outputDisplayList(rootView, split[0]);
            } else if (REMOTE_COMMAND_INVALIDATE.equalsIgnoreCase(str)) {
                invalidate(rootView, split[0]);
            } else if (REMOTE_COMMAND_REQUEST_LAYOUT.equalsIgnoreCase(str)) {
                requestLayout(rootView, split[0]);
            } else if (REMOTE_PROFILE.equalsIgnoreCase(str)) {
                profile(rootView, outputStream, split[0]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void dump(android.view.View r7, boolean r8, boolean r9, java.io.OutputStream r10) throws java.io.IOException {
        /*
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L78
            r1 = r0
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L78
            r3 = r2
            r4 = r10
            java.lang.String r5 = "utf-8"
            r3.<init>(r4, r5)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L78
            r3 = 32768(0x8000, float:4.5918E-41)
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L78
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r7
            android.view.View r0 = r0.getRootView()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            r7 = r0
            r0 = r11
            r10 = r0
            r0 = r7
            boolean r0 = r0 instanceof android.view.ViewGroup     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            if (r0 == 0) goto L40
            r0 = r11
            r10 = r0
            r0 = r7
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            r7 = r0
            r0 = r11
            r10 = r0
            r0 = r7
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            r1 = r7
            r2 = r11
            r3 = 0
            r4 = r8
            r5 = r9
            dumpViewHierarchy(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
        L40:
            r0 = r11
            r10 = r0
            r0 = r11
            java.lang.String r1 = "DONE."
            r0.write(r1)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            r0 = r11
            r10 = r0
            r0 = r11
            r0.newLine()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L89
            r0 = r11
            if (r0 == 0) goto L5d
            r0 = r11
            r0.close()
        L5d:
            return
        L5e:
            r11 = move-exception
            r0 = 0
            r7 = r0
        L62:
            r0 = r7
            r10 = r0
            java.lang.String r0 = "View"
            java.lang.String r1 = "Problem dumping the view:"
            r2 = r11
            int r0 = android.util.Log.w(r0, r1, r2)     // Catch: java.lang.Throwable -> L85
            r0 = r7
            if (r0 == 0) goto L5d
            r0 = r7
            r0.close()
            return
        L78:
            r7 = move-exception
            r0 = 0
            r10 = r0
        L7b:
            r0 = r10
            if (r0 == 0) goto L83
            r0 = r10
            r0.close()
        L83:
            r0 = r7
            throw r0
        L85:
            r7 = move-exception
            goto L7b
        L89:
            r10 = move-exception
            r0 = r11
            r7 = r0
            r0 = r10
            r11 = r0
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.ViewDebug.dump(android.view.View, boolean, boolean, java.io.OutputStream):void");
    }

    public static void dumpCapturedView(String str, Object obj) {
        Class<?> cls = obj.getClass();
        Log.d(str, (cls.getName() + ": ") + capturedViewExportFields(obj, cls, "") + capturedViewExportMethods(obj, cls, ""));
    }

    public static void dumpTheme(View view, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                BufferedWriter bufferedWriter3 = new BufferedWriter(new OutputStreamWriter(outputStream, "utf-8"), 32768);
                try {
                    String[] styleAttributesDump = getStyleAttributesDump(view.getContext().getResources(), view.getContext().getTheme());
                    if (styleAttributesDump != null) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= styleAttributesDump.length) {
                                break;
                            }
                            if (styleAttributesDump[i2] != null) {
                                bufferedWriter3.write(styleAttributesDump[i2] + "\n");
                                bufferedWriter3.write(styleAttributesDump[i2 + 1] + "\n");
                            }
                            i = i2 + 2;
                        }
                    }
                    bufferedWriter3.write("DONE.");
                    bufferedWriter3.newLine();
                    if (bufferedWriter3 != null) {
                        bufferedWriter3.close();
                    }
                } catch (Exception e) {
                    bufferedWriter = bufferedWriter3;
                    e = e;
                    Log.w("View", "Problem dumping View Theme:", e);
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = bufferedWriter3;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                bufferedWriter = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean dumpView(Context context, View view, BufferedWriter bufferedWriter, int i, boolean z) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            try {
                bufferedWriter.write(32);
                i2 = i3 + 1;
            } catch (IOException e) {
                Log.w("View", "Error while dumping hierarchy tree");
                return false;
            }
            Log.w("View", "Error while dumping hierarchy tree");
            return false;
        }
        String name = view.getClass().getName();
        String str = name;
        if (name.equals("android.view.ViewOverlay$OverlayViewGroup")) {
            str = "ViewOverlay";
        }
        bufferedWriter.write(str);
        bufferedWriter.write(64);
        bufferedWriter.write(Integer.toHexString(view.hashCode()));
        bufferedWriter.write(32);
        if (z) {
            dumpViewProperties(context, view, bufferedWriter);
        }
        bufferedWriter.newLine();
        return true;
    }

    private static void dumpViewHierarchy(Context context, ViewGroup viewGroup, BufferedWriter bufferedWriter, int i, boolean z, boolean z2) {
        if (dumpView(context, viewGroup, bufferedWriter, i, z2) && !z) {
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ViewGroup) {
                    dumpViewHierarchy(context, (ViewGroup) childAt, bufferedWriter, i + 1, z, z2);
                } else {
                    dumpView(context, childAt, bufferedWriter, i + 1, z2);
                }
                if (childAt.mOverlay != null) {
                    dumpViewHierarchy(context, childAt.getOverlay().mOverlayViewGroup, bufferedWriter, i + 2, z, z2);
                }
                i2 = i3 + 1;
            }
            if (viewGroup instanceof HierarchyHandler) {
                ((HierarchyHandler) viewGroup).dumpViewHierarchyWithProperties(bufferedWriter, i + 1);
            }
        }
    }

    private static void dumpViewProperties(Context context, Object obj, BufferedWriter bufferedWriter) throws IOException {
        dumpViewProperties(context, obj, bufferedWriter, "");
    }

    private static void dumpViewProperties(Context context, Object obj, BufferedWriter bufferedWriter, String str) throws IOException {
        Class<? super Object> superclass;
        if (obj == null) {
            bufferedWriter.write(str + "=4,null ");
            return;
        }
        Class<?> cls = obj.getClass();
        do {
            exportFields(context, obj, bufferedWriter, cls, str);
            exportMethods(context, obj, bufferedWriter, cls, str);
            superclass = cls.getSuperclass();
            cls = superclass;
        } while (superclass != Object.class);
    }

    private static void exportFields(Context context, Object obj, BufferedWriter bufferedWriter, Class<?> cls, String str) throws IOException {
        Class<?> type;
        ExportedProperty exportedProperty;
        String str2;
        String str3;
        Field[] exportedPropertyFields = getExportedPropertyFields(cls);
        int length = exportedPropertyFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Field field = exportedPropertyFields[i2];
            Integer num = null;
            try {
                type = field.getType();
                exportedProperty = sAnnotations.get(field);
                str2 = exportedProperty.category().length() != 0 ? exportedProperty.category() + ":" : "";
            } catch (IllegalAccessException e) {
            }
            if (type != Integer.TYPE && type != Byte.TYPE) {
                if (type == int[].class) {
                    exportUnrolledArray(context, bufferedWriter, exportedProperty, (int[]) field.get(obj), str2 + str + field.getName() + '_', "");
                } else if (type == String[].class) {
                    String[] strArr = (String[]) field.get(obj);
                    if (exportedProperty.hasAdjacentMapping() && strArr != null) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < strArr.length) {
                                if (strArr[i4] != null) {
                                    writeEntry(bufferedWriter, str2 + str, strArr[i4], "", strArr[i4 + 1] == null ? b.l : strArr[i4 + 1]);
                                }
                                i3 = i4 + 2;
                            }
                        }
                    }
                } else {
                    num = null;
                    if (!type.isPrimitive()) {
                        num = null;
                        if (exportedProperty.deepExport()) {
                            dumpViewProperties(context, field.get(obj), bufferedWriter, str + exportedProperty.prefix());
                        }
                    }
                }
                i = i2 + 1;
            } else if (!exportedProperty.resolveId() || context == null) {
                FlagToString[] flagMapping = exportedProperty.flagMapping();
                if (flagMapping.length > 0) {
                    exportUnrolledFlags(bufferedWriter, flagMapping, field.getInt(obj), str2 + str + field.getName() + '_');
                }
                IntToString[] mapping = exportedProperty.mapping();
                if (mapping.length > 0) {
                    int i5 = field.getInt(obj);
                    int length2 = mapping.length;
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        str3 = null;
                        if (i7 >= length2) {
                            break;
                        }
                        IntToString intToString = mapping[i7];
                        if (intToString.from() == i5) {
                            str3 = intToString.to();
                            break;
                        }
                        i6 = i7 + 1;
                    }
                    num = str3;
                    if (str3 == null) {
                        num = Integer.valueOf(i5);
                    }
                }
                if (exportedProperty.formatToHexString()) {
                    Object obj2 = field.get(obj);
                    if (type == Integer.TYPE) {
                        num = formatIntToHexString(((Integer) obj2).intValue());
                    } else {
                        num = obj2;
                        if (type == Byte.TYPE) {
                            num = "0x" + Byte.toHexString(((Byte) obj2).byteValue(), true);
                        }
                    }
                }
            } else {
                num = resolveId(context, field.getInt(obj));
            }
            Object obj3 = num;
            if (num == null) {
                obj3 = field.get(obj);
            }
            writeEntry(bufferedWriter, str2 + str, field.getName(), "", obj3);
            i = i2 + 1;
        }
    }

    private static void exportMethods(Context context, Object obj, BufferedWriter bufferedWriter, Class<?> cls, String str) throws IOException {
        Object callMethodOnAppropriateTheadBlocking;
        Class<?> returnType;
        ExportedProperty exportedProperty;
        String str2;
        Integer num;
        boolean z;
        Method[] exportedPropertyMethods = getExportedPropertyMethods(cls);
        int length = exportedPropertyMethods.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            Method method = exportedPropertyMethods[i2];
            try {
                callMethodOnAppropriateTheadBlocking = callMethodOnAppropriateTheadBlocking(method, obj);
                returnType = method.getReturnType();
                exportedProperty = sAnnotations.get(method);
                str2 = exportedProperty.category().length() != 0 ? exportedProperty.category() + ":" : "";
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e2) {
            } catch (TimeoutException e3) {
            }
            if (returnType != Integer.TYPE) {
                if (returnType == int[].class) {
                    exportUnrolledArray(context, bufferedWriter, exportedProperty, (int[]) callMethodOnAppropriateTheadBlocking, str2 + str + method.getName() + '_', "()");
                } else if (returnType == String[].class) {
                    String[] strArr = (String[]) callMethodOnAppropriateTheadBlocking;
                    if (exportedProperty.hasAdjacentMapping() && strArr != null) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < strArr.length) {
                                if (strArr[i4] != null) {
                                    writeEntry(bufferedWriter, str2 + str, strArr[i4], "()", strArr[i4 + 1] == null ? b.l : strArr[i4 + 1]);
                                }
                                i3 = i4 + 2;
                            }
                        }
                    }
                } else {
                    num = callMethodOnAppropriateTheadBlocking;
                    if (!returnType.isPrimitive()) {
                        num = callMethodOnAppropriateTheadBlocking;
                        if (exportedProperty.deepExport()) {
                            dumpViewProperties(context, callMethodOnAppropriateTheadBlocking, bufferedWriter, str + exportedProperty.prefix());
                        }
                    }
                }
                i = i2 + 1;
            } else if (!exportedProperty.resolveId() || context == null) {
                FlagToString[] flagMapping = exportedProperty.flagMapping();
                if (flagMapping.length > 0) {
                    exportUnrolledFlags(bufferedWriter, flagMapping, ((Integer) callMethodOnAppropriateTheadBlocking).intValue(), str2 + str + method.getName() + '_');
                }
                IntToString[] mapping = exportedProperty.mapping();
                num = callMethodOnAppropriateTheadBlocking;
                if (mapping.length > 0) {
                    int intValue = ((Integer) callMethodOnAppropriateTheadBlocking).intValue();
                    int length2 = mapping.length;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        z = false;
                        num = callMethodOnAppropriateTheadBlocking;
                        if (i6 >= length2) {
                            break;
                        }
                        IntToString intToString = mapping[i6];
                        if (intToString.from() == intValue) {
                            num = intToString.to();
                            z = true;
                            break;
                        }
                        i5 = i6 + 1;
                    }
                    if (!z) {
                        num = Integer.valueOf(intValue);
                    }
                }
            } else {
                num = resolveId(context, ((Integer) callMethodOnAppropriateTheadBlocking).intValue());
            }
            writeEntry(bufferedWriter, str2 + str, method.getName(), "()", num);
            i = i2 + 1;
        }
    }

    private static void exportUnrolledArray(Context context, BufferedWriter bufferedWriter, ExportedProperty exportedProperty, int[] iArr, String str, String str2) throws IOException {
        String valueOf;
        IntToString[] indexMapping = exportedProperty.indexMapping();
        boolean z = indexMapping.length > 0;
        IntToString[] mapping = exportedProperty.mapping();
        boolean z2 = mapping.length > 0;
        boolean z3 = exportedProperty.resolveId() && context != null;
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            int i3 = iArr[i2];
            String valueOf2 = String.valueOf(i2);
            String str3 = valueOf2;
            if (z) {
                int length2 = indexMapping.length;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    str3 = valueOf2;
                    if (i5 >= length2) {
                        break;
                    }
                    IntToString intToString = indexMapping[i5];
                    if (intToString.from() == i2) {
                        str3 = intToString.to();
                        break;
                    }
                    i4 = i5 + 1;
                }
            }
            String str4 = null;
            if (z2) {
                int length3 = mapping.length;
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    str4 = null;
                    if (i7 >= length3) {
                        break;
                    }
                    IntToString intToString2 = mapping[i7];
                    if (intToString2.from() == i3) {
                        str4 = intToString2.to();
                        break;
                    }
                    i6 = i7 + 1;
                }
            }
            if (z3) {
                valueOf = str4;
                if (str4 == null) {
                    valueOf = (String) resolveId(context, i3);
                }
            } else {
                valueOf = String.valueOf(i3);
            }
            writeEntry(bufferedWriter, str, str3, str2, valueOf);
            i = i2 + 1;
        }
    }

    private static void exportUnrolledFlags(BufferedWriter bufferedWriter, FlagToString[] flagToStringArr, int i, String str) throws IOException {
        int length = flagToStringArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            FlagToString flagToString = flagToStringArr[i3];
            boolean outputIf = flagToString.outputIf();
            int mask = i & flagToString.mask();
            boolean z = mask == flagToString.equals();
            if ((z && outputIf) || (!z && !outputIf)) {
                writeEntry(bufferedWriter, str, flagToString.name(), "", formatIntToHexString(mask));
            }
            i2 = i3 + 1;
        }
    }

    public static View findView(View view, String str) {
        if (str.indexOf(64) == -1) {
            return view.getRootView().findViewById(view.getResources().getIdentifier(str, null, null));
        }
        String[] split = str.split("@");
        String str2 = split[0];
        int parseLong = (int) Long.parseLong(split[1], 16);
        View rootView = view.getRootView();
        View view2 = null;
        if (rootView instanceof ViewGroup) {
            view2 = findView((ViewGroup) rootView, str2, parseLong);
        }
        return view2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v34, types: [android.view.View] */
    private static View findView(ViewGroup viewGroup, String str, int i) {
        ViewGroup viewGroup2;
        if (isRequestedView(viewGroup, str, i)) {
            viewGroup2 = viewGroup;
        } else {
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= childCount) {
                    return null;
                }
                View childAt = viewGroup.getChildAt(i3);
                if (childAt instanceof ViewGroup) {
                    ?? findView = findView((ViewGroup) childAt, str, i);
                    viewGroup2 = findView;
                    if (findView != 0) {
                        break;
                    }
                } else if (isRequestedView(childAt, str, i)) {
                    return childAt;
                }
                if (childAt.mOverlay != null) {
                    ?? findView2 = findView(childAt.mOverlay.mOverlayViewGroup, str, i);
                    viewGroup2 = findView2;
                    if (findView2 != 0) {
                        break;
                    }
                }
                if (childAt instanceof HierarchyHandler) {
                    View findHierarchyView = ((HierarchyHandler) childAt).findHierarchyView(str, i);
                    viewGroup2 = findHierarchyView;
                    if (findHierarchyView != 0) {
                        break;
                    }
                }
                i2 = i3 + 1;
            }
        }
        return viewGroup2;
    }

    private static String formatIntToHexString(int i) {
        return "0x" + Integer.toHexString(i).toUpperCase();
    }

    private static Field[] getExportedPropertyFields(Class<?> cls) {
        if (sFieldsForClasses == null) {
            sFieldsForClasses = new HashMap<>();
        }
        if (sAnnotations == null) {
            sAnnotations = new HashMap<>(512);
        }
        HashMap<Class<?>, Field[]> hashMap = sFieldsForClasses;
        Field[] fieldArr = hashMap.get(cls);
        if (fieldArr != null) {
            return fieldArr;
        }
        ArrayList arrayList = new ArrayList();
        cls.getDeclaredFieldsUnchecked(false, arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                Field[] fieldArr2 = (Field[]) arrayList2.toArray(new Field[arrayList2.size()]);
                hashMap.put(cls, fieldArr2);
                return fieldArr2;
            }
            Field field = (Field) arrayList.get(i2);
            try {
                field.getType();
                if (field.isAnnotationPresent(ExportedProperty.class)) {
                    field.setAccessible(true);
                    arrayList2.add(field);
                    sAnnotations.put(field, field.getAnnotation(ExportedProperty.class));
                }
            } catch (NoClassDefFoundError e) {
            }
            i = i2 + 1;
        }
    }

    private static Method[] getExportedPropertyMethods(Class<?> cls) {
        if (sMethodsForClasses == null) {
            sMethodsForClasses = new HashMap<>(100);
        }
        if (sAnnotations == null) {
            sAnnotations = new HashMap<>(512);
        }
        HashMap<Class<?>, Method[]> hashMap = sMethodsForClasses;
        Method[] methodArr = hashMap.get(cls);
        if (methodArr != null) {
            return methodArr;
        }
        ArrayList arrayList = new ArrayList();
        cls.getDeclaredMethodsUnchecked(false, arrayList);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                Method[] methodArr2 = (Method[]) arrayList2.toArray(new Method[arrayList2.size()]);
                hashMap.put(cls, methodArr2);
                return methodArr2;
            }
            Method method = (Method) arrayList.get(i2);
            try {
                method.getReturnType();
                method.getParameterTypes();
                if (method.getParameterTypes().length == 0 && method.isAnnotationPresent(ExportedProperty.class) && method.getReturnType() != Void.class) {
                    method.setAccessible(true);
                    arrayList2.add(method);
                    sAnnotations.put(method, method.getAnnotation(ExportedProperty.class));
                }
            } catch (NoClassDefFoundError e) {
            }
            i = i2 + 1;
        }
    }

    private static String[] getStyleAttributesDump(Resources resources, Resources.Theme theme) {
        String str;
        TypedValue typedValue = new TypedValue();
        int i = 0;
        int[] allAttributes = theme.getAllAttributes();
        String[] strArr = new String[allAttributes.length * 2];
        int length = allAttributes.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return strArr;
            }
            int i4 = allAttributes[i3];
            int i5 = i;
            try {
                strArr[i] = resources.getResourceName(i4);
                int i6 = i;
                if (theme.resolveAttribute(i4, typedValue, true)) {
                    int i7 = i;
                    str = typedValue.coerceToString().toString();
                } else {
                    str = b.l;
                }
                strArr[i + 1] = str;
                int i8 = i + 2;
                i = i8;
                if (typedValue.type == 1) {
                    strArr[i8 - 1] = resources.getResourceName(typedValue.resourceId);
                    i = i8;
                }
            } catch (Resources.NotFoundException e) {
                i = i5;
            }
            i2 = i3 + 1;
        }
    }

    public static long getViewInstanceCount() {
        return Debug.countInstancesOfClass(View.class);
    }

    public static long getViewRootImplCount() {
        return Debug.countInstancesOfClass(ViewRootImpl.class);
    }

    private static void invalidate(View view, String str) {
        View findView = findView(view, str);
        if (findView != null) {
            findView.postInvalidate();
        }
    }

    public static Object invokeViewMethod(final View view, final Method method, final Object[] objArr) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        view.post(new Runnable() { // from class: android.view.ViewDebug.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AtomicReference.this.set(method.invoke(view, objArr));
                } catch (InvocationTargetException e) {
                    atomicReference2.set(e.getCause());
                } catch (Exception e2) {
                    atomicReference2.set(e2);
                }
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await();
            if (atomicReference2.get() != null) {
                throw new RuntimeException((Throwable) atomicReference2.get());
            }
            return atomicReference.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isRequestedView(View view, String str, int i) {
        if (view.hashCode() == i) {
            String name = view.getClass().getName();
            return str.equals("ViewOverlay") ? name.equals("android.view.ViewOverlay$OverlayViewGroup") : str.equals(name);
        }
        return false;
    }

    public static void outputDisplayList(View view, View view2) {
        view.getViewRootImpl().outputDisplayList(view2);
    }

    private static void outputDisplayList(View view, String str) throws IOException {
        View findView = findView(view, str);
        findView.getViewRootImpl().outputDisplayList(findView);
    }

    private static Bitmap performViewCapture(final View view, final boolean z) {
        if (view != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bitmap[] bitmapArr = new Bitmap[1];
            view.post(new Runnable() { // from class: android.view.ViewDebug.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        bitmapArr[0] = view.createSnapshot(Bitmap.Config.ARGB_8888, 0, z);
                    } catch (OutOfMemoryError e) {
                        Log.w("View", "Out of memory for bitmap");
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });
            try {
                countDownLatch.await(4000L, TimeUnit.MILLISECONDS);
                return bitmapArr[0];
            } catch (InterruptedException e) {
                Log.w("View", "Could not complete the capture of the view " + view);
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return null;
    }

    private static void profile(View view, OutputStream outputStream, String str) throws IOException {
        BufferedWriter bufferedWriter;
        View findView = findView(view, str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 32768);
                try {
                    if (findView != null) {
                        profileViewAndChildren(findView, bufferedWriter);
                    } else {
                        bufferedWriter.write("-1 -1 -1");
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.write("DONE.");
                    bufferedWriter.newLine();
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Exception e) {
                    e = e;
                    bufferedWriter2 = bufferedWriter;
                    Log.w("View", "Problem profiling the view:", e);
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Throwable th) {
                    bufferedWriter2 = bufferedWriter;
                    th = th;
                    if (bufferedWriter2 != null) {
                        bufferedWriter2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
            bufferedWriter = null;
        }
    }

    public static void profileViewAndChildren(View view, BufferedWriter bufferedWriter) throws IOException {
        profileViewAndChildren(view, bufferedWriter, true);
    }

    private static void profileViewAndChildren(final View view, BufferedWriter bufferedWriter, boolean z) throws IOException {
        long j = 0;
        long profileViewOperation = (z || (view.mPrivateFlags & 2048) != 0) ? profileViewOperation(view, new ViewOperation<Void>() { // from class: android.view.ViewDebug.2
            private void forceLayout(View view2) {
                view2.forceLayout();
                if (!(view2 instanceof ViewGroup)) {
                    return;
                }
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childCount) {
                        return;
                    }
                    forceLayout(viewGroup.getChildAt(i2));
                    i = i2 + 1;
                }
            }

            @Override // android.view.ViewDebug.ViewOperation
            public void post(Void... voidArr) {
            }

            @Override // android.view.ViewDebug.ViewOperation
            public Void[] pre() {
                forceLayout(View.this);
                return null;
            }

            @Override // android.view.ViewDebug.ViewOperation
            public void run(Void... voidArr) {
                View.this.measure(View.this.mOldWidthMeasureSpec, View.this.mOldHeightMeasureSpec);
            }
        }) : 0L;
        long profileViewOperation2 = (z || (view.mPrivateFlags & 8192) != 0) ? profileViewOperation(view, new ViewOperation<Void>() { // from class: android.view.ViewDebug.3
            @Override // android.view.ViewDebug.ViewOperation
            public void post(Void... voidArr) {
            }

            @Override // android.view.ViewDebug.ViewOperation
            public Void[] pre() {
                return null;
            }

            @Override // android.view.ViewDebug.ViewOperation
            public void run(Void... voidArr) {
                View.this.layout(View.this.mLeft, View.this.mTop, View.this.mRight, View.this.mBottom);
            }
        }) : 0L;
        if (z || !view.willNotDraw() || (view.mPrivateFlags & 32) != 0) {
            j = profileViewOperation(view, new ViewOperation<Object>() { // from class: android.view.ViewDebug.4
                @Override // android.view.ViewDebug.ViewOperation
                public void post(Object... objArr) {
                    if (objArr[1] != null) {
                        ((Canvas) objArr[1]).setBitmap(null);
                    }
                    if (objArr[0] != null) {
                        ((Bitmap) objArr[0]).recycle();
                    }
                }

                @Override // android.view.ViewDebug.ViewOperation
                public Object[] pre() {
                    Canvas canvas = null;
                    DisplayMetrics displayMetrics = (View.this == null || View.this.getResources() == null) ? null : View.this.getResources().getDisplayMetrics();
                    Bitmap createBitmap = displayMetrics != null ? Bitmap.createBitmap(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.RGB_565) : null;
                    if (createBitmap != null) {
                        canvas = new Canvas(createBitmap);
                    }
                    return new Object[]{createBitmap, canvas};
                }

                @Override // android.view.ViewDebug.ViewOperation
                public void run(Object... objArr) {
                    if (objArr[1] != null) {
                        View.this.draw((Canvas) objArr[1]);
                    }
                }
            });
        }
        bufferedWriter.write(String.valueOf(profileViewOperation));
        bufferedWriter.write(32);
        bufferedWriter.write(String.valueOf(profileViewOperation2));
        bufferedWriter.write(32);
        bufferedWriter.write(String.valueOf(j));
        bufferedWriter.newLine();
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            profileViewAndChildren(viewGroup.getChildAt(i2), bufferedWriter, false);
            i = i2 + 1;
        }
    }

    private static <T> long profileViewOperation(View view, final ViewOperation<T> viewOperation) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final long[] jArr = new long[1];
        view.post(new Runnable() { // from class: android.view.ViewDebug.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Object[] pre = ViewOperation.this.pre();
                    long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
                    ViewOperation.this.run(pre);
                    jArr[0] = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
                    ViewOperation.this.post(pre);
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        try {
            if (countDownLatch.await(4000L, TimeUnit.MILLISECONDS)) {
                return jArr[0];
            }
            Log.w("View", "Could not complete the profiling of the view " + view);
            return -1L;
        } catch (InterruptedException e) {
            Log.w("View", "Could not complete the profiling of the view " + view);
            Thread.currentThread().interrupt();
            return -1L;
        }
    }

    private static void requestLayout(View view, String str) {
        final View findView = findView(view, str);
        if (findView != null) {
            view.post(new Runnable() { // from class: android.view.ViewDebug.1
                @Override // java.lang.Runnable
                public void run() {
                    View.this.requestLayout();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object resolveId(Context context, int i) {
        Resources resources = context.getResources();
        if (i >= 0) {
            try {
                return resources.getResourceTypeName(i) + '/' + resources.getResourceEntryName(i);
            } catch (Resources.NotFoundException e) {
                return "id/" + formatIntToHexString(i);
            }
        }
        return "NO_ID";
    }

    public static void setLayoutParameter(final View view, String str, int i) throws NoSuchFieldException, IllegalAccessException {
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Field field = layoutParams.getClass().getField(str);
        if (field.getType() != Integer.TYPE) {
            throw new RuntimeException("Only integer layout parameters can be set. Field " + str + " is of type " + field.getType().getSimpleName());
        }
        field.set(layoutParams, Integer.valueOf(i));
        view.post(new Runnable() { // from class: android.view.ViewDebug.9
            @Override // java.lang.Runnable
            public void run() {
                View.this.setLayoutParams(layoutParams);
            }
        });
    }

    @Deprecated
    public static void startHierarchyTracing(String str, View view) {
    }

    @Deprecated
    public static void startRecyclerTracing(String str, View view) {
    }

    @Deprecated
    public static void stopHierarchyTracing() {
    }

    @Deprecated
    public static void stopRecyclerTracing() {
    }

    @Deprecated
    public static void trace(View view, HierarchyTraceType hierarchyTraceType) {
    }

    @Deprecated
    public static void trace(View view, RecyclerTraceType recyclerTraceType, int... iArr) {
    }

    private static void writeEntry(BufferedWriter bufferedWriter, String str, String str2, String str3, Object obj) throws IOException {
        bufferedWriter.write(str);
        bufferedWriter.write(str2);
        bufferedWriter.write(str3);
        bufferedWriter.write("=");
        writeValue(bufferedWriter, obj);
        bufferedWriter.write(32);
    }

    private static void writeValue(BufferedWriter bufferedWriter, Object obj) throws IOException {
        if (obj == null) {
            bufferedWriter.write("4,null");
            return;
        }
        try {
            String replace = obj.toString().replace("\n", "\\n");
            bufferedWriter.write(String.valueOf(replace.length()));
            bufferedWriter.write(",");
            bufferedWriter.write(replace);
        } catch (Throwable th) {
            bufferedWriter.write(String.valueOf("[EXCEPTION]".length()));
            bufferedWriter.write(",");
            bufferedWriter.write("[EXCEPTION]");
            throw th;
        }
    }
}
