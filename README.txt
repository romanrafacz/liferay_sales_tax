Sales Tax App for Liferay

The Problem : Basic sales tax is applicable at a rate of 10% on all goods, except books,
food, and medical products that are exempt. Import duty is an additional
sales tax applicable on all imported goods at a rate of 5%, with no
exemptions.

When I purchase items I receive a receipt which lists the name of all the
items and their price (including tax), finishing with the total cost of the
items, and the total amounts of sales taxes paid. The rounding rules for
sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax.


How to run - execute the jar file the directory of the liferay_sales_tax folder
java -jar /liferay_sales_tax/target/Liferay_sales_tax-0.0.1-SNAPSHOT.jar

Program will ask for input. 1, 2, 3, etc... based on package order.



