@Address
Feature: Address Module API automation

  Scenario Outline: Verify add new address to the application through api
    Given User add headers and bearer authentication for accessing address endpoints
    When User add request body for Add new address "<first_name>","<last_name>","<mobile>","<appartment>","<state>","<city>","<country>","<zipcode>", "<address>" and "<address_Type>"
    And User send "POST" request for AddUserAddress endpoint
    Then User verify the status code is 200
    And User verify the login response message matches "Address added sucessfully"

    Examples: 
      | first_name  | last_name | mobile     | appartment | state | city | country | zipcode | address      | address_type |
      | Neriyarasan | Lenin     | 9944847248 | L&T        |    34 |   34 |      45 |  600028 | Thuraipakkam | Home         |

  Scenario Outline: Verify  update address to the application through api
    Given User add headers and bearer authentication for accessing address endpoints
    When User add request body for  update address "<AddressId>","<first_name>","<last_name>","<mobile>","<appartment>","<state>","<city>","<country>","<zipcode>", "<address>" and "<address_Type>"
    And User send "PUT" request for AddUpdateAddress endpoint
    Then User verify the status code is 200
    And User verify the UpdateUserAddress response message matches "Address updated sucessfully"

    Examples: 
      | first_name  | last_name | mobile     | appartment | state | city | country | zipcode | address | address_type |
      | Neriyarasan | Lenin     | 9944847248 | L&T        |    34 |   34 |      45 |  600038 | chennai | Home         |

  Scenario: Verify  delete address to the application through api
    Given User add headers and bearer authentication for accessing address endpoints
    When User add request body for update address "<AddressId>"
    And User send "DELETE" request for AddUpdateAddress endpoint
    Then User verify the status code is 200
    And User verify the deleteUserAddress response message matches "Address deleted sucessfully"

  Scenario: Verify get all address to the application through api
    Given User add headers and bearer authentication for accessing address endpoints
    When User add request body for get address "<AddressId>"
    And User send "GET" request for AddUpdateAddress endpoint
    Then User verify the status code is 200
    And User verify the deleteUserAddress response message matches "OK"
