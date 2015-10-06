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
		"problem.title=Removed Asset Tag Properties",
		"problem.summary=The Asset Tag Properties have been removed. The service no longer exists and the Asset Tag Service API no longer has this parameter. " +
			"The behavior associated with tag properties in the Asset Publisher and XSL portlets has also been removed.",
		"problem.tickets=LPS-52588",
		"problem.section=#removed-asset-tag-properties"
	},
	service = FileMigrator.class
)
public class AssetTagProperties  extends JavaFileMigrator {

	@Override
	protected List<SearchResult> searchJavaFile(File file, JavaFileChecker javaFileChecker) {
		final List<SearchResult> searchResults = new ArrayList<>();

		// all imports from AssetTagPropertyLocalServiceUtil and
		// AssetTagPropertyServiceUtil
		SearchResult searchResult = javaFileChecker.findImport(
				"com.liferay.portlet.asset.service.AssetTagPropertyLocalServiceUtil");

		if (searchResult != null) {
			searchResults.add(searchResult);
		}

		searchResult = javaFileChecker.findImport(
				"com.liferay.portlet.asset.service.AssetTagPropertyServiceUtil");

		if (searchResult != null) {
			searchResults.add(searchResult);
		}

		// all calls on AssetTagPropertyLocalServiceUtil
		List<SearchResult> localInvocations = javaFileChecker
				.findMethodInvocations(null, "AssetTagPropertyLocalServiceUtil",
						"*", null);

		searchResults.addAll(localInvocations);

		// all calls on AssetTagPropertyServiceUtil
		List<SearchResult> serviceInvocations = javaFileChecker
				.findMethodInvocations(null, "AssetTagPropertyServiceUtil", "*",
						null);

		searchResults.addAll(serviceInvocations);

		// all calls on methods with String[] tagProperties parameter
		// AssetTagLocalServiceUtil java.lang.String[] tagProperties
		List<SearchResult> tagServiceLocalUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "AssetTagLocalServiceUtil",
						"addTag", new String[] { "long", "String", "String[]",
								"ServiceContext" });

		searchResults.addAll(tagServiceLocalUtilInvocations);

		tagServiceLocalUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "AssetTagLocalServiceUtil", "search",
				new String[] { "long", "String", "String[]", "int", "int" });

		searchResults.addAll(tagServiceLocalUtilInvocations);

		tagServiceLocalUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "AssetTagLocalServiceUtil", "search",
				new String[] { "long[]", "String", "String[]", "int", "int" });

		searchResults.addAll(tagServiceLocalUtilInvocations);

		tagServiceLocalUtilInvocations = javaFileChecker.findMethodInvocations(
				null, "AssetTagLocalServiceUtil", "updateTag",
				new String[] { "long", "long", "String", "String[]",
						"ServiceContext" });

		searchResults.addAll(tagServiceLocalUtilInvocations);

		// AssetTagServiceUtil java.lang.String[] tagProperties
		List<SearchResult> tagServiceUtilInvocations = javaFileChecker
				.findMethodInvocations(null, "AssetTagServiceUtil", "addTag",
						new String[] { "String", "String[]",
								"ServiceContext" });

		searchResults.addAll(tagServiceUtilInvocations);

		tagServiceUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"AssetTagServiceUtil", "getTags",
				new String[] { "long", "String", "String[]", "int", "int" });

		searchResults.addAll(tagServiceUtilInvocations);

		tagServiceUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"AssetTagServiceUtil", "getTags",
				new String[] { "long[]", "String", "String[]", "int", "int" });

		searchResults.addAll(tagServiceUtilInvocations);

		tagServiceUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"AssetTagServiceUtil", "getTagsCount",
				new String[] { "long", "String", "String[]" });

		searchResults.addAll(tagServiceUtilInvocations);

		tagServiceUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"AssetTagServiceUtil", "search",
				new String[] { "long", "String", "String[]", "int", "int" });

		searchResults.addAll(tagServiceUtilInvocations);

		tagServiceUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"AssetTagServiceUtil", "search",
				new String[] { "long[]", "String", "String[]", "int", "int" });

		searchResults.addAll(tagServiceUtilInvocations);

		tagServiceUtilInvocations = javaFileChecker.findMethodInvocations(null,
				"AssetTagServiceUtil", "updateTag", new String[] { "long",
						"String", "String[]", "ServiceContext" });

		searchResults.addAll(tagServiceUtilInvocations);

		return searchResults;
	}
}
