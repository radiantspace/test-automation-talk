What's in it?
=============
Very simple Appium test creating a new task.

How to start up?
================
You need to create an `.apk` with the Tasky app. From Visual Studio, select `Build` -> `Archive for Publishing`,
then right-click and select `Sign and Distribute`. Choose ad-hoc distribution. You may need to create a new certificate
for this process.

Store the `.apk` in the root of the `appium-android-example` folder, and call it `com.xamarin.samples.taskyandroid.apk`.

Then run `mvn test` to run the test.

Possible test:

```
    @Test
    public void canAddTask() throws Exception {
        driver.findElement(By.id("AddButton")).click();
        WebElement nameElement = driver.findElement(By.id("NameText"));
        nameElement.click();
        nameElement.sendKeys("Sleep");
        driver.findElement(By.id("SaveButton")).click();

        Assert.assertNotNull(driver.findElement(By.id("AddButton")));
        Assert.assertEquals("Sleep", driver.findElement(By.id("android:id/text1")).getAttribute("text"));
    }
```