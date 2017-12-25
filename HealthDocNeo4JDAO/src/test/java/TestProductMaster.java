import com.ihm.customer.neo4j.service.ProductService;
import com.ihm.customer.neo4j.service.ProductServiceImpl;
import org.junit.Test;
import org.neo4j.ogm.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TestProductMaster {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);


     @Test
     public void testGetHCforProductsAsyncwithOutCallback(){

        ProductService productService = new ProductServiceImpl();

	   
        CompletableFuture<List<String>> productNamesList = productService.getAllProductsNames();
        if (productNamesList.isCompletedExceptionally() == true) {
           System.out.println("Exception received during execution of API productService::getAllProductsNames ");
        }
            
        productNamesList.thenAccept(new Consumer<List<String>>() {
           @Override
           public void accept(List<String> productNamesList) {
               System.out.println("Number of Results -> "+ productNamesList.size());
               //productNamesList.stream().forEach(productName -> System.out.println("Product Name -> " + productName));
           }
        });

        logThreadId();
        
	}

     	public void logThreadId() {
	   
	    
	    try {
		Thread.sleep(10000);
	    } catch (InterruptedException e) {			
		e.printStackTrace();
	    }
	   
	    System.out.println("Invocation complete. Main ThreadID -> " + Thread.currentThread());
	    
	}

    @Test
    public void testProductSuggest(){

        ProductService productService = new ProductServiceImpl();

        CompletableFuture<Result> suggestionListFuture = productService.suggestProduct("17OH");

        System.out.println(" Starting Suggestion Test");

        if ( suggestionListFuture.isCompletedExceptionally() == true ) {

            System.out.println("Suggestion Test Failed");

        }

        suggestionListFuture.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result result) {

                Iterable<Map<String,Object>> searchResult = result.queryResults();
                searchResult.forEach((mapEntry) -> {

                    logger.info("Product_Name"+mapEntry.get("prod_name")+"---"+mapEntry.get("prod_code"));

                });


            }
        });

        logThreadId();


    }


    @Test
    public void testGeoSpecificProductSuggest(){

        ProductService productService = new ProductServiceImpl();

        CompletableFuture<Result> suggestionListFuture = productService.suggestProduct("17","18.5514501","73.93478559999994");

        System.out.println(" Starting Geo Specific Suggestion Test");

        if ( suggestionListFuture.isCompletedExceptionally() == true ) {

            System.out.println("Geo Specific Suggestion Test Failed");

        }

        logThreadId();

        suggestionListFuture.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result result) {

                Iterable<Map<String,Object>> searchResult = result.queryResults();
                searchResult.forEach((mapEntry) -> {

                    logger.info("Product_Name"+mapEntry.get("prod_name")+"---"+mapEntry.get("prod_code"));

                    System.out.println("Product_Name"+mapEntry.get("prod_name")+"---"+mapEntry.get("prod_code"));

                });


            }
        });




    }

    @Test
    public void getProductTest(){

        ProductService productService = new ProductServiceImpl();

        CompletableFuture<Result> suggestionListFuture = productService.getProducts("pune","A0003");

        System.out.println(" Starting getProductTest ");

        if ( suggestionListFuture.isCompletedExceptionally() == true ) {

            System.out.println("getProductTest Failed");

        }

        logThreadId();

        suggestionListFuture.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result result) {

                Iterable<Map<String,Object>> searchResult = result.queryResults();
                searchResult.forEach((mapEntry) -> {

                    //logger.info("Product_Name"+mapEntry.get("prod_name")+"---"+mapEntry.get("prod_code"));

                    System.out.println("Product_Name"+mapEntry.get("seller_name")+"---"+mapEntry.get("product_name"));

                });


            }
        });



    }

    @Test
    public void getProductDetailsTest(){

        ProductService productService = new ProductServiceImpl();

        CompletableFuture<Result> suggestionListFuture = productService.getProductDetail("A0003");

        System.out.println(" Starting getProductDetailsTest ");

        if ( suggestionListFuture.isCompletedExceptionally() == true ) {

            System.out.println("getProductDetailsTest Failed");

        }

        logThreadId();

        suggestionListFuture.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result result) {

                Iterable<Map<String,Object>> searchResult = result.queryResults();
                searchResult.forEach((mapEntry) -> {

                    //logger.info("Product_Name"+mapEntry.get("prod_name")+"---"+mapEntry.get("prod_code"));

                    System.out.println("Product_Name"+mapEntry.get("product_code")+"---"+mapEntry.get("name"));

                });


            }
        });



    }
}