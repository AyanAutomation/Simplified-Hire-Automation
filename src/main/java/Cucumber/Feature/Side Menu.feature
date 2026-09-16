@SideMenu
Feature: Simplified Hire side menu navigation

  @OpenSideMenuOption
  Scenario Outline: Open Simplified Hire side menu option <Menu_Menu_Option>
    Given open the Simplified Hire side menu option using the following feature data
      | Menu Option | <Menu_Menu_Option> |

    Examples:
      | Menu_Menu_Option |
      | Candidates |

  @ExpandSideMenu
  Scenario: Expand the Simplified Hire side menu
    Given expand the Simplified Hire side menu
