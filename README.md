What?
=====
Example code from my "Test Automation" talk. There's some Ruby unit test using RSpec, some Cucumber
unit testing, WebDriver test, and a bunch of mobile testing.

Before running the presentation
===============================
- Reset the Tasky repository.
- Reset this repository.
- Start up Android emulator.
- Start Sinatra server from browser example.

TODO
====
Espresso:
- Upload to App Center!
- "Unit testing" the "create new item" view.

XCUITest:
- Upload to App Center!
- Waiting for elements in a nice way?

Appium-Android:
- Upload to App Center!
- Weird ID we're using for looking up the list item. Perhaps use the class? (android.widget.CheckedTextView)

Ruby example
------------
Run tests: `bundle exec rspec`

Potential code:

```ruby
class Order
  def initialize
    @sum = 0
  end

  def sum
    @sum
  end

  def add_line(description, amount)
    @sum += amount
  end
end
```

Potential test:

```ruby
require 'order'

RSpec.describe Order do
  subject { Order.new }

  context 'newly created' do
    it 'is free' do
      expect(subject.sum).to eq(0)
    end
  end

  context 'with lines' do
    before do
      subject.add_line('Carpets', 42)
      subject.add_line('Cleaners', 15)
    end

    it 'knows the sum' do
      expect(subject.sum).to eq(57)
    end
  end
end
```

Run continuously in RubyMine by right-clicking the `specs` folder, selecting `Run` -> `All specs`, then
selecting the "Toggle auto-test" button just beneath the "play" button to the left.

JavaScript example
------------------
Just load the `index.html` file, reload to re-test. Try breaking the test.

Cucumber example
----------------
First run the tests, watch the really nice and helpful error message appear.

Potential steps:

```ruby
require 'order'

Given('I have an order') do
  @order = Order.new
end

Then('I need to pay {int} dollars') do |int|
  if @order.sum != int
    raise "Expected to pay #{int} dollars, was #{@order.sum}"
  end
end

Given('I add for {int} dollars {string}') do |amount, name|
  @order.add_line(name, amount)
end
```

Browser example
---------------
Install [ChromeDriver](http://chromedriver.storage.googleapis.com/index.html), make sure to put it in `PATH`.

Start server: `bundle exec ruby server.rb`

Run tests: `bundle exec rspec`

Potential test:

```ruby
  it 'can add new tasks' do
    fill_in 'name', with: 'Sleep'
    click_button 'Add'

    fill_in 'name', with: 'Wake up'
    click_button 'Add'

    expect(body).to include('Sleep')
    expect(body).to include('Wake up')
  end
```

In `spec_helper.rb`, try setting `Capybara.default_driver` to `:selenium_chrome_headless`.

Mobile testing
==============
We're primarily using the Tasky app from the [mobile-samples repository](https://github.com/xamarin/mobile-samples).
This is a Xamarin project. However, neither Espresso nor XCUITest has proper tooling for "non-native" projects, so
I had to re-build Tasky in Java for Android and Swift for iOS. (We're talking _very_ limited versions of the app
where you're only able to add to-do items!)

Xamarin.UITest iOS
------------------
First of all, add the Xamarin.TestCloud.Agent package to the TaskyiOS project, and add this to the `FinishedLaunching`
method of `AppDelegate`:

```
            Xamarin.Calabash.Start();
```

Build TaskyiOS.

In Visual Studio, right-click the solution and choose "New project". Select iOS -> Tests -> UI Test App. Update the Xamarin.UITest package.

In the Unit Test window, add a project reference to TaskyiOS.

Potential test:

```C#
        [Test]
        public void CanAddTask()
        {
            app.Tap(c => c.Marked("Add"));

            app.EnterText(c => c.Marked("Name"), "Sleep");
            app.Tap(c => c.Marked("Save"));

            app.WaitForElement(c => c.Marked("Add"));
            app.WaitForElement(c => c.Text("Sleep"));
        }
```

Xamarin.UITest Android
----------------------
In Visual Studio, right-click the solution and choose "New project". Select Android -> Tests -> UI Test App. Update the Xamarin.UITest package.

In the Unit Test window, add a project reference to TaskyAndroid.

Potential test:

```C#
        [Test]
        public void CanAddTask()
        {
            app.Tap(c => c.Marked("AddButton"));

            app.EnterText(c => c.Marked("NameText"), "Sleep");
            app.Tap(c => c.Marked("SaveButton"));

            app.WaitForElement(c => c.Marked("AddButton"));
            app.WaitForElement(c => c.Text("Sleep"));
        }
```

appium-android
--------------
You need to create an `.apk` with the Tasky app. From Visual Studio, select `Build` -> `Archive for Publishing`,
then right-click and select `Sign and Distribute`. Choose ad-hoc distribution. You may need to create a new certificate
for this process.

Store the `.apk` in the root of the `appium-android-example` folder, and call it `com.xamarin.samples.taskyandroid.apk`.

Then run `mvn test` to run the test.

Possible test:

```Java
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

appium-ios
----------
You need to create an `.app` file from Tasky. When you've run Tasky on a simulator, you can copy the file
`bin/iPhoneSimulator/Debug/device-builds/iphone*/Tasky.app` to the root of the `appium-iOS-sample` directory.

Also, you need to `brew install carthage`, otherwise Appium won't be able to start the XCUITest agent.

Run the tests using `mvn test`.

Possible test:

```Java
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

Espresso
--------
Open Android Studio, and open the `EspressoExample` folder.

Select `HomeActivity.java`, and from the main menu choose `Run` -> `Record Espresso Test`. When
recording the test, add a new task and call it e.g. "Sleep".

To make sure that we're validating the creation of a new list item, add this line to the
generated test:

```Java
        onView(allOf(withId(R.id.listItemTask), withText("Sleep"))).check(matches(isDisplayed()));
```

The generated code is very bloated and can be squashed into

```Java
    @Test
    public void homeActivityTest() {
        onView(withId(R.id.AddButton)).perform(click());
        onView(withId(R.id.NameText)).perform(replaceText("Sleep"), closeSoftKeyboard());
        onView(withId(R.id.SaveButton)).perform(click());

        onView(allOf(withId(R.id.listItemTask), withText("Sleep"))).check(matches(isDisplayed()));
    }
```

XCUITest
--------
Open Xcode, open the `xcuitestexample` project.

Open the `xcuitestexampleUITests.swift` file, go to the `testExample()` method, and click the
"record" button below the edit area.

The test ends up looking something like this:

```Swift
    func testExample() {
        let app = XCUIApplication()
        app.navigationBars["Tasky Lite"].buttons["Add"].tap()
        
        let textField = app.textFields["itemNameTextField"]
        textField.tap()
        textField.typeText("Sleep")
        app.buttons["Create"].tap()
    }
```

For it to verify that the new item is indeed created, you should add this to the test method:

```Swift
        XCTAssertTrue(app.staticTexts["Aflevere børn"].waitForExistence(timeout: 5))
        XCTAssertTrue(app.staticTexts["Sove"].waitForExistence(timeout: 5))
```
