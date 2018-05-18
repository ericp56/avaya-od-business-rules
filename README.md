# avaya-od-business-rules
A demonstration of keeping your business rules in Java


Before we dive in, here's a design style I like to use.  It *may* not help during the VUI design with the customer, but it definitely helps during debugging and testing.  Let's call it token-driven design.

For example, let's say we're designing the "Main Menu" in an application, after a caller has logged in.  The customer says if they have an account balance and their status flag is D or X, transfer them to the billing department; if their status is A or Z, skip the main menu and go right to the Sales menu; if their primary phone number is not set, transfer them to the general agent skill; otherwise, present the main menu options.

The VUI designer may put those rules verbatim into the design document, but it is more flexible if you program the app to handle tokens.  You can program a business rule to evaluate the caller information and return an "action" token, being one of BILLING, SALES, GENERAL or MAIN_MENU.

This becomes really useful when used in conjunction with JUnit unit tests.  Consider the following scenarios:

  * The customer needs to validate the Main Menu rules with another department, and they won't have them finalized until next month.  No problem; code your app and you can update your business rules later without impacting the application flow.
  * During UAT, the customer realizes that some accounts have primary phone numbers with all 0's or all 9's.  Those should follow the same logic as "no primary phone number, transfer."  Just update the business rule and add some unit tests.  If it works as expected, release a new build for your QA team.
  * One year later, the customer asks for a change.  If the account status is P, then a primary phone number is not required and the caller should be allowed to use the main menu.  Do you need to setup their apps in your lab environment so you can update the call flow and test the change?  No, just make a change to the Java rule and unit tests, and you can confidently deliver the new build to the customer for UAT. *OK, that's a little presumptious, but you know what I mean*
  * The customer says the billing system is being updated and the phone number field will no longer include dashes.  Will that break the Main Menu logic?  A quick unit test will provide the answer.

Check out com.nextivr.demo.br.MainMenuEval.  It implements the sample "main menu" logic mentioned above.  I added a separate source folder named "test" to keep it organized.  Also, to build my test, with focus in the MainMenuEval.java editor window, I hit ctrl-n for new, and selected JUnit test.  The Eclipse wizard created the test skeleton and also added the junit jar to the classpath.  If you are automating your build process, you can make junit testing a required task, and you can also exclude the "test" source path in the final build.

In the flow, look at the Java code for mainMenuEval.  That implements the business rule.  If you run the app, you'll see some nice logging that will help you debug what happened during the call.  It's also something you can use to build a test case if you discover a flaw, for example.

So Java business rules help.  It lets OD apps do what they are good at and lets Java do what it is good at.
