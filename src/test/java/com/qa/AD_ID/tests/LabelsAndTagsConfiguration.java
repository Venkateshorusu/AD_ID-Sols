package com.qa.AD_ID.tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.qa.AD_ID.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC - 0001 : Configuring the Quote and Sent it to the EBS")
@Story("US - 01 : Configuring the labels And Tags  and sending it to the EBS")
public class LabelsAndTagsConfiguration extends BaseTest {

	@Description(" login to CPQ ")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 1)
	public void logintoCPQ() {

		loginpage.doLoginToCPQ(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Description("Login to Sales Cloud ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void LoginToSalesCloud() {

		salesCloudHomePage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"),
				prop.getProperty("url2"));

		
	}
	@Description("labels And Tags Configuration  ")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void labelsAndTagsConfiguration() {

		String backgroundColorofSentToEBS = salesCloudHomePage.oscQuoteCreation().addLineItem().modelConfiguration()
				.materialConfiguration().constructionConfiguration().validate().DemandConfiguration();

		Assert.assertEquals(backgroundColorofSentToEBS, "rgba(227, 31, 38, 1)");

	}
}
