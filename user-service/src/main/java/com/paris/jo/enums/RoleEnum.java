package com.paris.jo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RoleEnum {
  ADMIN("ADMIN"),
  CLIENT("CLIENT"),
  VISITOR("VISITOR");

  @Getter private final String value;
}
