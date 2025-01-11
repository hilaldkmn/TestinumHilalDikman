Feature: CatchyLabs Actions Homepage

    Background:
      # Kullanıcı giriş yapar. Diğer senaryoların koşması için aynu zamanda bir precondition oluşturur.
      Given kullanıcı CatchyLabs giriş sayfasındadır
      And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
      And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
      When kullanıcı "loginButton" butonuna tıklar
      Then kullanıcının giriş yaptığı görülür

  @AccountTestCase @all
  Scenario: Kullanıcının gösterilen bakiyesinin API üzerinden kontrol edilmesi
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcının "balance" değeri API'den kontrol edilir

