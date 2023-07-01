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

    }
}