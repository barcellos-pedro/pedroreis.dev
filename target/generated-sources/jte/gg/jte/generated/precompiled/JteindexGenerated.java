package gg.jte.generated.precompiled;
@SuppressWarnings("unchecked")
public final class JteindexGenerated {
	public static final String JTE_NAME = "index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,0,0,0,0,2,2,2,2,4,4,4,5,5,5,6,6,6,0,0,0,0};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteindexGenerated.class, "JteindexGenerated.bin", 1,29,5,1);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String text) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "Github User Info", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(text);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
			}
		});
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String text = (String)params.get("text");
		render(jteOutput, jteHtmlInterceptor, text);
	}
}
