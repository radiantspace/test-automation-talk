What's in it?
=============
A simple iOS project - Tasky Lite. It can only show tasks and add new
tasks, not mark them as completed or delete them.

How to start up?
================
Open Xcode, open the `xcuitestexample` project.

Open the `xcuitestexampleUITests.swift` file, go to the `testExample()` method, and click the
"record" button below the edit area.

The test ends up looking something like this:

```
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

```

        waitForText(app: app, text: "Aflevere børn")
        waitForText(app: app, text: "Sleep")
```

...and create this new method:

```
    func waitForText(app: XCUIApplication, text: String) {
        let label = app.staticTexts[text]
        let exists = NSPredicate(format: "exists == 1")
        
        expectation(for: exists, evaluatedWith: label, handler: nil)
        waitForExpectations(timeout: 5, handler: nil)
    }
```

It doesn't seem like XCUITest has a nice, built-in way to wait for e.g. text.
