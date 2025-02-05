package Test;

import Utilities.DriverHelper;
import Main.DynamicControlPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlTest {

    DynamicControlPage dynamicControl = new DynamicControlPage();

    @Test
    public void CheckDynamicButtons() {

        DriverHelper.getDriver().get("http://localhost:7080/dynamic_controls");

        DriverHelper.getDriver().manage().window().maximize();

        dynamicControl.removeButton.click();

        Assert.assertTrue(dynamicControl.checkBoxButton.isDisplayed());

        WebDriverWait wait = new WebDriverWait(DriverHelper.getDriver(), 15);


        wait.until(ExpectedConditions.visibilityOf(dynamicControl.addButton));

        Assert.assertFalse(dynamicControl.checkBoxButton.isDisplayed());

        dynamicControl.addButton.click();

        WebDriverWait wait2 = new WebDriverWait(DriverHelper.getDriver(), 15);

        wait2.until(ExpectedConditions.visibilityOf(dynamicControl.removeButton));

        Assert.assertTrue(dynamicControl.checkBoxButton.isDisplayed());

        dynamicControl.enableButton.click();

        WebDriverWait wait3 = new WebDriverWait(DriverHelper.getDriver(),15);

        wait3.until(ExpectedConditions.visibilityOf(dynamicControl.disableButton));

        Assert.assertTrue(dynamicControl.enableText.isEnabled());

        dynamicControl.disableButton.click();

        WebDriverWait wait4 = new WebDriverWait(DriverHelper.getDriver(), 15);

        wait4.until(ExpectedConditions.visibilityOf(dynamicControl.enableButton));

        Assert.assertFalse(dynamicControl.enableText.isEnabled());

        DriverHelper.closeDriver();
    }

}
