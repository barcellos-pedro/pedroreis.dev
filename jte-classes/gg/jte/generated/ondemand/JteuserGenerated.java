package gg.jte.generated.ondemand;
@SuppressWarnings("unchecked")
public final class JteuserGenerated {
	public static final String JTE_NAME = "user.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,4,4,5,5,7,7,7,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,11,11,11,0,1,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String avatarUrl, String visits, String userName) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "User info", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1></h1>\n    <p>Total visits: ");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(visits);
				jteOutput.writeContent("</p>\n    <p>");
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(userName);
				jteOutput.writeContent("</p>\n    <img");
				var __jte_html_attribute_0 = avatarUrl;
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeContent(" src=\"");
					jteOutput.setContext("img", "src");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("img", null);
					jteOutput.writeContent("\"");
				}
				jteOutput.writeContent(" width=\"100\" alt=\"user profile image\">\n");
			}
		});
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String avatarUrl = (String)params.get("avatarUrl");
		String visits = (String)params.get("visits");
		String userName = (String)params.get("userName");
		render(jteOutput, jteHtmlInterceptor, avatarUrl, visits, userName);
	}
}
