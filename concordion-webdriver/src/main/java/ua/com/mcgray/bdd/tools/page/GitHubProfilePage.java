package ua.com.mcgray.bdd.tools.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA. User: orezchykov Date: 10.10.12 Time: 18:37 To
 * change this template use File | Settings | File Templates.
 */
public class GitHubProfilePage extends Page {

	private WebElement repositories;
	private By repositoriesLocator = By.cssSelector("div.repo-tab ul.repolist.js-repo-list");

	// private By repositoriesLineLocator =
	// By.xpath("li[@class='public source']");

	private By repositoriesLineLocator = By.cssSelector("li.public.source");

	// private By repositoriesLocator =
	// By.xpath("//div[@class='repo-tab']/ul[@class='repolist js-repo-list']");

	public GitHubProfilePage(WebDriver webDriver) {
		super(webDriver);
	}

	@FindBy(xpath = "//div[@class='avatared']/h1/em")
	private WebElement profileName;

	// @FindBy(xpath =
	// "//ul[@class='tabnav-tabs']/li/a/span[@class='mini-icon mini-icon-public-repo']")
	@FindBy(css = "ul.tabnav-tabs li a span.mini-icon.mini-icon-public-repo")
	private WebElement repoTab;

	public boolean isOnProfilePage(String username) {
		return profileName.equals(username);
	}

	public List<String> repoList() {
		repoTab.click();
		List<String> result = new ArrayList<String>();
		repositories = new WebDriverWait(getWebDriver(), TIME_OUT_IN_SECONDS).until(ExpectedConditions.presenceOfElementLocated(repositoriesLocator));

		for (WebElement element : repositories.findElements(repositoriesLineLocator)) {
			result.add(element.findElement(By.tagName("h3")).findElement(By.tagName("a")).getText());
		}
		return result;
	}
}
