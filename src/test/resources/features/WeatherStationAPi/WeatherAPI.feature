@weather
Feature: Weather Station API
  As a  user
  I want to test weather station API


  @Regression
  Scenario Outline: Negative-01-Validate Negative response 401 when we submit invalid Api Key
    Given Add weather Payload "<external_id>" "<name>" "<latitude>" "<longitude>" "<altitude>"
    When User calls API with "Post" http request with Invalid api Key
    Then The API Should return 401 response

    Examples:
      |external_id |name                      |latitude|longitude|altitude|
      |DEMO_TEST001|Team Demo Test Station 001|33.33   |-122.43  |222     |

  Scenario Outline: Positive-01-Validate positive response 201 when we submit valid Api Key
    Given Add weather Payload "<external_id>" "<name>" "<latitude>" "<longitude>" "<altitude>"
    When User calls API with "Post" http request
    Then The API Should return 201 response

    Examples:
      |external_id |name                      |latitude|longitude|altitude|
      |DEMO_TEST001|Team Demo Test Station 001|33.33   |-122.43  |222     |
      |DEMO_TEST002|Team Demo Test Station 002|44.44   |-122.44  |111     |

  Scenario Outline: Validate positive response 200 when we submit get request with valid Api Key
    Given A valid get request for stations submitted
    Then The API Should return 200 response
    Then Response should contain "<external_id>" "<name>" "<latitude>" "<longitude>" "<altitude>"
Examples:
  |external_id |name                      |latitude|longitude|altitude|
  |DEMO_TEST001|Team Demo Test Station 001|33.33   |-122.43  |222     |
