package steps;

import io.qameta.allure.Step;
import pages.CreateProjectModalPage;
import pages.ProjectPage;
import pages.ProjectsListPage;

public class ProjectsSteps extends BaseSteps {
    ProjectsListPage projectsListPage;
    CreateProjectModalPage createProjectModalPage;
    ProjectPage projectPage;

    public ProjectsSteps() {
        this.projectsListPage = new ProjectsListPage();
        this.createProjectModalPage = new CreateProjectModalPage();
        this.projectPage = new ProjectPage();
    }

    @Step
    public void createNewProject(String name, String description) {
        projectsListPage.openModalToCreateProject();
        createProjectModalPage.fillFormToCreateProject(name, description);
    }

    @Step
    public void deleteCreatedProjectAfterTest() {
        projectPage.openProjectsFromHeader();
        if(projectsListPage.isProjectVisible()){
            projectsListPage.deleteCreatedProject();
        }
    }
}
