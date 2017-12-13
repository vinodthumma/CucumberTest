package Object_Repo;
import org.openqa.selenium.By;
import Object_Repo.Home_Page;
import org.openqa.selenium.WebDriver;
public class Registration_Objects {
	public static By Btn_Registration= By.id("registerNowButton_1");
    public static By Txt_FirstName = By.id("firstName");
    public static By Txt_LastName =By.id("lastName");
    public static By Lbl_FirstNameError_Container = By.id("firstName_errorContainerMessage");
    public static By Lbl_LastNameError_Container=By.id("lastName_errorContainerMessage");
    public static By Txt_emailAddress=By.id("emailAddress");
    public static By Lbl_emailAddressError_Container=By.id("emailAddress_errorContainerMessage");
    public static By Chk_marketing=By.name("mrktCheck");
    public static By Txt_RegisterPassword=By.id("registerPassword");
    public static By Lbl_PasswordError_Container=By.id("registerPassword_errorContainerMessage");
    public static By Txt_ConfirmPassword=By.id("confirmPassword");
    public static By Lbl_ConfirmPasswordError_Container=By.id("confirmPassword_errorContainerMessage");
    public static By Btn_Registration_Next_1=By.id("pg1NextButton_label");
    public static By Btn_Registration_Cancel_1=By.id("pg1CancelButton_label");
    public static By Lnk_Password_ShowHide=By.id("registerPassword_visibleText");
    public static By Lnk_ConfirmPassword_ShowHide=By.id("confirmPassword_visibleText");
    public static By Div_validatorPw=By.id("validatorPw");
   //CSS display none if user didn't click on help link
//    public static By icon_marketingHelp=By.id("offers_iconInfotipContainer");
//    public static By icon_marketingHelp=By.id("offers_iconInfotipContainer");
//    public static By icon_marketingHelp=By.id("offers_iconInfotipContainer");
    
}
