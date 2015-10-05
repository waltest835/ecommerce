# ecommerce
Walmart Assigment: end to end ecommerce

Test Problem: 
Automate an end to end user e-commerce transaction flow using any open source tool for mobile.walmart.com<http://mobile.walmart.com> with an existing customer on chrome or safari browser.

This java class performs the below:
1. Perform a search on home page from a pool of key words given below 
2. Identify an item from the result set that you can add to cart
3. Add the item to cart and then login using existing account which is set up with at least one shipping address
4. Validate that item added is present in the cart and is the only item in the cart
5. Select Ship to Home as shipping method for your order
6. Validate that you are on Payment details page
7. Go back to Cart Page, Remove the item from cart and validate cart is empty
8. Sign out from your account

Account Details: username:waltest835@gmail.com
Search item: tv

Reasoning behind Technical choices:
I used Java as the progamming language and Selenium Webdriver as the open source tool, as Selenium has good libraries and interfaces to automate a web application. It is used to create robust, browser-based regression automation suites and tests. Java supports Selenium calls very conveniently.

Trade Offs, What I would do differntly:
I created this project using FireFox browser
I would use a different strategy to slect an item to add to the cart using List <WebElement> to get a list of all items and select one from the list. My laptop is controlled by IT of the company I work for, so Java 1.8 cannot be installed to recognize List <WebElement>. 

Create another mechanism to wait for the page load to finish in between browser clicks, instead of introducing wait time.






