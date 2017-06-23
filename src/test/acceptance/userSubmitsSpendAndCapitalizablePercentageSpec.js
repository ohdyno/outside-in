var webdriver = require('selenium-webdriver');
var driver = new webdriver.Builder()
    .withCapabilities(webdriver.Capabilities.chrome())
    .build();

var chai = require('chai');
var expect = require('chai').expect;
var by = webdriver.By;

describe('Submitting a capitilizable percentage and a spend', function () {
    beforeEach(function () {
    });

    it('should allow the user to see the percentage applied to the spend so they know the capex amount', function (done) {
        driver.get('http://localhost:8080/calculator').then(
            function () {
                driver.findElement(by.css('input.spend')).then(function (element) {
                    element.sendKeys('50000');
                });
                driver.findElement(by.css('input.percentage')).then(function (element) {
                    element.sendKeys('84');
                });
                driver.findElement(by.css('form.capex input[type=submit]')).then(function (element) {
                    element.click();
                });
                driver.getCurrentUrl().then(function (url) {
                    expect(url).to.contain('/result?spend=50000&percentage=84');
                });
                driver.findElement(by.css('.capitalizable-amount')).then(function (element) {
                    element.getText().then(function (value) {
                        expect(value).to.equal("42000");
                        done();
                    });
                });
            })
            .then(function () {
                driver.close();
            })
            .then(function () {
                done();
            });
    });
});
