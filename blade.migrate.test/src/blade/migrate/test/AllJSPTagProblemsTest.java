package blade.migrate.test;

import static org.junit.Assert.assertEquals;

import blade.migrate.api.Migration;
import blade.migrate.api.Problem;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class AllJSPTagProblemsTest {

	@Test
	public void allProblems() throws Exception {
		ServiceReference<Migration> sr = context
			.getServiceReference(Migration.class);
		Migration m = context.getService(sr);
		List<Problem> problems = m.findProblems(new File("jsptests/"));

		final int expectedSize = 52;
		final int size = problems.size();

		if (size != expectedSize) {
			System.err.println("All problems size is " + size + ", expected size is " + expectedSize);
		}

		assertEquals(expectedSize, size);
	}

	private final BundleContext context = FrameworkUtil.getBundle(
		this.getClass()).getBundleContext();

}
