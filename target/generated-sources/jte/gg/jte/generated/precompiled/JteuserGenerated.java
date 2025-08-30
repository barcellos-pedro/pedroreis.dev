package gg.jte.generated.precompiled;
@SuppressWarnings("unchecked")
public final class JteuserGenerated {
	public static final String JTE_NAME = "user.jte";
	public static final int[] JTE_LINE_INFO = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,5,5,7,7,7,8,8,8,9,9,9,9,9,9,9,9,9,10,10,10,11,11,11,0,1,2,2,2,2};
	private static final gg.jte.runtime.BinaryContent BINARY_CONTENT = gg.jte.runtime.BinaryContent.load(JteuserGenerated.class, "JteuserGenerated.bin", 1,36,12,13,6,1,39,1);
	private static final byte[] TEXT_PART_BINARY_0 = BINARY_CONTENT.get(0);
	private static final byte[] TEXT_PART_BINARY_1 = BINARY_CONTENT.get(1);
	private static final byte[] TEXT_PART_BINARY_2 = BINARY_CONTENT.get(2);
	private static final byte[] TEXT_PART_BINARY_3 = BINARY_CONTENT.get(3);
	private static final byte[] TEXT_PART_BINARY_4 = BINARY_CONTENT.get(4);
	private static final byte[] TEXT_PART_BINARY_5 = BINARY_CONTENT.get(5);
	private static final byte[] TEXT_PART_BINARY_6 = BINARY_CONTENT.get(6);
	private static final byte[] TEXT_PART_BINARY_7 = BINARY_CONTENT.get(7);
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, String avatarUrl, String visits, String userName) {
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_0);
		gg.jte.generated.precompiled.JtelayoutGenerated.render(jteOutput, jteHtmlInterceptor, "User info", new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_1);
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(visits);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_2);
				jteOutput.setContext("p", null);
				jteOutput.writeUserContent(userName);
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_3);
				var __jte_html_attribute_0 = avatarUrl;
				if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_4);
					jteOutput.setContext("img", "src");
					jteOutput.writeUserContent(__jte_html_attribute_0);
					jteOutput.setContext("img", null);
					jteOutput.writeBinaryContent(TEXT_PART_BINARY_5);
				}
				jteOutput.writeBinaryContent(TEXT_PART_BINARY_6);
			}
		});
		jteOutput.writeBinaryContent(TEXT_PART_BINARY_7);
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		String avatarUrl = (String)params.get("avatarUrl");
		String visits = (String)params.get("visits");
		String userName = (String)params.get("userName");
		render(jteOutput, jteHtmlInterceptor, avatarUrl, visits, userName);
	}
}
