package blade.migrate.api;

import java.io.File;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface FileMigrator {

	public List<Problem> analyze(File file);

}