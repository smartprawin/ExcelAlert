$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/Java/Window7/First/ExcelSample/src/test/resources/FeatureFile/AlertHandle.feature");
formatter.feature({
  "name": "Handle Alert",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Handle Alert using guru99",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Open guru99 website",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinition.open_guru_website(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the details needed",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinition.enter_the_details_needed()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.stepdefinition.stepDefinition.enter_the_details_needed(stepDefinition.java:33)\r\n\tat ✽.Enter the details needed(D:/Java/Window7/First/ExcelSample/src/test/resources/FeatureFile/AlertHandle.feature:4)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Handle Alert",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinition.handle_Alert()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "close the website",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinition.close_the_website()"
});
formatter.result({
  "status": "skipped"
});
});