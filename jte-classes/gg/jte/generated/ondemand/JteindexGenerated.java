package gg.jte.generated.ondemand;
import com.pedroreis.dev.model.Link;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,5,5,7,7,19,19,19,19,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,21,21,21,23,23,23,25,25,28,28,28,29,29,29,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Link> links) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Home", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <div class=\"bio\">\n        <img src=\"https://avatars.githubusercontent.com/u/33139500?v=4\" alt=\"Pedro's profile image\">\n\n        <h3>\n            <p>Pedro Barcellos dos Reis</p>\n            <p>Software Engineer</p>\n        </h3>\n\n        <a href=\"/projects\">Check out my Portfolio Overview &rarr;</a>\n\n        <section class=\"links\">\n            ");
				boolean __jte_for_loop_entered_1 = false;
				for (var link : links) {
					__jte_for_loop_entered_1 = true;
					jteOutput.writeContent("\n                <a");
					var __jte_html_attribute_0 = link.url();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(__jte_html_attribute_0);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					var __jte_html_attribute_1 = link.title();
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
						jteOutput.writeContent(" title=\"");
						jteOutput.setContext("a", "title");
						jteOutput.writeUserContent(__jte_html_attribute_1);
						jteOutput.setContext("a", null);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" target=\"_blank\">\n                    ");
					jteOutput.setContext("a", null);
					jteOutput.writeUserContent(link.title());
					jteOutput.writeContent("\n                </a>\n            ");
				}
				if (!__jte_for_loop_entered_1) {
					jteOutput.writeContent("\n                <p>Links are under maintenance</p>\n            ");
				}
				jteOutput.writeContent("\n        </section>\n    </div>\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Link> links = (List<Link>)params.get("links");
		render(jteOutput, jteHtmlInterceptor, links);
	}
}
