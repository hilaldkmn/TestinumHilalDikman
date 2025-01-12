Feature: CatchyLabs Actions Edit Account Modal

  Background:# Kullanıcı giriş yapar. Diğer senaryoların koşması için ayni zamanda bir precondition oluşturur.
    Given kullanıcı CatchyLabs giriş sayfasındadır
    And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
    And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
    When kullanıcı "loginButton" butonuna tıklar
    Then kullanıcının giriş yaptığı görülür
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcı "editAccountButton" butonuna tıklar

  @EditAccountButtonTestCaseFromAPI @all
  Scenario: Edit Account Buton tiklandiginda Edit Account Modal aciliyor mu
    And kullanıcının "editAccountText" elementinde "Edit account" metnini gördüğü doğrulanır

  @EditAccountNameTestCase @all
  Scenario: Kendi hesabina 20 dolar ekleme ve API'den gonderen kontrolu
    And kullanıcı "editAccountNameInput" alanına "hilal26" yazar
    And kullanıcı "editAccountUpdateButton" butonuna tıklar
    And kullanıcının "accountName" elementinde "hilal26" metnini gördüğü doğrulanır