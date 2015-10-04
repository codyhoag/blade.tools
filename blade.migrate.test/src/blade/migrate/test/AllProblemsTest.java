package blade.migrate.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import blade.migrate.api.Migration;
import blade.migrate.api.NullProgressMonitor;
import blade.migrate.api.Problem;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

public class AllProblemsTest {

	@Test
	public void allProblems() throws Exception {
		ServiceReference<Migration> sr = context
			.getServiceReference(Migration.class);
		Migration m = context.getService(sr);
		List<Problem> problems = m
				.findProblems(new File(
						"../blade.migrate.liferay70/projects/"), new NullProgressMonitor());

		final int expectedSize = 284;
		final int size = problems.size();

		if (size != expectedSize) {
			System.err.println("All problems size is " + size + ", expected size is " + expectedSize);
		}

		assertEquals(expectedSize, size);

		for (Problem problem : problems) {
			assertNotNull(problem.html);
			assertTrue("problem.title=" + problem.title + ", problem.file=" + problem.file, problem.html.length() > 0);
		}
	}

	private final BundleContext context = FrameworkUtil.getBundle(
		this.getClass()).getBundleContext();

}
