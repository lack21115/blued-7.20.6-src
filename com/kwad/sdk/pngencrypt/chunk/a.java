package com.kwad.sdk.pngencrypt.chunk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/a.class */
public final class a implements com.kwad.sdk.pngencrypt.g {
    boolean awy;

    public a() {
        this(true);
    }

    private a(boolean z) {
        this.awy = true;
    }

    private static PngChunk a(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("IDAT")) {
            return new g(kVar);
        }
        if (str.equals("IHDR")) {
            return new i(kVar);
        }
        if (str.equals("PLTE")) {
            return new m(kVar);
        }
        if (str.equals("IEND")) {
            return new h(kVar);
        }
        if (str.equals("tEXt")) {
            return new q(kVar);
        }
        if (str.equals("iTXt")) {
            return new j(kVar);
        }
        if (str.equals("zTXt")) {
            return new v(kVar);
        }
        if (str.equals("tIME")) {
            return new r(kVar);
        }
        if (str.equals("tRNS")) {
            return new s(kVar);
        }
        if (str.equals("sPLT")) {
            return new n(kVar);
        }
        return null;
    }

    private static PngChunk b(String str, com.kwad.sdk.pngencrypt.k kVar) {
        return new u(str, kVar);
    }

    private static PngChunk c(String str, com.kwad.sdk.pngencrypt.k kVar) {
        if (str.equals("oFFs")) {
            return new l(kVar);
        }
        if (str.equals("sTER")) {
            return new o(kVar);
        }
        return null;
    }

    @Override // com.kwad.sdk.pngencrypt.g
    public final PngChunk a(d dVar, com.kwad.sdk.pngencrypt.k kVar) {
        PngChunk a2 = a(dVar.awG, kVar);
        PngChunk pngChunk = a2;
        if (a2 == null) {
            pngChunk = c(dVar.awG, kVar);
        }
        PngChunk pngChunk2 = pngChunk;
        if (pngChunk == null) {
            pngChunk2 = b(dVar.awG, kVar);
        }
        pngChunk2.b(dVar);
        if (this.awy && dVar.data != null) {
            pngChunk2.a(dVar);
        }
        return pngChunk2;
    }
}
