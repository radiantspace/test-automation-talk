What's in it?
=============
A simple Android project - Tasky Lite. It can only show tasks and add new
tasks, not mark them as completed or delete them.

How to start up?
================
Open Android Studio, and open the `EspressoExample` folder.

Select `HomeActivity.java`, and from the main menu choose `Run` -> `Record Espresso Test`. When
recording the test, add a new task and call it e.g. "Sleep".

To make sure that we're validating the creation of a new list item, add this line to the
generated test:

```
        onView(allOf(withId(R.id.listItemTask), withText("Sleep"))).check(matches(isDisplayed()));
```

The generated code is very bloated and can be squashed into

```
    @Test
    public void homeActivityTest() {
        onView(withId(R.id.AddButton)).perform(click());
        onView(withId(R.id.NameText)).perform(replaceText("Sleep"), closeSoftKeyboard());
        onView(withId(R.id.SaveButton)).perform(click());

        onView(allOf(withId(R.id.listItemTask), withText("Sleep"))).check(matches(isDisplayed()));
    }
```
