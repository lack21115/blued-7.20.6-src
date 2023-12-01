package android.ddm;

import android.opengl.GLUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.view.WindowManagerGlobal;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import org.apache.harmony.dalvik.ddmc.Chunk;
import org.apache.harmony.dalvik.ddmc.ChunkHandler;
import org.apache.harmony.dalvik.ddmc.DdmServer;

/* loaded from: source-9557208-dex2jar.jar:android/ddm/DdmHandleViewDebug.class */
public class DdmHandleViewDebug extends ChunkHandler {
    private static final int ERR_EXCEPTION = -3;
    private static final int ERR_INVALID_OP = -1;
    private static final int ERR_INVALID_PARAM = -2;
    private static final String TAG = "DdmViewDebug";
    private static final int VUOP_CAPTURE_VIEW = 1;
    private static final int VUOP_DUMP_DISPLAYLIST = 2;
    private static final int VUOP_INVOKE_VIEW_METHOD = 4;
    private static final int VUOP_PROFILE_VIEW = 3;
    private static final int VUOP_SET_LAYOUT_PARAMETER = 5;
    private static final int VURT_CAPTURE_LAYERS = 2;
    private static final int VURT_DUMP_HIERARCHY = 1;
    private static final int VURT_DUMP_THEME = 3;
    public static final int CHUNK_VUGL = type("VUGL");
    private static final int CHUNK_VULW = type("VULW");
    private static final int CHUNK_VURT = type("VURT");
    private static final int CHUNK_VUOP = type("VUOP");
    private static final DdmHandleViewDebug sInstance = new DdmHandleViewDebug();

    private DdmHandleViewDebug() {
    }

