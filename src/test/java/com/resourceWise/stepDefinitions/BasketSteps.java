package com.resourceWise.stepDefinitions;

import com.resourceWise.webPages.SearchResultpage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BasketSteps {
    SearchResultpage searchResultpage=new SearchResultpage();

    @When("^I select any product$")
    public void i_select_any_product() throws Throwable {
      searchResultpage.selectAnyProduct();
    }

    @When("^I add the product to the basket$")
    public void i_add_the_product_to_the_basket() throws Throwable {

    }

    @Then("^the product should be in the basket$")
    public void the_product_should_be_in_the_basket() throws Throwable {

    }

}
