// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTransactionController TransactionController = new controllers.ReverseTransactionController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTransactionController TransactionController = new controllers.javascript.ReverseTransactionController(RoutesPrefix.byNamePrefix());
  }

}
