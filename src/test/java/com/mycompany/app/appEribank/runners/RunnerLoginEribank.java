package com.mycompany.app.appEribank.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features = "src/test/resources/features/login"
,glue = "com.mycompany.app.appEribank.definitions"
,tags="@login"
,snippets = SnippetType.UNDERSCORE
)

public class RunnerLoginEribank {}
