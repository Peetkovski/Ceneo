package com.example.ceneo.service.scraping;

import com.example.ceneo.entity.Product;
import com.example.ceneo.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
@AllArgsConstructor
public class ScrappingProduct {


    private final static String PageName = "KONOPNY MARKET";
    private final ProductRepository productRepository;

    public void scrapDataFromSiteSuszCbd(String URL) throws IOException {
        Document document = Jsoup.connect(URL).get();
        Elements products = document.getElementsByClass("product");
        String linkUrl = "https://www.konopnymarket.pl/";
        for(Element element: products) {
            Product product = new Product();
            String dataCategory = element.attr("data-category");
            String producer = element.attr("data-producer");
            String productName = element.getElementsByClass("productname").get(0).text();
            String productPrice = element.getElementsByClass("price").get(0).getElementsByTag("em").text().replace("zł", "").replace(",", ".");
            String productPriceOriginal = element.getElementsByClass("price").get(0).getElementsByTag("del").text().replace("zł", "").replace(",", ".");
            String productLink = element.getElementsByTag("a").get(0).attr("href");
            String productImg = element.getElementsByTag("img").get(0).attr("src");
            double doubleProductPrice = Double.parseDouble(productPrice);
            if(productPriceOriginal.equals("")) {
                product.setProductPriceOriginal(0.0);
            } else {
                double doubleProductPriceOriginal = Double.parseDouble(productPriceOriginal);
                product.setProductPriceOriginal(doubleProductPriceOriginal);
            }
            product.setProductCategory(dataCategory);
            product.setProductProducer(producer);
            product.setProductName(productName);
            product.setProductPrice(doubleProductPrice);
            product.setLinkUrl(linkUrl + productLink);
            product.setImageUrl(productImg);
            product.setProductPage(PageName);
            productRepository.save(product);
        }
    }

}
