package com.ob.moneyhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ob.moneyhub.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class MoneyHubAccountsResponse {

  @JsonProperty("Data")
  private List<Account> data;

/*@JsonProperty("Links")
  private Links links;

  @JsonProperty("Meta")
  private Meta meta;*/
}