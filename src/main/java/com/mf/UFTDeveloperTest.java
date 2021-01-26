package com.mf;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.verifications.*;
import com.hp.lft.sdk.web.*;

import unittesting.*;

import java.time.Year;
import java.util.Date;

public class UFTDeveloperTest extends UnitTestClassBase {
Browser browser;
Browser browser2;
    public UFTDeveloperTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new UFTDeveloperTest();
        globalSetup(UFTDeveloperTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
        browser=BrowserFactory.launch(BrowserType.CHROME);
        browser.clearCache();
        browser.deleteCookies();
    }

    @After
    public void tearDown() throws Exception {

        browser.closeAllTabs();
        if (browser2.exists()){
            browser2.closeAllTabs();
        }

    }

    @Test
    public void test() throws GeneralLeanFtException {
        browser.navigate("http://nimbusserver.aos.com:8088");
        browser.sync();
        String ThisYear = Year.now().toString();

        Link SignOutLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText(new RegExpProperty("Sign Out.*")).build());
        WebElement MenuUserIconWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .id("menuUserIcon").build());
        Image StrategicPortfolioImage = browser.describe(Image.class, new ImageDescription.Builder()
                .href("http://nimbusserver.aos.com:8088/PFM.300.html")
                .type(com.hp.lft.sdk.web.ImageType.LINK).build());
        StrategicPortfolioImage.click();
        browser.sync();
        Area AndySteinImage = browser.describe(Area.class, new AreaDescription.Builder()
                .href(new RegExpProperty(".*astein.*")).build());
        AndySteinImage.click();
        browser.sync();
        Link SearchLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("SEARCH").build());
        SearchLink.click();
        Link RequestsLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Requests").build());
        RequestsLink.click();
        browser.sync();
        //PFM - Proposal
        EditField RequestTypeEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("REQUEST_TYPE_ID").build());
        RequestTypeEditField.setValue("PFM - Proposal");
        WebElement StatusWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("Status:").build());
        StatusWebElement.click();
        browser.sync();
        EditField StatusEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .title("Status").build());
        StatusEditField.setValue("Finance Review");
        WebElement TopSearchWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Search")
                .index(0).build());
        TopSearchWebElement.click();
        browser.sync();
        Link FirstResultLink = browser.describe(Table.class, new TableDescription.Builder()
                .id("searchResultTable")
                .tagName("TABLE").build())
                .describe(Link.class, new LinkDescription.Builder()
                        .tagName("A")
                        .index(0).build());
        FirstResultLink.click();
        browser.sync();
        Link FinancialSummaryLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText(new RegExpProperty("Proposal Name .*"))
                .index(1).build());
        FinancialSummaryLink.click();
        browser.sync();
        browser.sync();

        BrowserDescription browserDescription = new BrowserDescription();
        browserDescription.setOpenTitle("Financial Summary");
        browserDescription.setType(BrowserType.CHROME);
        browser2 = BrowserFactory.attach(browserDescription);

        Link AddCostsLink = browser2.describe(Link.class, new LinkDescription.Builder()
                .innerText("Add Costs ").build());
        AddCostsLink.click();
        browser2.sync();

        WebElement CopyDropDownwebElement = browser2.describe(WebElement.class, new WebElementDescription.Builder()
                .className("react-svg-icon copy-with-dropdown.svg").build());
        CopyDropDownwebElement.click();
        browser2.sync();
        WebElement CopyFromAnotherRequestWebElement = browser2.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("Copy from Another Request").build());
        CopyFromAnotherRequestWebElement.click();
        browser2.sync();
        Frame copyCostLinesFSSearchDialogIFFrame = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("copyCostLinesFSSearchDialogIF")
                .index(0).build());
        RadioGroup includedRadioGroup = copyCostLinesFSSearchDialogIFFrame.describe(RadioGroup.class, new RadioGroupDescription.Builder()
                .name("included")
                .tagName("INPUT").build());
        includedRadioGroup.select("Project");
        browser2.sync();
        //Web for One World
        EditField IncludeProjectEditField = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("copyCostLinesFSSearchDialogIF")
                .index(0).build())
                .describe(EditField.class, new EditFieldDescription.Builder()
                        .title("Include Project:").build());
        IncludeProjectEditField.setValue("Web for One World");
        browser2.sync();
        WebElement AddSpecificItemsWebElement = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("copyCostLinesFSSearchDialogIF")
                .index(0).build())
                .describe(WebElement.class, new WebElementDescription.Builder()
                        .innerText("Add Specific Items").build());
        AddSpecificItemsWebElement.click();
        browser2.sync();
        Button AddButton = browser2.describe(Button.class, new ButtonDescription.Builder()
                .name(new RegExpProperty(".*Add.*")).build());
        AddButton.click();
        browser2.sync();
        CheckBox CopyForecastCheckBox = browser2.describe(CheckBox.class, new CheckBoxDescription.Builder()
                .name("copyForecast")
                .type("checkbox").build());
        CopyForecastCheckBox.click();
        browser2.sync();
        Button CreateButton = browser2.describe(Button.class, new ButtonDescription.Builder()
                .name(new RegExpProperty(".*Copy.*")).build());
        CreateButton.click();
        browser2.sync();
        ListBox SelectListBox = browser2.describe(ListBox.class, new ListBoxDescription.Builder()
                .tagName("SELECT")
                .name("select").build());
        SelectListBox.select(ThisYear);
        browser2.sync();
        WebElement FirstEditwebElement = browser2.describe(WebElement.class, new WebElementDescription.Builder()
                .className("react-svg-icon edit.svg action-icon")
                .index(0).build());
        FirstEditwebElement.click();
        browser2.sync();
        ListBox CostTypeListBox = browser2.describe(Frame.class, new FrameDescription.Builder()
                .name("editCostLineDialogIF").build())
                .describe(ListBox.class, new ListBoxDescription.Builder()
                        .outerText("Labor Non-Labor").build());
        CostTypeListBox.select("Non-Labor");
        browser2.sync();
        CostTypeListBox.select("Labor");
        browser2.sync();
        //Consultant
        EditField CategoryEditField = browser2.describe(EditField.class, new EditFieldDescription.Builder()
                .title("Category").build());
        CategoryEditField.setValue("Consultant");
        browser2.sync();
        Button OKeditButton = browser2.describe(Button.class, new ButtonDescription.Builder()
                .name(new RegExpProperty(".*OK.*"))
                .role("button").build());
        OKeditButton.click();
        browser2.sync();
        Button SaveButton = browser2.describe(Button.class, new ButtonDescription.Builder()
                .name("Save")
                .buttonType("button").build());
        SaveButton.click();
        browser2.sync();

        /*Button DoneButton = browser2.describe(Button.class, new ButtonDescription.Builder()
                .name("Done")
                .buttonType("button").build());
        DoneButton.click();
        browser2.sync();
        Link DoneLink = browser2.describe(Link.class, new LinkDescription.Builder()
                .innerText("Done").build());
        DoneLink.click();
        browser2.sync();

         */
        browser2.closeAllTabs();
        browser.sync();
        Link ApprovedLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("Approved").build());
        ApprovedLink.click();
        browser.sync();
        WebElement StatusStandardsReviewWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .tagName("SPAN")
                .innerText("Status: Standards Review ").build());
        if (StatusStandardsReviewWebElement.exists()){
            try {
                Reporter.reportEvent("Final Status of Standards Review","The final status of Standards Review showed up correctly.", Status.Passed);
            } catch (ReportException e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                Reporter.reportEvent("Final Status of Standards Review","The final status of Standards Review did not show up correctly, Jason talk to Alan.", Status.Failed);
            } catch (ReportException e) {
                e.printStackTrace();
            }

        }
        MenuUserIconWebElement.click();
        SignOutLink.click();
        browser.sync();

    }

}