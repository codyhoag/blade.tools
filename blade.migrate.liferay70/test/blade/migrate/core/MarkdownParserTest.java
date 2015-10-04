package blade.migrate.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

public class MarkdownParserTest {

	@Test
	public void parseBreakingChanges() throws Exception {
		Map<String, String> tags = MarkdownParser.parse("BREAKING_CHANGES.markdown");

		assertNotNull(tags);
		assertEquals(68, tags.size());
	}
}
