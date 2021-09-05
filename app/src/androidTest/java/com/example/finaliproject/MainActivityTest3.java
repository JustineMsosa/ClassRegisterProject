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
public class MainActivityTest3 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.READ_EXTERNAL_STORAGE");

    @Test
    public void mainActivityTest3() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btnLogin), withText("LOGIN"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.Name),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.Name),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("Justine"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.pass),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction checkableImageButton = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());

        pressBack();

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button2), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.pass), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.pass), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("12345678"));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.pass), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());

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

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.pass), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.pass), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("1234567"));

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.pass), withText("1234567"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText9.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialTextView = onView(
                allOf(withId(R.id.ForgPassword), withText("Forgot Password"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        materialTextView.perform(click());

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.pass), withText("1234567"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText10.perform(click());

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.pass), withText("1234567"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText11.perform(replaceText("123456"));

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.pass), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText12.perform(closeSoftKeyboard());

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

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.pass), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(click());

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.pass), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(replaceText("12345678"));

        ViewInteraction textInputEditText15 = onView(
                allOf(withId(R.id.pass), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText15.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.button2), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction materialTextView2 = onView(
                allOf(withId(R.id.Register1), withText("Register here"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialTextView2.perform(click());

        ViewInteraction textInputEditText16 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regName),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText16.perform(click());

        ViewInteraction textInputEditText17 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regName),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText17.perform(replaceText("Justine"), closeSoftKeyboard());

        ViewInteraction textInputEditText18 = onView(
                allOf(withId(R.id.pass1),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regPassword),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText18.perform(replaceText("12345678"), closeSoftKeyboard());

        ViewInteraction textInputEditText19 = onView(
                allOf(withId(R.id.confirm),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regCorfirm),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText19.perform(replaceText("1234567"), closeSoftKeyboard());

        ViewInteraction checkableImageButton2 = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton2.perform(click());

        ViewInteraction textInputEditText20 = onView(
                allOf(withId(R.id.confirm), withText("1234567"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regCorfirm),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText20.perform(replaceText("12345678"));

        ViewInteraction textInputEditText21 = onView(
                allOf(withId(R.id.confirm), withText("12345678"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.regCorfirm),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText21.perform(closeSoftKeyboard());

        ViewInteraction checkableImageButton3 = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton3.perform(click());

        pressBack();

        ViewInteraction textInputEditText22 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.regPhone),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText22.perform(replaceText("5659968"), closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.regButton), withText("SIGN UP"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction textInputEditText23 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.Name),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText23.perform(click());

        ViewInteraction textInputEditText24 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.Name),
                                0),
                        0),
                        isDisplayed()));
        textInputEditText24.perform(replaceText("Justine"), closeSoftKeyboard());

        ViewInteraction textInputEditText25 = onView(
                allOf(withId(R.id.pass),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.Password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText25.perform(replaceText("12345678"), closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.button2), withText("Login"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.btnRegisterStudents), withText("Register Students"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton8.perform(click());

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
        appCompatEditText2.perform(replaceText("tiya"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.editAge),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("32"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.editResidents),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("Noma"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.student_number),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("5686"), closeSoftKeyboard());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.female), withText("F"),
                        childAtPosition(
                                allOf(withId(R.id.radioGroup),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                1),
                        isDisplayed()));
        materialRadioButton.perform(click());

        pressBack();

        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.btnChoose), withText("Change"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        materialButton9.perform(click());

        ViewInteraction materialButton10 = onView(
                allOf(withId(R.id.btnAdd), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton10.perform(click());

        DataInteraction appCompatTextView = onData(anything())
                .inAdapterView(allOf(withId(R.id.select_dialog_listview),
                        childAtPosition(
                                withId(R.id.contentPanel),
                                0)))
                .atPosition(2);
        appCompatTextView.perform(click());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.confirm), withText("confirm"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        DataInteraction relativeLayout = onData(anything())
                .inAdapterView(allOf(withId(R.id.gridView),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                0)))
                .atPosition(0);
        relativeLayout.perform(click());

        pressBack();
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
