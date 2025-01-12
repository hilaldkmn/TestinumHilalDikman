Feature: CatchyLabs Actions Add Money Modal

  Background:# Kullanıcı giriş yapar. Diğer senaryoların koşması için ayni zamanda bir precondition oluşturur.
    Given kullanıcı CatchyLabs giriş sayfasındadır
    And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
    And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
    When kullanıcı "loginButton" butonuna tıklar
    Then kullanıcının giriş yaptığı görülür
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcı "addMoneyButton" butonuna tıklar

  @AddMoneyButtonTestCase @all
  Scenario: Add Money Buton tiklandiginda Add Money Modal aciliyor mu
    And kullanıcının "addMoneyText" elementinde "Add money" metnini gördüğü doğrulanır

  @AddMoneySenderInfoTestCase @all
  Scenario: Kendi hesabina 100 dolar ekleme ve arayuz gonderici kontrolu
    And kullanıcı "cardNumberInput" alanına "123412341234" yazar
    And kullanıcı "cardHolderInput" alanına "hilal2" yazar
    And kullanıcı "expiryDateInput" alanına "1026" yazar
    And kullanıcı "cVVInput" alanına "110" yazar
    And kullanıcı "amountInput" alanına "100" yazar
    And kullanıcı "addMoneyModalAddButton" butonuna tıklar
    And kullanıcının "accountSenderInfo" elementinde "hilal2" metnini gördüğü doğrulanır

  @AddMoneyReceiverInfoTestCase @all
  Scenario: Kendi hesabina 100 dolar ekleme ve arayuz alici kontrolu
    And kullanıcı "cardNumberInput" alanına "123412341234" yazar
    And kullanıcı "cardHolderInput" alanına "hilal2" yazar
    And kullanıcı "expiryDateInput" alanına "1026" yazar
    And kullanıcı "cVVInput" alanına "110" yazar
    And kullanıcı "amountInput" alanına "100" yazar
    And kullanıcı "addMoneyModalAddButton" butonuna tıklar
    And kullanıcının "ownAccountReceiverInfo" elementinde "hilal" metnini gördüğü doğrulanır

  @LastAddMoneyTestCase @all
  Scenario: Kendi hesabina 20 dolar ekleme ve arayuz gonderilen tutar kontrolu
    And kullanıcı "cardNumberInput" alanına "123412341234" yazar
    And kullanıcı "cardHolderInput" alanına "hilal2" yazar
    And kullanıcı "expiryDateInput" alanına "1026" yazar
    And kullanıcı "cVVInput" alanına "110" yazar
    And kullanıcı "amountInput" alanına "20" yazar
    And kullanıcı "addMoneyModalAddButton" butonuna tıklar
    And kullanıcının "lastSendAmountInfo" elementinde "20" metnini gördüğü doğrulanır
    And bir daha incele calismasi gerekli

  @CheckAmountAfterAmountReceiverTestCase @all
  Scenario: Kendi hesabina 200 dolar gonderme ve artan bakiye kontrolu
    And API balance değeri hafızaya alınır
    And kullanıcı "cardNumberInput" alanına "123412341234" yazar
    And kullanıcı "cardHolderInput" alanına "hilal2" yazar
    And kullanıcı "expiryDateInput" alanına "1026" yazar
    And kullanıcı "cVVInput" alanına "110" yazar
    And kullanıcı "amountInput" alanına "200" yazar
    And kullanıcı "addMoneyModalAddButton" butonuna tıklar
    And Kullanıcı "200" tutarını kendine gönderdiğinde kalan bakiye doğru hesaplanmalıdır

  @MissingCardNumberTestCase @all
  Scenario: Kendi hesabinin eksik kart numarasi girme
    And API balance değeri hafızaya alınır
    And kullanıcı "cardNumberInput" alanına "1234" yazar
    And kullanıcı "cardHolderInput" butonuna tıklar
    And kullanıcının "missingCardNumberAlert" elementinde "Too Short!" metnini gördüğü doğrulanır

  @ExtraNumberCardNumberTestCase @all
  Scenario: Kendi hesabinin fazla kart numarasi girme
    And API balance değeri hafızaya alınır
    And kullanıcı "cardNumberInput" alanına "12341234123412341234" yazar
    And kullanıcı "cardHolderInput" butonuna tıklar
    And kullanıcının "extraNumberCardNumberAlert" elementinde "Too Long!" metnini gördüğü doğrulanır

  @WrongDateTestCase @all
  Scenario: Kendi hesabinin eksik son kullanma tarihi girme
    And API balance değeri hafızaya alınır
    And kullanıcı "cardNumberInput" alanına "123412341234" yazar
    And kullanıcı "cardHolderInput" alanına "hilal2" yazar
    And kullanıcı "expiryDateInput" alanına "101" yazar
    And kullanıcı "cardHolderInput" butonuna tıklar
    And kullanıcının "wrongDateExpiryDateAlert" elementinde "Wrong date. Please give a correct date" metnini gördüğü doğrulanır

  @CheckAmountAfterAmountReceiverTestCase @all
  Scenario: Kendi hesabina 200 dolar gonderme ve artan bakiye kontrolu
    And API balance değeri hafızaya alınır
    And kullanıcı "cardNumberInput" alanına "123412341234" yazar
    And kullanıcı "cardHolderInput" alanına "hilal2" yazar
    And kullanıcı "expiryDateInput" alanına "1026" yazar
    And kullanıcı "cVVInput" alanına "110" yazar
    And kullanıcı "amountInput" alanına "asdasd" yazar
    And kullanıcı "cardHolderInput" butonuna tıklar
    And kullanıcının "wrongDateExpiryDateAlert" elementinde "" metnini gördüğü doğrulanır
    And bir daha incele calismasi gerekli