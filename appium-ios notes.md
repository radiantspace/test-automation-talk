What's in it?
=============
Very simple Appium test creating a new task.

How to start up?
================
You need to create an `.app` file from Tasky. When you've run Tasky on a simulator, you can copy the file
`bin/iPhoneSimulator/Debug/device-builds/iphone*/Tasky.app` to the root of the `appium-iOS-sample` directory.

Also, you need to `brew install carthage`, otherwise Appium won't be able to start the XCUITest agent.

Run the tests using `mvn test`.

Possible test:

```
    @Test
    public void canAddTask() throws Exception {
        driver.findElement(By.id("Add")).click();
        WebElement nameElement = driver.findElement(By.id("Name"));
        nameElement.click();
        nameElement.sendKeys("Sleep");
        driver.findElement(By.id("Save")).click();

        Assert.assertNotNull(driver.findElement(By.id("Add")));
        Assert.assertEquals("Sleep", driver.findElement(By.id("Sleep")).getAttribute("value"));
    }
```
