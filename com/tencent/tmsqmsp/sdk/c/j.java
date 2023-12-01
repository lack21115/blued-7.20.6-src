package com.tencent.tmsqmsp.sdk.c;

import android.os.Bundle;
import android.util.Pair;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/j.class */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[][] f39718c = {new byte[]{20, 67, -74, 67, 2, 50, 117, -18}, new byte[]{51, 117, -95, 83, 39, 52, 121}, new byte[]{9, 121, -79, 101, 32, 47, 101, -28}, new byte[]{44, 116}, new byte[]{49, 105, -93, 69}, new byte[]{35, 124, -78, 71, 61}, new byte[]{53, 113, -89, 72}, new byte[]{43, 113, -66, 69}, new byte[]{51, 113, -65, 85, 43}, new byte[]{51, 117, -95}, new byte[]{20, 125, -96, 80, 96, 63, 118, -23}};

    /* renamed from: a  reason: collision with root package name */
    private List<a> f39719a;
    private int b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/c/j$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f39720a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f39721c;
        public String d;
        public String e;
    }

    public j() {
        this.b = 1;
        Pair<Integer, List<a>> a2 = a(c(), 1);
        if (a2 != null) {
            this.b = a2.first.intValue();
            this.f39719a = a2.second;
        }
        if (this.f39719a == null) {
            this.f39719a = new LinkedList();
        }
    }

    private int a(Element element) {
        try {
            NamedNodeMap attributes = element.getAttributes();
            if (attributes == null) {
                return 0;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= attributes.getLength()) {
                    return 0;
                }
                Node item = attributes.item(i2);
                String nodeName = item.getNodeName();
                if (nodeName != null && nodeName.equalsIgnoreCase(b(1))) {
                    return Integer.parseInt(item.getNodeValue());
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private Pair<Integer, List<a>> a(String str, int i) {
        byte[] a2 = new m().a(str, null, 1);
        if (a2 != null) {
            return a(a2, i);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.ByteArrayInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Integer, java.util.List<com.tencent.tmsqmsp.sdk.c.j.a>> a(byte[] r6, int r7) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.c.j.a(byte[], int):android.util.Pair");
    }

    private a a(Node node) {
        int i;
        int i2;
        try {
            NamedNodeMap attributes = node.getAttributes();
            if (attributes == null) {
                return null;
            }
            a aVar = new a();
            int length = attributes.getLength();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                i = i4;
                if (i3 >= length) {
                    break;
                }
                Node item = attributes.item(i3);
                if (item.getNodeType() != 2) {
                    i2 = i;
                } else {
                    String nodeName = item.getNodeName();
                    String nodeValue = item.getNodeValue();
                    i2 = i;
                    if (nodeName != null) {
                        if (nodeValue == null) {
                            i2 = i;
                        } else {
                            if (nodeName.equalsIgnoreCase(b(3))) {
                                aVar.f39720a = Integer.parseInt(nodeValue);
                            } else if (nodeName.equalsIgnoreCase(b(4))) {
                                aVar.b = Integer.parseInt(nodeValue);
                            } else if (nodeName.equalsIgnoreCase(b(5))) {
                                aVar.f39721c = Integer.parseInt(nodeValue);
                            } else if (nodeName.equalsIgnoreCase(b(6))) {
                                aVar.e = nodeValue;
                            } else {
                                i2 = i;
                                if (nodeName.equalsIgnoreCase(b(9))) {
                                    aVar.d = nodeValue;
                                }
                            }
                            i2 = i + 1;
                        }
                    }
                }
                i3++;
                i4 = i2;
            }
            if (i != 5) {
                return null;
            }
            b(node);
            return aVar;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(String str, int i, List<a> list) {
        byte[] a2 = a(i, list);
        if (a2 == null) {
            return false;
        }
        return new m().a(str, a2, null, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] a(int r6, java.util.List<com.tencent.tmsqmsp.sdk.c.j.a> r7) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.sdk.c.j.a(int, java.util.List):byte[]");
    }

    private Bundle b(Node node) {
        NamedNodeMap attributes;
        Node namedItem;
        String nodeValue;
        Node namedItem2;
        String nodeValue2;
        try {
            Bundle bundle = new Bundle();
            NodeList childNodes = node.getChildNodes();
            int length = childNodes.getLength();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return bundle;
                }
                Node item = childNodes.item(i2);
                if (item.getNodeType() == 1 && (attributes = item.getAttributes()) != null && (namedItem = attributes.getNamedItem(b(7))) != null && namedItem.getNodeType() == 2 && (nodeValue = namedItem.getNodeValue()) != null && (namedItem2 = attributes.getNamedItem(b(8))) != null && namedItem2.getNodeType() == 2 && (nodeValue2 = namedItem2.getNodeValue()) != null) {
                    bundle.putString(nodeValue, nodeValue2);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String b(int i) {
        return com.tencent.tmsqmsp.sdk.f.h.a(f39718c[i]);
    }

    private String c() {
        return com.tencent.tmsqmsp.sdk.a.b.a() + File.separator + b(10);
    }

    private boolean c(int i) {
        return d(i) != null;
    }

    private a d(int i) {
        for (a aVar : this.f39719a) {
            if (aVar.f39720a == i) {
                return aVar;
            }
        }
        return null;
    }

    public a a(int i) {
        return d(i);
    }

    public void a(int i, boolean z) {
        a d = d(i);
        if (d == null) {
            return;
        }
        this.f39719a.remove(d);
        if (z) {
            a(c(), this.b, this.f39719a);
        }
    }

    public boolean a() {
        return a(c(), this.b, this.f39719a);
    }

    public boolean a(a aVar, boolean z) {
        if (c(aVar.f39720a)) {
            return false;
        }
        this.f39719a.add(aVar);
        if (z) {
            return a();
        }
        return true;
    }

    public List<a> b() {
        return this.f39719a;
    }
}
