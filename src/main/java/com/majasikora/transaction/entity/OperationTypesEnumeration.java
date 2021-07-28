package com.majasikora.transaction.entity;

import static java.util.Arrays.asList;
import static java.util.Objects.isNull;


public enum OperationTypesEnumeration {
  IN_CASH(1),
  IN_INSTALLMENTS(2),
  WITHDRAW(3),
  PAYMENT(4);

  private Integer value;

  OperationTypesEnumeration(int value) {
	this.value = value;
}

public static OperationTypesEnumeration valueOf(final Integer value) throws Exception {
    if (isNull(value)) throw new Exception();

    // It seems that spotless plugin does not recognize Java SE12 Enhanced Switch
    // So I kept it in old fashion style.
    switch (value) {
      case 1:
        return IN_CASH;
      case 2:
        return IN_INSTALLMENTS;
      case 3:
        return WITHDRAW;
      case 4:
        return PAYMENT;
      default:
        throw new Exception();
    }
  }

  public boolean isNegative() {
    return asList(IN_CASH, IN_INSTALLMENTS, WITHDRAW).contains(this);
  }
}
