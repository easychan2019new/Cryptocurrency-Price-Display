<h1>Questionnaire:</h1>

*1. Are there any sub-optimal choices (or short cuts taken due to limited time) in your implementation?*<br><br>
 **No**

*2. Is any part of it over-designed?*<br><br>
  **No**

*3. If you have to scale your solution to 100 users/second traffic, what changes would you make, if any?*<br><br>
  **Create multiple instances of our “Price Service”, using Spring Cloud API gateway to perform load balance.**

*4. What are some other enhancements you would have made, if you had more time to do this implementation?*<br><br>
  **Create a new function call “Predict”. It will predict the Bitcoin price of different exchanges or platforms. When we do the recommendation, we can call this function and provide suggestion that when and where to buy or sell Bitcoin. To implement this, we can use the scikit-learn model, feed in original data collected from certain platforms, train and tune the model. Transform it to PMML format and integrate with Java platform.**
