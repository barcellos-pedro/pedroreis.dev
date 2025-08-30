package gg.jte.generated.ondemand;
import com.pedroreis.dev.Link;
import java.util.List;
@SuppressWarnings("unchecked")
public final class JtehomeGenerated {
	public static final String JTE_NAME = "home.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,2,4,4,6,6,55,55,55,55,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,57,57,57,59,59,59,61,61,64,64,64,66,66,66,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Link> links) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Home", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <style>\n        .bio {\n            display: flex;\n            flex-direction: column;\n            align-items: center;\n            justify-content:center;\n            height: 100vh;\n            \n            img {\n                width:112px;\n                height:112px;\n                border-radius: 50%;\n            }\n            \n            h3 {\n                margin-top: 0px;\n                text-align: center;\n            \n                p {\n                    margin-bottom: 0.5em;\n                    font-weight: bold;\n                    margin-top: 2em;\n                }\n                p:nth-of-type(2) {\n                    margin-top: 0;\n                    font-weight: 300;\n                }\n            }\n\n            .links {\n                display:flex;\n                gap:3em;\n                align-items:center;\n            }\n        }\n    </style>\n\n    <div class=\"bio\">\n        <img src=\"https://avatars.githubusercontent.com/u/33139500?v=4\" alt=\"Pedro's profile image\">\n\n        <h3>\n            <p>Pedro Barcellos dos Reis</p>\n            <p>Software Engineer</p>\n        </h3>\n\n        <a href=\"/projects\">Check out my Portfolio Overview &rarr;</a>\n\n        <section class=\"links\">\n            ");
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
		jteOutput.writeContent("\n\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Link> links = (List<Link>)params.get("links");
		render(jteOutput, jteHtmlInterceptor, links);
	}
}
