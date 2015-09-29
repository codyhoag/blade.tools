package blade.migrate.api;

import java.io.File;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Migration {

	int DETAIL_LONG = 1 << 2;

	int DETAIL_SHORT = 1 << 1;

	public List<Problem> findProblems(File projectDir, ProgressMonitor monitor);

	public void reportProblems(List<Problem> problems, int detail, String format, Object... args);

}