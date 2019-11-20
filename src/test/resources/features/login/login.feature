#Author: David Cardenas Guzman
@login
Feature: prueba de ingreso a la app

  @login_no_exitoso
  Scenario: login no exitoso
    Given Ingreso a la aplicacion
    When ingreso usuario "company1" y contrasena "company1"
    Then valido mensaje de error

  @make_payment
  Scenario Outline: validar boton make payment
    Given Ingreso a la aplicacion
    When ingreso usuario y contrasena <usuario> <contrasena>
    And seleccionar y llenar datos <phone> <name> <amount>
    Then valido estado boton

    Examples: 
      | usuario   | contrasena | phone        | name     | amount   |
      | "company" | "company"  | "3213333333" | "Carlos" | "150000" |
