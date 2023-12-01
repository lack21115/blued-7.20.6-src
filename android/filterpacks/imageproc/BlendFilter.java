package android.filterpacks.imageproc;

import android.filterfw.core.FilterContext;
import android.filterfw.core.Program;
import android.filterfw.core.ShaderProgram;

/* loaded from: source-9557208-dex2jar.jar:android/filterpacks/imageproc/BlendFilter.class */
public class BlendFilter extends ImageCombineFilter {
    private final String mBlendShader;

    public BlendFilter(String str) {
        super(str, new String[]{"left", "right"}, "blended", "blend");
        this.mBlendShader = "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform float blend;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 colorL = texture2D(tex_sampler_0, v_texcoord);\n  vec4 colorR = texture2D(tex_sampler_1, v_texcoord);\n  float weight = colorR.a * blend;\n  gl_FragColor = mix(colorL, colorR, weight);\n}\n";
    }

    @Override // android.filterpacks.imageproc.ImageCombineFilter
    protected Program getNativeProgram(FilterContext filterContext) {
        throw new RuntimeException("TODO: Write native implementation for Blend!");
    }

    @Override // android.filterpacks.imageproc.ImageCombineFilter
    protected Program getShaderProgram(FilterContext filterContext) {
        return new ShaderProgram(filterContext, "precision mediump float;\nuniform sampler2D tex_sampler_0;\nuniform sampler2D tex_sampler_1;\nuniform float blend;\nvarying vec2 v_texcoord;\nvoid main() {\n  vec4 colorL = texture2D(tex_sampler_0, v_texcoord);\n  vec4 colorR = texture2D(tex_sampler_1, v_texcoord);\n  float weight = colorR.a * blend;\n  gl_FragColor = mix(colorL, colorR, weight);\n}\n");
    }
}
