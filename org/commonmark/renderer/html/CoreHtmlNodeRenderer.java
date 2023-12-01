package org.commonmark.renderer.html;

import com.cdo.oaps.ad.OapsKey;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Block;
import org.commonmark.node.BlockQuote;
import org.commonmark.node.BulletList;
import org.commonmark.node.Code;
import org.commonmark.node.Document;
import org.commonmark.node.Emphasis;
import org.commonmark.node.FencedCodeBlock;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Heading;
import org.commonmark.node.HtmlBlock;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Image;
import org.commonmark.node.IndentedCodeBlock;
import org.commonmark.node.Link;
import org.commonmark.node.ListBlock;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.OrderedList;
import org.commonmark.node.Paragraph;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.StrongEmphasis;
import org.commonmark.node.Text;
import org.commonmark.node.ThematicBreak;
import org.commonmark.renderer.NodeRenderer;

/* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/CoreHtmlNodeRenderer.class */
public class CoreHtmlNodeRenderer extends AbstractVisitor implements NodeRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected final HtmlNodeRendererContext f44074a;
    private final HtmlWriter b;

    /* loaded from: source-3503164-dex2jar.jar:org/commonmark/renderer/html/CoreHtmlNodeRenderer$AltTextVisitor.class */
    static class AltTextVisitor extends AbstractVisitor {

        /* renamed from: a  reason: collision with root package name */
        private final StringBuilder f44075a;

        private AltTextVisitor() {
            this.f44075a = new StringBuilder();
        }

        String a() {
            return this.f44075a.toString();
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void visit(HardLineBreak hardLineBreak) {
            this.f44075a.append('\n');
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void visit(SoftLineBreak softLineBreak) {
            this.f44075a.append('\n');
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void visit(Text text) {
            this.f44075a.append(text.a());
        }
    }

    private Map<String, String> a(Node node, String str) {
        return a(node, str, Collections.emptyMap());
    }

    private Map<String, String> a(Node node, String str, Map<String, String> map) {
        return this.f44074a.a(node, str, map);
    }

    private void a(String str, Node node, Map<String, String> map) {
        this.b.a();
        this.b.a("pre", a(node, "pre"));
        this.b.a("code", a(node, "code", map));
        this.b.b(str);
        this.b.c("/code");
        this.b.c("/pre");
        this.b.a();
    }

    private void a(ListBlock listBlock, String str, Map<String, String> map) {
        this.b.a();
        this.b.a(str, map);
        this.b.a();
        a(listBlock);
        this.b.a();
        HtmlWriter htmlWriter = this.b;
        htmlWriter.c('/' + str);
        this.b.a();
    }

    private boolean a(Paragraph paragraph) {
        Node b;
        Block a2 = paragraph.b();
        if (a2 == null || (b = a2.b()) == null || !(b instanceof ListBlock)) {
            return false;
        }
        return ((ListBlock) b).e();
    }

    @Override // org.commonmark.node.AbstractVisitor
    public void a(Node node) {
        Node j = node.j();
        while (true) {
            Node node2 = j;
            if (node2 == null) {
                return;
            }
            Node h = node2.h();
            this.f44074a.a(node2);
            j = h;
        }
    }

    @Override // org.commonmark.renderer.NodeRenderer
    public void b(Node node) {
        node.a(this);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(BlockQuote blockQuote) {
        this.b.a();
        this.b.a("blockquote", a(blockQuote, "blockquote"));
        this.b.a();
        a(blockQuote);
        this.b.a();
        this.b.c("/blockquote");
        this.b.a();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(BulletList bulletList) {
        a((ListBlock) bulletList, "ul", a(bulletList, "ul"));
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Code code) {
        this.b.a("code", a(code, "code"));
        this.b.b(code.a());
        this.b.c("/code");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Document document) {
        a(document);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Emphasis emphasis) {
        this.b.a("em", a(emphasis, "em"));
        a(emphasis);
        this.b.c("/em");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(FencedCodeBlock fencedCodeBlock) {
        String g = fencedCodeBlock.g();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String f = fencedCodeBlock.f();
        if (f != null && !f.isEmpty()) {
            int indexOf = f.indexOf(" ");
            if (indexOf != -1) {
                f = f.substring(0, indexOf);
            }
            linkedHashMap.put("class", "language-" + f);
        }
        a(g, fencedCodeBlock, linkedHashMap);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(HardLineBreak hardLineBreak) {
        this.b.a("br", a(hardLineBreak, "br"), true);
        this.b.a();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Heading heading) {
        String str = "h" + heading.c();
        this.b.a();
        this.b.a(str, a(heading, str));
        a(heading);
        this.b.c('/' + str);
        this.b.a();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(HtmlBlock htmlBlock) {
        this.b.a();
        if (this.f44074a.b()) {
            this.b.a("p", a(htmlBlock, "p"));
            this.b.b(htmlBlock.c());
            this.b.c("/p");
        } else {
            this.b.a(htmlBlock.c());
        }
        this.b.a();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(HtmlInline htmlInline) {
        if (this.f44074a.b()) {
            this.b.b(htmlInline.a());
        } else {
            this.b.a(htmlInline.a());
        }
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Image image) {
        String a2 = this.f44074a.a(image.a());
        AltTextVisitor altTextVisitor = new AltTextVisitor();
        image.a(altTextVisitor);
        String a3 = altTextVisitor.a();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(OapsKey.KEY_SRC, a2);
        linkedHashMap.put("alt", a3);
        if (image.c() != null) {
            linkedHashMap.put("title", image.c());
        }
        this.b.a("img", a(image, "img", linkedHashMap), true);
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(IndentedCodeBlock indentedCodeBlock) {
        a(indentedCodeBlock.c(), indentedCodeBlock, Collections.emptyMap());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Link link) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("href", this.f44074a.a(link.a()));
        if (link.c() != null) {
            linkedHashMap.put("title", link.c());
        }
        this.b.a("a", a(link, "a", linkedHashMap));
        a(link);
        this.b.c("/a");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(ListItem listItem) {
        this.b.a(AppIconSetting.LARGE_ICON_URL, a(listItem, AppIconSetting.LARGE_ICON_URL));
        a(listItem);
        this.b.c("/li");
        this.b.a();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(OrderedList orderedList) {
        int c2 = orderedList.c();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (c2 != 1) {
            linkedHashMap.put("start", String.valueOf(c2));
        }
        a((ListBlock) orderedList, "ol", a((Node) orderedList, "ol", (Map<String, String>) linkedHashMap));
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Paragraph paragraph) {
        boolean a2 = a(paragraph);
        if (!a2) {
            this.b.a();
            this.b.a("p", a(paragraph, "p"));
        }
        a((Node) paragraph);
        if (a2) {
            return;
        }
        this.b.c("/p");
        this.b.a();
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(SoftLineBreak softLineBreak) {
        this.b.a(this.f44074a.a());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(StrongEmphasis strongEmphasis) {
        this.b.a("strong", a(strongEmphasis, "strong"));
        a(strongEmphasis);
        this.b.c("/strong");
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(Text text) {
        this.b.b(text.a());
    }

    @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
    public void visit(ThematicBreak thematicBreak) {
        this.b.a();
        this.b.a("hr", a(thematicBreak, "hr"), true);
        this.b.a();
    }
}
