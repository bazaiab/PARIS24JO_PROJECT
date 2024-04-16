package com.paris.jo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OfferTypeEnum {
  DUO("DUO"),
  SOLO("SOLO"),
  FAMILY("FAMILY");

  @Getter private final String value;
}
