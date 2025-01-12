Feature: CatchyLabs Actions Transfer Money Modal

  Background:# Kullanıcı giriş yapar. Diğer senaryoların koşması için ayni zamanda bir precondition oluşturur.
    Given kullanıcı CatchyLabs giriş sayfasındadır
    And kullanıcı "emailInput" alanına "[catchyLabUsername]" yazar
    And kullanıcı "passwordInput" alanına "[catchyLabPassword]" yazar
    When kullanıcı "loginButton" butonuna tıklar
    Then kullanıcının giriş yaptığı görülür
    When kullanıcı "openMoneyTransfer" butonuna tıklar
    And kullanıcı "transferMoneyButton" butonuna tıklar

  @TransferMoneyButtonTestCase @all
  Scenario: Transfer Money Buton tiklandiginda Transfer Money Modal aciliyor mu 
    And kullanıcının "transferMoneyText" elementinde "Transfer money" metnini gördüğü doğrulanır

  @SenderInfoHilalTestCase @all
  Scenario: Testinium-2 alici hesabina 1 dolar gonderme ve arayuz gonderici kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "1" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "accountSenderInfo" elementinde "hilal" metnini gördüğü doğrulanır

  @ReceiverAccountTestinium-2TestCase @all
  Scenario: Testinium-2 alici hesabina 1 dolar gonderme ve arayuz alici kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "1" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "accountReceiverInfo" elementinde "Testinium-2" metnini gördüğü doğrulanır

  @ReceiverAccountTestinium-5TestCase @all
  Scenario: Testinium-5 alici hesabina 1 dolar gonderme ve  arayuz alici kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-5Account" butonuna tıklar
    And kullanıcı "transferMoneyAmount" alanına "1" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "accountReceiverInfo" elementinde "Testinium-5" metnini gördüğü doğrulanır

  @ReceiverAccountTestinium-4TestCase @all
  Scenario: Testinium-4 alici hesabina 1 dolar gonderme ve  arayuz alici kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-4Account" butonuna tıklar
    And kullanıcı "transferMoneyAmount" alanına "1" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "accountReceiverInfo" elementinde "Testinium-4" metnini gördüğü doğrulanır

  @ReceiverAccountTestinium-3TestCase @all
  Scenario: Testinium-3 alici hesabina 1 dolar gonderme ve  arayuz alici kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-3Account" butonuna tıklar
    And kullanıcı "transferMoneyAmount" alanına "1" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "accountReceiverInfo" elementinde "Testinium-3" metnini gördüğü doğrulanır

  @ReceiverAccountTestinium-1TestCase @all
  Scenario: Testinium-1 alici hesabina 1 dolar gonderme ve  arayuz alici kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-1Account" butonuna tıklar
    And kullanıcı "transferMoneyAmount" alanına "1" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "accountReceiverInfo" elementinde "Testinium-1" metnini gördüğü doğrulanır

  @LastSendAmountTestCase @all
  Scenario: Testinium-2 alici hesabina 20 dolar gonderme ve arayuz gonderilen tutar kontrolu
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "20" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "lastSendAmountInfo" elementinde "20" metnini gördüğü doğrulanır

  @CheckAmountAfterAmountSentTestCase @all
  Scenario: Testinium-2 alici hesabina 200 dolar gonderme ve kalan bakiye kontrolu
    And API balance değeri hafızaya alınır
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "200" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And Kullanıcı "200" tutarını gönderdiğinde kalan bakiye doğru hesaplanmalıdır

  @LastSendAmountNegativeTestCase @all
  Scenario: Testinium-2 alici hesabina negatif tutar gonderilmemesi kontrolu
    And API balance değeri hafızaya alınır
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "-200" yazar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And "3" saniye beklenir
    And API balance değeri hafızadaki değer ile karşılaştırılır

  @SendMoreMoneyThanBalanceTestCase @all
  Scenario: Testinium-2 alici hesabina kalan bakiyeden daha fazla para gonderme
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "200000" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And Kullanıcı eğer bir alert görürse tamam butonuna basar, yoksa test başarısız olur

  @SendMoreNegativeMoneyThanBalanceTestCase @all
  Scenario: Testinium-2 alici hesabina kalan bakiyeden daha fazla negatif para gonderme
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "-300000" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And Kullanıcı eğer bir alert görürse tamam butonuna basar, yoksa test başarısız olur

  @dashAmountTestCase @all
  Scenario: Testinium-2 alici hesabina "-" gonderilmesi
    And kullanıcı "receiverAccountSelect" butonuna tıklar
    And kullanıcı "Testinium-2Account" butonuna tıklar
    And Açılan uyarı varsa Tamam butonuna basılır
    And kullanıcı "transferMoneyAmount" alanına "-" yazar
    And kullanıcı "transferMoneySendButton" butonuna tıklar
    And kullanıcının "internalError" elementinde "Internal Error Occurred!" metnini gördüğü doğrulanır