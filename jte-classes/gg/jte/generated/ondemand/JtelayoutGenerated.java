package gg.jte.generated.ondemand;
@SuppressWarnings("unchecked")
public final class JtelayoutGenerated {
	public static final String JTE_NAME = "layout.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,11,11,11,13,13,14,14,14,15,15,18,19,22,29,37,46,46,46,49,49,49,0,1,1,1,1};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String title, gg.jte.Content content) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <link rel=\"icon\" type=\"image/x-icon\" href=\"/images/favicon.ico\">\n\n    <title>\n        ");
		if (title == null) {
			jteOutput.writeContent("\n            pedroreis.dev\n        ");
		} else {
			jteOutput.writeContent("\n            ");
			jteOutput.setContext("title", null);
			jteOutput.writeUserContent(title);
			jteOutput.writeContent("\n        ");
		}
		jteOutput.writeContent("\n    </title>\n\n    ");
		jteOutput.writeContent("\n    ");
		jteOutput.writeContent("\n    <meta name=\"description\" content=\"Web App to show my main projects stats from GitHub API.\">\n\n    ");
		jteOutput.writeContent("\n    <meta property=\"og:type\" content=\"website\">\n    <meta property=\"og:url\" content=\"https://pedroreis.dev/\">\n    <meta property=\"og:title\" content=\"My GitHub Projects Stats\">\n    <meta property=\"og:description\" content=\"Web App to show my main projects stats from GitHub API.\">\n    <meta property=\"og:image\" content=\"https://pedroreis.dev/images/social-preview.jpg\">\n\n    ");
		jteOutput.writeContent("\n    <meta name=\"twitter:card\" content=\"summary_large_image\">\n    <meta property=\"twitter:domain\" content=\"pedroreis.dev\">\n    <meta name=\"twitter:title\" content=\"My GitHub Projects Stats\">\n    <meta property=\"twitter:url\" content=\"https://pedroreis.dev/\">\n    <meta name=\"twitter:description\" content=\"Web App to show my main projects stats from GitHub API.\">\n    <meta name=\"twitter:image\" content=\"https://pedroreis.dev/images/social-preview.jpg\">\n\n    ");
		jteOutput.writeContent("\n    <link rel=\"stylesheet\" href=\"/css/simple.css\">\n    <link rel=\"stylesheet\" href=\"/css/style.css\">\n\n    <script type=\"module\" src=\"/js/hotwired-turbo.js\" defer></script>\n    <script type=\"module\" src=\"/js/script.js\" defer></script>\n</head>\n<body>\n<main>\n    ");
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
