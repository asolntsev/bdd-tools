package ua.com.mcgray.bdd.tools.pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * @author orezchykov
 * @since 01.03.13
 */

@Name("Search result menu")
@Block(@FindBy(xpath = "//ul[@class='menu']"))
public class MenuContainer extends HtmlElement {

	@Name("Search by user tab")
	@FindBy(xpath = "//li/a[text()=' Users']")
	private Link searchByUserLink;

	public void switch_to_user_search_list() {
		searchByUserLink.click();
	}

}
