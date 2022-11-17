package com.example.ceneo.service.scraping;

import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class ScrappingKonopnySklep {
    private final static String shopName = "KONOPNY SKLEP";

    public void scrapPageKonopnySklep(String URL) throws IOException {
        Document document = Jsoup.connect(URL).get();
    }
}
