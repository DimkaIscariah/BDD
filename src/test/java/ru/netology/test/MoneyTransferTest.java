package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;

class MoneyTransferTest {
    DashboardPage dashboardPage;

    @BeforeEach
    public void Authentication() {
        open("http://localhost:9999");
        var LoginPage = new LoginPageV2();
        var autoInfo = DataHelper.getAuthInfo();
        var verificationPage = LoginPage.validLogin(autoInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(autoInfo);
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Test
    void transferFromCardToCard() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 1000;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(1000,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);

    }

    @Test
    void transferFromCardToCard2() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 10000;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(10000,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }

    @Test
    void transferFromCardToCard3() {
        var firstCardNumber = getOneCardNumber();
        var twoCardNumber = getTwoCardNumber();
        var oneCardBalance = dashboardPage.getCardBalance(0);
        var twoCardBalance = dashboardPage.getCardBalance(1);
        var amount = 2500;
        var expectedBalanceOneCard = oneCardBalance - amount;
        var expectedBalanceTwoCard = twoCardBalance + amount;
        var transferPages = dashboardPage.selectCardToTransfer(twoCardNumber);
        dashboardPage = transferPages.setRefill(2500,getOneCardNumber());
        var actualBalanceOneCard = dashboardPage.getCardBalance(0);
        var actualBalanceTwoCard = dashboardPage.getCardBalance(1);
        assertEquals(expectedBalanceOneCard, actualBalanceOneCard);
        assertEquals(expectedBalanceTwoCard ,actualBalanceTwoCard);
    }
}