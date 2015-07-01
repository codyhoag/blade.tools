
package blade.migrate.liferay70;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import blade.migrate.api.Problem;

public class SearchPermissionCheckerGetPermissionQueryDeclTest
{
	final File testFile = new File( "projects/filetests/SearchPermissionCheckerImpl.java" );
	SearchPermissionCheckerGetPermissionQueryDecl checker;

	@Before
	public void beforeTest()
	{
		assertTrue( testFile.exists() );
		checker = new SearchPermissionCheckerGetPermissionQueryDecl();
	}

    @Test
    public void searchPermissionCheckerTest() throws Exception
    {
        List<Problem> problems = checker.analyzeFile(testFile);

        assertNotNull( problems );
        assertEquals( 1, problems.size() );
    }

    @Test
    public void asearchPermissionCheckerTestTwice() throws Exception
    {
    	List<Problem> problems = checker.analyzeFile(testFile);
    	problems = checker.analyzeFile(testFile);

        assertNotNull( problems );
        assertEquals( 1, problems.size() );
    }
}