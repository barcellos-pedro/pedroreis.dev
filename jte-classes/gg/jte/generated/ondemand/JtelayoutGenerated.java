package gg.jte.generated.ondemand;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,12,12,12,14,14,15,15,15,16,16,21,21,21,24,24,24,0,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, gg.jte.Content content) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <link rel=\"stylesheet\" href=\"https://cdn.simplecss.org/simple.css\">\n    <link rel=\"stylesheet\" href=\"/style.css\">\n    <script src=\"/script.js\" defer></script>\n    <title>\n        ");
		if (title == null) {
			jteOutput.writeContent("\n            Pedro Barcellos | Portfolio\n        ");
		} else {
			jteOutput.writeContent("\n            ");
			jteOutput.setContext("title", null);
			jteOutput.writeUserContent(title);
			jteOutput.writeContent(" | Portfolio\n        ");
		}
		jteOutput.writeContent("\n    </title>\n</head>\n<body>\n<main>\n    ");
		jteOutput.setContext("main", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n</main>\n</body>\n</html>");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String title = (String)params.getOrDefault("title", null);
		gg.jte.Content content = (gg.jte.Content)params.get("content");
		render(jteOutput, jteHtmlInterceptor, title, content);
	}
}