    private Chunk captureLayers(View view) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            try {
                ViewDebug.captureLayers(view, dataOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return new Chunk(CHUNK_VURT, byteArray, 0, byteArray.length);
            } catch (IOException e) {
                Chunk createFailChunk = createFailChunk(1, "Unexpected error while obtaining view hierarchy: " + e.getMessage());
                try {
                    dataOutputStream.close();
                    return createFailChunk;
                } catch (IOException e2) {
                    return createFailChunk;
                }
            }
        } finally {
            try {
                dataOutputStream.close();
            } catch (IOException e3) {
            }
        }
    }

    private Chunk captureView(View view, View view2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            ViewDebug.capture(view, byteArrayOutputStream, view2);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return new Chunk(CHUNK_VUOP, byteArray, 0, byteArray.length);
        } catch (IOException e) {
            return createFailChunk(1, "Unexpected error while capturing view: " + e.getMessage());
        }
    }

    private Chunk dumpDisplayLists(final View view, final View view2) {
        view.post(new Runnable() { // from class: android.ddm.DdmHandleViewDebug.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDebug.outputDisplayList(view, view2);
            }
        });
        return null;
    }

    private Chunk dumpHierarchy(View view, ByteBuffer byteBuffer) {
        boolean z = byteBuffer.getInt() > 0;
        boolean z2 = byteBuffer.getInt() > 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            ViewDebug.dump(view, z, z2, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return new Chunk(CHUNK_VURT, byteArray, 0, byteArray.length);
        } catch (IOException e) {
            return createFailChunk(1, "Unexpected error while obtaining view hierarchy: " + e.getMessage());
        }
    }

    private Chunk dumpTheme(View view) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            ViewDebug.dumpTheme(view, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return new Chunk(CHUNK_VURT, byteArray, 0, byteArray.length);
        } catch (IOException e) {
            return createFailChunk(1, "Unexpected error while dumping the theme: " + e.getMessage());
        }
    }

    private View getRootView(ByteBuffer byteBuffer) {
        try {
            return WindowManagerGlobal.getInstance().getRootView(getString(byteBuffer, byteBuffer.getInt()));
        } catch (BufferUnderflowException e) {
            return null;
        }
    }

    private View getTargetView(View view, ByteBuffer byteBuffer) {
        try {
            return ViewDebug.findView(view, getString(byteBuffer, byteBuffer.getInt()));
        } catch (BufferUnderflowException e) {
            return null;
        }
    }

    private Chunk handleOpenGlTrace(Chunk chunk) {
        GLUtils.setTracingLevel(wrapChunk(chunk).getInt());
        return null;
    }

    private Chunk invokeViewMethod(View view, View view2, ByteBuffer byteBuffer) {
        Class<?>[] clsArr;
        Object[] objArr;
        String string = getString(byteBuffer, byteBuffer.getInt());
        if (byteBuffer.hasRemaining()) {
            int i = byteBuffer.getInt();
            Class<?>[] clsArr2 = new Class[i];
            Object[] objArr2 = new Object[i];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                clsArr = clsArr2;
                objArr = objArr2;
                if (i3 < i) {
                    char c2 = byteBuffer.getChar();
                    switch (c2) {
                        case 'B':
                            clsArr2[i3] = Byte.TYPE;
                            objArr2[i3] = Byte.valueOf(byteBuffer.get());
                            break;
                        case 'C':
                            clsArr2[i3] = Character.TYPE;
                            objArr2[i3] = Character.valueOf(byteBuffer.getChar());
                            break;
                        case 'D':
                            clsArr2[i3] = Double.TYPE;
                            objArr2[i3] = Double.valueOf(byteBuffer.getDouble());
                            break;
                        case 'F':
                            clsArr2[i3] = Float.TYPE;
                            objArr2[i3] = Float.valueOf(byteBuffer.getFloat());
                            break;
                        case 'I':
                            clsArr2[i3] = Integer.TYPE;
                            objArr2[i3] = Integer.valueOf(byteBuffer.getInt());
                            break;
                        case 'J':
                            clsArr2[i3] = Long.TYPE;
                            objArr2[i3] = Long.valueOf(byteBuffer.getLong());
                            break;
                        case 'S':
                            clsArr2[i3] = Short.TYPE;
                            objArr2[i3] = Short.valueOf(byteBuffer.getShort());
                            break;
                        case 'Z':
                            clsArr2[i3] = Boolean.TYPE;
                            objArr2[i3] = Boolean.valueOf(byteBuffer.get() != 0);
                            break;
                        default:
                            Log.e(TAG, "arg " + i3 + ", unrecognized type: " + c2);
                            return createFailChunk(-2, "Unsupported parameter type (" + c2 + ") to invoke view method.");
                    }
                    i2 = i3 + 1;
                }
            }
        } else {
            clsArr = new Class[0];
            objArr = new Object[0];
        }
        try {
            try {
                ViewDebug.invokeViewMethod(view2, view2.getClass().getMethod(string, clsArr), objArr);
                return null;
            } catch (Exception e) {
                Log.e(TAG, "Exception while invoking method: " + e.getCause().getMessage());
                String message = e.getCause().getMessage();
                String str = message;
                if (message == null) {
                    str = e.getCause().toString();
                }
                return createFailChunk(-3, str);
            }
        } catch (NoSuchMethodException e2) {
            Log.e(TAG, "No such method: " + e2.getMessage());
            return createFailChunk(-2, "No such method: " + e2.getMessage());
        }
    }

    private Chunk listWindows() {
        String[] viewRootNames = WindowManagerGlobal.getInstance().getViewRootNames();
        int i = 4;
        int length = viewRootNames.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                break;
            }
            i = i + 4 + (viewRootNames[i3].length() * 2);
            i2 = i3 + 1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ChunkHandler.CHUNK_ORDER);
        allocate.putInt(viewRootNames.length);
        int length2 = viewRootNames.length;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= length2) {
                return new Chunk(CHUNK_VULW, allocate);
            }
            String str = viewRootNames[i5];
            allocate.putInt(str.length());
            putString(allocate, str);
            i4 = i5 + 1;
        }
    }

    private Chunk profileView(View view, View view2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(32768);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream), 32768);
        try {
            try {
                ViewDebug.profileViewAndChildren(view2, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return new Chunk(CHUNK_VUOP, byteArray, 0, byteArray.length);
            } catch (IOException e) {
                Chunk createFailChunk = createFailChunk(1, "Unexpected error while profiling view: " + e.getMessage());
                try {
                    bufferedWriter.close();
                    return createFailChunk;
                } catch (IOException e2) {
                    return createFailChunk;
                }
            }
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e3) {
            }
        }
    }

    public static void register() {
        DdmServer.registerHandler(CHUNK_VUGL, sInstance);
        DdmServer.registerHandler(CHUNK_VULW, sInstance);
        DdmServer.registerHandler(CHUNK_VURT, sInstance);
        DdmServer.registerHandler(CHUNK_VUOP, sInstance);
    }

    private Chunk setLayoutParameter(View view, View view2, ByteBuffer byteBuffer) {
        String string = getString(byteBuffer, byteBuffer.getInt());
        try {
            ViewDebug.setLayoutParameter(view2, string, byteBuffer.getInt());
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Exception setting layout parameter: " + e);
            return createFailChunk(-3, "Error accessing field " + string + ":" + e.getMessage());
        }
    }

    public void connected() {
    }

    public void disconnected() {
    }

    public Chunk handleChunk(Chunk chunk) {
        int i = chunk.type;
        if (i == CHUNK_VUGL) {
            return handleOpenGlTrace(chunk);
        }
        if (i == CHUNK_VULW) {
            return listWindows();
        }
        ByteBuffer wrapChunk = wrapChunk(chunk);
        int i2 = wrapChunk.getInt();
        View rootView = getRootView(wrapChunk);
        if (rootView == null) {
            return createFailChunk(-2, "Invalid View Root");
        }
        if (i == CHUNK_VURT) {
            return i2 == 1 ? dumpHierarchy(rootView, wrapChunk) : i2 == 2 ? captureLayers(rootView) : i2 == 3 ? dumpTheme(rootView) : createFailChunk(-1, "Unknown view root operation: " + i2);
        }
        View targetView = getTargetView(rootView, wrapChunk);
        if (targetView == null) {
            return createFailChunk(-2, "Invalid target view");
        }
        if (i == CHUNK_VUOP) {
            switch (i2) {
                case 1:
                    return captureView(rootView, targetView);
                case 2:
                    return dumpDisplayLists(rootView, targetView);
                case 3:
                    return profileView(rootView, targetView);
                case 4:
                    return invokeViewMethod(rootView, targetView, wrapChunk);
                case 5:
                    return setLayoutParameter(rootView, targetView, wrapChunk);
                default:
                    return createFailChunk(-1, "Unknown view operation: " + i2);
            }
        }
        throw new RuntimeException("Unknown packet " + ChunkHandler.name(i));
    }
}
