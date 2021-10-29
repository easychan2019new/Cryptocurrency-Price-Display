# Cryptocurrency-Price-Display (Backend)
This project was built for Chainalysis Take Home Test.
<br><br>
[<h1>project demo</h1>](http://cryptocurrency-price-display.s3-website.us-east-2.amazonaws.com/)  
<br>
<h3>Function:</h3>

*1. Display the Bitcoin and Ethereum prices from two exchanges(Coinbase and Bitfinex).*


*2. Provide recommendations where to buy and where to sell.*

How to build:

• Front end:  Angular
==

Implemented dynamic web pages to display the Bitcoin and Ethereum prices.(The data comes from backend spring application)

• Back end:  Spring boot/ Java
==
Implemented "Price Service" to handle front-end requests. In the "price service" it will fetch the most recent cryptocurrency quotes from the exchange's public API. The "buying price" will refer to the "ask" (the lowest price the seller is willing to accept for the cryptocurrency), the "selling price" will refer to the "bid" (the highest price the buyer is willing to pay for the cryptocurrency), and the "last price" will refer to the most recent transaction price on the exchange." The "Price Service" will also provide recommendations for buying/selling cryptocurrencies based on the exchange's quotes.


Deploy: 

 •	Spring Application will be deployed on AWS Elastic Beanstalk
 
 •	Angular Application will be deployed on AWS S3 Buckets
 
 [<h2>***Questionnaire***</h2>](./Questionnaire.md)
 [<h2>***front-end code***</h2>](https://github.com/easychan2019new/Cryptocurrency-Price-Display-front-end)
 
