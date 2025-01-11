Feature: CatchyLabs Actions Homepage

  @AuthTestCase @all
  Scenario: CatchyLabs'e giriş yapılması
    Given kullanıcı CatchyLabs giriş sayfasındadır
    And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
    And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
    When kullanıcı "loginButton" butonuna tıklar
    Then kullanıcının giriş yaptığı görülür

  @AuthTestCase @all
  Scenario: CatchyLabs'ten çıkış yapılması
    Given kullanıcı CatchyLabs giriş sayfasındadır
    And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
    And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
    When kullanıcı "loginButton" butonuna tıklar
    Then kullanıcının giriş yaptığı görülür
    And kullanıcı "logoutButton" butonuna tıklar
    Then kullanıcının çıkış yaptığı görülür