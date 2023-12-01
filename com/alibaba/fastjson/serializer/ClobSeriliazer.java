package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.sql.Clob;
import java.sql.SQLException;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/fastjson/serializer/ClobSeriliazer.class */
public class ClobSeriliazer implements ObjectSerializer {
    public static final ClobSeriliazer instance = new ClobSeriliazer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        try {
            if (obj == null) {
                jSONSerializer.writeNull();
                return;
            }
            Reader characterStream = ((Clob) obj).getCharacterStream();
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            while (true) {
                int read = characterStream.read(cArr);
                if (read == -1) {
                    characterStream.close();
                    jSONSerializer.write(stringWriter.toString());
                    return;
                }
                stringWriter.write(cArr, 0, read);
            }
        } catch (SQLException e) {
            throw new IOException("write clob error", e);
        }
    }
}
