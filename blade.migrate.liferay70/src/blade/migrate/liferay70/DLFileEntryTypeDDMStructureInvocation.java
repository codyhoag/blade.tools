package blade.migrate.liferay70;

import blade.migrate.api.FileMigrator;
import blade.migrate.core.JavaFileChecker;
import blade.migrate.core.JavaFileMigrator;
import blade.migrate.core.SearchResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"file.extensions=java,jsp,jspf",
		"problem.title=DLFileEntryTypeLocalServiceUtil Api Changes",
		"problem.section=#removed-the-dlfileentrytypes",
		"problem.summary=Removed the DLFileEntryTypes_DDMStructures Mapping Table",
		"problem.tickets=LPS-56660",
	},
	service = FileMigrator.class
)
public class DLFileEntryTypeDDMStructureInvocation extends JavaFileMigrator {

	@Override
	protected List<SearchResult> searchJavaFile(
		File file, JavaFileChecker javaFileChecker) {

		final List<SearchResult> result = new ArrayList<SearchResult>();

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"addDDMStructureDLFileEntryType", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"addDDMStructureDLFileEntryTypes", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"clearDDMStructureDLFileEntryTypes", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"deleteDDMStructureDLFileEntryType", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"deleteDDMStructureDLFileEntryTypes", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"getDDMStructureDLFileEntryTypes", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"getDDMStructureDLFileEntryTypesCount", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"hasDDMStructureDLFileEntryType", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"hasDDMStructureDLFileEntryTypes", null));

		result.addAll(
			javaFileChecker.findMethodInvocations(
				null, "DLFileEntryTypeLocalServiceUtil",
				"setDDMStructureDLFileEntryTypes", null));

		return result;
	}

}
