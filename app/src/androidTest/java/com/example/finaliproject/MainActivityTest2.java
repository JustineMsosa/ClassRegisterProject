package com.example.finaliproject;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.READ_EXTERNAL_STORAGE");

    @Test
    public void mainActivityTest2() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnAboutApp), withText("ABOUTS"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.buttonHome), withText("login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.ForgPassword), withText("Forgot Password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction materialTextView2 = onView(
                allOf(withId(R.id.Register1), withText("Register here"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialTextView2.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regName),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regName),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("Justine"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.pass1),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.confirm),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regCorfirm),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.pass1), withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("123456"));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.pass1), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());

        ViewInteraction checkableImageButton = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());

        ViewInteraction checkableImageButton2 = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton2.perform(click());

        pressBack();

        ViewInteraction textInputEditText7 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regPhone),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("888299361"), closeSoftKeyboard());

        ViewInteraction checkableImageButton3 = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Clear text"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton3.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regPhone),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("8882993"), closeSoftKeyboard());

        pressBack();

        ViewInteraction textInputEditText9 = onView(
                allOf(withText("8882993"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regPhone),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText9.perform(replaceText("888299361"));

        ViewInteraction textInputEditText10 = onView(
                allOf(withText("888299361"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regPhone),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText10.perform(closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.regButton), withText("SIGN UP"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText11 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.Name),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText11.perform(click());

        ViewInteraction textInputEditText12 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.Name),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText12.perform(replaceText("Jus"), closeSoftKeyboard());

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.pass),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction checkableImageButton4 = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton4.perform(click());

        pressBack();

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.button2), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText14 = onView(
                allOf(withText("Jus"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Name),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(replaceText("Justine"));

        ViewInteraction textInputEditText15 = onView(
                allOf(withText("Justine"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Name),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText15.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.button2), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.btnRegisterStudents), withText("Register Students"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.editName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.editName),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("Owen"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editAge),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("52"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editResidents),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("Chilek"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.student_number),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("656"), closeSoftKeyboard());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.male), withText("M"),
                        childAtPosition(
                                allOf(withId(R.id.radioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.editName), withText("Owen"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("Owen kunja"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.editName), withText("Owen kunja"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.btnChoose), withText("Change"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.btnAdd), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton7.perform(click());

        DataInteraction relativeLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gridView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(0);
        relativeLayout.perform(click());

        pressBack();

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                allOf(withId(R.id.activity_main2),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab3),
                        childAtPosition(
                                allOf(withId(R.id.activity_main2),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        pressBack();

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab2),
                        childAtPosition(
                                allOf(withId(R.id.activity_main2),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        pressBack();

        ViewInteraction floatingActionButton4 = onView(
                allOf(withId(R.id.fab1),
                        childAtPosition(
                                allOf(withId(R.id.activity_main2),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        floatingActionButton4.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnList), withText("View Registered Students"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton8.perform(click());

        DataInteraction appCompatTextView = onData(anything())
                .inAdapterView(allOf(withId(R.id.select_dialog_listview),
                        childAtPosition(
                                withId(R.id.contentPanel),
                                0)))
                .atPosition(1);
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton2.perform(scrollTo(), click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
