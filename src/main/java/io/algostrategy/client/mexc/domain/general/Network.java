package io.algostrategy.client.mexc.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Network information.
 */
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {

    @JsonProperty("coin")
    private String assetSymbol;

    @JsonProperty("Name")
    private String symbol;
    @JsonProperty("network")
    private String name;

    @JsonProperty("depositEnable")
    private Boolean depositEnabled;
    @JsonProperty("withdrawEnable")
    private Boolean withdrawEnabled;

    private Integer minConfirm;

    private Double withdrawFee;
    private Double withdrawMin;
    private Double withdrawMax;
    private Integer withdrawIntegerMultiple;

    private String depositDesc;
    private String depositTips;
    private String withdrawTips;

    private Boolean sameAddress;

    private String contract;
}
