package gg.jte.generated.ondemand.repos;
import static com.pedroreis.dev.utils.Template.join;
import static com.pedroreis.dev.utils.Template.date;
import com.pedroreis.dev.model.Repo;
@SuppressWarnings("unchecked")
public final class Jte_repoGenerated {
	public static final String JTE_NAME = "repos/_repo.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,5,5,5,5,8,8,8,8,8,8,8,8,8,8,9,9,9,13,13,13,13,13,13,13,13,13,14,14,14,19,19,21,21,21,23,23,25,25,25,26,26,26,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Repo repo) {
		jteOutput.writeContent("\n<div class=\"repo-header\">\n    <a");
		var __jte_html_attribute_0 = repo.htmlUrl();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(" target=\"_blank\">\n        <p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(repo.name());
		jteOutput.writeContent("</p>\n    </a>\n\n    <small>\n        <time");
		var __jte_html_attribute_1 = date(repo.createdAt());
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" datetime=\"");
			jteOutput.setContext("time", "datetime");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("time", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">\n            ");
		jteOutput.setContext("time", null);
		jteOutput.writeUserContent(date(repo.createdAt()));
		jteOutput.writeContent("\n        </time>\n    </small>\n</div>\n\n");
		if (!repo.topics().isEmpty()) {
			jteOutput.writeContent("\n    <small style=\"display: block\">\n        Topics: ");
			jteOutput.setContext("small", null);
			jteOutput.writeUserContent(join(repo.topics()));
			jteOutput.writeContent("\n    </small>\n");
		}
		jteOutput.writeContent("\n\n<p>");
		jteOutput.setContext("p", null);
		jteOutput.writeUserContent(repo.description());
		jteOutput.writeContent("</p>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Repo repo = (Repo)params.get("repo");
		render(jteOutput, jteHtmlInterceptor, repo);
	}
}
