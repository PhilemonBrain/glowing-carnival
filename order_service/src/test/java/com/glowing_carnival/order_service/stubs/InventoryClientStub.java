package com.glowing_carnival.order_service.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {
    public static void stubInventoryClientStub(String skuCode, Integer quantity){
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
            .willReturn(
                aResponse()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("true")));
    }
}
