package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewCaseTest extends BaseTest {
    @Test
    public void createNewTestCaseTest() {
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(NAME_SUITE);
        testCaseSteps.createTestCase(NAME_CASE, DESCRIPTION_CASE, PRECONDITION_CASE, POSTCONDITION_CASE);
        Assert.assertTrue(projectPage.createdCasesIsVisibleOnPage(), "Created cases is not visible on page");
    }

    @Test
    public void validateDataOfCaseTest() {
        SoftAssertions softly = new SoftAssertions();
        loginSteps.login(USER, PASSWORD, LOGIN_URL);
        projectsSteps.createNewProject(PROJECT_NAME, PROJECT_DESCRIPTION);
        suiteSteps.createSuite(NAME_SUITE);
        testCaseSteps.createTestCase(NAME_CASE, DESCRIPTION_CASE, PRECONDITION_CASE, POSTCONDITION_CASE);
        projectPage.openCaseCard();
        softly.assertThat(casePage.getTitleFromCard()).isEqualTo(NAME_CASE);
        softly.assertThat(casePage.getDescriptionFromCard()).isEqualTo(DESCRIPTION_CASE);
        softly.assertThat(casePage.getPostconditionFromCard()).isEqualTo(POSTCONDITION_CASE);
        softly.assertThat(casePage.getPreconditionFromCard()).isEqualTo(PRECONDITION_CASE);
        softly.assertAll();
    }
}
