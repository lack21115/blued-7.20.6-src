package com.airbnb.lottie.parser;

import android.util.JsonReader;
import com.airbnb.lottie.model.DocumentData;
import com.amap.api.col.p0003sl.iu;
import java.io.IOException;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/parser/DocumentDataParser.class */
public class DocumentDataParser implements ValueParser<DocumentData> {
    public static final DocumentDataParser a = new DocumentDataParser();

    private DocumentDataParser() {
    }

    @Override // com.airbnb.lottie.parser.ValueParser
    /* renamed from: a */
    public DocumentData b(JsonReader jsonReader, float f) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = true;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            boolean z2 = true;
            int hashCode = nextName.hashCode();
            if (hashCode != 102) {
                if (hashCode != 106) {
                    if (hashCode != 3261) {
                        if (hashCode != 3452) {
                            if (hashCode != 3463) {
                                if (hashCode != 3543) {
                                    if (hashCode != 3664) {
                                        if (hashCode != 3684) {
                                            if (hashCode != 3710) {
                                                if (hashCode != 115) {
                                                    if (hashCode == 116 && nextName.equals("t")) {
                                                        z2 = false;
                                                    }
                                                } else if (nextName.equals("s")) {
                                                    z2 = true;
                                                }
                                            } else if (nextName.equals("tr")) {
                                                z2 = true;
                                            }
                                        } else if (nextName.equals("sw")) {
                                            z2 = true;
                                        }
                                    } else if (nextName.equals("sc")) {
                                        z2 = true;
                                    }
                                } else if (nextName.equals("of")) {
                                    z2 = true;
                                }
                            } else if (nextName.equals("ls")) {
                                z2 = true;
                            }
                        } else if (nextName.equals("lh")) {
                            z2 = true;
                        }
                    } else if (nextName.equals("fc")) {
                        z2 = true;
                    }
                } else if (nextName.equals(iu.j)) {
                    z2 = true;
                }
            } else if (nextName.equals(iu.i)) {
                z2 = true;
            }
            switch (z2) {
                case false:
                    str = jsonReader.nextString();
                    break;
                case true:
                    str2 = jsonReader.nextString();
                    break;
                case true:
                    d = jsonReader.nextDouble();
                    break;
                case true:
                    int nextInt = jsonReader.nextInt();
                    if (nextInt <= DocumentData.Justification.CENTER.ordinal() && nextInt >= 0) {
                        justification = DocumentData.Justification.values()[nextInt];
                        break;
                    } else {
                        justification = DocumentData.Justification.CENTER;
                        break;
                    }
                    break;
                case true:
                    i = jsonReader.nextInt();
                    break;
                case true:
                    d2 = jsonReader.nextDouble();
                    break;
                case true:
                    d3 = jsonReader.nextDouble();
                    break;
                case true:
                    i2 = JsonUtils.a(jsonReader);
                    break;
                case true:
                    i3 = JsonUtils.a(jsonReader);
                    break;
                case true:
                    d4 = jsonReader.nextDouble();
                    break;
                case true:
                    z = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new DocumentData(str, str2, d, justification, i, d2, d3, i2, i3, d4, z);
    }
}
