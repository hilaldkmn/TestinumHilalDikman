$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Feature/Account.feature");
formatter.feature({
  "name": "CatchyLabs Actions Homepage",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı CatchyLabs giriş sayfasındadır",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.HomepageSteps.checkUserInHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı \"emailInput\" alanına \"[catchyLabUsername]\" yazar",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.HomepageSteps.enterTextToInput(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı \"passwordInput\" alanına \"[catchyLabPassword]\" yazar",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.HomepageSteps.enterTextToInput(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı \"loginButton\" butonuna tıklar",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.HomepageSteps.clickButtonOnPage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcının giriş yaptığı görülür",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.HomepageSteps.checkUserLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "CatchyLabs\u0027ten çıkış yapılması",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "kullanıcı \"logoutButton\" butonuna tıklar",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.HomepageSteps.clickButtonOnPage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcının çıkış yaptığı görülür",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.HomepageSteps.checkUserLoggedOut()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı CatchyLabs giriş sayfasındadır",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.HomepageSteps.checkUserInHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı \"emailInput\" alanına \"[catchyLabUsername]\" yazar",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.HomepageSteps.enterTextToInput(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı \"passwordInput\" alanına \"[catchyLabPassword]\" yazar",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.HomepageSteps.enterTextToInput(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcı \"loginButton\" butonuna tıklar",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.HomepageSteps.clickButtonOnPage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcının giriş yaptığı görülür",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.HomepageSteps.checkUserLoggedIn()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Kullanıcının gösterilen bakiyesinin API üzerinden kontrol edilmesi",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "kullanıcı \"openMoneyTransfer\" butonuna tıklar",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.HomepageSteps.clickButtonOnPage(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "kullanıcının \"balance\" değeri API\u0027den kontrol edilir",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.HomepageSteps.checkBalanceIsSameAsDatabase(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});