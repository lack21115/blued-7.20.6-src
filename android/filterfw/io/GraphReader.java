package android.filterfw.io;

import android.content.Context;
import android.filterfw.core.FilterGraph;
import android.filterfw.core.KeyValueMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

/* loaded from: source-9557208-dex2jar.jar:android/filterfw/io/GraphReader.class */
public abstract class GraphReader {
    protected KeyValueMap mReferences = new KeyValueMap();

    public void addReference(String str, Object obj) {
        this.mReferences.put(str, obj);
    }

    public void addReferencesByKeysAndValues(Object... objArr) {
        this.mReferences.setKeyValues(objArr);
    }

    public void addReferencesByMap(KeyValueMap keyValueMap) {
        this.mReferences.putAll(keyValueMap);
    }

    public FilterGraph readGraphResource(Context context, int i) throws GraphIOException {
        InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().openRawResource(i));
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        while (true) {
            try {
                int read = inputStreamReader.read(cArr, 0, 1024);
                if (read <= 0) {
                    return readGraphString(stringWriter.toString());
                }
                stringWriter.write(cArr, 0, read);
            } catch (IOException e) {
                throw new RuntimeException("Could not read specified resource file!");
            }
        }
    }

    public abstract FilterGraph readGraphString(String str) throws GraphIOException;

    public abstract KeyValueMap readKeyValueAssignments(String str) throws GraphIOException;
}
