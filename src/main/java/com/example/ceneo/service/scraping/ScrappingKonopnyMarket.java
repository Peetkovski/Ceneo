package com.example.ceneo.service.scraping;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@AllArgsConstructor
public class ScrappingKonopnyMarket {


    private ScrappingProduct scrappingProduct;

    @PostConstruct
    public void ScrapMarketKonopny() throws IOException {
    scrappingProduct.scrapDataFromSiteSuszCbd("https://www.konopnymarket.pl/susz-cbd");
    scrappingProduct.scrapDataFromSiteSuszCbd("https://www.konopnymarket.pl/olej-cbd");
    scrappingProduct.scrapDataFromSiteSuszCbd("https://www.konopnymarket.pl/kosmetyki-konopne-cbd");
    scrappingProduct.scrapDataFromSiteSuszCbd("https://www.konopnymarket.pl/zywnosc-konopna");
    }

}
