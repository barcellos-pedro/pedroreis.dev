package gg.jte.generated.ondemand.repos;
import java.util.List;
import com.pedroreis.dev.model.Repo;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "repos/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,5,5,7,7,8,8,8,12,12,12,12,14,14,16,16,16,18,18,19,19,19,20,20,20,3,3,3,3};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, List<Repo> repos) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Projects", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Projects (");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(repos.size());
				jteOutput.writeContent(")</h1>\n\n    <a href=\"/\" title=\"Go back\">Go back</a>\n\n    ");
				boolean __jte_for_loop_entered_1 = false;
				for (var repo: repos) {
					__jte_for_loop_entered_1 = true;
					jteOutput.writeContent("\n        <section class='repo'>\n            ");
					gg.jte.generated.ondemand.repos.Jte_repoGenerated.render(jteOutput, jteHtmlInterceptor, repo);
					jteOutput.writeContent("\n        </section>\n    ");
				}
				if (!__jte_for_loop_entered_1) {
					jteOutput.writeContent("\n        <p>Projects are under maintenance</p>\n    ");
				}
				jteOutput.writeContent("\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		List<Repo> repos = (List<Repo>)params.get("repos");
		render(jteOutput, jteHtmlInterceptor, repos);
	}
}
