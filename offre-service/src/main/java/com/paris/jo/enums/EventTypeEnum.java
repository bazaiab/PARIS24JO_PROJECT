package com.paris.jo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum EventTypeEnum {
  FOOT_BALL("FOOT_BALL"),
  BASKET_BALL("BASKET_BALL"),
  RUGBY_7("RUGBY_7"),
  BADMINTON("BADMINTON"),
  BOXE("BOXE"),
  HAND_BALL("HAND_BALL"),
  TENNIS("TENNIS");

  @Getter private final String value;
}
