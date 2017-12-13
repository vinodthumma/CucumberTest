package Object_Repo;
import org.openqa.selenium.By;
import Object_Repo.Home_Page;
import org.openqa.selenium.WebDriver;
public class Home_Page {


	    WebDriver driver;

	    public static By UserName = By.id("fullLoginEmail");
	    public static By password = By.id("fullLoginPassword");
	    public static By rememberMe =By.id("rememberMeCheckbox");
	    public static By login = By.id("loginSubmitDesktopButton_label");
	    public static By BenchmarkingPage=By.className("pageTitleText");
	    public static By WebUserLinkAccount=By.className("pageTitle");
	    public static By Lbl_UserName=By.id("desktopAccountLabel");
	    public static By btn_Logout=By.id("logoutButton");
	    public static By Title_Logout=By.className("pageTitleText");
	    public static By Lbl_LoginError=By.id("desktopLoginError");
	     
}
