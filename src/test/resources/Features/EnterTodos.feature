Feature: Enter Todos to the list

  Scenario Outline: Enter Single Todo Value to the List
    Given user visit the todo list
    When enter "<_value>" to the todo list
    Then todo list update with new value

    Examples:
    |_value     |
    |test todo1 |
    |test todo2 |

    Scenario: Enter Multiple Todo Values to the list
      Given user visit the todo list
      When enter todos to the list
      |todo1|
      |todo2|
      Then todo list update with new values
        |todo1|
        |todo2|

