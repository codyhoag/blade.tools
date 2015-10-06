
package blade.migrate.liferay70;

import blade.migrate.api.FileMigrator;
import blade.migrate.core.SearchResult;
import blade.migrate.core.XMLFileChecker;
import blade.migrate.core.XMLFileMigrator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"file.extensions=xml",
		"problem.title=copy-request-parameters init-param default value change",
		"problem.summary=The copy-request-parameters init parameter's default value is now set to true in all portlets that extend MVCPortlet.",
		"problem.tickets=LPS-54798",
		"problem.section=#changed-the-default-value-of-the-copy"
	},
	service = FileMigrator.class
)
public class MVCPortletInitParamsChangeXML extends XMLFileMigrator {

	@Override
	protected List<SearchResult> searchXMLFile(File file) {
		// check if it is portlet.xml file

		if (!"portlet.xml".equals(file.getName())) {
			return Collections.emptyList();
		}

		final XMLFileChecker xmlFileChecker = new XMLFileChecker(file);

		final List<SearchResult> results = new ArrayList<>();

		results.addAll(xmlFileChecker.findTag(
			"portlet-class", "com.liferay.util.bridges.mvc.MVCPortlet"));

		results.addAll(xmlFileChecker.findTag(
			"name", "copy-request-parameters"));

		return results;
	}

}
