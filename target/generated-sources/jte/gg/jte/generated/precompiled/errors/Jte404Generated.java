package gg.jte.generated.precompiled.errors;
@SuppressWarnings("unchecked")
public final class Jte404Generated {
	public static final String JTE_NAME = "errors/404.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,2,2,5,5,5,5,5,5,5,5};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor) {
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Page not found", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n    <h1>Page not found.</h1>\n    <a href=\"/\">&larr; Go back</a>\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		render(jteOutput, jteHtmlInterceptor);
	}
}
