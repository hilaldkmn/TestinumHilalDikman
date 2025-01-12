Feature: CatchyLabs Actions Homepage

  Background:# Kullanıcı giriş yapar. Diğer senaryoların koşması için ayni zamanda bir precondition oluşturur.
    Given kullanıcı CatchyLabs giriş sayfasındadır
    And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
    And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
    When kullanıcı "loginButton" butonuna tıklar
    Then kullanıcının giriş yaptığı görülür

  @AccountAmountTestCase @all
  Scenario: Kullanıcının gösterilen bakiyesinin API üzerinden kontrol edilmesi
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcının arayuzdeki "accountAmount" değeri API'deki balance degeri ile teyit edilir

  @AccountNameTestCase @all
  Scenario: Kullanıcının gösterilen ismin API üzerinden kontrol edilmesi
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcının arayuzdeki "accountName" değeri API'deki bank_account_name degeri ile teyit edilir

  @AccountNameTestCase @all
  Scenario: Kullanıcının gösterilen type API üzerinden kontrol edilmesi
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcının arayuzdeki "accountType" değeri API'deki bank_account_type degeri ile teyit edilir

  @EditAccountButtonTestCase @all
  Scenario: Edit Account Buton tiklandiginda Edit Account Modal aciliyor mu
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcı "editAccountButton" butonuna tıklar
    And kullanıcının "editAccountText" elementinde "Edit account" metnini gördüğü doğrulanır